package com.squidex.api.resources.schemas.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.types.FieldRuleDto;
import com.squidex.api.types.IUpsertSchemaDto;
import com.squidex.api.types.SchemaPropertiesDto;
import com.squidex.api.types.SchemaScriptsDto;
import com.squidex.api.types.UpsertSchemaFieldDto;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SynchronizeSchemaDto.Builder.class)
public final class SynchronizeSchemaDto implements IUpsertSchemaDto {
    private final Optional<SchemaPropertiesDto> properties;

    private final Optional<SchemaScriptsDto> scripts;

    private final Optional<List<String>> fieldsInReferences;

    private final Optional<List<String>> fieldsInLists;

    private final Optional<List<UpsertSchemaFieldDto>> fields;

    private final Optional<Map<String, Optional<String>>> previewUrls;

    private final Optional<List<FieldRuleDto>> fieldRules;

    private final Optional<String> category;

    private final Optional<Boolean> isPublished;

    private final Optional<Boolean> noFieldDeletion;

    private final Optional<Boolean> noFieldRecreation;

    private SynchronizeSchemaDto(
            Optional<SchemaPropertiesDto> properties,
            Optional<SchemaScriptsDto> scripts,
            Optional<List<String>> fieldsInReferences,
            Optional<List<String>> fieldsInLists,
            Optional<List<UpsertSchemaFieldDto>> fields,
            Optional<Map<String, Optional<String>>> previewUrls,
            Optional<List<FieldRuleDto>> fieldRules,
            Optional<String> category,
            Optional<Boolean> isPublished,
            Optional<Boolean> noFieldDeletion,
            Optional<Boolean> noFieldRecreation) {
        this.properties = properties;
        this.scripts = scripts;
        this.fieldsInReferences = fieldsInReferences;
        this.fieldsInLists = fieldsInLists;
        this.fields = fields;
        this.previewUrls = previewUrls;
        this.fieldRules = fieldRules;
        this.category = category;
        this.isPublished = isPublished;
        this.noFieldDeletion = noFieldDeletion;
        this.noFieldRecreation = noFieldRecreation;
    }

    @JsonProperty("properties")
    @Override
    public Optional<SchemaPropertiesDto> getProperties() {
        return properties;
    }

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
     * @return True, when fields should not be deleted.
     */
    @JsonProperty("noFieldDeletion")
    public Optional<Boolean> getNoFieldDeletion() {
        return noFieldDeletion;
    }

    /**
     * @return True, when fields with different types should not be recreated.
     */
    @JsonProperty("noFieldRecreation")
    public Optional<Boolean> getNoFieldRecreation() {
        return noFieldRecreation;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SynchronizeSchemaDto && equalTo((SynchronizeSchemaDto) other);
    }

    private boolean equalTo(SynchronizeSchemaDto other) {
        return properties.equals(other.properties)
                && scripts.equals(other.scripts)
                && fieldsInReferences.equals(other.fieldsInReferences)
                && fieldsInLists.equals(other.fieldsInLists)
                && fields.equals(other.fields)
                && previewUrls.equals(other.previewUrls)
                && fieldRules.equals(other.fieldRules)
                && category.equals(other.category)
                && isPublished.equals(other.isPublished)
                && noFieldDeletion.equals(other.noFieldDeletion)
                && noFieldRecreation.equals(other.noFieldRecreation);
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
                this.noFieldDeletion,
                this.noFieldRecreation);
    }

    @Override
    public String toString() {
        return "SynchronizeSchemaDto{" + "properties: " + properties + ", scripts: " + scripts
                + ", fieldsInReferences: " + fieldsInReferences + ", fieldsInLists: " + fieldsInLists + ", fields: "
                + fields + ", previewUrls: " + previewUrls + ", fieldRules: " + fieldRules + ", category: " + category
                + ", isPublished: " + isPublished + ", noFieldDeletion: " + noFieldDeletion + ", noFieldRecreation: "
                + noFieldRecreation + "}";
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

        private Optional<Boolean> noFieldDeletion = Optional.empty();

        private Optional<Boolean> noFieldRecreation = Optional.empty();

        private Builder() {}

        public Builder from(SynchronizeSchemaDto other) {
            properties(other.getProperties());
            scripts(other.getScripts());
            fieldsInReferences(other.getFieldsInReferences());
            fieldsInLists(other.getFieldsInLists());
            fields(other.getFields());
            previewUrls(other.getPreviewUrls());
            fieldRules(other.getFieldRules());
            category(other.getCategory());
            isPublished(other.getIsPublished());
            noFieldDeletion(other.getNoFieldDeletion());
            noFieldRecreation(other.getNoFieldRecreation());
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

        @JsonSetter(value = "noFieldDeletion", nulls = Nulls.SKIP)
        public Builder noFieldDeletion(Optional<Boolean> noFieldDeletion) {
            this.noFieldDeletion = noFieldDeletion;
            return this;
        }

        public Builder noFieldDeletion(Boolean noFieldDeletion) {
            this.noFieldDeletion = Optional.of(noFieldDeletion);
            return this;
        }

        @JsonSetter(value = "noFieldRecreation", nulls = Nulls.SKIP)
        public Builder noFieldRecreation(Optional<Boolean> noFieldRecreation) {
            this.noFieldRecreation = noFieldRecreation;
            return this;
        }

        public Builder noFieldRecreation(Boolean noFieldRecreation) {
            this.noFieldRecreation = Optional.of(noFieldRecreation);
            return this;
        }

        public SynchronizeSchemaDto build() {
            return new SynchronizeSchemaDto(
                    properties,
                    scripts,
                    fieldsInReferences,
                    fieldsInLists,
                    fields,
                    previewUrls,
                    fieldRules,
                    category,
                    isPublished,
                    noFieldDeletion,
                    noFieldRecreation);
        }
    }
}
