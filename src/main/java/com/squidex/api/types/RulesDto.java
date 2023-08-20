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
@JsonDeserialize(builder = RulesDto.Builder.class)
public final class RulesDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final List<RuleDto> items;

    private final Optional<String> runningRuleId;

    private RulesDto(Map<String, ResourceLink> links, List<RuleDto> items, Optional<String> runningRuleId) {
        this.links = links;
        this.items = items;
        this.runningRuleId = runningRuleId;
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
     * @return The rules.
     */
    @JsonProperty("items")
    public List<RuleDto> getItems() {
        return items;
    }

    /**
     * @return The ID of the rule that is currently rerunning.
     */
    @JsonProperty("runningRuleId")
    public Optional<String> getRunningRuleId() {
        return runningRuleId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RulesDto && equalTo((RulesDto) other);
    }

    private boolean equalTo(RulesDto other) {
        return links.equals(other.links) && items.equals(other.items) && runningRuleId.equals(other.runningRuleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.links, this.items, this.runningRuleId);
    }

    @Override
    public String toString() {
        return "RulesDto{" + "links: " + links + ", items: " + items + ", runningRuleId: " + runningRuleId + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private List<RuleDto> items = new ArrayList<>();

        private Optional<String> runningRuleId = Optional.empty();

        private Builder() {}

        public Builder from(RulesDto other) {
            links(other.getLinks());
            items(other.getItems());
            runningRuleId(other.getRunningRuleId());
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
        public Builder items(List<RuleDto> items) {
            this.items.clear();
            this.items.addAll(items);
            return this;
        }

        public Builder addItems(RuleDto items) {
            this.items.add(items);
            return this;
        }

        public Builder addAllItems(List<RuleDto> items) {
            this.items.addAll(items);
            return this;
        }

        @JsonSetter(value = "runningRuleId", nulls = Nulls.SKIP)
        public Builder runningRuleId(Optional<String> runningRuleId) {
            this.runningRuleId = runningRuleId;
            return this;
        }

        public Builder runningRuleId(String runningRuleId) {
            this.runningRuleId = Optional.of(runningRuleId);
            return this;
        }

        public RulesDto build() {
            return new RulesDto(links, items, runningRuleId);
        }
    }
}
