package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SchemaChangedRuleTriggerDto.Builder.class)
public final class SchemaChangedRuleTriggerDto {
    private final Optional<String> condition;

    private SchemaChangedRuleTriggerDto(Optional<String> condition) {
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
        return other instanceof SchemaChangedRuleTriggerDto && equalTo((SchemaChangedRuleTriggerDto) other);
    }

    private boolean equalTo(SchemaChangedRuleTriggerDto other) {
        return condition.equals(other.condition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.condition);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> condition = Optional.empty();

        private Builder() {}

        public Builder from(SchemaChangedRuleTriggerDto other) {
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

        public SchemaChangedRuleTriggerDto build() {
            return new SchemaChangedRuleTriggerDto(condition);
        }
    }
}
