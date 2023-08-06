package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AssetChangedRuleTriggerDto.Builder.class)
public final class AssetChangedRuleTriggerDto {
    private final Optional<String> condition;

    private AssetChangedRuleTriggerDto(Optional<String> condition) {
        this.condition = condition;
    }

    /**
     * @return Javascript condition when to trigger.
     */
    @JsonProperty("condition")
    public Optional<String> getCondition() {
        return condition;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AssetChangedRuleTriggerDto && equalTo((AssetChangedRuleTriggerDto) other);
    }

    private boolean equalTo(AssetChangedRuleTriggerDto other) {
        return condition.equals(other.condition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.condition);
    }

    @Override
    public String toString() {
        return "AssetChangedRuleTriggerDto{" + "condition: " + condition + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> condition = Optional.empty();

        private Builder() {}

        public Builder from(AssetChangedRuleTriggerDto other) {
            condition(other.getCondition());
            return this;
        }

        @JsonSetter(value = "condition", nulls = Nulls.SKIP)
        public Builder condition(Optional<String> condition) {
            this.condition = condition;
            return this;
        }

        public Builder condition(String condition) {
            this.condition = Optional.of(condition);
            return this;
        }

        public AssetChangedRuleTriggerDto build() {
            return new AssetChangedRuleTriggerDto(condition);
        }
    }
}
