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

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TemplateDetailsDto.Builder.class)
public final class TemplateDetailsDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final String details;

    private TemplateDetailsDto(Map<String, ResourceLink> links, String details) {
        this.links = links;
        this.details = details;
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
     * @return The details of the template.
     */
    @JsonProperty("details")
    public String getDetails() {
        return details;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TemplateDetailsDto && equalTo((TemplateDetailsDto) other);
    }

    private boolean equalTo(TemplateDetailsDto other) {
        return links.equals(other.links) && details.equals(other.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.links, this.details);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static DetailsStage builder() {
        return new Builder();
    }

    public interface DetailsStage {
        _FinalStage details(String details);

        Builder from(TemplateDetailsDto other);
    }

    public interface _FinalStage {
        TemplateDetailsDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements DetailsStage, _FinalStage {
        private String details;

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(TemplateDetailsDto other) {
            links(other.getLinks());
            details(other.getDetails());
            return this;
        }

        /**
         * <p>The details of the template.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("details")
        public _FinalStage details(String details) {
            this.details = details;
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
        public TemplateDetailsDto build() {
            return new TemplateDetailsDto(links, details);
        }
    }
}
