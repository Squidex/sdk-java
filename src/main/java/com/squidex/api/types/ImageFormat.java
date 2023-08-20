package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ImageFormat {
    AVIF("AVIF"),

    BMP("BMP"),

    GIF("GIF"),

    JPEG("JPEG"),

    PNG("PNG"),

    TGA("TGA"),

    TIFF("TIFF"),

    WEBP("WEBP");

    private final String value;

    ImageFormat(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
