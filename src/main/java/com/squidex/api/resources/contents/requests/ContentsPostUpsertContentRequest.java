package com.squidex.api.resources.contents.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ContentsPostUpsertContentRequest.Builder.class)
public final class ContentsPostUpsertContentRequest {
    private final Optional<Boolean> unpublished;

    private final Optional<String> languages;

    private final Optional<String> status;

    private final Optional<Boolean> patch;

    private final Optional<Boolean> publish;

    private final Map<String, Map<String, Object>> body;

    private ContentsPostUpsertContentRequest(
            Optional<Boolean> unpublished,
            Optional<String> languages,
            Optional<String> status,
            Optional<Boolean> patch,
            Optional<Boolean> publish,
            Map<String, Map<String, Object>> body) {
        this.unpublished = unpublished;
        this.languages = languages;
        this.status = status;
        this.patch = patch;
        this.publish = publish;
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
     * @return The list of languages to resolve (comma-separated).
     */
    @JsonProperty("X-Languages")
    public Optional<String> getLanguages() {
        return languages;
    }

    /**
     * @return The initial status.
     */
    @JsonProperty("status")
    public Optional<String> getStatus() {
        return status;
    }

    /**
     * @return Makes the update as patch.
     */
    @JsonProperty("patch")
    public Optional<Boolean> getPatch() {
        return patch;
    }

    /**
     * @return True to automatically publish the content.
     */
    @JsonProperty("publish")
    public Optional<Boolean> getPublish() {
        return publish;
    }

    @JsonProperty("body")
    public Map<String, Map<String, Object>> getBody() {
        return body;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ContentsPostUpsertContentRequest && equalTo((ContentsPostUpsertContentRequest) other);
    }

    private boolean equalTo(ContentsPostUpsertContentRequest other) {
        return unpublished.equals(other.unpublished)
                && languages.equals(other.languages)
                && status.equals(other.status)
                && patch.equals(other.patch)
                && publish.equals(other.publish)
                && body.equals(other.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.unpublished, this.languages, this.status, this.patch, this.publish, this.body);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Boolean> unpublished = Optional.empty();

        private Optional<String> languages = Optional.empty();

        private Optional<String> status = Optional.empty();

        private Optional<Boolean> patch = Optional.empty();

        private Optional<Boolean> publish = Optional.empty();

        private Map<String, Map<String, Object>> body = new LinkedHashMap<>();

        private Builder() {}

        public Builder from(ContentsPostUpsertContentRequest other) {
            unpublished(other.getUnpublished());
            languages(other.getLanguages());
            status(other.getStatus());
            patch(other.getPatch());
            publish(other.getPublish());
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

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<String> status) {
            this.status = status;
            return this;
        }

        public Builder status(String status) {
            this.status = Optional.of(status);
            return this;
        }

        @JsonSetter(value = "patch", nulls = Nulls.SKIP)
        public Builder patch(Optional<Boolean> patch) {
            this.patch = patch;
            return this;
        }

        public Builder patch(Boolean patch) {
            this.patch = Optional.of(patch);
            return this;
        }

        @JsonSetter(value = "publish", nulls = Nulls.SKIP)
        public Builder publish(Optional<Boolean> publish) {
            this.publish = publish;
            return this;
        }

        public Builder publish(Boolean publish) {
            this.publish = Optional.of(publish);
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

        public ContentsPostUpsertContentRequest build() {
            return new ContentsPostUpsertContentRequest(unpublished, languages, status, patch, publish, body);
        }
    }
}
