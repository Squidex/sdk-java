package com.squidex.api.resources.search.requests;

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
@JsonDeserialize(builder = SearchGetSearchResultsRequest.Builder.class)
public final class SearchGetSearchResultsRequest {
    private final Optional<String> query;

    private SearchGetSearchResultsRequest(Optional<String> query) {
        this.query = query;
    }

    /**
     * @return The search query.
     */
    @JsonProperty("query")
    public Optional<String> getQuery() {
        return query;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SearchGetSearchResultsRequest && equalTo((SearchGetSearchResultsRequest) other);
    }

    private boolean equalTo(SearchGetSearchResultsRequest other) {
        return query.equals(other.query);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.query);
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

        private Builder() {}

        public Builder from(SearchGetSearchResultsRequest other) {
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

        public SearchGetSearchResultsRequest build() {
            return new SearchGetSearchResultsRequest(query);
        }
    }
}
