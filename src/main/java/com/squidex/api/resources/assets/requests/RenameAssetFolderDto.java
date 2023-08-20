package com.squidex.api.resources.assets.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = RenameAssetFolderDto.Builder.class)
public final class RenameAssetFolderDto {
    private final String folderName;

    private RenameAssetFolderDto(String folderName) {
        this.folderName = folderName;
    }

    /**
     * @return The name of the folder. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("folderName")
    public String getFolderName() {
        return folderName;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RenameAssetFolderDto && equalTo((RenameAssetFolderDto) other);
    }

    private boolean equalTo(RenameAssetFolderDto other) {
        return folderName.equals(other.folderName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.folderName);
    }

    @Override
    public String toString() {
        return "RenameAssetFolderDto{" + "folderName: " + folderName + "}";
    }

    public static FolderNameStage builder() {
        return new Builder();
    }

    public interface FolderNameStage {
        _FinalStage folderName(String folderName);

        Builder from(RenameAssetFolderDto other);
    }

    public interface _FinalStage {
        RenameAssetFolderDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements FolderNameStage, _FinalStage {
        private String folderName;

        private Builder() {}

        @Override
        public Builder from(RenameAssetFolderDto other) {
            folderName(other.getFolderName());
            return this;
        }

        /**
         * <p>The name of the folder. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("folderName")
        public _FinalStage folderName(String folderName) {
            this.folderName = folderName;
            return this;
        }

        @Override
        public RenameAssetFolderDto build() {
            return new RenameAssetFolderDto(folderName);
        }
    }
}
