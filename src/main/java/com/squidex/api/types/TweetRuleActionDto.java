package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TweetRuleActionDto.Builder.class)
public final class TweetRuleActionDto {
    private final String accessToken;

    private final String accessSecret;

    private final String text;

    private TweetRuleActionDto(String accessToken, String accessSecret, String text) {
        this.accessToken = accessToken;
        this.accessSecret = accessSecret;
        this.text = text;
    }

    /**
     * @return The generated access token. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("accessToken")
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * @return The generated access secret. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("accessSecret")
    public String getAccessSecret() {
        return accessSecret;
    }

    /**
     * @return The text that is sent as tweet to twitter. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TweetRuleActionDto && equalTo((TweetRuleActionDto) other);
    }

    private boolean equalTo(TweetRuleActionDto other) {
        return accessToken.equals(other.accessToken)
                && accessSecret.equals(other.accessSecret)
                && text.equals(other.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.accessToken, this.accessSecret, this.text);
    }

    @Override
    public String toString() {
        return "TweetRuleActionDto{" + "accessToken: " + accessToken + ", accessSecret: " + accessSecret + ", text: "
                + text + "}";
    }

    public static AccessTokenStage builder() {
        return new Builder();
    }

    public interface AccessTokenStage {
        AccessSecretStage accessToken(String accessToken);

        Builder from(TweetRuleActionDto other);
    }

    public interface AccessSecretStage {
        TextStage accessSecret(String accessSecret);
    }

    public interface TextStage {
        _FinalStage text(String text);
    }

    public interface _FinalStage {
        TweetRuleActionDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements AccessTokenStage, AccessSecretStage, TextStage, _FinalStage {
        private String accessToken;

        private String accessSecret;

        private String text;

        private Builder() {}

        @Override
        public Builder from(TweetRuleActionDto other) {
            accessToken(other.getAccessToken());
            accessSecret(other.getAccessSecret());
            text(other.getText());
            return this;
        }

        /**
         * <p>The generated access token. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("accessToken")
        public AccessSecretStage accessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        /**
         * <p>The generated access secret. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("accessSecret")
        public TextStage accessSecret(String accessSecret) {
            this.accessSecret = accessSecret;
            return this;
        }

        /**
         * <p>The text that is sent as tweet to twitter. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("text")
        public _FinalStage text(String text) {
            this.text = text;
            return this;
        }

        @Override
        public TweetRuleActionDto build() {
            return new TweetRuleActionDto(accessToken, accessSecret, text);
        }
    }
}
