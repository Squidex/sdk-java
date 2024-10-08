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
import com.squidex.api.types.StringContentType;
import com.squidex.api.types.StringFieldEditor;
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
 * StringFieldPropertiesDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.9.0-SNAPSHOT")
public class StringFieldPropertiesDto extends FieldPropertiesDto {
  public static final String SERIALIZED_NAME_DEFAULT_VALUES = "defaultValues";
  @SerializedName(SERIALIZED_NAME_DEFAULT_VALUES)
  private Map<String, String> defaultValues = new HashMap<>();
  public static final String SERIALIZED_NAME_DEFAULT_VALUE = "defaultValue";
  @SerializedName(SERIALIZED_NAME_DEFAULT_VALUE)
  private String defaultValue;
  public static final String SERIALIZED_NAME_PATTERN = "pattern";
  @SerializedName(SERIALIZED_NAME_PATTERN)
  private String pattern;
  public static final String SERIALIZED_NAME_PATTERN_MESSAGE = "patternMessage";
  @SerializedName(SERIALIZED_NAME_PATTERN_MESSAGE)
  private String patternMessage;
  public static final String SERIALIZED_NAME_FOLDER_ID = "folderId";
  @SerializedName(SERIALIZED_NAME_FOLDER_ID)
  private String folderId;
  public static final String SERIALIZED_NAME_MIN_LENGTH = "minLength";
  @SerializedName(SERIALIZED_NAME_MIN_LENGTH)
  private Integer minLength;
  public static final String SERIALIZED_NAME_MAX_LENGTH = "maxLength";
  @SerializedName(SERIALIZED_NAME_MAX_LENGTH)
  private Integer maxLength;
  public static final String SERIALIZED_NAME_MIN_CHARACTERS = "minCharacters";
  @SerializedName(SERIALIZED_NAME_MIN_CHARACTERS)
  private Integer minCharacters;
  public static final String SERIALIZED_NAME_MAX_CHARACTERS = "maxCharacters";
  @SerializedName(SERIALIZED_NAME_MAX_CHARACTERS)
  private Integer maxCharacters;
  public static final String SERIALIZED_NAME_MIN_WORDS = "minWords";
  @SerializedName(SERIALIZED_NAME_MIN_WORDS)
  private Integer minWords;
  public static final String SERIALIZED_NAME_MAX_WORDS = "maxWords";
  @SerializedName(SERIALIZED_NAME_MAX_WORDS)
  private Integer maxWords;
  public static final String SERIALIZED_NAME_CLASS_NAMES = "classNames";
  @SerializedName(SERIALIZED_NAME_CLASS_NAMES)
  private List<String> classNames;
  public static final String SERIALIZED_NAME_ALLOWED_VALUES = "allowedValues";
  @SerializedName(SERIALIZED_NAME_ALLOWED_VALUES)
  private List<String> allowedValues;
  public static final String SERIALIZED_NAME_SCHEMA_IDS = "schemaIds";
  @SerializedName(SERIALIZED_NAME_SCHEMA_IDS)
  private List<String> schemaIds;
  public static final String SERIALIZED_NAME_IS_UNIQUE = "isUnique";
  @SerializedName(SERIALIZED_NAME_IS_UNIQUE)
  private Boolean isUnique;
  public static final String SERIALIZED_NAME_IS_EMBEDDABLE = "isEmbeddable";
  @SerializedName(SERIALIZED_NAME_IS_EMBEDDABLE)
  private Boolean isEmbeddable;
  public static final String SERIALIZED_NAME_INLINE_EDITABLE = "inlineEditable";
  @SerializedName(SERIALIZED_NAME_INLINE_EDITABLE)
  private Boolean inlineEditable;
  public static final String SERIALIZED_NAME_CREATE_ENUM = "createEnum";
  @SerializedName(SERIALIZED_NAME_CREATE_ENUM)
  private Boolean createEnum;
  public static final String SERIALIZED_NAME_CONTENT_TYPE = "contentType";
  @SerializedName(SERIALIZED_NAME_CONTENT_TYPE)
  private StringContentType contentType;
  public static final String SERIALIZED_NAME_EDITOR = "editor";
  @SerializedName(SERIALIZED_NAME_EDITOR)
  private StringFieldEditor editor;
  public StringFieldPropertiesDto() {
  }
  public StringFieldPropertiesDto defaultValues(Map<String, String> defaultValues) {
    this.defaultValues = defaultValues;
    return this;
  }

