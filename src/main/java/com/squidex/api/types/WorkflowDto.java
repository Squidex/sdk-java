package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = WorkflowDto.Builder.class)
public final class WorkflowDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final String id;

    private final Optional<String> name;

    private final Map<String, WorkflowStepDto> steps;

    private final Optional<List<String>> schemaIds;

    private final String initial;

    private WorkflowDto(
            Map<String, ResourceLink> links,
            String id,
            Optional<String> name,
            Map<String, WorkflowStepDto> steps,
            Optional<List<String>> schemaIds,
            String initial) {
        this.links = links;
        this.id = id;
        this.name = name;
        this.steps = steps;
        this.schemaIds = schemaIds;
        this.initial = initial;
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
     * @return The workflow id.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The name of the workflow.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return The workflow steps.
     */
    @JsonProperty("steps")
    public Map<String, WorkflowStepDto> getSteps() {
        return steps;
    }

    /**
     * @return The schema ids.
     */
    @JsonProperty("schemaIds")
    public Optional<List<String>> getSchemaIds() {
        return schemaIds;
    }

    /**
     * @return The initial step.
     */
    @JsonProperty("initial")
    public String getInitial() {
        return initial;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof WorkflowDto && equalTo((WorkflowDto) other);
    }

    private boolean equalTo(WorkflowDto other) {
        return links.equals(other.links)
                && id.equals(other.id)
                && name.equals(other.name)
                && steps.equals(other.steps)
                && schemaIds.equals(other.schemaIds)
                && initial.equals(other.initial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.links, this.id, this.name, this.steps, this.schemaIds, this.initial);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        InitialStage id(String id);

        Builder from(WorkflowDto other);
    }

    public interface InitialStage {
        _FinalStage initial(String initial);
    }

    public interface _FinalStage {
        WorkflowDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);

        _FinalStage name(Optional<String> name);

        _FinalStage name(String name);

        _FinalStage steps(Map<String, WorkflowStepDto> steps);

        _FinalStage putAllSteps(Map<String, WorkflowStepDto> steps);

        _FinalStage steps(String key, WorkflowStepDto value);

        _FinalStage schemaIds(Optional<List<String>> schemaIds);

        _FinalStage schemaIds(List<String> schemaIds);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, InitialStage, _FinalStage {
        private String id;

        private String initial;

        private Optional<List<String>> schemaIds = Optional.empty();

        private Map<String, WorkflowStepDto> steps = new LinkedHashMap<>();

        private Optional<String> name = Optional.empty();

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(WorkflowDto other) {
            links(other.getLinks());
            id(other.getId());
            name(other.getName());
            steps(other.getSteps());
            schemaIds(other.getSchemaIds());
            initial(other.getInitial());
            return this;
        }

        /**
         * <p>The workflow id.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("id")
        public InitialStage id(String id) {
            this.id = id;
            return this;
        }

        /**
         * <p>The initial step.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("initial")
        public _FinalStage initial(String initial) {
            this.initial = initial;
            return this;
        }

        /**
         * <p>The schema ids.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage schemaIds(List<String> schemaIds) {
            this.schemaIds = Optional.of(schemaIds);
            return this;
        }

        @Override
        @JsonSetter(value = "schemaIds", nulls = Nulls.SKIP)
        public _FinalStage schemaIds(Optional<List<String>> schemaIds) {
            this.schemaIds = schemaIds;
            return this;
        }

        /**
         * <p>The workflow steps.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage steps(String key, WorkflowStepDto value) {
            this.steps.put(key, value);
            return this;
        }

        /**
         * <p>The workflow steps.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage putAllSteps(Map<String, WorkflowStepDto> steps) {
            this.steps.putAll(steps);
            return this;
        }

        @Override
        @JsonSetter(value = "steps", nulls = Nulls.SKIP)
        public _FinalStage steps(Map<String, WorkflowStepDto> steps) {
            this.steps.clear();
            this.steps.putAll(steps);
            return this;
        }

        /**
         * <p>The name of the workflow.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage name(String name) {
            this.name = Optional.of(name);
            return this;
        }

        @Override
        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public _FinalStage name(Optional<String> name) {
            this.name = name;
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
        public WorkflowDto build() {
            return new WorkflowDto(links, id, name, steps, schemaIds, initial);
        }
    }
}
