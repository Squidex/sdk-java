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
@JsonDeserialize(builder = MediumRuleActionDto.Builder.class)
public final class MediumRuleActionDto {
    private final String accessToken;

    private final String title;

    private final String content;

    private final Optional<String> canonicalUrl;

    private final Optional<String> tags;

    private final Optional<String> publicationId;

    private final boolean isHtml;

    private MediumRuleActionDto(
            String accessToken,
            String title,
            String content,
            Optional<String> canonicalUrl,
            Optional<String> tags,
            Optional<String> publicationId,
            boolean isHtml) {
        this.accessToken = accessToken;
        this.title = title;
        this.content = content;
        this.canonicalUrl = canonicalUrl;
        this.tags = tags;
        this.publicationId = publicationId;
        this.isHtml = isHtml;
    }

    /**
     * @return The self issued access token. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("accessToken")
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * @return The title, used for the url. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * @return The content, either html or markdown. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    /**
     * @return The original home of this content, if it was originally published elsewhere.
     */
    @JsonProperty("canonicalUrl")
    public Optional<String> getCanonicalUrl() {
        return canonicalUrl;
    }

    /**
     * @return The optional comma separated list of tags.
     */
    @JsonProperty("tags")
    public Optional<String> getTags() {
        return tags;
    }

    /**
     * @return Optional publication id.
     */
    @JsonProperty("publicationId")
    public Optional<String> getPublicationId() {
        return publicationId;
    }

    /**
     * @return Indicates whether the content is markdown or html.
     */
    @JsonProperty("isHtml")
    public boolean getIsHtml() {
        return isHtml;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof MediumRuleActionDto && equalTo((MediumRuleActionDto) other);
    }

    private boolean equalTo(MediumRuleActionDto other) {
        return accessToken.equals(other.accessToken)
                && title.equals(other.title)
                && content.equals(other.content)
                && canonicalUrl.equals(other.canonicalUrl)
                && tags.equals(other.tags)
                && publicationId.equals(other.publicationId)
                && isHtml == other.isHtml;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.accessToken,
                this.title,
                this.content,
                this.canonicalUrl,
                this.tags,
                this.publicationId,
                this.isHtml);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static AccessTokenStage builder() {
        return new Builder();
    }

    public interface AccessTokenStage {
        TitleStage accessToken(String accessToken);

        Builder from(MediumRuleActionDto other);
    }

    public interface TitleStage {
        ContentStage title(String title);
    }

    public interface ContentStage {
        IsHtmlStage content(String content);
    }

    public interface IsHtmlStage {
        _FinalStage isHtml(boolean isHtml);
    }

    public interface _FinalStage {
        MediumRuleActionDto build();

        _FinalStage canonicalUrl(Optional<String> canonicalUrl);

        _FinalStage canonicalUrl(String canonicalUrl);

        _FinalStage tags(Optional<String> tags);

        _FinalStage tags(String tags);

        _FinalStage publicationId(Optional<String> publicationId);

        _FinalStage publicationId(String publicationId);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements AccessTokenStage, TitleStage, ContentStage, IsHtmlStage, _FinalStage {
        private String accessToken;

        private String title;

        private String content;

        private boolean isHtml;

        private Optional<String> publicationId = Optional.empty();

        private Optional<String> tags = Optional.empty();

        private Optional<String> canonicalUrl = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(MediumRuleActionDto other) {
            accessToken(other.getAccessToken());
            title(other.getTitle());
            content(other.getContent());
            canonicalUrl(other.getCanonicalUrl());
            tags(other.getTags());
            publicationId(other.getPublicationId());
            isHtml(other.getIsHtml());
            return this;
        }

        /**
         * <p>The self issued access token. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("accessToken")
        public TitleStage accessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        /**
         * <p>The title, used for the url. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("title")
        public ContentStage title(String title) {
            this.title = title;
            return this;
        }

        /**
         * <p>The content, either html or markdown. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("content")
        public IsHtmlStage content(String content) {
            this.content = content;
            return this;
        }

        /**
         * <p>Indicates whether the content is markdown or html.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("isHtml")
        public _FinalStage isHtml(boolean isHtml) {
            this.isHtml = isHtml;
            return this;
        }

        /**
         * <p>Optional publication id.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage publicationId(String publicationId) {
            this.publicationId = Optional.of(publicationId);
            return this;
        }

        @Override
        @JsonSetter(value = "publicationId", nulls = Nulls.SKIP)
        public _FinalStage publicationId(Optional<String> publicationId) {
            this.publicationId = publicationId;
            return this;
        }

        /**
         * <p>The optional comma separated list of tags.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage tags(String tags) {
            this.tags = Optional.of(tags);
            return this;
        }

        @Override
        @JsonSetter(value = "tags", nulls = Nulls.SKIP)
        public _FinalStage tags(Optional<String> tags) {
            this.tags = tags;
            return this;
        }

        /**
         * <p>The original home of this content, if it was originally published elsewhere.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage canonicalUrl(String canonicalUrl) {
            this.canonicalUrl = Optional.of(canonicalUrl);
            return this;
        }

        @Override
        @JsonSetter(value = "canonicalUrl", nulls = Nulls.SKIP)
        public _FinalStage canonicalUrl(Optional<String> canonicalUrl) {
            this.canonicalUrl = canonicalUrl;
            return this;
        }

        @Override
        public MediumRuleActionDto build() {
            return new MediumRuleActionDto(accessToken, title, content, canonicalUrl, tags, publicationId, isHtml);
        }
    }
}
