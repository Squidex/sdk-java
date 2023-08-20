package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RuleFieldEditor {
    CHECKBOX("Checkbox"),

    DROPDOWN("Dropdown"),

    EMAIL("Email"),

    JAVASCRIPT("Javascript"),

    NUMBER("Number"),

    PASSWORD("Password"),

    TEXT("Text"),

    TEXT_AREA("TextArea"),

    URL("Url");

    private final String value;

    RuleFieldEditor(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
