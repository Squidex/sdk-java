package com.squidex.api;

import java.util.function.Supplier;

public final class TokenSupplier implements Supplier<String> {

    private final String clientId;
    private final String clientSecret;

    public TokenSupplier(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    @Override
    public String get() {
        // TODO: make calls to get token
        String token = "";
        return "Bearer " + token;
    }
}
