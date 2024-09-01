package com.squidex.api;

import com.google.gson.annotations.SerializedName;

import java.time.Instant;

public class AccessTokenResponse {
    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("expires_in")
    private long expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public AccessToken toToken() {
        return new AccessToken(accessToken, expiresIn, expiresIn + Instant.now().toEpochMilli());
    }
}
