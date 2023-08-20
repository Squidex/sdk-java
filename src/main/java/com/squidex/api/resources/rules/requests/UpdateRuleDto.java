package com.squidex.api.resources.rules.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.types.RuleActionDto;
import com.squidex.api.types.RuleTriggerDto;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UpdateRuleDto.Builder.class)
public final class UpdateRuleDto {
    private final Optional<String> name;

    private final Optional<RuleTriggerDto> trigger;

    private final Optional<RuleActionDto> action;

    private final Optional<Boolean> isEnabled;

    private UpdateRuleDto(
            Optional<String> name,
            Optional<RuleTriggerDto> trigger,
            Optional<RuleActionDto> action,
            Optional<Boolean> isEnabled) {
        this.name = name;
        this.trigger = trigger;
        this.action = action;
        this.isEnabled = isEnabled;
    }

    /**
     * @return Optional rule name.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    @JsonProperty("trigger")
    public Optional<RuleTriggerDto> getTrigger() {
        return trigger;
    }

    @JsonProperty("action")
    public Optional<RuleActionDto> getAction() {
        return action;
    }

    /**
     * @return Enable or disable the rule.
     */
    @JsonProperty("isEnabled")
    public Optional<Boolean> getIsEnabled() {
        return isEnabled;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdateRuleDto && equalTo((UpdateRuleDto) other);
    }

    private boolean equalTo(UpdateRuleDto other) {
        return name.equals(other.name)
                && trigger.equals(other.trigger)
                && action.equals(other.action)
                && isEnabled.equals(other.isEnabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.trigger, this.action, this.isEnabled);
    }

    @Override
    public String toString() {
        return "UpdateRuleDto{" + "name: " + name + ", trigger: " + trigger + ", action: " + action + ", isEnabled: "
                + isEnabled + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> name = Optional.empty();

        private Optional<RuleTriggerDto> trigger = Optional.empty();

        private Optional<RuleActionDto> action = Optional.empty();

        private Optional<Boolean> isEnabled = Optional.empty();

        private Builder() {}

        public Builder from(UpdateRuleDto other) {
            name(other.getName());
            trigger(other.getTrigger());
            action(other.getAction());
            isEnabled(other.getIsEnabled());
            return this;
        }

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.of(name);
            return this;
        }

        @JsonSetter(value = "trigger", nulls = Nulls.SKIP)
        public Builder trigger(Optional<RuleTriggerDto> trigger) {
            this.trigger = trigger;
            return this;
        }

        public Builder trigger(RuleTriggerDto trigger) {
            this.trigger = Optional.of(trigger);
            return this;
        }

        @JsonSetter(value = "action", nulls = Nulls.SKIP)
        public Builder action(Optional<RuleActionDto> action) {
            this.action = action;
            return this;
        }

        public Builder action(RuleActionDto action) {
            this.action = Optional.of(action);
            return this;
        }

        @JsonSetter(value = "isEnabled", nulls = Nulls.SKIP)
        public Builder isEnabled(Optional<Boolean> isEnabled) {
            this.isEnabled = isEnabled;
            return this;
        }

        public Builder isEnabled(Boolean isEnabled) {
            this.isEnabled = Optional.of(isEnabled);
            return this;
        }

        public UpdateRuleDto build() {
            return new UpdateRuleDto(name, trigger, action, isEnabled);
        }
    }
}
