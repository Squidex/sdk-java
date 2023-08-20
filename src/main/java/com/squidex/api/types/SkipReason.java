package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SkipReason {
    NONE("None"),

    CONDITION_DOES_NOT_MATCH("ConditionDoesNotMatch"),

    CONDITION_PRECHECK_DOES_NOT_MATCH("ConditionPrecheckDoesNotMatch"),

    DISABLED("Disabled"),

    FAILED("Failed"),

    FROM_RULE("FromRule"),

    NO_ACTION("NoAction"),

    NO_TRIGGER("NoTrigger"),

    TOO_OLD("TooOld"),

    WRONG_EVENT("WrongEvent"),

    WRONG_EVENT_FOR_TRIGGER("WrongEventForTrigger");

    private final String value;

    SkipReason(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
