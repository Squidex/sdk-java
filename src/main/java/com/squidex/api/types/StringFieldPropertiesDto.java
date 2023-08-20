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
@JsonDeserialize(builder = StringFieldPropertiesDto.Builder.class)
public final class StringFieldPropertiesDto {
    private final Optional<Map<String, String>> defaultValues;

    private final Optional<String> defaultValue;

    private final Optional<String> pattern;

    private final Optional<String> patternMessage;

    private final Optional<String> folderId;

    private final Optional<Integer> minLength;

    private final Optional<Integer> maxLength;

    private final Optional<Integer> minCharacters;

    private final Optional<Integer> maxCharacters;

    private final Optional<Integer> minWords;

    private final Optional<Integer> maxWords;

    private final Optional<List<String>> allowedValues;

    private final Optional<List<String>> schemaIds;

    private final Optional<Boolean> isUnique;

    private final Optional<Boolean> isEmbeddable;

    private final Optional<Boolean> inlineEditable;

    private final Optional<Boolean> createEnum;

    private final Optional<StringContentType> contentType;

    private final Optional<StringFieldEditor> editor;

    private StringFieldPropertiesDto(
            Optional<Map<String, String>> defaultValues,
            Optional<String> defaultValue,
            Optional<String> pattern,
            Optional<String> patternMessage,
            Optional<String> folderId,
            Optional<Integer> minLength,
            Optional<Integer> maxLength,
            Optional<Integer> minCharacters,
            Optional<Integer> maxCharacters,
            Optional<Integer> minWords,
            Optional<Integer> maxWords,
            Optional<List<String>> allowedValues,
            Optional<List<String>> schemaIds,
            Optional<Boolean> isUnique,
            Optional<Boolean> isEmbeddable,
            Optional<Boolean> inlineEditable,
            Optional<Boolean> createEnum,
            Optional<StringContentType> contentType,
            Optional<StringFieldEditor> editor) {
        this.defaultValues = defaultValues;
        this.defaultValue = defaultValue;
        this.pattern = pattern;
        this.patternMessage = patternMessage;
        this.folderId = folderId;
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.minCharacters = minCharacters;
        this.maxCharacters = maxCharacters;
        this.minWords = minWords;
        this.maxWords = maxWords;
        this.allowedValues = allowedValues;
        this.schemaIds = schemaIds;
        this.isUnique = isUnique;
        this.isEmbeddable = isEmbeddable;
        this.inlineEditable = inlineEditable;
        this.createEnum = createEnum;
        this.contentType = contentType;
        this.editor = editor;
    }

    @JsonProperty("defaultValues")
    public Optional<Map<String, String>> getDefaultValues() {
        return defaultValues;
    }

    /**
     * @return The default value for the field value.
     */
    @JsonProperty("defaultValue")
    public Optional<String> getDefaultValue() {
        return defaultValue;
    }

    /**
     * @return The pattern to enforce a specific format for the field value.
     */
    @JsonProperty("pattern")
    public Optional<String> getPattern() {
        return pattern;
    }

    /**
     * @return The validation message for the pattern.
     */
    @JsonProperty("patternMessage")
    public Optional<String> getPatternMessage() {
        return patternMessage;
    }

    /**
     * @return The initial id to the folder when the control supports file uploads.
     */
    @JsonProperty("folderId")
    public Optional<String> getFolderId() {
        return folderId;
    }

    /**
     * @return The minimum allowed length for the field value.
     */
    @JsonProperty("minLength")
    public Optional<Integer> getMinLength() {
        return minLength;
    }

    /**
     * @return The maximum allowed length for the field value.
     */
    @JsonProperty("maxLength")
    public Optional<Integer> getMaxLength() {
        return maxLength;
    }

    /**
     * @return The minimum allowed of normal characters for the field value.
     */
    @JsonProperty("minCharacters")
    public Optional<Integer> getMinCharacters() {
        return minCharacters;
    }

    /**
     * @return The maximum allowed of normal characters for the field value.
     */
    @JsonProperty("maxCharacters")
    public Optional<Integer> getMaxCharacters() {
        return maxCharacters;
    }

    /**
     * @return The minimum allowed number of words for the field value.
     */
    @JsonProperty("minWords")
    public Optional<Integer> getMinWords() {
        return minWords;
    }

    /**
     * @return The maximum allowed number of words for the field value.
     */
    @JsonProperty("maxWords")
    public Optional<Integer> getMaxWords() {
        return maxWords;
    }

    /**
     * @return The allowed values for the field value.
     */
    @JsonProperty("allowedValues")
    public Optional<List<String>> getAllowedValues() {
        return allowedValues;
    }

    /**
     * @return The allowed schema ids that can be embedded.
     */
    @JsonProperty("schemaIds")
    public Optional<List<String>> getSchemaIds() {
        return schemaIds;
    }

    /**
     * @return Indicates if the field value must be unique. Ignored for nested fields and localized fields.
     */
    @JsonProperty("isUnique")
    public Optional<Boolean> getIsUnique() {
        return isUnique;
    }

