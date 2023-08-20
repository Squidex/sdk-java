package com.squidex.api.resources.translations.requests;

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
@JsonDeserialize(builder = TranslateDto.Builder.class)
public final class TranslateDto {
    private final String text;

    private final String targetLanguage;

    private final Optional<String> sourceLanguage;

    private TranslateDto(String text, String targetLanguage, Optional<String> sourceLanguage) {
        this.text = text;
        this.targetLanguage = targetLanguage;
        this.sourceLanguage = sourceLanguage;
    }

    /**
     * @return The text to translate. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * @return The target language. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("targetLanguage")
    public String getTargetLanguage() {
        return targetLanguage;
    }

    /**
     * @return The optional source language.
     */
    @JsonProperty("sourceLanguage")
    public Optional<String> getSourceLanguage() {
        return sourceLanguage;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TranslateDto && equalTo((TranslateDto) other);
    }

    private boolean equalTo(TranslateDto other) {
        return text.equals(other.text)
                && targetLanguage.equals(other.targetLanguage)
                && sourceLanguage.equals(other.sourceLanguage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.text, this.targetLanguage, this.sourceLanguage);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TextStage builder() {
        return new Builder();
    }

    public interface TextStage {
        TargetLanguageStage text(String text);

        Builder from(TranslateDto other);
    }

    public interface TargetLanguageStage {
        _FinalStage targetLanguage(String targetLanguage);
    }

    public interface _FinalStage {
        TranslateDto build();

        _FinalStage sourceLanguage(Optional<String> sourceLanguage);

        _FinalStage sourceLanguage(String sourceLanguage);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TextStage, TargetLanguageStage, _FinalStage {
        private String text;

        private String targetLanguage;

        private Optional<String> sourceLanguage = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(TranslateDto other) {
            text(other.getText());
            targetLanguage(other.getTargetLanguage());
            sourceLanguage(other.getSourceLanguage());
            return this;
        }

        /**
         * <p>The text to translate. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("text")
        public TargetLanguageStage text(String text) {
            this.text = text;
            return this;
        }

        /**
         * <p>The target language. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("targetLanguage")
        public _FinalStage targetLanguage(String targetLanguage) {
            this.targetLanguage = targetLanguage;
            return this;
        }

        /**
         * <p>The optional source language.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage sourceLanguage(String sourceLanguage) {
            this.sourceLanguage = Optional.of(sourceLanguage);
            return this;
        }

        @Override
        @JsonSetter(value = "sourceLanguage", nulls = Nulls.SKIP)
        public _FinalStage sourceLanguage(Optional<String> sourceLanguage) {
            this.sourceLanguage = sourceLanguage;
            return this;
        }

        @Override
        public TranslateDto build() {
            return new TranslateDto(text, targetLanguage, sourceLanguage);
        }
    }
}
