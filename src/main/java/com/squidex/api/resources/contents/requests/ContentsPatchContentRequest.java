package com.squidex.api.resources.contents.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ContentsPatchContentRequest.Builder.class)
public final class ContentsPatchContentRequest {
    private final Optional<Boolean> unpublished;

    private final Optional<String> languages;

    private final Map<String, Map<String, Object>> body;

    private ContentsPatchContentRequest(
            Optional<Boolean> unpublished, Optional<String> languages, Map<String, Map<String, Object>> body) {
        this.unpublished = unpublished;
        this.languages = languages;
        this.body = body;
    }

    /**
     * @return Return unpublished content items.
     */
    @JsonProperty("X-Unpublished")
    public Optional<Boolean> getUnpublished() {
        return unpublished;
    }

    /**
     * @return Only resolve these languages (comma-separated).
     */
    @JsonProperty("X-Languages")
    public Optional<String> getLanguages() {
        return languages;
    }

    @JsonProperty("body")
    public Map<String, Map<String, Object>> getBody() {
        return body;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ContentsPatchContentRequest && equalTo((ContentsPatchContentRequest) other);
    }

    private boolean equalTo(ContentsPatchContentRequest other) {
        return unpublished.equals(other.unpublished) && languages.equals(other.languages) && body.equals(other.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.unpublished, this.languages, this.body);
    }

    @Override
    public String toString() {
        return "ContentsPatchContentRequest{" + "unpublished: " + unpublished + ", languages: " + languages + ", body: "
                + body + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Boolean> unpublished = Optional.empty();

        private Optional<String> languages = Optional.empty();

        private Map<String, Map<String, Object>> body = new LinkedHashMap<>();

        private Builder() {}

        public Builder from(ContentsPatchContentRequest other) {
            unpublished(other.getUnpublished());
            languages(other.getLanguages());
            body(other.getBody());
            return this;
        }

        @JsonSetter(value = "X-Unpublished", nulls = Nulls.SKIP)
        public Builder unpublished(Optional<Boolean> unpublished) {
            this.unpublished = unpublished;
            return this;
        }

        public Builder unpublished(Boolean unpublished) {
            this.unpublished = Optional.of(unpublished);
            return this;
        }

        @JsonSetter(value = "X-Languages", nulls = Nulls.SKIP)
        public Builder languages(Optional<String> languages) {
            this.languages = languages;
            return this;
        }

        public Builder languages(String languages) {
            this.languages = Optional.of(languages);
            return this;
        }

        @JsonSetter(value = "body", nulls = Nulls.SKIP)
        public Builder body(Map<String, Map<String, Object>> body) {
            this.body.clear();
            this.body.putAll(body);
            return this;
        }

        public Builder putAllBody(Map<String, Map<String, Object>> body) {
            this.body.putAll(body);
            return this;
        }

        public Builder body(String key, Map<String, Object> value) {
            this.body.put(key, value);
            return this;
        }

        public ContentsPatchContentRequest build() {
            return new ContentsPatchContentRequest(unpublished, languages, body);
        }
    }
}
