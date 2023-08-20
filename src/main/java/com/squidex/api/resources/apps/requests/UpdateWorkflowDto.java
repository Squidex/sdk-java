package com.squidex.api.resources.apps.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.types.WorkflowStepDto;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UpdateWorkflowDto.Builder.class)
public final class UpdateWorkflowDto {
    private final Optional<String> name;

    private final Map<String, WorkflowStepDto> steps;

    private final Optional<List<String>> schemaIds;

    private final String initial;

    private UpdateWorkflowDto(
            Optional<String> name,
            Map<String, WorkflowStepDto> steps,
            Optional<List<String>> schemaIds,
            String initial) {
        this.name = name;
        this.steps = steps;
        this.schemaIds = schemaIds;
        this.initial = initial;
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
     * @return The initial step. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("initial")
    public String getInitial() {
        return initial;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdateWorkflowDto && equalTo((UpdateWorkflowDto) other);
    }

    private boolean equalTo(UpdateWorkflowDto other) {
        return name.equals(other.name)
                && steps.equals(other.steps)
                && schemaIds.equals(other.schemaIds)
                && initial.equals(other.initial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.steps, this.schemaIds, this.initial);
    }

    @Override
    public String toString() {
        return "UpdateWorkflowDto{" + "name: " + name + ", steps: " + steps + ", schemaIds: " + schemaIds
                + ", initial: " + initial + "}";
    }

    public static InitialStage builder() {
        return new Builder();
    }

    public interface InitialStage {
        _FinalStage initial(String initial);

        Builder from(UpdateWorkflowDto other);
    }

    public interface _FinalStage {
        UpdateWorkflowDto build();

        _FinalStage name(Optional<String> name);

        _FinalStage name(String name);

        _FinalStage steps(Map<String, WorkflowStepDto> steps);

        _FinalStage putAllSteps(Map<String, WorkflowStepDto> steps);

        _FinalStage steps(String key, WorkflowStepDto value);

        _FinalStage schemaIds(Optional<List<String>> schemaIds);

        _FinalStage schemaIds(List<String> schemaIds);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements InitialStage, _FinalStage {
        private String initial;

        private Optional<List<String>> schemaIds = Optional.empty();

        private Map<String, WorkflowStepDto> steps = new LinkedHashMap<>();

        private Optional<String> name = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(UpdateWorkflowDto other) {
            name(other.getName());
            steps(other.getSteps());
            schemaIds(other.getSchemaIds());
            initial(other.getInitial());
            return this;
        }

        /**
         * <p>The initial step. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
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

        @Override
        public UpdateWorkflowDto build() {
            return new UpdateWorkflowDto(name, steps, schemaIds, initial);
        }
    }
}
