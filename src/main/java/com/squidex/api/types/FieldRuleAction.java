package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FieldRuleAction {
    DISABLE("Disable"),

    HIDE("Hide"),

    REQUIRE("Require");

    private final String value;

    FieldRuleAction(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
