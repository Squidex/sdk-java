package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ChangePlanDto.Builder.class)
public final class ChangePlanDto {
    private final String planId;

    private ChangePlanDto(String planId) {
        this.planId = planId;
    }

    /**
     * @return The new plan id. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("planId")
    public String getPlanId() {
        return planId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ChangePlanDto && equalTo((ChangePlanDto) other);
    }

    private boolean equalTo(ChangePlanDto other) {
        return planId.equals(other.planId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.planId);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static PlanIdStage builder() {
        return new Builder();
    }

    public interface PlanIdStage {
        _FinalStage planId(String planId);

        Builder from(ChangePlanDto other);
    }

    public interface _FinalStage {
        ChangePlanDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements PlanIdStage, _FinalStage {
        private String planId;

        private Builder() {}

        @Override
        public Builder from(ChangePlanDto other) {
            planId(other.getPlanId());
            return this;
        }

        /**
         * <p>The new plan id. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("planId")
        public _FinalStage planId(String planId) {
            this.planId = planId;
            return this;
        }

        @Override
        public ChangePlanDto build() {
            return new ChangePlanDto(planId);
        }
    }
}
