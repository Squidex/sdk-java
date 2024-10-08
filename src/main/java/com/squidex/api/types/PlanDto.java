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
 * PlanDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.9.0-SNAPSHOT")
public class PlanDto {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;
  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;
  public static final String SERIALIZED_NAME_COSTS = "costs";
  @SerializedName(SERIALIZED_NAME_COSTS)
  private String costs;
  public static final String SERIALIZED_NAME_CONFIRM_TEXT = "confirmText";
  @SerializedName(SERIALIZED_NAME_CONFIRM_TEXT)
  private String confirmText;
  public static final String SERIALIZED_NAME_YEARLY_CONFIRM_TEXT = "yearlyConfirmText";
  @SerializedName(SERIALIZED_NAME_YEARLY_CONFIRM_TEXT)
  private String yearlyConfirmText;
  public static final String SERIALIZED_NAME_YEARLY_COSTS = "yearlyCosts";
  @SerializedName(SERIALIZED_NAME_YEARLY_COSTS)
  private String yearlyCosts;
  public static final String SERIALIZED_NAME_YEARLY_ID = "yearlyId";
  @SerializedName(SERIALIZED_NAME_YEARLY_ID)
  private String yearlyId;
  public static final String SERIALIZED_NAME_MAX_API_BYTES = "maxApiBytes";
  @SerializedName(SERIALIZED_NAME_MAX_API_BYTES)
  private Long maxApiBytes;
  public static final String SERIALIZED_NAME_MAX_API_CALLS = "maxApiCalls";
  @SerializedName(SERIALIZED_NAME_MAX_API_CALLS)
  private Long maxApiCalls;
  public static final String SERIALIZED_NAME_MAX_ASSET_SIZE = "maxAssetSize";
  @SerializedName(SERIALIZED_NAME_MAX_ASSET_SIZE)
  private Long maxAssetSize;
  public static final String SERIALIZED_NAME_MAX_CONTRIBUTORS = "maxContributors";
  @SerializedName(SERIALIZED_NAME_MAX_CONTRIBUTORS)
  private Integer maxContributors;
  public PlanDto() {
  }
  public PlanDto id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The ID of the plan.
   * @return id
   */
  @javax.annotation.Nonnull
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
  public PlanDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the plan.
   * @return name
   */
  @javax.annotation.Nonnull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  public PlanDto costs(String costs) {
    this.costs = costs;
    return this;
  }

  /**
   * The monthly costs of the plan.
   * @return costs
   */
  @javax.annotation.Nonnull
  public String getCosts() {
    return costs;
  }

  public void setCosts(String costs) {
    this.costs = costs;
  }
  public PlanDto confirmText(String confirmText) {
    this.confirmText = confirmText;
    return this;
  }

  /**
   * An optional confirm text for the monthly subscription.
   * @return confirmText
   */
  @javax.annotation.Nullable
  public String getConfirmText() {
    return confirmText;
  }

  public void setConfirmText(String confirmText) {
    this.confirmText = confirmText;
  }
  public PlanDto yearlyConfirmText(String yearlyConfirmText) {
    this.yearlyConfirmText = yearlyConfirmText;
    return this;
  }

  /**
   * An optional confirm text for the yearly subscription.
   * @return yearlyConfirmText
   */
  @javax.annotation.Nullable
  public String getYearlyConfirmText() {
    return yearlyConfirmText;
  }

  public void setYearlyConfirmText(String yearlyConfirmText) {
    this.yearlyConfirmText = yearlyConfirmText;
  }
  public PlanDto yearlyCosts(String yearlyCosts) {
    this.yearlyCosts = yearlyCosts;
    return this;
  }

  /**
   * The yearly costs of the plan.
   * @return yearlyCosts
   */
  @javax.annotation.Nullable
  public String getYearlyCosts() {
    return yearlyCosts;
  }

  public void setYearlyCosts(String yearlyCosts) {
    this.yearlyCosts = yearlyCosts;
  }
  public PlanDto yearlyId(String yearlyId) {
    this.yearlyId = yearlyId;
    return this;
  }

  /**
   * The yearly ID of the plan.
   * @return yearlyId
   */
  @javax.annotation.Nullable
  public String getYearlyId() {
    return yearlyId;
  }

  public void setYearlyId(String yearlyId) {
    this.yearlyId = yearlyId;
  }
  public PlanDto maxApiBytes(Long maxApiBytes) {
    this.maxApiBytes = maxApiBytes;
    return this;
  }

  /**
   * The maximum number of API traffic.
   * @return maxApiBytes
   */
  @javax.annotation.Nonnull
  public Long getMaxApiBytes() {
    return maxApiBytes;
  }

  public void setMaxApiBytes(Long maxApiBytes) {
    this.maxApiBytes = maxApiBytes;
  }
  public PlanDto maxApiCalls(Long maxApiCalls) {
    this.maxApiCalls = maxApiCalls;
    return this;
  }

  /**
   * The maximum number of API calls.
   * @return maxApiCalls
   */
  @javax.annotation.Nonnull
  public Long getMaxApiCalls() {
    return maxApiCalls;
  }

  public void setMaxApiCalls(Long maxApiCalls) {
    this.maxApiCalls = maxApiCalls;
  }
  public PlanDto maxAssetSize(Long maxAssetSize) {
    this.maxAssetSize = maxAssetSize;
    return this;
  }

