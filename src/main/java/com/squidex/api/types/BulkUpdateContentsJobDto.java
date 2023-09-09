package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = BulkUpdateContentsJobDto.Builder.class)
public final class BulkUpdateContentsJobDto {
    private final Optional<QueryJsonDto> query;

    private final Optional<String> id;

    private final Optional<Map<String, Map<String, Object>>> data;

    private final Optional<String> status;

    private final Optional<OffsetDateTime> dueTime;

    private final Optional<BulkUpdateContentType> type;

    private final Optional<String> schema;

    private final Optional<Boolean> patch;

    private final Optional<Boolean> permanent;

    private final Optional<Integer> expectedCount;

    private final Optional<Integer> expectedVersion;

    private BulkUpdateContentsJobDto(
            Optional<QueryJsonDto> query,
            Optional<String> id,
            Optional<Map<String, Map<String, Object>>> data,
            Optional<String> status,
            Optional<OffsetDateTime> dueTime,
            Optional<BulkUpdateContentType> type,
            Optional<String> schema,
            Optional<Boolean> patch,
            Optional<Boolean> permanent,
            Optional<Integer> expectedCount,
            Optional<Integer> expectedVersion) {
        this.query = query;
        this.id = id;
        this.data = data;
        this.status = status;
        this.dueTime = dueTime;
        this.type = type;
        this.schema = schema;
        this.patch = patch;
        this.permanent = permanent;
        this.expectedCount = expectedCount;
        this.expectedVersion = expectedVersion;
    }

    /**
     * @return An optional query to identify the content to update.
     */
    @JsonProperty("query")
    public Optional<QueryJsonDto> getQuery() {
        return query;
    }

    /**
     * @return An optional ID of the content to update.
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return The data of the content when type is set to 'Upsert', 'Create', 'Update' or 'Patch.
     */
    @JsonProperty("data")
    public Optional<Map<String, Map<String, Object>>> getData() {
        return data;
    }

    /**
     * @return The new status when the type is set to 'ChangeStatus' or 'Upsert'.
     */
    @JsonProperty("status")
    public Optional<String> getStatus() {
        return status;
    }

    /**
     * @return The due time.
     */
    @JsonProperty("dueTime")
    public Optional<OffsetDateTime> getDueTime() {
        return dueTime;
    }

    /**
     * @return The update type.
     */
    @JsonProperty("type")
    public Optional<BulkUpdateContentType> getType() {
        return type;
    }

    /**
     * @return The optional schema id or name.
     */
    @JsonProperty("schema")
    public Optional<String> getSchema() {
        return schema;
    }

    /**
     * @return Makes the update as patch.
     */
    @JsonProperty("patch")
    public Optional<Boolean> getPatch() {
        return patch;
    }

    /**
     * @return True to delete the content permanently.
     */
    @JsonProperty("permanent")
    public Optional<Boolean> getPermanent() {
        return permanent;
    }

    /**
     * @return The number of expected items. Set it to a higher number to update multiple items when a query is defined.
     */
    @JsonProperty("expectedCount")
    public Optional<Integer> getExpectedCount() {
        return expectedCount;
    }

    /**
     * @return The expected version.
     */
    @JsonProperty("expectedVersion")
    public Optional<Integer> getExpectedVersion() {
        return expectedVersion;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BulkUpdateContentsJobDto && equalTo((BulkUpdateContentsJobDto) other);
    }

