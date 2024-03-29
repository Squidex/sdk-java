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
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TranslationDto.Builder.class)
public final class TranslationDto {
    private final TranslationStatus status;

    private final TranslationStatus result;

    private final Optional<String> text;

    private TranslationDto(TranslationStatus status, TranslationStatus result, Optional<String> text) {
        this.status = status;
        this.result = result;
        this.text = text;
    }

    /**
     * @return The result of the translation.
     */
    @JsonProperty("status")
    public TranslationStatus getStatus() {
        return status;
    }

    /**
     * @return The result of the translation.
     */
    @JsonProperty("result")
    public TranslationStatus getResult() {
        return result;
    }

    /**
     * @return The translated text.
     */
    @JsonProperty("text")
    public Optional<String> getText() {
        return text;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TranslationDto && equalTo((TranslationDto) other);
    }

    private boolean equalTo(TranslationDto other) {
        return status.equals(other.status) && result.equals(other.result) && text.equals(other.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.status, this.result, this.text);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static StatusStage builder() {
        return new Builder();
    }

    public interface StatusStage {
        ResultStage status(TranslationStatus status);

        Builder from(TranslationDto other);
    }

    public interface ResultStage {
        _FinalStage result(TranslationStatus result);
    }

    public interface _FinalStage {
        TranslationDto build();

        _FinalStage text(Optional<String> text);

        _FinalStage text(String text);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements StatusStage, ResultStage, _FinalStage {
        private TranslationStatus status;

        private TranslationStatus result;

        private Optional<String> text = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(TranslationDto other) {
            status(other.getStatus());
            result(other.getResult());
            text(other.getText());
            return this;
        }

        /**
         * <p>The result of the translation.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("status")
        public ResultStage status(TranslationStatus status) {
            this.status = status;
            return this;
        }

        /**
         * <p>The result of the translation.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("result")
        public _FinalStage result(TranslationStatus result) {
            this.result = result;
            return this;
        }

        /**
         * <p>The translated text.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage text(String text) {
            this.text = Optional.of(text);
            return this;
        }

        @Override
        @JsonSetter(value = "text", nulls = Nulls.SKIP)
        public _FinalStage text(Optional<String> text) {
            this.text = text;
            return this;
        }

        @Override
        public TranslationDto build() {
            return new TranslationDto(status, result, text);
        }
    }
}
