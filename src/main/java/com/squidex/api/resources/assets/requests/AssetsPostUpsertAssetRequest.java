/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squidex.api.resources.assets.requests;

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
@JsonDeserialize(builder = AssetsPostUpsertAssetRequest.Builder.class)
public final class AssetsPostUpsertAssetRequest {
    private final Optional<String> parentId;

    private final Optional<Boolean> duplicate;

    private AssetsPostUpsertAssetRequest(Optional<String> parentId, Optional<Boolean> duplicate) {
        this.parentId = parentId;
        this.duplicate = duplicate;
    }

    /**
     * @return The optional parent folder id.
     */
    @JsonProperty("parentId")
    public Optional<String> getParentId() {
        return parentId;
    }

    /**
     * @return True to duplicate the asset, event if the file has been uploaded.
     */
    @JsonProperty("duplicate")
    public Optional<Boolean> getDuplicate() {
        return duplicate;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AssetsPostUpsertAssetRequest && equalTo((AssetsPostUpsertAssetRequest) other);
    }

    private boolean equalTo(AssetsPostUpsertAssetRequest other) {
        return parentId.equals(other.parentId) && duplicate.equals(other.duplicate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.parentId, this.duplicate);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> parentId = Optional.empty();

        private Optional<Boolean> duplicate = Optional.empty();

        private Builder() {}

        public Builder from(AssetsPostUpsertAssetRequest other) {
            parentId(other.getParentId());
            duplicate(other.getDuplicate());
            return this;
        }

        @JsonSetter(value = "parentId", nulls = Nulls.SKIP)
        public Builder parentId(Optional<String> parentId) {
            this.parentId = parentId;
            return this;
        }

        public Builder parentId(String parentId) {
            this.parentId = Optional.of(parentId);
            return this;
        }

        @JsonSetter(value = "duplicate", nulls = Nulls.SKIP)
        public Builder duplicate(Optional<Boolean> duplicate) {
            this.duplicate = duplicate;
            return this;
        }

        public Builder duplicate(Boolean duplicate) {
            this.duplicate = Optional.of(duplicate);
            return this;
        }

        public AssetsPostUpsertAssetRequest build() {
            return new AssetsPostUpsertAssetRequest(parentId, duplicate);
        }
    }
}
