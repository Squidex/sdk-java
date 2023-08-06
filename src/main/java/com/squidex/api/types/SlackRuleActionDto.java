package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SlackRuleActionDto.Builder.class)
public final class SlackRuleActionDto {
    private final String webhookUrl;

    private final String text;

    private SlackRuleActionDto(String webhookUrl, String text) {
        this.webhookUrl = webhookUrl;
        this.text = text;
    }

    /**
     * @return The slack webhook url. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("webhookUrl")
    public String getWebhookUrl() {
        return webhookUrl;
    }

    /**
     * @return The text that is sent as message to slack. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SlackRuleActionDto && equalTo((SlackRuleActionDto) other);
    }

    private boolean equalTo(SlackRuleActionDto other) {
        return webhookUrl.equals(other.webhookUrl) && text.equals(other.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.webhookUrl, this.text);
    }

    @Override
    public String toString() {
        return "SlackRuleActionDto{" + "webhookUrl: " + webhookUrl + ", text: " + text + "}";
    }

    public static WebhookUrlStage builder() {
        return new Builder();
    }

    public interface WebhookUrlStage {
        TextStage webhookUrl(String webhookUrl);

        Builder from(SlackRuleActionDto other);
    }

    public interface TextStage {
        _FinalStage text(String text);
    }

    public interface _FinalStage {
        SlackRuleActionDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements WebhookUrlStage, TextStage, _FinalStage {
        private String webhookUrl;

        private String text;

        private Builder() {}

        @Override
        public Builder from(SlackRuleActionDto other) {
            webhookUrl(other.getWebhookUrl());
            text(other.getText());
            return this;
        }

        /**
         * <p>The slack webhook url. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("webhookUrl")
        public TextStage webhookUrl(String webhookUrl) {
            this.webhookUrl = webhookUrl;
            return this;
        }

        /**
         * <p>The text that is sent as message to slack. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("text")
        public _FinalStage text(String text) {
            this.text = text;
            return this;
        }

        @Override
        public SlackRuleActionDto build() {
            return new SlackRuleActionDto(webhookUrl, text);
        }
    }
}
