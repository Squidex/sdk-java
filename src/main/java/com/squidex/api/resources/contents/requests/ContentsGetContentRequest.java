package com.squidex.api.resources.contents.requests;

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
@JsonDeserialize(builder = ContentsGetContentRequest.Builder.class)
public final class ContentsGetContentRequest {
    private final Optional<String> fields;

    private final Optional<Boolean> flatten;

    private final Optional<String> languages;

    private final Optional<Boolean> unpublished;

    private final Optional<Integer> version;

    private ContentsGetContentRequest(
            Optional<String> fields,
            Optional<Boolean> flatten,
            Optional<String> languages,
            Optional<Boolean> unpublished,
            Optional<Integer> version) {
        this.fields = fields;
        this.flatten = flatten;
        this.languages = languages;
        this.unpublished = unpublished;
        this.version = version;
    }

    /**
     * @return The list of content fields (comma-separated).
     */
    @JsonProperty("X-Fields")
    public Optional<String> getFields() {
        return fields;
    }

    /**
     * @return Provide the data as flat object.
     */
    @JsonProperty("X-Flatten")
    public Optional<Boolean> getFlatten() {
        return flatten;
    }

    /**
     * @return The list of languages to resolve (comma-separated).
     */
    @JsonProperty("X-Languages")
    public Optional<String> getLanguages() {
        return languages;
    }

    /**
     * @return Return unpublished content items.
     */
    @JsonProperty("X-Unpublished")
    public Optional<Boolean> getUnpublished() {
        return unpublished;
    }

    /**
     * @return The optional version.
     */
    @JsonProperty("version")
    public Optional<Integer> getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ContentsGetContentRequest && equalTo((ContentsGetContentRequest) other);
    }

    private boolean equalTo(ContentsGetContentRequest other) {
        return fields.equals(other.fields)
                && flatten.equals(other.flatten)
                && languages.equals(other.languages)
                && unpublished.equals(other.unpublished)
                && version.equals(other.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fields, this.flatten, this.languages, this.unpublished, this.version);
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
        private Optional<String> fields = Optional.empty();

        private Optional<Boolean> flatten = Optional.empty();

        private Optional<String> languages = Optional.empty();

        private Optional<Boolean> unpublished = Optional.empty();

        private Optional<Integer> version = Optional.empty();

        private Builder() {}

        public Builder from(ContentsGetContentRequest other) {
            fields(other.getFields());
            flatten(other.getFlatten());
            languages(other.getLanguages());
            unpublished(other.getUnpublished());
            version(other.getVersion());
            return this;
        }

        @JsonSetter(value = "X-Fields", nulls = Nulls.SKIP)
        public Builder fields(Optional<String> fields) {
            this.fields = fields;
            return this;
        }

        public Builder fields(String fields) {
            this.fields = Optional.of(fields);
            return this;
        }

        @JsonSetter(value = "X-Flatten", nulls = Nulls.SKIP)
        public Builder flatten(Optional<Boolean> flatten) {
            this.flatten = flatten;
            return this;
        }

        public Builder flatten(Boolean flatten) {
            this.flatten = Optional.of(flatten);
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

        @JsonSetter(value = "X-Unpublished", nulls = Nulls.SKIP)
        public Builder unpublished(Optional<Boolean> unpublished) {
            this.unpublished = unpublished;
            return this;
        }

        public Builder unpublished(Boolean unpublished) {
            this.unpublished = Optional.of(unpublished);
            return this;
        }

        @JsonSetter(value = "version", nulls = Nulls.SKIP)
        public Builder version(Optional<Integer> version) {
            this.version = version;
            return this;
        }

        public Builder version(Integer version) {
            this.version = Optional.of(version);
            return this;
        }

        public ContentsGetContentRequest build() {
            return new ContentsGetContentRequest(fields, flatten, languages, unpublished, version);
        }
    }
}
