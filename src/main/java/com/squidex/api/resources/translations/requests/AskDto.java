package com.squidex.api.resources.translations.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AskDto.Builder.class)
public final class AskDto {
    private final String prompt;

    private AskDto(String prompt) {
        this.prompt = prompt;
    }

    /**
     * @return The text to ask. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("prompt")
    public String getPrompt() {
        return prompt;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AskDto && equalTo((AskDto) other);
    }

    private boolean equalTo(AskDto other) {
        return prompt.equals(other.prompt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.prompt);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static PromptStage builder() {
        return new Builder();
    }

    public interface PromptStage {
        _FinalStage prompt(String prompt);

        Builder from(AskDto other);
    }

    public interface _FinalStage {
        AskDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements PromptStage, _FinalStage {
        private String prompt;

        private Builder() {}

        @Override
        public Builder from(AskDto other) {
            prompt(other.getPrompt());
            return this;
        }

        /**
         * <p>The text to ask. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("prompt")
        public _FinalStage prompt(String prompt) {
            this.prompt = prompt;
            return this;
        }

        @Override
        public AskDto build() {
            return new AskDto(prompt);
        }
    }
}