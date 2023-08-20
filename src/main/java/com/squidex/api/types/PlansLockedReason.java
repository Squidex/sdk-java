package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PlansLockedReason {
    NONE("None"),

    NOT_OWNER("NotOwner"),

    NO_PERMISSION("NoPermission"),

    MANAGED_BY_TEAM("ManagedByTeam");

    private final String value;

    PlansLockedReason(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
