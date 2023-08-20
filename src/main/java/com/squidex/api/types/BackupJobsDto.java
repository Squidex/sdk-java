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
@JsonDeserialize(builder = BackupJobsDto.Builder.class)
public final class BackupJobsDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final List<BackupJobDto> items;

    private BackupJobsDto(Map<String, ResourceLink> links, List<BackupJobDto> items) {
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
     * @return The backups.
     */
    @JsonProperty("items")
    public List<BackupJobDto> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BackupJobsDto && equalTo((BackupJobsDto) other);
    }

    private boolean equalTo(BackupJobsDto other) {
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

        private List<BackupJobDto> items = new ArrayList<>();

        private Builder() {}

        public Builder from(BackupJobsDto other) {
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
        public Builder items(List<BackupJobDto> items) {
            this.items.clear();
            this.items.addAll(items);
            return this;
        }

        public Builder addItems(BackupJobDto items) {
            this.items.add(items);
            return this;
        }

        public Builder addAllItems(List<BackupJobDto> items) {
            this.items.addAll(items);
            return this;
        }

        public BackupJobsDto build() {
            return new BackupJobsDto(links, items);
        }
    }
}
