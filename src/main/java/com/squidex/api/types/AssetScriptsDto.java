package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AssetScriptsDto.Builder.class)
public final class AssetScriptsDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final Optional<String> query;

    private final Optional<String> queryPre;

    private final Optional<String> create;

    private final Optional<String> update;

    private final Optional<String> annotate;

    private final Optional<String> move;

    private final Optional<String> delete;

    private final int version;

    private AssetScriptsDto(
            Map<String, ResourceLink> links,
            Optional<String> query,
            Optional<String> queryPre,
            Optional<String> create,
            Optional<String> update,
            Optional<String> annotate,
            Optional<String> move,
            Optional<String> delete,
            int version) {
        this.links = links;
        this.query = query;
        this.queryPre = queryPre;
        this.create = create;
        this.update = update;
        this.annotate = annotate;
        this.move = move;
        this.delete = delete;
        this.version = version;
    }

    /**
     * @return The links.
     */
    @JsonProperty("_links")
    @Override
    public Map<String, ResourceLink> getLinks() {
        return links;
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

    /**
     * @return The version of the app.
     */
    @JsonProperty("version")
    public int getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AssetScriptsDto && equalTo((AssetScriptsDto) other);
    }

    private boolean equalTo(AssetScriptsDto other) {
        return links.equals(other.links)
                && query.equals(other.query)
                && queryPre.equals(other.queryPre)
                && create.equals(other.create)
                && update.equals(other.update)
                && annotate.equals(other.annotate)
                && move.equals(other.move)
                && delete.equals(other.delete)
                && version == other.version;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.links,
                this.query,
                this.queryPre,
                this.create,
                this.update,
                this.annotate,
                this.move,
                this.delete,
                this.version);
    }

    @Override
    public String toString() {
        return "AssetScriptsDto{" + "links: " + links + ", query: " + query + ", queryPre: " + queryPre + ", create: "
                + create + ", update: " + update + ", annotate: " + annotate + ", move: " + move + ", delete: " + delete
                + ", version: " + version + "}";
    }

    public static VersionStage builder() {
        return new Builder();
    }

    public interface VersionStage {
        _FinalStage version(int version);

        Builder from(AssetScriptsDto other);
    }

    public interface _FinalStage {
        AssetScriptsDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);

        _FinalStage query(Optional<String> query);

        _FinalStage query(String query);

        _FinalStage queryPre(Optional<String> queryPre);

        _FinalStage queryPre(String queryPre);

        _FinalStage create(Optional<String> create);

        _FinalStage create(String create);

        _FinalStage update(Optional<String> update);

        _FinalStage update(String update);

        _FinalStage annotate(Optional<String> annotate);

        _FinalStage annotate(String annotate);

        _FinalStage move(Optional<String> move);

        _FinalStage move(String move);

        _FinalStage delete(Optional<String> delete);

        _FinalStage delete(String delete);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements VersionStage, _FinalStage {
        private int version;

        private Optional<String> delete = Optional.empty();

        private Optional<String> move = Optional.empty();

        private Optional<String> annotate = Optional.empty();

        private Optional<String> update = Optional.empty();

        private Optional<String> create = Optional.empty();

        private Optional<String> queryPre = Optional.empty();

        private Optional<String> query = Optional.empty();

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(AssetScriptsDto other) {
            links(other.getLinks());
            query(other.getQuery());
            queryPre(other.getQueryPre());
            create(other.getCreate());
            update(other.getUpdate());
            annotate(other.getAnnotate());
            move(other.getMove());
            delete(other.getDelete());
            version(other.getVersion());
            return this;
        }

        /**
         * <p>The version of the app.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("version")
        public _FinalStage version(int version) {
            this.version = version;
            return this;
        }

        /**
         * <p>The script that is executed when deleting a content.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage delete(String delete) {
            this.delete = Optional.of(delete);
            return this;
        }

        @Override
        @JsonSetter(value = "delete", nulls = Nulls.SKIP)
        public _FinalStage delete(Optional<String> delete) {
            this.delete = delete;
            return this;
        }

        /**
         * <p>The script that is executed when moving a content.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage move(String move) {
            this.move = Optional.of(move);
            return this;
        }

        @Override
        @JsonSetter(value = "move", nulls = Nulls.SKIP)
        public _FinalStage move(Optional<String> move) {
            this.move = move;
            return this;
        }

        /**
         * <p>The script that is executed when annotating a content.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage annotate(String annotate) {
            this.annotate = Optional.of(annotate);
            return this;
        }

        @Override
        @JsonSetter(value = "annotate", nulls = Nulls.SKIP)
        public _FinalStage annotate(Optional<String> annotate) {
            this.annotate = annotate;
            return this;
        }

        /**
         * <p>The script that is executed when updating a content.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage update(String update) {
            this.update = Optional.of(update);
            return this;
        }

        @Override
        @JsonSetter(value = "update", nulls = Nulls.SKIP)
        public _FinalStage update(Optional<String> update) {
            this.update = update;
            return this;
        }

        /**
         * <p>The script that is executed when creating an asset.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage create(String create) {
            this.create = Optional.of(create);
            return this;
        }

        @Override
        @JsonSetter(value = "create", nulls = Nulls.SKIP)
        public _FinalStage create(Optional<String> create) {
            this.create = create;
            return this;
        }

        /**
         * <p>The script that is executed for all assets when querying assets.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage queryPre(String queryPre) {
            this.queryPre = Optional.of(queryPre);
            return this;
        }

        @Override
        @JsonSetter(value = "queryPre", nulls = Nulls.SKIP)
        public _FinalStage queryPre(Optional<String> queryPre) {
            this.queryPre = queryPre;
            return this;
        }

        /**
         * <p>The script that is executed for each asset when querying assets.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage query(String query) {
            this.query = Optional.of(query);
            return this;
        }

        @Override
        @JsonSetter(value = "query", nulls = Nulls.SKIP)
        public _FinalStage query(Optional<String> query) {
            this.query = query;
            return this;
        }

        /**
         * <p>The links.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage links(String key, ResourceLink value) {
            this.links.put(key, value);
            return this;
        }

        /**
         * <p>The links.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage putAllLinks(Map<String, ResourceLink> links) {
            this.links.putAll(links);
            return this;
        }

        @Override
        @JsonSetter(value = "_links", nulls = Nulls.SKIP)
        public _FinalStage links(Map<String, ResourceLink> links) {
            this.links.clear();
            this.links.putAll(links);
            return this;
        }

        @Override
        public AssetScriptsDto build() {
            return new AssetScriptsDto(links, query, queryPre, create, update, annotate, move, delete, version);
        }
    }
}
