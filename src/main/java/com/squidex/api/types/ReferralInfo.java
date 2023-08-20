package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ReferralInfo.Builder.class)
public final class ReferralInfo {
    private final String code;

    private final String earned;

    private final String condition;

    private ReferralInfo(String code, String earned, String condition) {
        this.code = code;
        this.earned = earned;
        this.condition = condition;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("earned")
    public String getEarned() {
        return earned;
    }

    @JsonProperty("condition")
    public String getCondition() {
        return condition;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ReferralInfo && equalTo((ReferralInfo) other);
    }

    private boolean equalTo(ReferralInfo other) {
        return code.equals(other.code) && earned.equals(other.earned) && condition.equals(other.condition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.code, this.earned, this.condition);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static CodeStage builder() {
        return new Builder();
    }

    public interface CodeStage {
        EarnedStage code(String code);

        Builder from(ReferralInfo other);
    }

    public interface EarnedStage {
        ConditionStage earned(String earned);
    }

    public interface ConditionStage {
        _FinalStage condition(String condition);
    }

    public interface _FinalStage {
        ReferralInfo build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements CodeStage, EarnedStage, ConditionStage, _FinalStage {
        private String code;

        private String earned;

        private String condition;

        private Builder() {}

        @Override
        public Builder from(ReferralInfo other) {
            code(other.getCode());
            earned(other.getEarned());
            condition(other.getCondition());
            return this;
        }

        @Override
        @JsonSetter("code")
        public EarnedStage code(String code) {
            this.code = code;
            return this;
        }

        @Override
        @JsonSetter("earned")
        public ConditionStage earned(String earned) {
            this.earned = earned;
            return this;
        }

        @Override
        @JsonSetter("condition")
        public _FinalStage condition(String condition) {
            this.condition = condition;
            return this;
        }

        @Override
        public ReferralInfo build() {
            return new ReferralInfo(code, earned, condition);
        }
    }
}
