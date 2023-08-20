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
@JsonDeserialize(builder = ResourceLink.Builder.class)
public final class ResourceLink {
    private final String href;

    private final String method;

    private final Optional<String> metadata;

    private ResourceLink(String href, String method, Optional<String> metadata) {
        this.href = href;
        this.method = method;
        this.metadata = metadata;
    }

    /**
     * @return The link url. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    /**
     * @return The link method. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    /**
     * @return Additional data about the link.
     */
    @JsonProperty("metadata")
    public Optional<String> getMetadata() {
        return metadata;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ResourceLink && equalTo((ResourceLink) other);
    }

    private boolean equalTo(ResourceLink other) {
        return href.equals(other.href) && method.equals(other.method) && metadata.equals(other.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.href, this.method, this.metadata);
    }

    @Override
    public String toString() {
        return "ResourceLink{" + "href: " + href + ", method: " + method + ", metadata: " + metadata + "}";
    }

    public static HrefStage builder() {
        return new Builder();
    }

    public interface HrefStage {
        MethodStage href(String href);

        Builder from(ResourceLink other);
    }

    public interface MethodStage {
        _FinalStage method(String method);
    }

    public interface _FinalStage {
        ResourceLink build();

        _FinalStage metadata(Optional<String> metadata);

        _FinalStage metadata(String metadata);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements HrefStage, MethodStage, _FinalStage {
        private String href;

        private String method;

        private Optional<String> metadata = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(ResourceLink other) {
            href(other.getHref());
            method(other.getMethod());
            metadata(other.getMetadata());
            return this;
        }

        /**
         * <p>The link url. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("href")
        public MethodStage href(String href) {
            this.href = href;
            return this;
        }

        /**
         * <p>The link method. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("method")
        public _FinalStage method(String method) {
            this.method = method;
            return this;
        }

        /**
         * <p>Additional data about the link.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage metadata(String metadata) {
            this.metadata = Optional.of(metadata);
            return this;
        }

        @Override
        @JsonSetter(value = "metadata", nulls = Nulls.SKIP)
        public _FinalStage metadata(Optional<String> metadata) {
            this.metadata = metadata;
            return this;
        }

        @Override
        public ResourceLink build() {
            return new ResourceLink(href, method, metadata);
        }
    }
}
