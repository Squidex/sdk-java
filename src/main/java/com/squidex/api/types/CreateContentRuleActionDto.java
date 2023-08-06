package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CreateContentRuleActionDto.Builder.class)
public final class CreateContentRuleActionDto {
    private final String data;

    private final String schema;

    private final String client;

    private final boolean publish;

    private CreateContentRuleActionDto(String data, String schema, String client, boolean publish) {
        this.data = data;
        this.schema = schema;
        this.client = client;
        this.publish = publish;
    }

    /**
     * @return The content data. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("data")
    public String getData() {
        return data;
    }

    /**
     * @return The name of the schema. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("schema")
    public String getSchema() {
        return schema;
    }

    /**
     * @return An optional client name.
     */
    @JsonProperty("client")
    public String getClient() {
        return client;
    }

    /**
     * @return Publish the content.
     */
    @JsonProperty("publish")
    public boolean getPublish() {
        return publish;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateContentRuleActionDto && equalTo((CreateContentRuleActionDto) other);
    }

    private boolean equalTo(CreateContentRuleActionDto other) {
        return data.equals(other.data)
                && schema.equals(other.schema)
                && client.equals(other.client)
                && publish == other.publish;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.data, this.schema, this.client, this.publish);
    }

    @Override
    public String toString() {
        return "CreateContentRuleActionDto{" + "data: " + data + ", schema: " + schema + ", client: " + client
                + ", publish: " + publish + "}";
    }

    public static DataStage builder() {
        return new Builder();
    }

    public interface DataStage {
        SchemaStage data(String data);

        Builder from(CreateContentRuleActionDto other);
    }

    public interface SchemaStage {
        ClientStage schema(String schema);
    }

    public interface ClientStage {
        PublishStage client(String client);
    }

    public interface PublishStage {
        _FinalStage publish(boolean publish);
    }

    public interface _FinalStage {
        CreateContentRuleActionDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements DataStage, SchemaStage, ClientStage, PublishStage, _FinalStage {
        private String data;

        private String schema;

        private String client;

        private boolean publish;

        private Builder() {}

        @Override
        public Builder from(CreateContentRuleActionDto other) {
            data(other.getData());
            schema(other.getSchema());
            client(other.getClient());
            publish(other.getPublish());
            return this;
        }

        /**
         * <p>The content data. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("data")
        public SchemaStage data(String data) {
            this.data = data;
            return this;
        }

        /**
         * <p>The name of the schema. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("schema")
        public ClientStage schema(String schema) {
            this.schema = schema;
            return this;
        }

        /**
         * <p>An optional client name.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("client")
        public PublishStage client(String client) {
            this.client = client;
            return this;
        }

        /**
         * <p>Publish the content.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("publish")
        public _FinalStage publish(boolean publish) {
            this.publish = publish;
            return this;
        }

        @Override
        public CreateContentRuleActionDto build() {
            return new CreateContentRuleActionDto(data, schema, client, publish);
        }
    }
}
