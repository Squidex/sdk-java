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
import com.squidex.api.types.FieldRuleDto;
import com.squidex.api.types.SchemaPropertiesDto;
import com.squidex.api.types.SchemaScriptsDto;
import com.squidex.api.types.UpsertSchemaFieldDto;
import java.io.IOException;
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
 * SynchronizeSchemaDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.9.0-SNAPSHOT")
public class SynchronizeSchemaDto {
  public static final String SERIALIZED_NAME_PROPERTIES = "properties";
  @SerializedName(SERIALIZED_NAME_PROPERTIES)
  private SchemaPropertiesDto properties;
  public static final String SERIALIZED_NAME_SCRIPTS = "scripts";
  @SerializedName(SERIALIZED_NAME_SCRIPTS)
  private SchemaScriptsDto scripts;
  public static final String SERIALIZED_NAME_FIELDS_IN_REFERENCES = "fieldsInReferences";
  @SerializedName(SERIALIZED_NAME_FIELDS_IN_REFERENCES)
  private List<String> fieldsInReferences;
  public static final String SERIALIZED_NAME_FIELDS_IN_LISTS = "fieldsInLists";
  @SerializedName(SERIALIZED_NAME_FIELDS_IN_LISTS)
  private List<String> fieldsInLists;
  public static final String SERIALIZED_NAME_FIELDS = "fields";
  @SerializedName(SERIALIZED_NAME_FIELDS)
  private List<UpsertSchemaFieldDto> fields;
  public static final String SERIALIZED_NAME_PREVIEW_URLS = "previewUrls";
  @SerializedName(SERIALIZED_NAME_PREVIEW_URLS)
  private Map<String, String> previewUrls;
  public static final String SERIALIZED_NAME_FIELD_RULES = "fieldRules";
  @SerializedName(SERIALIZED_NAME_FIELD_RULES)
  private List<FieldRuleDto> fieldRules;
  public static final String SERIALIZED_NAME_CATEGORY = "category";
  @SerializedName(SERIALIZED_NAME_CATEGORY)
  private String category;
  public static final String SERIALIZED_NAME_IS_PUBLISHED = "isPublished";
  @SerializedName(SERIALIZED_NAME_IS_PUBLISHED)
  private Boolean isPublished;
  public static final String SERIALIZED_NAME_NO_FIELD_DELETION = "noFieldDeletion";
  @SerializedName(SERIALIZED_NAME_NO_FIELD_DELETION)
  private Boolean noFieldDeletion;
  public static final String SERIALIZED_NAME_NO_FIELD_RECREATION = "noFieldRecreation";
  @SerializedName(SERIALIZED_NAME_NO_FIELD_RECREATION)
  private Boolean noFieldRecreation;
  public SynchronizeSchemaDto() {
  }
  public SynchronizeSchemaDto properties(SchemaPropertiesDto properties) {
    this.properties = properties;
    return this;
  }

  /**
   * Get properties
   * @return properties
   */
  @javax.annotation.Nullable
  public SchemaPropertiesDto getProperties() {
    return properties;
  }

  public void setProperties(SchemaPropertiesDto properties) {
    this.properties = properties;
  }
  public SynchronizeSchemaDto scripts(SchemaScriptsDto scripts) {
    this.scripts = scripts;
    return this;
  }

  /**
   * Get scripts
   * @return scripts
   */
  @javax.annotation.Nullable
  public SchemaScriptsDto getScripts() {
    return scripts;
  }

  public void setScripts(SchemaScriptsDto scripts) {
    this.scripts = scripts;
  }
  public SynchronizeSchemaDto fieldsInReferences(List<String> fieldsInReferences) {
    this.fieldsInReferences = fieldsInReferences;
    return this;
  }

  public SynchronizeSchemaDto addFieldsInReferencesItem(String fieldsInReferencesItem) {
    if (this.fieldsInReferences == null) {
      this.fieldsInReferences = new ArrayList<>();
    }
    this.fieldsInReferences.add(fieldsInReferencesItem);
    return this;
  }

  /**
   * The names of the fields that should be used in references.
   * @return fieldsInReferences
   */
  @javax.annotation.Nullable
  public List<String> getFieldsInReferences() {
    return fieldsInReferences;
  }

  public void setFieldsInReferences(List<String> fieldsInReferences) {
    this.fieldsInReferences = fieldsInReferences;
  }
  public SynchronizeSchemaDto fieldsInLists(List<String> fieldsInLists) {
    this.fieldsInLists = fieldsInLists;
    return this;
  }

  public SynchronizeSchemaDto addFieldsInListsItem(String fieldsInListsItem) {
    if (this.fieldsInLists == null) {
      this.fieldsInLists = new ArrayList<>();
    }
    this.fieldsInLists.add(fieldsInListsItem);
    return this;
  }

  /**
   * The names of the fields that should be shown in lists, including meta fields.
   * @return fieldsInLists
   */
  @javax.annotation.Nullable
  public List<String> getFieldsInLists() {
    return fieldsInLists;
  }

