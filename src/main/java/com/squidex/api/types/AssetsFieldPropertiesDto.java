package com.squidex.api.types;

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
@JsonDeserialize(builder = AssetsFieldPropertiesDto.Builder.class)
public final class AssetsFieldPropertiesDto {
    private final Optional<AssetPreviewMode> previewMode;

    private final Optional<Map<String, List<String>>> defaultValues;

    private final Optional<List<String>> defaultValue;

    private final Optional<String> folderId;

    private final Optional<String> previewFormat;

    private final Optional<Integer> minItems;

    private final Optional<Integer> maxItems;

    private final Optional<Integer> minSize;

    private final Optional<Integer> maxSize;

    private final Optional<Integer> minWidth;

    private final Optional<Integer> maxWidth;

    private final Optional<Integer> minHeight;

    private final Optional<Integer> maxHeight;

    private final Optional<Integer> aspectWidth;

    private final Optional<Integer> aspectHeight;

    private final Optional<AssetType> expectedType;

    private final Optional<Boolean> resolveFirst;

    private final Optional<Boolean> mustBeImage;

    private final Optional<Boolean> resolveImage;

    private final Optional<List<String>> allowedExtensions;

    private final Optional<Boolean> allowDuplicates;

    private AssetsFieldPropertiesDto(
            Optional<AssetPreviewMode> previewMode,
            Optional<Map<String, List<String>>> defaultValues,
            Optional<List<String>> defaultValue,
            Optional<String> folderId,
            Optional<String> previewFormat,
            Optional<Integer> minItems,
            Optional<Integer> maxItems,
            Optional<Integer> minSize,
            Optional<Integer> maxSize,
            Optional<Integer> minWidth,
            Optional<Integer> maxWidth,
            Optional<Integer> minHeight,
            Optional<Integer> maxHeight,
            Optional<Integer> aspectWidth,
            Optional<Integer> aspectHeight,
            Optional<AssetType> expectedType,
            Optional<Boolean> resolveFirst,
            Optional<Boolean> mustBeImage,
            Optional<Boolean> resolveImage,
            Optional<List<String>> allowedExtensions,
            Optional<Boolean> allowDuplicates) {
        this.previewMode = previewMode;
        this.defaultValues = defaultValues;
        this.defaultValue = defaultValue;
        this.folderId = folderId;
        this.previewFormat = previewFormat;
        this.minItems = minItems;
        this.maxItems = maxItems;
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.minWidth = minWidth;
        this.maxWidth = maxWidth;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.aspectWidth = aspectWidth;
        this.aspectHeight = aspectHeight;
        this.expectedType = expectedType;
        this.resolveFirst = resolveFirst;
        this.mustBeImage = mustBeImage;
        this.resolveImage = resolveImage;
        this.allowedExtensions = allowedExtensions;
        this.allowDuplicates = allowDuplicates;
    }

    @JsonProperty("previewMode")
    public Optional<AssetPreviewMode> getPreviewMode() {
        return previewMode;
    }

    @JsonProperty("defaultValues")
    public Optional<Map<String, List<String>>> getDefaultValues() {
        return defaultValues;
    }

    /**
     * @return The default value as a list of asset ids.
     */
    @JsonProperty("defaultValue")
    public Optional<List<String>> getDefaultValue() {
        return defaultValue;
    }

    /**
     * @return The initial id to the folder.
     */
    @JsonProperty("folderId")
    public Optional<String> getFolderId() {
        return folderId;
    }

    /**
     * @return The preview format.
     */
    @JsonProperty("previewFormat")
    public Optional<String> getPreviewFormat() {
        return previewFormat;
    }

    /**
     * @return The minimum allowed items for the field value.
     */
    @JsonProperty("minItems")
    public Optional<Integer> getMinItems() {
        return minItems;
    }

    /**
     * @return The maximum allowed items for the field value.
     */
    @JsonProperty("maxItems")
    public Optional<Integer> getMaxItems() {
        return maxItems;
    }

    /**
     * @return The minimum file size in bytes.
     */
    @JsonProperty("minSize")
    public Optional<Integer> getMinSize() {
        return minSize;
    }

    /**
     * @return The maximum file size in bytes.
     */
    @JsonProperty("maxSize")
    public Optional<Integer> getMaxSize() {
        return maxSize;
    }

    /**
     * @return The minimum image width in pixels.
     */
    @JsonProperty("minWidth")
    public Optional<Integer> getMinWidth() {
        return minWidth;
    }

    /**
     * @return The maximum image width in pixels.
     */
    @JsonProperty("maxWidth")
    public Optional<Integer> getMaxWidth() {
        return maxWidth;
    }

    /**
     * @return The minimum image height in pixels.
     */
    @JsonProperty("minHeight")
    public Optional<Integer> getMinHeight() {
        return minHeight;
    }

