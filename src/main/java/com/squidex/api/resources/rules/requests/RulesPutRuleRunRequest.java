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
@JsonDeserialize(builder = RulesPutRuleRunRequest.Builder.class)
public final class RulesPutRuleRunRequest {
    private final Optional<Boolean> fromSnapshots;

    private RulesPutRuleRunRequest(Optional<Boolean> fromSnapshots) {
        this.fromSnapshots = fromSnapshots;
    }

    /**
     * @return Runs the rule from snapeshots if possible.
     */
    @JsonProperty("fromSnapshots")
    public Optional<Boolean> getFromSnapshots() {
        return fromSnapshots;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RulesPutRuleRunRequest && equalTo((RulesPutRuleRunRequest) other);
    }

    private boolean equalTo(RulesPutRuleRunRequest other) {
        return fromSnapshots.equals(other.fromSnapshots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fromSnapshots);
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
        private Optional<Boolean> fromSnapshots = Optional.empty();

        private Builder() {}

        public Builder from(RulesPutRuleRunRequest other) {
            fromSnapshots(other.getFromSnapshots());
            return this;
        }

        @JsonSetter(value = "fromSnapshots", nulls = Nulls.SKIP)
        public Builder fromSnapshots(Optional<Boolean> fromSnapshots) {
            this.fromSnapshots = fromSnapshots;
            return this;
        }

        public Builder fromSnapshots(Boolean fromSnapshots) {
            this.fromSnapshots = Optional.of(fromSnapshots);
            return this;
        }

        public RulesPutRuleRunRequest build() {
            return new RulesPutRuleRunRequest(fromSnapshots);
        }
    }
}
