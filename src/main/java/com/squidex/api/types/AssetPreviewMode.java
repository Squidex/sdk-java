package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AssetPreviewMode {
    IMAGE_AND_FILE_NAME("ImageAndFileName"),

    IMAGE("Image"),

    FILE_NAME("FileName");

    private final String value;

    AssetPreviewMode(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
