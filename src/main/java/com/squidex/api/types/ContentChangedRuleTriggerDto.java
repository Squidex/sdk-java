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
import com.squidex.api.types.RuleTriggerDto;
import com.squidex.api.types.SchemaCondition;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
 * ContentChangedRuleTriggerDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.9.0-SNAPSHOT")
public class ContentChangedRuleTriggerDto extends RuleTriggerDto {
  public static final String SERIALIZED_NAME_SCHEMAS = "schemas";
  @SerializedName(SERIALIZED_NAME_SCHEMAS)
  private List<SchemaCondition> schemas;
  public static final String SERIALIZED_NAME_REFERENCED_SCHEMAS = "referencedSchemas";
  @SerializedName(SERIALIZED_NAME_REFERENCED_SCHEMAS)
  private List<SchemaCondition> referencedSchemas;
  public static final String SERIALIZED_NAME_HANDLE_ALL = "handleAll";
  @SerializedName(SERIALIZED_NAME_HANDLE_ALL)
  private Boolean handleAll;
  public ContentChangedRuleTriggerDto() {
  }
  public ContentChangedRuleTriggerDto schemas(List<SchemaCondition> schemas) {
    this.schemas = schemas;
    return this;
  }

  public ContentChangedRuleTriggerDto addSchemasItem(SchemaCondition schemasItem) {
    if (this.schemas == null) {
      this.schemas = new ArrayList<>();
    }
    this.schemas.add(schemasItem);
    return this;
  }

  /**
   * The schema settings.
   * @return schemas
   */
  @javax.annotation.Nullable
  public List<SchemaCondition> getSchemas() {
    return schemas;
  }

  public void setSchemas(List<SchemaCondition> schemas) {
    this.schemas = schemas;
  }
  public ContentChangedRuleTriggerDto referencedSchemas(List<SchemaCondition> referencedSchemas) {
    this.referencedSchemas = referencedSchemas;
    return this;
  }

  public ContentChangedRuleTriggerDto addReferencedSchemasItem(SchemaCondition referencedSchemasItem) {
    if (this.referencedSchemas == null) {
      this.referencedSchemas = new ArrayList<>();
    }
    this.referencedSchemas.add(referencedSchemasItem);
    return this;
  }

  /**
   * The schema references.
   * @return referencedSchemas
   */
  @javax.annotation.Nullable
  public List<SchemaCondition> getReferencedSchemas() {
    return referencedSchemas;
  }

  public void setReferencedSchemas(List<SchemaCondition> referencedSchemas) {
    this.referencedSchemas = referencedSchemas;
  }
  public ContentChangedRuleTriggerDto handleAll(Boolean handleAll) {
    this.handleAll = handleAll;
    return this;
  }

  /**
   * Determines whether the trigger should handle all content changes events.
   * @return handleAll
   */
  @javax.annotation.Nonnull
  public Boolean getHandleAll() {
    return handleAll;
  }

  public void setHandleAll(Boolean handleAll) {
    this.handleAll = handleAll;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentChangedRuleTriggerDto contentChangedRuleTriggerDto = (ContentChangedRuleTriggerDto) o;
    return Objects.equals(this.schemas, contentChangedRuleTriggerDto.schemas) &&
        Objects.equals(this.referencedSchemas, contentChangedRuleTriggerDto.referencedSchemas) &&
        Objects.equals(this.handleAll, contentChangedRuleTriggerDto.handleAll) &&
        super.equals(o);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(schemas, referencedSchemas, handleAll, super.hashCode());
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
    sb.append("class ContentChangedRuleTriggerDto {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    schemas: ").append(toIndentedString(schemas)).append("\n");
    sb.append("    referencedSchemas: ").append(toIndentedString(referencedSchemas)).append("\n");
    sb.append("    handleAll: ").append(toIndentedString(handleAll)).append("\n");
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
    openapiFields.add("triggerType");
    openapiFields.add("schemas");
    openapiFields.add("referencedSchemas");
    openapiFields.add("handleAll");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("handleAll");
    openapiRequiredFields.add("triggerType");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to ContentChangedRuleTriggerDto
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ContentChangedRuleTriggerDto.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ContentChangedRuleTriggerDto is not found in the empty JSON string", ContentChangedRuleTriggerDto.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ContentChangedRuleTriggerDto.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ContentChangedRuleTriggerDto` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : ContentChangedRuleTriggerDto.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ContentChangedRuleTriggerDto.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ContentChangedRuleTriggerDto' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ContentChangedRuleTriggerDto> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ContentChangedRuleTriggerDto.class));

       return (TypeAdapter<T>) new TypeAdapter<ContentChangedRuleTriggerDto>() {
           @Override
           public void write(JsonWriter out, ContentChangedRuleTriggerDto value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ContentChangedRuleTriggerDto read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of ContentChangedRuleTriggerDto given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of ContentChangedRuleTriggerDto
   * @throws IOException if the JSON string is invalid with respect to ContentChangedRuleTriggerDto
   */
  public static ContentChangedRuleTriggerDto fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ContentChangedRuleTriggerDto.class);
  }

  /**
   * Convert an instance of ContentChangedRuleTriggerDto to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
