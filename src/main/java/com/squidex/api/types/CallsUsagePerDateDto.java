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
import java.time.LocalDate;
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
 * CallsUsagePerDateDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.9.0-SNAPSHOT")
public class CallsUsagePerDateDto {
  public static final String SERIALIZED_NAME_DATE = "date";
  @SerializedName(SERIALIZED_NAME_DATE)
  private LocalDate date;
  public static final String SERIALIZED_NAME_TOTAL_CALLS = "totalCalls";
  @SerializedName(SERIALIZED_NAME_TOTAL_CALLS)
  private Long totalCalls;
  public static final String SERIALIZED_NAME_TOTAL_BYTES = "totalBytes";
  @SerializedName(SERIALIZED_NAME_TOTAL_BYTES)
  private Long totalBytes;
  public static final String SERIALIZED_NAME_AVERAGE_ELAPSED_MS = "averageElapsedMs";
  @SerializedName(SERIALIZED_NAME_AVERAGE_ELAPSED_MS)
  private Double averageElapsedMs;
  public CallsUsagePerDateDto() {
  }
  public CallsUsagePerDateDto date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * The date when the usage was tracked.
   * @return date
   */
  @javax.annotation.Nonnull
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }
  public CallsUsagePerDateDto totalCalls(Long totalCalls) {
    this.totalCalls = totalCalls;
    return this;
  }

  /**
   * The total number of API calls.
   * @return totalCalls
   */
  @javax.annotation.Nonnull
  public Long getTotalCalls() {
    return totalCalls;
  }

  public void setTotalCalls(Long totalCalls) {
    this.totalCalls = totalCalls;
  }
  public CallsUsagePerDateDto totalBytes(Long totalBytes) {
    this.totalBytes = totalBytes;
    return this;
  }

  /**
   * The total number of bytes transferred.
   * @return totalBytes
   */
  @javax.annotation.Nonnull
  public Long getTotalBytes() {
    return totalBytes;
  }

  public void setTotalBytes(Long totalBytes) {
    this.totalBytes = totalBytes;
  }
  public CallsUsagePerDateDto averageElapsedMs(Double averageElapsedMs) {
    this.averageElapsedMs = averageElapsedMs;
    return this;
  }

  /**
   * The average duration in milliseconds.
   * @return averageElapsedMs
   */
  @javax.annotation.Nonnull
  public Double getAverageElapsedMs() {
    return averageElapsedMs;
  }

  public void setAverageElapsedMs(Double averageElapsedMs) {
    this.averageElapsedMs = averageElapsedMs;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CallsUsagePerDateDto callsUsagePerDateDto = (CallsUsagePerDateDto) o;
    return Objects.equals(this.date, callsUsagePerDateDto.date) &&
        Objects.equals(this.totalCalls, callsUsagePerDateDto.totalCalls) &&
        Objects.equals(this.totalBytes, callsUsagePerDateDto.totalBytes) &&
        Objects.equals(this.averageElapsedMs, callsUsagePerDateDto.averageElapsedMs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, totalCalls, totalBytes, averageElapsedMs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CallsUsagePerDateDto {\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    totalCalls: ").append(toIndentedString(totalCalls)).append("\n");
    sb.append("    totalBytes: ").append(toIndentedString(totalBytes)).append("\n");
    sb.append("    averageElapsedMs: ").append(toIndentedString(averageElapsedMs)).append("\n");
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
    openapiFields.add("date");
    openapiFields.add("totalCalls");
    openapiFields.add("totalBytes");
    openapiFields.add("averageElapsedMs");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("date");
    openapiRequiredFields.add("totalCalls");
    openapiRequiredFields.add("totalBytes");
    openapiRequiredFields.add("averageElapsedMs");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to CallsUsagePerDateDto
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!CallsUsagePerDateDto.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in CallsUsagePerDateDto is not found in the empty JSON string", CallsUsagePerDateDto.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!CallsUsagePerDateDto.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `CallsUsagePerDateDto` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : CallsUsagePerDateDto.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!CallsUsagePerDateDto.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CallsUsagePerDateDto' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CallsUsagePerDateDto> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CallsUsagePerDateDto.class));

       return (TypeAdapter<T>) new TypeAdapter<CallsUsagePerDateDto>() {
           @Override
           public void write(JsonWriter out, CallsUsagePerDateDto value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public CallsUsagePerDateDto read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of CallsUsagePerDateDto given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of CallsUsagePerDateDto
   * @throws IOException if the JSON string is invalid with respect to CallsUsagePerDateDto
   */
  public static CallsUsagePerDateDto fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CallsUsagePerDateDto.class);
  }

  /**
   * Convert an instance of CallsUsagePerDateDto to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