    /**
     * @return Indicates that other content items or references are embedded.
     */
    @JsonProperty("isEmbeddable")
    public Optional<Boolean> getIsEmbeddable() {
        return isEmbeddable;
    }

    /**
     * @return Indicates that the inline editor is enabled for this field.
     */
    @JsonProperty("inlineEditable")
    public Optional<Boolean> getInlineEditable() {
        return inlineEditable;
    }

    /**
     * @return Indicates whether GraphQL Enum should be created.
     */
    @JsonProperty("createEnum")
    public Optional<Boolean> getCreateEnum() {
        return createEnum;
    }

    @JsonProperty("contentType")
    public Optional<StringContentType> getContentType() {
        return contentType;
    }

    @JsonProperty("editor")
    public Optional<StringFieldEditor> getEditor() {
        return editor;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof StringFieldPropertiesDto && equalTo((StringFieldPropertiesDto) other);
    }

    private boolean equalTo(StringFieldPropertiesDto other) {
        return defaultValues.equals(other.defaultValues)
                && defaultValue.equals(other.defaultValue)
                && pattern.equals(other.pattern)
                && patternMessage.equals(other.patternMessage)
                && folderId.equals(other.folderId)
                && minLength.equals(other.minLength)
                && maxLength.equals(other.maxLength)
                && minCharacters.equals(other.minCharacters)
                && maxCharacters.equals(other.maxCharacters)
                && minWords.equals(other.minWords)
                && maxWords.equals(other.maxWords)
                && allowedValues.equals(other.allowedValues)
                && schemaIds.equals(other.schemaIds)
                && isUnique.equals(other.isUnique)
                && isEmbeddable.equals(other.isEmbeddable)
                && inlineEditable.equals(other.inlineEditable)
                && createEnum.equals(other.createEnum)
                && contentType.equals(other.contentType)
                && editor.equals(other.editor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.defaultValues,
                this.defaultValue,
                this.pattern,
                this.patternMessage,
                this.folderId,
                this.minLength,
                this.maxLength,
                this.minCharacters,
                this.maxCharacters,
                this.minWords,
                this.maxWords,
                this.allowedValues,
                this.schemaIds,
                this.isUnique,
                this.isEmbeddable,
                this.inlineEditable,
                this.createEnum,
                this.contentType,
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
        private Optional<Map<String, String>> defaultValues = Optional.empty();

        private Optional<String> defaultValue = Optional.empty();

        private Optional<String> pattern = Optional.empty();

        private Optional<String> patternMessage = Optional.empty();

        private Optional<String> folderId = Optional.empty();

        private Optional<Integer> minLength = Optional.empty();

        private Optional<Integer> maxLength = Optional.empty();

        private Optional<Integer> minCharacters = Optional.empty();

        private Optional<Integer> maxCharacters = Optional.empty();

        private Optional<Integer> minWords = Optional.empty();

        private Optional<Integer> maxWords = Optional.empty();

        private Optional<List<String>> allowedValues = Optional.empty();

        private Optional<List<String>> schemaIds = Optional.empty();

        private Optional<Boolean> isUnique = Optional.empty();

        private Optional<Boolean> isEmbeddable = Optional.empty();

        private Optional<Boolean> inlineEditable = Optional.empty();

        private Optional<Boolean> createEnum = Optional.empty();

        private Optional<StringContentType> contentType = Optional.empty();

        private Optional<StringFieldEditor> editor = Optional.empty();

        private Builder() {}

        public Builder from(StringFieldPropertiesDto other) {
            defaultValues(other.getDefaultValues());
            defaultValue(other.getDefaultValue());
            pattern(other.getPattern());
            patternMessage(other.getPatternMessage());
            folderId(other.getFolderId());
            minLength(other.getMinLength());
            maxLength(other.getMaxLength());
            minCharacters(other.getMinCharacters());
            maxCharacters(other.getMaxCharacters());
            minWords(other.getMinWords());
            maxWords(other.getMaxWords());
            allowedValues(other.getAllowedValues());
            schemaIds(other.getSchemaIds());
            isUnique(other.getIsUnique());
            isEmbeddable(other.getIsEmbeddable());
            inlineEditable(other.getInlineEditable());
            createEnum(other.getCreateEnum());
            contentType(other.getContentType());
            editor(other.getEditor());
            return this;
        }

        @JsonSetter(value = "defaultValues", nulls = Nulls.SKIP)
        public Builder defaultValues(Optional<Map<String, String>> defaultValues) {
            this.defaultValues = defaultValues;
            return this;
        }

        public Builder defaultValues(Map<String, String> defaultValues) {
            this.defaultValues = Optional.of(defaultValues);
            return this;
        }

        @JsonSetter(value = "defaultValue", nulls = Nulls.SKIP)
        public Builder defaultValue(Optional<String> defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }

        public Builder defaultValue(String defaultValue) {
            this.defaultValue = Optional.of(defaultValue);
            return this;
        }

        @JsonSetter(value = "pattern", nulls = Nulls.SKIP)
        public Builder pattern(Optional<String> pattern) {
            this.pattern = pattern;
            return this;
        }

        public Builder pattern(String pattern) {
            this.pattern = Optional.of(pattern);
            return this;
        }

        @JsonSetter(value = "patternMessage", nulls = Nulls.SKIP)
        public Builder patternMessage(Optional<String> patternMessage) {
            this.patternMessage = patternMessage;
            return this;
        }

        public Builder patternMessage(String patternMessage) {
            this.patternMessage = Optional.of(patternMessage);
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

        @JsonSetter(value = "minLength", nulls = Nulls.SKIP)
        public Builder minLength(Optional<Integer> minLength) {
            this.minLength = minLength;
            return this;
        }

        public Builder minLength(Integer minLength) {
            this.minLength = Optional.of(minLength);
            return this;
        }

        @JsonSetter(value = "maxLength", nulls = Nulls.SKIP)
        public Builder maxLength(Optional<Integer> maxLength) {
            this.maxLength = maxLength;
            return this;
        }

        public Builder maxLength(Integer maxLength) {
            this.maxLength = Optional.of(maxLength);
            return this;
        }

        @JsonSetter(value = "minCharacters", nulls = Nulls.SKIP)
        public Builder minCharacters(Optional<Integer> minCharacters) {
            this.minCharacters = minCharacters;
            return this;
        }

        public Builder minCharacters(Integer minCharacters) {
            this.minCharacters = Optional.of(minCharacters);
            return this;
        }

        @JsonSetter(value = "maxCharacters", nulls = Nulls.SKIP)
        public Builder maxCharacters(Optional<Integer> maxCharacters) {
            this.maxCharacters = maxCharacters;
            return this;
        }

        public Builder maxCharacters(Integer maxCharacters) {
            this.maxCharacters = Optional.of(maxCharacters);
            return this;
        }

        @JsonSetter(value = "minWords", nulls = Nulls.SKIP)
        public Builder minWords(Optional<Integer> minWords) {
            this.minWords = minWords;
            return this;
        }

        public Builder minWords(Integer minWords) {
            this.minWords = Optional.of(minWords);
            return this;
        }

        @JsonSetter(value = "maxWords", nulls = Nulls.SKIP)
        public Builder maxWords(Optional<Integer> maxWords) {
            this.maxWords = maxWords;
            return this;
        }

        public Builder maxWords(Integer maxWords) {
            this.maxWords = Optional.of(maxWords);
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

        @JsonSetter(value = "schemaIds", nulls = Nulls.SKIP)
        public Builder schemaIds(Optional<List<String>> schemaIds) {
            this.schemaIds = schemaIds;
            return this;
        }

        public Builder schemaIds(List<String> schemaIds) {
            this.schemaIds = Optional.of(schemaIds);
            return this;
        }

        @JsonSetter(value = "isUnique", nulls = Nulls.SKIP)
        public Builder isUnique(Optional<Boolean> isUnique) {
            this.isUnique = isUnique;
            return this;
        }

        public Builder isUnique(Boolean isUnique) {
            this.isUnique = Optional.of(isUnique);
            return this;
        }

        @JsonSetter(value = "isEmbeddable", nulls = Nulls.SKIP)
        public Builder isEmbeddable(Optional<Boolean> isEmbeddable) {
            this.isEmbeddable = isEmbeddable;
            return this;
        }

        public Builder isEmbeddable(Boolean isEmbeddable) {
            this.isEmbeddable = Optional.of(isEmbeddable);
            return this;
        }

        @JsonSetter(value = "inlineEditable", nulls = Nulls.SKIP)
        public Builder inlineEditable(Optional<Boolean> inlineEditable) {
            this.inlineEditable = inlineEditable;
            return this;
        }

        public Builder inlineEditable(Boolean inlineEditable) {
            this.inlineEditable = Optional.of(inlineEditable);
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

        @JsonSetter(value = "contentType", nulls = Nulls.SKIP)
        public Builder contentType(Optional<StringContentType> contentType) {
            this.contentType = contentType;
            return this;
        }

        public Builder contentType(StringContentType contentType) {
            this.contentType = Optional.of(contentType);
            return this;
        }

        @JsonSetter(value = "editor", nulls = Nulls.SKIP)
        public Builder editor(Optional<StringFieldEditor> editor) {
            this.editor = editor;
            return this;
        }

        public Builder editor(StringFieldEditor editor) {
            this.editor = Optional.of(editor);
            return this;
        }

        public StringFieldPropertiesDto build() {
            return new StringFieldPropertiesDto(
                    defaultValues,
                    defaultValue,
                    pattern,
                    patternMessage,
                    folderId,
                    minLength,
                    maxLength,
                    minCharacters,
                    maxCharacters,
                    minWords,
                    maxWords,
                    allowedValues,
                    schemaIds,
                    isUnique,
                    isEmbeddable,
                    inlineEditable,
                    createEnum,
                    contentType,
                    editor);
        }
    }
}
