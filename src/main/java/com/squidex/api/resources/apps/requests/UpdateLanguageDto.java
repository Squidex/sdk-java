package com.squidex.api.resources.apps.requests;

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
@JsonDeserialize(builder = UpdateLanguageDto.Builder.class)
public final class UpdateLanguageDto {
    private final Optional<Boolean> isMaster;

    private final Optional<Boolean> isOptional;

    private final Optional<List<String>> fallback;

    private UpdateLanguageDto(
            Optional<Boolean> isMaster, Optional<Boolean> isOptional, Optional<List<String>> fallback) {
        this.isMaster = isMaster;
        this.isOptional = isOptional;
        this.fallback = fallback;
    }

    /**
     * @return Set the value to true to make the language the master.
     */
    @JsonProperty("isMaster")
    public Optional<Boolean> getIsMaster() {
        return isMaster;
    }

    /**
     * @return Set the value to true to make the language optional.
     */
    @JsonProperty("isOptional")
    public Optional<Boolean> getIsOptional() {
        return isOptional;
    }

    /**
     * @return Optional fallback languages.
     */
    @JsonProperty("fallback")
    public Optional<List<String>> getFallback() {
        return fallback;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdateLanguageDto && equalTo((UpdateLanguageDto) other);
    }

    private boolean equalTo(UpdateLanguageDto other) {
        return isMaster.equals(other.isMaster)
                && isOptional.equals(other.isOptional)
                && fallback.equals(other.fallback);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.isMaster, this.isOptional, this.fallback);
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
        private Optional<Boolean> isMaster = Optional.empty();

        private Optional<Boolean> isOptional = Optional.empty();

        private Optional<List<String>> fallback = Optional.empty();

        private Builder() {}

        public Builder from(UpdateLanguageDto other) {
            isMaster(other.getIsMaster());
            isOptional(other.getIsOptional());
            fallback(other.getFallback());
            return this;
        }

        @JsonSetter(value = "isMaster", nulls = Nulls.SKIP)
        public Builder isMaster(Optional<Boolean> isMaster) {
            this.isMaster = isMaster;
            return this;
        }

        public Builder isMaster(Boolean isMaster) {
            this.isMaster = Optional.of(isMaster);
            return this;
        }

        @JsonSetter(value = "isOptional", nulls = Nulls.SKIP)
        public Builder isOptional(Optional<Boolean> isOptional) {
            this.isOptional = isOptional;
            return this;
        }

        public Builder isOptional(Boolean isOptional) {
            this.isOptional = Optional.of(isOptional);
            return this;
        }

        @JsonSetter(value = "fallback", nulls = Nulls.SKIP)
        public Builder fallback(Optional<List<String>> fallback) {
            this.fallback = fallback;
            return this;
        }

        public Builder fallback(List<String> fallback) {
            this.fallback = Optional.of(fallback);
            return this;
        }

        public UpdateLanguageDto build() {
            return new UpdateLanguageDto(isMaster, isOptional, fallback);
        }
    }
}
