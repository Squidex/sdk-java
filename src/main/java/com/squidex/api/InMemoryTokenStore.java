package com.squidex.api;

public class InMemoryTokenStore implements TokenStore {
    private AccessToken currentToken;

    @Override
    public AccessToken get() {
        return this.currentToken;
    }

    @Override
    public void set(AccessToken token) {
        this.currentToken = token;
    }

    @Override
    public void clear() {
        this.currentToken = null;
    }
}
