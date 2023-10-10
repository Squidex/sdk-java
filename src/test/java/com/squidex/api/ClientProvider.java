package com.squidex.api;

public final class ClientProvider {
    private final SquidexClientBuilder builder;
    private final SquidexClient client;

    public ClientProvider(SquidexClientBuilder builder, SquidexClient client) {
        this.builder = builder;
        this.client = client;
    }

    public SquidexClient client(String appName) {
        return this.builder.appName(appName).build();
    }

    public SquidexClient client() {
        return client;
    }

    public SquidexClientBuilder builder() {
        return builder;
    }
}
