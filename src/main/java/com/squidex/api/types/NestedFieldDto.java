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
import com.squidex.api.types.FieldPropertiesDto;
import com.squidex.api.types.ResourceLink;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
 * NestedFieldDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.9.0-SNAPSHOT")
public class NestedFieldDto {
  public static final String SERIALIZED_NAME_LINKS = "_links";
  @SerializedName(SERIALIZED_NAME_LINKS)
  private Map<String, ResourceLink> links = new HashMap<>();
  public static final String SERIALIZED_NAME_FIELD_ID = "fieldId";
  @SerializedName(SERIALIZED_NAME_FIELD_ID)
  private Long fieldId;
  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;
  public static final String SERIALIZED_NAME_IS_HIDDEN = "isHidden";
  @SerializedName(SERIALIZED_NAME_IS_HIDDEN)
  private Boolean isHidden;
  public static final String SERIALIZED_NAME_IS_LOCKED = "isLocked";
  @SerializedName(SERIALIZED_NAME_IS_LOCKED)
  private Boolean isLocked;
  public static final String SERIALIZED_NAME_IS_DISABLED = "isDisabled";
  @SerializedName(SERIALIZED_NAME_IS_DISABLED)
  private Boolean isDisabled;
  public static final String SERIALIZED_NAME_PROPERTIES = "properties";
  @SerializedName(SERIALIZED_NAME_PROPERTIES)
  private FieldPropertiesDto properties;
  public NestedFieldDto() {
  }
  public NestedFieldDto links(Map<String, ResourceLink> links) {
    this.links = links;
    return this;
  }

  public NestedFieldDto putLinksItem(String key, ResourceLink linksItem) {
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
  public NestedFieldDto fieldId(Long fieldId) {
    this.fieldId = fieldId;
    return this;
  }

  /**
   * The ID of the field.
   * @return fieldId
   */
  @javax.annotation.Nonnull
  public Long getFieldId() {
    return fieldId;
  }

  public void setFieldId(Long fieldId) {
    this.fieldId = fieldId;
  }
  public NestedFieldDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the field. Must be unique within the schema.
   * @return name
   */
  @javax.annotation.Nonnull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  public NestedFieldDto isHidden(Boolean isHidden) {
    this.isHidden = isHidden;
    return this;
  }

  /**
   * Defines if the field is hidden.
   * @return isHidden
   */
  @javax.annotation.Nonnull
  public Boolean getIsHidden() {
    return isHidden;
  }

  public void setIsHidden(Boolean isHidden) {
    this.isHidden = isHidden;
  }
  public NestedFieldDto isLocked(Boolean isLocked) {
    this.isLocked = isLocked;
    return this;
  }

  /**
   * Defines if the field is locked.
   * @return isLocked
   */
  @javax.annotation.Nonnull
  public Boolean getIsLocked() {
    return isLocked;
  }

  public void setIsLocked(Boolean isLocked) {
    this.isLocked = isLocked;
  }
  public NestedFieldDto isDisabled(Boolean isDisabled) {
    this.isDisabled = isDisabled;
    return this;
  }

  /**
   * Defines if the field is disabled.
   * @return isDisabled
   */
  @javax.annotation.Nonnull
  public Boolean getIsDisabled() {
    return isDisabled;
  }

  public void setIsDisabled(Boolean isDisabled) {
    this.isDisabled = isDisabled;
  }
  public NestedFieldDto properties(FieldPropertiesDto properties) {
    this.properties = properties;
    return this;
  }

  /**
   * Get properties
   * @return properties
   */
  @javax.annotation.Nonnull
  public FieldPropertiesDto getProperties() {
    return properties;
  }

  public void setProperties(FieldPropertiesDto properties) {
    this.properties = properties;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NestedFieldDto nestedFieldDto = (NestedFieldDto) o;
    return Objects.equals(this.links, nestedFieldDto.links) &&
        Objects.equals(this.fieldId, nestedFieldDto.fieldId) &&
        Objects.equals(this.name, nestedFieldDto.name) &&
        Objects.equals(this.isHidden, nestedFieldDto.isHidden) &&
        Objects.equals(this.isLocked, nestedFieldDto.isLocked) &&
        Objects.equals(this.isDisabled, nestedFieldDto.isDisabled) &&
        Objects.equals(this.properties, nestedFieldDto.properties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(links, fieldId, name, isHidden, isLocked, isDisabled, properties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NestedFieldDto {\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    fieldId: ").append(toIndentedString(fieldId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    isHidden: ").append(toIndentedString(isHidden)).append("\n");
    sb.append("    isLocked: ").append(toIndentedString(isLocked)).append("\n");
    sb.append("    isDisabled: ").append(toIndentedString(isDisabled)).append("\n");
    sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
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
    openapiFields.add("fieldId");
    openapiFields.add("name");
    openapiFields.add("isHidden");
    openapiFields.add("isLocked");
    openapiFields.add("isDisabled");
    openapiFields.add("properties");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("_links");
    openapiRequiredFields.add("fieldId");
    openapiRequiredFields.add("name");
    openapiRequiredFields.add("isHidden");
    openapiRequiredFields.add("isLocked");
    openapiRequiredFields.add("isDisabled");
    openapiRequiredFields.add("properties");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to NestedFieldDto
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!NestedFieldDto.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in NestedFieldDto is not found in the empty JSON string", NestedFieldDto.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!NestedFieldDto.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `NestedFieldDto` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : NestedFieldDto.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      // validate the required field `properties`
      FieldPropertiesDto.validateJsonElement(jsonObj.get("properties"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!NestedFieldDto.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'NestedFieldDto' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<NestedFieldDto> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(NestedFieldDto.class));

       return (TypeAdapter<T>) new TypeAdapter<NestedFieldDto>() {
           @Override
           public void write(JsonWriter out, NestedFieldDto value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public NestedFieldDto read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of NestedFieldDto given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of NestedFieldDto
   * @throws IOException if the JSON string is invalid with respect to NestedFieldDto
   */
  public static NestedFieldDto fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, NestedFieldDto.class);
  }

  /**
   * Convert an instance of NestedFieldDto to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
