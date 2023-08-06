package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ReferencesFieldEditor {
    LIST("List"),

    DROPDOWN("Dropdown"),

    TAGS("Tags"),

    CHECKBOXES("Checkboxes"),

    INPUT("Input");

    private final String value;

    ReferencesFieldEditor(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
