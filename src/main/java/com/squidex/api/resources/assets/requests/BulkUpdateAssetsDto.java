package com.squidex.api.resources.assets.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.types.BulkUpdateAssetsJobDto;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = BulkUpdateAssetsDto.Builder.class)
public final class BulkUpdateAssetsDto {
    private final Optional<List<BulkUpdateAssetsJobDto>> jobs;

    private final Optional<Boolean> checkReferrers;

    private final Optional<Boolean> optimizeValidation;

    private final Optional<Boolean> doNotScript;

    private BulkUpdateAssetsDto(
            Optional<List<BulkUpdateAssetsJobDto>> jobs,
            Optional<Boolean> checkReferrers,
            Optional<Boolean> optimizeValidation,
            Optional<Boolean> doNotScript) {
        this.jobs = jobs;
        this.checkReferrers = checkReferrers;
        this.optimizeValidation = optimizeValidation;
        this.doNotScript = doNotScript;
    }

    /**
     * @return The contents to update or insert.
     */
    @JsonProperty("jobs")
    public Optional<List<BulkUpdateAssetsJobDto>> getJobs() {
        return jobs;
    }

    /**
     * @return True to check referrers of deleted assets.
     */
    @JsonProperty("checkReferrers")
    public Optional<Boolean> getCheckReferrers() {
        return checkReferrers;
    }

    /**
     * @return True to turn off costly validation: Folder checks. Default: true.
     */
    @JsonProperty("optimizeValidation")
    public Optional<Boolean> getOptimizeValidation() {
        return optimizeValidation;
    }

    /**
     * @return True to turn off scripting for faster inserts. Default: true.
     */
    @JsonProperty("doNotScript")
    public Optional<Boolean> getDoNotScript() {
        return doNotScript;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BulkUpdateAssetsDto && equalTo((BulkUpdateAssetsDto) other);
    }

    private boolean equalTo(BulkUpdateAssetsDto other) {
        return jobs.equals(other.jobs)
                && checkReferrers.equals(other.checkReferrers)
                && optimizeValidation.equals(other.optimizeValidation)
                && doNotScript.equals(other.doNotScript);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.jobs, this.checkReferrers, this.optimizeValidation, this.doNotScript);
    }

    @Override
    public String toString() {
        return "BulkUpdateAssetsDto{" + "jobs: " + jobs + ", checkReferrers: " + checkReferrers
                + ", optimizeValidation: " + optimizeValidation + ", doNotScript: " + doNotScript + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<List<BulkUpdateAssetsJobDto>> jobs = Optional.empty();

        private Optional<Boolean> checkReferrers = Optional.empty();

        private Optional<Boolean> optimizeValidation = Optional.empty();

        private Optional<Boolean> doNotScript = Optional.empty();

        private Builder() {}

        public Builder from(BulkUpdateAssetsDto other) {
            jobs(other.getJobs());
            checkReferrers(other.getCheckReferrers());
            optimizeValidation(other.getOptimizeValidation());
            doNotScript(other.getDoNotScript());
            return this;
        }

        @JsonSetter(value = "jobs", nulls = Nulls.SKIP)
        public Builder jobs(Optional<List<BulkUpdateAssetsJobDto>> jobs) {
            this.jobs = jobs;
            return this;
        }

        public Builder jobs(List<BulkUpdateAssetsJobDto> jobs) {
            this.jobs = Optional.of(jobs);
            return this;
        }

        @JsonSetter(value = "checkReferrers", nulls = Nulls.SKIP)
        public Builder checkReferrers(Optional<Boolean> checkReferrers) {
            this.checkReferrers = checkReferrers;
            return this;
        }

        public Builder checkReferrers(Boolean checkReferrers) {
            this.checkReferrers = Optional.of(checkReferrers);
            return this;
        }

        @JsonSetter(value = "optimizeValidation", nulls = Nulls.SKIP)
        public Builder optimizeValidation(Optional<Boolean> optimizeValidation) {
            this.optimizeValidation = optimizeValidation;
            return this;
        }

        public Builder optimizeValidation(Boolean optimizeValidation) {
            this.optimizeValidation = Optional.of(optimizeValidation);
            return this;
        }

        @JsonSetter(value = "doNotScript", nulls = Nulls.SKIP)
        public Builder doNotScript(Optional<Boolean> doNotScript) {
            this.doNotScript = doNotScript;
            return this;
        }

        public Builder doNotScript(Boolean doNotScript) {
            this.doNotScript = Optional.of(doNotScript);
            return this;
        }

        public BulkUpdateAssetsDto build() {
            return new BulkUpdateAssetsDto(jobs, checkReferrers, optimizeValidation, doNotScript);
        }
    }
}
