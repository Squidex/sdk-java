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
import com.squidex.api.types.NumberFieldEditor;
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
 * NumberFieldPropertiesDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.9.0-SNAPSHOT")
public class NumberFieldPropertiesDto extends FieldPropertiesDto {
  public static final String SERIALIZED_NAME_DEFAULT_VALUES = "defaultValues";
  @SerializedName(SERIALIZED_NAME_DEFAULT_VALUES)
  private Map<String, Double> defaultValues = new HashMap<>();
  public static final String SERIALIZED_NAME_DEFAULT_VALUE = "defaultValue";
  @SerializedName(SERIALIZED_NAME_DEFAULT_VALUE)
  private Double defaultValue;
  public static final String SERIALIZED_NAME_MAX_VALUE = "maxValue";
  @SerializedName(SERIALIZED_NAME_MAX_VALUE)
  private Double maxValue;
  public static final String SERIALIZED_NAME_MIN_VALUE = "minValue";
  @SerializedName(SERIALIZED_NAME_MIN_VALUE)
  private Double minValue;
  public static final String SERIALIZED_NAME_ALLOWED_VALUES = "allowedValues";
  @SerializedName(SERIALIZED_NAME_ALLOWED_VALUES)
  private List<Double> allowedValues;
  public static final String SERIALIZED_NAME_IS_UNIQUE = "isUnique";
  @SerializedName(SERIALIZED_NAME_IS_UNIQUE)
  private Boolean isUnique;
  public static final String SERIALIZED_NAME_INLINE_EDITABLE = "inlineEditable";
  @SerializedName(SERIALIZED_NAME_INLINE_EDITABLE)
  private Boolean inlineEditable;
  public static final String SERIALIZED_NAME_EDITOR = "editor";
  @SerializedName(SERIALIZED_NAME_EDITOR)
  private NumberFieldEditor editor;
  public NumberFieldPropertiesDto() {
  }
  public NumberFieldPropertiesDto defaultValues(Map<String, Double> defaultValues) {
    this.defaultValues = defaultValues;
    return this;
  }