  public void setFieldsInLists(List<String> fieldsInLists) {
    this.fieldsInLists = fieldsInLists;
  }
  public SynchronizeSchemaDto fields(List<UpsertSchemaFieldDto> fields) {
    this.fields = fields;
    return this;
  }

  public SynchronizeSchemaDto addFieldsItem(UpsertSchemaFieldDto fieldsItem) {
    if (this.fields == null) {
      this.fields = new ArrayList<>();
    }
    this.fields.add(fieldsItem);
    return this;
  }

  /**
   * Optional fields.
   * @return fields
   */
  @javax.annotation.Nullable
  public List<UpsertSchemaFieldDto> getFields() {
    return fields;
  }

  public void setFields(List<UpsertSchemaFieldDto> fields) {
    this.fields = fields;
  }
  public SynchronizeSchemaDto previewUrls(Map<String, String> previewUrls) {
    this.previewUrls = previewUrls;
    return this;
  }

  public SynchronizeSchemaDto putPreviewUrlsItem(String key, String previewUrlsItem) {
    if (this.previewUrls == null) {
      this.previewUrls = new HashMap<>();
    }
    this.previewUrls.put(key, previewUrlsItem);
    return this;
  }

  /**
   * The optional preview urls.
   * @return previewUrls
   */
  @javax.annotation.Nullable
  public Map<String, String> getPreviewUrls() {
    return previewUrls;
  }

  public void setPreviewUrls(Map<String, String> previewUrls) {
    this.previewUrls = previewUrls;
  }
  public SynchronizeSchemaDto fieldRules(List<FieldRuleDto> fieldRules) {
    this.fieldRules = fieldRules;
    return this;
  }

  public SynchronizeSchemaDto addFieldRulesItem(FieldRuleDto fieldRulesItem) {
    if (this.fieldRules == null) {
      this.fieldRules = new ArrayList<>();
    }
    this.fieldRules.add(fieldRulesItem);
    return this;
  }

  /**
   * The optional field Rules.
   * @return fieldRules
   */
  @javax.annotation.Nullable
  public List<FieldRuleDto> getFieldRules() {
    return fieldRules;
  }

  public void setFieldRules(List<FieldRuleDto> fieldRules) {
    this.fieldRules = fieldRules;
  }
  public SynchronizeSchemaDto category(String category) {
    this.category = category;
    return this;
  }

  /**
   * The category.
   * @return category
   */
  @javax.annotation.Nullable
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
  public SynchronizeSchemaDto isPublished(Boolean isPublished) {
    this.isPublished = isPublished;
    return this;
  }

  /**
   * Set it to true to autopublish the schema.
   * @return isPublished
   */
  @javax.annotation.Nullable
  public Boolean getIsPublished() {
    return isPublished;
  }

  public void setIsPublished(Boolean isPublished) {
    this.isPublished = isPublished;
  }
  public SynchronizeSchemaDto noFieldDeletion(Boolean noFieldDeletion) {
    this.noFieldDeletion = noFieldDeletion;
    return this;
  }

  /**
   * True, when fields should not be deleted.
   * @return noFieldDeletion
   */
  @javax.annotation.Nullable
  public Boolean getNoFieldDeletion() {
    return noFieldDeletion;
  }

  public void setNoFieldDeletion(Boolean noFieldDeletion) {
    this.noFieldDeletion = noFieldDeletion;
  }
  public SynchronizeSchemaDto noFieldRecreation(Boolean noFieldRecreation) {
    this.noFieldRecreation = noFieldRecreation;
    return this;
  }

  /**
   * True, when fields with different types should not be recreated.
   * @return noFieldRecreation
   */
  @javax.annotation.Nullable
  public Boolean getNoFieldRecreation() {
    return noFieldRecreation;
  }

