package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BulkUpdateContentType {
    UPSERT("Upsert"),

    CHANGE_STATUS("ChangeStatus"),

    CREATE("Create"),

    DELETE("Delete"),

    PATCH("Patch"),

    UPDATE("Update"),

    VALIDATE("Validate");

    private final String value;

    BulkUpdateContentType(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
