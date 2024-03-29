/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = PatternDto.Builder.class)
public final class PatternDto {
    private final String name;

    private final String regex;

    private final Optional<String> message;

    private PatternDto(String name, String regex, Optional<String> message) {
        this.name = name;
        this.regex = regex;
        this.message = message;
    }

    /**
     * @return The name of the suggestion.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @return The regex pattern.
     */
    @JsonProperty("regex")
    public String getRegex() {
        return regex;
    }

    /**
     * @return The regex message.
     */
    @JsonProperty("message")
    public Optional<String> getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PatternDto && equalTo((PatternDto) other);
    }

    private boolean equalTo(PatternDto other) {
        return name.equals(other.name) && regex.equals(other.regex) && message.equals(other.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.regex, this.message);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        RegexStage name(String name);

        Builder from(PatternDto other);
    }

    public interface RegexStage {
        _FinalStage regex(String regex);
    }

    public interface _FinalStage {
        PatternDto build();

        _FinalStage message(Optional<String> message);

        _FinalStage message(String message);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, RegexStage, _FinalStage {
        private String name;

        private String regex;

        private Optional<String> message = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(PatternDto other) {
            name(other.getName());
            regex(other.getRegex());
            message(other.getMessage());
            return this;
        }

        /**
         * <p>The name of the suggestion.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name")
        public RegexStage name(String name) {
            this.name = name;
            return this;
        }

        /**
         * <p>The regex pattern.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("regex")
        public _FinalStage regex(String regex) {
            this.regex = regex;
            return this;
        }

        /**
         * <p>The regex message.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage message(String message) {
            this.message = Optional.of(message);
            return this;
        }

        @Override
        @JsonSetter(value = "message", nulls = Nulls.SKIP)
        public _FinalStage message(Optional<String> message) {
            this.message = message;
            return this;
        }

        @Override
        public PatternDto build() {
            return new PatternDto(name, regex, message);
        }
    }
}