  public void setNoFieldRecreation(Boolean noFieldRecreation) {
    this.noFieldRecreation = noFieldRecreation;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SynchronizeSchemaDto synchronizeSchemaDto = (SynchronizeSchemaDto) o;
    return Objects.equals(this.properties, synchronizeSchemaDto.properties) &&
        Objects.equals(this.scripts, synchronizeSchemaDto.scripts) &&
        Objects.equals(this.fieldsInReferences, synchronizeSchemaDto.fieldsInReferences) &&
        Objects.equals(this.fieldsInLists, synchronizeSchemaDto.fieldsInLists) &&
        Objects.equals(this.fields, synchronizeSchemaDto.fields) &&
        Objects.equals(this.previewUrls, synchronizeSchemaDto.previewUrls) &&
        Objects.equals(this.fieldRules, synchronizeSchemaDto.fieldRules) &&
        Objects.equals(this.category, synchronizeSchemaDto.category) &&
        Objects.equals(this.isPublished, synchronizeSchemaDto.isPublished) &&
        Objects.equals(this.noFieldDeletion, synchronizeSchemaDto.noFieldDeletion) &&
        Objects.equals(this.noFieldRecreation, synchronizeSchemaDto.noFieldRecreation);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(properties, scripts, fieldsInReferences, fieldsInLists, fields, previewUrls, fieldRules, category, isPublished, noFieldDeletion, noFieldRecreation);
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
    sb.append("class SynchronizeSchemaDto {\n");
    sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
    sb.append("    scripts: ").append(toIndentedString(scripts)).append("\n");
    sb.append("    fieldsInReferences: ").append(toIndentedString(fieldsInReferences)).append("\n");
    sb.append("    fieldsInLists: ").append(toIndentedString(fieldsInLists)).append("\n");
    sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
    sb.append("    previewUrls: ").append(toIndentedString(previewUrls)).append("\n");
    sb.append("    fieldRules: ").append(toIndentedString(fieldRules)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    isPublished: ").append(toIndentedString(isPublished)).append("\n");
    sb.append("    noFieldDeletion: ").append(toIndentedString(noFieldDeletion)).append("\n");
    sb.append("    noFieldRecreation: ").append(toIndentedString(noFieldRecreation)).append("\n");
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
    openapiFields.add("properties");
    openapiFields.add("scripts");
    openapiFields.add("fieldsInReferences");
    openapiFields.add("fieldsInLists");
    openapiFields.add("fields");
    openapiFields.add("previewUrls");
    openapiFields.add("fieldRules");
    openapiFields.add("category");
    openapiFields.add("isPublished");
    openapiFields.add("noFieldDeletion");
    openapiFields.add("noFieldRecreation");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to SynchronizeSchemaDto
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!SynchronizeSchemaDto.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in SynchronizeSchemaDto is not found in the empty JSON string", SynchronizeSchemaDto.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!SynchronizeSchemaDto.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `SynchronizeSchemaDto` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the optional field `properties`
      if (jsonObj.get("properties") != null && !jsonObj.get("properties").isJsonNull()) {
        SchemaPropertiesDto.validateJsonElement(jsonObj.get("properties"));
      }
      // validate the optional field `scripts`
      if (jsonObj.get("scripts") != null && !jsonObj.get("scripts").isJsonNull()) {
        SchemaScriptsDto.validateJsonElement(jsonObj.get("scripts"));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("fieldsInReferences") != null && !jsonObj.get("fieldsInReferences").isJsonNull() && !jsonObj.get("fieldsInReferences").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `fieldsInReferences` to be an array in the JSON string but got `%s`", jsonObj.get("fieldsInReferences").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("fieldsInLists") != null && !jsonObj.get("fieldsInLists").isJsonNull() && !jsonObj.get("fieldsInLists").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `fieldsInLists` to be an array in the JSON string but got `%s`", jsonObj.get("fieldsInLists").toString()));
      }
      if (jsonObj.get("fields") != null && !jsonObj.get("fields").isJsonNull()) {
        JsonArray jsonArrayfields = jsonObj.getAsJsonArray("fields");
        if (jsonArrayfields != null) {
          // ensure the json data is an array
          if (!jsonObj.get("fields").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `fields` to be an array in the JSON string but got `%s`", jsonObj.get("fields").toString()));
          }

          // validate the optional field `fields` (array)
          for (int i = 0; i < jsonArrayfields.size(); i++) {
            UpsertSchemaFieldDto.validateJsonElement(jsonArrayfields.get(i));
          };
        }
      }
      if (jsonObj.get("fieldRules") != null && !jsonObj.get("fieldRules").isJsonNull()) {
        JsonArray jsonArrayfieldRules = jsonObj.getAsJsonArray("fieldRules");
        if (jsonArrayfieldRules != null) {
          // ensure the json data is an array
          if (!jsonObj.get("fieldRules").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `fieldRules` to be an array in the JSON string but got `%s`", jsonObj.get("fieldRules").toString()));
          }

          // validate the optional field `fieldRules` (array)
          for (int i = 0; i < jsonArrayfieldRules.size(); i++) {
            FieldRuleDto.validateJsonElement(jsonArrayfieldRules.get(i));
          };
        }
      }
      if ((jsonObj.get("category") != null && !jsonObj.get("category").isJsonNull()) && !jsonObj.get("category").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `category` to be a primitive type in the JSON string but got `%s`", jsonObj.get("category").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!SynchronizeSchemaDto.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'SynchronizeSchemaDto' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<SynchronizeSchemaDto> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(SynchronizeSchemaDto.class));

       return (TypeAdapter<T>) new TypeAdapter<SynchronizeSchemaDto>() {
           @Override
           public void write(JsonWriter out, SynchronizeSchemaDto value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public SynchronizeSchemaDto read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of SynchronizeSchemaDto given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of SynchronizeSchemaDto
   * @throws IOException if the JSON string is invalid with respect to SynchronizeSchemaDto
   */
  public static SynchronizeSchemaDto fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, SynchronizeSchemaDto.class);
  }

  /**
   * Convert an instance of SynchronizeSchemaDto to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
