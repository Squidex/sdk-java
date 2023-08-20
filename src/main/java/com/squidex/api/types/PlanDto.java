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
@JsonDeserialize(builder = PlanDto.Builder.class)
public final class PlanDto {
    private final String id;

    private final String name;

    private final String costs;

    private final Optional<String> confirmText;

    private final Optional<String> yearlyConfirmText;

    private final Optional<String> yearlyCosts;

    private final Optional<String> yearlyId;

    private final int maxApiBytes;

    private final int maxApiCalls;

    private final int maxAssetSize;

    private final int maxContributors;

    private PlanDto(
            String id,
            String name,
            String costs,
            Optional<String> confirmText,
            Optional<String> yearlyConfirmText,
            Optional<String> yearlyCosts,
            Optional<String> yearlyId,
            int maxApiBytes,
            int maxApiCalls,
            int maxAssetSize,
            int maxContributors) {
        this.id = id;
        this.name = name;
        this.costs = costs;
        this.confirmText = confirmText;
        this.yearlyConfirmText = yearlyConfirmText;
        this.yearlyCosts = yearlyCosts;
        this.yearlyId = yearlyId;
        this.maxApiBytes = maxApiBytes;
        this.maxApiCalls = maxApiCalls;
        this.maxAssetSize = maxAssetSize;
        this.maxContributors = maxContributors;
    }

    /**
     * @return The ID of the plan.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The name of the plan.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @return The monthly costs of the plan.
     */
    @JsonProperty("costs")
    public String getCosts() {
        return costs;
    }

    /**
     * @return An optional confirm text for the monthly subscription.
     */
    @JsonProperty("confirmText")
    public Optional<String> getConfirmText() {
        return confirmText;
    }

    /**
     * @return An optional confirm text for the yearly subscription.
     */
    @JsonProperty("yearlyConfirmText")
    public Optional<String> getYearlyConfirmText() {
        return yearlyConfirmText;
    }

    /**
     * @return The yearly costs of the plan.
     */
    @JsonProperty("yearlyCosts")
    public Optional<String> getYearlyCosts() {
        return yearlyCosts;
    }

    /**
     * @return The yearly ID of the plan.
     */
    @JsonProperty("yearlyId")
    public Optional<String> getYearlyId() {
        return yearlyId;
    }

    /**
     * @return The maximum number of API traffic.
     */
    @JsonProperty("maxApiBytes")
    public int getMaxApiBytes() {
        return maxApiBytes;
    }

    /**
     * @return The maximum number of API calls.
     */
    @JsonProperty("maxApiCalls")
    public int getMaxApiCalls() {
        return maxApiCalls;
    }

    /**
     * @return The maximum allowed asset size.
     */
    @JsonProperty("maxAssetSize")
    public int getMaxAssetSize() {
        return maxAssetSize;
    }

    /**
     * @return The maximum number of contributors.
     */
    @JsonProperty("maxContributors")
    public int getMaxContributors() {
        return maxContributors;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PlanDto && equalTo((PlanDto) other);
    }

    private boolean equalTo(PlanDto other) {
        return id.equals(other.id)
                && name.equals(other.name)
                && costs.equals(other.costs)
                && confirmText.equals(other.confirmText)
                && yearlyConfirmText.equals(other.yearlyConfirmText)
                && yearlyCosts.equals(other.yearlyCosts)
                && yearlyId.equals(other.yearlyId)
                && maxApiBytes == other.maxApiBytes
                && maxApiCalls == other.maxApiCalls
                && maxAssetSize == other.maxAssetSize
                && maxContributors == other.maxContributors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.name,
                this.costs,
                this.confirmText,
                this.yearlyConfirmText,
                this.yearlyCosts,
                this.yearlyId,
                this.maxApiBytes,
                this.maxApiCalls,
                this.maxAssetSize,
                this.maxContributors);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        NameStage id(String id);

