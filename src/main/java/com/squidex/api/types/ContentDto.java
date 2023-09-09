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
@JsonDeserialize(builder = ContentDto.Builder.class)
public final class ContentDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final String id;

    private final String createdBy;

    private final String lastModifiedBy;

    private final Object data;

    private final Optional<Map<String, Map<String, Object>>> referenceData;

    private final OffsetDateTime created;

    private final OffsetDateTime lastModified;

    private final String status;

    private final Optional<String> newStatus;

    private final String statusColor;

    private final Optional<String> newStatusColor;

    private final Optional<String> editToken;

    private final Optional<ScheduleJobDto> scheduleJob;

    private final String schemaId;

    private final Optional<String> schemaName;

    private final Optional<String> schemaDisplayName;

    private final Optional<List<FieldDto>> referenceFields;

    private final boolean isDeleted;

    private final int version;

    private ContentDto(
            Map<String, ResourceLink> links,
            String id,
            String createdBy,
            String lastModifiedBy,
            Object data,
            Optional<Map<String, Map<String, Object>>> referenceData,
            OffsetDateTime created,
            OffsetDateTime lastModified,
            String status,
            Optional<String> newStatus,
            String statusColor,
            Optional<String> newStatusColor,
            Optional<String> editToken,
            Optional<ScheduleJobDto> scheduleJob,
            String schemaId,
            Optional<String> schemaName,
            Optional<String> schemaDisplayName,
            Optional<List<FieldDto>> referenceFields,
            boolean isDeleted,
            int version) {
        this.links = links;
        this.id = id;
        this.createdBy = createdBy;
        this.lastModifiedBy = lastModifiedBy;
        this.data = data;
        this.referenceData = referenceData;
        this.created = created;
        this.lastModified = lastModified;
        this.status = status;
        this.newStatus = newStatus;
        this.statusColor = statusColor;
        this.newStatusColor = newStatusColor;
        this.editToken = editToken;
        this.scheduleJob = scheduleJob;
        this.schemaId = schemaId;
        this.schemaName = schemaName;
        this.schemaDisplayName = schemaDisplayName;
        this.referenceFields = referenceFields;
        this.isDeleted = isDeleted;
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
     * @return The if of the content item.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The user that has created the content item.
     */
    @JsonProperty("createdBy")
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @return The user that has updated the content item.
     */
    @JsonProperty("lastModifiedBy")
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    @JsonProperty("data")
    public Object getData() {
        return data;
    }

    /**
     * @return The reference data for the frontend UI.
     */
    @JsonProperty("referenceData")
    public Optional<Map<String, Map<String, Object>>> getReferenceData() {
        return referenceData;
    }

    /**
     * @return The date and time when the content item has been created.
     */
    @JsonProperty("created")
    public OffsetDateTime getCreated() {
        return created;
    }

    /**
     * @return The date and time when the content item has been modified last.
     */
    @JsonProperty("lastModified")
    public OffsetDateTime getLastModified() {
        return lastModified;
    }

    /**
     * @return The status of the content.
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * @return The new status of the content.
     */
    @JsonProperty("newStatus")
    public Optional<String> getNewStatus() {
        return newStatus;
    }

    /**
     * @return The color of the status.
     */
    @JsonProperty("statusColor")
    public String getStatusColor() {
        return statusColor;
    }

    /**
     * @return The color of the new status.
     */
    @JsonProperty("newStatusColor")
    public Optional<String> getNewStatusColor() {
        return newStatusColor;
    }

    /**
     * @return The UI token.
     */
    @JsonProperty("editToken")
    public Optional<String> getEditToken() {
        return editToken;
    }

    /**
     * @return The scheduled status.
     */
    @JsonProperty("scheduleJob")
    public Optional<ScheduleJobDto> getScheduleJob() {
        return scheduleJob;
    }

    /**
     * @return The ID of the schema.
     */
    @JsonProperty("schemaId")
    public String getSchemaId() {
        return schemaId;
    }

    /**
     * @return The name of the schema.
     */
    @JsonProperty("schemaName")
    public Optional<String> getSchemaName() {
        return schemaName;
    }

    /**
     * @return The display name of the schema.
     */
    @JsonProperty("schemaDisplayName")
    public Optional<String> getSchemaDisplayName() {
        return schemaDisplayName;
    }

    /**
     * @return The reference fields.
     */
    @JsonProperty("referenceFields")
    public Optional<List<FieldDto>> getReferenceFields() {
        return referenceFields;
    }

    /**
     * @return Indicates whether the content is deleted.
     */
    @JsonProperty("isDeleted")
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * @return The version of the content.
     */
    @JsonProperty("version")
    public int getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ContentDto && equalTo((ContentDto) other);
    }

    private boolean equalTo(ContentDto other) {
        return links.equals(other.links)
                && id.equals(other.id)
                && createdBy.equals(other.createdBy)
                && lastModifiedBy.equals(other.lastModifiedBy)
                && data.equals(other.data)
                && referenceData.equals(other.referenceData)
                && created.equals(other.created)
                && lastModified.equals(other.lastModified)
                && status.equals(other.status)
                && newStatus.equals(other.newStatus)
                && statusColor.equals(other.statusColor)
                && newStatusColor.equals(other.newStatusColor)
                && editToken.equals(other.editToken)
                && scheduleJob.equals(other.scheduleJob)
                && schemaId.equals(other.schemaId)
                && schemaName.equals(other.schemaName)
                && schemaDisplayName.equals(other.schemaDisplayName)
                && referenceFields.equals(other.referenceFields)
                && isDeleted == other.isDeleted
                && version == other.version;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.links,
                this.id,
                this.createdBy,
                this.lastModifiedBy,
                this.data,
                this.referenceData,
                this.created,
                this.lastModified,
                this.status,
                this.newStatus,
                this.statusColor,
                this.newStatusColor,
                this.editToken,
                this.scheduleJob,
                this.schemaId,
                this.schemaName,
                this.schemaDisplayName,
                this.referenceFields,
                this.isDeleted,
                this.version);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        CreatedByStage id(String id);

        Builder from(ContentDto other);
    }

    public interface CreatedByStage {
        LastModifiedByStage createdBy(String createdBy);
    }

    public interface LastModifiedByStage {
        DataStage lastModifiedBy(String lastModifiedBy);
    }

    public interface DataStage {
        CreatedStage data(Object data);
    }

    public interface CreatedStage {
        LastModifiedStage created(OffsetDateTime created);
    }

    public interface LastModifiedStage {
        StatusStage lastModified(OffsetDateTime lastModified);
    }

    public interface StatusStage {
        StatusColorStage status(String status);
    }

    public interface StatusColorStage {
        SchemaIdStage statusColor(String statusColor);
    }

    public interface SchemaIdStage {
        IsDeletedStage schemaId(String schemaId);
    }

    public interface IsDeletedStage {
        VersionStage isDeleted(boolean isDeleted);
    }

    public interface VersionStage {
        _FinalStage version(int version);
    }

    public interface _FinalStage {
        ContentDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);

        _FinalStage referenceData(Optional<Map<String, Map<String, Object>>> referenceData);

        _FinalStage referenceData(Map<String, Map<String, Object>> referenceData);

        _FinalStage newStatus(Optional<String> newStatus);

        _FinalStage newStatus(String newStatus);

        _FinalStage newStatusColor(Optional<String> newStatusColor);

        _FinalStage newStatusColor(String newStatusColor);

        _FinalStage editToken(Optional<String> editToken);

        _FinalStage editToken(String editToken);

        _FinalStage scheduleJob(Optional<ScheduleJobDto> scheduleJob);

        _FinalStage scheduleJob(ScheduleJobDto scheduleJob);

        _FinalStage schemaName(Optional<String> schemaName);

        _FinalStage schemaName(String schemaName);

        _FinalStage schemaDisplayName(Optional<String> schemaDisplayName);

        _FinalStage schemaDisplayName(String schemaDisplayName);

        _FinalStage referenceFields(Optional<List<FieldDto>> referenceFields);

        _FinalStage referenceFields(List<FieldDto> referenceFields);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements IdStage,
                    CreatedByStage,
                    LastModifiedByStage,
                    DataStage,
                    CreatedStage,
                    LastModifiedStage,
                    StatusStage,
                    StatusColorStage,
                    SchemaIdStage,
                    IsDeletedStage,
                    VersionStage,
                    _FinalStage {
        private String id;

        private String createdBy;

        private String lastModifiedBy;

        private Object data;

        private OffsetDateTime created;

        private OffsetDateTime lastModified;

        private String status;

        private String statusColor;

        private String schemaId;

        private boolean isDeleted;

        private int version;

        private Optional<List<FieldDto>> referenceFields = Optional.empty();

        private Optional<String> schemaDisplayName = Optional.empty();

        private Optional<String> schemaName = Optional.empty();

        private Optional<ScheduleJobDto> scheduleJob = Optional.empty();

        private Optional<String> editToken = Optional.empty();

        private Optional<String> newStatusColor = Optional.empty();

        private Optional<String> newStatus = Optional.empty();

        private Optional<Map<String, Map<String, Object>>> referenceData = Optional.empty();

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(ContentDto other) {
            links(other.getLinks());
            id(other.getId());
            createdBy(other.getCreatedBy());
            lastModifiedBy(other.getLastModifiedBy());
            data(other.getData());
            referenceData(other.getReferenceData());
            created(other.getCreated());
            lastModified(other.getLastModified());
            status(other.getStatus());
            newStatus(other.getNewStatus());
            statusColor(other.getStatusColor());
            newStatusColor(other.getNewStatusColor());
            editToken(other.getEditToken());
            scheduleJob(other.getScheduleJob());
            schemaId(other.getSchemaId());
            schemaName(other.getSchemaName());
            schemaDisplayName(other.getSchemaDisplayName());
            referenceFields(other.getReferenceFields());
            isDeleted(other.getIsDeleted());
            version(other.getVersion());
            return this;
        }

        /**
         * <p>The if of the content item.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("id")
        public CreatedByStage id(String id) {
            this.id = id;
            return this;
        }

        /**
         * <p>The user that has created the content item.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("createdBy")
        public LastModifiedByStage createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        /**
         * <p>The user that has updated the content item.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("lastModifiedBy")
        public DataStage lastModifiedBy(String lastModifiedBy) {
            this.lastModifiedBy = lastModifiedBy;
            return this;
        }

        @Override
        @JsonSetter("data")
        public CreatedStage data(Object data) {
            this.data = data;
            return this;
        }

        /**
         * <p>The date and time when the content item has been created.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("created")
        public LastModifiedStage created(OffsetDateTime created) {
            this.created = created;
            return this;
        }

        /**
         * <p>The date and time when the content item has been modified last.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("lastModified")
        public StatusStage lastModified(OffsetDateTime lastModified) {
            this.lastModified = lastModified;
            return this;
        }

        /**
         * <p>The status of the content.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("status")
        public StatusColorStage status(String status) {
            this.status = status;
            return this;
        }

        /**
         * <p>The color of the status.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("statusColor")
        public SchemaIdStage statusColor(String statusColor) {
            this.statusColor = statusColor;
            return this;
        }

        /**
         * <p>The ID of the schema.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("schemaId")
        public IsDeletedStage schemaId(String schemaId) {
            this.schemaId = schemaId;
            return this;
        }

        /**
         * <p>Indicates whether the content is deleted.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("isDeleted")
        public VersionStage isDeleted(boolean isDeleted) {
            this.isDeleted = isDeleted;
            return this;
        }

        /**
         * <p>The version of the content.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("version")
        public _FinalStage version(int version) {
            this.version = version;
            return this;
        }

        /**
         * <p>The reference fields.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage referenceFields(List<FieldDto> referenceFields) {
            this.referenceFields = Optional.of(referenceFields);
            return this;
        }

        @Override
        @JsonSetter(value = "referenceFields", nulls = Nulls.SKIP)
        public _FinalStage referenceFields(Optional<List<FieldDto>> referenceFields) {
            this.referenceFields = referenceFields;
            return this;
        }

        /**
         * <p>The display name of the schema.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage schemaDisplayName(String schemaDisplayName) {
            this.schemaDisplayName = Optional.of(schemaDisplayName);
            return this;
        }

        @Override
        @JsonSetter(value = "schemaDisplayName", nulls = Nulls.SKIP)
        public _FinalStage schemaDisplayName(Optional<String> schemaDisplayName) {
            this.schemaDisplayName = schemaDisplayName;
            return this;
        }

        /**
         * <p>The name of the schema.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage schemaName(String schemaName) {
            this.schemaName = Optional.of(schemaName);
            return this;
        }

        @Override
        @JsonSetter(value = "schemaName", nulls = Nulls.SKIP)
        public _FinalStage schemaName(Optional<String> schemaName) {
            this.schemaName = schemaName;
            return this;
        }

        /**
         * <p>The scheduled status.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage scheduleJob(ScheduleJobDto scheduleJob) {
            this.scheduleJob = Optional.of(scheduleJob);
            return this;
        }

        @Override
        @JsonSetter(value = "scheduleJob", nulls = Nulls.SKIP)
        public _FinalStage scheduleJob(Optional<ScheduleJobDto> scheduleJob) {
            this.scheduleJob = scheduleJob;
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
         * <p>The color of the new status.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage newStatusColor(String newStatusColor) {
            this.newStatusColor = Optional.of(newStatusColor);
            return this;
        }

        @Override
        @JsonSetter(value = "newStatusColor", nulls = Nulls.SKIP)
        public _FinalStage newStatusColor(Optional<String> newStatusColor) {
            this.newStatusColor = newStatusColor;
            return this;
        }

        /**
         * <p>The new status of the content.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage newStatus(String newStatus) {
            this.newStatus = Optional.of(newStatus);
            return this;
        }

        @Override
        @JsonSetter(value = "newStatus", nulls = Nulls.SKIP)
        public _FinalStage newStatus(Optional<String> newStatus) {
            this.newStatus = newStatus;
            return this;
        }

        /**
         * <p>The reference data for the frontend UI.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage referenceData(Map<String, Map<String, Object>> referenceData) {
            this.referenceData = Optional.of(referenceData);
            return this;
        }

        @Override
        @JsonSetter(value = "referenceData", nulls = Nulls.SKIP)
        public _FinalStage referenceData(Optional<Map<String, Map<String, Object>>> referenceData) {
            this.referenceData = referenceData;
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
        public ContentDto build() {
            return new ContentDto(
                    links,
                    id,
                    createdBy,
                    lastModifiedBy,
                    data,
                    referenceData,
                    created,
                    lastModified,
                    status,
                    newStatus,
                    statusColor,
                    newStatusColor,
                    editToken,
                    scheduleJob,
                    schemaId,
                    schemaName,
                    schemaDisplayName,
                    referenceFields,
                    isDeleted,
                    version);
        }
    }
}
