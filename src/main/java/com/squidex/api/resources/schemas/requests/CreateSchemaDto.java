package com.squidex.api.resources.schemas.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import com.squidex.api.types.FieldRuleDto;
import com.squidex.api.types.IUpsertSchemaDto;
import com.squidex.api.types.SchemaPropertiesDto;
import com.squidex.api.types.SchemaScriptsDto;
import com.squidex.api.types.SchemaType;
import com.squidex.api.types.UpsertSchemaFieldDto;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CreateSchemaDto.Builder.class)
public final class CreateSchemaDto implements IUpsertSchemaDto {
    private final Optional<SchemaPropertiesDto> properties;

    private final Optional<SchemaScriptsDto> scripts;

    private final Optional<List<String>> fieldsInReferences;

    private final Optional<List<String>> fieldsInLists;

    private final Optional<List<UpsertSchemaFieldDto>> fields;

    private final Optional<Map<String, Optional<String>>> previewUrls;

    private final Optional<List<FieldRuleDto>> fieldRules;

    private final Optional<String> category;

    private final Optional<Boolean> isPublished;

    private final String name;

    private final Optional<SchemaType> type;

    private final Optional<Boolean> isSingleton;

    private CreateSchemaDto(
            Optional<SchemaPropertiesDto> properties,
            Optional<SchemaScriptsDto> scripts,
            Optional<List<String>> fieldsInReferences,
            Optional<List<String>> fieldsInLists,
            Optional<List<UpsertSchemaFieldDto>> fields,
            Optional<Map<String, Optional<String>>> previewUrls,
            Optional<List<FieldRuleDto>> fieldRules,
            Optional<String> category,
            Optional<Boolean> isPublished,
            String name,
            Optional<SchemaType> type,
            Optional<Boolean> isSingleton) {
        this.properties = properties;
        this.scripts = scripts;
        this.fieldsInReferences = fieldsInReferences;
        this.fieldsInLists = fieldsInLists;
        this.fields = fields;
        this.previewUrls = previewUrls;
        this.fieldRules = fieldRules;
        this.category = category;
        this.isPublished = isPublished;
        this.name = name;
        this.type = type;
        this.isSingleton = isSingleton;
    }

    /**
     * @return The optional properties.
     */
    @JsonProperty("properties")
    @Override
    public Optional<SchemaPropertiesDto> getProperties() {
        return properties;
    }

    /**
     * @return The optional scripts.
     */
    @JsonProperty("scripts")
    @Override
    public Optional<SchemaScriptsDto> getScripts() {
        return scripts;
    }

    /**
     * @return The names of the fields that should be used in references.
     */
    @JsonProperty("fieldsInReferences")
    @Override
    public Optional<List<String>> getFieldsInReferences() {
        return fieldsInReferences;
    }

    /**
     * @return The names of the fields that should be shown in lists, including meta fields.
     */
    @JsonProperty("fieldsInLists")
    @Override
    public Optional<List<String>> getFieldsInLists() {
        return fieldsInLists;
    }

    /**
     * @return Optional fields.
     */
    @JsonProperty("fields")
    @Override
    public Optional<List<UpsertSchemaFieldDto>> getFields() {
        return fields;
    }

    /**
     * @return The optional preview urls.
     */
    @JsonProperty("previewUrls")
    @Override
    public Optional<Map<String, Optional<String>>> getPreviewUrls() {
        return previewUrls;
    }

    /**
     * @return The optional field Rules.
     */
    @JsonProperty("fieldRules")
    @Override
    public Optional<List<FieldRuleDto>> getFieldRules() {
        return fieldRules;
    }

    /**
     * @return The category.
     */
    @JsonProperty("category")
    @Override
    public Optional<String> getCategory() {
        return category;
    }

    /**
     * @return Set it to true to autopublish the schema.
     */
    @JsonProperty("isPublished")
    @Override
    public Optional<Boolean> getIsPublished() {
        return isPublished;
    }

    /**
     * @return The name of the schema. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @return The type of the schema.
     */
    @JsonProperty("type")
    public Optional<SchemaType> getType() {
        return type;
    }

    /**
     * @return Set to true to allow a single content item only.
     */
    @JsonProperty("isSingleton")
    public Optional<Boolean> getIsSingleton() {
        return isSingleton;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateSchemaDto && equalTo((CreateSchemaDto) other);
    }

