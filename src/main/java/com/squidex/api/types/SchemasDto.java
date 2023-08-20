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
@JsonDeserialize(builder = SchemasDto.Builder.class)
public final class SchemasDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final List<SchemaDto> items;

    private SchemasDto(Map<String, ResourceLink> links, List<SchemaDto> items) {
        this.links = links;
        this.items = items;
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
     * @return The schemas.
     */
    @JsonProperty("items")
    public List<SchemaDto> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SchemasDto && equalTo((SchemasDto) other);
    }

    private boolean equalTo(SchemasDto other) {
        return links.equals(other.links) && items.equals(other.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.links, this.items);
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
        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private List<SchemaDto> items = new ArrayList<>();

        private Builder() {}

        public Builder from(SchemasDto other) {
            links(other.getLinks());
            items(other.getItems());
            return this;
        }

        @JsonSetter(value = "_links", nulls = Nulls.SKIP)
        public Builder links(Map<String, ResourceLink> links) {
            this.links.clear();
            this.links.putAll(links);
            return this;
        }

        public Builder putAllLinks(Map<String, ResourceLink> links) {
            this.links.putAll(links);
            return this;
        }

        public Builder links(String key, ResourceLink value) {
            this.links.put(key, value);
            return this;
        }

        @JsonSetter(value = "items", nulls = Nulls.SKIP)
        public Builder items(List<SchemaDto> items) {
            this.items.clear();
            this.items.addAll(items);
            return this;
        }

        public Builder addItems(SchemaDto items) {
            this.items.add(items);
            return this;
        }

        public Builder addAllItems(List<SchemaDto> items) {
            this.items.addAll(items);
            return this;
        }

        public SchemasDto build() {
            return new SchemasDto(links, items);
        }
    }
}
