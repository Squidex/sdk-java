package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum JobStatus {
    CREATED("Created"),

    STARTED("Started"),

    COMPLETED("Completed"),

    FAILED("Failed");

    private final String value;

    JobStatus(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
