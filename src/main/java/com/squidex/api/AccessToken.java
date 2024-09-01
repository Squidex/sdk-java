package com.squidex.api;

import java.time.Instant;

@SuppressWarnings("ClassCanBeRecord")
public final class AccessToken {
    private final String accessToken;
    private final long expiresIn;
    private final long expiresAt;

    public AccessToken(String accessToken, long expiresIn, long expiresAt) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.expiresAt = expiresAt;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public long getExpiresAt() {
        return expiresAt;
    }

    public boolean isExpired() {
        long now = Instant.now().toEpochMilli();

        return expiresAt < now;
    }
}

