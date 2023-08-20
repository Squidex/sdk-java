package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ContributorsDto.Builder.class)
public final class ContributorsDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final List<ContributorDto> items;

    private final int maxContributors;

    private final Optional<ContributorsMetadata> meta;

    private ContributorsDto(
            Map<String, ResourceLink> links,
            List<ContributorDto> items,
            int maxContributors,
            Optional<ContributorsMetadata> meta) {
        this.links = links;
        this.items = items;
        this.maxContributors = maxContributors;
        this.meta = meta;
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
     * @return The contributors.
     */
    @JsonProperty("items")
    public List<ContributorDto> getItems() {
        return items;
    }

    /**
     * @return The maximum number of allowed contributors.
     */
    @JsonProperty("maxContributors")
    public int getMaxContributors() {
        return maxContributors;
    }

    @JsonProperty("_meta")
    public Optional<ContributorsMetadata> getMeta() {
        return meta;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ContributorsDto && equalTo((ContributorsDto) other);
    }

    private boolean equalTo(ContributorsDto other) {
        return links.equals(other.links)
                && items.equals(other.items)
                && maxContributors == other.maxContributors
                && meta.equals(other.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.links, this.items, this.maxContributors, this.meta);
    }

    @Override
    public String toString() {
        return "ContributorsDto{" + "links: " + links + ", items: " + items + ", maxContributors: " + maxContributors
                + ", meta: " + meta + "}";
    }

    public static MaxContributorsStage builder() {
        return new Builder();
    }

    public interface MaxContributorsStage {
        _FinalStage maxContributors(int maxContributors);

        Builder from(ContributorsDto other);
    }

    public interface _FinalStage {
        ContributorsDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);

        _FinalStage items(List<ContributorDto> items);

        _FinalStage addItems(ContributorDto items);

        _FinalStage addAllItems(List<ContributorDto> items);

        _FinalStage meta(Optional<ContributorsMetadata> meta);

        _FinalStage meta(ContributorsMetadata meta);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements MaxContributorsStage, _FinalStage {
        private int maxContributors;

        private Optional<ContributorsMetadata> meta = Optional.empty();

        private List<ContributorDto> items = new ArrayList<>();

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(ContributorsDto other) {
            links(other.getLinks());
            items(other.getItems());
            maxContributors(other.getMaxContributors());
            meta(other.getMeta());
            return this;
        }

        /**
         * <p>The maximum number of allowed contributors.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("maxContributors")
        public _FinalStage maxContributors(int maxContributors) {
            this.maxContributors = maxContributors;
            return this;
        }

        @Override
        public _FinalStage meta(ContributorsMetadata meta) {
            this.meta = Optional.of(meta);
            return this;
        }

        @Override
        @JsonSetter(value = "_meta", nulls = Nulls.SKIP)
        public _FinalStage meta(Optional<ContributorsMetadata> meta) {
            this.meta = meta;
            return this;
        }

        /**
         * <p>The contributors.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllItems(List<ContributorDto> items) {
            this.items.addAll(items);
            return this;
        }

        /**
         * <p>The contributors.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addItems(ContributorDto items) {
            this.items.add(items);
            return this;
        }

        @Override
        @JsonSetter(value = "items", nulls = Nulls.SKIP)
        public _FinalStage items(List<ContributorDto> items) {
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
        public ContributorsDto build() {
            return new ContributorsDto(links, items, maxContributors, meta);
        }
    }
}
