package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TagsFieldEditor {
    TAGS("Tags"),

    CHECKBOXES("Checkboxes"),

    DROPDOWN("Dropdown");

    private final String value;

    TagsFieldEditor(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
