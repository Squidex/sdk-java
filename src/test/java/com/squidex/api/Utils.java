package com.squidex.api;

final class Utils {
    private static ClientProvider singleClient;

    private Utils() {
    }

    public static ClientProvider getClient() {
        if (singleClient != null) {
            return singleClient;
        }

        String appName = System.getenv("CONFIG__APP__NAME");
        String clientId = System.getenv("CONFIG__CLIENT_ID");
        String clientSecret = System.getenv("CONFIG__CLIENT_SECRET");
        String environment = System.getenv("CONFIG__SERVER__URL");

        if (appName == null) {
            appName = "integration-tests";
        }

        if (clientId == null) {
            clientId = "root";
        }

        if (clientSecret == null) {
            clientSecret = "xeLd6jFxqbXJrfmNLlO2j1apagGGGSyZJhFnIuHp4I0=";
        }

        if (environment == null) {
            environment = "https://localhost:5001";
        }

        SquidexClientBuilder builder = SquidexClient.builder()
                .trustAllCerts(true)
                .appName(appName)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .baseUrl(environment);

        singleClient = new ClientProvider(builder, builder.build());

        return singleClient;
    }
}

