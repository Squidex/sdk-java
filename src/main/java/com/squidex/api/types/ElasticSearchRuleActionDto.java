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
import com.squidex.api.types.RuleActionDto;
import java.io.IOException;
import java.net.URI;
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
 * ElasticSearchRuleActionDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.9.0-SNAPSHOT")
public class ElasticSearchRuleActionDto extends RuleActionDto {
  public static final String SERIALIZED_NAME_HOST = "host";
  @SerializedName(SERIALIZED_NAME_HOST)
  private URI host;
  public static final String SERIALIZED_NAME_INDEX_NAME = "indexName";
  @SerializedName(SERIALIZED_NAME_INDEX_NAME)
  private String indexName;
  public static final String SERIALIZED_NAME_USERNAME = "username";
  @SerializedName(SERIALIZED_NAME_USERNAME)
  private String username;
  public static final String SERIALIZED_NAME_PASSWORD = "password";
  @SerializedName(SERIALIZED_NAME_PASSWORD)
  private String password;
  public static final String SERIALIZED_NAME_DOCUMENT = "document";
  @SerializedName(SERIALIZED_NAME_DOCUMENT)
  private String document;
  public static final String SERIALIZED_NAME_DELETE = "delete";
  @SerializedName(SERIALIZED_NAME_DELETE)
  private String delete;
  public ElasticSearchRuleActionDto() {
  }
  public ElasticSearchRuleActionDto host(URI host) {
    this.host = host;
    return this;
  }

  /**
   * The url to the instance or cluster.
   * @return host
   */
  @javax.annotation.Nonnull
  public URI getHost() {
    return host;
  }

  public void setHost(URI host) {
    this.host = host;
  }
  public ElasticSearchRuleActionDto indexName(String indexName) {
    this.indexName = indexName;
    return this;
  }

  /**
   * The name of the index.
   * @return indexName
   */
  @javax.annotation.Nonnull
  public String getIndexName() {
    return indexName;
  }

  public void setIndexName(String indexName) {
    this.indexName = indexName;
  }
  public ElasticSearchRuleActionDto username(String username) {
    this.username = username;
    return this;
  }

  /**
   * The optional username.
   * @return username
   */
  @javax.annotation.Nullable
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
  public ElasticSearchRuleActionDto password(String password) {
    this.password = password;
    return this;
  }

  /**
   * The optional password.
   * @return password
   */
  @javax.annotation.Nullable
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  public ElasticSearchRuleActionDto document(String document) {
    this.document = document;
    return this;
  }

  /**
   * The optional custom document.
   * @return document
   */
  @javax.annotation.Nullable
  public String getDocument() {
    return document;
  }

  public void setDocument(String document) {
    this.document = document;
  }
  public ElasticSearchRuleActionDto delete(String delete) {
    this.delete = delete;
    return this;
  }

  /**
   * The condition when to delete the document.
   * @return delete
   */
  @javax.annotation.Nullable
  public String getDelete() {
    return delete;
  }

  public void setDelete(String delete) {
    this.delete = delete;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ElasticSearchRuleActionDto elasticSearchRuleActionDto = (ElasticSearchRuleActionDto) o;
    return Objects.equals(this.host, elasticSearchRuleActionDto.host) &&
        Objects.equals(this.indexName, elasticSearchRuleActionDto.indexName) &&
        Objects.equals(this.username, elasticSearchRuleActionDto.username) &&
        Objects.equals(this.password, elasticSearchRuleActionDto.password) &&
        Objects.equals(this.document, elasticSearchRuleActionDto.document) &&
        Objects.equals(this.delete, elasticSearchRuleActionDto.delete) &&
        super.equals(o);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(host, indexName, username, password, document, delete, super.hashCode());
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
    sb.append("class ElasticSearchRuleActionDto {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    host: ").append(toIndentedString(host)).append("\n");
    sb.append("    indexName: ").append(toIndentedString(indexName)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    document: ").append(toIndentedString(document)).append("\n");
    sb.append("    delete: ").append(toIndentedString(delete)).append("\n");
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
    openapiFields.add("actionType");
    openapiFields.add("host");
    openapiFields.add("indexName");
    openapiFields.add("username");
    openapiFields.add("password");
    openapiFields.add("document");
    openapiFields.add("delete");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("host");
    openapiRequiredFields.add("indexName");
    openapiRequiredFields.add("actionType");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to ElasticSearchRuleActionDto
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ElasticSearchRuleActionDto.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ElasticSearchRuleActionDto is not found in the empty JSON string", ElasticSearchRuleActionDto.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ElasticSearchRuleActionDto.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ElasticSearchRuleActionDto` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : ElasticSearchRuleActionDto.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ElasticSearchRuleActionDto.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ElasticSearchRuleActionDto' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ElasticSearchRuleActionDto> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ElasticSearchRuleActionDto.class));

       return (TypeAdapter<T>) new TypeAdapter<ElasticSearchRuleActionDto>() {
           @Override
           public void write(JsonWriter out, ElasticSearchRuleActionDto value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ElasticSearchRuleActionDto read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of ElasticSearchRuleActionDto given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of ElasticSearchRuleActionDto
   * @throws IOException if the JSON string is invalid with respect to ElasticSearchRuleActionDto
   */
  public static ElasticSearchRuleActionDto fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ElasticSearchRuleActionDto.class);
  }

  /**
   * Convert an instance of ElasticSearchRuleActionDto to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
