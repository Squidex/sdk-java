/**
 * This file was auto-generated by Fern from our API Definition.
 */
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
@JsonDeserialize(builder = SimulatedRuleEventsDto.Builder.class)
public final class SimulatedRuleEventsDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final int total;

    private final List<SimulatedRuleEventDto> items;

    private SimulatedRuleEventsDto(Map<String, ResourceLink> links, int total, List<SimulatedRuleEventDto> items) {
        this.links = links;
        this.total = total;
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
     * @return The total number of simulated rule events.
     */
    @JsonProperty("total")
    public int getTotal() {
        return total;
    }

    /**
     * @return The simulated rule events.
     */
    @JsonProperty("items")
    public List<SimulatedRuleEventDto> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SimulatedRuleEventsDto && equalTo((SimulatedRuleEventsDto) other);
    }

    private boolean equalTo(SimulatedRuleEventsDto other) {
        return links.equals(other.links) && total == other.total && items.equals(other.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.links, this.total, this.items);
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

        Builder from(SimulatedRuleEventsDto other);
    }

    public interface _FinalStage {
        SimulatedRuleEventsDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);

        _FinalStage items(List<SimulatedRuleEventDto> items);

        _FinalStage addItems(SimulatedRuleEventDto items);

        _FinalStage addAllItems(List<SimulatedRuleEventDto> items);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TotalStage, _FinalStage {
        private int total;

        private List<SimulatedRuleEventDto> items = new ArrayList<>();

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(SimulatedRuleEventsDto other) {
            links(other.getLinks());
            total(other.getTotal());
            items(other.getItems());
            return this;
        }

        /**
         * <p>The total number of simulated rule events.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("total")
        public _FinalStage total(int total) {
            this.total = total;
            return this;
        }

        /**
         * <p>The simulated rule events.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllItems(List<SimulatedRuleEventDto> items) {
            this.items.addAll(items);
            return this;
        }

        /**
         * <p>The simulated rule events.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addItems(SimulatedRuleEventDto items) {
            this.items.add(items);
            return this;
        }

        @Override
        @JsonSetter(value = "items", nulls = Nulls.SKIP)
        public _FinalStage items(List<SimulatedRuleEventDto> items) {
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
        public SimulatedRuleEventsDto build() {
            return new SimulatedRuleEventsDto(links, total, items);
        }
    }
}
