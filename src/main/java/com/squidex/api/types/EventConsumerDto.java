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
import com.squidex.api.types.ResourceLink;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
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
 * EventConsumerDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.9.0-SNAPSHOT")
public class EventConsumerDto {
  public static final String SERIALIZED_NAME_LINKS = "_links";
  @SerializedName(SERIALIZED_NAME_LINKS)
  private Map<String, ResourceLink> links = new HashMap<>();
  public static final String SERIALIZED_NAME_IS_STOPPED = "isStopped";
  @SerializedName(SERIALIZED_NAME_IS_STOPPED)
  private Boolean isStopped;
  public static final String SERIALIZED_NAME_IS_RESETTING = "isResetting";
  @SerializedName(SERIALIZED_NAME_IS_RESETTING)
  private Boolean isResetting;
  public static final String SERIALIZED_NAME_COUNT = "count";
  @SerializedName(SERIALIZED_NAME_COUNT)
  private Integer count;
  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;
  public static final String SERIALIZED_NAME_ERROR = "error";
  @SerializedName(SERIALIZED_NAME_ERROR)
  private String error;
  public static final String SERIALIZED_NAME_POSITION = "position";
  @SerializedName(SERIALIZED_NAME_POSITION)
  private String position;
  public EventConsumerDto() {
  }
  public EventConsumerDto links(Map<String, ResourceLink> links) {
    this.links = links;
    return this;
  }

  public EventConsumerDto putLinksItem(String key, ResourceLink linksItem) {
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
  public EventConsumerDto isStopped(Boolean isStopped) {
    this.isStopped = isStopped;
    return this;
  }

  /**
   * Indicates if the event consumer has been started.
   * @return isStopped
   */
  @javax.annotation.Nonnull
  public Boolean getIsStopped() {
    return isStopped;
  }

  public void setIsStopped(Boolean isStopped) {
    this.isStopped = isStopped;
  }
  public EventConsumerDto isResetting(Boolean isResetting) {
    this.isResetting = isResetting;
    return this;
  }

  /**
   * Indicates if the event consumer is resetting at the moment.
   * @return isResetting
   */
  @javax.annotation.Nonnull
  public Boolean getIsResetting() {
    return isResetting;
  }

  public void setIsResetting(Boolean isResetting) {
    this.isResetting = isResetting;
  }
  public EventConsumerDto count(Integer count) {
    this.count = count;
    return this;
  }

  /**
   * The number of handled events.
   * @return count
   */
  @javax.annotation.Nonnull
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }
  public EventConsumerDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the event consumer.
   * @return name
   */
  @javax.annotation.Nonnull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  public EventConsumerDto error(String error) {
    this.error = error;
    return this;
  }

  /**
   * The error details if the event consumer has been stopped after a failure.
   * @return error
   */
  @javax.annotation.Nullable
  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
  public EventConsumerDto position(String position) {
    this.position = position;
    return this;
  }

  /**
   * The position within the vent stream.
   * @return position
   */
  @javax.annotation.Nullable
  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventConsumerDto eventConsumerDto = (EventConsumerDto) o;
    return Objects.equals(this.links, eventConsumerDto.links) &&
        Objects.equals(this.isStopped, eventConsumerDto.isStopped) &&
        Objects.equals(this.isResetting, eventConsumerDto.isResetting) &&
        Objects.equals(this.count, eventConsumerDto.count) &&
        Objects.equals(this.name, eventConsumerDto.name) &&
        Objects.equals(this.error, eventConsumerDto.error) &&
        Objects.equals(this.position, eventConsumerDto.position);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(links, isStopped, isResetting, count, name, error, position);
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
    sb.append("class EventConsumerDto {\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    isStopped: ").append(toIndentedString(isStopped)).append("\n");
    sb.append("    isResetting: ").append(toIndentedString(isResetting)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
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
    openapiFields.add("isStopped");
    openapiFields.add("isResetting");
    openapiFields.add("count");
    openapiFields.add("name");
    openapiFields.add("error");
    openapiFields.add("position");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("_links");
    openapiRequiredFields.add("isStopped");
    openapiRequiredFields.add("isResetting");
    openapiRequiredFields.add("count");
    openapiRequiredFields.add("name");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to EventConsumerDto
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!EventConsumerDto.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in EventConsumerDto is not found in the empty JSON string", EventConsumerDto.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!EventConsumerDto.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `EventConsumerDto` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : EventConsumerDto.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if ((jsonObj.get("error") != null && !jsonObj.get("error").isJsonNull()) && !jsonObj.get("error").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `error` to be a primitive type in the JSON string but got `%s`", jsonObj.get("error").toString()));
      }
      if ((jsonObj.get("position") != null && !jsonObj.get("position").isJsonNull()) && !jsonObj.get("position").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `position` to be a primitive type in the JSON string but got `%s`", jsonObj.get("position").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!EventConsumerDto.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'EventConsumerDto' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<EventConsumerDto> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(EventConsumerDto.class));

       return (TypeAdapter<T>) new TypeAdapter<EventConsumerDto>() {
           @Override
           public void write(JsonWriter out, EventConsumerDto value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public EventConsumerDto read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of EventConsumerDto given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of EventConsumerDto
   * @throws IOException if the JSON string is invalid with respect to EventConsumerDto
   */
  public static EventConsumerDto fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, EventConsumerDto.class);
  }

  /**
   * Convert an instance of EventConsumerDto to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
