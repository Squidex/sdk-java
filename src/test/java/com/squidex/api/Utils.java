package com.squidex.api;

final class Utils {
    private static ClientProvider singleClient;

    private Utils() {
    }

    public static ClientProvider getClient() {
        if (singleClient != null) {
            return singleClient;
        }

        String appName = getEnvOrDefault("CONFIG__APP__NAME", "integration-tests");
        String clientId = getEnvOrDefault("CONFIG__CLIENT_ID", "root");
        String clientSecret = getEnvOrDefault("CONFIG__CLIENT_SECRET", "xeLd6jFxqbXJrfmNLlO2j1apagGGGSyZJhFnIuHp4I0=");
        String url = getEnvOrDefault("CONFIG__SERVER__URL", "https://localhost:5001");

        SquidexClientBuilder builder = SquidexClient.builder()
                .trustAllCerts(true)
                .appName(appName)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .url(url);

        singleClient = new ClientProvider(builder, builder.build());

        return singleClient;
    }

    private static String getEnvOrDefault(String key, String defaultValue) {
        String result = System.getenv(key);
        if (result == null || result.isEmpty()) {
            result = defaultValue;
        }

        return result;
    }
}

