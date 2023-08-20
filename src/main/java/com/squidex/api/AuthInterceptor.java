package com.squidex.api;

import com.squidex.api.core.Environment;
import com.squidex.api.core.ObjectMappers;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.time.Instant;
import java.util.Objects;

public final class AuthInterceptor implements Interceptor {
    private final Environment environment;
    private final String clientId;
    private final String clientSecret;
    private final TokenStore tokenStore;
    private final OkHttpClient httpClient;

    public AuthInterceptor(OkHttpClient httpClient, Environment environment, String clientId, String clientSecret, TokenStore tokenStore) {
        this.httpClient = httpClient;
        this.environment = environment;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.tokenStore = tokenStore;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request originalRequest = chain.request();

        AccessToken token = this.tokenStore.get();
        if (token != null && token.getExpiresAt().isBefore(Instant.now())) {
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

        HttpUrl tokenUrl = Objects.requireNonNull(HttpUrl.parse(this.environment.getUrl()))
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
            token = ObjectMappers.JSON_MAPPER.readValue(response.body().string(), AccessToken.class);
        }

        return token;
    }
}