package com.squidex.api.resources.backups.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = RestoreRequestDto.Builder.class)
public final class RestoreRequestDto {
    private final Optional<String> name;

    private final String url;

    private RestoreRequestDto(Optional<String> name, String url) {
        this.name = name;
        this.url = url;
    }

    /**
     * @return The name of the app.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return The url to the restore file. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RestoreRequestDto && equalTo((RestoreRequestDto) other);
    }

    private boolean equalTo(RestoreRequestDto other) {
        return name.equals(other.name) && url.equals(other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.url);
    }

    @Override
    public String toString() {
        return "RestoreRequestDto{" + "name: " + name + ", url: " + url + "}";
    }

    public static UrlStage builder() {
        return new Builder();
    }

    public interface UrlStage {
        _FinalStage url(String url);

        Builder from(RestoreRequestDto other);
    }

    public interface _FinalStage {
        RestoreRequestDto build();

        _FinalStage name(Optional<String> name);

        _FinalStage name(String name);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements UrlStage, _FinalStage {
        private String url;

        private Optional<String> name = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(RestoreRequestDto other) {
            name(other.getName());
            url(other.getUrl());
            return this;
        }

        /**
         * <p>The url to the restore file. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("url")
        public _FinalStage url(String url) {
            this.url = url;
            return this;
        }

        /**
         * <p>The name of the app.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage name(String name) {
            this.name = Optional.of(name);
            return this;
        }

        @Override
        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public _FinalStage name(Optional<String> name) {
            this.name = name;
            return this;
        }

        @Override
        public RestoreRequestDto build() {
            return new RestoreRequestDto(name, url);
        }
    }
}
