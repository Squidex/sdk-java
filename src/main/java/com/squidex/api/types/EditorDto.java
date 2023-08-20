package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = EditorDto.Builder.class)
public final class EditorDto {
    private final String name;

    private final String url;

    private EditorDto(String name, String url) {
        this.name = name;
        this.url = url;
    }

    /**
     * @return The name of the editor.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @return The url to the editor.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof EditorDto && equalTo((EditorDto) other);
    }

    private boolean equalTo(EditorDto other) {
        return name.equals(other.name) && url.equals(other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.url);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        UrlStage name(String name);

        Builder from(EditorDto other);
    }

    public interface UrlStage {
        _FinalStage url(String url);
    }

    public interface _FinalStage {
        EditorDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, UrlStage, _FinalStage {
        private String name;

        private String url;

        private Builder() {}

        @Override
        public Builder from(EditorDto other) {
            name(other.getName());
            url(other.getUrl());
            return this;
        }

        /**
         * <p>The name of the editor.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name")
        public UrlStage name(String name) {
            this.name = name;
            return this;
        }

        /**
         * <p>The url to the editor.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("url")
        public _FinalStage url(String url) {
            this.url = url;
            return this;
        }

        @Override
        public EditorDto build() {
            return new EditorDto(name, url);
        }
    }
}
