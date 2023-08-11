package com.squidex.api;

import com.squidex.api.core.ClientOptions;
import com.squidex.api.core.Environment;
import okhttp3.OkHttpClient;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public final class SquidexApiClientBuilder {
    private final ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private Environment environment = Environment.DEFAULT;
    private String clientId;
    private String clientSecret;
    private TokenStore tokenStore;
    private OkHttpClient httpClient;
    private boolean trustAllCerts;

    public SquidexApiClientBuilder environment(Environment environment) {
        this.environment = environment;
        return this;
    }

    public SquidexApiClientBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    public SquidexApiClientBuilder clientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public String clientId() {
        return this.clientId;
    }

    public SquidexApiClientBuilder clientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
        return this;
    }

    public String clientSecret() {
        return this.clientSecret;
    }

    public SquidexApiClientBuilder tokenStore(TokenStore tokenStore) {
        this.tokenStore = tokenStore;
        return this;
    }

    public SquidexApiClientBuilder httpClient(OkHttpClient httpClient) {
        this.httpClient = httpClient;
        return this;
    }

    public SquidexApiClientBuilder appName(String appName) {
        this.clientOptionsBuilder.appName(appName);
        return this;
    }

    public SquidexApiClientBuilder trustAllCerts() {
        this.trustAllCerts = true;
        return this;
    }

    public SquidexApiClient build() {
        clientOptionsBuilder.environment(this.environment);

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
                    return new java.security.cert.X509Certificate[] {};
                }
            };

            try {
                SSLContext sslContext = SSLContext.getInstance("SSL");
                sslContext.init(null, new TrustManager[] { trustAllCerts }, new java.security.SecureRandom());

                this.httpClient = this.httpClient.newBuilder()
                        .sslSocketFactory(sslContext.getSocketFactory(), trustAllCerts)
                        .build();
            } catch (NoSuchAlgorithmException | KeyManagementException e) {
                throw new RuntimeException(e);
            }
        }

        AuthInterceptor interceptor = new AuthInterceptor(
                this.httpClient,
                this.environment,
                this.clientId,
                this.clientSecret,
                this.tokenStore);

        this.httpClient = this.httpClient.newBuilder()
                .addInterceptor(interceptor)
                .build();

        clientOptionsBuilder.httpClient(this.httpClient);

        return new SquidexApiClient(clientOptionsBuilder.build());
    }
}
