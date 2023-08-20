package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = PrerenderRuleActionDto.Builder.class)
public final class PrerenderRuleActionDto {
    private final String token;

    private final String url;

    private PrerenderRuleActionDto(String token, String url) {
        this.token = token;
        this.url = url;
    }

    /**
     * @return The prerender token from your account. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    /**
     * @return The url to recache. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PrerenderRuleActionDto && equalTo((PrerenderRuleActionDto) other);
    }

    private boolean equalTo(PrerenderRuleActionDto other) {
        return token.equals(other.token) && url.equals(other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.token, this.url);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TokenStage builder() {
        return new Builder();
    }

    public interface TokenStage {
        UrlStage token(String token);

        Builder from(PrerenderRuleActionDto other);
    }

    public interface UrlStage {
        _FinalStage url(String url);
    }

    public interface _FinalStage {
        PrerenderRuleActionDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TokenStage, UrlStage, _FinalStage {
        private String token;

        private String url;

        private Builder() {}

        @Override
        public Builder from(PrerenderRuleActionDto other) {
            token(other.getToken());
            url(other.getUrl());
            return this;
        }

        /**
         * <p>The prerender token from your account. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("token")
        public UrlStage token(String token) {
            this.token = token;
            return this;
        }

        /**
         * <p>The url to recache. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("url")
        public _FinalStage url(String url) {
            this.url = url;
            return this;
        }

        @Override
        public PrerenderRuleActionDto build() {
            return new PrerenderRuleActionDto(token, url);
        }
    }
}
