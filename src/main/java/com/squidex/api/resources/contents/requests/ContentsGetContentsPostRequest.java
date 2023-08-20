package com.squidex.api.resources.contents.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import com.squidex.api.types.QueryDto;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ContentsGetContentsPostRequest.Builder.class)
public final class ContentsGetContentsPostRequest {
    private final Optional<Boolean> flatten;

    private final Optional<String> languages;

    private final Optional<Boolean> noSlowTotal;

    private final Optional<Boolean> noTotal;

    private final Optional<Boolean> unpublished;

    private final QueryDto body;

    private ContentsGetContentsPostRequest(
            Optional<Boolean> flatten,
            Optional<String> languages,
            Optional<Boolean> noSlowTotal,
            Optional<Boolean> noTotal,
            Optional<Boolean> unpublished,
            QueryDto body) {
        this.flatten = flatten;
        this.languages = languages;
        this.noSlowTotal = noSlowTotal;
        this.noTotal = noTotal;
        this.unpublished = unpublished;
        this.body = body;
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
     * @return Return unpublished content items.
     */
    @JsonProperty("X-Unpublished")
    public Optional<Boolean> getUnpublished() {
        return unpublished;
    }

    @JsonProperty("body")
    public QueryDto getBody() {
        return body;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ContentsGetContentsPostRequest && equalTo((ContentsGetContentsPostRequest) other);
    }

    private boolean equalTo(ContentsGetContentsPostRequest other) {
        return flatten.equals(other.flatten)
                && languages.equals(other.languages)
                && noSlowTotal.equals(other.noSlowTotal)
                && noTotal.equals(other.noTotal)
                && unpublished.equals(other.unpublished)
                && body.equals(other.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.flatten, this.languages, this.noSlowTotal, this.noTotal, this.unpublished, this.body);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static BodyStage builder() {
        return new Builder();
    }

    public interface BodyStage {
        _FinalStage body(QueryDto body);

        Builder from(ContentsGetContentsPostRequest other);
    }

    public interface _FinalStage {
        ContentsGetContentsPostRequest build();

        _FinalStage flatten(Optional<Boolean> flatten);

        _FinalStage flatten(Boolean flatten);

        _FinalStage languages(Optional<String> languages);

        _FinalStage languages(String languages);

        _FinalStage noSlowTotal(Optional<Boolean> noSlowTotal);

        _FinalStage noSlowTotal(Boolean noSlowTotal);

        _FinalStage noTotal(Optional<Boolean> noTotal);

        _FinalStage noTotal(Boolean noTotal);

        _FinalStage unpublished(Optional<Boolean> unpublished);

        _FinalStage unpublished(Boolean unpublished);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements BodyStage, _FinalStage {
        private QueryDto body;

        private Optional<Boolean> unpublished = Optional.empty();

        private Optional<Boolean> noTotal = Optional.empty();

        private Optional<Boolean> noSlowTotal = Optional.empty();

        private Optional<String> languages = Optional.empty();

        private Optional<Boolean> flatten = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(ContentsGetContentsPostRequest other) {
            flatten(other.getFlatten());
            languages(other.getLanguages());
            noSlowTotal(other.getNoSlowTotal());
            noTotal(other.getNoTotal());
            unpublished(other.getUnpublished());
            body(other.getBody());
            return this;
        }

        @Override
        @JsonSetter("body")
        public _FinalStage body(QueryDto body) {
            this.body = body;
            return this;
        }

        /**
         * <p>Return unpublished content items.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage unpublished(Boolean unpublished) {
            this.unpublished = Optional.of(unpublished);
            return this;
        }

        @Override
        @JsonSetter(value = "X-Unpublished", nulls = Nulls.SKIP)
        public _FinalStage unpublished(Optional<Boolean> unpublished) {
            this.unpublished = unpublished;
            return this;
        }

        /**
         * <p>Do not return the total amount.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage noTotal(Boolean noTotal) {
            this.noTotal = Optional.of(noTotal);
            return this;
        }

        @Override
        @JsonSetter(value = "X-NoTotal", nulls = Nulls.SKIP)
        public _FinalStage noTotal(Optional<Boolean> noTotal) {
            this.noTotal = noTotal;
            return this;
        }

        /**
         * <p>Do not return the total amount, if it would be slow.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage noSlowTotal(Boolean noSlowTotal) {
            this.noSlowTotal = Optional.of(noSlowTotal);
            return this;
        }

        @Override
        @JsonSetter(value = "X-NoSlowTotal", nulls = Nulls.SKIP)
        public _FinalStage noSlowTotal(Optional<Boolean> noSlowTotal) {
            this.noSlowTotal = noSlowTotal;
            return this;
        }

        /**
         * <p>Only resolve these languages (comma-separated).</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage languages(String languages) {
            this.languages = Optional.of(languages);
            return this;
        }

        @Override
        @JsonSetter(value = "X-Languages", nulls = Nulls.SKIP)
        public _FinalStage languages(Optional<String> languages) {
            this.languages = languages;
            return this;
        }

        /**
         * <p>Provide the data as flat object.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage flatten(Boolean flatten) {
            this.flatten = Optional.of(flatten);
            return this;
        }

        @Override
        @JsonSetter(value = "X-Flatten", nulls = Nulls.SKIP)
        public _FinalStage flatten(Optional<Boolean> flatten) {
            this.flatten = flatten;
            return this;
        }

        @Override
        public ContentsGetContentsPostRequest build() {
            return new ContentsGetContentsPostRequest(flatten, languages, noSlowTotal, noTotal, unpublished, body);
        }
    }
}
