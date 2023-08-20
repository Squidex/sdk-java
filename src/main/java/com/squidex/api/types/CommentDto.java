package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CommentDto.Builder.class)
public final class CommentDto {
    private final String id;

    private final OffsetDateTime time;

    private final String user;

    private final String text;

    private final Optional<String> url;

    private CommentDto(String id, OffsetDateTime time, String user, String text, Optional<String> url) {
        this.id = id;
        this.time = time;
        this.user = user;
        this.text = text;
        this.url = url;
    }

    /**
     * @return The ID of the comment.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The time when the comment was created or updated last.
     */
    @JsonProperty("time")
    public OffsetDateTime getTime() {
        return time;
    }

    /**
     * @return The user who created or updated the comment.
     */
    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    /**
     * @return The text of the comment.
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
        return other instanceof CommentDto && equalTo((CommentDto) other);
    }

    private boolean equalTo(CommentDto other) {
        return id.equals(other.id)
                && time.equals(other.time)
                && user.equals(other.user)
                && text.equals(other.text)
                && url.equals(other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.time, this.user, this.text, this.url);
    }

    @Override
    public String toString() {
        return "CommentDto{" + "id: " + id + ", time: " + time + ", user: " + user + ", text: " + text + ", url: " + url
                + "}";
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        TimeStage id(String id);

        Builder from(CommentDto other);
    }

    public interface TimeStage {
        UserStage time(OffsetDateTime time);
    }

    public interface UserStage {
        TextStage user(String user);
    }

    public interface TextStage {
        _FinalStage text(String text);
    }

    public interface _FinalStage {
        CommentDto build();

        _FinalStage url(Optional<String> url);

        _FinalStage url(String url);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, TimeStage, UserStage, TextStage, _FinalStage {
        private String id;

        private OffsetDateTime time;

        private String user;

        private String text;

        private Optional<String> url = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(CommentDto other) {
            id(other.getId());
            time(other.getTime());
            user(other.getUser());
            text(other.getText());
            url(other.getUrl());
            return this;
        }

        /**
         * <p>The ID of the comment.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("id")
        public TimeStage id(String id) {
            this.id = id;
            return this;
        }

        /**
         * <p>The time when the comment was created or updated last.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("time")
        public UserStage time(OffsetDateTime time) {
            this.time = time;
            return this;
        }

        /**
         * <p>The user who created or updated the comment.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("user")
        public TextStage user(String user) {
            this.user = user;
            return this;
        }

        /**
         * <p>The text of the comment.</p>
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
        public CommentDto build() {
            return new CommentDto(id, time, user, text, url);
        }
    }
}
