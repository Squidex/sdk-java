package com.squidex.api.resources.assets.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = RenameTagDto.Builder.class)
public final class RenameTagDto {
    private final String tagName;

    private RenameTagDto(String tagName) {
        this.tagName = tagName;
    }

    /**
     * @return The new name for the tag. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("tagName")
    public String getTagName() {
        return tagName;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RenameTagDto && equalTo((RenameTagDto) other);
    }

    private boolean equalTo(RenameTagDto other) {
        return tagName.equals(other.tagName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.tagName);
    }

    @Override
    public String toString() {
        return "RenameTagDto{" + "tagName: " + tagName + "}";
    }

    public static TagNameStage builder() {
        return new Builder();
    }

    public interface TagNameStage {
        _FinalStage tagName(String tagName);

        Builder from(RenameTagDto other);
    }

    public interface _FinalStage {
        RenameTagDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TagNameStage, _FinalStage {
        private String tagName;

        private Builder() {}

        @Override
        public Builder from(RenameTagDto other) {
            tagName(other.getTagName());
            return this;
        }

        /**
         * <p>The new name for the tag. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("tagName")
        public _FinalStage tagName(String tagName) {
            this.tagName = tagName;
            return this;
        }

        @Override
        public RenameTagDto build() {
            return new RenameTagDto(tagName);
        }
    }
}
