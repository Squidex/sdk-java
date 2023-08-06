package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TemplateDto.Builder.class)
public final class TemplateDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final String name;

    private final String title;

    private final String description;

    private final boolean isStarter;

    private TemplateDto(
            Map<String, ResourceLink> links, String name, String title, String description, boolean isStarter) {
        this.links = links;
        this.name = name;
        this.title = title;
        this.description = description;
        this.isStarter = isStarter;
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
     * @return The name of the template.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @return The title of the template.
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * @return The description of the template.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * @return True, if the template is a starter.
     */
    @JsonProperty("isStarter")
    public boolean getIsStarter() {
        return isStarter;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TemplateDto && equalTo((TemplateDto) other);
    }

    private boolean equalTo(TemplateDto other) {
        return links.equals(other.links)
                && name.equals(other.name)
                && title.equals(other.title)
                && description.equals(other.description)
                && isStarter == other.isStarter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.links, this.name, this.title, this.description, this.isStarter);
    }

    @Override
    public String toString() {
        return "TemplateDto{" + "links: " + links + ", name: " + name + ", title: " + title + ", description: "
                + description + ", isStarter: " + isStarter + "}";
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        TitleStage name(String name);

        Builder from(TemplateDto other);
    }

    public interface TitleStage {
        DescriptionStage title(String title);
    }

    public interface DescriptionStage {
        IsStarterStage description(String description);
    }

    public interface IsStarterStage {
        _FinalStage isStarter(boolean isStarter);
    }

    public interface _FinalStage {
        TemplateDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, TitleStage, DescriptionStage, IsStarterStage, _FinalStage {
        private String name;

        private String title;

        private String description;

        private boolean isStarter;

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(TemplateDto other) {
            links(other.getLinks());
            name(other.getName());
            title(other.getTitle());
            description(other.getDescription());
            isStarter(other.getIsStarter());
            return this;
        }

        /**
         * <p>The name of the template.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name")
        public TitleStage name(String name) {
            this.name = name;
            return this;
        }

        /**
         * <p>The title of the template.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("title")
        public DescriptionStage title(String title) {
            this.title = title;
            return this;
        }

        /**
         * <p>The description of the template.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("description")
        public IsStarterStage description(String description) {
            this.description = description;
            return this;
        }

        /**
         * <p>True, if the template is a starter.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("isStarter")
        public _FinalStage isStarter(boolean isStarter) {
            this.isStarter = isStarter;
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
        public TemplateDto build() {
            return new TemplateDto(links, name, title, description, isStarter);
        }
    }
}
