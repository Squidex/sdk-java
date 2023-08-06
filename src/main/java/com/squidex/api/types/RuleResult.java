package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RuleResult {
    PENDING("Pending"),

    SUCCESS("Success"),

    FAILED("Failed"),

    TIMEOUT("Timeout");

    private final String value;

    RuleResult(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
