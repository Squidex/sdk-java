package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SchemaPropertiesDto.Builder.class)
public final class SchemaPropertiesDto {
    private final Optional<String> label;

    private final Optional<String> hints;

    private final Optional<String> contentsSidebarUrl;

    private final Optional<String> contentSidebarUrl;

    private final Optional<String> contentEditorUrl;

    private final boolean validateOnPublish;

    private final Optional<List<String>> tags;

    private SchemaPropertiesDto(
            Optional<String> label,
            Optional<String> hints,
            Optional<String> contentsSidebarUrl,
            Optional<String> contentSidebarUrl,
            Optional<String> contentEditorUrl,
            boolean validateOnPublish,
            Optional<List<String>> tags) {
        this.label = label;
        this.hints = hints;
        this.contentsSidebarUrl = contentsSidebarUrl;
        this.contentSidebarUrl = contentSidebarUrl;
        this.contentEditorUrl = contentEditorUrl;
        this.validateOnPublish = validateOnPublish;
        this.tags = tags;
    }

    /**
     * @return Optional label for the editor.
     */
    @JsonProperty("label")
    public Optional<String> getLabel() {
        return label;
    }

    /**
     * @return Hints to describe the schema.
     */
    @JsonProperty("hints")
    public Optional<String> getHints() {
        return hints;
    }

    /**
     * @return The url to a the sidebar plugin for content lists.
     */
    @JsonProperty("contentsSidebarUrl")
    public Optional<String> getContentsSidebarUrl() {
        return contentsSidebarUrl;
    }

    /**
     * @return The url to a the sidebar plugin for content items.
     */
    @JsonProperty("contentSidebarUrl")
    public Optional<String> getContentSidebarUrl() {
        return contentSidebarUrl;
    }

    /**
     * @return The url to the editor plugin.
     */
    @JsonProperty("contentEditorUrl")
    public Optional<String> getContentEditorUrl() {
        return contentEditorUrl;
    }

    /**
     * @return True to validate the content items on publish.
     */
    @JsonProperty("validateOnPublish")
    public boolean getValidateOnPublish() {
        return validateOnPublish;
    }

    /**
     * @return Tags for automation processes.
     */
    @JsonProperty("tags")
    public Optional<List<String>> getTags() {
        return tags;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SchemaPropertiesDto && equalTo((SchemaPropertiesDto) other);
    }

    private boolean equalTo(SchemaPropertiesDto other) {
        return label.equals(other.label)
                && hints.equals(other.hints)
                && contentsSidebarUrl.equals(other.contentsSidebarUrl)
                && contentSidebarUrl.equals(other.contentSidebarUrl)
                && contentEditorUrl.equals(other.contentEditorUrl)
                && validateOnPublish == other.validateOnPublish
                && tags.equals(other.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.label,
                this.hints,
                this.contentsSidebarUrl,
                this.contentSidebarUrl,
                this.contentEditorUrl,
                this.validateOnPublish,
                this.tags);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ValidateOnPublishStage builder() {
        return new Builder();
    }

    public interface ValidateOnPublishStage {
        _FinalStage validateOnPublish(boolean validateOnPublish);

        Builder from(SchemaPropertiesDto other);
    }

    public interface _FinalStage {
        SchemaPropertiesDto build();

        _FinalStage label(Optional<String> label);

        _FinalStage label(String label);

        _FinalStage hints(Optional<String> hints);

        _FinalStage hints(String hints);

        _FinalStage contentsSidebarUrl(Optional<String> contentsSidebarUrl);

        _FinalStage contentsSidebarUrl(String contentsSidebarUrl);

        _FinalStage contentSidebarUrl(Optional<String> contentSidebarUrl);

        _FinalStage contentSidebarUrl(String contentSidebarUrl);

        _FinalStage contentEditorUrl(Optional<String> contentEditorUrl);

        _FinalStage contentEditorUrl(String contentEditorUrl);

        _FinalStage tags(Optional<List<String>> tags);

        _FinalStage tags(List<String> tags);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ValidateOnPublishStage, _FinalStage {
        private boolean validateOnPublish;

        private Optional<List<String>> tags = Optional.empty();

        private Optional<String> contentEditorUrl = Optional.empty();

        private Optional<String> contentSidebarUrl = Optional.empty();

        private Optional<String> contentsSidebarUrl = Optional.empty();

        private Optional<String> hints = Optional.empty();

        private Optional<String> label = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(SchemaPropertiesDto other) {
            label(other.getLabel());
            hints(other.getHints());
            contentsSidebarUrl(other.getContentsSidebarUrl());
            contentSidebarUrl(other.getContentSidebarUrl());
            contentEditorUrl(other.getContentEditorUrl());
            validateOnPublish(other.getValidateOnPublish());
            tags(other.getTags());
            return this;
        }

        /**
         * <p>True to validate the content items on publish.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("validateOnPublish")
        public _FinalStage validateOnPublish(boolean validateOnPublish) {
            this.validateOnPublish = validateOnPublish;
            return this;
        }

        /**
         * <p>Tags for automation processes.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage tags(List<String> tags) {
            this.tags = Optional.of(tags);
            return this;
        }

        @Override
        @JsonSetter(value = "tags", nulls = Nulls.SKIP)
        public _FinalStage tags(Optional<List<String>> tags) {
            this.tags = tags;
            return this;
        }

        /**
         * <p>The url to the editor plugin.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage contentEditorUrl(String contentEditorUrl) {
            this.contentEditorUrl = Optional.of(contentEditorUrl);
            return this;
        }

        @Override
        @JsonSetter(value = "contentEditorUrl", nulls = Nulls.SKIP)
        public _FinalStage contentEditorUrl(Optional<String> contentEditorUrl) {
            this.contentEditorUrl = contentEditorUrl;
            return this;
        }

        /**
         * <p>The url to a the sidebar plugin for content items.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage contentSidebarUrl(String contentSidebarUrl) {
            this.contentSidebarUrl = Optional.of(contentSidebarUrl);
            return this;
        }

        @Override
        @JsonSetter(value = "contentSidebarUrl", nulls = Nulls.SKIP)
        public _FinalStage contentSidebarUrl(Optional<String> contentSidebarUrl) {
            this.contentSidebarUrl = contentSidebarUrl;
            return this;
        }

        /**
         * <p>The url to a the sidebar plugin for content lists.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage contentsSidebarUrl(String contentsSidebarUrl) {
            this.contentsSidebarUrl = Optional.of(contentsSidebarUrl);
            return this;
        }

        @Override
        @JsonSetter(value = "contentsSidebarUrl", nulls = Nulls.SKIP)
        public _FinalStage contentsSidebarUrl(Optional<String> contentsSidebarUrl) {
            this.contentsSidebarUrl = contentsSidebarUrl;
            return this;
        }

        /**
         * <p>Hints to describe the schema.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage hints(String hints) {
            this.hints = Optional.of(hints);
            return this;
        }

        @Override
        @JsonSetter(value = "hints", nulls = Nulls.SKIP)
        public _FinalStage hints(Optional<String> hints) {
            this.hints = hints;
            return this;
        }

        /**
         * <p>Optional label for the editor.</p>
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

        @Override
        public SchemaPropertiesDto build() {
            return new SchemaPropertiesDto(
                    label, hints, contentsSidebarUrl, contentSidebarUrl, contentEditorUrl, validateOnPublish, tags);
        }
    }
}
