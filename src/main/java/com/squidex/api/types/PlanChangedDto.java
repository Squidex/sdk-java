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
@JsonDeserialize(builder = PlanChangedDto.Builder.class)
public final class PlanChangedDto {
    private final Optional<String> redirectUri;

    private PlanChangedDto(Optional<String> redirectUri) {
        this.redirectUri = redirectUri;
    }

    /**
     * @return Optional redirect uri.
     */
    @JsonProperty("redirectUri")
    public Optional<String> getRedirectUri() {
        return redirectUri;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PlanChangedDto && equalTo((PlanChangedDto) other);
    }

    private boolean equalTo(PlanChangedDto other) {
        return redirectUri.equals(other.redirectUri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.redirectUri);
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
        private Optional<String> redirectUri = Optional.empty();

        private Builder() {}

        public Builder from(PlanChangedDto other) {
            redirectUri(other.getRedirectUri());
            return this;
        }

        @JsonSetter(value = "redirectUri", nulls = Nulls.SKIP)
        public Builder redirectUri(Optional<String> redirectUri) {
            this.redirectUri = redirectUri;
            return this;
        }

        public Builder redirectUri(String redirectUri) {
            this.redirectUri = Optional.of(redirectUri);
            return this;
        }

        public PlanChangedDto build() {
            return new PlanChangedDto(redirectUri);
        }
    }
}
