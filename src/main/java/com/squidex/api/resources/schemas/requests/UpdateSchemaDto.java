package com.squidex.api.resources.schemas.requests;

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
@JsonDeserialize(builder = UpdateSchemaDto.Builder.class)
public final class UpdateSchemaDto {
    private final Optional<String> label;

    private final Optional<String> hints;

    private final Optional<String> contentsSidebarUrl;

    private final Optional<String> contentSidebarUrl;

    private final Optional<String> contentEditorUrl;

    private final Optional<Boolean> validateOnPublish;

    private final Optional<List<String>> tags;

    private UpdateSchemaDto(
            Optional<String> label,
            Optional<String> hints,
            Optional<String> contentsSidebarUrl,
            Optional<String> contentSidebarUrl,
            Optional<String> contentEditorUrl,
            Optional<Boolean> validateOnPublish,
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
    public Optional<Boolean> getValidateOnPublish() {
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
        return other instanceof UpdateSchemaDto && equalTo((UpdateSchemaDto) other);
    }

    private boolean equalTo(UpdateSchemaDto other) {
        return label.equals(other.label)
                && hints.equals(other.hints)
                && contentsSidebarUrl.equals(other.contentsSidebarUrl)
                && contentSidebarUrl.equals(other.contentSidebarUrl)
                && contentEditorUrl.equals(other.contentEditorUrl)
                && validateOnPublish.equals(other.validateOnPublish)
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

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> label = Optional.empty();

        private Optional<String> hints = Optional.empty();

        private Optional<String> contentsSidebarUrl = Optional.empty();

        private Optional<String> contentSidebarUrl = Optional.empty();

        private Optional<String> contentEditorUrl = Optional.empty();

        private Optional<Boolean> validateOnPublish = Optional.empty();

        private Optional<List<String>> tags = Optional.empty();

        private Builder() {}

        public Builder from(UpdateSchemaDto other) {
            label(other.getLabel());
            hints(other.getHints());
            contentsSidebarUrl(other.getContentsSidebarUrl());
            contentSidebarUrl(other.getContentSidebarUrl());
            contentEditorUrl(other.getContentEditorUrl());
            validateOnPublish(other.getValidateOnPublish());
            tags(other.getTags());
            return this;
        }

        @JsonSetter(value = "label", nulls = Nulls.SKIP)
        public Builder label(Optional<String> label) {
            this.label = label;
            return this;
        }

        public Builder label(String label) {
            this.label = Optional.of(label);
            return this;
        }

        @JsonSetter(value = "hints", nulls = Nulls.SKIP)
        public Builder hints(Optional<String> hints) {
            this.hints = hints;
            return this;
        }

        public Builder hints(String hints) {
            this.hints = Optional.of(hints);
            return this;
        }

        @JsonSetter(value = "contentsSidebarUrl", nulls = Nulls.SKIP)
        public Builder contentsSidebarUrl(Optional<String> contentsSidebarUrl) {
            this.contentsSidebarUrl = contentsSidebarUrl;
            return this;
        }

        public Builder contentsSidebarUrl(String contentsSidebarUrl) {
            this.contentsSidebarUrl = Optional.of(contentsSidebarUrl);
            return this;
        }

        @JsonSetter(value = "contentSidebarUrl", nulls = Nulls.SKIP)
        public Builder contentSidebarUrl(Optional<String> contentSidebarUrl) {
            this.contentSidebarUrl = contentSidebarUrl;
            return this;
        }

        public Builder contentSidebarUrl(String contentSidebarUrl) {
            this.contentSidebarUrl = Optional.of(contentSidebarUrl);
            return this;
        }

        @JsonSetter(value = "contentEditorUrl", nulls = Nulls.SKIP)
        public Builder contentEditorUrl(Optional<String> contentEditorUrl) {
            this.contentEditorUrl = contentEditorUrl;
            return this;
        }

        public Builder contentEditorUrl(String contentEditorUrl) {
            this.contentEditorUrl = Optional.of(contentEditorUrl);
            return this;
        }

        @JsonSetter(value = "validateOnPublish", nulls = Nulls.SKIP)
        public Builder validateOnPublish(Optional<Boolean> validateOnPublish) {
            this.validateOnPublish = validateOnPublish;
            return this;
        }

        public Builder validateOnPublish(Boolean validateOnPublish) {
            this.validateOnPublish = Optional.of(validateOnPublish);
            return this;
        }

        @JsonSetter(value = "tags", nulls = Nulls.SKIP)
        public Builder tags(Optional<List<String>> tags) {
            this.tags = tags;
            return this;
        }

        public Builder tags(List<String> tags) {
            this.tags = Optional.of(tags);
            return this;
        }

        public UpdateSchemaDto build() {
            return new UpdateSchemaDto(
                    label, hints, contentsSidebarUrl, contentSidebarUrl, contentEditorUrl, validateOnPublish, tags);
        }
    }
}
