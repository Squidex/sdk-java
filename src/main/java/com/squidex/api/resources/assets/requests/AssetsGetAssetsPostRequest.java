package com.squidex.api.resources.assets.requests;

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
@JsonDeserialize(builder = AssetsGetAssetsPostRequest.Builder.class)
public final class AssetsGetAssetsPostRequest {
    private final Optional<Boolean> noTotal;

    private final Optional<Boolean> noSlowTotal;

    private final QueryDto body;

    private AssetsGetAssetsPostRequest(Optional<Boolean> noTotal, Optional<Boolean> noSlowTotal, QueryDto body) {
        this.noTotal = noTotal;
        this.noSlowTotal = noSlowTotal;
        this.body = body;
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

    @JsonProperty("body")
    public QueryDto getBody() {
        return body;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AssetsGetAssetsPostRequest && equalTo((AssetsGetAssetsPostRequest) other);
    }

    private boolean equalTo(AssetsGetAssetsPostRequest other) {
        return noTotal.equals(other.noTotal) && noSlowTotal.equals(other.noSlowTotal) && body.equals(other.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.noTotal, this.noSlowTotal, this.body);
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

        Builder from(AssetsGetAssetsPostRequest other);
    }

    public interface _FinalStage {
        AssetsGetAssetsPostRequest build();

        _FinalStage noTotal(Optional<Boolean> noTotal);

        _FinalStage noTotal(Boolean noTotal);

        _FinalStage noSlowTotal(Optional<Boolean> noSlowTotal);

        _FinalStage noSlowTotal(Boolean noSlowTotal);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements BodyStage, _FinalStage {
        private QueryDto body;

        private Optional<Boolean> noSlowTotal = Optional.empty();

        private Optional<Boolean> noTotal = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(AssetsGetAssetsPostRequest other) {
            noTotal(other.getNoTotal());
            noSlowTotal(other.getNoSlowTotal());
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

        @Override
        public AssetsGetAssetsPostRequest build() {
            return new AssetsGetAssetsPostRequest(noTotal, noSlowTotal, body);
        }
    }
}
