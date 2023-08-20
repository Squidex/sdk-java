package com.squidex.api.resources.apps.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AddLanguageDto.Builder.class)
public final class AddLanguageDto {
    private final String language;

    private AddLanguageDto(String language) {
        this.language = language;
    }

    /**
     * @return The language to add. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AddLanguageDto && equalTo((AddLanguageDto) other);
    }

    private boolean equalTo(AddLanguageDto other) {
        return language.equals(other.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.language);
    }

    @Override
    public String toString() {
        return "AddLanguageDto{" + "language: " + language + "}";
    }

    public static LanguageStage builder() {
        return new Builder();
    }

    public interface LanguageStage {
        _FinalStage language(String language);

        Builder from(AddLanguageDto other);
    }

    public interface _FinalStage {
        AddLanguageDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements LanguageStage, _FinalStage {
        private String language;

        private Builder() {}

        @Override
        public Builder from(AddLanguageDto other) {
            language(other.getLanguage());
            return this;
        }

        /**
         * <p>The language to add. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("language")
        public _FinalStage language(String language) {
            this.language = language;
            return this;
        }

        @Override
        public AddLanguageDto build() {
            return new AddLanguageDto(language);
        }
    }
}
