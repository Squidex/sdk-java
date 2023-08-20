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
@JsonDeserialize(builder = ContentsDto.Builder.class)
public final class ContentsDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final int total;

    private final List<ContentDto> items;

    private final List<StatusInfoDto> statuses;

    private ContentsDto(
            Map<String, ResourceLink> links, int total, List<ContentDto> items, List<StatusInfoDto> statuses) {
        this.links = links;
        this.total = total;
        this.items = items;
        this.statuses = statuses;
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
     * @return The total number of content items.
     */
    @JsonProperty("total")
    public int getTotal() {
        return total;
    }

    /**
     * @return The content items.
     */
    @JsonProperty("items")
    public List<ContentDto> getItems() {
        return items;
    }

    /**
     * @return The possible statuses.
     */
    @JsonProperty("statuses")
    public List<StatusInfoDto> getStatuses() {
        return statuses;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ContentsDto && equalTo((ContentsDto) other);
    }

    private boolean equalTo(ContentsDto other) {
        return links.equals(other.links)
                && total == other.total
                && items.equals(other.items)
                && statuses.equals(other.statuses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.links, this.total, this.items, this.statuses);
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

        Builder from(ContentsDto other);
    }

    public interface _FinalStage {
        ContentsDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);

        _FinalStage items(List<ContentDto> items);

        _FinalStage addItems(ContentDto items);

        _FinalStage addAllItems(List<ContentDto> items);

        _FinalStage statuses(List<StatusInfoDto> statuses);

        _FinalStage addStatuses(StatusInfoDto statuses);

        _FinalStage addAllStatuses(List<StatusInfoDto> statuses);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TotalStage, _FinalStage {
        private int total;

        private List<StatusInfoDto> statuses = new ArrayList<>();

        private List<ContentDto> items = new ArrayList<>();

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(ContentsDto other) {
            links(other.getLinks());
            total(other.getTotal());
            items(other.getItems());
            statuses(other.getStatuses());
            return this;
        }

        /**
         * <p>The total number of content items.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("total")
        public _FinalStage total(int total) {
            this.total = total;
            return this;
        }

        /**
         * <p>The possible statuses.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllStatuses(List<StatusInfoDto> statuses) {
            this.statuses.addAll(statuses);
            return this;
        }

        /**
         * <p>The possible statuses.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addStatuses(StatusInfoDto statuses) {
            this.statuses.add(statuses);
            return this;
        }

        @Override
        @JsonSetter(value = "statuses", nulls = Nulls.SKIP)
        public _FinalStage statuses(List<StatusInfoDto> statuses) {
            this.statuses.clear();
            this.statuses.addAll(statuses);
            return this;
        }

        /**
         * <p>The content items.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllItems(List<ContentDto> items) {
            this.items.addAll(items);
            return this;
        }

        /**
         * <p>The content items.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addItems(ContentDto items) {
            this.items.add(items);
            return this;
        }

        @Override
        @JsonSetter(value = "items", nulls = Nulls.SKIP)
        public _FinalStage items(List<ContentDto> items) {
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
        public ContentsDto build() {
            return new ContentsDto(links, total, items, statuses);
        }
    }
}