  /**
   * The maximum allowed asset size.
   * @return maxAssetSize
   */
  @javax.annotation.Nonnull
  public Long getMaxAssetSize() {
    return maxAssetSize;
  }

  public void setMaxAssetSize(Long maxAssetSize) {
    this.maxAssetSize = maxAssetSize;
  }
  public PlanDto maxContributors(Integer maxContributors) {
    this.maxContributors = maxContributors;
    return this;
  }

  /**
   * The maximum number of contributors.
   * @return maxContributors
   */
  @javax.annotation.Nonnull
  public Integer getMaxContributors() {
    return maxContributors;
  }

  public void setMaxContributors(Integer maxContributors) {
    this.maxContributors = maxContributors;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlanDto planDto = (PlanDto) o;
    return Objects.equals(this.id, planDto.id) &&
        Objects.equals(this.name, planDto.name) &&
        Objects.equals(this.costs, planDto.costs) &&
        Objects.equals(this.confirmText, planDto.confirmText) &&
        Objects.equals(this.yearlyConfirmText, planDto.yearlyConfirmText) &&
        Objects.equals(this.yearlyCosts, planDto.yearlyCosts) &&
        Objects.equals(this.yearlyId, planDto.yearlyId) &&
        Objects.equals(this.maxApiBytes, planDto.maxApiBytes) &&
        Objects.equals(this.maxApiCalls, planDto.maxApiCalls) &&
        Objects.equals(this.maxAssetSize, planDto.maxAssetSize) &&
        Objects.equals(this.maxContributors, planDto.maxContributors);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, costs, confirmText, yearlyConfirmText, yearlyCosts, yearlyId, maxApiBytes, maxApiCalls, maxAssetSize, maxContributors);
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
    sb.append("class PlanDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    costs: ").append(toIndentedString(costs)).append("\n");
    sb.append("    confirmText: ").append(toIndentedString(confirmText)).append("\n");
    sb.append("    yearlyConfirmText: ").append(toIndentedString(yearlyConfirmText)).append("\n");
    sb.append("    yearlyCosts: ").append(toIndentedString(yearlyCosts)).append("\n");
    sb.append("    yearlyId: ").append(toIndentedString(yearlyId)).append("\n");
    sb.append("    maxApiBytes: ").append(toIndentedString(maxApiBytes)).append("\n");
    sb.append("    maxApiCalls: ").append(toIndentedString(maxApiCalls)).append("\n");
    sb.append("    maxAssetSize: ").append(toIndentedString(maxAssetSize)).append("\n");
    sb.append("    maxContributors: ").append(toIndentedString(maxContributors)).append("\n");
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
    openapiFields.add("name");
    openapiFields.add("costs");
    openapiFields.add("confirmText");
    openapiFields.add("yearlyConfirmText");
    openapiFields.add("yearlyCosts");
    openapiFields.add("yearlyId");
    openapiFields.add("maxApiBytes");
    openapiFields.add("maxApiCalls");
    openapiFields.add("maxAssetSize");
    openapiFields.add("maxContributors");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("id");
    openapiRequiredFields.add("name");
    openapiRequiredFields.add("costs");
    openapiRequiredFields.add("maxApiBytes");
    openapiRequiredFields.add("maxApiCalls");
    openapiRequiredFields.add("maxAssetSize");
    openapiRequiredFields.add("maxContributors");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to PlanDto
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!PlanDto.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PlanDto is not found in the empty JSON string", PlanDto.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!PlanDto.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `PlanDto` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PlanDto.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if (!jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if (!jsonObj.get("costs").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `costs` to be a primitive type in the JSON string but got `%s`", jsonObj.get("costs").toString()));
      }
      if ((jsonObj.get("confirmText") != null && !jsonObj.get("confirmText").isJsonNull()) && !jsonObj.get("confirmText").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `confirmText` to be a primitive type in the JSON string but got `%s`", jsonObj.get("confirmText").toString()));
      }
      if ((jsonObj.get("yearlyConfirmText") != null && !jsonObj.get("yearlyConfirmText").isJsonNull()) && !jsonObj.get("yearlyConfirmText").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `yearlyConfirmText` to be a primitive type in the JSON string but got `%s`", jsonObj.get("yearlyConfirmText").toString()));
      }
      if ((jsonObj.get("yearlyCosts") != null && !jsonObj.get("yearlyCosts").isJsonNull()) && !jsonObj.get("yearlyCosts").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `yearlyCosts` to be a primitive type in the JSON string but got `%s`", jsonObj.get("yearlyCosts").toString()));
      }
      if ((jsonObj.get("yearlyId") != null && !jsonObj.get("yearlyId").isJsonNull()) && !jsonObj.get("yearlyId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `yearlyId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("yearlyId").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PlanDto.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PlanDto' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PlanDto> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PlanDto.class));

       return (TypeAdapter<T>) new TypeAdapter<PlanDto>() {
           @Override
           public void write(JsonWriter out, PlanDto value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public PlanDto read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of PlanDto given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of PlanDto
   * @throws IOException if the JSON string is invalid with respect to PlanDto
   */
  public static PlanDto fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PlanDto.class);
  }

  /**
   * Convert an instance of PlanDto to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
