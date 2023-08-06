package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UpsertSchemaFieldDto.Builder.class)
public final class UpsertSchemaFieldDto {
    private final String name;

    private final Optional<Boolean> isHidden;

    private final Optional<Boolean> isLocked;

    private final Optional<Boolean> isDisabled;

    private final Optional<String> partitioning;

    private final FieldPropertiesDto properties;

    private final Optional<List<UpsertSchemaNestedFieldDto>> nested;

    private UpsertSchemaFieldDto(
            String name,
            Optional<Boolean> isHidden,
            Optional<Boolean> isLocked,
            Optional<Boolean> isDisabled,
            Optional<String> partitioning,
            FieldPropertiesDto properties,
            Optional<List<UpsertSchemaNestedFieldDto>> nested) {
        this.name = name;
        this.isHidden = isHidden;
        this.isLocked = isLocked;
        this.isDisabled = isDisabled;
        this.partitioning = partitioning;
        this.properties = properties;
        this.nested = nested;
    }

    /**
     * @return The name of the field. Must be unique within the schema. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @return Defines if the field is hidden.
     */
    @JsonProperty("isHidden")
    public Optional<Boolean> getIsHidden() {
        return isHidden;
    }

    /**
     * @return Defines if the field is locked.
     */
    @JsonProperty("isLocked")
    public Optional<Boolean> getIsLocked() {
        return isLocked;
    }

    /**
     * @return Defines if the field is disabled.
     */
    @JsonProperty("isDisabled")
    public Optional<Boolean> getIsDisabled() {
        return isDisabled;
    }

    /**
     * @return Determines the optional partitioning of the field.
     */
    @JsonProperty("partitioning")
    public Optional<String> getPartitioning() {
        return partitioning;
    }

    @JsonProperty("properties")
    public FieldPropertiesDto getProperties() {
        return properties;
    }

    /**
     * @return The nested fields.
     */
    @JsonProperty("nested")
    public Optional<List<UpsertSchemaNestedFieldDto>> getNested() {
        return nested;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpsertSchemaFieldDto && equalTo((UpsertSchemaFieldDto) other);
    }

    private boolean equalTo(UpsertSchemaFieldDto other) {
        return name.equals(other.name)
                && isHidden.equals(other.isHidden)
                && isLocked.equals(other.isLocked)
                && isDisabled.equals(other.isDisabled)
                && partitioning.equals(other.partitioning)
                && properties.equals(other.properties)
                && nested.equals(other.nested);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.name,
                this.isHidden,
                this.isLocked,
                this.isDisabled,
                this.partitioning,
                this.properties,
                this.nested);
    }

    @Override
    public String toString() {
        return "UpsertSchemaFieldDto{" + "name: " + name + ", isHidden: " + isHidden + ", isLocked: " + isLocked
                + ", isDisabled: " + isDisabled + ", partitioning: " + partitioning + ", properties: " + properties
                + ", nested: " + nested + "}";
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        PropertiesStage name(String name);

        Builder from(UpsertSchemaFieldDto other);
    }

    public interface PropertiesStage {
        _FinalStage properties(FieldPropertiesDto properties);
    }

    public interface _FinalStage {
        UpsertSchemaFieldDto build();

        _FinalStage isHidden(Optional<Boolean> isHidden);

        _FinalStage isHidden(Boolean isHidden);

        _FinalStage isLocked(Optional<Boolean> isLocked);

        _FinalStage isLocked(Boolean isLocked);

        _FinalStage isDisabled(Optional<Boolean> isDisabled);

        _FinalStage isDisabled(Boolean isDisabled);

        _FinalStage partitioning(Optional<String> partitioning);

        _FinalStage partitioning(String partitioning);

        _FinalStage nested(Optional<List<UpsertSchemaNestedFieldDto>> nested);

        _FinalStage nested(List<UpsertSchemaNestedFieldDto> nested);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, PropertiesStage, _FinalStage {
        private String name;

        private FieldPropertiesDto properties;

        private Optional<List<UpsertSchemaNestedFieldDto>> nested = Optional.empty();

        private Optional<String> partitioning = Optional.empty();

        private Optional<Boolean> isDisabled = Optional.empty();

        private Optional<Boolean> isLocked = Optional.empty();

        private Optional<Boolean> isHidden = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(UpsertSchemaFieldDto other) {
            name(other.getName());
            isHidden(other.getIsHidden());
            isLocked(other.getIsLocked());
            isDisabled(other.getIsDisabled());
            partitioning(other.getPartitioning());
            properties(other.getProperties());
            nested(other.getNested());
            return this;
        }

        /**
         * <p>The name of the field. Must be unique within the schema. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name")
        public PropertiesStage name(String name) {
            this.name = name;
            return this;
        }

        @Override
        @JsonSetter("properties")
        public _FinalStage properties(FieldPropertiesDto properties) {
            this.properties = properties;
            return this;
        }

        /**
         * <p>The nested fields.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage nested(List<UpsertSchemaNestedFieldDto> nested) {
            this.nested = Optional.of(nested);
            return this;
        }

        @Override
        @JsonSetter(value = "nested", nulls = Nulls.SKIP)
        public _FinalStage nested(Optional<List<UpsertSchemaNestedFieldDto>> nested) {
            this.nested = nested;
            return this;
        }

        /**
         * <p>Determines the optional partitioning of the field.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage partitioning(String partitioning) {
            this.partitioning = Optional.of(partitioning);
            return this;
        }

        @Override
        @JsonSetter(value = "partitioning", nulls = Nulls.SKIP)
        public _FinalStage partitioning(Optional<String> partitioning) {
            this.partitioning = partitioning;
            return this;
        }

        /**
         * <p>Defines if the field is disabled.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage isDisabled(Boolean isDisabled) {
            this.isDisabled = Optional.of(isDisabled);
            return this;
        }

        @Override
        @JsonSetter(value = "isDisabled", nulls = Nulls.SKIP)
        public _FinalStage isDisabled(Optional<Boolean> isDisabled) {
            this.isDisabled = isDisabled;
            return this;
        }

        /**
         * <p>Defines if the field is locked.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage isLocked(Boolean isLocked) {
            this.isLocked = Optional.of(isLocked);
            return this;
        }

        @Override
        @JsonSetter(value = "isLocked", nulls = Nulls.SKIP)
        public _FinalStage isLocked(Optional<Boolean> isLocked) {
            this.isLocked = isLocked;
            return this;
        }

        /**
         * <p>Defines if the field is hidden.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage isHidden(Boolean isHidden) {
            this.isHidden = Optional.of(isHidden);
            return this;
        }

        @Override
        @JsonSetter(value = "isHidden", nulls = Nulls.SKIP)
        public _FinalStage isHidden(Optional<Boolean> isHidden) {
            this.isHidden = isHidden;
            return this;
        }

        @Override
        public UpsertSchemaFieldDto build() {
            return new UpsertSchemaFieldDto(name, isHidden, isLocked, isDisabled, partitioning, properties, nested);
        }
    }
}
