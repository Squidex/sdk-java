package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AssetFoldersDto.Builder.class)
public final class AssetFoldersDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final int total;

    private final List<AssetFolderDto> items;

    private final List<AssetFolderDto> path;

    private AssetFoldersDto(
            Map<String, ResourceLink> links, int total, List<AssetFolderDto> items, List<AssetFolderDto> path) {
        this.links = links;
        this.total = total;
        this.items = items;
        this.path = path;
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
     * @return The total number of assets.
     */
    @JsonProperty("total")
    public int getTotal() {
        return total;
    }

    /**
     * @return The assets folders.
     */
    @JsonProperty("items")
    public List<AssetFolderDto> getItems() {
        return items;
    }

    /**
     * @return The path to the current folder.
     */
    @JsonProperty("path")
    public List<AssetFolderDto> getPath() {
        return path;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AssetFoldersDto && equalTo((AssetFoldersDto) other);
    }

    private boolean equalTo(AssetFoldersDto other) {
        return links.equals(other.links)
                && total == other.total
                && items.equals(other.items)
                && path.equals(other.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.links, this.total, this.items, this.path);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TotalStage builder() {
        return new Builder();
    }

    public interface TotalStage {
        _FinalStage total(int total);

        Builder from(AssetFoldersDto other);
    }

    public interface _FinalStage {
        AssetFoldersDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);

        _FinalStage items(List<AssetFolderDto> items);

        _FinalStage addItems(AssetFolderDto items);

        _FinalStage addAllItems(List<AssetFolderDto> items);

        _FinalStage path(List<AssetFolderDto> path);

        _FinalStage addPath(AssetFolderDto path);

        _FinalStage addAllPath(List<AssetFolderDto> path);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TotalStage, _FinalStage {
        private int total;

        private List<AssetFolderDto> path = new ArrayList<>();

        private List<AssetFolderDto> items = new ArrayList<>();

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(AssetFoldersDto other) {
            links(other.getLinks());
            total(other.getTotal());
            items(other.getItems());
            path(other.getPath());
            return this;
        }

        /**
         * <p>The total number of assets.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("total")
        public _FinalStage total(int total) {
            this.total = total;
            return this;
        }

        /**
         * <p>The path to the current folder.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllPath(List<AssetFolderDto> path) {
            this.path.addAll(path);
            return this;
        }

        /**
         * <p>The path to the current folder.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addPath(AssetFolderDto path) {
            this.path.add(path);
            return this;
        }

        @Override
        @JsonSetter(value = "path", nulls = Nulls.SKIP)
        public _FinalStage path(List<AssetFolderDto> path) {
            this.path.clear();
            this.path.addAll(path);
            return this;
        }

        /**
         * <p>The assets folders.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllItems(List<AssetFolderDto> items) {
            this.items.addAll(items);
            return this;
        }

        /**
         * <p>The assets folders.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addItems(AssetFolderDto items) {
            this.items.add(items);
            return this;
        }

        @Override
        @JsonSetter(value = "items", nulls = Nulls.SKIP)
        public _FinalStage items(List<AssetFolderDto> items) {
            this.items.clear();
            this.items.addAll(items);
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
        public AssetFoldersDto build() {
            return new AssetFoldersDto(links, total, items, path);
        }
    }
}