    /**
     * @return The maximum image height in pixels.
     */
    @JsonProperty("maxHeight")
    public Optional<Integer> getMaxHeight() {
        return maxHeight;
    }

    /**
     * @return The image aspect width in pixels.
     */
    @JsonProperty("aspectWidth")
    public Optional<Integer> getAspectWidth() {
        return aspectWidth;
    }

    /**
     * @return The image aspect height in pixels.
     */
    @JsonProperty("aspectHeight")
    public Optional<Integer> getAspectHeight() {
        return aspectHeight;
    }

    @JsonProperty("expectedType")
    public Optional<AssetType> getExpectedType() {
        return expectedType;
    }

    /**
     * @return True to resolve first asset in the content list.
     */
    @JsonProperty("resolveFirst")
    public Optional<Boolean> getResolveFirst() {
        return resolveFirst;
    }

    /**
     * @return True to resolve first image in the content list.
     */
    @JsonProperty("mustBeImage")
    public Optional<Boolean> getMustBeImage() {
        return mustBeImage;
    }

    /**
     * @return True to resolve first image in the content list.
     */
    @JsonProperty("resolveImage")
    public Optional<Boolean> getResolveImage() {
        return resolveImage;
    }

    /**
     * @return The allowed file extensions.
     */
    @JsonProperty("allowedExtensions")
    public Optional<List<String>> getAllowedExtensions() {
        return allowedExtensions;
    }

    /**
     * @return True, if duplicate values are allowed.
     */
    @JsonProperty("allowDuplicates")
    public Optional<Boolean> getAllowDuplicates() {
        return allowDuplicates;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AssetsFieldPropertiesDto && equalTo((AssetsFieldPropertiesDto) other);
    }

    private boolean equalTo(AssetsFieldPropertiesDto other) {
        return previewMode.equals(other.previewMode)
                && defaultValues.equals(other.defaultValues)
                && defaultValue.equals(other.defaultValue)
                && folderId.equals(other.folderId)
                && previewFormat.equals(other.previewFormat)
                && minItems.equals(other.minItems)
                && maxItems.equals(other.maxItems)
                && minSize.equals(other.minSize)
                && maxSize.equals(other.maxSize)
                && minWidth.equals(other.minWidth)
                && maxWidth.equals(other.maxWidth)
                && minHeight.equals(other.minHeight)
                && maxHeight.equals(other.maxHeight)
                && aspectWidth.equals(other.aspectWidth)
                && aspectHeight.equals(other.aspectHeight)
                && expectedType.equals(other.expectedType)
                && resolveFirst.equals(other.resolveFirst)
                && mustBeImage.equals(other.mustBeImage)
                && resolveImage.equals(other.resolveImage)
                && allowedExtensions.equals(other.allowedExtensions)
                && allowDuplicates.equals(other.allowDuplicates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.previewMode,
                this.defaultValues,
                this.defaultValue,
                this.folderId,
                this.previewFormat,
                this.minItems,
                this.maxItems,
                this.minSize,
                this.maxSize,
                this.minWidth,
                this.maxWidth,
                this.minHeight,
                this.maxHeight,
                this.aspectWidth,
                this.aspectHeight,
                this.expectedType,
                this.resolveFirst,
                this.mustBeImage,
                this.resolveImage,
                this.allowedExtensions,
                this.allowDuplicates);
    }

