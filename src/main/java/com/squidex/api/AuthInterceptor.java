package com.squidex.api;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.time.Instant;
import java.util.Objects;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class AuthInterceptor implements Interceptor {
    private final Gson gson = new Gson();
    private final String baseUrl;
    private final String clientId;
    private final String clientSecret;
    private final TokenStore tokenStore;
    private final OkHttpClient httpClient;

    public AuthInterceptor(OkHttpClient httpClient, String baseUrl, String clientId, String clientSecret, TokenStore tokenStore) {
        this.httpClient = httpClient;
        this.baseUrl = baseUrl;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.tokenStore = tokenStore;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request originalRequest = chain.request();

        AccessToken token = this.tokenStore.get();
        if (token != null && token.isExpired()) {
            // The token has been expired, therefore also remove it from the store for other calls.
            token = null;
            this.tokenStore.clear();
        }

        if (token == null) {
            token = acquireToken();
            this.tokenStore.set(token);
        }

        Request requestWithHeader = originalRequest.newBuilder()
            .header("Authorization", String.format("Bearer %s", token.getAccessToken()))
            .build();

        Response response = chain.proceed(requestWithHeader);
        if (response.code() == 401) {
            response.close();
            this.tokenStore.clear();

            return intercept(chain);
        }

        return response;
    }

    private AccessToken acquireToken() throws IOException {
        RequestBody formBody = new FormBody.Builder()
            .add("grant_type", "client_credentials")
            .add("client_id", this.clientId)
            .add("client_secret", this.clientSecret)
            .add("scope", "squidex-api")
            .build();

        HttpUrl tokenUrl = Objects.requireNonNull(HttpUrl.parse(baseUrl))
            .newBuilder()
            .addPathSegments("identity-server/connect/token")
            .build();

        Request tokenRequest = new Request.Builder()
            .url(tokenUrl.url())
            .post(formBody)
            .build();

        AccessToken token;
        try (Response response = this.httpClient.newCall(tokenRequest).execute()) {
            assert response.body() != null;
            token = gson.fromJson(response.body().string(), AccessTokenResponse.class).toToken();
        }

        return token;
    }
}