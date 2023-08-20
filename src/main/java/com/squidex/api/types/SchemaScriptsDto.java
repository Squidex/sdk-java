package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SchemaScriptsDto.Builder.class)
public final class SchemaScriptsDto {
    private final Optional<String> query;

    private final Optional<String> queryPre;

    private final Optional<String> create;

    private final Optional<String> update;

    private final Optional<String> delete;

    private final Optional<String> change;

    private SchemaScriptsDto(
            Optional<String> query,
            Optional<String> queryPre,
            Optional<String> create,
            Optional<String> update,
            Optional<String> delete,
            Optional<String> change) {
        this.query = query;
        this.queryPre = queryPre;
        this.create = create;
        this.update = update;
        this.delete = delete;
        this.change = change;
    }

    /**
     * @return The script that is executed for each content when querying contents.
     */
    @JsonProperty("query")
    public Optional<String> getQuery() {
        return query;
    }

    /**
     * @return The script that is executed for all contents when querying contents.
     */
    @JsonProperty("queryPre")
    public Optional<String> getQueryPre() {
        return queryPre;
    }

    /**
     * @return The script that is executed when creating a content.
     */
    @JsonProperty("create")
    public Optional<String> getCreate() {
        return create;
    }

    /**
     * @return The script that is executed when updating a content.
     */
    @JsonProperty("update")
    public Optional<String> getUpdate() {
        return update;
    }

    /**
     * @return The script that is executed when deleting a content.
     */
    @JsonProperty("delete")
    public Optional<String> getDelete() {
        return delete;
    }

    /**
     * @return The script that is executed when change a content status.
     */
    @JsonProperty("change")
    public Optional<String> getChange() {
        return change;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SchemaScriptsDto && equalTo((SchemaScriptsDto) other);
    }

    private boolean equalTo(SchemaScriptsDto other) {
        return query.equals(other.query)
                && queryPre.equals(other.queryPre)
                && create.equals(other.create)
                && update.equals(other.update)
                && delete.equals(other.delete)
                && change.equals(other.change);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.query, this.queryPre, this.create, this.update, this.delete, this.change);
    }

    @Override
    public String toString() {
        return "SchemaScriptsDto{" + "query: " + query + ", queryPre: " + queryPre + ", create: " + create
                + ", update: " + update + ", delete: " + delete + ", change: " + change + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> query = Optional.empty();

        private Optional<String> queryPre = Optional.empty();

        private Optional<String> create = Optional.empty();

        private Optional<String> update = Optional.empty();

        private Optional<String> delete = Optional.empty();

        private Optional<String> change = Optional.empty();

        private Builder() {}

        public Builder from(SchemaScriptsDto other) {
            query(other.getQuery());
            queryPre(other.getQueryPre());
            create(other.getCreate());
            update(other.getUpdate());
            delete(other.getDelete());
            change(other.getChange());
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

        @JsonSetter(value = "queryPre", nulls = Nulls.SKIP)
        public Builder queryPre(Optional<String> queryPre) {
            this.queryPre = queryPre;
            return this;
        }

        public Builder queryPre(String queryPre) {
            this.queryPre = Optional.of(queryPre);
            return this;
        }

        @JsonSetter(value = "create", nulls = Nulls.SKIP)
        public Builder create(Optional<String> create) {
            this.create = create;
            return this;
        }

        public Builder create(String create) {
            this.create = Optional.of(create);
            return this;
        }

        @JsonSetter(value = "update", nulls = Nulls.SKIP)
        public Builder update(Optional<String> update) {
            this.update = update;
            return this;
        }

        public Builder update(String update) {
            this.update = Optional.of(update);
            return this;
        }

        @JsonSetter(value = "delete", nulls = Nulls.SKIP)
        public Builder delete(Optional<String> delete) {
            this.delete = delete;
            return this;
        }

        public Builder delete(String delete) {
            this.delete = Optional.of(delete);
            return this;
        }

        @JsonSetter(value = "change", nulls = Nulls.SKIP)
        public Builder change(Optional<String> change) {
            this.change = change;
            return this;
        }

        public Builder change(String change) {
            this.change = Optional.of(change);
            return this;
        }

        public SchemaScriptsDto build() {
            return new SchemaScriptsDto(query, queryPre, create, update, delete, change);
        }
    }
}
