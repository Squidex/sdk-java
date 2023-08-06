package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BooleanFieldEditor {
    CHECKBOX("Checkbox"),

    TOGGLE("Toggle");

    private final String value;

    BooleanFieldEditor(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
