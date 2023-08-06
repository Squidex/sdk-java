package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TranslationResultCode {
    TRANSLATED("Translated"),

    LANGUAGE_NOT_SUPPORTED("LanguageNotSupported"),

    NOT_TRANSLATED("NotTranslated"),

    NOT_CONFIGURED("NotConfigured"),

    UNAUTHORIZED("Unauthorized"),

    FAILED("Failed");

    private final String value;

    TranslationResultCode(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
