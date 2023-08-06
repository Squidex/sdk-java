package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StringContentType {
    UNSPECIFIED("Unspecified"),

    HTML("Html"),

    MARKDOWN("Markdown");

    private final String value;

    StringContentType(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
