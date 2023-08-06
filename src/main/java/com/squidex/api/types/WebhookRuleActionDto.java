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
@JsonDeserialize(builder = WebhookRuleActionDto.Builder.class)
public final class WebhookRuleActionDto {
    private final String url;

    private final WebhookMethod method;

    private final Optional<String> payload;

    private final Optional<String> payloadType;

    private final Optional<String> headers;

    private final Optional<String> sharedSecret;

    private WebhookRuleActionDto(
            String url,
            WebhookMethod method,
            Optional<String> payload,
            Optional<String> payloadType,
            Optional<String> headers,
            Optional<String> sharedSecret) {
        this.url = url;
        this.method = method;
        this.payload = payload;
        this.payloadType = payloadType;
        this.headers = headers;
        this.sharedSecret = sharedSecret;
    }

    /**
     * @return The url to the webhook. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("method")
    public WebhookMethod getMethod() {
        return method;
    }

    /**
     * @return Leave it empty to use the full event as body.
     */
    @JsonProperty("payload")
    public Optional<String> getPayload() {
        return payload;
    }

    /**
     * @return The mime type of the payload.
     */
    @JsonProperty("payloadType")
    public Optional<String> getPayloadType() {
        return payloadType;
    }

    /**
     * @return The message headers in the format '[Key]=[Value]', one entry per line.
     */
    @JsonProperty("headers")
    public Optional<String> getHeaders() {
        return headers;
    }

    /**
     * @return The shared secret that is used to calculate the payload signature.
     */
    @JsonProperty("sharedSecret")
    public Optional<String> getSharedSecret() {
        return sharedSecret;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof WebhookRuleActionDto && equalTo((WebhookRuleActionDto) other);
    }

    private boolean equalTo(WebhookRuleActionDto other) {
        return url.equals(other.url)
                && method.equals(other.method)
                && payload.equals(other.payload)
                && payloadType.equals(other.payloadType)
                && headers.equals(other.headers)
                && sharedSecret.equals(other.sharedSecret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.url, this.method, this.payload, this.payloadType, this.headers, this.sharedSecret);
    }

    @Override
    public String toString() {
        return "WebhookRuleActionDto{" + "url: " + url + ", method: " + method + ", payload: " + payload
                + ", payloadType: " + payloadType + ", headers: " + headers + ", sharedSecret: " + sharedSecret + "}";
    }

    public static UrlStage builder() {
        return new Builder();
    }

    public interface UrlStage {
        MethodStage url(String url);

        Builder from(WebhookRuleActionDto other);
    }

    public interface MethodStage {
        _FinalStage method(WebhookMethod method);
    }

    public interface _FinalStage {
        WebhookRuleActionDto build();

        _FinalStage payload(Optional<String> payload);

        _FinalStage payload(String payload);

        _FinalStage payloadType(Optional<String> payloadType);

        _FinalStage payloadType(String payloadType);

        _FinalStage headers(Optional<String> headers);

        _FinalStage headers(String headers);

        _FinalStage sharedSecret(Optional<String> sharedSecret);

        _FinalStage sharedSecret(String sharedSecret);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements UrlStage, MethodStage, _FinalStage {
        private String url;

        private WebhookMethod method;

        private Optional<String> sharedSecret = Optional.empty();

        private Optional<String> headers = Optional.empty();

        private Optional<String> payloadType = Optional.empty();

        private Optional<String> payload = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(WebhookRuleActionDto other) {
            url(other.getUrl());
            method(other.getMethod());
            payload(other.getPayload());
            payloadType(other.getPayloadType());
            headers(other.getHeaders());
            sharedSecret(other.getSharedSecret());
            return this;
        }

        /**
         * <p>The url to the webhook. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("url")
        public MethodStage url(String url) {
            this.url = url;
            return this;
        }

        @Override
        @JsonSetter("method")
        public _FinalStage method(WebhookMethod method) {
            this.method = method;
            return this;
        }

        /**
         * <p>The shared secret that is used to calculate the payload signature.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage sharedSecret(String sharedSecret) {
            this.sharedSecret = Optional.of(sharedSecret);
            return this;
        }

        @Override
        @JsonSetter(value = "sharedSecret", nulls = Nulls.SKIP)
        public _FinalStage sharedSecret(Optional<String> sharedSecret) {
            this.sharedSecret = sharedSecret;
            return this;
        }

        /**
         * <p>The message headers in the format '[Key]=[Value]', one entry per line.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage headers(String headers) {
            this.headers = Optional.of(headers);
            return this;
        }

        @Override
        @JsonSetter(value = "headers", nulls = Nulls.SKIP)
        public _FinalStage headers(Optional<String> headers) {
            this.headers = headers;
            return this;
        }

        /**
         * <p>The mime type of the payload.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage payloadType(String payloadType) {
            this.payloadType = Optional.of(payloadType);
            return this;
        }

        @Override
        @JsonSetter(value = "payloadType", nulls = Nulls.SKIP)
        public _FinalStage payloadType(Optional<String> payloadType) {
            this.payloadType = payloadType;
            return this;
        }

        /**
         * <p>Leave it empty to use the full event as body.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage payload(String payload) {
            this.payload = Optional.of(payload);
            return this;
        }

        @Override
        @JsonSetter(value = "payload", nulls = Nulls.SKIP)
        public _FinalStage payload(Optional<String> payload) {
            this.payload = payload;
            return this;
        }

        @Override
        public WebhookRuleActionDto build() {
            return new WebhookRuleActionDto(url, method, payload, payloadType, headers, sharedSecret);
        }
    }
}
