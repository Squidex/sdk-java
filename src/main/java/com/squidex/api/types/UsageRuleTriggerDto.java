package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UsageRuleTriggerDto.Builder.class)
public final class UsageRuleTriggerDto {
    private final int limit;

    private final Optional<Integer> numDays;

    private UsageRuleTriggerDto(int limit, Optional<Integer> numDays) {
        this.limit = limit;
        this.numDays = numDays;
    }

    /**
     * @return The number of monthly api calls.
     */
    @JsonProperty("limit")
    public int getLimit() {
        return limit;
    }

    /**
     * @return The number of days to check or null for the current month.
     */
    @JsonProperty("numDays")
    public Optional<Integer> getNumDays() {
        return numDays;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UsageRuleTriggerDto && equalTo((UsageRuleTriggerDto) other);
    }

    private boolean equalTo(UsageRuleTriggerDto other) {
        return limit == other.limit && numDays.equals(other.numDays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.limit, this.numDays);
    }

    @Override
    public String toString() {
        return "UsageRuleTriggerDto{" + "limit: " + limit + ", numDays: " + numDays + "}";
    }

    public static LimitStage builder() {
        return new Builder();
    }

    public interface LimitStage {
        _FinalStage limit(int limit);

        Builder from(UsageRuleTriggerDto other);
    }

    public interface _FinalStage {
        UsageRuleTriggerDto build();

        _FinalStage numDays(Optional<Integer> numDays);

        _FinalStage numDays(Integer numDays);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements LimitStage, _FinalStage {
        private int limit;

        private Optional<Integer> numDays = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(UsageRuleTriggerDto other) {
            limit(other.getLimit());
            numDays(other.getNumDays());
            return this;
        }

        /**
         * <p>The number of monthly api calls.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("limit")
        public _FinalStage limit(int limit) {
            this.limit = limit;
            return this;
        }

        /**
         * <p>The number of days to check or null for the current month.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage numDays(Integer numDays) {
            this.numDays = Optional.of(numDays);
            return this;
        }

        @Override
        @JsonSetter(value = "numDays", nulls = Nulls.SKIP)
        public _FinalStage numDays(Optional<Integer> numDays) {
            this.numDays = numDays;
            return this;
        }

        @Override
        public UsageRuleTriggerDto build() {
            return new UsageRuleTriggerDto(limit, numDays);
        }
    }
}
