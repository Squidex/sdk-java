package com.squidex.api.resources.assets.requests;

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
@JsonDeserialize(builder = CreateAssetFolderDto.Builder.class)
public final class CreateAssetFolderDto {
    private final String folderName;

    private final Optional<String> parentId;

    private CreateAssetFolderDto(String folderName, Optional<String> parentId) {
        this.folderName = folderName;
        this.parentId = parentId;
    }

    /**
     * @return The name of the folder. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("folderName")
    public String getFolderName() {
        return folderName;
    }

    /**
     * @return The ID of the parent folder.
     */
    @JsonProperty("parentId")
    public Optional<String> getParentId() {
        return parentId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateAssetFolderDto && equalTo((CreateAssetFolderDto) other);
    }

    private boolean equalTo(CreateAssetFolderDto other) {
        return folderName.equals(other.folderName) && parentId.equals(other.parentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.folderName, this.parentId);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static FolderNameStage builder() {
        return new Builder();
    }

    public interface FolderNameStage {
        _FinalStage folderName(String folderName);

        Builder from(CreateAssetFolderDto other);
    }

    public interface _FinalStage {
        CreateAssetFolderDto build();

        _FinalStage parentId(Optional<String> parentId);

        _FinalStage parentId(String parentId);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements FolderNameStage, _FinalStage {
        private String folderName;

        private Optional<String> parentId = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(CreateAssetFolderDto other) {
            folderName(other.getFolderName());
            parentId(other.getParentId());
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

        /**
         * <p>The ID of the parent folder.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage parentId(String parentId) {
            this.parentId = Optional.of(parentId);
            return this;
        }

        @Override
        @JsonSetter(value = "parentId", nulls = Nulls.SKIP)
        public _FinalStage parentId(Optional<String> parentId) {
            this.parentId = parentId;
            return this;
        }

        @Override
        public CreateAssetFolderDto build() {
            return new CreateAssetFolderDto(folderName, parentId);
        }
    }
}
