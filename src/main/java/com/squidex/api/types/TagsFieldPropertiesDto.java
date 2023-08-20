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
@JsonDeserialize(builder = TagsFieldPropertiesDto.Builder.class)
public final class TagsFieldPropertiesDto {
    private final Optional<Map<String, List<String>>> defaultValues;

    private final Optional<List<String>> defaultValue;

    private final Optional<Integer> minItems;

    private final Optional<Integer> maxItems;

    private final Optional<List<String>> allowedValues;

    private final Optional<Boolean> createEnum;

    private final Optional<TagsFieldEditor> editor;

    private TagsFieldPropertiesDto(
            Optional<Map<String, List<String>>> defaultValues,
            Optional<List<String>> defaultValue,
            Optional<Integer> minItems,
            Optional<Integer> maxItems,
            Optional<List<String>> allowedValues,
            Optional<Boolean> createEnum,
            Optional<TagsFieldEditor> editor) {
        this.defaultValues = defaultValues;
        this.defaultValue = defaultValue;
        this.minItems = minItems;
        this.maxItems = maxItems;
        this.allowedValues = allowedValues;
        this.createEnum = createEnum;
        this.editor = editor;
    }

    @JsonProperty("defaultValues")
    public Optional<Map<String, List<String>>> getDefaultValues() {
        return defaultValues;
    }

    /**
     * @return The default value.
     */
    @JsonProperty("defaultValue")
    public Optional<List<String>> getDefaultValue() {
        return defaultValue;
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
     * @return The allowed values for the field value.
     */
    @JsonProperty("allowedValues")
    public Optional<List<String>> getAllowedValues() {
        return allowedValues;
    }

    /**
     * @return Indicates whether GraphQL Enum should be created.
     */
    @JsonProperty("createEnum")
    public Optional<Boolean> getCreateEnum() {
        return createEnum;
    }

    @JsonProperty("editor")
    public Optional<TagsFieldEditor> getEditor() {
        return editor;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TagsFieldPropertiesDto && equalTo((TagsFieldPropertiesDto) other);
    }

    private boolean equalTo(TagsFieldPropertiesDto other) {
        return defaultValues.equals(other.defaultValues)
                && defaultValue.equals(other.defaultValue)
                && minItems.equals(other.minItems)
                && maxItems.equals(other.maxItems)
                && allowedValues.equals(other.allowedValues)
                && createEnum.equals(other.createEnum)
                && editor.equals(other.editor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.defaultValues,
                this.defaultValue,
                this.minItems,
                this.maxItems,
                this.allowedValues,
                this.createEnum,
                this.editor);
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
        private Optional<Map<String, List<String>>> defaultValues = Optional.empty();

        private Optional<List<String>> defaultValue = Optional.empty();

        private Optional<Integer> minItems = Optional.empty();

        private Optional<Integer> maxItems = Optional.empty();

        private Optional<List<String>> allowedValues = Optional.empty();

        private Optional<Boolean> createEnum = Optional.empty();

        private Optional<TagsFieldEditor> editor = Optional.empty();

        private Builder() {}

        public Builder from(TagsFieldPropertiesDto other) {
            defaultValues(other.getDefaultValues());
            defaultValue(other.getDefaultValue());
            minItems(other.getMinItems());
            maxItems(other.getMaxItems());
            allowedValues(other.getAllowedValues());
            createEnum(other.getCreateEnum());
            editor(other.getEditor());
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

        @JsonSetter(value = "allowedValues", nulls = Nulls.SKIP)
        public Builder allowedValues(Optional<List<String>> allowedValues) {
            this.allowedValues = allowedValues;
            return this;
        }

        public Builder allowedValues(List<String> allowedValues) {
            this.allowedValues = Optional.of(allowedValues);
            return this;
        }

        @JsonSetter(value = "createEnum", nulls = Nulls.SKIP)
        public Builder createEnum(Optional<Boolean> createEnum) {
            this.createEnum = createEnum;
            return this;
        }

        public Builder createEnum(Boolean createEnum) {
            this.createEnum = Optional.of(createEnum);
            return this;
        }

        @JsonSetter(value = "editor", nulls = Nulls.SKIP)
        public Builder editor(Optional<TagsFieldEditor> editor) {
            this.editor = editor;
            return this;
        }

        public Builder editor(TagsFieldEditor editor) {
            this.editor = Optional.of(editor);
            return this;
        }

        public TagsFieldPropertiesDto build() {
            return new TagsFieldPropertiesDto(
                    defaultValues, defaultValue, minItems, maxItems, allowedValues, createEnum, editor);
        }
    }
}