  public StringFieldPropertiesDto putDefaultValuesItem(String key, String defaultValuesItem) {
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
  public Map<String, String> getDefaultValues() {
    return defaultValues;
  }

  public void setDefaultValues(Map<String, String> defaultValues) {
    this.defaultValues = defaultValues;
  }
  public StringFieldPropertiesDto defaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
    return this;
  }

  /**
   * The default value for the field value.
   * @return defaultValue
   */
  @javax.annotation.Nullable
  public String getDefaultValue() {
    return defaultValue;
  }

  public void setDefaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
  }
  public StringFieldPropertiesDto pattern(String pattern) {
    this.pattern = pattern;
    return this;
  }

  /**
   * The pattern to enforce a specific format for the field value.
   * @return pattern
   */
  @javax.annotation.Nullable
  public String getPattern() {
    return pattern;
  }

  public void setPattern(String pattern) {
    this.pattern = pattern;
  }
  public StringFieldPropertiesDto patternMessage(String patternMessage) {
    this.patternMessage = patternMessage;
    return this;
  }

  /**
   * The validation message for the pattern.
   * @return patternMessage
   */
  @javax.annotation.Nullable
  public String getPatternMessage() {
    return patternMessage;
  }

  public void setPatternMessage(String patternMessage) {
    this.patternMessage = patternMessage;
  }
  public StringFieldPropertiesDto folderId(String folderId) {
    this.folderId = folderId;
    return this;
  }

  /**
   * The initial id to the folder when the control supports file uploads.
   * @return folderId
   */
  @javax.annotation.Nullable
  public String getFolderId() {
    return folderId;
  }

  public void setFolderId(String folderId) {
    this.folderId = folderId;
  }
  public StringFieldPropertiesDto minLength(Integer minLength) {
    this.minLength = minLength;
    return this;
  }

  /**
   * The minimum allowed length for the field value.
   * @return minLength
   */
  @javax.annotation.Nullable
  public Integer getMinLength() {
    return minLength;
  }

  public void setMinLength(Integer minLength) {
    this.minLength = minLength;
  }
  public StringFieldPropertiesDto maxLength(Integer maxLength) {
    this.maxLength = maxLength;
    return this;
  }

  /**
   * The maximum allowed length for the field value.
   * @return maxLength
   */
  @javax.annotation.Nullable
  public Integer getMaxLength() {
    return maxLength;
  }

  public void setMaxLength(Integer maxLength) {
    this.maxLength = maxLength;
  }
  public StringFieldPropertiesDto minCharacters(Integer minCharacters) {
    this.minCharacters = minCharacters;
    return this;
  }

  /**
   * The minimum allowed of normal characters for the field value.
   * @return minCharacters
   */
  @javax.annotation.Nullable
  public Integer getMinCharacters() {
    return minCharacters;
  }

  public void setMinCharacters(Integer minCharacters) {
    this.minCharacters = minCharacters;
  }
  public StringFieldPropertiesDto maxCharacters(Integer maxCharacters) {
    this.maxCharacters = maxCharacters;
    return this;
  }

  /**
   * The maximum allowed of normal characters for the field value.
   * @return maxCharacters
   */
  @javax.annotation.Nullable
  public Integer getMaxCharacters() {
    return maxCharacters;
  }

  public void setMaxCharacters(Integer maxCharacters) {
    this.maxCharacters = maxCharacters;
  }
  public StringFieldPropertiesDto minWords(Integer minWords) {
    this.minWords = minWords;
    return this;
  }

  /**
   * The minimum allowed number of words for the field value.
   * @return minWords
   */
  @javax.annotation.Nullable
  public Integer getMinWords() {
    return minWords;
  }

  public void setMinWords(Integer minWords) {
    this.minWords = minWords;
  }
  public StringFieldPropertiesDto maxWords(Integer maxWords) {
    this.maxWords = maxWords;
    return this;
  }

  /**
   * The maximum allowed number of words for the field value.
   * @return maxWords
   */
  @javax.annotation.Nullable
  public Integer getMaxWords() {
    return maxWords;
  }

  public void setMaxWords(Integer maxWords) {
    this.maxWords = maxWords;
  }
  public StringFieldPropertiesDto classNames(List<String> classNames) {
    this.classNames = classNames;
    return this;
  }

  public StringFieldPropertiesDto addClassNamesItem(String classNamesItem) {
    if (this.classNames == null) {
      this.classNames = new ArrayList<>();
    }
    this.classNames.add(classNamesItem);
    return this;
  }

  /**
   * The class names for the editor.
   * @return classNames
   */
  @javax.annotation.Nullable
  public List<String> getClassNames() {
    return classNames;
  }

  public void setClassNames(List<String> classNames) {
    this.classNames = classNames;
  }
  public StringFieldPropertiesDto allowedValues(List<String> allowedValues) {
    this.allowedValues = allowedValues;
    return this;
  }

  public StringFieldPropertiesDto addAllowedValuesItem(String allowedValuesItem) {
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
  public List<String> getAllowedValues() {
    return allowedValues;
  }

  public void setAllowedValues(List<String> allowedValues) {
    this.allowedValues = allowedValues;
  }
  public StringFieldPropertiesDto schemaIds(List<String> schemaIds) {
    this.schemaIds = schemaIds;
    return this;
  }

  public StringFieldPropertiesDto addSchemaIdsItem(String schemaIdsItem) {
    if (this.schemaIds == null) {
      this.schemaIds = new ArrayList<>();
    }
    this.schemaIds.add(schemaIdsItem);
    return this;
  }

  /**
   * The allowed schema ids that can be embedded.
   * @return schemaIds
   */
  @javax.annotation.Nullable
  public List<String> getSchemaIds() {
    return schemaIds;
  }

  public void setSchemaIds(List<String> schemaIds) {
    this.schemaIds = schemaIds;
  }
  public StringFieldPropertiesDto isUnique(Boolean isUnique) {
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
  public StringFieldPropertiesDto isEmbeddable(Boolean isEmbeddable) {
    this.isEmbeddable = isEmbeddable;
    return this;
  }

  /**
   * Indicates that other content items or references are embedded.
   * @return isEmbeddable
   */
  @javax.annotation.Nullable
  public Boolean getIsEmbeddable() {
    return isEmbeddable;
  }

  public void setIsEmbeddable(Boolean isEmbeddable) {
    this.isEmbeddable = isEmbeddable;
  }
  public StringFieldPropertiesDto inlineEditable(Boolean inlineEditable) {
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
  public StringFieldPropertiesDto createEnum(Boolean createEnum) {
    this.createEnum = createEnum;
    return this;
  }

  /**
   * Indicates whether GraphQL Enum should be created.
   * @return createEnum
   */
  @javax.annotation.Nullable
  public Boolean getCreateEnum() {
    return createEnum;
  }

  public void setCreateEnum(Boolean createEnum) {
    this.createEnum = createEnum;
  }
  public StringFieldPropertiesDto contentType(StringContentType contentType) {
    this.contentType = contentType;
    return this;
  }

  /**
   * Get contentType
   * @return contentType
   */
  @javax.annotation.Nullable
  public StringContentType getContentType() {
    return contentType;
  }

  public void setContentType(StringContentType contentType) {
    this.contentType = contentType;
  }
  public StringFieldPropertiesDto editor(StringFieldEditor editor) {
    this.editor = editor;
    return this;
  }

  /**
   * Get editor
   * @return editor
   */
  @javax.annotation.Nullable
  public StringFieldEditor getEditor() {
    return editor;
  }

  public void setEditor(StringFieldEditor editor) {
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
    StringFieldPropertiesDto stringFieldPropertiesDto = (StringFieldPropertiesDto) o;
    return Objects.equals(this.defaultValues, stringFieldPropertiesDto.defaultValues) &&
        Objects.equals(this.defaultValue, stringFieldPropertiesDto.defaultValue) &&
        Objects.equals(this.pattern, stringFieldPropertiesDto.pattern) &&
        Objects.equals(this.patternMessage, stringFieldPropertiesDto.patternMessage) &&
        Objects.equals(this.folderId, stringFieldPropertiesDto.folderId) &&
        Objects.equals(this.minLength, stringFieldPropertiesDto.minLength) &&
        Objects.equals(this.maxLength, stringFieldPropertiesDto.maxLength) &&
        Objects.equals(this.minCharacters, stringFieldPropertiesDto.minCharacters) &&
        Objects.equals(this.maxCharacters, stringFieldPropertiesDto.maxCharacters) &&
        Objects.equals(this.minWords, stringFieldPropertiesDto.minWords) &&
        Objects.equals(this.maxWords, stringFieldPropertiesDto.maxWords) &&
        Objects.equals(this.classNames, stringFieldPropertiesDto.classNames) &&
        Objects.equals(this.allowedValues, stringFieldPropertiesDto.allowedValues) &&
        Objects.equals(this.schemaIds, stringFieldPropertiesDto.schemaIds) &&
        Objects.equals(this.isUnique, stringFieldPropertiesDto.isUnique) &&
        Objects.equals(this.isEmbeddable, stringFieldPropertiesDto.isEmbeddable) &&
        Objects.equals(this.inlineEditable, stringFieldPropertiesDto.inlineEditable) &&
        Objects.equals(this.createEnum, stringFieldPropertiesDto.createEnum) &&
        Objects.equals(this.contentType, stringFieldPropertiesDto.contentType) &&
        Objects.equals(this.editor, stringFieldPropertiesDto.editor) &&
        super.equals(o);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(defaultValues, defaultValue, pattern, patternMessage, folderId, minLength, maxLength, minCharacters, maxCharacters, minWords, maxWords, classNames, allowedValues, schemaIds, isUnique, isEmbeddable, inlineEditable, createEnum, contentType, editor, super.hashCode());
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
    sb.append("class StringFieldPropertiesDto {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    defaultValues: ").append(toIndentedString(defaultValues)).append("\n");
    sb.append("    defaultValue: ").append(toIndentedString(defaultValue)).append("\n");
    sb.append("    pattern: ").append(toIndentedString(pattern)).append("\n");
    sb.append("    patternMessage: ").append(toIndentedString(patternMessage)).append("\n");
    sb.append("    folderId: ").append(toIndentedString(folderId)).append("\n");
    sb.append("    minLength: ").append(toIndentedString(minLength)).append("\n");
    sb.append("    maxLength: ").append(toIndentedString(maxLength)).append("\n");
    sb.append("    minCharacters: ").append(toIndentedString(minCharacters)).append("\n");
    sb.append("    maxCharacters: ").append(toIndentedString(maxCharacters)).append("\n");
    sb.append("    minWords: ").append(toIndentedString(minWords)).append("\n");
    sb.append("    maxWords: ").append(toIndentedString(maxWords)).append("\n");
    sb.append("    classNames: ").append(toIndentedString(classNames)).append("\n");
    sb.append("    allowedValues: ").append(toIndentedString(allowedValues)).append("\n");
    sb.append("    schemaIds: ").append(toIndentedString(schemaIds)).append("\n");
    sb.append("    isUnique: ").append(toIndentedString(isUnique)).append("\n");
    sb.append("    isEmbeddable: ").append(toIndentedString(isEmbeddable)).append("\n");
    sb.append("    inlineEditable: ").append(toIndentedString(inlineEditable)).append("\n");
    sb.append("    createEnum: ").append(toIndentedString(createEnum)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
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
    openapiFields.add("pattern");
    openapiFields.add("patternMessage");
    openapiFields.add("folderId");
    openapiFields.add("minLength");
    openapiFields.add("maxLength");
    openapiFields.add("minCharacters");
    openapiFields.add("maxCharacters");
    openapiFields.add("minWords");
    openapiFields.add("maxWords");
    openapiFields.add("classNames");
    openapiFields.add("allowedValues");
    openapiFields.add("schemaIds");
    openapiFields.add("isUnique");
    openapiFields.add("isEmbeddable");
    openapiFields.add("inlineEditable");
    openapiFields.add("createEnum");
    openapiFields.add("contentType");
    openapiFields.add("editor");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("fieldType");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to StringFieldPropertiesDto
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!StringFieldPropertiesDto.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in StringFieldPropertiesDto is not found in the empty JSON string", StringFieldPropertiesDto.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!StringFieldPropertiesDto.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `StringFieldPropertiesDto` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : StringFieldPropertiesDto.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!StringFieldPropertiesDto.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'StringFieldPropertiesDto' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<StringFieldPropertiesDto> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(StringFieldPropertiesDto.class));

       return (TypeAdapter<T>) new TypeAdapter<StringFieldPropertiesDto>() {
           @Override
           public void write(JsonWriter out, StringFieldPropertiesDto value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public StringFieldPropertiesDto read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of StringFieldPropertiesDto given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of StringFieldPropertiesDto
   * @throws IOException if the JSON string is invalid with respect to StringFieldPropertiesDto
   */
  public static StringFieldPropertiesDto fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, StringFieldPropertiesDto.class);
  }

  /**
   * Convert an instance of StringFieldPropertiesDto to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
