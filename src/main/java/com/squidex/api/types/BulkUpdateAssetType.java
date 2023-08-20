package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BulkUpdateAssetType {
    ANNOTATE("Annotate"),

    MOVE("Move"),

    DELETE("Delete");

    private final String value;

    BulkUpdateAssetType(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
