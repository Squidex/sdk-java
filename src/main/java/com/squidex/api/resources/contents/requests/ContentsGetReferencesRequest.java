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
@JsonDeserialize(builder = ContentsGetReferencesRequest.Builder.class)
public final class ContentsGetReferencesRequest {
    private final Optional<Boolean> flatten;

    private final Optional<String> languages;

    private final Optional<Boolean> unpublished;

    private final Optional<Boolean> noSlowTotal;

    private final Optional<Boolean> noTotal;

    private final Optional<String> q;

    private ContentsGetReferencesRequest(
            Optional<Boolean> flatten,
            Optional<String> languages,
            Optional<Boolean> unpublished,
            Optional<Boolean> noSlowTotal,
            Optional<Boolean> noTotal,
            Optional<String> q) {
        this.flatten = flatten;
        this.languages = languages;
        this.unpublished = unpublished;
        this.noSlowTotal = noSlowTotal;
        this.noTotal = noTotal;
        this.q = q;
    }

    /**
     * @return Provide the data as flat object.
     */
    @JsonProperty("X-Flatten")
    public Optional<Boolean> getFlatten() {
        return flatten;
    }

    /**
     * @return Only resolve these languages (comma-separated).
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
     * @return Do not return the total amount, if it would be slow.
     */
    @JsonProperty("X-NoSlowTotal")
    public Optional<Boolean> getNoSlowTotal() {
        return noSlowTotal;
    }

    /**
     * @return Do not return the total amount.
     */
    @JsonProperty("X-NoTotal")
    public Optional<Boolean> getNoTotal() {
        return noTotal;
    }

    /**
     * @return The optional json query.
     */
    @JsonProperty("q")
    public Optional<String> getQ() {
        return q;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ContentsGetReferencesRequest && equalTo((ContentsGetReferencesRequest) other);
    }

    private boolean equalTo(ContentsGetReferencesRequest other) {
        return flatten.equals(other.flatten)
                && languages.equals(other.languages)
                && unpublished.equals(other.unpublished)
                && noSlowTotal.equals(other.noSlowTotal)
                && noTotal.equals(other.noTotal)
                && q.equals(other.q);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.flatten, this.languages, this.unpublished, this.noSlowTotal, this.noTotal, this.q);
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
        private Optional<Boolean> flatten = Optional.empty();

        private Optional<String> languages = Optional.empty();

        private Optional<Boolean> unpublished = Optional.empty();

        private Optional<Boolean> noSlowTotal = Optional.empty();

        private Optional<Boolean> noTotal = Optional.empty();

        private Optional<String> q = Optional.empty();

        private Builder() {}

        public Builder from(ContentsGetReferencesRequest other) {
            flatten(other.getFlatten());
            languages(other.getLanguages());
            unpublished(other.getUnpublished());
            noSlowTotal(other.getNoSlowTotal());
            noTotal(other.getNoTotal());
            q(other.getQ());
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

        @JsonSetter(value = "X-NoSlowTotal", nulls = Nulls.SKIP)
        public Builder noSlowTotal(Optional<Boolean> noSlowTotal) {
            this.noSlowTotal = noSlowTotal;
            return this;
        }

        public Builder noSlowTotal(Boolean noSlowTotal) {
            this.noSlowTotal = Optional.of(noSlowTotal);
            return this;
        }

        @JsonSetter(value = "X-NoTotal", nulls = Nulls.SKIP)
        public Builder noTotal(Optional<Boolean> noTotal) {
            this.noTotal = noTotal;
            return this;
        }

        public Builder noTotal(Boolean noTotal) {
            this.noTotal = Optional.of(noTotal);
            return this;
        }

        @JsonSetter(value = "q", nulls = Nulls.SKIP)
        public Builder q(Optional<String> q) {
            this.q = q;
            return this;
        }

        public Builder q(String q) {
            this.q = Optional.of(q);
            return this;
        }

        public ContentsGetReferencesRequest build() {
            return new ContentsGetReferencesRequest(flatten, languages, unpublished, noSlowTotal, noTotal, q);
        }
    }
}
