package com.squidex.api.resources.assets.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AnnotateAssetDto.Builder.class)
public final class AnnotateAssetDto {
    private final Optional<String> fileName;

    private final Optional<String> slug;

    private final Optional<Boolean> isProtected;

    private final Optional<List<String>> tags;

    private final Optional<Map<String, Object>> metadata;

    private AnnotateAssetDto(
            Optional<String> fileName,
            Optional<String> slug,
            Optional<Boolean> isProtected,
            Optional<List<String>> tags,
            Optional<Map<String, Object>> metadata) {
        this.fileName = fileName;
        this.slug = slug;
        this.isProtected = isProtected;
        this.tags = tags;
        this.metadata = metadata;
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

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AnnotateAssetDto && equalTo((AnnotateAssetDto) other);
    }

    private boolean equalTo(AnnotateAssetDto other) {
        return fileName.equals(other.fileName)
                && slug.equals(other.slug)
                && isProtected.equals(other.isProtected)
                && tags.equals(other.tags)
                && metadata.equals(other.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fileName, this.slug, this.isProtected, this.tags, this.metadata);
    }

    @Override
    public String toString() {
        return "AnnotateAssetDto{" + "fileName: " + fileName + ", slug: " + slug + ", isProtected: " + isProtected
                + ", tags: " + tags + ", metadata: " + metadata + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> fileName = Optional.empty();

        private Optional<String> slug = Optional.empty();

        private Optional<Boolean> isProtected = Optional.empty();

        private Optional<List<String>> tags = Optional.empty();

        private Optional<Map<String, Object>> metadata = Optional.empty();

        private Builder() {}

        public Builder from(AnnotateAssetDto other) {
            fileName(other.getFileName());
            slug(other.getSlug());
            isProtected(other.getIsProtected());
            tags(other.getTags());
            metadata(other.getMetadata());
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

        public AnnotateAssetDto build() {
            return new AnnotateAssetDto(fileName, slug, isProtected, tags, metadata);
        }
    }
}
