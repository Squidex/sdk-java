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
import com.squidex.api.types.BooleanFieldEditor;
import com.squidex.api.types.FieldPropertiesDto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
 * BooleanFieldPropertiesDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.9.0-SNAPSHOT")
public class BooleanFieldPropertiesDto extends FieldPropertiesDto {
  public static final String SERIALIZED_NAME_DEFAULT_VALUES = "defaultValues";
  @SerializedName(SERIALIZED_NAME_DEFAULT_VALUES)
  private Map<String, Boolean> defaultValues = new HashMap<>();
  public static final String SERIALIZED_NAME_DEFAULT_VALUE = "defaultValue";
  @SerializedName(SERIALIZED_NAME_DEFAULT_VALUE)
  private Boolean defaultValue;
  public static final String SERIALIZED_NAME_INLINE_EDITABLE = "inlineEditable";
  @SerializedName(SERIALIZED_NAME_INLINE_EDITABLE)
  private Boolean inlineEditable;
  public static final String SERIALIZED_NAME_EDITOR = "editor";
  @SerializedName(SERIALIZED_NAME_EDITOR)
  private BooleanFieldEditor editor;
  public BooleanFieldPropertiesDto() {
  }
  public BooleanFieldPropertiesDto defaultValues(Map<String, Boolean> defaultValues) {
    this.defaultValues = defaultValues;
    return this;
  }

  public BooleanFieldPropertiesDto putDefaultValuesItem(String key, Boolean defaultValuesItem) {
    if (this.defaultValues == null) {
      this.defaultValues = new HashMap<>();
    }
    this.defaultValues.put(key, defaultValuesItem);
    return this;
  }

  /**
   * Get defaultValues
   * @return defaultValues
   */
  @javax.annotation.Nullable
  public Map<String, Boolean> getDefaultValues() {
    return defaultValues;
  }

  public void setDefaultValues(Map<String, Boolean> defaultValues) {
    this.defaultValues = defaultValues;
  }
  public BooleanFieldPropertiesDto defaultValue(Boolean defaultValue) {
    this.defaultValue = defaultValue;
    return this;
  }

  /**
   * The default value for the field value.
   * @return defaultValue
   */
  @javax.annotation.Nullable
  public Boolean getDefaultValue() {
    return defaultValue;
  }

  public void setDefaultValue(Boolean defaultValue) {
    this.defaultValue = defaultValue;
  }
  public BooleanFieldPropertiesDto inlineEditable(Boolean inlineEditable) {
    this.inlineEditable = inlineEditable;
    return this;
  }

  /**
   * Indicates that the inline editor is enabled for this field.
   * @return inlineEditable
   */
  @javax.annotation.Nullable
  public Boolean getInlineEditable() {
    return inlineEditable;
  }

  public void setInlineEditable(Boolean inlineEditable) {
    this.inlineEditable = inlineEditable;
  }
  public BooleanFieldPropertiesDto editor(BooleanFieldEditor editor) {
    this.editor = editor;
    return this;
  }

  /**
   * Get editor
   * @return editor
   */
  @javax.annotation.Nullable
  public BooleanFieldEditor getEditor() {
    return editor;
  }

  public void setEditor(BooleanFieldEditor editor) {
    this.editor = editor;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BooleanFieldPropertiesDto booleanFieldPropertiesDto = (BooleanFieldPropertiesDto) o;
    return Objects.equals(this.defaultValues, booleanFieldPropertiesDto.defaultValues) &&
        Objects.equals(this.defaultValue, booleanFieldPropertiesDto.defaultValue) &&
        Objects.equals(this.inlineEditable, booleanFieldPropertiesDto.inlineEditable) &&
        Objects.equals(this.editor, booleanFieldPropertiesDto.editor) &&
        super.equals(o);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(defaultValues, defaultValue, inlineEditable, editor, super.hashCode());
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
    sb.append("class BooleanFieldPropertiesDto {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    defaultValues: ").append(toIndentedString(defaultValues)).append("\n");
    sb.append("    defaultValue: ").append(toIndentedString(defaultValue)).append("\n");
    sb.append("    inlineEditable: ").append(toIndentedString(inlineEditable)).append("\n");
    sb.append("    editor: ").append(toIndentedString(editor)).append("\n");
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
    openapiFields.add("defaultValues");
    openapiFields.add("defaultValue");
    openapiFields.add("inlineEditable");
    openapiFields.add("editor");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("fieldType");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to BooleanFieldPropertiesDto
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!BooleanFieldPropertiesDto.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in BooleanFieldPropertiesDto is not found in the empty JSON string", BooleanFieldPropertiesDto.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!BooleanFieldPropertiesDto.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `BooleanFieldPropertiesDto` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : BooleanFieldPropertiesDto.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!BooleanFieldPropertiesDto.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'BooleanFieldPropertiesDto' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<BooleanFieldPropertiesDto> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(BooleanFieldPropertiesDto.class));

       return (TypeAdapter<T>) new TypeAdapter<BooleanFieldPropertiesDto>() {
           @Override
           public void write(JsonWriter out, BooleanFieldPropertiesDto value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public BooleanFieldPropertiesDto read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of BooleanFieldPropertiesDto given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of BooleanFieldPropertiesDto
   * @throws IOException if the JSON string is invalid with respect to BooleanFieldPropertiesDto
   */
  public static BooleanFieldPropertiesDto fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, BooleanFieldPropertiesDto.class);
  }

  /**
   * Convert an instance of BooleanFieldPropertiesDto to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
