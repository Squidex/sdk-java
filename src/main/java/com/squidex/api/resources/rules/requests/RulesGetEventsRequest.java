package com.squidex.api.resources.rules.requests;

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
@JsonDeserialize(builder = RulesGetEventsRequest.Builder.class)
public final class RulesGetEventsRequest {
    private final Optional<String> ruleId;

    private final Optional<Integer> skip;

    private final Optional<Integer> take;

    private RulesGetEventsRequest(Optional<String> ruleId, Optional<Integer> skip, Optional<Integer> take) {
        this.ruleId = ruleId;
        this.skip = skip;
        this.take = take;
    }

    /**
     * @return The optional rule id to filter to events.
     */
    @JsonProperty("ruleId")
    public Optional<String> getRuleId() {
        return ruleId;
    }

    /**
     * @return The number of events to skip.
     */
    @JsonProperty("skip")
    public Optional<Integer> getSkip() {
        return skip;
    }

    /**
     * @return The number of events to take.
     */
    @JsonProperty("take")
    public Optional<Integer> getTake() {
        return take;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RulesGetEventsRequest && equalTo((RulesGetEventsRequest) other);
    }

    private boolean equalTo(RulesGetEventsRequest other) {
        return ruleId.equals(other.ruleId) && skip.equals(other.skip) && take.equals(other.take);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.ruleId, this.skip, this.take);
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
        private Optional<String> ruleId = Optional.empty();

        private Optional<Integer> skip = Optional.empty();

        private Optional<Integer> take = Optional.empty();

        private Builder() {}

        public Builder from(RulesGetEventsRequest other) {
            ruleId(other.getRuleId());
            skip(other.getSkip());
            take(other.getTake());
            return this;
        }

        @JsonSetter(value = "ruleId", nulls = Nulls.SKIP)
        public Builder ruleId(Optional<String> ruleId) {
            this.ruleId = ruleId;
            return this;
        }

        public Builder ruleId(String ruleId) {
            this.ruleId = Optional.of(ruleId);
            return this;
        }

        @JsonSetter(value = "skip", nulls = Nulls.SKIP)
        public Builder skip(Optional<Integer> skip) {
            this.skip = skip;
            return this;
        }

        public Builder skip(Integer skip) {
            this.skip = Optional.of(skip);
            return this;
        }

        @JsonSetter(value = "take", nulls = Nulls.SKIP)
        public Builder take(Optional<Integer> take) {
            this.take = take;
            return this;
        }

        public Builder take(Integer take) {
            this.take = Optional.of(take);
            return this;
        }

        public RulesGetEventsRequest build() {
            return new RulesGetEventsRequest(ruleId, skip, take);
        }
    }
}
