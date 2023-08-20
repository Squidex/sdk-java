package com.squidex.api.types;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IUpsertSchemaDto {
    Optional<SchemaPropertiesDto> getProperties();

    Optional<SchemaScriptsDto> getScripts();

    Optional<List<String>> getFieldsInReferences();

    Optional<List<String>> getFieldsInLists();

    Optional<List<UpsertSchemaFieldDto>> getFields();

    Optional<Map<String, Optional<String>>> getPreviewUrls();

    Optional<List<FieldRuleDto>> getFieldRules();

    Optional<String> getCategory();

    Optional<Boolean> getIsPublished();
}
