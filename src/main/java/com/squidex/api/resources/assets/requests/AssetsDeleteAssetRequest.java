package com.squidex.api.resources.assets.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AssetsDeleteAssetRequest.Builder.class)
public final class AssetsDeleteAssetRequest {
    private final Optional<Boolean> checkReferrers;

    private final Optional<Boolean> permanent;

    private AssetsDeleteAssetRequest(Optional<Boolean> checkReferrers, Optional<Boolean> permanent) {
        this.checkReferrers = checkReferrers;
        this.permanent = permanent;
    }

    /**
     * @return True to check referrers of this asset.
     */
    @JsonProperty("checkReferrers")
    public Optional<Boolean> getCheckReferrers() {
        return checkReferrers;
    }

    /**
     * @return True to delete the asset permanently.
     */
    @JsonProperty("permanent")
    public Optional<Boolean> getPermanent() {
        return permanent;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AssetsDeleteAssetRequest && equalTo((AssetsDeleteAssetRequest) other);
    }

    private boolean equalTo(AssetsDeleteAssetRequest other) {
        return checkReferrers.equals(other.checkReferrers) && permanent.equals(other.permanent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.checkReferrers, this.permanent);
    }

    @Override
    public String toString() {
        return "AssetsDeleteAssetRequest{" + "checkReferrers: " + checkReferrers + ", permanent: " + permanent + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Boolean> checkReferrers = Optional.empty();

        private Optional<Boolean> permanent = Optional.empty();

        private Builder() {}

        public Builder from(AssetsDeleteAssetRequest other) {
            checkReferrers(other.getCheckReferrers());
            permanent(other.getPermanent());
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

        @JsonSetter(value = "permanent", nulls = Nulls.SKIP)
        public Builder permanent(Optional<Boolean> permanent) {
            this.permanent = permanent;
            return this;
        }

        public Builder permanent(Boolean permanent) {
            this.permanent = Optional.of(permanent);
            return this;
        }

        public AssetsDeleteAssetRequest build() {
            return new AssetsDeleteAssetRequest(checkReferrers, permanent);
        }
    }
}
