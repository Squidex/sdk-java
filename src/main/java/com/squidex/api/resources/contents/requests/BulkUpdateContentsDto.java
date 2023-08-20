package com.squidex.api.resources.contents.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.types.BulkUpdateContentsJobDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = BulkUpdateContentsDto.Builder.class)
public final class BulkUpdateContentsDto {
    private final List<BulkUpdateContentsJobDto> jobs;

    private final Optional<Boolean> publish;

    private final Optional<Boolean> doNotScript;

    private final Optional<Boolean> doNotValidate;

    private final Optional<Boolean> doNotValidateWorkflow;

    private final Optional<Boolean> checkReferrers;

    private final Optional<Boolean> optimizeValidation;

    private BulkUpdateContentsDto(
            List<BulkUpdateContentsJobDto> jobs,
            Optional<Boolean> publish,
            Optional<Boolean> doNotScript,
            Optional<Boolean> doNotValidate,
            Optional<Boolean> doNotValidateWorkflow,
            Optional<Boolean> checkReferrers,
            Optional<Boolean> optimizeValidation) {
        this.jobs = jobs;
        this.publish = publish;
        this.doNotScript = doNotScript;
        this.doNotValidate = doNotValidate;
        this.doNotValidateWorkflow = doNotValidateWorkflow;
        this.checkReferrers = checkReferrers;
        this.optimizeValidation = optimizeValidation;
    }

    /**
     * @return The contents to update or insert.
     */
    @JsonProperty("jobs")
    public List<BulkUpdateContentsJobDto> getJobs() {
        return jobs;
    }

    /**
     * @return True to automatically publish the content.
     */
    @JsonProperty("publish")
    public Optional<Boolean> getPublish() {
        return publish;
    }

    /**
     * @return True to turn off scripting for faster inserts. Default: true.
     */
    @JsonProperty("doNotScript")
    public Optional<Boolean> getDoNotScript() {
        return doNotScript;
    }

    /**
     * @return True to turn off validation for faster inserts. Default: false.
     */
    @JsonProperty("doNotValidate")
    public Optional<Boolean> getDoNotValidate() {
        return doNotValidate;
    }

    /**
     * @return True to turn off validation of workflow rules. Default: false.
     */
    @JsonProperty("doNotValidateWorkflow")
    public Optional<Boolean> getDoNotValidateWorkflow() {
        return doNotValidateWorkflow;
    }

    /**
     * @return True to check referrers of deleted contents.
     */
    @JsonProperty("checkReferrers")
    public Optional<Boolean> getCheckReferrers() {
        return checkReferrers;
    }

    /**
     * @return True to turn off costly validation: Unique checks, asset checks and reference checks. Default: true.
     */
    @JsonProperty("optimizeValidation")
    public Optional<Boolean> getOptimizeValidation() {
        return optimizeValidation;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BulkUpdateContentsDto && equalTo((BulkUpdateContentsDto) other);
    }

    private boolean equalTo(BulkUpdateContentsDto other) {
        return jobs.equals(other.jobs)
                && publish.equals(other.publish)
                && doNotScript.equals(other.doNotScript)
                && doNotValidate.equals(other.doNotValidate)
                && doNotValidateWorkflow.equals(other.doNotValidateWorkflow)
                && checkReferrers.equals(other.checkReferrers)
                && optimizeValidation.equals(other.optimizeValidation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.jobs,
                this.publish,
                this.doNotScript,
                this.doNotValidate,
                this.doNotValidateWorkflow,
                this.checkReferrers,
                this.optimizeValidation);
    }

    @Override
    public String toString() {
        return "BulkUpdateContentsDto{" + "jobs: " + jobs + ", publish: " + publish + ", doNotScript: " + doNotScript
                + ", doNotValidate: " + doNotValidate + ", doNotValidateWorkflow: " + doNotValidateWorkflow
                + ", checkReferrers: " + checkReferrers + ", optimizeValidation: " + optimizeValidation + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private List<BulkUpdateContentsJobDto> jobs = new ArrayList<>();

        private Optional<Boolean> publish = Optional.empty();

        private Optional<Boolean> doNotScript = Optional.empty();

        private Optional<Boolean> doNotValidate = Optional.empty();

        private Optional<Boolean> doNotValidateWorkflow = Optional.empty();

        private Optional<Boolean> checkReferrers = Optional.empty();

        private Optional<Boolean> optimizeValidation = Optional.empty();

        private Builder() {}

        public Builder from(BulkUpdateContentsDto other) {
            jobs(other.getJobs());
            publish(other.getPublish());
            doNotScript(other.getDoNotScript());
            doNotValidate(other.getDoNotValidate());
            doNotValidateWorkflow(other.getDoNotValidateWorkflow());
            checkReferrers(other.getCheckReferrers());
            optimizeValidation(other.getOptimizeValidation());
            return this;
        }

        @JsonSetter(value = "jobs", nulls = Nulls.SKIP)
        public Builder jobs(List<BulkUpdateContentsJobDto> jobs) {
            this.jobs.clear();
            this.jobs.addAll(jobs);
            return this;
        }

        public Builder addJobs(BulkUpdateContentsJobDto jobs) {
            this.jobs.add(jobs);
            return this;
        }

        public Builder addAllJobs(List<BulkUpdateContentsJobDto> jobs) {
            this.jobs.addAll(jobs);
            return this;
        }

        @JsonSetter(value = "publish", nulls = Nulls.SKIP)
        public Builder publish(Optional<Boolean> publish) {
            this.publish = publish;
            return this;
        }

        public Builder publish(Boolean publish) {
            this.publish = Optional.of(publish);
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

        @JsonSetter(value = "doNotValidate", nulls = Nulls.SKIP)
        public Builder doNotValidate(Optional<Boolean> doNotValidate) {
            this.doNotValidate = doNotValidate;
            return this;
        }

        public Builder doNotValidate(Boolean doNotValidate) {
            this.doNotValidate = Optional.of(doNotValidate);
            return this;
        }

        @JsonSetter(value = "doNotValidateWorkflow", nulls = Nulls.SKIP)
        public Builder doNotValidateWorkflow(Optional<Boolean> doNotValidateWorkflow) {
            this.doNotValidateWorkflow = doNotValidateWorkflow;
            return this;
        }

        public Builder doNotValidateWorkflow(Boolean doNotValidateWorkflow) {
            this.doNotValidateWorkflow = Optional.of(doNotValidateWorkflow);
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

        public BulkUpdateContentsDto build() {
            return new BulkUpdateContentsDto(
                    jobs,
                    publish,
                    doNotScript,
                    doNotValidate,
                    doNotValidateWorkflow,
                    checkReferrers,
                    optimizeValidation);
        }
    }
}
