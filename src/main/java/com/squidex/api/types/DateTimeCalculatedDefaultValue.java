package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DateTimeCalculatedDefaultValue {
    NOW("Now"),

    TODAY("Today");

    private final String value;

    DateTimeCalculatedDefaultValue(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
