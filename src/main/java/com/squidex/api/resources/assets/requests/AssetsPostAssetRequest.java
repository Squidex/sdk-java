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
@JsonDeserialize(builder = AssetsPostAssetRequest.Builder.class)
public final class AssetsPostAssetRequest {
    private final Optional<String> parentId;

    private final Optional<String> id;

    private final Optional<Boolean> duplicate;

    private AssetsPostAssetRequest(Optional<String> parentId, Optional<String> id, Optional<Boolean> duplicate) {
        this.parentId = parentId;
        this.id = id;
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
     * @return The optional custom asset id.
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
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
        return other instanceof AssetsPostAssetRequest && equalTo((AssetsPostAssetRequest) other);
    }

    private boolean equalTo(AssetsPostAssetRequest other) {
        return parentId.equals(other.parentId) && id.equals(other.id) && duplicate.equals(other.duplicate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.parentId, this.id, this.duplicate);
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

        private Optional<String> id = Optional.empty();

        private Optional<Boolean> duplicate = Optional.empty();

        private Builder() {}

        public Builder from(AssetsPostAssetRequest other) {
            parentId(other.getParentId());
            id(other.getId());
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

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.of(id);
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

        public AssetsPostAssetRequest build() {
            return new AssetsPostAssetRequest(parentId, id, duplicate);
        }
    }
}