  public NumberFieldPropertiesDto putDefaultValuesItem(String key, Double defaultValuesItem) {
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
  public Map<String, Double> getDefaultValues() {
    return defaultValues;
  }

  public void setDefaultValues(Map<String, Double> defaultValues) {
    this.defaultValues = defaultValues;
  }
  public NumberFieldPropertiesDto defaultValue(Double defaultValue) {
    this.defaultValue = defaultValue;
    return this;
  }

  /**
   * The default value for the field value.
   * @return defaultValue
   */
  @javax.annotation.Nullable
  public Double getDefaultValue() {
    return defaultValue;
  }

  public void setDefaultValue(Double defaultValue) {
    this.defaultValue = defaultValue;
  }
  public NumberFieldPropertiesDto maxValue(Double maxValue) {
    this.maxValue = maxValue;
    return this;
  }

  /**
   * The maximum allowed value for the field value.
   * @return maxValue
   */
  @javax.annotation.Nullable
  public Double getMaxValue() {
    return maxValue;
  }

  public void setMaxValue(Double maxValue) {
    this.maxValue = maxValue;
  }
  public NumberFieldPropertiesDto minValue(Double minValue) {
    this.minValue = minValue;
    return this;
  }

  /**
   * The minimum allowed value for the field value.
   * @return minValue
   */
  @javax.annotation.Nullable
  public Double getMinValue() {
    return minValue;
  }

  public void setMinValue(Double minValue) {
    this.minValue = minValue;
  }
  public NumberFieldPropertiesDto allowedValues(List<Double> allowedValues) {
    this.allowedValues = allowedValues;
    return this;
  }

  public NumberFieldPropertiesDto addAllowedValuesItem(Double allowedValuesItem) {
    if (this.allowedValues == null) {
      this.allowedValues = new ArrayList<>();
    }
    this.allowedValues.add(allowedValuesItem);
    return this;
  }

  /**
   * The allowed values for the field value.
   * @return allowedValues
   */
  @javax.annotation.Nullable
  public List<Double> getAllowedValues() {
    return allowedValues;
  }

  public void setAllowedValues(List<Double> allowedValues) {
    this.allowedValues = allowedValues;
  }
  public NumberFieldPropertiesDto isUnique(Boolean isUnique) {
    this.isUnique = isUnique;
    return this;
  }

  /**
   * Indicates if the field value must be unique. Ignored for nested fields and localized fields.
   * @return isUnique
   */
  @javax.annotation.Nullable
  public Boolean getIsUnique() {
    return isUnique;
  }

  public void setIsUnique(Boolean isUnique) {
    this.isUnique = isUnique;
  }
  public NumberFieldPropertiesDto inlineEditable(Boolean inlineEditable) {
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
  public NumberFieldPropertiesDto editor(NumberFieldEditor editor) {
    this.editor = editor;
    return this;
  }

  /**
   * Get editor
   * @return editor
   */
  @javax.annotation.Nullable
  public NumberFieldEditor getEditor() {
    return editor;
  }

  public void setEditor(NumberFieldEditor editor) {
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
    NumberFieldPropertiesDto numberFieldPropertiesDto = (NumberFieldPropertiesDto) o;
    return Objects.equals(this.defaultValues, numberFieldPropertiesDto.defaultValues) &&
        Objects.equals(this.defaultValue, numberFieldPropertiesDto.defaultValue) &&
        Objects.equals(this.maxValue, numberFieldPropertiesDto.maxValue) &&
        Objects.equals(this.minValue, numberFieldPropertiesDto.minValue) &&
        Objects.equals(this.allowedValues, numberFieldPropertiesDto.allowedValues) &&
        Objects.equals(this.isUnique, numberFieldPropertiesDto.isUnique) &&
        Objects.equals(this.inlineEditable, numberFieldPropertiesDto.inlineEditable) &&
        Objects.equals(this.editor, numberFieldPropertiesDto.editor) &&
        super.equals(o);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(defaultValues, defaultValue, maxValue, minValue, allowedValues, isUnique, inlineEditable, editor, super.hashCode());
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
    sb.append("class NumberFieldPropertiesDto {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    defaultValues: ").append(toIndentedString(defaultValues)).append("\n");
    sb.append("    defaultValue: ").append(toIndentedString(defaultValue)).append("\n");
    sb.append("    maxValue: ").append(toIndentedString(maxValue)).append("\n");
    sb.append("    minValue: ").append(toIndentedString(minValue)).append("\n");
    sb.append("    allowedValues: ").append(toIndentedString(allowedValues)).append("\n");
    sb.append("    isUnique: ").append(toIndentedString(isUnique)).append("\n");
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
    openapiFields.add("maxValue");
    openapiFields.add("minValue");
    openapiFields.add("allowedValues");
    openapiFields.add("isUnique");
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
   * @throws IOException if the JSON Element is invalid with respect to NumberFieldPropertiesDto
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!NumberFieldPropertiesDto.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in NumberFieldPropertiesDto is not found in the empty JSON string", NumberFieldPropertiesDto.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!NumberFieldPropertiesDto.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `NumberFieldPropertiesDto` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : NumberFieldPropertiesDto.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!NumberFieldPropertiesDto.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'NumberFieldPropertiesDto' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<NumberFieldPropertiesDto> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(NumberFieldPropertiesDto.class));

       return (TypeAdapter<T>) new TypeAdapter<NumberFieldPropertiesDto>() {
           @Override
           public void write(JsonWriter out, NumberFieldPropertiesDto value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public NumberFieldPropertiesDto read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of NumberFieldPropertiesDto given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of NumberFieldPropertiesDto
   * @throws IOException if the JSON string is invalid with respect to NumberFieldPropertiesDto
   */
  public static NumberFieldPropertiesDto fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, NumberFieldPropertiesDto.class);
  }

  /**
   * Convert an instance of NumberFieldPropertiesDto to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
