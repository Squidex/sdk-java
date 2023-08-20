package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SchemaCondition.Builder.class)
public final class SchemaCondition {
    private final String schemaId;

    private final Optional<String> condition;

    private SchemaCondition(String schemaId, Optional<String> condition) {
        this.schemaId = schemaId;
        this.condition = condition;
    }

    @JsonProperty("schemaId")
    public String getSchemaId() {
        return schemaId;
    }

    @JsonProperty("condition")
    public Optional<String> getCondition() {
        return condition;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SchemaCondition && equalTo((SchemaCondition) other);
    }

    private boolean equalTo(SchemaCondition other) {
        return schemaId.equals(other.schemaId) && condition.equals(other.condition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.schemaId, this.condition);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static SchemaIdStage builder() {
        return new Builder();
    }

    public interface SchemaIdStage {
        _FinalStage schemaId(String schemaId);

        Builder from(SchemaCondition other);
    }

    public interface _FinalStage {
        SchemaCondition build();

        _FinalStage condition(Optional<String> condition);

        _FinalStage condition(String condition);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements SchemaIdStage, _FinalStage {
        private String schemaId;

        private Optional<String> condition = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(SchemaCondition other) {
            schemaId(other.getSchemaId());
            condition(other.getCondition());
            return this;
        }

        @Override
        @JsonSetter("schemaId")
        public _FinalStage schemaId(String schemaId) {
            this.schemaId = schemaId;
            return this;
        }

        @Override
        public _FinalStage condition(String condition) {
            this.condition = Optional.of(condition);
            return this;
        }

        @Override
        @JsonSetter(value = "condition", nulls = Nulls.SKIP)
        public _FinalStage condition(Optional<String> condition) {
            this.condition = condition;
            return this;
        }

        @Override
        public SchemaCondition build() {
            return new SchemaCondition(schemaId, condition);
        }
    }
}
