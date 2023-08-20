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
@JsonDeserialize(builder = WorkflowsDto.Builder.class)
public final class WorkflowsDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final List<WorkflowDto> items;

    private final List<String> errors;

    private WorkflowsDto(Map<String, ResourceLink> links, List<WorkflowDto> items, List<String> errors) {
        this.links = links;
        this.items = items;
        this.errors = errors;
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
     * @return The workflow.
     */
    @JsonProperty("items")
    public List<WorkflowDto> getItems() {
        return items;
    }

    /**
     * @return The errros that should be fixed.
     */
    @JsonProperty("errors")
    public List<String> getErrors() {
        return errors;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof WorkflowsDto && equalTo((WorkflowsDto) other);
    }

    private boolean equalTo(WorkflowsDto other) {
        return links.equals(other.links) && items.equals(other.items) && errors.equals(other.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.links, this.items, this.errors);
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

        private List<WorkflowDto> items = new ArrayList<>();

        private List<String> errors = new ArrayList<>();

        private Builder() {}

        public Builder from(WorkflowsDto other) {
            links(other.getLinks());
            items(other.getItems());
            errors(other.getErrors());
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
        public Builder items(List<WorkflowDto> items) {
            this.items.clear();
            this.items.addAll(items);
            return this;
        }

        public Builder addItems(WorkflowDto items) {
            this.items.add(items);
            return this;
        }

        public Builder addAllItems(List<WorkflowDto> items) {
            this.items.addAll(items);
            return this;
        }

        @JsonSetter(value = "errors", nulls = Nulls.SKIP)
        public Builder errors(List<String> errors) {
            this.errors.clear();
            this.errors.addAll(errors);
            return this;
        }

        public Builder addErrors(String errors) {
            this.errors.add(errors);
            return this;
        }

        public Builder addAllErrors(List<String> errors) {
            this.errors.addAll(errors);
            return this;
        }

        public WorkflowsDto build() {
            return new WorkflowsDto(links, items, errors);
        }
    }
}
