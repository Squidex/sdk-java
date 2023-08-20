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
@JsonDeserialize(builder = AddFieldDto.Builder.class)
public final class AddFieldDto {
    private final String name;

    private final Optional<String> partitioning;

    private final FieldPropertiesDto properties;

    private AddFieldDto(String name, Optional<String> partitioning, FieldPropertiesDto properties) {
        this.name = name;
        this.partitioning = partitioning;
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

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AddFieldDto && equalTo((AddFieldDto) other);
    }

    private boolean equalTo(AddFieldDto other) {
        return name.equals(other.name)
                && partitioning.equals(other.partitioning)
                && properties.equals(other.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.partitioning, this.properties);
    }

    @Override
    public String toString() {
        return "AddFieldDto{" + "name: " + name + ", partitioning: " + partitioning + ", properties: " + properties
                + "}";
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        PropertiesStage name(String name);

        Builder from(AddFieldDto other);
    }

    public interface PropertiesStage {
        _FinalStage properties(FieldPropertiesDto properties);
    }

    public interface _FinalStage {
        AddFieldDto build();

        _FinalStage partitioning(Optional<String> partitioning);

        _FinalStage partitioning(String partitioning);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, PropertiesStage, _FinalStage {
        private String name;

        private FieldPropertiesDto properties;

        private Optional<String> partitioning = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(AddFieldDto other) {
            name(other.getName());
            partitioning(other.getPartitioning());
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

        @Override
        public AddFieldDto build() {
            return new AddFieldDto(name, partitioning, properties);
        }
    }
}
