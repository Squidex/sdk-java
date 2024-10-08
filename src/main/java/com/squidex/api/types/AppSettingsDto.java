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
import com.squidex.api.types.EditorDto;
import com.squidex.api.types.PatternDto;
import com.squidex.api.types.ResourceLink;
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
 * AppSettingsDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.9.0-SNAPSHOT")
public class AppSettingsDto {
  public static final String SERIALIZED_NAME_LINKS = "_links";
  @SerializedName(SERIALIZED_NAME_LINKS)
  private Map<String, ResourceLink> links = new HashMap<>();
  public static final String SERIALIZED_NAME_PATTERNS = "patterns";
  @SerializedName(SERIALIZED_NAME_PATTERNS)
  private List<PatternDto> patterns = new ArrayList<>();
  public static final String SERIALIZED_NAME_EDITORS = "editors";
  @SerializedName(SERIALIZED_NAME_EDITORS)
  private List<EditorDto> editors = new ArrayList<>();
  public static final String SERIALIZED_NAME_HIDE_SCHEDULER = "hideScheduler";
  @SerializedName(SERIALIZED_NAME_HIDE_SCHEDULER)
  private Boolean hideScheduler;
  public static final String SERIALIZED_NAME_HIDE_DATE_TIME_MODE_BUTTON = "hideDateTimeModeButton";
  @SerializedName(SERIALIZED_NAME_HIDE_DATE_TIME_MODE_BUTTON)
  private Boolean hideDateTimeModeButton;
  public static final String SERIALIZED_NAME_VERSION = "version";
  @SerializedName(SERIALIZED_NAME_VERSION)
  private Long version;
  public AppSettingsDto() {
  }
  public AppSettingsDto links(Map<String, ResourceLink> links) {
    this.links = links;
    return this;
  }

  public AppSettingsDto putLinksItem(String key, ResourceLink linksItem) {
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
  public AppSettingsDto patterns(List<PatternDto> patterns) {
    this.patterns = patterns;
    return this;
  }

  public AppSettingsDto addPatternsItem(PatternDto patternsItem) {
    if (this.patterns == null) {
      this.patterns = new ArrayList<>();
    }
    this.patterns.add(patternsItem);
    return this;
  }

  /**
   * The configured app patterns.
   * @return patterns
   */
  @javax.annotation.Nonnull
  public List<PatternDto> getPatterns() {
    return patterns;
  }

  public void setPatterns(List<PatternDto> patterns) {
    this.patterns = patterns;
  }
  public AppSettingsDto editors(List<EditorDto> editors) {
    this.editors = editors;
    return this;
  }

  public AppSettingsDto addEditorsItem(EditorDto editorsItem) {
    if (this.editors == null) {
      this.editors = new ArrayList<>();
    }
    this.editors.add(editorsItem);
    return this;
  }

  /**
   * The configured UI editors.
   * @return editors
   */
  @javax.annotation.Nonnull
  public List<EditorDto> getEditors() {
    return editors;
  }

  public void setEditors(List<EditorDto> editors) {
    this.editors = editors;
  }
  public AppSettingsDto hideScheduler(Boolean hideScheduler) {
    this.hideScheduler = hideScheduler;
    return this;
  }

  /**
   * Hide the scheduler for content items.
   * @return hideScheduler
   */
  @javax.annotation.Nonnull
  public Boolean getHideScheduler() {
    return hideScheduler;
  }

  public void setHideScheduler(Boolean hideScheduler) {
    this.hideScheduler = hideScheduler;
  }
  public AppSettingsDto hideDateTimeModeButton(Boolean hideDateTimeModeButton) {
    this.hideDateTimeModeButton = hideDateTimeModeButton;
    return this;
  }

  /**
   * Hide the datetime mode button.
   * @return hideDateTimeModeButton
   */
  @javax.annotation.Nonnull
  public Boolean getHideDateTimeModeButton() {
    return hideDateTimeModeButton;
  }

  public void setHideDateTimeModeButton(Boolean hideDateTimeModeButton) {
    this.hideDateTimeModeButton = hideDateTimeModeButton;
  }
  public AppSettingsDto version(Long version) {
    this.version = version;
    return this;
  }

  /**
   * The version of the app.
   * @return version
   */
  @javax.annotation.Nonnull
  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppSettingsDto appSettingsDto = (AppSettingsDto) o;
    return Objects.equals(this.links, appSettingsDto.links) &&
        Objects.equals(this.patterns, appSettingsDto.patterns) &&
        Objects.equals(this.editors, appSettingsDto.editors) &&
        Objects.equals(this.hideScheduler, appSettingsDto.hideScheduler) &&
        Objects.equals(this.hideDateTimeModeButton, appSettingsDto.hideDateTimeModeButton) &&
        Objects.equals(this.version, appSettingsDto.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(links, patterns, editors, hideScheduler, hideDateTimeModeButton, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppSettingsDto {\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    patterns: ").append(toIndentedString(patterns)).append("\n");
    sb.append("    editors: ").append(toIndentedString(editors)).append("\n");
    sb.append("    hideScheduler: ").append(toIndentedString(hideScheduler)).append("\n");
    sb.append("    hideDateTimeModeButton: ").append(toIndentedString(hideDateTimeModeButton)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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
    openapiFields.add("patterns");
    openapiFields.add("editors");
    openapiFields.add("hideScheduler");
    openapiFields.add("hideDateTimeModeButton");
    openapiFields.add("version");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("_links");
    openapiRequiredFields.add("patterns");
    openapiRequiredFields.add("editors");
    openapiRequiredFields.add("hideScheduler");
    openapiRequiredFields.add("hideDateTimeModeButton");
    openapiRequiredFields.add("version");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to AppSettingsDto
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!AppSettingsDto.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in AppSettingsDto is not found in the empty JSON string", AppSettingsDto.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!AppSettingsDto.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `AppSettingsDto` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : AppSettingsDto.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // ensure the json data is an array
      if (!jsonObj.get("patterns").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `patterns` to be an array in the JSON string but got `%s`", jsonObj.get("patterns").toString()));
      }

      JsonArray jsonArraypatterns = jsonObj.getAsJsonArray("patterns");
      // validate the required field `patterns` (array)
      for (int i = 0; i < jsonArraypatterns.size(); i++) {
        PatternDto.validateJsonElement(jsonArraypatterns.get(i));
      };
      // ensure the json data is an array
      if (!jsonObj.get("editors").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `editors` to be an array in the JSON string but got `%s`", jsonObj.get("editors").toString()));
      }

      JsonArray jsonArrayeditors = jsonObj.getAsJsonArray("editors");
      // validate the required field `editors` (array)
      for (int i = 0; i < jsonArrayeditors.size(); i++) {
        EditorDto.validateJsonElement(jsonArrayeditors.get(i));
      };
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!AppSettingsDto.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'AppSettingsDto' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<AppSettingsDto> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(AppSettingsDto.class));

       return (TypeAdapter<T>) new TypeAdapter<AppSettingsDto>() {
           @Override
           public void write(JsonWriter out, AppSettingsDto value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public AppSettingsDto read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of AppSettingsDto given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of AppSettingsDto
   * @throws IOException if the JSON string is invalid with respect to AppSettingsDto
   */
  public static AppSettingsDto fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, AppSettingsDto.class);
  }

  /**
   * Convert an instance of AppSettingsDto to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
