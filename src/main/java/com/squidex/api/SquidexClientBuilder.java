package com.squidex.api;

import com.squidex.api.core.ApiClient;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public final class SquidexClientBuilder {
    private String baseUrl = "https://cloud.squidex.io";
    private String clientId;
    private String clientSecret;
    private String appName;
    private TokenStore tokenStore;
    private OkHttpClient httpClient;
    private boolean trustAllCerts;

    public SquidexClientBuilder baseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public SquidexClientBuilder clientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public String clientId() {
        return this.clientId;
    }

    public SquidexClientBuilder clientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
        return this;
    }

    public String clientSecret() {
        return this.clientSecret;
    }

    public SquidexClientBuilder tokenStore(TokenStore tokenStore) {
        this.tokenStore = tokenStore;
        return this;
    }

    public TokenStore tokenStore() {
        return this.tokenStore;
    }

    public SquidexClientBuilder httpClient(OkHttpClient httpClient) {
        this.httpClient = httpClient;
        return this;
    }

    public OkHttpClient httpClient() {
        return this.httpClient;
    }

    public SquidexClientBuilder appName(String appName) {
        this.appName = appName;
        return this;
    }

    public String appName() {
        return this.appName;
    }

    public SquidexClientBuilder trustAllCerts(Boolean trustAllCerts) {
        this.trustAllCerts = trustAllCerts;
        return this;
    }

    public boolean trustAllCerts() {
        return this.trustAllCerts;
    }

    public SquidexClient build() {
        if (this.tokenStore == null) {
            this.tokenStore = new InMemoryTokenStore();
        }

        if (this.httpClient == null) {
            this.httpClient = new OkHttpClient();
        }

        if (this.trustAllCerts) {
            X509TrustManager trustAllCerts = new X509TrustManager() {
                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                }

                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return new java.security.cert.X509Certificate[]{};
                }
            };

            try {
                SSLContext sslContext = SSLContext.getInstance("SSL");
                sslContext.init(null, new TrustManager[]{trustAllCerts}, new java.security.SecureRandom());

                this.httpClient = this.httpClient.newBuilder()
                    .sslSocketFactory(sslContext.getSocketFactory(), trustAllCerts)
                    .build();
            } catch (NoSuchAlgorithmException | KeyManagementException e) {
                throw new RuntimeException(e);
            }
        }

        AuthInterceptor interceptor = new AuthInterceptor(
            this.httpClient,
            this.baseUrl,
            this.clientId,
            this.clientSecret,
            this.tokenStore);

        this.httpClient = this.httpClient.newBuilder()
            .addInterceptor(interceptor)
            .addInterceptor(new Interceptor() {
                @NotNull
                @Override
                public Response intercept(@NotNull Chain chain) throws IOException {
                    Request originalRequest = chain.request();

                    Request newRequest =
                        originalRequest.newBuilder()
                            .url(originalRequest.url().url().toString().replace("$app$", appName))
                            .build();

                    return chain.proceed(newRequest);
                }
            })
            .build();

        ApiClient apiClient = new ApiClient(this.httpClient);
        apiClient.setBasePath(this.baseUrl);
        apiClient.setVerifyingSsl(!this.trustAllCerts);

        return new SquidexClient(apiClient, this.appName, this.clientId, this.clientSecret, this.baseUrl);
    }
}
