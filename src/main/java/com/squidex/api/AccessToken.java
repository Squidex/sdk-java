package com.squidex.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public final class AccessToken {
    private final String accessToken;
    private final int expiresIn;
    private final Instant expiresAt;

    @JsonCreator()
    public AccessToken(
            @JsonProperty("access_token")String accessToken,
            @JsonProperty("expires_in")int expiresIn) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.expiresAt = Instant.now().plusSeconds(expiresIn);
    }


    public String getAccessToken() {
        return accessToken;
    }


    public int getExpiresIn() {
        return expiresIn;
    }

    @JsonIgnore()
    public Instant getExpiresAt() {
        return expiresAt;
    }
}
