package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = JsonFieldPropertiesDto.Builder.class)
public final class JsonFieldPropertiesDto {
    private final Optional<String> graphQlSchema;

    private JsonFieldPropertiesDto(Optional<String> graphQlSchema) {
        this.graphQlSchema = graphQlSchema;
    }

    /**
     * @return The GraphQL schema.
     */
    @JsonProperty("graphQLSchema")
    public Optional<String> getGraphQlSchema() {
        return graphQlSchema;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof JsonFieldPropertiesDto && equalTo((JsonFieldPropertiesDto) other);
    }

    private boolean equalTo(JsonFieldPropertiesDto other) {
        return graphQlSchema.equals(other.graphQlSchema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.graphQlSchema);
    }

    @Override
    public String toString() {
        return "JsonFieldPropertiesDto{" + "graphQlSchema: " + graphQlSchema + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> graphQlSchema = Optional.empty();

        private Builder() {}

        public Builder from(JsonFieldPropertiesDto other) {
            graphQlSchema(other.getGraphQlSchema());
            return this;
        }

        @JsonSetter(value = "graphQLSchema", nulls = Nulls.SKIP)
        public Builder graphQlSchema(Optional<String> graphQlSchema) {
            this.graphQlSchema = graphQlSchema;
            return this;
        }

        public Builder graphQlSchema(String graphQlSchema) {
            this.graphQlSchema = Optional.of(graphQlSchema);
            return this;
        }

        public JsonFieldPropertiesDto build() {
            return new JsonFieldPropertiesDto(graphQlSchema);
        }
    }
}
