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
import java.util.Arrays;
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
 * UpdateClientDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.9.0-SNAPSHOT")
public class UpdateClientDto {
  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;
  public static final String SERIALIZED_NAME_ROLE = "role";
  @SerializedName(SERIALIZED_NAME_ROLE)
  private String role;
  public static final String SERIALIZED_NAME_ALLOW_ANONYMOUS = "allowAnonymous";
  @SerializedName(SERIALIZED_NAME_ALLOW_ANONYMOUS)
  private Boolean allowAnonymous;
  public static final String SERIALIZED_NAME_API_CALLS_LIMIT = "apiCallsLimit";
  @SerializedName(SERIALIZED_NAME_API_CALLS_LIMIT)
  private Long apiCallsLimit;
  public static final String SERIALIZED_NAME_API_TRAFFIC_LIMIT = "apiTrafficLimit";
  @SerializedName(SERIALIZED_NAME_API_TRAFFIC_LIMIT)
  private Long apiTrafficLimit;
  public UpdateClientDto() {
  }
  public UpdateClientDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The new display name of the client.
   * @return name
   */
  @javax.annotation.Nullable
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  public UpdateClientDto role(String role) {
    this.role = role;
    return this;
  }

  /**
   * The role of the client.
   * @return role
   */
  @javax.annotation.Nullable
  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }
  public UpdateClientDto allowAnonymous(Boolean allowAnonymous) {
    this.allowAnonymous = allowAnonymous;
    return this;
  }

  /**
   * True to allow anonymous access without an access token for this client.
   * @return allowAnonymous
   */
  @javax.annotation.Nullable
  public Boolean getAllowAnonymous() {
    return allowAnonymous;
  }

  public void setAllowAnonymous(Boolean allowAnonymous) {
    this.allowAnonymous = allowAnonymous;
  }
  public UpdateClientDto apiCallsLimit(Long apiCallsLimit) {
    this.apiCallsLimit = apiCallsLimit;
    return this;
  }

  /**
   * The number of allowed api calls per month for this client.
   * @return apiCallsLimit
   */
  @javax.annotation.Nullable
  public Long getApiCallsLimit() {
    return apiCallsLimit;
  }

  public void setApiCallsLimit(Long apiCallsLimit) {
    this.apiCallsLimit = apiCallsLimit;
  }
  public UpdateClientDto apiTrafficLimit(Long apiTrafficLimit) {
    this.apiTrafficLimit = apiTrafficLimit;
    return this;
  }

  /**
   * The number of allowed api traffic bytes per month for this client.
   * @return apiTrafficLimit
   */
  @javax.annotation.Nullable
  public Long getApiTrafficLimit() {
    return apiTrafficLimit;
  }

  public void setApiTrafficLimit(Long apiTrafficLimit) {
    this.apiTrafficLimit = apiTrafficLimit;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateClientDto updateClientDto = (UpdateClientDto) o;
    return Objects.equals(this.name, updateClientDto.name) &&
        Objects.equals(this.role, updateClientDto.role) &&
        Objects.equals(this.allowAnonymous, updateClientDto.allowAnonymous) &&
        Objects.equals(this.apiCallsLimit, updateClientDto.apiCallsLimit) &&
        Objects.equals(this.apiTrafficLimit, updateClientDto.apiTrafficLimit);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, role, allowAnonymous, apiCallsLimit, apiTrafficLimit);
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
    sb.append("class UpdateClientDto {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    allowAnonymous: ").append(toIndentedString(allowAnonymous)).append("\n");
    sb.append("    apiCallsLimit: ").append(toIndentedString(apiCallsLimit)).append("\n");
    sb.append("    apiTrafficLimit: ").append(toIndentedString(apiTrafficLimit)).append("\n");
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
    openapiFields.add("name");
    openapiFields.add("role");
    openapiFields.add("allowAnonymous");
    openapiFields.add("apiCallsLimit");
    openapiFields.add("apiTrafficLimit");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to UpdateClientDto
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!UpdateClientDto.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in UpdateClientDto is not found in the empty JSON string", UpdateClientDto.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!UpdateClientDto.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `UpdateClientDto` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("name") != null && !jsonObj.get("name").isJsonNull()) && !jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if ((jsonObj.get("role") != null && !jsonObj.get("role").isJsonNull()) && !jsonObj.get("role").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `role` to be a primitive type in the JSON string but got `%s`", jsonObj.get("role").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!UpdateClientDto.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'UpdateClientDto' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<UpdateClientDto> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(UpdateClientDto.class));

       return (TypeAdapter<T>) new TypeAdapter<UpdateClientDto>() {
           @Override
           public void write(JsonWriter out, UpdateClientDto value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public UpdateClientDto read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of UpdateClientDto given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of UpdateClientDto
   * @throws IOException if the JSON string is invalid with respect to UpdateClientDto
   */
  public static UpdateClientDto fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, UpdateClientDto.class);
  }

  /**
   * Convert an instance of UpdateClientDto to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
