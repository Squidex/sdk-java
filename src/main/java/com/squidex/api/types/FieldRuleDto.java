package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = FieldRuleDto.Builder.class)
public final class FieldRuleDto {
    private final FieldRuleAction action;

    private final String field;

    private final Optional<String> condition;

    private FieldRuleDto(FieldRuleAction action, String field, Optional<String> condition) {
        this.action = action;
        this.field = field;
        this.condition = condition;
    }

    @JsonProperty("action")
    public FieldRuleAction getAction() {
        return action;
    }

    /**
     * @return The field to update. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("field")
    public String getField() {
        return field;
    }

    /**
     * @return The condition.
     */
    @JsonProperty("condition")
    public Optional<String> getCondition() {
        return condition;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof FieldRuleDto && equalTo((FieldRuleDto) other);
    }

    private boolean equalTo(FieldRuleDto other) {
        return action.equals(other.action) && field.equals(other.field) && condition.equals(other.condition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.action, this.field, this.condition);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ActionStage builder() {
        return new Builder();
    }

    public interface ActionStage {
        FieldStage action(FieldRuleAction action);

        Builder from(FieldRuleDto other);
    }

    public interface FieldStage {
        _FinalStage field(String field);
    }

    public interface _FinalStage {
        FieldRuleDto build();

        _FinalStage condition(Optional<String> condition);

        _FinalStage condition(String condition);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ActionStage, FieldStage, _FinalStage {
        private FieldRuleAction action;

        private String field;

        private Optional<String> condition = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(FieldRuleDto other) {
            action(other.getAction());
            field(other.getField());
            condition(other.getCondition());
            return this;
        }

        @Override
        @JsonSetter("action")
        public FieldStage action(FieldRuleAction action) {
            this.action = action;
            return this;
        }

        /**
         * <p>The field to update. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("field")
        public _FinalStage field(String field) {
            this.field = field;
            return this;
        }

        /**
         * <p>The condition.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage condition(String condition) {
            this.condition = Optional.of(condition);
            return this;
        }

        @Override
        @JsonSetter(value = "condition", nulls = Nulls.SKIP)
        public _FinalStage condition(Optional<String> condition) {
            this.condition = condition;
            return this;
        }

        @Override
        public FieldRuleDto build() {
            return new FieldRuleDto(action, field, condition);
        }
    }
}
