package com.squidex.api.resources.assets.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AssetsGetAssetsRequest.Builder.class)
public final class AssetsGetAssetsRequest {
    private final Optional<Boolean> noTotal;

    private final Optional<Boolean> noSlowTotal;

    private final Optional<String> parentId;

    private final Optional<String> ids;

    private final Optional<String> q;

    private final Optional<Double> top;

    private final Optional<Double> skip;

    private final Optional<String> orderby;

    private final Optional<String> filter;

    private AssetsGetAssetsRequest(
            Optional<Boolean> noTotal,
            Optional<Boolean> noSlowTotal,
            Optional<String> parentId,
            Optional<String> ids,
            Optional<String> q,
            Optional<Double> top,
            Optional<Double> skip,
            Optional<String> orderby,
            Optional<String> filter) {
        this.noTotal = noTotal;
        this.noSlowTotal = noSlowTotal;
        this.parentId = parentId;
        this.ids = ids;
        this.q = q;
        this.top = top;
        this.skip = skip;
        this.orderby = orderby;
        this.filter = filter;
    }

    /**
     * @return Do not return the total amount.
     */
    @JsonProperty("X-NoTotal")
    public Optional<Boolean> getNoTotal() {
        return noTotal;
    }

    /**
     * @return Do not return the total amount, if it would be slow.
     */
    @JsonProperty("X-NoSlowTotal")
    public Optional<Boolean> getNoSlowTotal() {
        return noSlowTotal;
    }

    /**
     * @return The optional parent folder id.
     */
    @JsonProperty("parentId")
    public Optional<String> getParentId() {
        return parentId;
    }

    /**
     * @return The optional asset ids.
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
        return other instanceof AssetsGetAssetsRequest && equalTo((AssetsGetAssetsRequest) other);
    }

    private boolean equalTo(AssetsGetAssetsRequest other) {
        return noTotal.equals(other.noTotal)
                && noSlowTotal.equals(other.noSlowTotal)
                && parentId.equals(other.parentId)
                && ids.equals(other.ids)
                && q.equals(other.q)
                && top.equals(other.top)
                && skip.equals(other.skip)
                && orderby.equals(other.orderby)
                && filter.equals(other.filter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.noTotal,
                this.noSlowTotal,
                this.parentId,
                this.ids,
                this.q,
                this.top,
                this.skip,
                this.orderby,
                this.filter);
    }

    @Override
    public String toString() {
        return "AssetsGetAssetsRequest{" + "noTotal: " + noTotal + ", noSlowTotal: " + noSlowTotal + ", parentId: "
                + parentId + ", ids: " + ids + ", q: " + q + ", top: " + top + ", skip: " + skip + ", orderby: "
                + orderby + ", filter: " + filter + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Boolean> noTotal = Optional.empty();

        private Optional<Boolean> noSlowTotal = Optional.empty();

        private Optional<String> parentId = Optional.empty();

        private Optional<String> ids = Optional.empty();

        private Optional<String> q = Optional.empty();

        private Optional<Double> top = Optional.empty();

        private Optional<Double> skip = Optional.empty();

        private Optional<String> orderby = Optional.empty();

        private Optional<String> filter = Optional.empty();

        private Builder() {}

        public Builder from(AssetsGetAssetsRequest other) {
            noTotal(other.getNoTotal());
            noSlowTotal(other.getNoSlowTotal());
            parentId(other.getParentId());
            ids(other.getIds());
            q(other.getQ());
            top(other.getTop());
            skip(other.getSkip());
            orderby(other.getOrderby());
            filter(other.getFilter());
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

        @JsonSetter(value = "X-NoSlowTotal", nulls = Nulls.SKIP)
        public Builder noSlowTotal(Optional<Boolean> noSlowTotal) {
            this.noSlowTotal = noSlowTotal;
            return this;
        }

        public Builder noSlowTotal(Boolean noSlowTotal) {
            this.noSlowTotal = Optional.of(noSlowTotal);
            return this;
        }

        @JsonSetter(value = "parentId", nulls = Nulls.SKIP)
        public Builder parentId(Optional<String> parentId) {
            this.parentId = parentId;
            return this;
        }

        public Builder parentId(String parentId) {
            this.parentId = Optional.of(parentId);
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

        public AssetsGetAssetsRequest build() {
            return new AssetsGetAssetsRequest(noTotal, noSlowTotal, parentId, ids, q, top, skip, orderby, filter);
        }
    }
}
