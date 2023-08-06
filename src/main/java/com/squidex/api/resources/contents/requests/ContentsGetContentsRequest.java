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
@JsonDeserialize(builder = ContentsGetContentsRequest.Builder.class)
public final class ContentsGetContentsRequest {
    private final Optional<Boolean> flatten;

    private final Optional<String> languages;

    private final Optional<Boolean> noSlowTotal;

    private final Optional<Boolean> noTotal;

    private final Optional<Boolean> unpublished;

    private final Optional<String> ids;

    private final Optional<String> q;

    private final Optional<String> search;

    private final Optional<Double> top;

    private final Optional<Double> skip;

    private final Optional<String> orderby;

    private final Optional<String> filter;

    private ContentsGetContentsRequest(
            Optional<Boolean> flatten,
            Optional<String> languages,
            Optional<Boolean> noSlowTotal,
            Optional<Boolean> noTotal,
            Optional<Boolean> unpublished,
            Optional<String> ids,
            Optional<String> q,
            Optional<String> search,
            Optional<Double> top,
            Optional<Double> skip,
            Optional<String> orderby,
            Optional<String> filter) {
        this.flatten = flatten;
        this.languages = languages;
        this.noSlowTotal = noSlowTotal;
        this.noTotal = noTotal;
        this.unpublished = unpublished;
        this.ids = ids;
        this.q = q;
        this.search = search;
        this.top = top;
        this.skip = skip;
        this.orderby = orderby;
        this.filter = filter;
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

    /**
     * @return The optional ids of the content to fetch.
     */
    @JsonProperty("ids")
    public Optional<String> getIds() {
        return ids;
    }

    /**
     * @return The optional json query.
     */
    @JsonProperty("q")
    public Optional<String> getQ() {
        return q;
    }

    /**
     * @return Optional number of items to skip.
     */
    @JsonProperty("$search")
    public Optional<String> getSearch() {
        return search;
    }

    /**
     * @return Optional number of items to take.
     */
    @JsonProperty("$top")
    public Optional<Double> getTop() {
        return top;
    }

    /**
     * @return Optional number of items to skip.
     */
    @JsonProperty("$skip")
    public Optional<Double> getSkip() {
        return skip;
    }

    /**
     * @return Optional OData order definition.
     */
    @JsonProperty("$orderby")
    public Optional<String> getOrderby() {
        return orderby;
    }

    /**
     * @return Optional OData filter.
     */
    @JsonProperty("$filter")
    public Optional<String> getFilter() {
        return filter;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ContentsGetContentsRequest && equalTo((ContentsGetContentsRequest) other);
    }

    private boolean equalTo(ContentsGetContentsRequest other) {
        return flatten.equals(other.flatten)
                && languages.equals(other.languages)
                && noSlowTotal.equals(other.noSlowTotal)
                && noTotal.equals(other.noTotal)
                && unpublished.equals(other.unpublished)
                && ids.equals(other.ids)
                && q.equals(other.q)
                && search.equals(other.search)
                && top.equals(other.top)
                && skip.equals(other.skip)
                && orderby.equals(other.orderby)
                && filter.equals(other.filter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.flatten,
                this.languages,
                this.noSlowTotal,
                this.noTotal,
                this.unpublished,
                this.ids,
                this.q,
                this.search,
                this.top,
                this.skip,
                this.orderby,
                this.filter);
    }

    @Override
    public String toString() {
        return "ContentsGetContentsRequest{" + "flatten: " + flatten + ", languages: " + languages + ", noSlowTotal: "
                + noSlowTotal + ", noTotal: " + noTotal + ", unpublished: " + unpublished + ", ids: " + ids + ", q: "
                + q + ", search: " + search + ", top: " + top + ", skip: " + skip + ", orderby: " + orderby
                + ", filter: " + filter + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Boolean> flatten = Optional.empty();

        private Optional<String> languages = Optional.empty();

        private Optional<Boolean> noSlowTotal = Optional.empty();

        private Optional<Boolean> noTotal = Optional.empty();

        private Optional<Boolean> unpublished = Optional.empty();

        private Optional<String> ids = Optional.empty();

        private Optional<String> q = Optional.empty();

        private Optional<String> search = Optional.empty();

        private Optional<Double> top = Optional.empty();

        private Optional<Double> skip = Optional.empty();

        private Optional<String> orderby = Optional.empty();

        private Optional<String> filter = Optional.empty();

        private Builder() {}

        public Builder from(ContentsGetContentsRequest other) {
            flatten(other.getFlatten());
            languages(other.getLanguages());
            noSlowTotal(other.getNoSlowTotal());
            noTotal(other.getNoTotal());
            unpublished(other.getUnpublished());
            ids(other.getIds());
            q(other.getQ());
            search(other.getSearch());
            top(other.getTop());
            skip(other.getSkip());
            orderby(other.getOrderby());
            filter(other.getFilter());
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

        @JsonSetter(value = "X-Unpublished", nulls = Nulls.SKIP)
        public Builder unpublished(Optional<Boolean> unpublished) {
            this.unpublished = unpublished;
            return this;
        }

        public Builder unpublished(Boolean unpublished) {
            this.unpublished = Optional.of(unpublished);
            return this;
        }

        @JsonSetter(value = "ids", nulls = Nulls.SKIP)
        public Builder ids(Optional<String> ids) {
            this.ids = ids;
            return this;
        }

        public Builder ids(String ids) {
            this.ids = Optional.of(ids);
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

        @JsonSetter(value = "$search", nulls = Nulls.SKIP)
        public Builder search(Optional<String> search) {
            this.search = search;
            return this;
        }

        public Builder search(String search) {
            this.search = Optional.of(search);
            return this;
        }

        @JsonSetter(value = "$top", nulls = Nulls.SKIP)
        public Builder top(Optional<Double> top) {
            this.top = top;
            return this;
        }

        public Builder top(Double top) {
            this.top = Optional.of(top);
            return this;
        }

        @JsonSetter(value = "$skip", nulls = Nulls.SKIP)
        public Builder skip(Optional<Double> skip) {
            this.skip = skip;
            return this;
        }

        public Builder skip(Double skip) {
            this.skip = Optional.of(skip);
            return this;
        }

        @JsonSetter(value = "$orderby", nulls = Nulls.SKIP)
        public Builder orderby(Optional<String> orderby) {
            this.orderby = orderby;
            return this;
        }

        public Builder orderby(String orderby) {
            this.orderby = Optional.of(orderby);
            return this;
        }

        @JsonSetter(value = "$filter", nulls = Nulls.SKIP)
        public Builder filter(Optional<String> filter) {
            this.filter = filter;
            return this;
        }

        public Builder filter(String filter) {
            this.filter = Optional.of(filter);
            return this;
        }

        public ContentsGetContentsRequest build() {
            return new ContentsGetContentsRequest(
                    flatten, languages, noSlowTotal, noTotal, unpublished, ids, q, search, top, skip, orderby, filter);
        }
    }
}
