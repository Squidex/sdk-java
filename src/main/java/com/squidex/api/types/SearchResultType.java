package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SearchResultType {
    ASSET("Asset"),

    CONTENT("Content"),

    DASHBOARD("Dashboard"),

    SETTING("Setting"),

    RULE("Rule"),

    SCHEMA("Schema");

    private final String value;

    SearchResultType(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
