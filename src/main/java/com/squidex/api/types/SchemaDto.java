/*
 * Squidex API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1.0.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.squidex.api.types;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.squidex.api.types.FieldDto;
import com.squidex.api.types.FieldRuleDto;
import com.squidex.api.types.ResourceLink;
import com.squidex.api.types.SchemaPropertiesDto;
import com.squidex.api.types.SchemaScriptsDto;
import com.squidex.api.types.SchemaType;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openapitools.jackson.nullable.JsonNullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.squidex.api.core.JSON;

/**
 * SchemaDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.9.0-SNAPSHOT")
public class SchemaDto {
  public static final String SERIALIZED_NAME_LINKS = "_links";
  @SerializedName(SERIALIZED_NAME_LINKS)
  private Map<String, ResourceLink> links = new HashMap<>();
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;
  public static final String SERIALIZED_NAME_CREATED_BY = "createdBy";
  @SerializedName(SERIALIZED_NAME_CREATED_BY)
  private String createdBy;
  public static final String SERIALIZED_NAME_LAST_MODIFIED_BY = "lastModifiedBy";
  @SerializedName(SERIALIZED_NAME_LAST_MODIFIED_BY)
  private String lastModifiedBy;
  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;
  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private SchemaType type;
  public static final String SERIALIZED_NAME_CATEGORY = "category";
  @SerializedName(SERIALIZED_NAME_CATEGORY)
  private String category;
  public static final String SERIALIZED_NAME_PROPERTIES = "properties";
  @SerializedName(SERIALIZED_NAME_PROPERTIES)
  private SchemaPropertiesDto properties;
  public static final String SERIALIZED_NAME_IS_SINGLETON = "isSingleton";
  @Deprecated
  @SerializedName(SERIALIZED_NAME_IS_SINGLETON)
  private Boolean isSingleton;
  public static final String SERIALIZED_NAME_IS_PUBLISHED = "isPublished";
  @SerializedName(SERIALIZED_NAME_IS_PUBLISHED)
  private Boolean isPublished;
  public static final String SERIALIZED_NAME_CREATED = "created";
  @SerializedName(SERIALIZED_NAME_CREATED)
  private OffsetDateTime created;
  public static final String SERIALIZED_NAME_LAST_MODIFIED = "lastModified";
  @SerializedName(SERIALIZED_NAME_LAST_MODIFIED)
  private OffsetDateTime lastModified;
  public static final String SERIALIZED_NAME_VERSION = "version";
  @SerializedName(SERIALIZED_NAME_VERSION)
  private Long version;
  public static final String SERIALIZED_NAME_SCRIPTS = "scripts";
  @SerializedName(SERIALIZED_NAME_SCRIPTS)
  private SchemaScriptsDto scripts;
  public static final String SERIALIZED_NAME_PREVIEW_URLS = "previewUrls";
  @SerializedName(SERIALIZED_NAME_PREVIEW_URLS)
  private Map<String, String> previewUrls = new HashMap<>();
  public static final String SERIALIZED_NAME_FIELDS_IN_LISTS = "fieldsInLists";
  @SerializedName(SERIALIZED_NAME_FIELDS_IN_LISTS)
  private List<String> fieldsInLists = new ArrayList<>();
  public static final String SERIALIZED_NAME_FIELDS_IN_REFERENCES = "fieldsInReferences";
  @SerializedName(SERIALIZED_NAME_FIELDS_IN_REFERENCES)
  private List<String> fieldsInReferences = new ArrayList<>();
  public static final String SERIALIZED_NAME_FIELD_RULES = "fieldRules";
  @SerializedName(SERIALIZED_NAME_FIELD_RULES)
  private List<FieldRuleDto> fieldRules = new ArrayList<>();
  public static final String SERIALIZED_NAME_FIELDS = "fields";
  @SerializedName(SERIALIZED_NAME_FIELDS)
  private List<FieldDto> fields = new ArrayList<>();
  public SchemaDto() {
  }
  public SchemaDto links(Map<String, ResourceLink> links) {
    this.links = links;
    return this;
  }

  public SchemaDto putLinksItem(String key, ResourceLink linksItem) {
    if (this.links == null) {
      this.links = new HashMap<>();
    }
    this.links.put(key, linksItem);
    return this;
  }

  /**
   * The links.
   * @return links
   */
  @javax.annotation.Nonnull
  public Map<String, ResourceLink> getLinks() {
    return links;
  }

  public void setLinks(Map<String, ResourceLink> links) {
    this.links = links;
  }
  public SchemaDto id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The ID of the schema.
   * @return id
   */
  @javax.annotation.Nonnull
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
  public SchemaDto createdBy(String createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  /**
   * The user that has created the schema.
   * @return createdBy
   */
  @javax.annotation.Nonnull
  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }
  public SchemaDto lastModifiedBy(String lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
    return this;
  }

  /**
   * The user that has updated the schema.
   * @return lastModifiedBy
   */
  @javax.annotation.Nonnull
  public String getLastModifiedBy() {
    return lastModifiedBy;
  }

  public void setLastModifiedBy(String lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
  }
  public SchemaDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the schema. Unique within the app.
   * @return name
   */
  @javax.annotation.Nonnull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  public SchemaDto type(SchemaType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   */
  @javax.annotation.Nonnull
  public SchemaType getType() {
    return type;
  }

  public void setType(SchemaType type) {
    this.type = type;
  }
  public SchemaDto category(String category) {
    this.category = category;
    return this;
  }

  /**
   * The name of the category.
   * @return category
   */
  @javax.annotation.Nullable
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
  public SchemaDto properties(SchemaPropertiesDto properties) {
    this.properties = properties;
    return this;
  }

  /**
   * Get properties
   * @return properties
   */
  @javax.annotation.Nonnull
  public SchemaPropertiesDto getProperties() {
    return properties;
  }

  public void setProperties(SchemaPropertiesDto properties) {
    this.properties = properties;
  }
  @Deprecated
  public SchemaDto isSingleton(Boolean isSingleton) {
    this.isSingleton = isSingleton;
    return this;
  }

  /**
   * Indicates if the schema is a singleton.
   * @return isSingleton
   * @deprecated
   */
  @Deprecated
  @javax.annotation.Nonnull
  public Boolean getIsSingleton() {
    return isSingleton;
  }

  @Deprecated
  public void setIsSingleton(Boolean isSingleton) {
    this.isSingleton = isSingleton;
  }
  public SchemaDto isPublished(Boolean isPublished) {
    this.isPublished = isPublished;
    return this;
  }

  /**
   * Indicates if the schema is published.
   * @return isPublished
   */
  @javax.annotation.Nonnull
  public Boolean getIsPublished() {
    return isPublished;
  }

  public void setIsPublished(Boolean isPublished) {
    this.isPublished = isPublished;
  }
  public SchemaDto created(OffsetDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * The date and time when the schema has been created.
   * @return created
   */
  @javax.annotation.Nonnull
  public OffsetDateTime getCreated() {
    return created;
  }

  public void setCreated(OffsetDateTime created) {
    this.created = created;
  }
  public SchemaDto lastModified(OffsetDateTime lastModified) {
    this.lastModified = lastModified;
    return this;
  }

  /**
   * The date and time when the schema has been modified last.
   * @return lastModified
   */
  @javax.annotation.Nonnull
  public OffsetDateTime getLastModified() {
    return lastModified;
  }

  public void setLastModified(OffsetDateTime lastModified) {
    this.lastModified = lastModified;
  }
  public SchemaDto version(Long version) {
    this.version = version;
    return this;
  }

  /**
   * The version of the schema.
   * @return version
   */
  @javax.annotation.Nonnull
  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
  public SchemaDto scripts(SchemaScriptsDto scripts) {
    this.scripts = scripts;
    return this;
  }

  /**
   * Get scripts
   * @return scripts
   */
  @javax.annotation.Nonnull
  public SchemaScriptsDto getScripts() {
    return scripts;
  }

  public void setScripts(SchemaScriptsDto scripts) {
    this.scripts = scripts;
  }
  public SchemaDto previewUrls(Map<String, String> previewUrls) {
    this.previewUrls = previewUrls;
    return this;
  }

  public SchemaDto putPreviewUrlsItem(String key, String previewUrlsItem) {
    if (this.previewUrls == null) {
      this.previewUrls = new HashMap<>();
    }
    this.previewUrls.put(key, previewUrlsItem);
    return this;
  }

  /**
   * The preview Urls.
   * @return previewUrls
   */
  @javax.annotation.Nonnull
  public Map<String, String> getPreviewUrls() {
    return previewUrls;
  }

  public void setPreviewUrls(Map<String, String> previewUrls) {
    this.previewUrls = previewUrls;
  }
  public SchemaDto fieldsInLists(List<String> fieldsInLists) {
    this.fieldsInLists = fieldsInLists;
    return this;
  }

  public SchemaDto addFieldsInListsItem(String fieldsInListsItem) {
    if (this.fieldsInLists == null) {
      this.fieldsInLists = new ArrayList<>();
    }
    this.fieldsInLists.add(fieldsInListsItem);
    return this;
  }

  /**
   * The name of fields that are used in content lists.
   * @return fieldsInLists
   */
  @javax.annotation.Nonnull
  public List<String> getFieldsInLists() {
    return fieldsInLists;
  }

  public void setFieldsInLists(List<String> fieldsInLists) {
    this.fieldsInLists = fieldsInLists;
  }
  public SchemaDto fieldsInReferences(List<String> fieldsInReferences) {
    this.fieldsInReferences = fieldsInReferences;
    return this;
  }

  public SchemaDto addFieldsInReferencesItem(String fieldsInReferencesItem) {
    if (this.fieldsInReferences == null) {
      this.fieldsInReferences = new ArrayList<>();
    }
    this.fieldsInReferences.add(fieldsInReferencesItem);
    return this;
  }

  /**
   * The name of fields that are used in content references.
   * @return fieldsInReferences
   */
  @javax.annotation.Nonnull
  public List<String> getFieldsInReferences() {
    return fieldsInReferences;
  }

  public void setFieldsInReferences(List<String> fieldsInReferences) {
    this.fieldsInReferences = fieldsInReferences;
  }
  public SchemaDto fieldRules(List<FieldRuleDto> fieldRules) {
    this.fieldRules = fieldRules;
    return this;
  }

  public SchemaDto addFieldRulesItem(FieldRuleDto fieldRulesItem) {
    if (this.fieldRules == null) {
      this.fieldRules = new ArrayList<>();
    }
    this.fieldRules.add(fieldRulesItem);
    return this;
  }

  /**
   * The field rules.
   * @return fieldRules
   */
  @javax.annotation.Nonnull
  public List<FieldRuleDto> getFieldRules() {
    return fieldRules;
  }

  public void setFieldRules(List<FieldRuleDto> fieldRules) {
    this.fieldRules = fieldRules;
  }
  public SchemaDto fields(List<FieldDto> fields) {
    this.fields = fields;
    return this;
  }

  public SchemaDto addFieldsItem(FieldDto fieldsItem) {
    if (this.fields == null) {
      this.fields = new ArrayList<>();
    }
    this.fields.add(fieldsItem);
    return this;
  }

  /**
   * The list of fields.
   * @return fields
   */
  @javax.annotation.Nonnull
  public List<FieldDto> getFields() {
    return fields;
  }

  public void setFields(List<FieldDto> fields) {
    this.fields = fields;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SchemaDto schemaDto = (SchemaDto) o;
    return Objects.equals(this.links, schemaDto.links) &&
        Objects.equals(this.id, schemaDto.id) &&
        Objects.equals(this.createdBy, schemaDto.createdBy) &&
        Objects.equals(this.lastModifiedBy, schemaDto.lastModifiedBy) &&
        Objects.equals(this.name, schemaDto.name) &&
        Objects.equals(this.type, schemaDto.type) &&
        Objects.equals(this.category, schemaDto.category) &&
        Objects.equals(this.properties, schemaDto.properties) &&
        Objects.equals(this.isSingleton, schemaDto.isSingleton) &&
        Objects.equals(this.isPublished, schemaDto.isPublished) &&
        Objects.equals(this.created, schemaDto.created) &&
        Objects.equals(this.lastModified, schemaDto.lastModified) &&
        Objects.equals(this.version, schemaDto.version) &&
        Objects.equals(this.scripts, schemaDto.scripts) &&
        Objects.equals(this.previewUrls, schemaDto.previewUrls) &&
        Objects.equals(this.fieldsInLists, schemaDto.fieldsInLists) &&
        Objects.equals(this.fieldsInReferences, schemaDto.fieldsInReferences) &&
        Objects.equals(this.fieldRules, schemaDto.fieldRules) &&
        Objects.equals(this.fields, schemaDto.fields);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(links, id, createdBy, lastModifiedBy, name, type, category, properties, isSingleton, isPublished, created, lastModified, version, scripts, previewUrls, fieldsInLists, fieldsInReferences, fieldRules, fields);
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SchemaDto {\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    lastModifiedBy: ").append(toIndentedString(lastModifiedBy)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
    sb.append("    isSingleton: ").append(toIndentedString(isSingleton)).append("\n");
    sb.append("    isPublished: ").append(toIndentedString(isPublished)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    lastModified: ").append(toIndentedString(lastModified)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    scripts: ").append(toIndentedString(scripts)).append("\n");
    sb.append("    previewUrls: ").append(toIndentedString(previewUrls)).append("\n");
    sb.append("    fieldsInLists: ").append(toIndentedString(fieldsInLists)).append("\n");
    sb.append("    fieldsInReferences: ").append(toIndentedString(fieldsInReferences)).append("\n");
    sb.append("    fieldRules: ").append(toIndentedString(fieldRules)).append("\n");
    sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("_links");
    openapiFields.add("id");
    openapiFields.add("createdBy");
    openapiFields.add("lastModifiedBy");
    openapiFields.add("name");
    openapiFields.add("type");
    openapiFields.add("category");
    openapiFields.add("properties");
    openapiFields.add("isSingleton");
    openapiFields.add("isPublished");
    openapiFields.add("created");
    openapiFields.add("lastModified");
    openapiFields.add("version");
    openapiFields.add("scripts");
    openapiFields.add("previewUrls");
    openapiFields.add("fieldsInLists");
    openapiFields.add("fieldsInReferences");
    openapiFields.add("fieldRules");
    openapiFields.add("fields");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("_links");
    openapiRequiredFields.add("id");
    openapiRequiredFields.add("createdBy");
    openapiRequiredFields.add("lastModifiedBy");
    openapiRequiredFields.add("name");
    openapiRequiredFields.add("type");
    openapiRequiredFields.add("properties");
    openapiRequiredFields.add("isSingleton");
    openapiRequiredFields.add("isPublished");
    openapiRequiredFields.add("created");
    openapiRequiredFields.add("lastModified");
    openapiRequiredFields.add("version");
    openapiRequiredFields.add("scripts");
    openapiRequiredFields.add("previewUrls");
    openapiRequiredFields.add("fieldsInLists");
    openapiRequiredFields.add("fieldsInReferences");
    openapiRequiredFields.add("fieldRules");
    openapiRequiredFields.add("fields");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to SchemaDto
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!SchemaDto.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in SchemaDto is not found in the empty JSON string", SchemaDto.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!SchemaDto.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `SchemaDto` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : SchemaDto.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if (!jsonObj.get("createdBy").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `createdBy` to be a primitive type in the JSON string but got `%s`", jsonObj.get("createdBy").toString()));
      }
      if (!jsonObj.get("lastModifiedBy").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `lastModifiedBy` to be a primitive type in the JSON string but got `%s`", jsonObj.get("lastModifiedBy").toString()));
      }
      if (!jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      // validate the required field `type`
      SchemaType.validateJsonElement(jsonObj.get("type"));
      if ((jsonObj.get("category") != null && !jsonObj.get("category").isJsonNull()) && !jsonObj.get("category").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `category` to be a primitive type in the JSON string but got `%s`", jsonObj.get("category").toString()));
      }
      // validate the required field `properties`
      SchemaPropertiesDto.validateJsonElement(jsonObj.get("properties"));
      // validate the required field `scripts`
      SchemaScriptsDto.validateJsonElement(jsonObj.get("scripts"));
      // ensure the required json array is present
      if (jsonObj.get("fieldsInLists") == null) {
        throw new IllegalArgumentException("Expected the field `linkedContent` to be an array in the JSON string but got `null`");
      } else if (!jsonObj.get("fieldsInLists").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `fieldsInLists` to be an array in the JSON string but got `%s`", jsonObj.get("fieldsInLists").toString()));
      }
      // ensure the required json array is present
      if (jsonObj.get("fieldsInReferences") == null) {
        throw new IllegalArgumentException("Expected the field `linkedContent` to be an array in the JSON string but got `null`");
      } else if (!jsonObj.get("fieldsInReferences").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `fieldsInReferences` to be an array in the JSON string but got `%s`", jsonObj.get("fieldsInReferences").toString()));
      }
      // ensure the json data is an array
      if (!jsonObj.get("fieldRules").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `fieldRules` to be an array in the JSON string but got `%s`", jsonObj.get("fieldRules").toString()));
      }

      JsonArray jsonArrayfieldRules = jsonObj.getAsJsonArray("fieldRules");
      // validate the required field `fieldRules` (array)
      for (int i = 0; i < jsonArrayfieldRules.size(); i++) {
        FieldRuleDto.validateJsonElement(jsonArrayfieldRules.get(i));
      };
      // ensure the json data is an array
      if (!jsonObj.get("fields").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `fields` to be an array in the JSON string but got `%s`", jsonObj.get("fields").toString()));
      }

      JsonArray jsonArrayfields = jsonObj.getAsJsonArray("fields");
      // validate the required field `fields` (array)
      for (int i = 0; i < jsonArrayfields.size(); i++) {
        FieldDto.validateJsonElement(jsonArrayfields.get(i));
      };
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!SchemaDto.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'SchemaDto' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<SchemaDto> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(SchemaDto.class));

       return (TypeAdapter<T>) new TypeAdapter<SchemaDto>() {
           @Override
           public void write(JsonWriter out, SchemaDto value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public SchemaDto read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of SchemaDto given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of SchemaDto
   * @throws IOException if the JSON string is invalid with respect to SchemaDto
   */
  public static SchemaDto fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, SchemaDto.class);
  }

  /**
   * Convert an instance of SchemaDto to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
