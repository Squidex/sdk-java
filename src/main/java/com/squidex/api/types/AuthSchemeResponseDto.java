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
import com.squidex.api.types.AuthSchemeDto;
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
 * AuthSchemeResponseDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.9.0-SNAPSHOT")
public class AuthSchemeResponseDto {
  public static final String SERIALIZED_NAME_LINKS = "_links";
  @SerializedName(SERIALIZED_NAME_LINKS)
  private Map<String, ResourceLink> links = new HashMap<>();
  public static final String SERIALIZED_NAME_SCHEME = "scheme";
  @SerializedName(SERIALIZED_NAME_SCHEME)
  private AuthSchemeDto scheme;
  public AuthSchemeResponseDto() {
  }
  public AuthSchemeResponseDto links(Map<String, ResourceLink> links) {
    this.links = links;
    return this;
  }

  public AuthSchemeResponseDto putLinksItem(String key, ResourceLink linksItem) {
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
  public AuthSchemeResponseDto scheme(AuthSchemeDto scheme) {
    this.scheme = scheme;
    return this;
  }

  /**
   * Get scheme
   * @return scheme
   */
  @javax.annotation.Nullable
  public AuthSchemeDto getScheme() {
    return scheme;
  }

  public void setScheme(AuthSchemeDto scheme) {
    this.scheme = scheme;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthSchemeResponseDto authSchemeResponseDto = (AuthSchemeResponseDto) o;
    return Objects.equals(this.links, authSchemeResponseDto.links) &&
        Objects.equals(this.scheme, authSchemeResponseDto.scheme);
  }

  @Override
  public int hashCode() {
    return Objects.hash(links, scheme);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthSchemeResponseDto {\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    scheme: ").append(toIndentedString(scheme)).append("\n");
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
    openapiFields.add("scheme");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("_links");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to AuthSchemeResponseDto
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!AuthSchemeResponseDto.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in AuthSchemeResponseDto is not found in the empty JSON string", AuthSchemeResponseDto.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!AuthSchemeResponseDto.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `AuthSchemeResponseDto` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : AuthSchemeResponseDto.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the optional field `scheme`
      if (jsonObj.get("scheme") != null && !jsonObj.get("scheme").isJsonNull()) {
        AuthSchemeDto.validateJsonElement(jsonObj.get("scheme"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!AuthSchemeResponseDto.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'AuthSchemeResponseDto' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<AuthSchemeResponseDto> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(AuthSchemeResponseDto.class));

       return (TypeAdapter<T>) new TypeAdapter<AuthSchemeResponseDto>() {
           @Override
           public void write(JsonWriter out, AuthSchemeResponseDto value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public AuthSchemeResponseDto read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of AuthSchemeResponseDto given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of AuthSchemeResponseDto
   * @throws IOException if the JSON string is invalid with respect to AuthSchemeResponseDto
   */
  public static AuthSchemeResponseDto fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, AuthSchemeResponseDto.class);
  }

  /**
   * Convert an instance of AuthSchemeResponseDto to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
