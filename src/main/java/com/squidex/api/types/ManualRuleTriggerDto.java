package com.squidex.api.types;

import com.squidex.api.core.ObjectMappers;

public final class ManualRuleTriggerDto {
    private ManualRuleTriggerDto() {}

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ManualRuleTriggerDto;
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }
}
