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
@JsonDeserialize(builder = UpsertSchemaNestedFieldDto.Builder.class)
public final class UpsertSchemaNestedFieldDto {
    private final String name;

    private final Optional<Boolean> isHidden;

    private final Optional<Boolean> isLocked;

    private final Optional<Boolean> isDisabled;

    private final FieldPropertiesDto properties;

    private UpsertSchemaNestedFieldDto(
            String name,
            Optional<Boolean> isHidden,
            Optional<Boolean> isLocked,
            Optional<Boolean> isDisabled,
            FieldPropertiesDto properties) {
        this.name = name;
        this.isHidden = isHidden;
        this.isLocked = isLocked;
        this.isDisabled = isDisabled;
        this.properties = properties;
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

    @JsonProperty("properties")
    public FieldPropertiesDto getProperties() {
        return properties;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpsertSchemaNestedFieldDto && equalTo((UpsertSchemaNestedFieldDto) other);
    }

    private boolean equalTo(UpsertSchemaNestedFieldDto other) {
        return name.equals(other.name)
                && isHidden.equals(other.isHidden)
                && isLocked.equals(other.isLocked)
                && isDisabled.equals(other.isDisabled)
                && properties.equals(other.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.isHidden, this.isLocked, this.isDisabled, this.properties);
    }

    @Override
    public String toString() {
        return "UpsertSchemaNestedFieldDto{" + "name: " + name + ", isHidden: " + isHidden + ", isLocked: " + isLocked
                + ", isDisabled: " + isDisabled + ", properties: " + properties + "}";
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        PropertiesStage name(String name);

        Builder from(UpsertSchemaNestedFieldDto other);
    }

    public interface PropertiesStage {
        _FinalStage properties(FieldPropertiesDto properties);
    }

    public interface _FinalStage {
        UpsertSchemaNestedFieldDto build();

        _FinalStage isHidden(Optional<Boolean> isHidden);

        _FinalStage isHidden(Boolean isHidden);

        _FinalStage isLocked(Optional<Boolean> isLocked);

        _FinalStage isLocked(Boolean isLocked);

        _FinalStage isDisabled(Optional<Boolean> isDisabled);

        _FinalStage isDisabled(Boolean isDisabled);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, PropertiesStage, _FinalStage {
        private String name;

        private FieldPropertiesDto properties;

        private Optional<Boolean> isDisabled = Optional.empty();

        private Optional<Boolean> isLocked = Optional.empty();

        private Optional<Boolean> isHidden = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(UpsertSchemaNestedFieldDto other) {
            name(other.getName());
            isHidden(other.getIsHidden());
            isLocked(other.getIsLocked());
            isDisabled(other.getIsDisabled());
            properties(other.getProperties());
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
        public UpsertSchemaNestedFieldDto build() {
            return new UpsertSchemaNestedFieldDto(name, isHidden, isLocked, isDisabled, properties);
        }
    }
}
