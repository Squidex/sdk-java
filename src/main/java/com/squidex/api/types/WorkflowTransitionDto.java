package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = WorkflowTransitionDto.Builder.class)
public final class WorkflowTransitionDto {
    private final Optional<String> expression;

    private final Optional<List<String>> roles;

    private WorkflowTransitionDto(Optional<String> expression, Optional<List<String>> roles) {
        this.expression = expression;
        this.roles = roles;
    }

    /**
     * @return The optional expression.
     */
    @JsonProperty("expression")
    public Optional<String> getExpression() {
        return expression;
    }

    /**
     * @return The optional restricted role.
     */
    @JsonProperty("roles")
    public Optional<List<String>> getRoles() {
        return roles;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof WorkflowTransitionDto && equalTo((WorkflowTransitionDto) other);
    }

    private boolean equalTo(WorkflowTransitionDto other) {
        return expression.equals(other.expression) && roles.equals(other.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.expression, this.roles);
    }

    @Override
    public String toString() {
        return "WorkflowTransitionDto{" + "expression: " + expression + ", roles: " + roles + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> expression = Optional.empty();

        private Optional<List<String>> roles = Optional.empty();

        private Builder() {}

        public Builder from(WorkflowTransitionDto other) {
            expression(other.getExpression());
            roles(other.getRoles());
            return this;
        }

        @JsonSetter(value = "expression", nulls = Nulls.SKIP)
        public Builder expression(Optional<String> expression) {
            this.expression = expression;
            return this;
        }

        public Builder expression(String expression) {
            this.expression = Optional.of(expression);
            return this;
        }

        @JsonSetter(value = "roles", nulls = Nulls.SKIP)
        public Builder roles(Optional<List<String>> roles) {
            this.roles = roles;
            return this;
        }

        public Builder roles(List<String> roles) {
            this.roles = Optional.of(roles);
            return this;
        }

        public WorkflowTransitionDto build() {
            return new WorkflowTransitionDto(expression, roles);
        }
    }
}
