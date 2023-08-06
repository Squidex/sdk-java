package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StringFieldEditor {
    INPUT("Input"),

    COLOR("Color"),

    MARKDOWN("Markdown"),

    DROPDOWN("Dropdown"),

    HTML("Html"),

    RADIO("Radio"),

    RICH_TEXT("RichText"),

    SLUG("Slug"),

    STOCK_PHOTO("StockPhoto"),

    TEXT_AREA("TextArea");

    private final String value;

    StringFieldEditor(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
