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
import com.squidex.api.types.RuleActionDto;
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
 * EmailRuleActionDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.9.0-SNAPSHOT")
public class EmailRuleActionDto extends RuleActionDto {
  public static final String SERIALIZED_NAME_SERVER_HOST = "serverHost";
  @SerializedName(SERIALIZED_NAME_SERVER_HOST)
  private String serverHost;
  public static final String SERIALIZED_NAME_SERVER_PORT = "serverPort";
  @SerializedName(SERIALIZED_NAME_SERVER_PORT)
  private Integer serverPort;
  public static final String SERIALIZED_NAME_SERVER_USERNAME = "serverUsername";
  @SerializedName(SERIALIZED_NAME_SERVER_USERNAME)
  private String serverUsername;
  public static final String SERIALIZED_NAME_SERVER_PASSWORD = "serverPassword";
  @SerializedName(SERIALIZED_NAME_SERVER_PASSWORD)
  private String serverPassword;
  public static final String SERIALIZED_NAME_MESSAGE_FROM = "messageFrom";
  @SerializedName(SERIALIZED_NAME_MESSAGE_FROM)
  private String messageFrom;
  public static final String SERIALIZED_NAME_MESSAGE_TO = "messageTo";
  @SerializedName(SERIALIZED_NAME_MESSAGE_TO)
  private String messageTo;
  public static final String SERIALIZED_NAME_MESSAGE_SUBJECT = "messageSubject";
  @SerializedName(SERIALIZED_NAME_MESSAGE_SUBJECT)
  private String messageSubject;
  public static final String SERIALIZED_NAME_MESSAGE_BODY = "messageBody";
  @SerializedName(SERIALIZED_NAME_MESSAGE_BODY)
  private String messageBody;
  public EmailRuleActionDto() {
  }
  public EmailRuleActionDto serverHost(String serverHost) {
    this.serverHost = serverHost;
    return this;
  }

  /**
   * The IP address or host to the SMTP server.
   * @return serverHost
   */
  @javax.annotation.Nonnull
  public String getServerHost() {
    return serverHost;
  }

  public void setServerHost(String serverHost) {
    this.serverHost = serverHost;
  }
  public EmailRuleActionDto serverPort(Integer serverPort) {
    this.serverPort = serverPort;
    return this;
  }

  /**
   * The port to the SMTP server.
   * @return serverPort
   */
  @javax.annotation.Nonnull
  public Integer getServerPort() {
    return serverPort;
  }

  public void setServerPort(Integer serverPort) {
    this.serverPort = serverPort;
  }
  public EmailRuleActionDto serverUsername(String serverUsername) {
    this.serverUsername = serverUsername;
    return this;
  }

  /**
   * The username for the SMTP server.
   * @return serverUsername
   */
  @javax.annotation.Nonnull
  public String getServerUsername() {
    return serverUsername;
  }

  public void setServerUsername(String serverUsername) {
    this.serverUsername = serverUsername;
  }
  public EmailRuleActionDto serverPassword(String serverPassword) {
    this.serverPassword = serverPassword;
    return this;
  }

  /**
   * The password for the SMTP server.
   * @return serverPassword
   */
  @javax.annotation.Nonnull
  public String getServerPassword() {
    return serverPassword;
  }

  public void setServerPassword(String serverPassword) {
    this.serverPassword = serverPassword;
  }
  public EmailRuleActionDto messageFrom(String messageFrom) {
    this.messageFrom = messageFrom;
    return this;
  }

  /**
   * The email sending address.
   * @return messageFrom
   */
  @javax.annotation.Nonnull
  public String getMessageFrom() {
    return messageFrom;
  }

  public void setMessageFrom(String messageFrom) {
    this.messageFrom = messageFrom;
  }
  public EmailRuleActionDto messageTo(String messageTo) {
    this.messageTo = messageTo;
    return this;
  }

  /**
   * The email message will be sent to.
   * @return messageTo
   */
  @javax.annotation.Nonnull
  public String getMessageTo() {
    return messageTo;
  }

