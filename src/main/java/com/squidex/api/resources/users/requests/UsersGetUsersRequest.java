package com.squidex.api.resources.users.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UsersGetUsersRequest.Builder.class)
public final class UsersGetUsersRequest {
    private final Optional<String> query;

    private UsersGetUsersRequest(Optional<String> query) {
        this.query = query;
    }

    /**
     * @return The query to search the user by email address. Case invariant.
     */
    @JsonProperty("query")
    public Optional<String> getQuery() {
        return query;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UsersGetUsersRequest && equalTo((UsersGetUsersRequest) other);
    }

    private boolean equalTo(UsersGetUsersRequest other) {
        return query.equals(other.query);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.query);
    }

    @Override
    public String toString() {
        return "UsersGetUsersRequest{" + "query: " + query + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> query = Optional.empty();

        private Builder() {}

        public Builder from(UsersGetUsersRequest other) {
            query(other.getQuery());
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

        public UsersGetUsersRequest build() {
            return new UsersGetUsersRequest(query);
        }
    }
}
