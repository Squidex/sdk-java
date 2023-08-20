package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UpdateFieldDto.Builder.class)
public final class UpdateFieldDto {
    private final FieldPropertiesDto properties;

    private UpdateFieldDto(FieldPropertiesDto properties) {
        this.properties = properties;
    }

    @JsonProperty("properties")
    public FieldPropertiesDto getProperties() {
        return properties;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdateFieldDto && equalTo((UpdateFieldDto) other);
    }

    private boolean equalTo(UpdateFieldDto other) {
        return properties.equals(other.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.properties);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static PropertiesStage builder() {
        return new Builder();
    }

    public interface PropertiesStage {
        _FinalStage properties(FieldPropertiesDto properties);

        Builder from(UpdateFieldDto other);
    }

    public interface _FinalStage {
        UpdateFieldDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements PropertiesStage, _FinalStage {
        private FieldPropertiesDto properties;

        private Builder() {}

        @Override
        public Builder from(UpdateFieldDto other) {
            properties(other.getProperties());
            return this;
        }

        @Override
        @JsonSetter("properties")
        public _FinalStage properties(FieldPropertiesDto properties) {
            this.properties = properties;
            return this;
        }

        @Override
        public UpdateFieldDto build() {
            return new UpdateFieldDto(properties);
        }
    }
}
