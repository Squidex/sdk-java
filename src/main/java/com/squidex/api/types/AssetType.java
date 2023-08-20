package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AssetType {
    UNKNOWN("Unknown"),

    IMAGE("Image"),

    AUDIO("Audio"),

    VIDEO("Video");

    private final String value;

    AssetType(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
