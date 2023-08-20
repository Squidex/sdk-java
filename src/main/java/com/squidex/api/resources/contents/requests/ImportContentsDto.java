package com.squidex.api.resources.contents.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ImportContentsDto.Builder.class)
public final class ImportContentsDto {
    private final List<Map<String, Map<String, Object>>> datas;

    private final Optional<Boolean> publish;

    private final Optional<Boolean> doNotScript;

    private final Optional<Boolean> optimizeValidation;

    private ImportContentsDto(
            List<Map<String, Map<String, Object>>> datas,
            Optional<Boolean> publish,
            Optional<Boolean> doNotScript,
            Optional<Boolean> optimizeValidation) {
        this.datas = datas;
        this.publish = publish;
        this.doNotScript = doNotScript;
        this.optimizeValidation = optimizeValidation;
    }

    /**
     * @return The data to import.
     */
    @JsonProperty("datas")
    public List<Map<String, Map<String, Object>>> getDatas() {
        return datas;
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
     * @return True to turn off costly validation: Unique checks, asset checks and reference checks. Default: true.
     */
    @JsonProperty("optimizeValidation")
    public Optional<Boolean> getOptimizeValidation() {
        return optimizeValidation;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ImportContentsDto && equalTo((ImportContentsDto) other);
    }

    private boolean equalTo(ImportContentsDto other) {
        return datas.equals(other.datas)
                && publish.equals(other.publish)
                && doNotScript.equals(other.doNotScript)
                && optimizeValidation.equals(other.optimizeValidation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.datas, this.publish, this.doNotScript, this.optimizeValidation);
    }

    @Override
    public String toString() {
        return "ImportContentsDto{" + "datas: " + datas + ", publish: " + publish + ", doNotScript: " + doNotScript
                + ", optimizeValidation: " + optimizeValidation + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private List<Map<String, Map<String, Object>>> datas = new ArrayList<>();

        private Optional<Boolean> publish = Optional.empty();

        private Optional<Boolean> doNotScript = Optional.empty();

        private Optional<Boolean> optimizeValidation = Optional.empty();

        private Builder() {}

        public Builder from(ImportContentsDto other) {
            datas(other.getDatas());
            publish(other.getPublish());
            doNotScript(other.getDoNotScript());
            optimizeValidation(other.getOptimizeValidation());
            return this;
        }

        @JsonSetter(value = "datas", nulls = Nulls.SKIP)
        public Builder datas(List<Map<String, Map<String, Object>>> datas) {
            this.datas.clear();
            this.datas.addAll(datas);
            return this;
        }

        public Builder addDatas(Map<String, Map<String, Object>> datas) {
            this.datas.add(datas);
            return this;
        }

        public Builder addAllDatas(List<Map<String, Map<String, Object>>> datas) {
            this.datas.addAll(datas);
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

        @JsonSetter(value = "optimizeValidation", nulls = Nulls.SKIP)
        public Builder optimizeValidation(Optional<Boolean> optimizeValidation) {
            this.optimizeValidation = optimizeValidation;
            return this;
        }

        public Builder optimizeValidation(Boolean optimizeValidation) {
            this.optimizeValidation = Optional.of(optimizeValidation);
            return this;
        }

        public ImportContentsDto build() {
            return new ImportContentsDto(datas, publish, doNotScript, optimizeValidation);
        }
    }
}
