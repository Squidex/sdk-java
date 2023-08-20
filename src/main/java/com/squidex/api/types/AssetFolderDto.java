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
@JsonDeserialize(builder = AssetFolderDto.Builder.class)
public final class AssetFolderDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final String id;

    private final String parentId;

    private final String folderName;

    private final int version;

    private AssetFolderDto(
            Map<String, ResourceLink> links, String id, String parentId, String folderName, int version) {
        this.links = links;
        this.id = id;
        this.parentId = parentId;
        this.folderName = folderName;
        this.version = version;
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
     * @return The ID of the asset.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The ID of the parent folder. Empty for files without parent.
     */
    @JsonProperty("parentId")
    public String getParentId() {
        return parentId;
    }

    /**
     * @return The folder name.
     */
    @JsonProperty("folderName")
    public String getFolderName() {
        return folderName;
    }

    /**
     * @return The version of the asset folder.
     */
    @JsonProperty("version")
    public int getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AssetFolderDto && equalTo((AssetFolderDto) other);
    }

    private boolean equalTo(AssetFolderDto other) {
        return links.equals(other.links)
                && id.equals(other.id)
                && parentId.equals(other.parentId)
                && folderName.equals(other.folderName)
                && version == other.version;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.links, this.id, this.parentId, this.folderName, this.version);
    }

    @Override
    public String toString() {
        return "AssetFolderDto{" + "links: " + links + ", id: " + id + ", parentId: " + parentId + ", folderName: "
                + folderName + ", version: " + version + "}";
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        ParentIdStage id(String id);

        Builder from(AssetFolderDto other);
    }

    public interface ParentIdStage {
        FolderNameStage parentId(String parentId);
    }

    public interface FolderNameStage {
        VersionStage folderName(String folderName);
    }

    public interface VersionStage {
        _FinalStage version(int version);
    }

    public interface _FinalStage {
        AssetFolderDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, ParentIdStage, FolderNameStage, VersionStage, _FinalStage {
        private String id;

        private String parentId;

        private String folderName;

        private int version;

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(AssetFolderDto other) {
            links(other.getLinks());
            id(other.getId());
            parentId(other.getParentId());
            folderName(other.getFolderName());
            version(other.getVersion());
            return this;
        }

        /**
         * <p>The ID of the asset.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("id")
        public ParentIdStage id(String id) {
            this.id = id;
            return this;
        }

        /**
         * <p>The ID of the parent folder. Empty for files without parent.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("parentId")
        public FolderNameStage parentId(String parentId) {
            this.parentId = parentId;
            return this;
        }

        /**
         * <p>The folder name.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("folderName")
        public VersionStage folderName(String folderName) {
            this.folderName = folderName;
            return this;
        }

        /**
         * <p>The version of the asset folder.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("version")
        public _FinalStage version(int version) {
            this.version = version;
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
        public AssetFolderDto build() {
            return new AssetFolderDto(links, id, parentId, folderName, version);
        }
    }
}