  public void setMessageTo(String messageTo) {
    this.messageTo = messageTo;
  }
  public EmailRuleActionDto messageSubject(String messageSubject) {
    this.messageSubject = messageSubject;
    return this;
  }

  /**
   * The subject line for this email message.
   * @return messageSubject
   */
  @javax.annotation.Nonnull
  public String getMessageSubject() {
    return messageSubject;
  }

  public void setMessageSubject(String messageSubject) {
    this.messageSubject = messageSubject;
  }
  public EmailRuleActionDto messageBody(String messageBody) {
    this.messageBody = messageBody;
    return this;
  }

  /**
   * The message body.
   * @return messageBody
   */
  @javax.annotation.Nonnull
  public String getMessageBody() {
    return messageBody;
  }

  public void setMessageBody(String messageBody) {
    this.messageBody = messageBody;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmailRuleActionDto emailRuleActionDto = (EmailRuleActionDto) o;
    return Objects.equals(this.serverHost, emailRuleActionDto.serverHost) &&
        Objects.equals(this.serverPort, emailRuleActionDto.serverPort) &&
        Objects.equals(this.serverUsername, emailRuleActionDto.serverUsername) &&
        Objects.equals(this.serverPassword, emailRuleActionDto.serverPassword) &&
        Objects.equals(this.messageFrom, emailRuleActionDto.messageFrom) &&
        Objects.equals(this.messageTo, emailRuleActionDto.messageTo) &&
        Objects.equals(this.messageSubject, emailRuleActionDto.messageSubject) &&
        Objects.equals(this.messageBody, emailRuleActionDto.messageBody) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serverHost, serverPort, serverUsername, serverPassword, messageFrom, messageTo, messageSubject, messageBody, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmailRuleActionDto {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    serverHost: ").append(toIndentedString(serverHost)).append("\n");
    sb.append("    serverPort: ").append(toIndentedString(serverPort)).append("\n");
    sb.append("    serverUsername: ").append(toIndentedString(serverUsername)).append("\n");
    sb.append("    serverPassword: ").append(toIndentedString(serverPassword)).append("\n");
    sb.append("    messageFrom: ").append(toIndentedString(messageFrom)).append("\n");
    sb.append("    messageTo: ").append(toIndentedString(messageTo)).append("\n");
    sb.append("    messageSubject: ").append(toIndentedString(messageSubject)).append("\n");
    sb.append("    messageBody: ").append(toIndentedString(messageBody)).append("\n");
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
    openapiFields.add("serverHost");
    openapiFields.add("serverPort");
    openapiFields.add("serverUsername");
    openapiFields.add("serverPassword");
    openapiFields.add("messageFrom");
    openapiFields.add("messageTo");
    openapiFields.add("messageSubject");
    openapiFields.add("messageBody");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("serverHost");
    openapiRequiredFields.add("serverPort");
    openapiRequiredFields.add("serverUsername");
    openapiRequiredFields.add("serverPassword");
    openapiRequiredFields.add("messageFrom");
    openapiRequiredFields.add("messageTo");
    openapiRequiredFields.add("messageSubject");
    openapiRequiredFields.add("messageBody");
    openapiRequiredFields.add("actionType");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to EmailRuleActionDto
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!EmailRuleActionDto.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in EmailRuleActionDto is not found in the empty JSON string", EmailRuleActionDto.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!EmailRuleActionDto.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `EmailRuleActionDto` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : EmailRuleActionDto.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!EmailRuleActionDto.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'EmailRuleActionDto' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<EmailRuleActionDto> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(EmailRuleActionDto.class));

       return (TypeAdapter<T>) new TypeAdapter<EmailRuleActionDto>() {
           @Override
           public void write(JsonWriter out, EmailRuleActionDto value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public EmailRuleActionDto read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of EmailRuleActionDto given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of EmailRuleActionDto
   * @throws IOException if the JSON string is invalid with respect to EmailRuleActionDto
   */
  public static EmailRuleActionDto fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, EmailRuleActionDto.class);
  }

  /**
   * Convert an instance of EmailRuleActionDto to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
