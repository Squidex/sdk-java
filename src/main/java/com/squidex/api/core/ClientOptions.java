package com.squidex.api.core;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import okhttp3.OkHttpClient;

public final class ClientOptions {
    private final Environment environment;

    private final Map<String, String> headers;

    private final Map<String, Supplier<String>> headerSuppliers;

    private final OkHttpClient httpClient;

    private String appName;

    private ClientOptions(
            Environment environment,
            Map<String, String> headers,
            Map<String, Supplier<String>> headerSuppliers,
            OkHttpClient httpClient,
            String appName) {
        this.environment = environment;
        this.headers = new HashMap<>();
        this.headers.putAll(headers);
        this.headers.putAll(Map.of(
                "X-Fern-SDK-Name",
                "com.squidex.fern:api-sdk",
                "X-Fern-SDK-Version",
                "0.0.7",
                "X-Fern-Language",
                "JAVA"));
        this.headerSuppliers = headerSuppliers;
        this.httpClient = httpClient;
        this.appName = appName;
    }

    public Environment environment() {
        return this.environment;
    }

    public Map<String, String> headers(RequestOptions requestOptions) {
        Map<String, String> values = new HashMap<>(this.headers);
        headerSuppliers.forEach((key, supplier) -> {
            values.put(key, supplier.get());
        });
        if (requestOptions != null) {
            values.putAll(requestOptions.getHeaders());
        }
        return values;
    }

    public OkHttpClient httpClient() {
        return this.httpClient;
    }

    public String appName() {
        return this.appName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Environment environment;

        private OkHttpClient httpClient;

        private final Map<String, String> headers = new HashMap<>();

        private final Map<String, Supplier<String>> headerSuppliers = new HashMap<>();

        private String appName;

        public Builder environment(Environment environment) {
            this.environment = environment;
            return this;
        }

        public Builder addHeader(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        public Builder addHeader(String key, Supplier<String> value) {
            this.headerSuppliers.put(key, value);
            return this;
        }

        public Builder appName(String appName) {
            this.appName = appName;
            return this;
        }

        public Builder httpClient(OkHttpClient httpClient) {
            this.httpClient = httpClient;
            return this;
        }

        public ClientOptions build() {
            if (this.httpClient == null) {
                this.httpClient = new OkHttpClient();
            }

            return new ClientOptions(environment, headers, headerSuppliers, this.httpClient, this.appName);
        }
    }
}
