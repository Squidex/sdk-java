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
 * UpdateLanguageDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.9.0-SNAPSHOT")
public class UpdateLanguageDto {
  public static final String SERIALIZED_NAME_IS_MASTER = "isMaster";
  @SerializedName(SERIALIZED_NAME_IS_MASTER)
  private Boolean isMaster;
  public static final String SERIALIZED_NAME_IS_OPTIONAL = "isOptional";
  @SerializedName(SERIALIZED_NAME_IS_OPTIONAL)
  private Boolean isOptional;
  public static final String SERIALIZED_NAME_FALLBACK = "fallback";
  @SerializedName(SERIALIZED_NAME_FALLBACK)
  private List<String> fallback;
  public UpdateLanguageDto() {
  }
  public UpdateLanguageDto isMaster(Boolean isMaster) {
    this.isMaster = isMaster;
    return this;
  }

  /**
   * Set the value to true to make the language the master.
   * @return isMaster
   */
  @javax.annotation.Nullable
  public Boolean getIsMaster() {
    return isMaster;
  }

  public void setIsMaster(Boolean isMaster) {
    this.isMaster = isMaster;
  }
  public UpdateLanguageDto isOptional(Boolean isOptional) {
    this.isOptional = isOptional;
    return this;
  }

  /**
   * Set the value to true to make the language optional.
   * @return isOptional
   */
  @javax.annotation.Nullable
  public Boolean getIsOptional() {
    return isOptional;
  }

  public void setIsOptional(Boolean isOptional) {
    this.isOptional = isOptional;
  }
  public UpdateLanguageDto fallback(List<String> fallback) {
    this.fallback = fallback;
    return this;
  }

  public UpdateLanguageDto addFallbackItem(String fallbackItem) {
    if (this.fallback == null) {
      this.fallback = new ArrayList<>();
    }
    this.fallback.add(fallbackItem);
    return this;
  }

  /**
   * Optional fallback languages.
   * @return fallback
   */
  @javax.annotation.Nullable
  public List<String> getFallback() {
    return fallback;
  }

  public void setFallback(List<String> fallback) {
    this.fallback = fallback;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateLanguageDto updateLanguageDto = (UpdateLanguageDto) o;
    return Objects.equals(this.isMaster, updateLanguageDto.isMaster) &&
        Objects.equals(this.isOptional, updateLanguageDto.isOptional) &&
        Objects.equals(this.fallback, updateLanguageDto.fallback);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(isMaster, isOptional, fallback);
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
    sb.append("class UpdateLanguageDto {\n");
    sb.append("    isMaster: ").append(toIndentedString(isMaster)).append("\n");
    sb.append("    isOptional: ").append(toIndentedString(isOptional)).append("\n");
    sb.append("    fallback: ").append(toIndentedString(fallback)).append("\n");
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
    openapiFields.add("isMaster");
    openapiFields.add("isOptional");
    openapiFields.add("fallback");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to UpdateLanguageDto
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!UpdateLanguageDto.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in UpdateLanguageDto is not found in the empty JSON string", UpdateLanguageDto.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!UpdateLanguageDto.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `UpdateLanguageDto` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // ensure the optional json data is an array if present
      if (jsonObj.get("fallback") != null && !jsonObj.get("fallback").isJsonNull() && !jsonObj.get("fallback").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `fallback` to be an array in the JSON string but got `%s`", jsonObj.get("fallback").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!UpdateLanguageDto.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'UpdateLanguageDto' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<UpdateLanguageDto> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(UpdateLanguageDto.class));

       return (TypeAdapter<T>) new TypeAdapter<UpdateLanguageDto>() {
           @Override
           public void write(JsonWriter out, UpdateLanguageDto value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public UpdateLanguageDto read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of UpdateLanguageDto given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of UpdateLanguageDto
   * @throws IOException if the JSON string is invalid with respect to UpdateLanguageDto
   */
  public static UpdateLanguageDto fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, UpdateLanguageDto.class);
  }

  /**
   * Convert an instance of UpdateLanguageDto to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
