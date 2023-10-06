/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = BulkUpdateAssetsJobDto.Builder.class)
public final class BulkUpdateAssetsJobDto {
    private final Optional<String> id;

    private final Optional<BulkUpdateAssetType> type;

    private final Optional<String> parentId;

    private final Optional<String> fileName;

    private final Optional<String> slug;

    private final Optional<Boolean> isProtected;

    private final Optional<List<String>> tags;

    private final Optional<Map<String, Object>> metadata;

    private final Optional<Boolean> permanent;

    private final Optional<Integer> expectedVersion;

    private BulkUpdateAssetsJobDto(
            Optional<String> id,
            Optional<BulkUpdateAssetType> type,
            Optional<String> parentId,
            Optional<String> fileName,
            Optional<String> slug,
            Optional<Boolean> isProtected,
            Optional<List<String>> tags,
            Optional<Map<String, Object>> metadata,
            Optional<Boolean> permanent,
            Optional<Integer> expectedVersion) {
        this.id = id;
        this.type = type;
        this.parentId = parentId;
        this.fileName = fileName;
        this.slug = slug;
        this.isProtected = isProtected;
        this.tags = tags;
        this.metadata = metadata;
        this.permanent = permanent;
        this.expectedVersion = expectedVersion;
    }

    /**
     * @return An optional ID of the asset to update.
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return The update type.
     */
    @JsonProperty("type")
    public Optional<BulkUpdateAssetType> getType() {
        return type;
    }

    /**
     * @return The parent folder id.
     */
    @JsonProperty("parentId")
    public Optional<String> getParentId() {
        return parentId;
    }

    /**
     * @return The new name of the asset.
     */
    @JsonProperty("fileName")
    public Optional<String> getFileName() {
        return fileName;
    }

    /**
     * @return The new slug of the asset.
     */
    @JsonProperty("slug")
    public Optional<String> getSlug() {
        return slug;
    }

    /**
     * @return True, when the asset is not public.
     */
    @JsonProperty("isProtected")
    public Optional<Boolean> getIsProtected() {
        return isProtected;
    }

    /**
     * @return The new asset tags.
     */
    @JsonProperty("tags")
    public Optional<List<String>> getTags() {
        return tags;
    }

    /**
     * @return The asset metadata.
     */
    @JsonProperty("metadata")
    public Optional<Map<String, Object>> getMetadata() {
        return metadata;
    }

    /**
     * @return True to delete the asset permanently.
     */
    @JsonProperty("permanent")
    public Optional<Boolean> getPermanent() {
        return permanent;
    }

    /**
     * @return The expected version.
     */
    @JsonProperty("expectedVersion")
    public Optional<Integer> getExpectedVersion() {
        return expectedVersion;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BulkUpdateAssetsJobDto && equalTo((BulkUpdateAssetsJobDto) other);
    }

    private boolean equalTo(BulkUpdateAssetsJobDto other) {
        return id.equals(other.id)
                && type.equals(other.type)
                && parentId.equals(other.parentId)
                && fileName.equals(other.fileName)
                && slug.equals(other.slug)
                && isProtected.equals(other.isProtected)
                && tags.equals(other.tags)
                && metadata.equals(other.metadata)
                && permanent.equals(other.permanent)
                && expectedVersion.equals(other.expectedVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.type,
                this.parentId,
                this.fileName,
                this.slug,
                this.isProtected,
                this.tags,
                this.metadata,
                this.permanent,
                this.expectedVersion);
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
        private Optional<String> id = Optional.empty();

        private Optional<BulkUpdateAssetType> type = Optional.empty();

        private Optional<String> parentId = Optional.empty();

        private Optional<String> fileName = Optional.empty();

        private Optional<String> slug = Optional.empty();

        private Optional<Boolean> isProtected = Optional.empty();

        private Optional<List<String>> tags = Optional.empty();

        private Optional<Map<String, Object>> metadata = Optional.empty();

        private Optional<Boolean> permanent = Optional.empty();

        private Optional<Integer> expectedVersion = Optional.empty();

        private Builder() {}

        public Builder from(BulkUpdateAssetsJobDto other) {
            id(other.getId());
            type(other.getType());
            parentId(other.getParentId());
            fileName(other.getFileName());
            slug(other.getSlug());
            isProtected(other.getIsProtected());
            tags(other.getTags());
            metadata(other.getMetadata());
            permanent(other.getPermanent());
            expectedVersion(other.getExpectedVersion());
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

        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public Builder type(Optional<BulkUpdateAssetType> type) {
            this.type = type;
            return this;
        }

        public Builder type(BulkUpdateAssetType type) {
            this.type = Optional.of(type);
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

        @JsonSetter(value = "fileName", nulls = Nulls.SKIP)
        public Builder fileName(Optional<String> fileName) {
            this.fileName = fileName;
            return this;
        }

        public Builder fileName(String fileName) {
            this.fileName = Optional.of(fileName);
            return this;
        }

        @JsonSetter(value = "slug", nulls = Nulls.SKIP)
        public Builder slug(Optional<String> slug) {
            this.slug = slug;
            return this;
        }

        public Builder slug(String slug) {
            this.slug = Optional.of(slug);
            return this;
        }

        @JsonSetter(value = "isProtected", nulls = Nulls.SKIP)
        public Builder isProtected(Optional<Boolean> isProtected) {
            this.isProtected = isProtected;
            return this;
        }

        public Builder isProtected(Boolean isProtected) {
            this.isProtected = Optional.of(isProtected);
            return this;
        }

        @JsonSetter(value = "tags", nulls = Nulls.SKIP)
        public Builder tags(Optional<List<String>> tags) {
            this.tags = tags;
            return this;
        }

        public Builder tags(List<String> tags) {
            this.tags = Optional.of(tags);
            return this;
        }

        @JsonSetter(value = "metadata", nulls = Nulls.SKIP)
        public Builder metadata(Optional<Map<String, Object>> metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder metadata(Map<String, Object> metadata) {
            this.metadata = Optional.of(metadata);
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

        @JsonSetter(value = "expectedVersion", nulls = Nulls.SKIP)
        public Builder expectedVersion(Optional<Integer> expectedVersion) {
            this.expectedVersion = expectedVersion;
            return this;
        }

        public Builder expectedVersion(Integer expectedVersion) {
            this.expectedVersion = Optional.of(expectedVersion);
            return this;
        }

        public BulkUpdateAssetsJobDto build() {
            return new BulkUpdateAssetsJobDto(
                    id, type, parentId, fileName, slug, isProtected, tags, metadata, permanent, expectedVersion);
        }
    }
}
