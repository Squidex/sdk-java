package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CreateRuleDto.Builder.class)
public final class CreateRuleDto {
    private final RuleTriggerDto trigger;

    private final RuleActionDto action;

    private CreateRuleDto(RuleTriggerDto trigger, RuleActionDto action) {
        this.trigger = trigger;
        this.action = action;
    }

    @JsonProperty("trigger")
    public RuleTriggerDto getTrigger() {
        return trigger;
    }

    @JsonProperty("action")
    public RuleActionDto getAction() {
        return action;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateRuleDto && equalTo((CreateRuleDto) other);
    }

    private boolean equalTo(CreateRuleDto other) {
        return trigger.equals(other.trigger) && action.equals(other.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.trigger, this.action);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TriggerStage builder() {
        return new Builder();
    }

    public interface TriggerStage {
        ActionStage trigger(RuleTriggerDto trigger);

        Builder from(CreateRuleDto other);
    }

    public interface ActionStage {
        _FinalStage action(RuleActionDto action);
    }

    public interface _FinalStage {
        CreateRuleDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TriggerStage, ActionStage, _FinalStage {
        private RuleTriggerDto trigger;

        private RuleActionDto action;

        private Builder() {}

        @Override
        public Builder from(CreateRuleDto other) {
            trigger(other.getTrigger());
            action(other.getAction());
            return this;
        }

        @Override
        @JsonSetter("trigger")
        public ActionStage trigger(RuleTriggerDto trigger) {
            this.trigger = trigger;
            return this;
        }

        @Override
        @JsonSetter("action")
        public _FinalStage action(RuleActionDto action) {
            this.action = action;
            return this;
        }

        @Override
        public CreateRuleDto build() {
            return new CreateRuleDto(trigger, action);
        }
    }
}