    private boolean equalTo(BulkUpdateContentsJobDto other) {
        return query.equals(other.query)
                && id.equals(other.id)
                && data.equals(other.data)
                && status.equals(other.status)
                && dueTime.equals(other.dueTime)
                && type.equals(other.type)
                && schema.equals(other.schema)
                && patch.equals(other.patch)
                && permanent.equals(other.permanent)
                && expectedCount.equals(other.expectedCount)
                && expectedVersion.equals(other.expectedVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.query,
                this.id,
                this.data,
                this.status,
                this.dueTime,
                this.type,
                this.schema,
                this.patch,
                this.permanent,
                this.expectedCount,
                this.expectedVersion);
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
        private Optional<QueryJsonDto> query = Optional.empty();

        private Optional<String> id = Optional.empty();

        private Optional<Map<String, Map<String, Object>>> data = Optional.empty();

        private Optional<String> status = Optional.empty();

        private Optional<OffsetDateTime> dueTime = Optional.empty();

        private Optional<BulkUpdateContentType> type = Optional.empty();

        private Optional<String> schema = Optional.empty();

        private Optional<Boolean> patch = Optional.empty();

        private Optional<Boolean> permanent = Optional.empty();

        private Optional<Integer> expectedCount = Optional.empty();

        private Optional<Integer> expectedVersion = Optional.empty();

        private Builder() {}

        public Builder from(BulkUpdateContentsJobDto other) {
            query(other.getQuery());
            id(other.getId());
            data(other.getData());
            status(other.getStatus());
            dueTime(other.getDueTime());
            type(other.getType());
            schema(other.getSchema());
            patch(other.getPatch());
            permanent(other.getPermanent());
            expectedCount(other.getExpectedCount());
            expectedVersion(other.getExpectedVersion());
            return this;
        }

        @JsonSetter(value = "query", nulls = Nulls.SKIP)
        public Builder query(Optional<QueryJsonDto> query) {
            this.query = query;
            return this;
        }

        public Builder query(QueryJsonDto query) {
            this.query = Optional.of(query);
            return this;
        }

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.of(id);
            return this;
        }

        @JsonSetter(value = "data", nulls = Nulls.SKIP)
        public Builder data(Optional<Map<String, Map<String, Object>>> data) {
            this.data = data;
            return this;
        }

        public Builder data(Map<String, Map<String, Object>> data) {
            this.data = Optional.of(data);
            return this;
        }

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<String> status) {
            this.status = status;
            return this;
        }

        public Builder status(String status) {
            this.status = Optional.of(status);
            return this;
        }

        @JsonSetter(value = "dueTime", nulls = Nulls.SKIP)
        public Builder dueTime(Optional<OffsetDateTime> dueTime) {
            this.dueTime = dueTime;
            return this;
        }

        public Builder dueTime(OffsetDateTime dueTime) {
            this.dueTime = Optional.of(dueTime);
            return this;
        }

        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public Builder type(Optional<BulkUpdateContentType> type) {
            this.type = type;
            return this;
        }

        public Builder type(BulkUpdateContentType type) {
            this.type = Optional.of(type);
            return this;
        }

        @JsonSetter(value = "schema", nulls = Nulls.SKIP)
        public Builder schema(Optional<String> schema) {
            this.schema = schema;
            return this;
        }

        public Builder schema(String schema) {
            this.schema = Optional.of(schema);
            return this;
        }

        @JsonSetter(value = "patch", nulls = Nulls.SKIP)
        public Builder patch(Optional<Boolean> patch) {
            this.patch = patch;
            return this;
        }

        public Builder patch(Boolean patch) {
            this.patch = Optional.of(patch);
            return this;
        }

        @JsonSetter(value = "permanent", nulls = Nulls.SKIP)
        public Builder permanent(Optional<Boolean> permanent) {
            this.permanent = permanent;
            return this;
        }

        public Builder permanent(Boolean permanent) {
            this.permanent = Optional.of(permanent);
            return this;
        }

        @JsonSetter(value = "expectedCount", nulls = Nulls.SKIP)
        public Builder expectedCount(Optional<Integer> expectedCount) {
            this.expectedCount = expectedCount;
            return this;
        }

        public Builder expectedCount(Integer expectedCount) {
            this.expectedCount = Optional.of(expectedCount);
            return this;
        }

        @JsonSetter(value = "expectedVersion", nulls = Nulls.SKIP)
        public Builder expectedVersion(Optional<Integer> expectedVersion) {
            this.expectedVersion = expectedVersion;
            return this;
        }

        public Builder expectedVersion(Integer expectedVersion) {
            this.expectedVersion = Optional.of(expectedVersion);
            return this;
        }

        public BulkUpdateContentsJobDto build() {
            return new BulkUpdateContentsJobDto(
                    query, id, data, status, dueTime, type, schema, patch, permanent, expectedCount, expectedVersion);
        }
    }
}
