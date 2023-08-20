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

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ResourcesDto.Builder.class)
public final class ResourcesDto implements IResource {
    private final Map<String, ResourceLink> links;

    private ResourcesDto(Map<String, ResourceLink> links) {
        this.links = links;
    }

    /**
     * @return The links.
     */
    @JsonProperty("_links")
    @Override
    public Map<String, ResourceLink> getLinks() {
        return links;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ResourcesDto && equalTo((ResourcesDto) other);
    }

    private boolean equalTo(ResourcesDto other) {
        return links.equals(other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.links);
    }

    @Override
    public String toString() {
        return "ResourcesDto{" + "links: " + links + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        public Builder from(ResourcesDto other) {
            links(other.getLinks());
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

        public ResourcesDto build() {
            return new ResourcesDto(links);
        }
    }
}
