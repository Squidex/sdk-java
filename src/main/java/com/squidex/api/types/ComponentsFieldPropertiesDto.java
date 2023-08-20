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
@JsonDeserialize(builder = ComponentsFieldPropertiesDto.Builder.class)
public final class ComponentsFieldPropertiesDto {
    private final Optional<Integer> minItems;

    private final Optional<Integer> maxItems;

    private final Optional<List<String>> schemaIds;

    private final Optional<List<String>> uniqueFields;

    private ComponentsFieldPropertiesDto(
            Optional<Integer> minItems,
            Optional<Integer> maxItems,
            Optional<List<String>> schemaIds,
            Optional<List<String>> uniqueFields) {
        this.minItems = minItems;
        this.maxItems = maxItems;
        this.schemaIds = schemaIds;
        this.uniqueFields = uniqueFields;
    }

    /**
     * @return The minimum allowed items for the field value.
     */
    @JsonProperty("minItems")
    public Optional<Integer> getMinItems() {
        return minItems;
    }

    /**
     * @return The maximum allowed items for the field value.
     */
    @JsonProperty("maxItems")
    public Optional<Integer> getMaxItems() {
        return maxItems;
    }

    /**
     * @return The ID of the embedded schemas.
     */
    @JsonProperty("schemaIds")
    public Optional<List<String>> getSchemaIds() {
        return schemaIds;
    }

    /**
     * @return The fields that must be unique.
     */
    @JsonProperty("uniqueFields")
    public Optional<List<String>> getUniqueFields() {
        return uniqueFields;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ComponentsFieldPropertiesDto && equalTo((ComponentsFieldPropertiesDto) other);
    }

    private boolean equalTo(ComponentsFieldPropertiesDto other) {
        return minItems.equals(other.minItems)
                && maxItems.equals(other.maxItems)
                && schemaIds.equals(other.schemaIds)
                && uniqueFields.equals(other.uniqueFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.minItems, this.maxItems, this.schemaIds, this.uniqueFields);
    }

    @Override
    public String toString() {
        return "ComponentsFieldPropertiesDto{" + "minItems: " + minItems + ", maxItems: " + maxItems + ", schemaIds: "
                + schemaIds + ", uniqueFields: " + uniqueFields + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Integer> minItems = Optional.empty();

        private Optional<Integer> maxItems = Optional.empty();

        private Optional<List<String>> schemaIds = Optional.empty();

        private Optional<List<String>> uniqueFields = Optional.empty();

        private Builder() {}

        public Builder from(ComponentsFieldPropertiesDto other) {
            minItems(other.getMinItems());
            maxItems(other.getMaxItems());
            schemaIds(other.getSchemaIds());
            uniqueFields(other.getUniqueFields());
            return this;
        }

        @JsonSetter(value = "minItems", nulls = Nulls.SKIP)
        public Builder minItems(Optional<Integer> minItems) {
            this.minItems = minItems;
            return this;
        }

        public Builder minItems(Integer minItems) {
            this.minItems = Optional.of(minItems);
            return this;
        }

        @JsonSetter(value = "maxItems", nulls = Nulls.SKIP)
        public Builder maxItems(Optional<Integer> maxItems) {
            this.maxItems = maxItems;
            return this;
        }

        public Builder maxItems(Integer maxItems) {
            this.maxItems = Optional.of(maxItems);
            return this;
        }

        @JsonSetter(value = "schemaIds", nulls = Nulls.SKIP)
        public Builder schemaIds(Optional<List<String>> schemaIds) {
            this.schemaIds = schemaIds;
            return this;
        }

        public Builder schemaIds(List<String> schemaIds) {
            this.schemaIds = Optional.of(schemaIds);
            return this;
        }

        @JsonSetter(value = "uniqueFields", nulls = Nulls.SKIP)
        public Builder uniqueFields(Optional<List<String>> uniqueFields) {
            this.uniqueFields = uniqueFields;
            return this;
        }

        public Builder uniqueFields(List<String> uniqueFields) {
            this.uniqueFields = Optional.of(uniqueFields);
            return this;
        }

        public ComponentsFieldPropertiesDto build() {
            return new ComponentsFieldPropertiesDto(minItems, maxItems, schemaIds, uniqueFields);
        }
    }
}
