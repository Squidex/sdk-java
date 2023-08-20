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
@JsonDeserialize(builder = NotificationRuleActionDto.Builder.class)
public final class NotificationRuleActionDto {
    private final String user;

    private final String text;

    private final Optional<String> url;

    private final Optional<String> client;

    private NotificationRuleActionDto(String user, String text, Optional<String> url, Optional<String> client) {
        this.user = user;
        this.text = text;
        this.url = url;
        this.client = client;
    }

    /**
     * @return The user id or email. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    /**
     * @return The text to send. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * @return The optional url to attach to the notification.
     */
    @JsonProperty("url")
    public Optional<String> getUrl() {
        return url;
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
        return other instanceof NotificationRuleActionDto && equalTo((NotificationRuleActionDto) other);
    }

    private boolean equalTo(NotificationRuleActionDto other) {
        return user.equals(other.user)
                && text.equals(other.text)
                && url.equals(other.url)
                && client.equals(other.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.user, this.text, this.url, this.client);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static UserStage builder() {
        return new Builder();
    }

    public interface UserStage {
        TextStage user(String user);

        Builder from(NotificationRuleActionDto other);
    }

    public interface TextStage {
        _FinalStage text(String text);
    }

    public interface _FinalStage {
        NotificationRuleActionDto build();

        _FinalStage url(Optional<String> url);

        _FinalStage url(String url);

        _FinalStage client(Optional<String> client);

        _FinalStage client(String client);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements UserStage, TextStage, _FinalStage {
        private String user;

        private String text;

        private Optional<String> client = Optional.empty();

        private Optional<String> url = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(NotificationRuleActionDto other) {
            user(other.getUser());
            text(other.getText());
            url(other.getUrl());
            client(other.getClient());
            return this;
        }

        /**
         * <p>The user id or email. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("user")
        public TextStage user(String user) {
            this.user = user;
            return this;
        }

        /**
         * <p>The text to send. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
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

        /**
         * <p>The optional url to attach to the notification.</p>
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
        public NotificationRuleActionDto build() {
            return new NotificationRuleActionDto(user, text, url, client);
        }
    }
}
