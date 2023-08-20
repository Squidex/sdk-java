package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SortNode.Builder.class)
public final class SortNode {
    private final List<String> path;

    private final SortOrder order;

    private SortNode(List<String> path, SortOrder order) {
        this.path = path;
        this.order = order;
    }

    @JsonProperty("path")
    public List<String> getPath() {
        return path;
    }

    @JsonProperty("order")
    public SortOrder getOrder() {
        return order;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SortNode && equalTo((SortNode) other);
    }

    private boolean equalTo(SortNode other) {
        return path.equals(other.path) && order.equals(other.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.path, this.order);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static OrderStage builder() {
        return new Builder();
    }

    public interface OrderStage {
        _FinalStage order(SortOrder order);

        Builder from(SortNode other);
    }

    public interface _FinalStage {
        SortNode build();

        _FinalStage path(List<String> path);

        _FinalStage addPath(String path);

        _FinalStage addAllPath(List<String> path);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements OrderStage, _FinalStage {
        private SortOrder order;

        private List<String> path = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(SortNode other) {
            path(other.getPath());
            order(other.getOrder());
            return this;
        }

        @Override
        @JsonSetter("order")
        public _FinalStage order(SortOrder order) {
            this.order = order;
            return this;
        }

        @Override
        public _FinalStage addAllPath(List<String> path) {
            this.path.addAll(path);
            return this;
        }

        @Override
        public _FinalStage addPath(String path) {
            this.path.add(path);
            return this;
        }

        @Override
        @JsonSetter(value = "path", nulls = Nulls.SKIP)
        public _FinalStage path(List<String> path) {
            this.path.clear();
            this.path.addAll(path);
            return this;
        }

        @Override
        public SortNode build() {
            return new SortNode(path, order);
        }
    }
}
