package com.squidex.api.resources.contents.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ContentsGetContentVersionRequest.Builder.class)
public final class ContentsGetContentVersionRequest {
    private final Optional<Boolean> unpublished;

    private final Optional<String> languages;

    private ContentsGetContentVersionRequest(Optional<Boolean> unpublished, Optional<String> languages) {
        this.unpublished = unpublished;
        this.languages = languages;
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

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ContentsGetContentVersionRequest && equalTo((ContentsGetContentVersionRequest) other);
    }

    private boolean equalTo(ContentsGetContentVersionRequest other) {
        return unpublished.equals(other.unpublished) && languages.equals(other.languages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.unpublished, this.languages);
    }

    @Override
    public String toString() {
        return "ContentsGetContentVersionRequest{" + "unpublished: " + unpublished + ", languages: " + languages + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Boolean> unpublished = Optional.empty();

        private Optional<String> languages = Optional.empty();

        private Builder() {}

        public Builder from(ContentsGetContentVersionRequest other) {
            unpublished(other.getUnpublished());
            languages(other.getLanguages());
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

        public ContentsGetContentVersionRequest build() {
            return new ContentsGetContentVersionRequest(unpublished, languages);
        }
    }
}
