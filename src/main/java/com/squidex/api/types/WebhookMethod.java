package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum WebhookMethod {
    POST("POST"),

    PUT("PUT"),

    GET("GET"),

    DELETE("DELETE"),

    PATCH("PATCH");

    private final String value;

    WebhookMethod(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
