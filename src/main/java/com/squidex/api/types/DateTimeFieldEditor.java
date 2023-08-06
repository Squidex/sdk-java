package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DateTimeFieldEditor {
    DATE("Date"),

    DATE_TIME("DateTime");

    private final String value;

    DateTimeFieldEditor(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
