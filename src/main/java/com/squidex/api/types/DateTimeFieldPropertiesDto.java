package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = DateTimeFieldPropertiesDto.Builder.class)
public final class DateTimeFieldPropertiesDto {
    private final Optional<Map<String, Optional<OffsetDateTime>>> defaultValues;

    private final Optional<OffsetDateTime> defaultValue;

    private final Optional<OffsetDateTime> maxValue;

    private final Optional<OffsetDateTime> minValue;

    private final Optional<String> format;

    private final Optional<DateTimeFieldEditor> editor;

    private final Optional<DateTimeCalculatedDefaultValue> calculatedDefaultValue;

    private DateTimeFieldPropertiesDto(
            Optional<Map<String, Optional<OffsetDateTime>>> defaultValues,
            Optional<OffsetDateTime> defaultValue,
            Optional<OffsetDateTime> maxValue,
            Optional<OffsetDateTime> minValue,
            Optional<String> format,
            Optional<DateTimeFieldEditor> editor,
            Optional<DateTimeCalculatedDefaultValue> calculatedDefaultValue) {
        this.defaultValues = defaultValues;
        this.defaultValue = defaultValue;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.format = format;
        this.editor = editor;
        this.calculatedDefaultValue = calculatedDefaultValue;
    }

    @JsonProperty("defaultValues")
    public Optional<Map<String, Optional<OffsetDateTime>>> getDefaultValues() {
        return defaultValues;
    }

    /**
     * @return The default value for the field value.
     */
    @JsonProperty("defaultValue")
    public Optional<OffsetDateTime> getDefaultValue() {
        return defaultValue;
    }

    /**
     * @return The maximum allowed value for the field value.
     */
    @JsonProperty("maxValue")
    public Optional<OffsetDateTime> getMaxValue() {
        return maxValue;
    }

    /**
     * @return The minimum allowed value for the field value.
     */
    @JsonProperty("minValue")
    public Optional<OffsetDateTime> getMinValue() {
        return minValue;
    }

    /**
     * @return The format pattern when displayed in the UI.
     */
    @JsonProperty("format")
    public Optional<String> getFormat() {
        return format;
    }

    @JsonProperty("editor")
    public Optional<DateTimeFieldEditor> getEditor() {
        return editor;
    }

    @JsonProperty("calculatedDefaultValue")
    public Optional<DateTimeCalculatedDefaultValue> getCalculatedDefaultValue() {
        return calculatedDefaultValue;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DateTimeFieldPropertiesDto && equalTo((DateTimeFieldPropertiesDto) other);
    }

    private boolean equalTo(DateTimeFieldPropertiesDto other) {
        return defaultValues.equals(other.defaultValues)
                && defaultValue.equals(other.defaultValue)
                && maxValue.equals(other.maxValue)
                && minValue.equals(other.minValue)
                && format.equals(other.format)
                && editor.equals(other.editor)
                && calculatedDefaultValue.equals(other.calculatedDefaultValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.defaultValues,
                this.defaultValue,
                this.maxValue,
                this.minValue,
                this.format,
                this.editor,
                this.calculatedDefaultValue);
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
        private Optional<Map<String, Optional<OffsetDateTime>>> defaultValues = Optional.empty();

        private Optional<OffsetDateTime> defaultValue = Optional.empty();

        private Optional<OffsetDateTime> maxValue = Optional.empty();

        private Optional<OffsetDateTime> minValue = Optional.empty();

        private Optional<String> format = Optional.empty();

        private Optional<DateTimeFieldEditor> editor = Optional.empty();

        private Optional<DateTimeCalculatedDefaultValue> calculatedDefaultValue = Optional.empty();

        private Builder() {}

        public Builder from(DateTimeFieldPropertiesDto other) {
            defaultValues(other.getDefaultValues());
            defaultValue(other.getDefaultValue());
            maxValue(other.getMaxValue());
            minValue(other.getMinValue());
            format(other.getFormat());
            editor(other.getEditor());
            calculatedDefaultValue(other.getCalculatedDefaultValue());
            return this;
        }

        @JsonSetter(value = "defaultValues", nulls = Nulls.SKIP)
        public Builder defaultValues(Optional<Map<String, Optional<OffsetDateTime>>> defaultValues) {
            this.defaultValues = defaultValues;
            return this;
        }

        public Builder defaultValues(Map<String, Optional<OffsetDateTime>> defaultValues) {
            this.defaultValues = Optional.of(defaultValues);
            return this;
        }

        @JsonSetter(value = "defaultValue", nulls = Nulls.SKIP)
        public Builder defaultValue(Optional<OffsetDateTime> defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }

        public Builder defaultValue(OffsetDateTime defaultValue) {
            this.defaultValue = Optional.of(defaultValue);
            return this;
        }

        @JsonSetter(value = "maxValue", nulls = Nulls.SKIP)
        public Builder maxValue(Optional<OffsetDateTime> maxValue) {
            this.maxValue = maxValue;
            return this;
        }

        public Builder maxValue(OffsetDateTime maxValue) {
            this.maxValue = Optional.of(maxValue);
            return this;
        }

        @JsonSetter(value = "minValue", nulls = Nulls.SKIP)
        public Builder minValue(Optional<OffsetDateTime> minValue) {
            this.minValue = minValue;
            return this;
        }

        public Builder minValue(OffsetDateTime minValue) {
            this.minValue = Optional.of(minValue);
            return this;
        }

        @JsonSetter(value = "format", nulls = Nulls.SKIP)
        public Builder format(Optional<String> format) {
            this.format = format;
            return this;
        }

        public Builder format(String format) {
            this.format = Optional.of(format);
            return this;
        }

        @JsonSetter(value = "editor", nulls = Nulls.SKIP)
        public Builder editor(Optional<DateTimeFieldEditor> editor) {
            this.editor = editor;
            return this;
        }

        public Builder editor(DateTimeFieldEditor editor) {
            this.editor = Optional.of(editor);
            return this;
        }

        @JsonSetter(value = "calculatedDefaultValue", nulls = Nulls.SKIP)
        public Builder calculatedDefaultValue(Optional<DateTimeCalculatedDefaultValue> calculatedDefaultValue) {
            this.calculatedDefaultValue = calculatedDefaultValue;
            return this;
        }

        public Builder calculatedDefaultValue(DateTimeCalculatedDefaultValue calculatedDefaultValue) {
            this.calculatedDefaultValue = Optional.of(calculatedDefaultValue);
            return this;
        }

        public DateTimeFieldPropertiesDto build() {
            return new DateTimeFieldPropertiesDto(
                    defaultValues, defaultValue, maxValue, minValue, format, editor, calculatedDefaultValue);
        }
    }
}
