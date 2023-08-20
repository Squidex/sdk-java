package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = WorkflowStepDto.Builder.class)
public final class WorkflowStepDto {
    private final Optional<Map<String, WorkflowTransitionDto>> transitions;

    private final Optional<String> color;

    private final Optional<Boolean> validate;

    private final Optional<Boolean> noUpdate;

    private final Optional<String> noUpdateExpression;

    private final Optional<List<String>> noUpdateRoles;

    private WorkflowStepDto(
            Optional<Map<String, WorkflowTransitionDto>> transitions,
            Optional<String> color,
            Optional<Boolean> validate,
            Optional<Boolean> noUpdate,
            Optional<String> noUpdateExpression,
            Optional<List<String>> noUpdateRoles) {
        this.transitions = transitions;
        this.color = color;
        this.validate = validate;
        this.noUpdate = noUpdate;
        this.noUpdateExpression = noUpdateExpression;
        this.noUpdateRoles = noUpdateRoles;
    }

    /**
     * @return The transitions.
     */
    @JsonProperty("transitions")
    public Optional<Map<String, WorkflowTransitionDto>> getTransitions() {
        return transitions;
    }

    /**
     * @return The optional color.
     */
    @JsonProperty("color")
    public Optional<String> getColor() {
        return color;
    }

    /**
     * @return True if the content should be validated when moving to this step.
     */
    @JsonProperty("validate")
    public Optional<Boolean> getValidate() {
        return validate;
    }

    /**
     * @return Indicates if updates should not be allowed.
     */
    @JsonProperty("noUpdate")
    public Optional<Boolean> getNoUpdate() {
        return noUpdate;
    }

    /**
     * @return Optional expression that must evaluate to true when you want to prevent updates.
     */
    @JsonProperty("noUpdateExpression")
    public Optional<String> getNoUpdateExpression() {
        return noUpdateExpression;
    }

    /**
     * @return Optional list of roles to restrict the updates for users with these roles.
     */
    @JsonProperty("noUpdateRoles")
    public Optional<List<String>> getNoUpdateRoles() {
        return noUpdateRoles;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof WorkflowStepDto && equalTo((WorkflowStepDto) other);
    }

    private boolean equalTo(WorkflowStepDto other) {
        return transitions.equals(other.transitions)
                && color.equals(other.color)
                && validate.equals(other.validate)
                && noUpdate.equals(other.noUpdate)
                && noUpdateExpression.equals(other.noUpdateExpression)
                && noUpdateRoles.equals(other.noUpdateRoles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.transitions,
                this.color,
                this.validate,
                this.noUpdate,
                this.noUpdateExpression,
                this.noUpdateRoles);
    }

    @Override
    public String toString() {
        return "WorkflowStepDto{" + "transitions: " + transitions + ", color: " + color + ", validate: " + validate
                + ", noUpdate: " + noUpdate + ", noUpdateExpression: " + noUpdateExpression + ", noUpdateRoles: "
                + noUpdateRoles + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Map<String, WorkflowTransitionDto>> transitions = Optional.empty();

        private Optional<String> color = Optional.empty();

        private Optional<Boolean> validate = Optional.empty();

        private Optional<Boolean> noUpdate = Optional.empty();

        private Optional<String> noUpdateExpression = Optional.empty();

        private Optional<List<String>> noUpdateRoles = Optional.empty();

        private Builder() {}

        public Builder from(WorkflowStepDto other) {
            transitions(other.getTransitions());
            color(other.getColor());
            validate(other.getValidate());
            noUpdate(other.getNoUpdate());
            noUpdateExpression(other.getNoUpdateExpression());
            noUpdateRoles(other.getNoUpdateRoles());
            return this;
        }

        @JsonSetter(value = "transitions", nulls = Nulls.SKIP)
        public Builder transitions(Optional<Map<String, WorkflowTransitionDto>> transitions) {
            this.transitions = transitions;
            return this;
        }

        public Builder transitions(Map<String, WorkflowTransitionDto> transitions) {
            this.transitions = Optional.of(transitions);
            return this;
        }

        @JsonSetter(value = "color", nulls = Nulls.SKIP)
        public Builder color(Optional<String> color) {
            this.color = color;
            return this;
        }

        public Builder color(String color) {
            this.color = Optional.of(color);
            return this;
        }

        @JsonSetter(value = "validate", nulls = Nulls.SKIP)
        public Builder validate(Optional<Boolean> validate) {
            this.validate = validate;
            return this;
        }

        public Builder validate(Boolean validate) {
            this.validate = Optional.of(validate);
            return this;
        }

        @JsonSetter(value = "noUpdate", nulls = Nulls.SKIP)
        public Builder noUpdate(Optional<Boolean> noUpdate) {
            this.noUpdate = noUpdate;
            return this;
        }

        public Builder noUpdate(Boolean noUpdate) {
            this.noUpdate = Optional.of(noUpdate);
            return this;
        }

        @JsonSetter(value = "noUpdateExpression", nulls = Nulls.SKIP)
        public Builder noUpdateExpression(Optional<String> noUpdateExpression) {
            this.noUpdateExpression = noUpdateExpression;
            return this;
        }

        public Builder noUpdateExpression(String noUpdateExpression) {
            this.noUpdateExpression = Optional.of(noUpdateExpression);
            return this;
        }

        @JsonSetter(value = "noUpdateRoles", nulls = Nulls.SKIP)
        public Builder noUpdateRoles(Optional<List<String>> noUpdateRoles) {
            this.noUpdateRoles = noUpdateRoles;
            return this;
        }

        public Builder noUpdateRoles(List<String> noUpdateRoles) {
            this.noUpdateRoles = Optional.of(noUpdateRoles);
            return this;
        }

        public WorkflowStepDto build() {
            return new WorkflowStepDto(transitions, color, validate, noUpdate, noUpdateExpression, noUpdateRoles);
        }
    }
}
