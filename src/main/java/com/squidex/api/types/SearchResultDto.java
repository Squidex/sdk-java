package com.squidex.api.types;

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
@JsonDeserialize(builder = SearchResultDto.Builder.class)
public final class SearchResultDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final String name;

    private final SearchResultType type;

    private final Optional<String> label;

    private SearchResultDto(
            Map<String, ResourceLink> links, String name, SearchResultType type, Optional<String> label) {
        this.links = links;
        this.name = name;
        this.type = type;
        this.label = label;
    }

    /**
     * @return The links.
     */
    @JsonProperty("_links")
    @Override
    public Map<String, ResourceLink> getLinks() {
        return links;
    }

    /**
     * @return The name of the search result.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("type")
    public SearchResultType getType() {
        return type;
    }

    /**
     * @return An optional label.
     */
    @JsonProperty("label")
    public Optional<String> getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SearchResultDto && equalTo((SearchResultDto) other);
    }

    private boolean equalTo(SearchResultDto other) {
        return links.equals(other.links)
                && name.equals(other.name)
                && type.equals(other.type)
                && label.equals(other.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.links, this.name, this.type, this.label);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        TypeStage name(String name);

        Builder from(SearchResultDto other);
    }

    public interface TypeStage {
        _FinalStage type(SearchResultType type);
    }

    public interface _FinalStage {
        SearchResultDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);

        _FinalStage label(Optional<String> label);

        _FinalStage label(String label);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, TypeStage, _FinalStage {
        private String name;

        private SearchResultType type;

        private Optional<String> label = Optional.empty();

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(SearchResultDto other) {
            links(other.getLinks());
            name(other.getName());
            type(other.getType());
            label(other.getLabel());
            return this;
        }

        /**
         * <p>The name of the search result.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name")
        public TypeStage name(String name) {
            this.name = name;
            return this;
        }

        @Override
        @JsonSetter("type")
        public _FinalStage type(SearchResultType type) {
            this.type = type;
            return this;
        }

        /**
         * <p>An optional label.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage label(String label) {
            this.label = Optional.of(label);
            return this;
        }

        @Override
        @JsonSetter(value = "label", nulls = Nulls.SKIP)
        public _FinalStage label(Optional<String> label) {
            this.label = label;
            return this;
        }

        /**
         * <p>The links.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage links(String key, ResourceLink value) {
            this.links.put(key, value);
            return this;
        }

        /**
         * <p>The links.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage putAllLinks(Map<String, ResourceLink> links) {
            this.links.putAll(links);
            return this;
        }

        @Override
        @JsonSetter(value = "_links", nulls = Nulls.SKIP)
        public _FinalStage links(Map<String, ResourceLink> links) {
            this.links.clear();
            this.links.putAll(links);
            return this;
        }

        @Override
        public SearchResultDto build() {
            return new SearchResultDto(links, name, type, label);
        }
    }
}
