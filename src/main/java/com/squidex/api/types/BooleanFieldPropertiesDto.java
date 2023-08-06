package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = BooleanFieldPropertiesDto.Builder.class)
public final class BooleanFieldPropertiesDto {
    private final Optional<Map<String, Optional<Boolean>>> defaultValues;

    private final Optional<Boolean> defaultValue;

    private final Optional<Boolean> inlineEditable;

    private final Optional<BooleanFieldEditor> editor;

    private BooleanFieldPropertiesDto(
            Optional<Map<String, Optional<Boolean>>> defaultValues,
            Optional<Boolean> defaultValue,
            Optional<Boolean> inlineEditable,
            Optional<BooleanFieldEditor> editor) {
        this.defaultValues = defaultValues;
        this.defaultValue = defaultValue;
        this.inlineEditable = inlineEditable;
        this.editor = editor;
    }

    @JsonProperty("defaultValues")
    public Optional<Map<String, Optional<Boolean>>> getDefaultValues() {
        return defaultValues;
    }

    /**
     * @return The default value for the field value.
     */
    @JsonProperty("defaultValue")
    public Optional<Boolean> getDefaultValue() {
        return defaultValue;
    }

    /**
     * @return Indicates that the inline editor is enabled for this field.
     */
    @JsonProperty("inlineEditable")
    public Optional<Boolean> getInlineEditable() {
        return inlineEditable;
    }

    @JsonProperty("editor")
    public Optional<BooleanFieldEditor> getEditor() {
        return editor;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BooleanFieldPropertiesDto && equalTo((BooleanFieldPropertiesDto) other);
    }

    private boolean equalTo(BooleanFieldPropertiesDto other) {
        return defaultValues.equals(other.defaultValues)
                && defaultValue.equals(other.defaultValue)
                && inlineEditable.equals(other.inlineEditable)
                && editor.equals(other.editor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.defaultValues, this.defaultValue, this.inlineEditable, this.editor);
    }

    @Override
    public String toString() {
        return "BooleanFieldPropertiesDto{" + "defaultValues: " + defaultValues + ", defaultValue: " + defaultValue
                + ", inlineEditable: " + inlineEditable + ", editor: " + editor + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Map<String, Optional<Boolean>>> defaultValues = Optional.empty();

        private Optional<Boolean> defaultValue = Optional.empty();

        private Optional<Boolean> inlineEditable = Optional.empty();

        private Optional<BooleanFieldEditor> editor = Optional.empty();

        private Builder() {}

        public Builder from(BooleanFieldPropertiesDto other) {
            defaultValues(other.getDefaultValues());
            defaultValue(other.getDefaultValue());
            inlineEditable(other.getInlineEditable());
            editor(other.getEditor());
            return this;
        }

        @JsonSetter(value = "defaultValues", nulls = Nulls.SKIP)
        public Builder defaultValues(Optional<Map<String, Optional<Boolean>>> defaultValues) {
            this.defaultValues = defaultValues;
            return this;
        }

        public Builder defaultValues(Map<String, Optional<Boolean>> defaultValues) {
            this.defaultValues = Optional.of(defaultValues);
            return this;
        }

        @JsonSetter(value = "defaultValue", nulls = Nulls.SKIP)
        public Builder defaultValue(Optional<Boolean> defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }

        public Builder defaultValue(Boolean defaultValue) {
            this.defaultValue = Optional.of(defaultValue);
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
        public Builder editor(Optional<BooleanFieldEditor> editor) {
            this.editor = editor;
            return this;
        }

        public Builder editor(BooleanFieldEditor editor) {
            this.editor = Optional.of(editor);
            return this;
        }

        public BooleanFieldPropertiesDto build() {
            return new BooleanFieldPropertiesDto(defaultValues, defaultValue, inlineEditable, editor);
        }
    }
}
