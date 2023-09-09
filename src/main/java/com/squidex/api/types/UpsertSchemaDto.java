package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UpsertSchemaDto.Builder.class)
public final class UpsertSchemaDto implements IUpsertSchemaDto {
    private final Optional<SchemaPropertiesDto> properties;

    private final Optional<SchemaScriptsDto> scripts;

    private final Optional<List<String>> fieldsInReferences;

    private final Optional<List<String>> fieldsInLists;

    private final Optional<List<UpsertSchemaFieldDto>> fields;

    private final Optional<Map<String, Optional<String>>> previewUrls;

    private final Optional<List<FieldRuleDto>> fieldRules;

    private final Optional<String> category;

    private final Optional<Boolean> isPublished;

    private UpsertSchemaDto(
            Optional<SchemaPropertiesDto> properties,
            Optional<SchemaScriptsDto> scripts,
            Optional<List<String>> fieldsInReferences,
            Optional<List<String>> fieldsInLists,
            Optional<List<UpsertSchemaFieldDto>> fields,
            Optional<Map<String, Optional<String>>> previewUrls,
            Optional<List<FieldRuleDto>> fieldRules,
            Optional<String> category,
            Optional<Boolean> isPublished) {
        this.properties = properties;
        this.scripts = scripts;
        this.fieldsInReferences = fieldsInReferences;
        this.fieldsInLists = fieldsInLists;
        this.fields = fields;
        this.previewUrls = previewUrls;
        this.fieldRules = fieldRules;
        this.category = category;
        this.isPublished = isPublished;
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

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpsertSchemaDto && equalTo((UpsertSchemaDto) other);
    }

    private boolean equalTo(UpsertSchemaDto other) {
        return properties.equals(other.properties)
                && scripts.equals(other.scripts)
                && fieldsInReferences.equals(other.fieldsInReferences)
                && fieldsInLists.equals(other.fieldsInLists)
                && fields.equals(other.fields)
                && previewUrls.equals(other.previewUrls)
                && fieldRules.equals(other.fieldRules)
                && category.equals(other.category)
                && isPublished.equals(other.isPublished);
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
                this.isPublished);
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
        private Optional<SchemaPropertiesDto> properties = Optional.empty();

        private Optional<SchemaScriptsDto> scripts = Optional.empty();

        private Optional<List<String>> fieldsInReferences = Optional.empty();

        private Optional<List<String>> fieldsInLists = Optional.empty();

        private Optional<List<UpsertSchemaFieldDto>> fields = Optional.empty();

        private Optional<Map<String, Optional<String>>> previewUrls = Optional.empty();

        private Optional<List<FieldRuleDto>> fieldRules = Optional.empty();

        private Optional<String> category = Optional.empty();

        private Optional<Boolean> isPublished = Optional.empty();

        private Builder() {}

        public Builder from(UpsertSchemaDto other) {
            properties(other.getProperties());
            scripts(other.getScripts());
            fieldsInReferences(other.getFieldsInReferences());
            fieldsInLists(other.getFieldsInLists());
            fields(other.getFields());
            previewUrls(other.getPreviewUrls());
            fieldRules(other.getFieldRules());
            category(other.getCategory());
            isPublished(other.getIsPublished());
            return this;
        }

        @JsonSetter(value = "properties", nulls = Nulls.SKIP)
        public Builder properties(Optional<SchemaPropertiesDto> properties) {
            this.properties = properties;
            return this;
        }

        public Builder properties(SchemaPropertiesDto properties) {
            this.properties = Optional.of(properties);
            return this;
        }

        @JsonSetter(value = "scripts", nulls = Nulls.SKIP)
        public Builder scripts(Optional<SchemaScriptsDto> scripts) {
            this.scripts = scripts;
            return this;
        }

        public Builder scripts(SchemaScriptsDto scripts) {
            this.scripts = Optional.of(scripts);
            return this;
        }

        @JsonSetter(value = "fieldsInReferences", nulls = Nulls.SKIP)
        public Builder fieldsInReferences(Optional<List<String>> fieldsInReferences) {
            this.fieldsInReferences = fieldsInReferences;
            return this;
        }

        public Builder fieldsInReferences(List<String> fieldsInReferences) {
            this.fieldsInReferences = Optional.of(fieldsInReferences);
            return this;
        }

        @JsonSetter(value = "fieldsInLists", nulls = Nulls.SKIP)
        public Builder fieldsInLists(Optional<List<String>> fieldsInLists) {
            this.fieldsInLists = fieldsInLists;
            return this;
        }

        public Builder fieldsInLists(List<String> fieldsInLists) {
            this.fieldsInLists = Optional.of(fieldsInLists);
            return this;
        }

        @JsonSetter(value = "fields", nulls = Nulls.SKIP)
        public Builder fields(Optional<List<UpsertSchemaFieldDto>> fields) {
            this.fields = fields;
            return this;
        }

        public Builder fields(List<UpsertSchemaFieldDto> fields) {
            this.fields = Optional.of(fields);
            return this;
        }

        @JsonSetter(value = "previewUrls", nulls = Nulls.SKIP)
        public Builder previewUrls(Optional<Map<String, Optional<String>>> previewUrls) {
            this.previewUrls = previewUrls;
            return this;
        }

        public Builder previewUrls(Map<String, Optional<String>> previewUrls) {
            this.previewUrls = Optional.of(previewUrls);
            return this;
        }

        @JsonSetter(value = "fieldRules", nulls = Nulls.SKIP)
        public Builder fieldRules(Optional<List<FieldRuleDto>> fieldRules) {
            this.fieldRules = fieldRules;
            return this;
        }

        public Builder fieldRules(List<FieldRuleDto> fieldRules) {
            this.fieldRules = Optional.of(fieldRules);
            return this;
        }

        @JsonSetter(value = "category", nulls = Nulls.SKIP)
        public Builder category(Optional<String> category) {
            this.category = category;
            return this;
        }

        public Builder category(String category) {
            this.category = Optional.of(category);
            return this;
        }

        @JsonSetter(value = "isPublished", nulls = Nulls.SKIP)
        public Builder isPublished(Optional<Boolean> isPublished) {
            this.isPublished = isPublished;
            return this;
        }

        public Builder isPublished(Boolean isPublished) {
            this.isPublished = Optional.of(isPublished);
            return this;
        }

        public UpsertSchemaDto build() {
            return new UpsertSchemaDto(
                    properties,
                    scripts,
                    fieldsInReferences,
                    fieldsInLists,
                    fields,
                    previewUrls,
                    fieldRules,
                    category,
                    isPublished);
        }
    }
}
