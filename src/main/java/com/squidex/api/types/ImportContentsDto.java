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
import java.util.ArrayList;
import java.util.Arrays;
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
 * ImportContentsDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.9.0-SNAPSHOT")
public class ImportContentsDto {
  public static final String SERIALIZED_NAME_DATAS = "datas";
  @SerializedName(SERIALIZED_NAME_DATAS)
  private List<Map<String, Map<String, Object>>> datas = new ArrayList<>();
  public static final String SERIALIZED_NAME_PUBLISH = "publish";
  @Deprecated
  @SerializedName(SERIALIZED_NAME_PUBLISH)
  private Boolean publish;
  public static final String SERIALIZED_NAME_DO_NOT_SCRIPT = "doNotScript";
  @SerializedName(SERIALIZED_NAME_DO_NOT_SCRIPT)
  private Boolean doNotScript;
  public static final String SERIALIZED_NAME_OPTIMIZE_VALIDATION = "optimizeValidation";
  @SerializedName(SERIALIZED_NAME_OPTIMIZE_VALIDATION)
  private Boolean optimizeValidation;
  public ImportContentsDto() {
  }
  public ImportContentsDto datas(List<Map<String, Map<String, Object>>> datas) {
    this.datas = datas;
    return this;
  }

  public ImportContentsDto addDatasItem(Map<String, Map<String, Object>> datasItem) {
    if (this.datas == null) {
      this.datas = new ArrayList<>();
    }
    this.datas.add(datasItem);
    return this;
  }

  /**
   * The data to import.
   * @return datas
   */
  @javax.annotation.Nonnull
  public List<Map<String, Map<String, Object>>> getDatas() {
    return datas;
  }

  public void setDatas(List<Map<String, Map<String, Object>>> datas) {
    this.datas = datas;
  }
  @Deprecated
  public ImportContentsDto publish(Boolean publish) {
    this.publish = publish;
    return this;
  }

  /**
   * True to automatically publish the content.
   * @return publish
   * @deprecated
   */
  @Deprecated
  @javax.annotation.Nullable
  public Boolean getPublish() {
    return publish;
  }

  @Deprecated
  public void setPublish(Boolean publish) {
    this.publish = publish;
  }
  public ImportContentsDto doNotScript(Boolean doNotScript) {
    this.doNotScript = doNotScript;
    return this;
  }

  /**
   * True to turn off scripting for faster inserts. Default: true.
   * @return doNotScript
   */
  @javax.annotation.Nullable
  public Boolean getDoNotScript() {
    return doNotScript;
  }

  public void setDoNotScript(Boolean doNotScript) {
    this.doNotScript = doNotScript;
  }
  public ImportContentsDto optimizeValidation(Boolean optimizeValidation) {
    this.optimizeValidation = optimizeValidation;
    return this;
  }

  /**
   * True to turn off costly validation: Unique checks, asset checks and reference checks. Default: true.
   * @return optimizeValidation
   */
  @javax.annotation.Nullable
  public Boolean getOptimizeValidation() {
    return optimizeValidation;
  }

  public void setOptimizeValidation(Boolean optimizeValidation) {
    this.optimizeValidation = optimizeValidation;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImportContentsDto importContentsDto = (ImportContentsDto) o;
    return Objects.equals(this.datas, importContentsDto.datas) &&
        Objects.equals(this.publish, importContentsDto.publish) &&
        Objects.equals(this.doNotScript, importContentsDto.doNotScript) &&
        Objects.equals(this.optimizeValidation, importContentsDto.optimizeValidation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(datas, publish, doNotScript, optimizeValidation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImportContentsDto {\n");
    sb.append("    datas: ").append(toIndentedString(datas)).append("\n");
    sb.append("    publish: ").append(toIndentedString(publish)).append("\n");
    sb.append("    doNotScript: ").append(toIndentedString(doNotScript)).append("\n");
    sb.append("    optimizeValidation: ").append(toIndentedString(optimizeValidation)).append("\n");
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
    openapiFields.add("datas");
    openapiFields.add("publish");
    openapiFields.add("doNotScript");
    openapiFields.add("optimizeValidation");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("datas");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to ImportContentsDto
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ImportContentsDto.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ImportContentsDto is not found in the empty JSON string", ImportContentsDto.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ImportContentsDto.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ImportContentsDto` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : ImportContentsDto.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // ensure the required json array is present
      if (jsonObj.get("datas") == null) {
        throw new IllegalArgumentException("Expected the field `linkedContent` to be an array in the JSON string but got `null`");
      } else if (!jsonObj.get("datas").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `datas` to be an array in the JSON string but got `%s`", jsonObj.get("datas").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ImportContentsDto.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ImportContentsDto' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ImportContentsDto> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ImportContentsDto.class));

       return (TypeAdapter<T>) new TypeAdapter<ImportContentsDto>() {
           @Override
           public void write(JsonWriter out, ImportContentsDto value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ImportContentsDto read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of ImportContentsDto given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of ImportContentsDto
   * @throws IOException if the JSON string is invalid with respect to ImportContentsDto
   */
  public static ImportContentsDto fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ImportContentsDto.class);
  }

  /**
   * Convert an instance of ImportContentsDto to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
