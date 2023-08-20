package com.squidex.api.resources.notifications.requests;

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
@JsonDeserialize(builder = NotificationsGetNotificationsRequest.Builder.class)
public final class NotificationsGetNotificationsRequest {
    private final Optional<Integer> version;

    private NotificationsGetNotificationsRequest(Optional<Integer> version) {
        this.version = version;
    }

    /**
     * @return The current version.
     */
    @JsonProperty("version")
    public Optional<Integer> getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof NotificationsGetNotificationsRequest
                && equalTo((NotificationsGetNotificationsRequest) other);
    }

    private boolean equalTo(NotificationsGetNotificationsRequest other) {
        return version.equals(other.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.version);
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
        private Optional<Integer> version = Optional.empty();

        private Builder() {}

        public Builder from(NotificationsGetNotificationsRequest other) {
            version(other.getVersion());
            return this;
        }

        @JsonSetter(value = "version", nulls = Nulls.SKIP)
        public Builder version(Optional<Integer> version) {
            this.version = version;
            return this;
        }

        public Builder version(Integer version) {
            this.version = Optional.of(version);
            return this;
        }

        public NotificationsGetNotificationsRequest build() {
            return new NotificationsGetNotificationsRequest(version);
        }
    }
}
