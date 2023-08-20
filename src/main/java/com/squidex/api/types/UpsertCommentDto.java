package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UpsertCommentDto.Builder.class)
public final class UpsertCommentDto {
    private final String text;

    private final Optional<String> url;

    private UpsertCommentDto(String text, Optional<String> url) {
        this.text = text;
        this.url = url;
    }

    /**
     * @return The comment text. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * @return The url where the comment is created.
     */
    @JsonProperty("url")
    public Optional<String> getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpsertCommentDto && equalTo((UpsertCommentDto) other);
    }

    private boolean equalTo(UpsertCommentDto other) {
        return text.equals(other.text) && url.equals(other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.text, this.url);
    }

    @Override
    public String toString() {
        return "UpsertCommentDto{" + "text: " + text + ", url: " + url + "}";
    }

    public static TextStage builder() {
        return new Builder();
    }

    public interface TextStage {
        _FinalStage text(String text);

        Builder from(UpsertCommentDto other);
    }

    public interface _FinalStage {
        UpsertCommentDto build();

        _FinalStage url(Optional<String> url);

        _FinalStage url(String url);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TextStage, _FinalStage {
        private String text;

        private Optional<String> url = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(UpsertCommentDto other) {
            text(other.getText());
            url(other.getUrl());
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
         * <p>The url where the comment is created.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage url(String url) {
            this.url = Optional.of(url);
            return this;
        }

        @Override
        @JsonSetter(value = "url", nulls = Nulls.SKIP)
        public _FinalStage url(Optional<String> url) {
            this.url = url;
            return this;
        }

        @Override
        public UpsertCommentDto build() {
            return new UpsertCommentDto(text, url);
        }
    }
}
