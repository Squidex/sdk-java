package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AssetMeta.Builder.class)
public final class AssetMeta {
    private final String isDuplicate;

    private AssetMeta(String isDuplicate) {
        this.isDuplicate = isDuplicate;
    }

    /**
     * @return Indicates whether the asset is a duplicate.
     */
    @JsonProperty("isDuplicate")
    public String getIsDuplicate() {
        return isDuplicate;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AssetMeta && equalTo((AssetMeta) other);
    }

    private boolean equalTo(AssetMeta other) {
        return isDuplicate.equals(other.isDuplicate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.isDuplicate);
    }

    @Override
    public String toString() {
        return "AssetMeta{" + "isDuplicate: " + isDuplicate + "}";
    }

    public static IsDuplicateStage builder() {
        return new Builder();
    }

    public interface IsDuplicateStage {
        _FinalStage isDuplicate(String isDuplicate);

        Builder from(AssetMeta other);
    }

    public interface _FinalStage {
        AssetMeta build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IsDuplicateStage, _FinalStage {
        private String isDuplicate;

        private Builder() {}

        @Override
        public Builder from(AssetMeta other) {
            isDuplicate(other.getIsDuplicate());
            return this;
        }

        /**
         * <p>Indicates whether the asset is a duplicate.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("isDuplicate")
        public _FinalStage isDuplicate(String isDuplicate) {
            this.isDuplicate = isDuplicate;
            return this;
        }

        @Override
        public AssetMeta build() {
            return new AssetMeta(isDuplicate);
        }
    }
}
