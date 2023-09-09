package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AssetDto.Builder.class)
public final class AssetDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final String id;

    private final String parentId;

    private final String fileName;

    private final Optional<String> fileHash;

    private final boolean isProtected;

    private final String slug;

    private final String mimeType;

    private final String fileType;

    private final String metadataText;

    private final Optional<String> editToken;

    private final Map<String, Object> metadata;

    private final Optional<List<String>> tags;

    private final int fileSize;

    private final int fileVersion;

    private final AssetType type;

    private final String createdBy;

    private final String lastModifiedBy;

    private final OffsetDateTime created;

    private final OffsetDateTime lastModified;

    private final int version;

    private final Optional<AssetMeta> meta;

    private final boolean isImage;

    private final Optional<Integer> pixelWidth;

    private final Optional<Integer> pixelHeight;

    private AssetDto(
            Map<String, ResourceLink> links,
            String id,
            String parentId,
            String fileName,
            Optional<String> fileHash,
            boolean isProtected,
            String slug,
            String mimeType,
            String fileType,
            String metadataText,
            Optional<String> editToken,
            Map<String, Object> metadata,
            Optional<List<String>> tags,
            int fileSize,
            int fileVersion,
            AssetType type,
            String createdBy,
            String lastModifiedBy,
            OffsetDateTime created,
            OffsetDateTime lastModified,
            int version,
            Optional<AssetMeta> meta,
            boolean isImage,
            Optional<Integer> pixelWidth,
            Optional<Integer> pixelHeight) {
        this.links = links;
        this.id = id;
        this.parentId = parentId;
        this.fileName = fileName;
        this.fileHash = fileHash;
        this.isProtected = isProtected;
        this.slug = slug;
        this.mimeType = mimeType;
        this.fileType = fileType;
        this.metadataText = metadataText;
        this.editToken = editToken;
        this.metadata = metadata;
        this.tags = tags;
        this.fileSize = fileSize;
        this.fileVersion = fileVersion;
        this.type = type;
        this.createdBy = createdBy;
        this.lastModifiedBy = lastModifiedBy;
        this.created = created;
        this.lastModified = lastModified;
        this.version = version;
        this.meta = meta;
        this.isImage = isImage;
        this.pixelWidth = pixelWidth;
        this.pixelHeight = pixelHeight;
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
     * @return The file name.
     */
    @JsonProperty("fileName")
    public String getFileName() {
        return fileName;
    }

    /**
     * @return The file hash.
     */
    @JsonProperty("fileHash")
    public Optional<String> getFileHash() {
        return fileHash;
    }

    /**
     * @return True, when the asset is not public.
     */
    @JsonProperty("isProtected")
    public boolean getIsProtected() {
        return isProtected;
    }

    /**
     * @return The slug.
     */
    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    /**
     * @return The mime type.
     */
    @JsonProperty("mimeType")
    public String getMimeType() {
        return mimeType;
    }

    /**
     * @return The file type.
     */
    @JsonProperty("fileType")
    public String getFileType() {
        return fileType;
    }

    /**
     * @return The formatted text representation of the metadata.
     */
    @JsonProperty("metadataText")
    public String getMetadataText() {
        return metadataText;
    }

    /**
     * @return The UI token.
     */
    @JsonProperty("editToken")
    public Optional<String> getEditToken() {
        return editToken;
    }

    /**
     * @return The asset metadata.
     */
    @JsonProperty("metadata")
    public Map<String, Object> getMetadata() {
        return metadata;
    }

    /**
     * @return The asset tags.
     */
    @JsonProperty("tags")
    public Optional<List<String>> getTags() {
        return tags;
    }

    /**
     * @return The size of the file in bytes.
     */
    @JsonProperty("fileSize")
    public int getFileSize() {
        return fileSize;
    }

    /**
     * @return The version of the file.
     */
    @JsonProperty("fileVersion")
    public int getFileVersion() {
        return fileVersion;
    }

    /**
     * @return The type of the asset.
     */
    @JsonProperty("type")
    public AssetType getType() {
        return type;
    }

    /**
     * @return The user that has created the schema.
     */
    @JsonProperty("createdBy")
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @return The user that has updated the asset.
     */
    @JsonProperty("lastModifiedBy")
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * @return The date and time when the asset has been created.
     */
    @JsonProperty("created")
    public OffsetDateTime getCreated() {
        return created;
    }

    /**
     * @return The date and time when the asset has been modified last.
     */
    @JsonProperty("lastModified")
    public OffsetDateTime getLastModified() {
        return lastModified;
    }

    /**
     * @return The version of the asset.
     */
    @JsonProperty("version")
    public int getVersion() {
        return version;
    }

    /**
     * @return The metadata.
     */
    @JsonProperty("_meta")
    public Optional<AssetMeta> getMeta() {
        return meta;
    }

    /**
     * @return Determines of the created file is an image.
     */
    @JsonProperty("isImage")
    public boolean getIsImage() {
        return isImage;
    }

    /**
     * @return The width of the image in pixels if the asset is an image.
     */
    @JsonProperty("pixelWidth")
    public Optional<Integer> getPixelWidth() {
        return pixelWidth;
    }

    /**
     * @return The height of the image in pixels if the asset is an image.
     */
    @JsonProperty("pixelHeight")
    public Optional<Integer> getPixelHeight() {
        return pixelHeight;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AssetDto && equalTo((AssetDto) other);
    }

    private boolean equalTo(AssetDto other) {
        return links.equals(other.links)
                && id.equals(other.id)
                && parentId.equals(other.parentId)
                && fileName.equals(other.fileName)
                && fileHash.equals(other.fileHash)
                && isProtected == other.isProtected
                && slug.equals(other.slug)
                && mimeType.equals(other.mimeType)
                && fileType.equals(other.fileType)
                && metadataText.equals(other.metadataText)
                && editToken.equals(other.editToken)
                && metadata.equals(other.metadata)
                && tags.equals(other.tags)
                && fileSize == other.fileSize
                && fileVersion == other.fileVersion
                && type.equals(other.type)
                && createdBy.equals(other.createdBy)
                && lastModifiedBy.equals(other.lastModifiedBy)
                && created.equals(other.created)
                && lastModified.equals(other.lastModified)
                && version == other.version
                && meta.equals(other.meta)
                && isImage == other.isImage
                && pixelWidth.equals(other.pixelWidth)
                && pixelHeight.equals(other.pixelHeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.links,
                this.id,
                this.parentId,
                this.fileName,
                this.fileHash,
                this.isProtected,
                this.slug,
                this.mimeType,
                this.fileType,
                this.metadataText,
                this.editToken,
                this.metadata,
                this.tags,
                this.fileSize,
                this.fileVersion,
                this.type,
                this.createdBy,
                this.lastModifiedBy,
                this.created,
                this.lastModified,
                this.version,
                this.meta,
                this.isImage,
                this.pixelWidth,
                this.pixelHeight);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        ParentIdStage id(String id);

        Builder from(AssetDto other);
    }

    public interface ParentIdStage {
        FileNameStage parentId(String parentId);
    }

    public interface FileNameStage {
        IsProtectedStage fileName(String fileName);
    }

    public interface IsProtectedStage {
        SlugStage isProtected(boolean isProtected);
    }

    public interface SlugStage {
        MimeTypeStage slug(String slug);
    }

    public interface MimeTypeStage {
        FileTypeStage mimeType(String mimeType);
    }

    public interface FileTypeStage {
        MetadataTextStage fileType(String fileType);
    }

    public interface MetadataTextStage {
        FileSizeStage metadataText(String metadataText);
    }

    public interface FileSizeStage {
        FileVersionStage fileSize(int fileSize);
    }

    public interface FileVersionStage {
        TypeStage fileVersion(int fileVersion);
    }

    public interface TypeStage {
        CreatedByStage type(AssetType type);
    }

    public interface CreatedByStage {
        LastModifiedByStage createdBy(String createdBy);
    }

    public interface LastModifiedByStage {
        CreatedStage lastModifiedBy(String lastModifiedBy);
    }

    public interface CreatedStage {
        LastModifiedStage created(OffsetDateTime created);
    }

    public interface LastModifiedStage {
        VersionStage lastModified(OffsetDateTime lastModified);
    }

    public interface VersionStage {
        IsImageStage version(int version);
    }

    public interface IsImageStage {
        _FinalStage isImage(boolean isImage);
    }

    public interface _FinalStage {
        AssetDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);

        _FinalStage fileHash(Optional<String> fileHash);

        _FinalStage fileHash(String fileHash);

        _FinalStage editToken(Optional<String> editToken);

        _FinalStage editToken(String editToken);

        _FinalStage metadata(Map<String, Object> metadata);

        _FinalStage putAllMetadata(Map<String, Object> metadata);

        _FinalStage metadata(String key, Object value);

        _FinalStage tags(Optional<List<String>> tags);

        _FinalStage tags(List<String> tags);

        _FinalStage meta(Optional<AssetMeta> meta);

        _FinalStage meta(AssetMeta meta);

        _FinalStage pixelWidth(Optional<Integer> pixelWidth);

        _FinalStage pixelWidth(Integer pixelWidth);

        _FinalStage pixelHeight(Optional<Integer> pixelHeight);

        _FinalStage pixelHeight(Integer pixelHeight);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements IdStage,
                    ParentIdStage,
                    FileNameStage,
                    IsProtectedStage,
                    SlugStage,
                    MimeTypeStage,
                    FileTypeStage,
                    MetadataTextStage,
                    FileSizeStage,
                    FileVersionStage,
                    TypeStage,
                    CreatedByStage,
                    LastModifiedByStage,
                    CreatedStage,
                    LastModifiedStage,
                    VersionStage,
                    IsImageStage,
                    _FinalStage {
        private String id;

        private String parentId;

        private String fileName;

        private boolean isProtected;

        private String slug;

        private String mimeType;

        private String fileType;

        private String metadataText;

        private int fileSize;

        private int fileVersion;

        private AssetType type;

        private String createdBy;

        private String lastModifiedBy;

        private OffsetDateTime created;

        private OffsetDateTime lastModified;

        private int version;

        private boolean isImage;

        private Optional<Integer> pixelHeight = Optional.empty();

        private Optional<Integer> pixelWidth = Optional.empty();

        private Optional<AssetMeta> meta = Optional.empty();

        private Optional<List<String>> tags = Optional.empty();

        private Map<String, Object> metadata = new LinkedHashMap<>();

        private Optional<String> editToken = Optional.empty();

        private Optional<String> fileHash = Optional.empty();

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(AssetDto other) {
            links(other.getLinks());
            id(other.getId());
            parentId(other.getParentId());
            fileName(other.getFileName());
            fileHash(other.getFileHash());
            isProtected(other.getIsProtected());
            slug(other.getSlug());
            mimeType(other.getMimeType());
            fileType(other.getFileType());
            metadataText(other.getMetadataText());
            editToken(other.getEditToken());
            metadata(other.getMetadata());
            tags(other.getTags());
            fileSize(other.getFileSize());
            fileVersion(other.getFileVersion());
            type(other.getType());
            createdBy(other.getCreatedBy());
            lastModifiedBy(other.getLastModifiedBy());
            created(other.getCreated());
            lastModified(other.getLastModified());
            version(other.getVersion());
            meta(other.getMeta());
            isImage(other.getIsImage());
            pixelWidth(other.getPixelWidth());
            pixelHeight(other.getPixelHeight());
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
        public FileNameStage parentId(String parentId) {
            this.parentId = parentId;
            return this;
        }

        /**
         * <p>The file name.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("fileName")
        public IsProtectedStage fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        /**
         * <p>True, when the asset is not public.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("isProtected")
        public SlugStage isProtected(boolean isProtected) {
            this.isProtected = isProtected;
            return this;
        }

        /**
         * <p>The slug.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("slug")
        public MimeTypeStage slug(String slug) {
            this.slug = slug;
            return this;
        }

        /**
         * <p>The mime type.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("mimeType")
        public FileTypeStage mimeType(String mimeType) {
            this.mimeType = mimeType;
            return this;
        }

        /**
         * <p>The file type.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("fileType")
        public MetadataTextStage fileType(String fileType) {
            this.fileType = fileType;
            return this;
        }

        /**
         * <p>The formatted text representation of the metadata.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("metadataText")
        public FileSizeStage metadataText(String metadataText) {
            this.metadataText = metadataText;
            return this;
        }

        /**
         * <p>The size of the file in bytes.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("fileSize")
        public FileVersionStage fileSize(int fileSize) {
            this.fileSize = fileSize;
            return this;
        }

        /**
         * <p>The version of the file.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("fileVersion")
        public TypeStage fileVersion(int fileVersion) {
            this.fileVersion = fileVersion;
            return this;
        }

        /**
         * <p>The type of the asset.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("type")
        public CreatedByStage type(AssetType type) {
            this.type = type;
            return this;
        }

        /**
         * <p>The user that has created the schema.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("createdBy")
        public LastModifiedByStage createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        /**
         * <p>The user that has updated the asset.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("lastModifiedBy")
        public CreatedStage lastModifiedBy(String lastModifiedBy) {
            this.lastModifiedBy = lastModifiedBy;
            return this;
        }

        /**
         * <p>The date and time when the asset has been created.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("created")
        public LastModifiedStage created(OffsetDateTime created) {
            this.created = created;
            return this;
        }

        /**
         * <p>The date and time when the asset has been modified last.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("lastModified")
        public VersionStage lastModified(OffsetDateTime lastModified) {
            this.lastModified = lastModified;
            return this;
        }

        /**
         * <p>The version of the asset.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("version")
        public IsImageStage version(int version) {
            this.version = version;
            return this;
        }

        /**
         * <p>Determines of the created file is an image.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("isImage")
        public _FinalStage isImage(boolean isImage) {
            this.isImage = isImage;
            return this;
        }

        /**
         * <p>The height of the image in pixels if the asset is an image.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage pixelHeight(Integer pixelHeight) {
            this.pixelHeight = Optional.of(pixelHeight);
            return this;
        }

        @Override
        @JsonSetter(value = "pixelHeight", nulls = Nulls.SKIP)
        public _FinalStage pixelHeight(Optional<Integer> pixelHeight) {
            this.pixelHeight = pixelHeight;
            return this;
        }

        /**
         * <p>The width of the image in pixels if the asset is an image.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage pixelWidth(Integer pixelWidth) {
            this.pixelWidth = Optional.of(pixelWidth);
            return this;
        }

        @Override
        @JsonSetter(value = "pixelWidth", nulls = Nulls.SKIP)
        public _FinalStage pixelWidth(Optional<Integer> pixelWidth) {
            this.pixelWidth = pixelWidth;
            return this;
        }

        /**
         * <p>The metadata.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage meta(AssetMeta meta) {
            this.meta = Optional.of(meta);
            return this;
        }

        @Override
        @JsonSetter(value = "_meta", nulls = Nulls.SKIP)
        public _FinalStage meta(Optional<AssetMeta> meta) {
            this.meta = meta;
            return this;
        }

        /**
         * <p>The asset tags.</p>
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
         * <p>The asset metadata.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage metadata(String key, Object value) {
            this.metadata.put(key, value);
            return this;
        }

        /**
         * <p>The asset metadata.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage putAllMetadata(Map<String, Object> metadata) {
            this.metadata.putAll(metadata);
            return this;
        }

        @Override
        @JsonSetter(value = "metadata", nulls = Nulls.SKIP)
        public _FinalStage metadata(Map<String, Object> metadata) {
            this.metadata.clear();
            this.metadata.putAll(metadata);
            return this;
        }

        /**
         * <p>The UI token.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage editToken(String editToken) {
            this.editToken = Optional.of(editToken);
            return this;
        }

        @Override
        @JsonSetter(value = "editToken", nulls = Nulls.SKIP)
        public _FinalStage editToken(Optional<String> editToken) {
            this.editToken = editToken;
            return this;
        }

        /**
         * <p>The file hash.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage fileHash(String fileHash) {
            this.fileHash = Optional.of(fileHash);
            return this;
        }

        @Override
        @JsonSetter(value = "fileHash", nulls = Nulls.SKIP)
        public _FinalStage fileHash(Optional<String> fileHash) {
            this.fileHash = fileHash;
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
        public AssetDto build() {
            return new AssetDto(
                    links,
                    id,
                    parentId,
                    fileName,
                    fileHash,
                    isProtected,
                    slug,
                    mimeType,
                    fileType,
                    metadataText,
                    editToken,
                    metadata,
                    tags,
                    fileSize,
                    fileVersion,
                    type,
                    createdBy,
                    lastModifiedBy,
                    created,
                    lastModified,
                    version,
                    meta,
                    isImage,
                    pixelWidth,
                    pixelHeight);
        }
    }
}
