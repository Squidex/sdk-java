package com.squidex.api.resources.usermanagement.requests;

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
@JsonDeserialize(builder = UserManagementGetUsersRequest.Builder.class)
public final class UserManagementGetUsersRequest {
    private final Optional<String> query;

    private final Optional<Integer> skip;

    private final Optional<Integer> take;

    private UserManagementGetUsersRequest(Optional<String> query, Optional<Integer> skip, Optional<Integer> take) {
        this.query = query;
        this.skip = skip;
        this.take = take;
    }

    /**
     * @return Optional query to search by email address or username.
     */
    @JsonProperty("query")
    public Optional<String> getQuery() {
        return query;
    }

    /**
     * @return The number of users to skip.
     */
    @JsonProperty("skip")
    public Optional<Integer> getSkip() {
        return skip;
    }

    /**
     * @return The number of users to return.
     */
    @JsonProperty("take")
    public Optional<Integer> getTake() {
        return take;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UserManagementGetUsersRequest && equalTo((UserManagementGetUsersRequest) other);
    }

    private boolean equalTo(UserManagementGetUsersRequest other) {
        return query.equals(other.query) && skip.equals(other.skip) && take.equals(other.take);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.query, this.skip, this.take);
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
        private Optional<String> query = Optional.empty();

        private Optional<Integer> skip = Optional.empty();

        private Optional<Integer> take = Optional.empty();

        private Builder() {}

        public Builder from(UserManagementGetUsersRequest other) {
            query(other.getQuery());
            skip(other.getSkip());
            take(other.getTake());
            return this;
        }

        @JsonSetter(value = "query", nulls = Nulls.SKIP)
        public Builder query(Optional<String> query) {
            this.query = query;
            return this;
        }

        public Builder query(String query) {
            this.query = Optional.of(query);
            return this;
        }

        @JsonSetter(value = "skip", nulls = Nulls.SKIP)
        public Builder skip(Optional<Integer> skip) {
            this.skip = skip;
            return this;
        }

        public Builder skip(Integer skip) {
            this.skip = Optional.of(skip);
            return this;
        }

        @JsonSetter(value = "take", nulls = Nulls.SKIP)
        public Builder take(Optional<Integer> take) {
            this.take = take;
            return this;
        }

        public Builder take(Integer take) {
            this.take = Optional.of(take);
            return this;
        }

        public UserManagementGetUsersRequest build() {
            return new UserManagementGetUsersRequest(query, skip, take);
        }
    }
}
