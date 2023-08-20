package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AssetFolderScope {
    PATH_AND_ITEMS("PathAndItems"),

    PATH("Path"),

    ITEMS("Items");

    private final String value;

    AssetFolderScope(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
