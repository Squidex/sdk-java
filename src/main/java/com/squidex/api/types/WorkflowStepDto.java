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
import com.squidex.api.types.WorkflowTransitionDto;
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
 * WorkflowStepDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.9.0-SNAPSHOT")
public class WorkflowStepDto {
  public static final String SERIALIZED_NAME_TRANSITIONS = "transitions";
  @SerializedName(SERIALIZED_NAME_TRANSITIONS)
  private Map<String, WorkflowTransitionDto> transitions = new HashMap<>();
  public static final String SERIALIZED_NAME_COLOR = "color";
  @SerializedName(SERIALIZED_NAME_COLOR)
  private String color;
  public static final String SERIALIZED_NAME_VALIDATE = "validate";
  @SerializedName(SERIALIZED_NAME_VALIDATE)
  private Boolean validate;
  public static final String SERIALIZED_NAME_NO_UPDATE = "noUpdate";
  @SerializedName(SERIALIZED_NAME_NO_UPDATE)
  private Boolean noUpdate;
  public static final String SERIALIZED_NAME_NO_UPDATE_EXPRESSION = "noUpdateExpression";
  @SerializedName(SERIALIZED_NAME_NO_UPDATE_EXPRESSION)
  private String noUpdateExpression;
  public static final String SERIALIZED_NAME_NO_UPDATE_ROLES = "noUpdateRoles";
  @SerializedName(SERIALIZED_NAME_NO_UPDATE_ROLES)
  private List<String> noUpdateRoles;
  public WorkflowStepDto() {
  }
  public WorkflowStepDto transitions(Map<String, WorkflowTransitionDto> transitions) {
    this.transitions = transitions;
    return this;
  }

  public WorkflowStepDto putTransitionsItem(String key, WorkflowTransitionDto transitionsItem) {
    if (this.transitions == null) {
      this.transitions = new HashMap<>();
    }
    this.transitions.put(key, transitionsItem);
    return this;
  }

  /**
   * The transitions.
   * @return transitions
   */
  @javax.annotation.Nullable
  public Map<String, WorkflowTransitionDto> getTransitions() {
    return transitions;
  }

  public void setTransitions(Map<String, WorkflowTransitionDto> transitions) {
    this.transitions = transitions;
  }
  public WorkflowStepDto color(String color) {
    this.color = color;
    return this;
  }

  /**
   * The optional color.
   * @return color
   */
  @javax.annotation.Nullable
  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
  public WorkflowStepDto validate(Boolean validate) {
    this.validate = validate;
    return this;
  }

  /**
   * True if the content should be validated when moving to this step.
   * @return validate
   */
  @javax.annotation.Nullable
  public Boolean getValidate() {
    return validate;
  }

  public void setValidate(Boolean validate) {
    this.validate = validate;
  }
  public WorkflowStepDto noUpdate(Boolean noUpdate) {
    this.noUpdate = noUpdate;
    return this;
  }

  /**
   * Indicates if updates should not be allowed.
   * @return noUpdate
   */
  @javax.annotation.Nullable
  public Boolean getNoUpdate() {
    return noUpdate;
  }

  public void setNoUpdate(Boolean noUpdate) {
    this.noUpdate = noUpdate;
  }
  public WorkflowStepDto noUpdateExpression(String noUpdateExpression) {
    this.noUpdateExpression = noUpdateExpression;
    return this;
  }

  /**
   * Optional expression that must evaluate to true when you want to prevent updates.
   * @return noUpdateExpression
   */
  @javax.annotation.Nullable
  public String getNoUpdateExpression() {
    return noUpdateExpression;
  }

  public void setNoUpdateExpression(String noUpdateExpression) {
    this.noUpdateExpression = noUpdateExpression;
  }
  public WorkflowStepDto noUpdateRoles(List<String> noUpdateRoles) {
    this.noUpdateRoles = noUpdateRoles;
    return this;
  }

  public WorkflowStepDto addNoUpdateRolesItem(String noUpdateRolesItem) {
    if (this.noUpdateRoles == null) {
      this.noUpdateRoles = new ArrayList<>();
    }
    this.noUpdateRoles.add(noUpdateRolesItem);
    return this;
  }

  /**
   * Optional list of roles to restrict the updates for users with these roles.
   * @return noUpdateRoles
   */
  @javax.annotation.Nullable
  public List<String> getNoUpdateRoles() {
    return noUpdateRoles;
  }

  public void setNoUpdateRoles(List<String> noUpdateRoles) {
    this.noUpdateRoles = noUpdateRoles;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkflowStepDto workflowStepDto = (WorkflowStepDto) o;
    return Objects.equals(this.transitions, workflowStepDto.transitions) &&
        Objects.equals(this.color, workflowStepDto.color) &&
        Objects.equals(this.validate, workflowStepDto.validate) &&
        Objects.equals(this.noUpdate, workflowStepDto.noUpdate) &&
        Objects.equals(this.noUpdateExpression, workflowStepDto.noUpdateExpression) &&
        Objects.equals(this.noUpdateRoles, workflowStepDto.noUpdateRoles);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(transitions, color, validate, noUpdate, noUpdateExpression, noUpdateRoles);
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
    sb.append("class WorkflowStepDto {\n");
    sb.append("    transitions: ").append(toIndentedString(transitions)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    validate: ").append(toIndentedString(validate)).append("\n");
    sb.append("    noUpdate: ").append(toIndentedString(noUpdate)).append("\n");
    sb.append("    noUpdateExpression: ").append(toIndentedString(noUpdateExpression)).append("\n");
    sb.append("    noUpdateRoles: ").append(toIndentedString(noUpdateRoles)).append("\n");
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
    openapiFields.add("transitions");
    openapiFields.add("color");
    openapiFields.add("validate");
    openapiFields.add("noUpdate");
    openapiFields.add("noUpdateExpression");
    openapiFields.add("noUpdateRoles");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to WorkflowStepDto
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!WorkflowStepDto.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in WorkflowStepDto is not found in the empty JSON string", WorkflowStepDto.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!WorkflowStepDto.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `WorkflowStepDto` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("color") != null && !jsonObj.get("color").isJsonNull()) && !jsonObj.get("color").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `color` to be a primitive type in the JSON string but got `%s`", jsonObj.get("color").toString()));
      }
      if ((jsonObj.get("noUpdateExpression") != null && !jsonObj.get("noUpdateExpression").isJsonNull()) && !jsonObj.get("noUpdateExpression").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `noUpdateExpression` to be a primitive type in the JSON string but got `%s`", jsonObj.get("noUpdateExpression").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("noUpdateRoles") != null && !jsonObj.get("noUpdateRoles").isJsonNull() && !jsonObj.get("noUpdateRoles").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `noUpdateRoles` to be an array in the JSON string but got `%s`", jsonObj.get("noUpdateRoles").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!WorkflowStepDto.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'WorkflowStepDto' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<WorkflowStepDto> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(WorkflowStepDto.class));

       return (TypeAdapter<T>) new TypeAdapter<WorkflowStepDto>() {
           @Override
           public void write(JsonWriter out, WorkflowStepDto value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public WorkflowStepDto read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of WorkflowStepDto given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of WorkflowStepDto
   * @throws IOException if the JSON string is invalid with respect to WorkflowStepDto
   */
  public static WorkflowStepDto fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, WorkflowStepDto.class);
  }

  /**
   * Convert an instance of WorkflowStepDto to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
