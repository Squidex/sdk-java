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
 * JsonFieldPropertiesDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.9.0-SNAPSHOT")
public class JsonFieldPropertiesDto extends FieldPropertiesDto {
  public static final String SERIALIZED_NAME_GRAPH_Q_L_SCHEMA = "graphQLSchema";
  @SerializedName(SERIALIZED_NAME_GRAPH_Q_L_SCHEMA)
  private String graphQLSchema;
  public JsonFieldPropertiesDto() {
  }
  public JsonFieldPropertiesDto graphQLSchema(String graphQLSchema) {
    this.graphQLSchema = graphQLSchema;
    return this;
  }

  /**
   * The GraphQL schema.
   * @return graphQLSchema
   */
  @javax.annotation.Nullable
  public String getGraphQLSchema() {
    return graphQLSchema;
  }

  public void setGraphQLSchema(String graphQLSchema) {
    this.graphQLSchema = graphQLSchema;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonFieldPropertiesDto jsonFieldPropertiesDto = (JsonFieldPropertiesDto) o;
    return Objects.equals(this.graphQLSchema, jsonFieldPropertiesDto.graphQLSchema) &&
        super.equals(o);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(graphQLSchema, super.hashCode());
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
    sb.append("class JsonFieldPropertiesDto {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    graphQLSchema: ").append(toIndentedString(graphQLSchema)).append("\n");
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
    openapiFields.add("label");
    openapiFields.add("hints");
    openapiFields.add("placeholder");
    openapiFields.add("isRequired");
    openapiFields.add("isRequiredOnPublish");
    openapiFields.add("isHalfWidth");
    openapiFields.add("editorUrl");
    openapiFields.add("tags");
    openapiFields.add("fieldType");
    openapiFields.add("graphQLSchema");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("fieldType");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to JsonFieldPropertiesDto
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!JsonFieldPropertiesDto.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in JsonFieldPropertiesDto is not found in the empty JSON string", JsonFieldPropertiesDto.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!JsonFieldPropertiesDto.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `JsonFieldPropertiesDto` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : JsonFieldPropertiesDto.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!JsonFieldPropertiesDto.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'JsonFieldPropertiesDto' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<JsonFieldPropertiesDto> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(JsonFieldPropertiesDto.class));

       return (TypeAdapter<T>) new TypeAdapter<JsonFieldPropertiesDto>() {
           @Override
           public void write(JsonWriter out, JsonFieldPropertiesDto value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public JsonFieldPropertiesDto read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of JsonFieldPropertiesDto given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of JsonFieldPropertiesDto
   * @throws IOException if the JSON string is invalid with respect to JsonFieldPropertiesDto
   */
  public static JsonFieldPropertiesDto fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, JsonFieldPropertiesDto.class);
  }

  /**
   * Convert an instance of JsonFieldPropertiesDto to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
