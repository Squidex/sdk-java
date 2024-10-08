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
import com.squidex.api.types.SortNode;
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
 * QueryJsonDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.9.0-SNAPSHOT")
public class QueryJsonDto {
  public static final String SERIALIZED_NAME_FILTER = "filter";
  @SerializedName(SERIALIZED_NAME_FILTER)
  private Object filter = null;
  public static final String SERIALIZED_NAME_FULL_TEXT = "fullText";
  @SerializedName(SERIALIZED_NAME_FULL_TEXT)
  private String fullText;
  public static final String SERIALIZED_NAME_SKIP = "skip";
  @SerializedName(SERIALIZED_NAME_SKIP)
  private Long skip;
  public static final String SERIALIZED_NAME_TAKE = "take";
  @SerializedName(SERIALIZED_NAME_TAKE)
  private Long take;
  public static final String SERIALIZED_NAME_RANDOM = "random";
  @SerializedName(SERIALIZED_NAME_RANDOM)
  private Long random;
  public static final String SERIALIZED_NAME_TOP = "top";
  @SerializedName(SERIALIZED_NAME_TOP)
  private Long top;
  public static final String SERIALIZED_NAME_SORT = "sort";
  @SerializedName(SERIALIZED_NAME_SORT)
  private List<SortNode> sort;
  public QueryJsonDto() {
  }
  public QueryJsonDto filter(Object filter) {
    this.filter = filter;
    return this;
  }

  /**
   * Get filter
   * @return filter
   */
  @javax.annotation.Nullable
  public Object getFilter() {
    return filter;
  }

  public void setFilter(Object filter) {
    this.filter = filter;
  }
  public QueryJsonDto fullText(String fullText) {
    this.fullText = fullText;
    return this;
  }

  /**
   * Get fullText
   * @return fullText
   */
  @javax.annotation.Nullable
  public String getFullText() {
    return fullText;
  }

  public void setFullText(String fullText) {
    this.fullText = fullText;
  }
  public QueryJsonDto skip(Long skip) {
    this.skip = skip;
    return this;
  }

  /**
   * Get skip
   * @return skip
   */
  @javax.annotation.Nonnull
  public Long getSkip() {
    return skip;
  }

  public void setSkip(Long skip) {
    this.skip = skip;
  }
  public QueryJsonDto take(Long take) {
    this.take = take;
    return this;
  }

  /**
   * Get take
   * @return take
   */
  @javax.annotation.Nonnull
  public Long getTake() {
    return take;
  }

  public void setTake(Long take) {
    this.take = take;
  }
  public QueryJsonDto random(Long random) {
    this.random = random;
    return this;
  }

  /**
   * Get random
   * @return random
   */
  @javax.annotation.Nonnull
  public Long getRandom() {
    return random;
  }

  public void setRandom(Long random) {
    this.random = random;
  }
  public QueryJsonDto top(Long top) {
    this.top = top;
    return this;
  }

  /**
   * Get top
   * @return top
   */
  @javax.annotation.Nonnull
  public Long getTop() {
    return top;
  }

  public void setTop(Long top) {
    this.top = top;
  }
  public QueryJsonDto sort(List<SortNode> sort) {
    this.sort = sort;
    return this;
  }

  public QueryJsonDto addSortItem(SortNode sortItem) {
    if (this.sort == null) {
      this.sort = new ArrayList<>();
    }
    this.sort.add(sortItem);
    return this;
  }

  /**
   * Get sort
   * @return sort
   */
  @javax.annotation.Nullable
  public List<SortNode> getSort() {
    return sort;
  }

  public void setSort(List<SortNode> sort) {
    this.sort = sort;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QueryJsonDto queryJsonDto = (QueryJsonDto) o;
    return Objects.equals(this.filter, queryJsonDto.filter) &&
        Objects.equals(this.fullText, queryJsonDto.fullText) &&
        Objects.equals(this.skip, queryJsonDto.skip) &&
        Objects.equals(this.take, queryJsonDto.take) &&
        Objects.equals(this.random, queryJsonDto.random) &&
        Objects.equals(this.top, queryJsonDto.top) &&
        Objects.equals(this.sort, queryJsonDto.sort);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(filter, fullText, skip, take, random, top, sort);
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
    sb.append("class QueryJsonDto {\n");
    sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
    sb.append("    fullText: ").append(toIndentedString(fullText)).append("\n");
    sb.append("    skip: ").append(toIndentedString(skip)).append("\n");
    sb.append("    take: ").append(toIndentedString(take)).append("\n");
    sb.append("    random: ").append(toIndentedString(random)).append("\n");
    sb.append("    top: ").append(toIndentedString(top)).append("\n");
    sb.append("    sort: ").append(toIndentedString(sort)).append("\n");
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
    openapiFields.add("filter");
    openapiFields.add("fullText");
    openapiFields.add("skip");
    openapiFields.add("take");
    openapiFields.add("random");
    openapiFields.add("top");
    openapiFields.add("sort");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("skip");
    openapiRequiredFields.add("take");
    openapiRequiredFields.add("random");
    openapiRequiredFields.add("top");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to QueryJsonDto
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!QueryJsonDto.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in QueryJsonDto is not found in the empty JSON string", QueryJsonDto.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!QueryJsonDto.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `QueryJsonDto` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : QueryJsonDto.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("fullText") != null && !jsonObj.get("fullText").isJsonNull()) && !jsonObj.get("fullText").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `fullText` to be a primitive type in the JSON string but got `%s`", jsonObj.get("fullText").toString()));
      }
      if (jsonObj.get("sort") != null && !jsonObj.get("sort").isJsonNull()) {
        JsonArray jsonArraysort = jsonObj.getAsJsonArray("sort");
        if (jsonArraysort != null) {
          // ensure the json data is an array
          if (!jsonObj.get("sort").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `sort` to be an array in the JSON string but got `%s`", jsonObj.get("sort").toString()));
          }

          // validate the optional field `sort` (array)
          for (int i = 0; i < jsonArraysort.size(); i++) {
            SortNode.validateJsonElement(jsonArraysort.get(i));
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!QueryJsonDto.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'QueryJsonDto' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<QueryJsonDto> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(QueryJsonDto.class));

       return (TypeAdapter<T>) new TypeAdapter<QueryJsonDto>() {
           @Override
           public void write(JsonWriter out, QueryJsonDto value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public QueryJsonDto read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of QueryJsonDto given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of QueryJsonDto
   * @throws IOException if the JSON string is invalid with respect to QueryJsonDto
   */
  public static QueryJsonDto fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, QueryJsonDto.class);
  }

  /**
   * Convert an instance of QueryJsonDto to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
