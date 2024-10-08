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
 * ConfigureUIFieldsDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.9.0-SNAPSHOT")
public class ConfigureUIFieldsDto {
  public static final String SERIALIZED_NAME_FIELDS_IN_LISTS = "fieldsInLists";
  @SerializedName(SERIALIZED_NAME_FIELDS_IN_LISTS)
  private List<String> fieldsInLists;
  public static final String SERIALIZED_NAME_FIELDS_IN_REFERENCES = "fieldsInReferences";
  @SerializedName(SERIALIZED_NAME_FIELDS_IN_REFERENCES)
  private List<String> fieldsInReferences;
  public ConfigureUIFieldsDto() {
  }
  public ConfigureUIFieldsDto fieldsInLists(List<String> fieldsInLists) {
    this.fieldsInLists = fieldsInLists;
    return this;
  }

  public ConfigureUIFieldsDto addFieldsInListsItem(String fieldsInListsItem) {
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
  @javax.annotation.Nullable
  public List<String> getFieldsInLists() {
    return fieldsInLists;
  }

  public void setFieldsInLists(List<String> fieldsInLists) {
    this.fieldsInLists = fieldsInLists;
  }
  public ConfigureUIFieldsDto fieldsInReferences(List<String> fieldsInReferences) {
    this.fieldsInReferences = fieldsInReferences;
    return this;
  }

  public ConfigureUIFieldsDto addFieldsInReferencesItem(String fieldsInReferencesItem) {
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
  @javax.annotation.Nullable
  public List<String> getFieldsInReferences() {
    return fieldsInReferences;
  }

  public void setFieldsInReferences(List<String> fieldsInReferences) {
    this.fieldsInReferences = fieldsInReferences;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConfigureUIFieldsDto configureUIFieldsDto = (ConfigureUIFieldsDto) o;
    return Objects.equals(this.fieldsInLists, configureUIFieldsDto.fieldsInLists) &&
        Objects.equals(this.fieldsInReferences, configureUIFieldsDto.fieldsInReferences);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(fieldsInLists, fieldsInReferences);
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
    sb.append("class ConfigureUIFieldsDto {\n");
    sb.append("    fieldsInLists: ").append(toIndentedString(fieldsInLists)).append("\n");
    sb.append("    fieldsInReferences: ").append(toIndentedString(fieldsInReferences)).append("\n");
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
    openapiFields.add("fieldsInLists");
    openapiFields.add("fieldsInReferences");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to ConfigureUIFieldsDto
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ConfigureUIFieldsDto.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ConfigureUIFieldsDto is not found in the empty JSON string", ConfigureUIFieldsDto.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ConfigureUIFieldsDto.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ConfigureUIFieldsDto` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // ensure the optional json data is an array if present
      if (jsonObj.get("fieldsInLists") != null && !jsonObj.get("fieldsInLists").isJsonNull() && !jsonObj.get("fieldsInLists").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `fieldsInLists` to be an array in the JSON string but got `%s`", jsonObj.get("fieldsInLists").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("fieldsInReferences") != null && !jsonObj.get("fieldsInReferences").isJsonNull() && !jsonObj.get("fieldsInReferences").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `fieldsInReferences` to be an array in the JSON string but got `%s`", jsonObj.get("fieldsInReferences").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ConfigureUIFieldsDto.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ConfigureUIFieldsDto' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ConfigureUIFieldsDto> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ConfigureUIFieldsDto.class));

       return (TypeAdapter<T>) new TypeAdapter<ConfigureUIFieldsDto>() {
           @Override
           public void write(JsonWriter out, ConfigureUIFieldsDto value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ConfigureUIFieldsDto read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of ConfigureUIFieldsDto given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of ConfigureUIFieldsDto
   * @throws IOException if the JSON string is invalid with respect to ConfigureUIFieldsDto
   */
  public static ConfigureUIFieldsDto fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ConfigureUIFieldsDto.class);
  }

  /**
   * Convert an instance of ConfigureUIFieldsDto to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
