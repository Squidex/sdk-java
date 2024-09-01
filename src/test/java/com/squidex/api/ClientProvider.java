package com.squidex.api;

@SuppressWarnings("ClassCanBeRecord")
public final class ClientProvider {
    private final SquidexClientBuilder builder;
    private final SquidexClient client;

    public ClientProvider(SquidexClientBuilder builder, SquidexClient client) {
        this.builder = builder;
        this.client = client;
    }

    public SquidexClient client() {
        return client;
    }

    public SquidexClient client(String appName) {
        return this.builder.appName(appName).build();
    }

    public SquidexClientBuilder builder() {
        return builder;
    }
}
