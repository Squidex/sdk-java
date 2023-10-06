/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ActionTypeEnum {
    BROADCAST("Broadcast"),

    USER("User"),

    GROUP("Group");

    private final String value;

    ActionTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
