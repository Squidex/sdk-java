/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SortOrder {
    ASCENDING("Ascending"),

    DESCENDING("Descending");

    private final String value;

    SortOrder(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
