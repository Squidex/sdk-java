package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RuleJobResult {
    PENDING("Pending"),

    SUCCESS("Success"),

    RETRY("Retry"),

    FAILED("Failed"),

    CANCELLED("Cancelled");

    private final String value;

    RuleJobResult(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
