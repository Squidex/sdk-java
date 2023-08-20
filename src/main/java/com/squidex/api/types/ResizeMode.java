package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ResizeMode {
    CROP("Crop"),

    CROP_UPSIZE("CropUpsize"),

    PAD("Pad"),

    BOX_PAD("BoxPad"),

    MAX("Max"),

    MIN("Min"),

    STRETCH("Stretch");

    private final String value;

    ResizeMode(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
