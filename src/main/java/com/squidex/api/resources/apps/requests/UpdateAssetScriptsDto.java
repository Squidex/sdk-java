package com.squidex.api.resources.apps.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UpdateAssetScriptsDto.Builder.class)
public final class UpdateAssetScriptsDto {
    private final Optional<String> query;

    private final Optional<String> queryPre;

    private final Optional<String> create;

    private final Optional<String> update;

    private final Optional<String> annotate;

    private final Optional<String> move;

    private final Optional<String> delete;

    private UpdateAssetScriptsDto(
            Optional<String> query,
            Optional<String> queryPre,
            Optional<String> create,
            Optional<String> update,
            Optional<String> annotate,
            Optional<String> move,
            Optional<String> delete) {
        this.query = query;
        this.queryPre = queryPre;
        this.create = create;
        this.update = update;
        this.annotate = annotate;
        this.move = move;
        this.delete = delete;
    }

    /**
     * @return The script that is executed for each asset when querying assets.
     */
    @JsonProperty("query")
    public Optional<String> getQuery() {
        return query;
    }

    /**
     * @return The script that is executed for all assets when querying assets.
     */
    @JsonProperty("queryPre")
    public Optional<String> getQueryPre() {
        return queryPre;
    }

    /**
     * @return The script that is executed when creating an asset.
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
     * @return The script that is executed when annotating a content.
     */
    @JsonProperty("annotate")
    public Optional<String> getAnnotate() {
        return annotate;
    }

    /**
     * @return The script that is executed when moving a content.
     */
    @JsonProperty("move")
    public Optional<String> getMove() {
        return move;
    }

    /**
     * @return The script that is executed when deleting a content.
     */
    @JsonProperty("delete")
    public Optional<String> getDelete() {
        return delete;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdateAssetScriptsDto && equalTo((UpdateAssetScriptsDto) other);
    }

    private boolean equalTo(UpdateAssetScriptsDto other) {
        return query.equals(other.query)
                && queryPre.equals(other.queryPre)
                && create.equals(other.create)
                && update.equals(other.update)
                && annotate.equals(other.annotate)
                && move.equals(other.move)
                && delete.equals(other.delete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.query, this.queryPre, this.create, this.update, this.annotate, this.move, this.delete);
    }

    @Override
    public String toString() {
        return "UpdateAssetScriptsDto{" + "query: " + query + ", queryPre: " + queryPre + ", create: " + create
                + ", update: " + update + ", annotate: " + annotate + ", move: " + move + ", delete: " + delete + "}";
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

        private Optional<String> annotate = Optional.empty();

        private Optional<String> move = Optional.empty();

        private Optional<String> delete = Optional.empty();

        private Builder() {}

        public Builder from(UpdateAssetScriptsDto other) {
            query(other.getQuery());
            queryPre(other.getQueryPre());
            create(other.getCreate());
            update(other.getUpdate());
            annotate(other.getAnnotate());
            move(other.getMove());
            delete(other.getDelete());
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

        @JsonSetter(value = "annotate", nulls = Nulls.SKIP)
        public Builder annotate(Optional<String> annotate) {
            this.annotate = annotate;
            return this;
        }

        public Builder annotate(String annotate) {
            this.annotate = Optional.of(annotate);
            return this;
        }

        @JsonSetter(value = "move", nulls = Nulls.SKIP)
        public Builder move(Optional<String> move) {
            this.move = move;
            return this;
        }

        public Builder move(String move) {
            this.move = Optional.of(move);
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

        public UpdateAssetScriptsDto build() {
            return new UpdateAssetScriptsDto(query, queryPre, create, update, annotate, move, delete);
        }
    }
}
