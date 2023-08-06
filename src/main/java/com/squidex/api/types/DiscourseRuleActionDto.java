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
@JsonDeserialize(builder = DiscourseRuleActionDto.Builder.class)
public final class DiscourseRuleActionDto {
    private final String url;

    private final String apiKey;

    private final String apiUsername;

    private final String text;

    private final Optional<String> title;

    private final Optional<Integer> topic;

    private final Optional<Integer> category;

    private DiscourseRuleActionDto(
            String url,
            String apiKey,
            String apiUsername,
            String text,
            Optional<String> title,
            Optional<Integer> topic,
            Optional<Integer> category) {
        this.url = url;
        this.apiKey = apiKey;
        this.apiUsername = apiUsername;
        this.text = text;
        this.title = title;
        this.topic = topic;
        this.category = category;
    }

    /**
     * @return The url to the discourse server. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * @return The api key to authenticate to your discourse server. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("apiKey")
    public String getApiKey() {
        return apiKey;
    }

    /**
     * @return The api username to authenticate to your discourse server. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("apiUsername")
    public String getApiUsername() {
        return apiUsername;
    }

    /**
     * @return The text as markdown. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * @return The optional title when creating new topics.
     */
    @JsonProperty("title")
    public Optional<String> getTitle() {
        return title;
    }

    /**
     * @return The optional topic id.
     */
    @JsonProperty("topic")
    public Optional<Integer> getTopic() {
        return topic;
    }

    /**
     * @return The optional category id.
     */
    @JsonProperty("category")
    public Optional<Integer> getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DiscourseRuleActionDto && equalTo((DiscourseRuleActionDto) other);
    }

    private boolean equalTo(DiscourseRuleActionDto other) {
        return url.equals(other.url)
                && apiKey.equals(other.apiKey)
                && apiUsername.equals(other.apiUsername)
                && text.equals(other.text)
                && title.equals(other.title)
                && topic.equals(other.topic)
                && category.equals(other.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.url, this.apiKey, this.apiUsername, this.text, this.title, this.topic, this.category);
    }

    @Override
    public String toString() {
        return "DiscourseRuleActionDto{" + "url: " + url + ", apiKey: " + apiKey + ", apiUsername: " + apiUsername
                + ", text: " + text + ", title: " + title + ", topic: " + topic + ", category: " + category + "}";
    }

    public static UrlStage builder() {
        return new Builder();
    }

    public interface UrlStage {
        ApiKeyStage url(String url);

        Builder from(DiscourseRuleActionDto other);
    }

    public interface ApiKeyStage {
        ApiUsernameStage apiKey(String apiKey);
    }

    public interface ApiUsernameStage {
        TextStage apiUsername(String apiUsername);
    }

    public interface TextStage {
        _FinalStage text(String text);
    }

    public interface _FinalStage {
        DiscourseRuleActionDto build();

        _FinalStage title(Optional<String> title);

        _FinalStage title(String title);

        _FinalStage topic(Optional<Integer> topic);

        _FinalStage topic(Integer topic);

        _FinalStage category(Optional<Integer> category);

        _FinalStage category(Integer category);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements UrlStage, ApiKeyStage, ApiUsernameStage, TextStage, _FinalStage {
        private String url;

        private String apiKey;

        private String apiUsername;

        private String text;

        private Optional<Integer> category = Optional.empty();

        private Optional<Integer> topic = Optional.empty();

        private Optional<String> title = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(DiscourseRuleActionDto other) {
            url(other.getUrl());
            apiKey(other.getApiKey());
            apiUsername(other.getApiUsername());
            text(other.getText());
            title(other.getTitle());
            topic(other.getTopic());
            category(other.getCategory());
            return this;
        }

        /**
         * <p>The url to the discourse server. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("url")
        public ApiKeyStage url(String url) {
            this.url = url;
            return this;
        }

        /**
         * <p>The api key to authenticate to your discourse server. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("apiKey")
        public ApiUsernameStage apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        /**
         * <p>The api username to authenticate to your discourse server. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("apiUsername")
        public TextStage apiUsername(String apiUsername) {
            this.apiUsername = apiUsername;
            return this;
        }

        /**
         * <p>The text as markdown. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("text")
        public _FinalStage text(String text) {
            this.text = text;
            return this;
        }

        /**
         * <p>The optional category id.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage category(Integer category) {
            this.category = Optional.of(category);
            return this;
        }

        @Override
        @JsonSetter(value = "category", nulls = Nulls.SKIP)
        public _FinalStage category(Optional<Integer> category) {
            this.category = category;
            return this;
        }

        /**
         * <p>The optional topic id.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage topic(Integer topic) {
            this.topic = Optional.of(topic);
            return this;
        }

        @Override
        @JsonSetter(value = "topic", nulls = Nulls.SKIP)
        public _FinalStage topic(Optional<Integer> topic) {
            this.topic = topic;
            return this;
        }

        /**
         * <p>The optional title when creating new topics.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage title(String title) {
            this.title = Optional.of(title);
            return this;
        }

        @Override
        @JsonSetter(value = "title", nulls = Nulls.SKIP)
        public _FinalStage title(Optional<String> title) {
            this.title = title;
            return this;
        }

        @Override
        public DiscourseRuleActionDto build() {
            return new DiscourseRuleActionDto(url, apiKey, apiUsername, text, title, topic, category);
        }
    }
}