        Builder from(PlanDto other);
    }

    public interface NameStage {
        CostsStage name(String name);
    }

    public interface CostsStage {
        MaxApiBytesStage costs(String costs);
    }

    public interface MaxApiBytesStage {
        MaxApiCallsStage maxApiBytes(int maxApiBytes);
    }

    public interface MaxApiCallsStage {
        MaxAssetSizeStage maxApiCalls(int maxApiCalls);
    }

    public interface MaxAssetSizeStage {
        MaxContributorsStage maxAssetSize(int maxAssetSize);
    }

    public interface MaxContributorsStage {
        _FinalStage maxContributors(int maxContributors);
    }

    public interface _FinalStage {
        PlanDto build();

        _FinalStage confirmText(Optional<String> confirmText);

        _FinalStage confirmText(String confirmText);

        _FinalStage yearlyConfirmText(Optional<String> yearlyConfirmText);

        _FinalStage yearlyConfirmText(String yearlyConfirmText);

        _FinalStage yearlyCosts(Optional<String> yearlyCosts);

        _FinalStage yearlyCosts(String yearlyCosts);

        _FinalStage yearlyId(Optional<String> yearlyId);

        _FinalStage yearlyId(String yearlyId);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements IdStage,
                    NameStage,
                    CostsStage,
                    MaxApiBytesStage,
                    MaxApiCallsStage,
                    MaxAssetSizeStage,
                    MaxContributorsStage,
                    _FinalStage {
        private String id;

        private String name;

        private String costs;

        private int maxApiBytes;

        private int maxApiCalls;

        private int maxAssetSize;

        private int maxContributors;

        private Optional<String> yearlyId = Optional.empty();

        private Optional<String> yearlyCosts = Optional.empty();

        private Optional<String> yearlyConfirmText = Optional.empty();

        private Optional<String> confirmText = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(PlanDto other) {
            id(other.getId());
            name(other.getName());
            costs(other.getCosts());
            confirmText(other.getConfirmText());
            yearlyConfirmText(other.getYearlyConfirmText());
            yearlyCosts(other.getYearlyCosts());
            yearlyId(other.getYearlyId());
            maxApiBytes(other.getMaxApiBytes());
            maxApiCalls(other.getMaxApiCalls());
            maxAssetSize(other.getMaxAssetSize());
            maxContributors(other.getMaxContributors());
            return this;
        }

        /**
         * <p>The ID of the plan.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("id")
        public NameStage id(String id) {
            this.id = id;
            return this;
        }

        /**
         * <p>The name of the plan.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name")
        public CostsStage name(String name) {
            this.name = name;
            return this;
        }

        /**
         * <p>The monthly costs of the plan.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("costs")
        public MaxApiBytesStage costs(String costs) {
            this.costs = costs;
            return this;
        }

        /**
         * <p>The maximum number of API traffic.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("maxApiBytes")
        public MaxApiCallsStage maxApiBytes(int maxApiBytes) {
            this.maxApiBytes = maxApiBytes;
            return this;
        }

        /**
         * <p>The maximum number of API calls.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("maxApiCalls")
        public MaxAssetSizeStage maxApiCalls(int maxApiCalls) {
            this.maxApiCalls = maxApiCalls;
            return this;
        }

        /**
         * <p>The maximum allowed asset size.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("maxAssetSize")
        public MaxContributorsStage maxAssetSize(int maxAssetSize) {
            this.maxAssetSize = maxAssetSize;
            return this;
        }

        /**
         * <p>The maximum number of contributors.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("maxContributors")
        public _FinalStage maxContributors(int maxContributors) {
            this.maxContributors = maxContributors;
            return this;
        }

        /**
         * <p>The yearly ID of the plan.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage yearlyId(String yearlyId) {
            this.yearlyId = Optional.of(yearlyId);
            return this;
        }

        @Override
        @JsonSetter(value = "yearlyId", nulls = Nulls.SKIP)
        public _FinalStage yearlyId(Optional<String> yearlyId) {
            this.yearlyId = yearlyId;
            return this;
        }

        /**
         * <p>The yearly costs of the plan.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage yearlyCosts(String yearlyCosts) {
            this.yearlyCosts = Optional.of(yearlyCosts);
            return this;
        }

        @Override
        @JsonSetter(value = "yearlyCosts", nulls = Nulls.SKIP)
        public _FinalStage yearlyCosts(Optional<String> yearlyCosts) {
            this.yearlyCosts = yearlyCosts;
            return this;
        }

        /**
         * <p>An optional confirm text for the yearly subscription.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage yearlyConfirmText(String yearlyConfirmText) {
            this.yearlyConfirmText = Optional.of(yearlyConfirmText);
            return this;
        }

        @Override
        @JsonSetter(value = "yearlyConfirmText", nulls = Nulls.SKIP)
        public _FinalStage yearlyConfirmText(Optional<String> yearlyConfirmText) {
            this.yearlyConfirmText = yearlyConfirmText;
            return this;
        }

        /**
         * <p>An optional confirm text for the monthly subscription.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage confirmText(String confirmText) {
            this.confirmText = Optional.of(confirmText);
            return this;
        }

        @Override
        @JsonSetter(value = "confirmText", nulls = Nulls.SKIP)
        public _FinalStage confirmText(Optional<String> confirmText) {
            this.confirmText = confirmText;
            return this;
        }

        @Override
        public PlanDto build() {
            return new PlanDto(
                    id,
                    name,
                    costs,
                    confirmText,
                    yearlyConfirmText,
                    yearlyCosts,
                    yearlyId,
                    maxApiBytes,
                    maxApiCalls,
                    maxAssetSize,
                    maxContributors);
        }
    }
}
