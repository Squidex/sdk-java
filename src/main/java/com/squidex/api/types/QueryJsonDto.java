package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = QueryJsonDto.Builder.class)
public final class QueryJsonDto {
    private final Optional<Object> filter;

    private final Optional<String> fullText;

    private final int skip;

    private final int take;

    private final int random;

    private final int top;

    private final Optional<List<SortNode>> sort;

    private QueryJsonDto(
            Optional<Object> filter,
            Optional<String> fullText,
            int skip,
            int take,
            int random,
            int top,
            Optional<List<SortNode>> sort) {
        this.filter = filter;
        this.fullText = fullText;
        this.skip = skip;
        this.take = take;
        this.random = random;
        this.top = top;
        this.sort = sort;
    }

    @JsonProperty("filter")
    public Optional<Object> getFilter() {
        return filter;
    }

    @JsonProperty("fullText")
    public Optional<String> getFullText() {
        return fullText;
    }

    @JsonProperty("skip")
    public int getSkip() {
        return skip;
    }

    @JsonProperty("take")
    public int getTake() {
        return take;
    }

    @JsonProperty("random")
    public int getRandom() {
        return random;
    }

    @JsonProperty("top")
    public int getTop() {
        return top;
    }

    @JsonProperty("sort")
    public Optional<List<SortNode>> getSort() {
        return sort;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof QueryJsonDto && equalTo((QueryJsonDto) other);
    }

    private boolean equalTo(QueryJsonDto other) {
        return filter.equals(other.filter)
                && fullText.equals(other.fullText)
                && skip == other.skip
                && take == other.take
                && random == other.random
                && top == other.top
                && sort.equals(other.sort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.filter, this.fullText, this.skip, this.take, this.random, this.top, this.sort);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static SkipStage builder() {
        return new Builder();
    }

    public interface SkipStage {
        TakeStage skip(int skip);

        Builder from(QueryJsonDto other);
    }

    public interface TakeStage {
        RandomStage take(int take);
    }

    public interface RandomStage {
        TopStage random(int random);
    }

    public interface TopStage {
        _FinalStage top(int top);
    }

    public interface _FinalStage {
        QueryJsonDto build();

        _FinalStage filter(Optional<Object> filter);

        _FinalStage filter(Object filter);

        _FinalStage fullText(Optional<String> fullText);

        _FinalStage fullText(String fullText);

        _FinalStage sort(Optional<List<SortNode>> sort);

        _FinalStage sort(List<SortNode> sort);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements SkipStage, TakeStage, RandomStage, TopStage, _FinalStage {
        private int skip;

        private int take;

        private int random;

        private int top;

        private Optional<List<SortNode>> sort = Optional.empty();

        private Optional<String> fullText = Optional.empty();

        private Optional<Object> filter = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(QueryJsonDto other) {
            filter(other.getFilter());
            fullText(other.getFullText());
            skip(other.getSkip());
            take(other.getTake());
            random(other.getRandom());
            top(other.getTop());
            sort(other.getSort());
            return this;
        }

        @Override
        @JsonSetter("skip")
        public TakeStage skip(int skip) {
            this.skip = skip;
            return this;
        }

        @Override
        @JsonSetter("take")
        public RandomStage take(int take) {
            this.take = take;
            return this;
        }

        @Override
        @JsonSetter("random")
        public TopStage random(int random) {
            this.random = random;
            return this;
        }

        @Override
        @JsonSetter("top")
        public _FinalStage top(int top) {
            this.top = top;
            return this;
        }

        @Override
        public _FinalStage sort(List<SortNode> sort) {
            this.sort = Optional.of(sort);
            return this;
        }

        @Override
        @JsonSetter(value = "sort", nulls = Nulls.SKIP)
        public _FinalStage sort(Optional<List<SortNode>> sort) {
            this.sort = sort;
            return this;
        }

        @Override
        public _FinalStage fullText(String fullText) {
            this.fullText = Optional.of(fullText);
            return this;
        }

        @Override
        @JsonSetter(value = "fullText", nulls = Nulls.SKIP)
        public _FinalStage fullText(Optional<String> fullText) {
            this.fullText = fullText;
            return this;
        }

        @Override
        public _FinalStage filter(Object filter) {
            this.filter = Optional.of(filter);
            return this;
        }

        @Override
        @JsonSetter(value = "filter", nulls = Nulls.SKIP)
        public _FinalStage filter(Optional<Object> filter) {
            this.filter = filter;
            return this;
        }

        @Override
        public QueryJsonDto build() {
            return new QueryJsonDto(filter, fullText, skip, take, random, top, sort);
        }
    }
}
