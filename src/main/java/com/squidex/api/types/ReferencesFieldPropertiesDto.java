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
@JsonDeserialize(builder = ReferencesFieldPropertiesDto.Builder.class)
public final class ReferencesFieldPropertiesDto {
    private final Optional<Map<String, List<String>>> defaultValues;

    private final Optional<List<String>> defaultValue;

    private final Optional<Integer> minItems;

    private final Optional<Integer> maxItems;

    private final Optional<Boolean> allowDuplicates;

    private final Optional<Boolean> resolveReference;

    private final Optional<Boolean> mustBePublished;

    private final Optional<ReferencesFieldEditor> editor;

    private final Optional<List<String>> schemaIds;

    private ReferencesFieldPropertiesDto(
            Optional<Map<String, List<String>>> defaultValues,
            Optional<List<String>> defaultValue,
            Optional<Integer> minItems,
            Optional<Integer> maxItems,
            Optional<Boolean> allowDuplicates,
            Optional<Boolean> resolveReference,
            Optional<Boolean> mustBePublished,
            Optional<ReferencesFieldEditor> editor,
            Optional<List<String>> schemaIds) {
        this.defaultValues = defaultValues;
        this.defaultValue = defaultValue;
        this.minItems = minItems;
        this.maxItems = maxItems;
        this.allowDuplicates = allowDuplicates;
        this.resolveReference = resolveReference;
        this.mustBePublished = mustBePublished;
        this.editor = editor;
        this.schemaIds = schemaIds;
    }

    /**
     * @return The language specific default value as a list of content ids.
     */
    @JsonProperty("defaultValues")
    public Optional<Map<String, List<String>>> getDefaultValues() {
        return defaultValues;
    }

    /**
     * @return The default value as a list of content ids.
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
     * @return True, if duplicate values are allowed.
     */
    @JsonProperty("allowDuplicates")
    public Optional<Boolean> getAllowDuplicates() {
        return allowDuplicates;
    }

    /**
     * @return True to resolve references in the content list.
     */
    @JsonProperty("resolveReference")
    public Optional<Boolean> getResolveReference() {
        return resolveReference;
    }

    /**
     * @return True when all references must be published.
     */
    @JsonProperty("mustBePublished")
    public Optional<Boolean> getMustBePublished() {
        return mustBePublished;
    }

    /**
     * @return The editor that is used to manage this field.
     */
    @JsonProperty("editor")
    public Optional<ReferencesFieldEditor> getEditor() {
        return editor;
    }

    /**
     * @return The ID of the referenced schemas.
     */
    @JsonProperty("schemaIds")
    public Optional<List<String>> getSchemaIds() {
        return schemaIds;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ReferencesFieldPropertiesDto && equalTo((ReferencesFieldPropertiesDto) other);
    }

    private boolean equalTo(ReferencesFieldPropertiesDto other) {
        return defaultValues.equals(other.defaultValues)
                && defaultValue.equals(other.defaultValue)
                && minItems.equals(other.minItems)
                && maxItems.equals(other.maxItems)
                && allowDuplicates.equals(other.allowDuplicates)
                && resolveReference.equals(other.resolveReference)
                && mustBePublished.equals(other.mustBePublished)
                && editor.equals(other.editor)
                && schemaIds.equals(other.schemaIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.defaultValues,
                this.defaultValue,
                this.minItems,
                this.maxItems,
                this.allowDuplicates,
                this.resolveReference,
                this.mustBePublished,
                this.editor,
                this.schemaIds);
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

        private Optional<Boolean> allowDuplicates = Optional.empty();

        private Optional<Boolean> resolveReference = Optional.empty();

        private Optional<Boolean> mustBePublished = Optional.empty();

        private Optional<ReferencesFieldEditor> editor = Optional.empty();

        private Optional<List<String>> schemaIds = Optional.empty();

        private Builder() {}

        public Builder from(ReferencesFieldPropertiesDto other) {
            defaultValues(other.getDefaultValues());
            defaultValue(other.getDefaultValue());
            minItems(other.getMinItems());
            maxItems(other.getMaxItems());
            allowDuplicates(other.getAllowDuplicates());
            resolveReference(other.getResolveReference());
            mustBePublished(other.getMustBePublished());
            editor(other.getEditor());
            schemaIds(other.getSchemaIds());
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

        @JsonSetter(value = "allowDuplicates", nulls = Nulls.SKIP)
        public Builder allowDuplicates(Optional<Boolean> allowDuplicates) {
            this.allowDuplicates = allowDuplicates;
            return this;
        }

        public Builder allowDuplicates(Boolean allowDuplicates) {
            this.allowDuplicates = Optional.of(allowDuplicates);
            return this;
        }

        @JsonSetter(value = "resolveReference", nulls = Nulls.SKIP)
        public Builder resolveReference(Optional<Boolean> resolveReference) {
            this.resolveReference = resolveReference;
            return this;
        }

        public Builder resolveReference(Boolean resolveReference) {
            this.resolveReference = Optional.of(resolveReference);
            return this;
        }

        @JsonSetter(value = "mustBePublished", nulls = Nulls.SKIP)
        public Builder mustBePublished(Optional<Boolean> mustBePublished) {
            this.mustBePublished = mustBePublished;
            return this;
        }

        public Builder mustBePublished(Boolean mustBePublished) {
            this.mustBePublished = Optional.of(mustBePublished);
            return this;
        }

        @JsonSetter(value = "editor", nulls = Nulls.SKIP)
        public Builder editor(Optional<ReferencesFieldEditor> editor) {
            this.editor = editor;
            return this;
        }

        public Builder editor(ReferencesFieldEditor editor) {
            this.editor = Optional.of(editor);
            return this;
        }

        @JsonSetter(value = "schemaIds", nulls = Nulls.SKIP)
        public Builder schemaIds(Optional<List<String>> schemaIds) {
            this.schemaIds = schemaIds;
            return this;
        }

        public Builder schemaIds(List<String> schemaIds) {
            this.schemaIds = Optional.of(schemaIds);
            return this;
        }

        public ReferencesFieldPropertiesDto build() {
            return new ReferencesFieldPropertiesDto(
                    defaultValues,
                    defaultValue,
                    minItems,
                    maxItems,
                    allowDuplicates,
                    resolveReference,
                    mustBePublished,
                    editor,
                    schemaIds);
        }
    }
}