    @Override
    public String toString() {
        return "AssetsFieldPropertiesDto{" + "previewMode: " + previewMode + ", defaultValues: " + defaultValues
                + ", defaultValue: " + defaultValue + ", folderId: " + folderId + ", previewFormat: " + previewFormat
                + ", minItems: " + minItems + ", maxItems: " + maxItems + ", minSize: " + minSize + ", maxSize: "
                + maxSize + ", minWidth: " + minWidth + ", maxWidth: " + maxWidth + ", minHeight: " + minHeight
                + ", maxHeight: " + maxHeight + ", aspectWidth: " + aspectWidth + ", aspectHeight: " + aspectHeight
                + ", expectedType: " + expectedType + ", resolveFirst: " + resolveFirst + ", mustBeImage: "
                + mustBeImage + ", resolveImage: " + resolveImage + ", allowedExtensions: " + allowedExtensions
                + ", allowDuplicates: " + allowDuplicates + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<AssetPreviewMode> previewMode = Optional.empty();

        private Optional<Map<String, List<String>>> defaultValues = Optional.empty();

        private Optional<List<String>> defaultValue = Optional.empty();

        private Optional<String> folderId = Optional.empty();

        private Optional<String> previewFormat = Optional.empty();

        private Optional<Integer> minItems = Optional.empty();

        private Optional<Integer> maxItems = Optional.empty();

        private Optional<Integer> minSize = Optional.empty();

        private Optional<Integer> maxSize = Optional.empty();

        private Optional<Integer> minWidth = Optional.empty();

        private Optional<Integer> maxWidth = Optional.empty();

        private Optional<Integer> minHeight = Optional.empty();

        private Optional<Integer> maxHeight = Optional.empty();

        private Optional<Integer> aspectWidth = Optional.empty();

        private Optional<Integer> aspectHeight = Optional.empty();

        private Optional<AssetType> expectedType = Optional.empty();

        private Optional<Boolean> resolveFirst = Optional.empty();

        private Optional<Boolean> mustBeImage = Optional.empty();

        private Optional<Boolean> resolveImage = Optional.empty();

        private Optional<List<String>> allowedExtensions = Optional.empty();

        private Optional<Boolean> allowDuplicates = Optional.empty();

        private Builder() {}

        public Builder from(AssetsFieldPropertiesDto other) {
            previewMode(other.getPreviewMode());
            defaultValues(other.getDefaultValues());
            defaultValue(other.getDefaultValue());
            folderId(other.getFolderId());
            previewFormat(other.getPreviewFormat());
            minItems(other.getMinItems());
            maxItems(other.getMaxItems());
            minSize(other.getMinSize());
            maxSize(other.getMaxSize());
            minWidth(other.getMinWidth());
            maxWidth(other.getMaxWidth());
            minHeight(other.getMinHeight());
            maxHeight(other.getMaxHeight());
            aspectWidth(other.getAspectWidth());
            aspectHeight(other.getAspectHeight());
            expectedType(other.getExpectedType());
            resolveFirst(other.getResolveFirst());
            mustBeImage(other.getMustBeImage());
            resolveImage(other.getResolveImage());
            allowedExtensions(other.getAllowedExtensions());
            allowDuplicates(other.getAllowDuplicates());
            return this;
        }

        @JsonSetter(value = "previewMode", nulls = Nulls.SKIP)
        public Builder previewMode(Optional<AssetPreviewMode> previewMode) {
            this.previewMode = previewMode;
            return this;
        }

        public Builder previewMode(AssetPreviewMode previewMode) {
            this.previewMode = Optional.of(previewMode);
            return this;
        }

        @JsonSetter(value = "defaultValues", nulls = Nulls.SKIP)
        public Builder defaultValues(Optional<Map<String, List<String>>> defaultValues) {
            this.defaultValues = defaultValues;
            return this;
        }

        public Builder defaultValues(Map<String, List<String>> defaultValues) {
            this.defaultValues = Optional.of(defaultValues);
            return this;
        }

        @JsonSetter(value = "defaultValue", nulls = Nulls.SKIP)
        public Builder defaultValue(Optional<List<String>> defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }

        public Builder defaultValue(List<String> defaultValue) {
            this.defaultValue = Optional.of(defaultValue);
            return this;
        }

        @JsonSetter(value = "folderId", nulls = Nulls.SKIP)
        public Builder folderId(Optional<String> folderId) {
            this.folderId = folderId;
            return this;
        }

        public Builder folderId(String folderId) {
            this.folderId = Optional.of(folderId);
            return this;
        }

        @JsonSetter(value = "previewFormat", nulls = Nulls.SKIP)
        public Builder previewFormat(Optional<String> previewFormat) {
            this.previewFormat = previewFormat;
            return this;
        }

        public Builder previewFormat(String previewFormat) {
            this.previewFormat = Optional.of(previewFormat);
            return this;
        }

        @JsonSetter(value = "minItems", nulls = Nulls.SKIP)
        public Builder minItems(Optional<Integer> minItems) {
            this.minItems = minItems;
            return this;
        }

        public Builder minItems(Integer minItems) {
            this.minItems = Optional.of(minItems);
            return this;
        }

        @JsonSetter(value = "maxItems", nulls = Nulls.SKIP)
        public Builder maxItems(Optional<Integer> maxItems) {
            this.maxItems = maxItems;
            return this;
        }

        public Builder maxItems(Integer maxItems) {
            this.maxItems = Optional.of(maxItems);
            return this;
        }

        @JsonSetter(value = "minSize", nulls = Nulls.SKIP)
        public Builder minSize(Optional<Integer> minSize) {
            this.minSize = minSize;
            return this;
        }

        public Builder minSize(Integer minSize) {
            this.minSize = Optional.of(minSize);
            return this;
        }

        @JsonSetter(value = "maxSize", nulls = Nulls.SKIP)
        public Builder maxSize(Optional<Integer> maxSize) {
            this.maxSize = maxSize;
            return this;
        }

        public Builder maxSize(Integer maxSize) {
            this.maxSize = Optional.of(maxSize);
            return this;
        }

        @JsonSetter(value = "minWidth", nulls = Nulls.SKIP)
        public Builder minWidth(Optional<Integer> minWidth) {
            this.minWidth = minWidth;
            return this;
        }

        public Builder minWidth(Integer minWidth) {
            this.minWidth = Optional.of(minWidth);
            return this;
        }

        @JsonSetter(value = "maxWidth", nulls = Nulls.SKIP)
        public Builder maxWidth(Optional<Integer> maxWidth) {
            this.maxWidth = maxWidth;
            return this;
        }

        public Builder maxWidth(Integer maxWidth) {
            this.maxWidth = Optional.of(maxWidth);
            return this;
        }

        @JsonSetter(value = "minHeight", nulls = Nulls.SKIP)
        public Builder minHeight(Optional<Integer> minHeight) {
            this.minHeight = minHeight;
            return this;
        }

        public Builder minHeight(Integer minHeight) {
            this.minHeight = Optional.of(minHeight);
            return this;
        }

        @JsonSetter(value = "maxHeight", nulls = Nulls.SKIP)
        public Builder maxHeight(Optional<Integer> maxHeight) {
            this.maxHeight = maxHeight;
            return this;
        }

        public Builder maxHeight(Integer maxHeight) {
            this.maxHeight = Optional.of(maxHeight);
            return this;
        }

        @JsonSetter(value = "aspectWidth", nulls = Nulls.SKIP)
        public Builder aspectWidth(Optional<Integer> aspectWidth) {
            this.aspectWidth = aspectWidth;
            return this;
        }

        public Builder aspectWidth(Integer aspectWidth) {
            this.aspectWidth = Optional.of(aspectWidth);
            return this;
        }

        @JsonSetter(value = "aspectHeight", nulls = Nulls.SKIP)
        public Builder aspectHeight(Optional<Integer> aspectHeight) {
            this.aspectHeight = aspectHeight;
            return this;
        }

        public Builder aspectHeight(Integer aspectHeight) {
            this.aspectHeight = Optional.of(aspectHeight);
            return this;
        }

        @JsonSetter(value = "expectedType", nulls = Nulls.SKIP)
        public Builder expectedType(Optional<AssetType> expectedType) {
            this.expectedType = expectedType;
            return this;
        }

        public Builder expectedType(AssetType expectedType) {
            this.expectedType = Optional.of(expectedType);
            return this;
        }

        @JsonSetter(value = "resolveFirst", nulls = Nulls.SKIP)
        public Builder resolveFirst(Optional<Boolean> resolveFirst) {
            this.resolveFirst = resolveFirst;
            return this;
        }

        public Builder resolveFirst(Boolean resolveFirst) {
            this.resolveFirst = Optional.of(resolveFirst);
            return this;
        }

        @JsonSetter(value = "mustBeImage", nulls = Nulls.SKIP)
        public Builder mustBeImage(Optional<Boolean> mustBeImage) {
            this.mustBeImage = mustBeImage;
            return this;
        }

        public Builder mustBeImage(Boolean mustBeImage) {
            this.mustBeImage = Optional.of(mustBeImage);
            return this;
        }

        @JsonSetter(value = "resolveImage", nulls = Nulls.SKIP)
        public Builder resolveImage(Optional<Boolean> resolveImage) {
            this.resolveImage = resolveImage;
            return this;
        }

        public Builder resolveImage(Boolean resolveImage) {
            this.resolveImage = Optional.of(resolveImage);
            return this;
        }

        @JsonSetter(value = "allowedExtensions", nulls = Nulls.SKIP)
        public Builder allowedExtensions(Optional<List<String>> allowedExtensions) {
            this.allowedExtensions = allowedExtensions;
            return this;
        }

        public Builder allowedExtensions(List<String> allowedExtensions) {
            this.allowedExtensions = Optional.of(allowedExtensions);
            return this;
        }

        @JsonSetter(value = "allowDuplicates", nulls = Nulls.SKIP)
        public Builder allowDuplicates(Optional<Boolean> allowDuplicates) {
            this.allowDuplicates = allowDuplicates;
            return this;
        }

        public Builder allowDuplicates(Boolean allowDuplicates) {
            this.allowDuplicates = Optional.of(allowDuplicates);
            return this;
        }

        public AssetsFieldPropertiesDto build() {
            return new AssetsFieldPropertiesDto(
                    previewMode,
                    defaultValues,
                    defaultValue,
                    folderId,
                    previewFormat,
                    minItems,
                    maxItems,
                    minSize,
                    maxSize,
                    minWidth,
                    maxWidth,
                    minHeight,
                    maxHeight,
                    aspectWidth,
                    aspectHeight,
                    expectedType,
                    resolveFirst,
                    mustBeImage,
                    resolveImage,
                    allowedExtensions,
                    allowDuplicates);
        }
    }
}