    private boolean equalTo(CreateSchemaDto other) {
        return properties.equals(other.properties)
                && scripts.equals(other.scripts)
                && fieldsInReferences.equals(other.fieldsInReferences)
                && fieldsInLists.equals(other.fieldsInLists)
                && fields.equals(other.fields)
                && previewUrls.equals(other.previewUrls)
                && fieldRules.equals(other.fieldRules)
                && category.equals(other.category)
                && isPublished.equals(other.isPublished)
                && name.equals(other.name)
                && type.equals(other.type)
                && isSingleton.equals(other.isSingleton);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.properties,
                this.scripts,
                this.fieldsInReferences,
                this.fieldsInLists,
                this.fields,
                this.previewUrls,
                this.fieldRules,
                this.category,
                this.isPublished,
                this.name,
                this.type,
                this.isSingleton);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        _FinalStage name(String name);

        Builder from(CreateSchemaDto other);
    }

    public interface _FinalStage {
        CreateSchemaDto build();

        _FinalStage properties(Optional<SchemaPropertiesDto> properties);

        _FinalStage properties(SchemaPropertiesDto properties);

        _FinalStage scripts(Optional<SchemaScriptsDto> scripts);

        _FinalStage scripts(SchemaScriptsDto scripts);

        _FinalStage fieldsInReferences(Optional<List<String>> fieldsInReferences);

        _FinalStage fieldsInReferences(List<String> fieldsInReferences);

        _FinalStage fieldsInLists(Optional<List<String>> fieldsInLists);

        _FinalStage fieldsInLists(List<String> fieldsInLists);

        _FinalStage fields(Optional<List<UpsertSchemaFieldDto>> fields);

        _FinalStage fields(List<UpsertSchemaFieldDto> fields);

        _FinalStage previewUrls(Optional<Map<String, Optional<String>>> previewUrls);

        _FinalStage previewUrls(Map<String, Optional<String>> previewUrls);

        _FinalStage fieldRules(Optional<List<FieldRuleDto>> fieldRules);

        _FinalStage fieldRules(List<FieldRuleDto> fieldRules);

        _FinalStage category(Optional<String> category);

        _FinalStage category(String category);

        _FinalStage isPublished(Optional<Boolean> isPublished);

        _FinalStage isPublished(Boolean isPublished);

        _FinalStage type(Optional<SchemaType> type);

        _FinalStage type(SchemaType type);

        _FinalStage isSingleton(Optional<Boolean> isSingleton);

        _FinalStage isSingleton(Boolean isSingleton);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, _FinalStage {
        private String name;

        private Optional<Boolean> isSingleton = Optional.empty();

        private Optional<SchemaType> type = Optional.empty();

        private Optional<Boolean> isPublished = Optional.empty();

        private Optional<String> category = Optional.empty();

        private Optional<List<FieldRuleDto>> fieldRules = Optional.empty();

        private Optional<Map<String, Optional<String>>> previewUrls = Optional.empty();

        private Optional<List<UpsertSchemaFieldDto>> fields = Optional.empty();

        private Optional<List<String>> fieldsInLists = Optional.empty();

        private Optional<List<String>> fieldsInReferences = Optional.empty();

        private Optional<SchemaScriptsDto> scripts = Optional.empty();

        private Optional<SchemaPropertiesDto> properties = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(CreateSchemaDto other) {
            properties(other.getProperties());
            scripts(other.getScripts());
            fieldsInReferences(other.getFieldsInReferences());
            fieldsInLists(other.getFieldsInLists());
            fields(other.getFields());
            previewUrls(other.getPreviewUrls());
            fieldRules(other.getFieldRules());
            category(other.getCategory());
            isPublished(other.getIsPublished());
            name(other.getName());
            type(other.getType());
            isSingleton(other.getIsSingleton());
            return this;
        }

        /**
         * <p>The name of the schema. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name")
        public _FinalStage name(String name) {
            this.name = name;
            return this;
        }

        /**
         * <p>Set to true to allow a single content item only.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage isSingleton(Boolean isSingleton) {
            this.isSingleton = Optional.of(isSingleton);
            return this;
        }

        @Override
        @JsonSetter(value = "isSingleton", nulls = Nulls.SKIP)
        public _FinalStage isSingleton(Optional<Boolean> isSingleton) {
            this.isSingleton = isSingleton;
            return this;
        }

        /**
         * <p>The type of the schema.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage type(SchemaType type) {
            this.type = Optional.of(type);
            return this;
        }

        @Override
        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public _FinalStage type(Optional<SchemaType> type) {
            this.type = type;
            return this;
        }

        /**
         * <p>Set it to true to autopublish the schema.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage isPublished(Boolean isPublished) {
            this.isPublished = Optional.of(isPublished);
            return this;
        }

        @Override
        @JsonSetter(value = "isPublished", nulls = Nulls.SKIP)
        public _FinalStage isPublished(Optional<Boolean> isPublished) {
            this.isPublished = isPublished;
            return this;
        }

        /**
         * <p>The category.</p>
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
         * <p>The optional field Rules.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage fieldRules(List<FieldRuleDto> fieldRules) {
            this.fieldRules = Optional.of(fieldRules);
            return this;
        }

        @Override
        @JsonSetter(value = "fieldRules", nulls = Nulls.SKIP)
        public _FinalStage fieldRules(Optional<List<FieldRuleDto>> fieldRules) {
            this.fieldRules = fieldRules;
            return this;
        }

        /**
         * <p>The optional preview urls.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage previewUrls(Map<String, Optional<String>> previewUrls) {
            this.previewUrls = Optional.of(previewUrls);
            return this;
        }

        @Override
        @JsonSetter(value = "previewUrls", nulls = Nulls.SKIP)
        public _FinalStage previewUrls(Optional<Map<String, Optional<String>>> previewUrls) {
            this.previewUrls = previewUrls;
            return this;
        }

        /**
         * <p>Optional fields.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage fields(List<UpsertSchemaFieldDto> fields) {
            this.fields = Optional.of(fields);
            return this;
        }

        @Override
        @JsonSetter(value = "fields", nulls = Nulls.SKIP)
        public _FinalStage fields(Optional<List<UpsertSchemaFieldDto>> fields) {
            this.fields = fields;
            return this;
        }

        /**
         * <p>The names of the fields that should be shown in lists, including meta fields.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage fieldsInLists(List<String> fieldsInLists) {
            this.fieldsInLists = Optional.of(fieldsInLists);
            return this;
        }

        @Override
        @JsonSetter(value = "fieldsInLists", nulls = Nulls.SKIP)
        public _FinalStage fieldsInLists(Optional<List<String>> fieldsInLists) {
            this.fieldsInLists = fieldsInLists;
            return this;
        }

        /**
         * <p>The names of the fields that should be used in references.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage fieldsInReferences(List<String> fieldsInReferences) {
            this.fieldsInReferences = Optional.of(fieldsInReferences);
            return this;
        }

        @Override
        @JsonSetter(value = "fieldsInReferences", nulls = Nulls.SKIP)
        public _FinalStage fieldsInReferences(Optional<List<String>> fieldsInReferences) {
            this.fieldsInReferences = fieldsInReferences;
            return this;
        }

        /**
         * <p>The optional scripts.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage scripts(SchemaScriptsDto scripts) {
            this.scripts = Optional.of(scripts);
            return this;
        }

        @Override
        @JsonSetter(value = "scripts", nulls = Nulls.SKIP)
        public _FinalStage scripts(Optional<SchemaScriptsDto> scripts) {
            this.scripts = scripts;
            return this;
        }

        /**
         * <p>The optional properties.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage properties(SchemaPropertiesDto properties) {
            this.properties = Optional.of(properties);
            return this;
        }

        @Override
        @JsonSetter(value = "properties", nulls = Nulls.SKIP)
        public _FinalStage properties(Optional<SchemaPropertiesDto> properties) {
            this.properties = properties;
            return this;
        }

        @Override
        public CreateSchemaDto build() {
            return new CreateSchemaDto(
                    properties,
                    scripts,
                    fieldsInReferences,
                    fieldsInLists,
                    fields,
                    previewUrls,
                    fieldRules,
                    category,
                    isPublished,
                    name,
                    type,
                    isSingleton);
        }
    }
}
