package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = FeatureDto.Builder.class)
public final class FeatureDto {
    private final String name;

    private final String text;

    private FeatureDto(String name, String text) {
        this.name = name;
        this.text = text;
    }

    /**
     * @return The name of the feature.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @return The description text.
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof FeatureDto && equalTo((FeatureDto) other);
    }

    private boolean equalTo(FeatureDto other) {
        return name.equals(other.name) && text.equals(other.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.text);
    }

    @Override
    public String toString() {
        return "FeatureDto{" + "name: " + name + ", text: " + text + "}";
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        TextStage name(String name);

        Builder from(FeatureDto other);
    }

    public interface TextStage {
        _FinalStage text(String text);
    }

    public interface _FinalStage {
        FeatureDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, TextStage, _FinalStage {
        private String name;

        private String text;

        private Builder() {}

        @Override
        public Builder from(FeatureDto other) {
            name(other.getName());
            text(other.getText());
            return this;
        }

        /**
         * <p>The name of the feature.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name")
        public TextStage name(String name) {
            this.name = name;
            return this;
        }

        /**
         * <p>The description text.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("text")
        public _FinalStage text(String text) {
            this.text = text;
            return this;
        }

        @Override
        public FeatureDto build() {
            return new FeatureDto(name, text);
        }
    }
}
