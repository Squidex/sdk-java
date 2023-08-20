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

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = FeaturesDto.Builder.class)
public final class FeaturesDto {
    private final List<FeatureDto> features;

    private final int version;

    private FeaturesDto(List<FeatureDto> features, int version) {
        this.features = features;
        this.version = version;
    }

    /**
     * @return The latest features.
     */
    @JsonProperty("features")
    public List<FeatureDto> getFeatures() {
        return features;
    }

    /**
     * @return The recent version.
     */
    @JsonProperty("version")
    public int getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof FeaturesDto && equalTo((FeaturesDto) other);
    }

    private boolean equalTo(FeaturesDto other) {
        return features.equals(other.features) && version == other.version;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.features, this.version);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static VersionStage builder() {
        return new Builder();
    }

    public interface VersionStage {
        _FinalStage version(int version);

        Builder from(FeaturesDto other);
    }

    public interface _FinalStage {
        FeaturesDto build();

        _FinalStage features(List<FeatureDto> features);

        _FinalStage addFeatures(FeatureDto features);

        _FinalStage addAllFeatures(List<FeatureDto> features);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements VersionStage, _FinalStage {
        private int version;

        private List<FeatureDto> features = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(FeaturesDto other) {
            features(other.getFeatures());
            version(other.getVersion());
            return this;
        }

        /**
         * <p>The recent version.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("version")
        public _FinalStage version(int version) {
            this.version = version;
            return this;
        }

        /**
         * <p>The latest features.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllFeatures(List<FeatureDto> features) {
            this.features.addAll(features);
            return this;
        }

        /**
         * <p>The latest features.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addFeatures(FeatureDto features) {
            this.features.add(features);
            return this;
        }

        @Override
        @JsonSetter(value = "features", nulls = Nulls.SKIP)
        public _FinalStage features(List<FeatureDto> features) {
            this.features.clear();
            this.features.addAll(features);
            return this;
        }

        @Override
        public FeaturesDto build() {
            return new FeaturesDto(features, version);
        }
    }
}
