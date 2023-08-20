package com.squidex.api.resources.apps.requests;

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
@JsonDeserialize(builder = UpdateClientDto.Builder.class)
public final class UpdateClientDto {
    private final Optional<String> name;

    private final Optional<String> role;

    private final Optional<Boolean> allowAnonymous;

    private final Optional<Integer> apiCallsLimit;

    private final Optional<Integer> apiTrafficLimit;

    private UpdateClientDto(
            Optional<String> name,
            Optional<String> role,
            Optional<Boolean> allowAnonymous,
            Optional<Integer> apiCallsLimit,
            Optional<Integer> apiTrafficLimit) {
        this.name = name;
        this.role = role;
        this.allowAnonymous = allowAnonymous;
        this.apiCallsLimit = apiCallsLimit;
        this.apiTrafficLimit = apiTrafficLimit;
    }

    /**
     * @return The new display name of the client.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return The role of the client.
     */
    @JsonProperty("role")
    public Optional<String> getRole() {
        return role;
    }

    /**
     * @return True to allow anonymous access without an access token for this client.
     */
    @JsonProperty("allowAnonymous")
    public Optional<Boolean> getAllowAnonymous() {
        return allowAnonymous;
    }

    /**
     * @return The number of allowed api calls per month for this client.
     */
    @JsonProperty("apiCallsLimit")
    public Optional<Integer> getApiCallsLimit() {
        return apiCallsLimit;
    }

    /**
     * @return The number of allowed api traffic bytes per month for this client.
     */
    @JsonProperty("apiTrafficLimit")
    public Optional<Integer> getApiTrafficLimit() {
        return apiTrafficLimit;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdateClientDto && equalTo((UpdateClientDto) other);
    }

    private boolean equalTo(UpdateClientDto other) {
        return name.equals(other.name)
                && role.equals(other.role)
                && allowAnonymous.equals(other.allowAnonymous)
                && apiCallsLimit.equals(other.apiCallsLimit)
                && apiTrafficLimit.equals(other.apiTrafficLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.role, this.allowAnonymous, this.apiCallsLimit, this.apiTrafficLimit);
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
        private Optional<String> name = Optional.empty();

        private Optional<String> role = Optional.empty();

        private Optional<Boolean> allowAnonymous = Optional.empty();

        private Optional<Integer> apiCallsLimit = Optional.empty();

        private Optional<Integer> apiTrafficLimit = Optional.empty();

        private Builder() {}

        public Builder from(UpdateClientDto other) {
            name(other.getName());
            role(other.getRole());
            allowAnonymous(other.getAllowAnonymous());
            apiCallsLimit(other.getApiCallsLimit());
            apiTrafficLimit(other.getApiTrafficLimit());
            return this;
        }

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.of(name);
            return this;
        }

        @JsonSetter(value = "role", nulls = Nulls.SKIP)
        public Builder role(Optional<String> role) {
            this.role = role;
            return this;
        }

        public Builder role(String role) {
            this.role = Optional.of(role);
            return this;
        }

        @JsonSetter(value = "allowAnonymous", nulls = Nulls.SKIP)
        public Builder allowAnonymous(Optional<Boolean> allowAnonymous) {
            this.allowAnonymous = allowAnonymous;
            return this;
        }

        public Builder allowAnonymous(Boolean allowAnonymous) {
            this.allowAnonymous = Optional.of(allowAnonymous);
            return this;
        }

        @JsonSetter(value = "apiCallsLimit", nulls = Nulls.SKIP)
        public Builder apiCallsLimit(Optional<Integer> apiCallsLimit) {
            this.apiCallsLimit = apiCallsLimit;
            return this;
        }

        public Builder apiCallsLimit(Integer apiCallsLimit) {
            this.apiCallsLimit = Optional.of(apiCallsLimit);
            return this;
        }

        @JsonSetter(value = "apiTrafficLimit", nulls = Nulls.SKIP)
        public Builder apiTrafficLimit(Optional<Integer> apiTrafficLimit) {
            this.apiTrafficLimit = apiTrafficLimit;
            return this;
        }

        public Builder apiTrafficLimit(Integer apiTrafficLimit) {
            this.apiTrafficLimit = Optional.of(apiTrafficLimit);
            return this;
        }

        public UpdateClientDto build() {
            return new UpdateClientDto(name, role, allowAnonymous, apiCallsLimit, apiTrafficLimit);
        }
    }
}
