package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SchemaDto.Builder.class)
public final class SchemaDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final String id;

    private final String createdBy;

    private final String lastModifiedBy;

    private final String name;

    private final SchemaType type;

    private final Optional<String> category;

    private final SchemaPropertiesDto properties;

    private final boolean isSingleton;

    private final boolean isPublished;

    private final OffsetDateTime created;

    private final OffsetDateTime lastModified;

    private final int version;

    private final SchemaScriptsDto scripts;

    private final Map<String, String> previewUrls;

    private final List<String> fieldsInLists;

    private final List<String> fieldsInReferences;

    private final List<FieldRuleDto> fieldRules;

    private final List<FieldDto> fields;

    private SchemaDto(
            Map<String, ResourceLink> links,
            String id,
            String createdBy,
            String lastModifiedBy,
            String name,
            SchemaType type,
            Optional<String> category,
            SchemaPropertiesDto properties,
            boolean isSingleton,
            boolean isPublished,
            OffsetDateTime created,
            OffsetDateTime lastModified,
            int version,
            SchemaScriptsDto scripts,
            Map<String, String> previewUrls,
            List<String> fieldsInLists,
            List<String> fieldsInReferences,
            List<FieldRuleDto> fieldRules,
            List<FieldDto> fields) {
        this.links = links;
        this.id = id;
        this.createdBy = createdBy;
        this.lastModifiedBy = lastModifiedBy;
        this.name = name;
        this.type = type;
        this.category = category;
        this.properties = properties;
        this.isSingleton = isSingleton;
        this.isPublished = isPublished;
        this.created = created;
        this.lastModified = lastModified;
        this.version = version;
        this.scripts = scripts;
        this.previewUrls = previewUrls;
        this.fieldsInLists = fieldsInLists;
        this.fieldsInReferences = fieldsInReferences;
        this.fieldRules = fieldRules;
        this.fields = fields;
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
     * @return The ID of the schema.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The user that has created the schema. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("createdBy")
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @return The user that has updated the schema. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("lastModifiedBy")
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * @return The name of the schema. Unique within the app. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("type")
    public SchemaType getType() {
        return type;
    }

    /**
     * @return The name of the category.
     */
    @JsonProperty("category")
    public Optional<String> getCategory() {
        return category;
    }

    @JsonProperty("properties")
    public SchemaPropertiesDto getProperties() {
        return properties;
    }

    /**
     * @return Indicates if the schema is a singleton.
     */
    @JsonProperty("isSingleton")
    public boolean getIsSingleton() {
        return isSingleton;
    }

    /**
     * @return Indicates if the schema is published.
     */
    @JsonProperty("isPublished")
    public boolean getIsPublished() {
        return isPublished;
    }

    /**
     * @return The date and time when the schema has been created.
     */
    @JsonProperty("created")
    public OffsetDateTime getCreated() {
        return created;
    }

    /**
     * @return The date and time when the schema has been modified last.
     */
    @JsonProperty("lastModified")
    public OffsetDateTime getLastModified() {
        return lastModified;
    }

    /**
     * @return The version of the schema.
     */
    @JsonProperty("version")
    public int getVersion() {
        return version;
    }

    @JsonProperty("scripts")
    public SchemaScriptsDto getScripts() {
        return scripts;
    }

    /**
     * @return The preview Urls.
     */
    @JsonProperty("previewUrls")
    public Map<String, String> getPreviewUrls() {
        return previewUrls;
    }

    /**
     * @return The name of fields that are used in content lists.
     */
    @JsonProperty("fieldsInLists")
    public List<String> getFieldsInLists() {
        return fieldsInLists;
    }

    /**
     * @return The name of fields that are used in content references.
     */
    @JsonProperty("fieldsInReferences")
    public List<String> getFieldsInReferences() {
        return fieldsInReferences;
    }

    /**
     * @return The field rules.
     */
    @JsonProperty("fieldRules")
    public List<FieldRuleDto> getFieldRules() {
        return fieldRules;
    }

    /**
     * @return The list of fields.
     */
    @JsonProperty("fields")
    public List<FieldDto> getFields() {
        return fields;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SchemaDto && equalTo((SchemaDto) other);
    }

    private boolean equalTo(SchemaDto other) {
        return links.equals(other.links)
                && id.equals(other.id)
                && createdBy.equals(other.createdBy)
                && lastModifiedBy.equals(other.lastModifiedBy)
                && name.equals(other.name)
                && type.equals(other.type)
                && category.equals(other.category)
                && properties.equals(other.properties)
                && isSingleton == other.isSingleton
                && isPublished == other.isPublished
                && created.equals(other.created)
                && lastModified.equals(other.lastModified)
                && version == other.version
                && scripts.equals(other.scripts)
                && previewUrls.equals(other.previewUrls)
                && fieldsInLists.equals(other.fieldsInLists)
                && fieldsInReferences.equals(other.fieldsInReferences)
                && fieldRules.equals(other.fieldRules)
                && fields.equals(other.fields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.links,
                this.id,
                this.createdBy,
                this.lastModifiedBy,
                this.name,
                this.type,
                this.category,
                this.properties,
                this.isSingleton,
                this.isPublished,
                this.created,
                this.lastModified,
                this.version,
                this.scripts,
                this.previewUrls,
                this.fieldsInLists,
                this.fieldsInReferences,
                this.fieldRules,
                this.fields);
    }

    @Override
    public String toString() {
        return "SchemaDto{" + "links: " + links + ", id: " + id + ", createdBy: " + createdBy + ", lastModifiedBy: "
                + lastModifiedBy + ", name: " + name + ", type: " + type + ", category: " + category + ", properties: "
                + properties + ", isSingleton: " + isSingleton + ", isPublished: " + isPublished + ", created: "
                + created + ", lastModified: " + lastModified + ", version: " + version + ", scripts: " + scripts
                + ", previewUrls: " + previewUrls + ", fieldsInLists: " + fieldsInLists + ", fieldsInReferences: "
                + fieldsInReferences + ", fieldRules: " + fieldRules + ", fields: " + fields + "}";
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        CreatedByStage id(String id);

        Builder from(SchemaDto other);
    }

    public interface CreatedByStage {
        LastModifiedByStage createdBy(String createdBy);
    }

    public interface LastModifiedByStage {
        NameStage lastModifiedBy(String lastModifiedBy);
    }

    public interface NameStage {
        TypeStage name(String name);
    }

    public interface TypeStage {
        PropertiesStage type(SchemaType type);
    }

    public interface PropertiesStage {
        IsSingletonStage properties(SchemaPropertiesDto properties);
    }

    public interface IsSingletonStage {
        IsPublishedStage isSingleton(boolean isSingleton);
    }

    public interface IsPublishedStage {
        CreatedStage isPublished(boolean isPublished);
    }

    public interface CreatedStage {
        LastModifiedStage created(OffsetDateTime created);
    }

    public interface LastModifiedStage {
        VersionStage lastModified(OffsetDateTime lastModified);
    }

    public interface VersionStage {
        ScriptsStage version(int version);
    }

    public interface ScriptsStage {
        _FinalStage scripts(SchemaScriptsDto scripts);
    }

    public interface _FinalStage {
        SchemaDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);

        _FinalStage category(Optional<String> category);

        _FinalStage category(String category);

        _FinalStage previewUrls(Map<String, String> previewUrls);

        _FinalStage putAllPreviewUrls(Map<String, String> previewUrls);

        _FinalStage previewUrls(String key, String value);

        _FinalStage fieldsInLists(List<String> fieldsInLists);

        _FinalStage addFieldsInLists(String fieldsInLists);

        _FinalStage addAllFieldsInLists(List<String> fieldsInLists);

        _FinalStage fieldsInReferences(List<String> fieldsInReferences);

        _FinalStage addFieldsInReferences(String fieldsInReferences);

        _FinalStage addAllFieldsInReferences(List<String> fieldsInReferences);

        _FinalStage fieldRules(List<FieldRuleDto> fieldRules);

        _FinalStage addFieldRules(FieldRuleDto fieldRules);

        _FinalStage addAllFieldRules(List<FieldRuleDto> fieldRules);

        _FinalStage fields(List<FieldDto> fields);

        _FinalStage addFields(FieldDto fields);

        _FinalStage addAllFields(List<FieldDto> fields);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements IdStage,
                    CreatedByStage,
                    LastModifiedByStage,
                    NameStage,
                    TypeStage,
                    PropertiesStage,
                    IsSingletonStage,
                    IsPublishedStage,
                    CreatedStage,
                    LastModifiedStage,
                    VersionStage,
                    ScriptsStage,
                    _FinalStage {
        private String id;

        private String createdBy;

        private String lastModifiedBy;

        private String name;

        private SchemaType type;

        private SchemaPropertiesDto properties;

        private boolean isSingleton;

        private boolean isPublished;

        private OffsetDateTime created;

        private OffsetDateTime lastModified;

        private int version;

        private SchemaScriptsDto scripts;

        private List<FieldDto> fields = new ArrayList<>();

        private List<FieldRuleDto> fieldRules = new ArrayList<>();

        private List<String> fieldsInReferences = new ArrayList<>();

        private List<String> fieldsInLists = new ArrayList<>();

        private Map<String, String> previewUrls = new LinkedHashMap<>();

        private Optional<String> category = Optional.empty();

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(SchemaDto other) {
            links(other.getLinks());
            id(other.getId());
            createdBy(other.getCreatedBy());
            lastModifiedBy(other.getLastModifiedBy());
            name(other.getName());
            type(other.getType());
            category(other.getCategory());
            properties(other.getProperties());
            isSingleton(other.getIsSingleton());
            isPublished(other.getIsPublished());
            created(other.getCreated());
            lastModified(other.getLastModified());
            version(other.getVersion());
            scripts(other.getScripts());
            previewUrls(other.getPreviewUrls());
            fieldsInLists(other.getFieldsInLists());
            fieldsInReferences(other.getFieldsInReferences());
            fieldRules(other.getFieldRules());
            fields(other.getFields());
            return this;
        }

        /**
         * <p>The ID of the schema.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("id")
        public CreatedByStage id(String id) {
            this.id = id;
            return this;
        }

        /**
         * <p>The user that has created the schema. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("createdBy")
        public LastModifiedByStage createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        /**
         * <p>The user that has updated the schema. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("lastModifiedBy")
        public NameStage lastModifiedBy(String lastModifiedBy) {
            this.lastModifiedBy = lastModifiedBy;
            return this;
        }

        /**
         * <p>The name of the schema. Unique within the app. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name")
        public TypeStage name(String name) {
            this.name = name;
            return this;
        }

        @Override
        @JsonSetter("type")
        public PropertiesStage type(SchemaType type) {
            this.type = type;
            return this;
        }

        @Override
        @JsonSetter("properties")
        public IsSingletonStage properties(SchemaPropertiesDto properties) {
            this.properties = properties;
            return this;
        }

        /**
         * <p>Indicates if the schema is a singleton.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("isSingleton")
        public IsPublishedStage isSingleton(boolean isSingleton) {
            this.isSingleton = isSingleton;
            return this;
        }

        /**
         * <p>Indicates if the schema is published.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("isPublished")
        public CreatedStage isPublished(boolean isPublished) {
            this.isPublished = isPublished;
            return this;
        }

        /**
         * <p>The date and time when the schema has been created.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("created")
        public LastModifiedStage created(OffsetDateTime created) {
            this.created = created;
            return this;
        }

        /**
         * <p>The date and time when the schema has been modified last.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("lastModified")
        public VersionStage lastModified(OffsetDateTime lastModified) {
            this.lastModified = lastModified;
            return this;
        }

        /**
         * <p>The version of the schema.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("version")
        public ScriptsStage version(int version) {
            this.version = version;
            return this;
        }

        @Override
        @JsonSetter("scripts")
        public _FinalStage scripts(SchemaScriptsDto scripts) {
            this.scripts = scripts;
            return this;
        }

        /**
         * <p>The list of fields.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllFields(List<FieldDto> fields) {
            this.fields.addAll(fields);
            return this;
        }

        /**
         * <p>The list of fields.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addFields(FieldDto fields) {
            this.fields.add(fields);
            return this;
        }

        @Override
        @JsonSetter(value = "fields", nulls = Nulls.SKIP)
        public _FinalStage fields(List<FieldDto> fields) {
            this.fields.clear();
            this.fields.addAll(fields);
            return this;
        }

        /**
         * <p>The field rules.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllFieldRules(List<FieldRuleDto> fieldRules) {
            this.fieldRules.addAll(fieldRules);
            return this;
        }

        /**
         * <p>The field rules.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addFieldRules(FieldRuleDto fieldRules) {
            this.fieldRules.add(fieldRules);
            return this;
        }

        @Override
        @JsonSetter(value = "fieldRules", nulls = Nulls.SKIP)
        public _FinalStage fieldRules(List<FieldRuleDto> fieldRules) {
            this.fieldRules.clear();
            this.fieldRules.addAll(fieldRules);
            return this;
        }

        /**
         * <p>The name of fields that are used in content references.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllFieldsInReferences(List<String> fieldsInReferences) {
            this.fieldsInReferences.addAll(fieldsInReferences);
            return this;
        }

        /**
         * <p>The name of fields that are used in content references.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addFieldsInReferences(String fieldsInReferences) {
            this.fieldsInReferences.add(fieldsInReferences);
            return this;
        }

        @Override
        @JsonSetter(value = "fieldsInReferences", nulls = Nulls.SKIP)
        public _FinalStage fieldsInReferences(List<String> fieldsInReferences) {
            this.fieldsInReferences.clear();
            this.fieldsInReferences.addAll(fieldsInReferences);
            return this;
        }

        /**
         * <p>The name of fields that are used in content lists.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllFieldsInLists(List<String> fieldsInLists) {
            this.fieldsInLists.addAll(fieldsInLists);
            return this;
        }

        /**
         * <p>The name of fields that are used in content lists.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addFieldsInLists(String fieldsInLists) {
            this.fieldsInLists.add(fieldsInLists);
            return this;
        }

        @Override
        @JsonSetter(value = "fieldsInLists", nulls = Nulls.SKIP)
        public _FinalStage fieldsInLists(List<String> fieldsInLists) {
            this.fieldsInLists.clear();
            this.fieldsInLists.addAll(fieldsInLists);
            return this;
        }

        /**
         * <p>The preview Urls.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage previewUrls(String key, String value) {
            this.previewUrls.put(key, value);
            return this;
        }

        /**
         * <p>The preview Urls.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage putAllPreviewUrls(Map<String, String> previewUrls) {
            this.previewUrls.putAll(previewUrls);
            return this;
        }

        @Override
        @JsonSetter(value = "previewUrls", nulls = Nulls.SKIP)
        public _FinalStage previewUrls(Map<String, String> previewUrls) {
            this.previewUrls.clear();
            this.previewUrls.putAll(previewUrls);
            return this;
        }

        /**
         * <p>The name of the category.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage category(String category) {
            this.category = Optional.of(category);
            return this;
        }

        @Override
        @JsonSetter(value = "category", nulls = Nulls.SKIP)
        public _FinalStage category(Optional<String> category) {
            this.category = category;
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
        public SchemaDto build() {
            return new SchemaDto(
                    links,
                    id,
                    createdBy,
                    lastModifiedBy,
                    name,
                    type,
                    category,
                    properties,
                    isSingleton,
                    isPublished,
                    created,
                    lastModified,
                    version,
                    scripts,
                    previewUrls,
                    fieldsInLists,
                    fieldsInReferences,
                    fieldRules,
                    fields);
        }
    }
}
