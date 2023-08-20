package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ContentChangedRuleTriggerDto.Builder.class)
public final class ContentChangedRuleTriggerDto {
    private final Optional<List<SchemaCondition>> schemas;

    private final Optional<List<SchemaCondition>> referencedSchemas;

    private final boolean handleAll;

    private ContentChangedRuleTriggerDto(
            Optional<List<SchemaCondition>> schemas,
            Optional<List<SchemaCondition>> referencedSchemas,
            boolean handleAll) {
        this.schemas = schemas;
        this.referencedSchemas = referencedSchemas;
        this.handleAll = handleAll;
    }

    /**
     * @return The schema settings.
     */
    @JsonProperty("schemas")
    public Optional<List<SchemaCondition>> getSchemas() {
        return schemas;
    }

    /**
     * @return The schema references.
     */
    @JsonProperty("referencedSchemas")
    public Optional<List<SchemaCondition>> getReferencedSchemas() {
        return referencedSchemas;
    }

    /**
     * @return Determines whether the trigger should handle all content changes events.
     */
    @JsonProperty("handleAll")
    public boolean getHandleAll() {
        return handleAll;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ContentChangedRuleTriggerDto && equalTo((ContentChangedRuleTriggerDto) other);
    }

    private boolean equalTo(ContentChangedRuleTriggerDto other) {
        return schemas.equals(other.schemas)
                && referencedSchemas.equals(other.referencedSchemas)
                && handleAll == other.handleAll;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.schemas, this.referencedSchemas, this.handleAll);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static HandleAllStage builder() {
        return new Builder();
    }

    public interface HandleAllStage {
        _FinalStage handleAll(boolean handleAll);

        Builder from(ContentChangedRuleTriggerDto other);
    }

    public interface _FinalStage {
        ContentChangedRuleTriggerDto build();

        _FinalStage schemas(Optional<List<SchemaCondition>> schemas);

        _FinalStage schemas(List<SchemaCondition> schemas);

        _FinalStage referencedSchemas(Optional<List<SchemaCondition>> referencedSchemas);

        _FinalStage referencedSchemas(List<SchemaCondition> referencedSchemas);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements HandleAllStage, _FinalStage {
        private boolean handleAll;

        private Optional<List<SchemaCondition>> referencedSchemas = Optional.empty();

        private Optional<List<SchemaCondition>> schemas = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(ContentChangedRuleTriggerDto other) {
            schemas(other.getSchemas());
            referencedSchemas(other.getReferencedSchemas());
            handleAll(other.getHandleAll());
            return this;
        }

        /**
         * <p>Determines whether the trigger should handle all content changes events.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("handleAll")
        public _FinalStage handleAll(boolean handleAll) {
            this.handleAll = handleAll;
            return this;
        }

        /**
         * <p>The schema references.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage referencedSchemas(List<SchemaCondition> referencedSchemas) {
            this.referencedSchemas = Optional.of(referencedSchemas);
            return this;
        }

        @Override
        @JsonSetter(value = "referencedSchemas", nulls = Nulls.SKIP)
        public _FinalStage referencedSchemas(Optional<List<SchemaCondition>> referencedSchemas) {
            this.referencedSchemas = referencedSchemas;
            return this;
        }

        /**
         * <p>The schema settings.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage schemas(List<SchemaCondition> schemas) {
            this.schemas = Optional.of(schemas);
            return this;
        }

        @Override
        @JsonSetter(value = "schemas", nulls = Nulls.SKIP)
        public _FinalStage schemas(Optional<List<SchemaCondition>> schemas) {
            this.schemas = schemas;
            return this;
        }

        @Override
        public ContentChangedRuleTriggerDto build() {
            return new ContentChangedRuleTriggerDto(schemas, referencedSchemas, handleAll);
        }
    }
}
