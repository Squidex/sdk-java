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
import com.squidex.api.types.ContentDto;
import com.squidex.api.types.ResourceLink;
import com.squidex.api.types.StatusInfoDto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
 * ContentsDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.9.0-SNAPSHOT")
public class ContentsDto {
  public static final String SERIALIZED_NAME_LINKS = "_links";
  @SerializedName(SERIALIZED_NAME_LINKS)
  private Map<String, ResourceLink> links = new HashMap<>();
  public static final String SERIALIZED_NAME_TOTAL = "total";
  @SerializedName(SERIALIZED_NAME_TOTAL)
  private Long total;
  public static final String SERIALIZED_NAME_ITEMS = "items";
  @SerializedName(SERIALIZED_NAME_ITEMS)
  private List<ContentDto> items = new ArrayList<>();
  public static final String SERIALIZED_NAME_STATUSES = "statuses";
  @SerializedName(SERIALIZED_NAME_STATUSES)
  private List<StatusInfoDto> statuses = new ArrayList<>();
  public ContentsDto() {
  }
  public ContentsDto links(Map<String, ResourceLink> links) {
    this.links = links;
    return this;
  }

  public ContentsDto putLinksItem(String key, ResourceLink linksItem) {
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
  public ContentsDto total(Long total) {
    this.total = total;
    return this;
  }

  /**
   * The total number of content items.
   * @return total
   */
  @javax.annotation.Nonnull
  public Long getTotal() {
    return total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }
  public ContentsDto items(List<ContentDto> items) {
    this.items = items;
    return this;
  }

  public ContentsDto addItemsItem(ContentDto itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * The content items.
   * @return items
   */
  @javax.annotation.Nonnull
  public List<ContentDto> getItems() {
    return items;
  }

  public void setItems(List<ContentDto> items) {
    this.items = items;
  }
  public ContentsDto statuses(List<StatusInfoDto> statuses) {
    this.statuses = statuses;
    return this;
  }

  public ContentsDto addStatusesItem(StatusInfoDto statusesItem) {
    if (this.statuses == null) {
      this.statuses = new ArrayList<>();
    }
    this.statuses.add(statusesItem);
    return this;
  }

  /**
   * The possible statuses.
   * @return statuses
   */
  @javax.annotation.Nonnull
  public List<StatusInfoDto> getStatuses() {
    return statuses;
  }

  public void setStatuses(List<StatusInfoDto> statuses) {
    this.statuses = statuses;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentsDto contentsDto = (ContentsDto) o;
    return Objects.equals(this.links, contentsDto.links) &&
        Objects.equals(this.total, contentsDto.total) &&
        Objects.equals(this.items, contentsDto.items) &&
        Objects.equals(this.statuses, contentsDto.statuses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(links, total, items, statuses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentsDto {\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    statuses: ").append(toIndentedString(statuses)).append("\n");
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
    openapiFields.add("total");
    openapiFields.add("items");
    openapiFields.add("statuses");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("_links");
    openapiRequiredFields.add("total");
    openapiRequiredFields.add("items");
    openapiRequiredFields.add("statuses");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to ContentsDto
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ContentsDto.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ContentsDto is not found in the empty JSON string", ContentsDto.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ContentsDto.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ContentsDto` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : ContentsDto.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // ensure the json data is an array
      if (!jsonObj.get("items").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `items` to be an array in the JSON string but got `%s`", jsonObj.get("items").toString()));
      }

      JsonArray jsonArrayitems = jsonObj.getAsJsonArray("items");
      // validate the required field `items` (array)
      for (int i = 0; i < jsonArrayitems.size(); i++) {
        ContentDto.validateJsonElement(jsonArrayitems.get(i));
      };
      // ensure the json data is an array
      if (!jsonObj.get("statuses").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `statuses` to be an array in the JSON string but got `%s`", jsonObj.get("statuses").toString()));
      }

      JsonArray jsonArraystatuses = jsonObj.getAsJsonArray("statuses");
      // validate the required field `statuses` (array)
      for (int i = 0; i < jsonArraystatuses.size(); i++) {
        StatusInfoDto.validateJsonElement(jsonArraystatuses.get(i));
      };
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ContentsDto.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ContentsDto' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ContentsDto> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ContentsDto.class));

       return (TypeAdapter<T>) new TypeAdapter<ContentsDto>() {
           @Override
           public void write(JsonWriter out, ContentsDto value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ContentsDto read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of ContentsDto given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of ContentsDto
   * @throws IOException if the JSON string is invalid with respect to ContentsDto
   */
  public static ContentsDto fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ContentsDto.class);
  }

  /**
   * Convert an instance of ContentsDto to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
