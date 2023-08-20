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
@JsonDeserialize(builder = NumberFieldPropertiesDto.Builder.class)
public final class NumberFieldPropertiesDto {
    private final Optional<Map<String, Optional<Double>>> defaultValues;

    private final Optional<Double> defaultValue;

    private final Optional<Double> maxValue;

    private final Optional<Double> minValue;

    private final Optional<List<Double>> allowedValues;

    private final Optional<Boolean> isUnique;

    private final Optional<Boolean> inlineEditable;

    private final Optional<NumberFieldEditor> editor;

    private NumberFieldPropertiesDto(
            Optional<Map<String, Optional<Double>>> defaultValues,
            Optional<Double> defaultValue,
            Optional<Double> maxValue,
            Optional<Double> minValue,
            Optional<List<Double>> allowedValues,
            Optional<Boolean> isUnique,
            Optional<Boolean> inlineEditable,
            Optional<NumberFieldEditor> editor) {
        this.defaultValues = defaultValues;
        this.defaultValue = defaultValue;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.allowedValues = allowedValues;
        this.isUnique = isUnique;
        this.inlineEditable = inlineEditable;
        this.editor = editor;
    }

    @JsonProperty("defaultValues")
    public Optional<Map<String, Optional<Double>>> getDefaultValues() {
        return defaultValues;
    }

    /**
     * @return The default value for the field value.
     */
    @JsonProperty("defaultValue")
    public Optional<Double> getDefaultValue() {
        return defaultValue;
    }

    /**
     * @return The maximum allowed value for the field value.
     */
    @JsonProperty("maxValue")
    public Optional<Double> getMaxValue() {
        return maxValue;
    }

    /**
     * @return The minimum allowed value for the field value.
     */
    @JsonProperty("minValue")
    public Optional<Double> getMinValue() {
        return minValue;
    }

    /**
     * @return The allowed values for the field value.
     */
    @JsonProperty("allowedValues")
    public Optional<List<Double>> getAllowedValues() {
        return allowedValues;
    }

    /**
     * @return Indicates if the field value must be unique. Ignored for nested fields and localized fields.
     */
    @JsonProperty("isUnique")
    public Optional<Boolean> getIsUnique() {
        return isUnique;
    }

    /**
     * @return Indicates that the inline editor is enabled for this field.
     */
    @JsonProperty("inlineEditable")
    public Optional<Boolean> getInlineEditable() {
        return inlineEditable;
    }

    @JsonProperty("editor")
    public Optional<NumberFieldEditor> getEditor() {
        return editor;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof NumberFieldPropertiesDto && equalTo((NumberFieldPropertiesDto) other);
    }

    private boolean equalTo(NumberFieldPropertiesDto other) {
        return defaultValues.equals(other.defaultValues)
                && defaultValue.equals(other.defaultValue)
                && maxValue.equals(other.maxValue)
                && minValue.equals(other.minValue)
                && allowedValues.equals(other.allowedValues)
                && isUnique.equals(other.isUnique)
                && inlineEditable.equals(other.inlineEditable)
                && editor.equals(other.editor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.defaultValues,
                this.defaultValue,
                this.maxValue,
                this.minValue,
                this.allowedValues,
                this.isUnique,
                this.inlineEditable,
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
        private Optional<Map<String, Optional<Double>>> defaultValues = Optional.empty();

        private Optional<Double> defaultValue = Optional.empty();

        private Optional<Double> maxValue = Optional.empty();

        private Optional<Double> minValue = Optional.empty();

        private Optional<List<Double>> allowedValues = Optional.empty();

        private Optional<Boolean> isUnique = Optional.empty();

        private Optional<Boolean> inlineEditable = Optional.empty();

        private Optional<NumberFieldEditor> editor = Optional.empty();

        private Builder() {}

        public Builder from(NumberFieldPropertiesDto other) {
            defaultValues(other.getDefaultValues());
            defaultValue(other.getDefaultValue());
            maxValue(other.getMaxValue());
            minValue(other.getMinValue());
            allowedValues(other.getAllowedValues());
            isUnique(other.getIsUnique());
            inlineEditable(other.getInlineEditable());
            editor(other.getEditor());
            return this;
        }

        @JsonSetter(value = "defaultValues", nulls = Nulls.SKIP)
        public Builder defaultValues(Optional<Map<String, Optional<Double>>> defaultValues) {
            this.defaultValues = defaultValues;
            return this;
        }

        public Builder defaultValues(Map<String, Optional<Double>> defaultValues) {
            this.defaultValues = Optional.of(defaultValues);
            return this;
        }

        @JsonSetter(value = "defaultValue", nulls = Nulls.SKIP)
        public Builder defaultValue(Optional<Double> defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }

        public Builder defaultValue(Double defaultValue) {
            this.defaultValue = Optional.of(defaultValue);
            return this;
        }

        @JsonSetter(value = "maxValue", nulls = Nulls.SKIP)
        public Builder maxValue(Optional<Double> maxValue) {
            this.maxValue = maxValue;
            return this;
        }

        public Builder maxValue(Double maxValue) {
            this.maxValue = Optional.of(maxValue);
            return this;
        }

        @JsonSetter(value = "minValue", nulls = Nulls.SKIP)
        public Builder minValue(Optional<Double> minValue) {
            this.minValue = minValue;
            return this;
        }

        public Builder minValue(Double minValue) {
            this.minValue = Optional.of(minValue);
            return this;
        }

        @JsonSetter(value = "allowedValues", nulls = Nulls.SKIP)
        public Builder allowedValues(Optional<List<Double>> allowedValues) {
            this.allowedValues = allowedValues;
            return this;
        }

        public Builder allowedValues(List<Double> allowedValues) {
            this.allowedValues = Optional.of(allowedValues);
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

        @JsonSetter(value = "inlineEditable", nulls = Nulls.SKIP)
        public Builder inlineEditable(Optional<Boolean> inlineEditable) {
            this.inlineEditable = inlineEditable;
            return this;
        }

        public Builder inlineEditable(Boolean inlineEditable) {
            this.inlineEditable = Optional.of(inlineEditable);
            return this;
        }

        @JsonSetter(value = "editor", nulls = Nulls.SKIP)
        public Builder editor(Optional<NumberFieldEditor> editor) {
            this.editor = editor;
            return this;
        }

        public Builder editor(NumberFieldEditor editor) {
            this.editor = Optional.of(editor);
            return this;
        }

        public NumberFieldPropertiesDto build() {
            return new NumberFieldPropertiesDto(
                    defaultValues, defaultValue, maxValue, minValue, allowedValues, isUnique, inlineEditable, editor);
        }
    }
}
