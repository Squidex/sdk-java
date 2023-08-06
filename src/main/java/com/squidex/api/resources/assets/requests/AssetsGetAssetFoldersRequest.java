package com.squidex.api.resources.assets.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.types.AssetFolderScope;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AssetsGetAssetFoldersRequest.Builder.class)
public final class AssetsGetAssetFoldersRequest {
    private final Optional<String> parentId;

    private final Optional<AssetFolderScope> scope;

    private AssetsGetAssetFoldersRequest(Optional<String> parentId, Optional<AssetFolderScope> scope) {
        this.parentId = parentId;
        this.scope = scope;
    }

    /**
     * @return The optional parent folder id.
     */
    @JsonProperty("parentId")
    public Optional<String> getParentId() {
        return parentId;
    }

    /**
     * @return The scope of the query.
     */
    @JsonProperty("scope")
    public Optional<AssetFolderScope> getScope() {
        return scope;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AssetsGetAssetFoldersRequest && equalTo((AssetsGetAssetFoldersRequest) other);
    }

    private boolean equalTo(AssetsGetAssetFoldersRequest other) {
        return parentId.equals(other.parentId) && scope.equals(other.scope);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.parentId, this.scope);
    }

    @Override
    public String toString() {
        return "AssetsGetAssetFoldersRequest{" + "parentId: " + parentId + ", scope: " + scope + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> parentId = Optional.empty();

        private Optional<AssetFolderScope> scope = Optional.empty();

        private Builder() {}

        public Builder from(AssetsGetAssetFoldersRequest other) {
            parentId(other.getParentId());
            scope(other.getScope());
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

        @JsonSetter(value = "scope", nulls = Nulls.SKIP)
        public Builder scope(Optional<AssetFolderScope> scope) {
            this.scope = scope;
            return this;
        }

        public Builder scope(AssetFolderScope scope) {
            this.scope = Optional.of(scope);
            return this;
        }

        public AssetsGetAssetFoldersRequest build() {
            return new AssetsGetAssetFoldersRequest(parentId, scope);
        }
    }
}
