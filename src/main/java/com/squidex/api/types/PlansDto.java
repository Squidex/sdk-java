package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = PlansDto.Builder.class)
public final class PlansDto {
    private final List<PlanDto> plans;

    private final Optional<String> currentPlanId;

    private final Optional<String> planOwner;

    private final Optional<String> portalLink;

    private final Optional<ReferralInfo> referral;

    private final PlansLockedReason locked;

    private PlansDto(
            List<PlanDto> plans,
            Optional<String> currentPlanId,
            Optional<String> planOwner,
            Optional<String> portalLink,
            Optional<ReferralInfo> referral,
            PlansLockedReason locked) {
        this.plans = plans;
        this.currentPlanId = currentPlanId;
        this.planOwner = planOwner;
        this.portalLink = portalLink;
        this.referral = referral;
        this.locked = locked;
    }

    /**
     * @return The available plans.
     */
    @JsonProperty("plans")
    public List<PlanDto> getPlans() {
        return plans;
    }

    /**
     * @return The current plan id.
     */
    @JsonProperty("currentPlanId")
    public Optional<String> getCurrentPlanId() {
        return currentPlanId;
    }

    /**
     * @return The plan owner.
     */
    @JsonProperty("planOwner")
    public Optional<String> getPlanOwner() {
        return planOwner;
    }

    /**
     * @return The link to the management portal.
     */
    @JsonProperty("portalLink")
    public Optional<String> getPortalLink() {
        return portalLink;
    }

    @JsonProperty("referral")
    public Optional<ReferralInfo> getReferral() {
        return referral;
    }

    @JsonProperty("locked")
    public PlansLockedReason getLocked() {
        return locked;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PlansDto && equalTo((PlansDto) other);
    }

    private boolean equalTo(PlansDto other) {
        return plans.equals(other.plans)
                && currentPlanId.equals(other.currentPlanId)
                && planOwner.equals(other.planOwner)
                && portalLink.equals(other.portalLink)
                && referral.equals(other.referral)
                && locked.equals(other.locked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.plans, this.currentPlanId, this.planOwner, this.portalLink, this.referral, this.locked);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static LockedStage builder() {
        return new Builder();
    }

    public interface LockedStage {
        _FinalStage locked(PlansLockedReason locked);

        Builder from(PlansDto other);
    }

    public interface _FinalStage {
        PlansDto build();

        _FinalStage plans(List<PlanDto> plans);

        _FinalStage addPlans(PlanDto plans);

        _FinalStage addAllPlans(List<PlanDto> plans);

        _FinalStage currentPlanId(Optional<String> currentPlanId);

        _FinalStage currentPlanId(String currentPlanId);

        _FinalStage planOwner(Optional<String> planOwner);

        _FinalStage planOwner(String planOwner);

        _FinalStage portalLink(Optional<String> portalLink);

        _FinalStage portalLink(String portalLink);

        _FinalStage referral(Optional<ReferralInfo> referral);

        _FinalStage referral(ReferralInfo referral);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements LockedStage, _FinalStage {
        private PlansLockedReason locked;

        private Optional<ReferralInfo> referral = Optional.empty();

        private Optional<String> portalLink = Optional.empty();

        private Optional<String> planOwner = Optional.empty();

        private Optional<String> currentPlanId = Optional.empty();

        private List<PlanDto> plans = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(PlansDto other) {
            plans(other.getPlans());
            currentPlanId(other.getCurrentPlanId());
            planOwner(other.getPlanOwner());
            portalLink(other.getPortalLink());
            referral(other.getReferral());
            locked(other.getLocked());
            return this;
        }

        @Override
        @JsonSetter("locked")
        public _FinalStage locked(PlansLockedReason locked) {
            this.locked = locked;
            return this;
        }

        @Override
        public _FinalStage referral(ReferralInfo referral) {
            this.referral = Optional.of(referral);
            return this;
        }

        @Override
        @JsonSetter(value = "referral", nulls = Nulls.SKIP)
        public _FinalStage referral(Optional<ReferralInfo> referral) {
            this.referral = referral;
            return this;
        }

        /**
         * <p>The link to the management portal.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage portalLink(String portalLink) {
            this.portalLink = Optional.of(portalLink);
            return this;
        }

        @Override
        @JsonSetter(value = "portalLink", nulls = Nulls.SKIP)
        public _FinalStage portalLink(Optional<String> portalLink) {
            this.portalLink = portalLink;
            return this;
        }

        /**
         * <p>The plan owner.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage planOwner(String planOwner) {
            this.planOwner = Optional.of(planOwner);
            return this;
        }

        @Override
        @JsonSetter(value = "planOwner", nulls = Nulls.SKIP)
        public _FinalStage planOwner(Optional<String> planOwner) {
            this.planOwner = planOwner;
            return this;
        }

        /**
         * <p>The current plan id.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage currentPlanId(String currentPlanId) {
            this.currentPlanId = Optional.of(currentPlanId);
            return this;
        }

        @Override
        @JsonSetter(value = "currentPlanId", nulls = Nulls.SKIP)
        public _FinalStage currentPlanId(Optional<String> currentPlanId) {
            this.currentPlanId = currentPlanId;
            return this;
        }

        /**
         * <p>The available plans.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllPlans(List<PlanDto> plans) {
            this.plans.addAll(plans);
            return this;
        }

        /**
         * <p>The available plans.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addPlans(PlanDto plans) {
            this.plans.add(plans);
            return this;
        }

        @Override
        @JsonSetter(value = "plans", nulls = Nulls.SKIP)
        public _FinalStage plans(List<PlanDto> plans) {
            this.plans.clear();
            this.plans.addAll(plans);
            return this;
        }

        @Override
        public PlansDto build() {
            return new PlansDto(plans, currentPlanId, planOwner, portalLink, referral, locked);
        }
    }
}
