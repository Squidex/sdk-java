package com.squidex.api;

public interface TokenStore {
    AccessToken get();

    void set(AccessToken token);

    void clear();
}