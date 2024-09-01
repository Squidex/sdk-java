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
 * RuleActionDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.9.0-SNAPSHOT")
public class RuleActionDto {
  public RuleActionDto() {
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RuleActionDto ruleActionDto = (RuleActionDto) o;
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(true);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RuleActionDto {\n");
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
    openapiFields.add("actionType");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("actionType");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to RuleActionDto
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!RuleActionDto.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RuleActionDto is not found in the empty JSON string", RuleActionDto.openapiRequiredFields.toString()));
        }
      }

      String discriminatorValue = jsonElement.getAsJsonObject().get("actionType").getAsString();
      switch (discriminatorValue) {
        case "Algolia":
          AlgoliaRuleActionDto.validateJsonElement(jsonElement);
          break;
        case "AzureQueue":
          AzureQueueRuleActionDto.validateJsonElement(jsonElement);
          break;
        case "Comment":
          CommentRuleActionDto.validateJsonElement(jsonElement);
          break;
        case "CreateContent":
          CreateContentRuleActionDto.validateJsonElement(jsonElement);
          break;
        case "Discourse":
          DiscourseRuleActionDto.validateJsonElement(jsonElement);
          break;
        case "ElasticSearch":
          ElasticSearchRuleActionDto.validateJsonElement(jsonElement);
          break;
        case "Email":
          EmailRuleActionDto.validateJsonElement(jsonElement);
          break;
        case "Fastly":
          FastlyRuleActionDto.validateJsonElement(jsonElement);
          break;
        case "Medium":
          MediumRuleActionDto.validateJsonElement(jsonElement);
          break;
        case "Notification":
          NotificationRuleActionDto.validateJsonElement(jsonElement);
          break;
        case "OpenSearch":
          OpenSearchRuleActionDto.validateJsonElement(jsonElement);
          break;
        case "Prerender":
          PrerenderRuleActionDto.validateJsonElement(jsonElement);
          break;
        case "Script":
          ScriptRuleActionDto.validateJsonElement(jsonElement);
          break;
        case "SignalR":
          SignalRRuleActionDto.validateJsonElement(jsonElement);
          break;
        case "Slack":
          SlackRuleActionDto.validateJsonElement(jsonElement);
          break;
        case "Tweet":
          TweetRuleActionDto.validateJsonElement(jsonElement);
          break;
        case "Typesense":
          TypesenseRuleActionDto.validateJsonElement(jsonElement);
          break;
        case "Webhook":
          WebhookRuleActionDto.validateJsonElement(jsonElement);
          break;
        default:
          throw new IllegalArgumentException(String.format("The value of the `actionType` field `%s` does not match any key defined in the discriminator's mapping.", discriminatorValue));
      }
  }


  /**
   * Create an instance of RuleActionDto given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of RuleActionDto
   * @throws IOException if the JSON string is invalid with respect to RuleActionDto
   */
  public static RuleActionDto fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RuleActionDto.class);
  }

  /**
   * Convert an instance of RuleActionDto to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
