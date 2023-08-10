package com.squidex.api;

import com.squidex.api.core.ClientOptions;
import com.squidex.api.core.Environment;

public final class SquidexApiClientBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private Environment environment = Environment.DEFAULT;

    public SquidexApiClientBuilder credentials(String clientId, String clientSecret) {
        this.clientOptionsBuilder.addHeader("Authorization", new TokenSupplier(clientId, clientSecret));
        return this;
    }

    public SquidexApiClientBuilder environment(Environment environment) {
        this.environment = environment;
        return this;
    }

    public SquidexApiClientBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    public SquidexApiClientBuilder appName(String appName) {
        clientOptionsBuilder.appName(appName);
        return this;
    }

    public SquidexApiClient build() {
        clientOptionsBuilder.environment(this.environment);
        return new SquidexApiClient(clientOptionsBuilder.build());
    }
}
