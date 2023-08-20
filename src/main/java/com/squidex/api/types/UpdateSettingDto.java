package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UpdateSettingDto.Builder.class)
public final class UpdateSettingDto {
    private final Object value;

    private UpdateSettingDto(Object value) {
        this.value = value;
    }

    @JsonProperty("value")
    public Object getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdateSettingDto && equalTo((UpdateSettingDto) other);
    }

    private boolean equalTo(UpdateSettingDto other) {
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

    @Override
    public String toString() {
        return "UpdateSettingDto{" + "value: " + value + "}";
    }

    public static ValueStage builder() {
        return new Builder();
    }

    public interface ValueStage {
        _FinalStage value(Object value);

        Builder from(UpdateSettingDto other);
    }

    public interface _FinalStage {
        UpdateSettingDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ValueStage, _FinalStage {
        private Object value;

        private Builder() {}

        @Override
        public Builder from(UpdateSettingDto other) {
            value(other.getValue());
            return this;
        }

        @Override
        @JsonSetter("value")
        public _FinalStage value(Object value) {
            this.value = value;
            return this;
        }

        @Override
        public UpdateSettingDto build() {
            return new UpdateSettingDto(value);
        }
    }
}
