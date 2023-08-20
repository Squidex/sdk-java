package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ComponentFieldPropertiesDto.Builder.class)
public final class ComponentFieldPropertiesDto {
    private final Optional<List<String>> schemaIds;

    private ComponentFieldPropertiesDto(Optional<List<String>> schemaIds) {
        this.schemaIds = schemaIds;
    }

    /**
     * @return The ID of the embedded schemas.
     */
    @JsonProperty("schemaIds")
    public Optional<List<String>> getSchemaIds() {
        return schemaIds;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ComponentFieldPropertiesDto && equalTo((ComponentFieldPropertiesDto) other);
    }

    private boolean equalTo(ComponentFieldPropertiesDto other) {
        return schemaIds.equals(other.schemaIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.schemaIds);
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
        private Optional<List<String>> schemaIds = Optional.empty();

        private Builder() {}

        public Builder from(ComponentFieldPropertiesDto other) {
            schemaIds(other.getSchemaIds());
            return this;
        }

        @JsonSetter(value = "schemaIds", nulls = Nulls.SKIP)
        public Builder schemaIds(Optional<List<String>> schemaIds) {
            this.schemaIds = schemaIds;
            return this;
        }

        public Builder schemaIds(List<String> schemaIds) {
            this.schemaIds = Optional.of(schemaIds);
            return this;
        }

        public ComponentFieldPropertiesDto build() {
            return new ComponentFieldPropertiesDto(schemaIds);
        }
    }
}
