package com.squidex.api.resources.schemas.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import com.squidex.api.types.FieldRuleDto;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ConfigureFieldRulesDto.Builder.class)
public final class ConfigureFieldRulesDto {
    private final Optional<List<FieldRuleDto>> fieldRules;

    private ConfigureFieldRulesDto(Optional<List<FieldRuleDto>> fieldRules) {
        this.fieldRules = fieldRules;
    }

    /**
     * @return The field rules to configure.
     */
    @JsonProperty("fieldRules")
    public Optional<List<FieldRuleDto>> getFieldRules() {
        return fieldRules;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ConfigureFieldRulesDto && equalTo((ConfigureFieldRulesDto) other);
    }

    private boolean equalTo(ConfigureFieldRulesDto other) {
        return fieldRules.equals(other.fieldRules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fieldRules);
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
        private Optional<List<FieldRuleDto>> fieldRules = Optional.empty();

        private Builder() {}

        public Builder from(ConfigureFieldRulesDto other) {
            fieldRules(other.getFieldRules());
            return this;
        }

        @JsonSetter(value = "fieldRules", nulls = Nulls.SKIP)
        public Builder fieldRules(Optional<List<FieldRuleDto>> fieldRules) {
            this.fieldRules = fieldRules;
            return this;
        }

        public Builder fieldRules(List<FieldRuleDto> fieldRules) {
            this.fieldRules = Optional.of(fieldRules);
            return this;
        }

        public ConfigureFieldRulesDto build() {
            return new ConfigureFieldRulesDto(fieldRules);
        }
    }
}
