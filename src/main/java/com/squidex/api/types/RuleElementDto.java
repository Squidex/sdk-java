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
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = RuleElementDto.Builder.class)
public final class RuleElementDto {
    private final String description;

    private final String display;

    private final Optional<String> title;

    private final Optional<String> iconColor;

    private final Optional<String> iconImage;

    private final Optional<String> readMore;

    private final List<RuleElementPropertyDto> properties;

    private RuleElementDto(
            String description,
            String display,
            Optional<String> title,
            Optional<String> iconColor,
            Optional<String> iconImage,
            Optional<String> readMore,
            List<RuleElementPropertyDto> properties) {
        this.description = description;
        this.display = display;
        this.title = title;
        this.iconColor = iconColor;
        this.iconImage = iconImage;
        this.readMore = readMore;
        this.properties = properties;
    }

    /**
     * @return Describes the action or trigger type.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * @return The label for the action or trigger type.
     */
    @JsonProperty("display")
    public String getDisplay() {
        return display;
    }

    /**
     * @return Optional title.
     */
    @JsonProperty("title")
    public Optional<String> getTitle() {
        return title;
    }

    /**
     * @return The color for the icon.
     */
    @JsonProperty("iconColor")
    public Optional<String> getIconColor() {
        return iconColor;
    }

    /**
     * @return The image for the icon.
     */
    @JsonProperty("iconImage")
    public Optional<String> getIconImage() {
        return iconImage;
    }

    /**
     * @return The optional link to the product that is integrated.
     */
    @JsonProperty("readMore")
    public Optional<String> getReadMore() {
        return readMore;
    }

    /**
     * @return The properties.
     */
    @JsonProperty("properties")
    public List<RuleElementPropertyDto> getProperties() {
        return properties;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RuleElementDto && equalTo((RuleElementDto) other);
    }

    private boolean equalTo(RuleElementDto other) {
        return description.equals(other.description)
                && display.equals(other.display)
                && title.equals(other.title)
                && iconColor.equals(other.iconColor)
                && iconImage.equals(other.iconImage)
                && readMore.equals(other.readMore)
                && properties.equals(other.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.description,
                this.display,
                this.title,
                this.iconColor,
                this.iconImage,
                this.readMore,
                this.properties);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static DescriptionStage builder() {
        return new Builder();
    }

    public interface DescriptionStage {
        DisplayStage description(String description);

        Builder from(RuleElementDto other);
    }

    public interface DisplayStage {
        _FinalStage display(String display);
    }

    public interface _FinalStage {
        RuleElementDto build();

        _FinalStage title(Optional<String> title);

        _FinalStage title(String title);

        _FinalStage iconColor(Optional<String> iconColor);

        _FinalStage iconColor(String iconColor);

        _FinalStage iconImage(Optional<String> iconImage);

        _FinalStage iconImage(String iconImage);

        _FinalStage readMore(Optional<String> readMore);

        _FinalStage readMore(String readMore);

        _FinalStage properties(List<RuleElementPropertyDto> properties);

        _FinalStage addProperties(RuleElementPropertyDto properties);

        _FinalStage addAllProperties(List<RuleElementPropertyDto> properties);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements DescriptionStage, DisplayStage, _FinalStage {
        private String description;

        private String display;

        private List<RuleElementPropertyDto> properties = new ArrayList<>();

        private Optional<String> readMore = Optional.empty();

        private Optional<String> iconImage = Optional.empty();

        private Optional<String> iconColor = Optional.empty();

        private Optional<String> title = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(RuleElementDto other) {
            description(other.getDescription());
            display(other.getDisplay());
            title(other.getTitle());
            iconColor(other.getIconColor());
            iconImage(other.getIconImage());
            readMore(other.getReadMore());
            properties(other.getProperties());
            return this;
        }

        /**
         * <p>Describes the action or trigger type.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("description")
        public DisplayStage description(String description) {
            this.description = description;
            return this;
        }

        /**
         * <p>The label for the action or trigger type.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("display")
        public _FinalStage display(String display) {
            this.display = display;
            return this;
        }

        /**
         * <p>The properties.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllProperties(List<RuleElementPropertyDto> properties) {
            this.properties.addAll(properties);
            return this;
        }

        /**
         * <p>The properties.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addProperties(RuleElementPropertyDto properties) {
            this.properties.add(properties);
            return this;
        }

        @Override
        @JsonSetter(value = "properties", nulls = Nulls.SKIP)
        public _FinalStage properties(List<RuleElementPropertyDto> properties) {
            this.properties.clear();
            this.properties.addAll(properties);
            return this;
        }

        /**
         * <p>The optional link to the product that is integrated.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage readMore(String readMore) {
            this.readMore = Optional.of(readMore);
            return this;
        }

        @Override
        @JsonSetter(value = "readMore", nulls = Nulls.SKIP)
        public _FinalStage readMore(Optional<String> readMore) {
            this.readMore = readMore;
            return this;
        }

        /**
         * <p>The image for the icon.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage iconImage(String iconImage) {
            this.iconImage = Optional.of(iconImage);
            return this;
        }

        @Override
        @JsonSetter(value = "iconImage", nulls = Nulls.SKIP)
        public _FinalStage iconImage(Optional<String> iconImage) {
            this.iconImage = iconImage;
            return this;
        }

        /**
         * <p>The color for the icon.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage iconColor(String iconColor) {
            this.iconColor = Optional.of(iconColor);
            return this;
        }

        @Override
        @JsonSetter(value = "iconColor", nulls = Nulls.SKIP)
        public _FinalStage iconColor(Optional<String> iconColor) {
            this.iconColor = iconColor;
            return this;
        }

        /**
         * <p>Optional title.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage title(String title) {
            this.title = Optional.of(title);
            return this;
        }

        @Override
        @JsonSetter(value = "title", nulls = Nulls.SKIP)
        public _FinalStage title(Optional<String> title) {
            this.title = title;
            return this;
        }

        @Override
        public RuleElementDto build() {
            return new RuleElementDto(description, display, title, iconColor, iconImage, readMore, properties);
        }
    }
}
