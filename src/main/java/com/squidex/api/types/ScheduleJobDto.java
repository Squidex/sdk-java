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
import java.time.OffsetDateTime;
import java.util.Arrays;

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
 * ScheduleJobDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.9.0-SNAPSHOT")
public class ScheduleJobDto {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;
  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private String status;
  public static final String SERIALIZED_NAME_DUE_TIME = "dueTime";
  @SerializedName(SERIALIZED_NAME_DUE_TIME)
  private OffsetDateTime dueTime;
  public static final String SERIALIZED_NAME_COLOR = "color";
  @SerializedName(SERIALIZED_NAME_COLOR)
  private String color;
  public static final String SERIALIZED_NAME_SCHEDULED_BY = "scheduledBy";
  @SerializedName(SERIALIZED_NAME_SCHEDULED_BY)
  private String scheduledBy;
  public ScheduleJobDto() {
  }
  public ScheduleJobDto id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The ID of the schedule job.
   * @return id
   */
  @javax.annotation.Nonnull
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
  public ScheduleJobDto status(String status) {
    this.status = status;
    return this;
  }

  /**
   * The new status.
   * @return status
   */
  @javax.annotation.Nonnull
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
  public ScheduleJobDto dueTime(OffsetDateTime dueTime) {
    this.dueTime = dueTime;
    return this;
  }

  /**
   * The target date and time when the content should be scheduled.
   * @return dueTime
   */
  @javax.annotation.Nonnull
  public OffsetDateTime getDueTime() {
    return dueTime;
  }

  public void setDueTime(OffsetDateTime dueTime) {
    this.dueTime = dueTime;
  }
  public ScheduleJobDto color(String color) {
    this.color = color;
    return this;
  }

  /**
   * The color of the scheduled status.
   * @return color
   */
  @javax.annotation.Nonnull
  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
  public ScheduleJobDto scheduledBy(String scheduledBy) {
    this.scheduledBy = scheduledBy;
    return this;
  }

  /**
   * The user who schedule the content.
   * @return scheduledBy
   */
  @javax.annotation.Nonnull
  public String getScheduledBy() {
    return scheduledBy;
  }

  public void setScheduledBy(String scheduledBy) {
    this.scheduledBy = scheduledBy;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScheduleJobDto scheduleJobDto = (ScheduleJobDto) o;
    return Objects.equals(this.id, scheduleJobDto.id) &&
        Objects.equals(this.status, scheduleJobDto.status) &&
        Objects.equals(this.dueTime, scheduleJobDto.dueTime) &&
        Objects.equals(this.color, scheduleJobDto.color) &&
        Objects.equals(this.scheduledBy, scheduleJobDto.scheduledBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, dueTime, color, scheduledBy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScheduleJobDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    dueTime: ").append(toIndentedString(dueTime)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    scheduledBy: ").append(toIndentedString(scheduledBy)).append("\n");
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
    openapiFields.add("id");
    openapiFields.add("status");
    openapiFields.add("dueTime");
    openapiFields.add("color");
    openapiFields.add("scheduledBy");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("id");
    openapiRequiredFields.add("status");
    openapiRequiredFields.add("dueTime");
    openapiRequiredFields.add("color");
    openapiRequiredFields.add("scheduledBy");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to ScheduleJobDto
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ScheduleJobDto.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ScheduleJobDto is not found in the empty JSON string", ScheduleJobDto.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ScheduleJobDto.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ScheduleJobDto` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : ScheduleJobDto.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if (!jsonObj.get("status").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `status` to be a primitive type in the JSON string but got `%s`", jsonObj.get("status").toString()));
      }
      if (!jsonObj.get("color").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `color` to be a primitive type in the JSON string but got `%s`", jsonObj.get("color").toString()));
      }
      if (!jsonObj.get("scheduledBy").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `scheduledBy` to be a primitive type in the JSON string but got `%s`", jsonObj.get("scheduledBy").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ScheduleJobDto.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ScheduleJobDto' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ScheduleJobDto> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ScheduleJobDto.class));

       return (TypeAdapter<T>) new TypeAdapter<ScheduleJobDto>() {
           @Override
           public void write(JsonWriter out, ScheduleJobDto value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ScheduleJobDto read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of ScheduleJobDto given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of ScheduleJobDto
   * @throws IOException if the JSON string is invalid with respect to ScheduleJobDto
   */
  public static ScheduleJobDto fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ScheduleJobDto.class);
  }

  /**
   * Convert an instance of ScheduleJobDto to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
