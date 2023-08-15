package com.squidex.api;

public final class ClientProvider {
    private final SquidexApiClientBuilder builder;
    private final SquidexApiClient client;

    public ClientProvider(SquidexApiClientBuilder builder, SquidexApiClient client) {
        this.builder = builder;
        this.client = client;
    }

    public SquidexApiClient client(String appName) {
        return this.builder.appName(appName).build();
    }

    public SquidexApiClient client() {
        return client;
    }

    public SquidexApiClientBuilder builder() {
        return builder;
    }
}
