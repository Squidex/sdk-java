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
@JsonDeserialize(builder = CommentRuleActionDto.Builder.class)
public final class CommentRuleActionDto {
    private final String text;

    private final Optional<String> client;

    private CommentRuleActionDto(String text, Optional<String> client) {
        this.text = text;
        this.client = client;
    }

    /**
     * @return The comment text. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * @return An optional client name.
     */
    @JsonProperty("client")
    public Optional<String> getClient() {
        return client;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CommentRuleActionDto && equalTo((CommentRuleActionDto) other);
    }

    private boolean equalTo(CommentRuleActionDto other) {
        return text.equals(other.text) && client.equals(other.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.text, this.client);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TextStage builder() {
        return new Builder();
    }

    public interface TextStage {
        _FinalStage text(String text);

        Builder from(CommentRuleActionDto other);
    }

    public interface _FinalStage {
        CommentRuleActionDto build();

        _FinalStage client(Optional<String> client);

        _FinalStage client(String client);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TextStage, _FinalStage {
        private String text;

        private Optional<String> client = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(CommentRuleActionDto other) {
            text(other.getText());
            client(other.getClient());
            return this;
        }

        /**
         * <p>The comment text. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("text")
        public _FinalStage text(String text) {
            this.text = text;
            return this;
        }

        /**
         * <p>An optional client name.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage client(String client) {
            this.client = Optional.of(client);
            return this;
        }

        @Override
        @JsonSetter(value = "client", nulls = Nulls.SKIP)
        public _FinalStage client(Optional<String> client) {
            this.client = client;
            return this;
        }

        @Override
        public CommentRuleActionDto build() {
            return new CommentRuleActionDto(text, client);
        }
    }
}
