package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = QueryDto.Builder.class)
public final class QueryDto {
    private final Optional<List<String>> ids;

    private final Optional<String> oData;

    private final Optional<Object> q;

    private final Optional<String> parentId;

    private QueryDto(
            Optional<List<String>> ids, Optional<String> oData, Optional<Object> q, Optional<String> parentId) {
        this.ids = ids;
        this.oData = oData;
        this.q = q;
        this.parentId = parentId;
    }

    /**
     * @return The optional list of ids to query.
     */
    @JsonProperty("ids")
    public Optional<List<String>> getIds() {
        return ids;
    }

    /**
     * @return The optional odata query.
     */
    @JsonProperty("oData")
    public Optional<String> getOData() {
        return oData;
    }

    @JsonProperty("q")
    public Optional<Object> getQ() {
        return q;
    }

    /**
     * @return The parent id (for assets).
     */
    @JsonProperty("parentId")
    public Optional<String> getParentId() {
        return parentId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof QueryDto && equalTo((QueryDto) other);
    }

    private boolean equalTo(QueryDto other) {
        return ids.equals(other.ids)
                && oData.equals(other.oData)
                && q.equals(other.q)
                && parentId.equals(other.parentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.ids, this.oData, this.q, this.parentId);
    }

    @Override
    public String toString() {
        return "QueryDto{" + "ids: " + ids + ", oData: " + oData + ", q: " + q + ", parentId: " + parentId + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<List<String>> ids = Optional.empty();

        private Optional<String> oData = Optional.empty();

        private Optional<Object> q = Optional.empty();

        private Optional<String> parentId = Optional.empty();

        private Builder() {}

        public Builder from(QueryDto other) {
            ids(other.getIds());
            oData(other.getOData());
            q(other.getQ());
            parentId(other.getParentId());
            return this;
        }

        @JsonSetter(value = "ids", nulls = Nulls.SKIP)
        public Builder ids(Optional<List<String>> ids) {
            this.ids = ids;
            return this;
        }

        public Builder ids(List<String> ids) {
            this.ids = Optional.of(ids);
            return this;
        }

        @JsonSetter(value = "oData", nulls = Nulls.SKIP)
        public Builder oData(Optional<String> oData) {
            this.oData = oData;
            return this;
        }

        public Builder oData(String oData) {
            this.oData = Optional.of(oData);
            return this;
        }

        @JsonSetter(value = "q", nulls = Nulls.SKIP)
        public Builder q(Optional<Object> q) {
            this.q = q;
            return this;
        }

        public Builder q(Object q) {
            this.q = Optional.of(q);
            return this;
        }

        @JsonSetter(value = "parentId", nulls = Nulls.SKIP)
        public Builder parentId(Optional<String> parentId) {
            this.parentId = parentId;
            return this;
        }

        public Builder parentId(String parentId) {
            this.parentId = Optional.of(parentId);
            return this;
        }

        public QueryDto build() {
            return new QueryDto(ids, oData, q, parentId);
        }
    }
}
