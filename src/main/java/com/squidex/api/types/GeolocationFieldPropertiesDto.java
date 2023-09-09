package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GeolocationFieldPropertiesDto.Builder.class)
public final class GeolocationFieldPropertiesDto {
    private final Optional<String> editor;

    private GeolocationFieldPropertiesDto(Optional<String> editor) {
        this.editor = editor;
    }

    /**
     * @return The editor that is used to manage this field.
     */
    @JsonProperty("editor")
    public Optional<String> getEditor() {
        return editor;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GeolocationFieldPropertiesDto && equalTo((GeolocationFieldPropertiesDto) other);
    }

    private boolean equalTo(GeolocationFieldPropertiesDto other) {
        return editor.equals(other.editor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.editor);
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
        private Optional<String> editor = Optional.empty();

        private Builder() {}

        public Builder from(GeolocationFieldPropertiesDto other) {
            editor(other.getEditor());
            return this;
        }

        @JsonSetter(value = "editor", nulls = Nulls.SKIP)
        public Builder editor(Optional<String> editor) {
            this.editor = editor;
            return this;
        }

        public Builder editor(String editor) {
            this.editor = Optional.of(editor);
            return this;
        }

        public GeolocationFieldPropertiesDto build() {
            return new GeolocationFieldPropertiesDto(editor);
        }
    }
}
