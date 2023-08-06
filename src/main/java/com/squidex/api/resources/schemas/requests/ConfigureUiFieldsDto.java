package com.squidex.api.resources.schemas.requests;

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
@JsonDeserialize(builder = ConfigureUiFieldsDto.Builder.class)
public final class ConfigureUiFieldsDto {
    private final Optional<List<String>> fieldsInLists;

    private final Optional<List<String>> fieldsInReferences;

    private ConfigureUiFieldsDto(Optional<List<String>> fieldsInLists, Optional<List<String>> fieldsInReferences) {
        this.fieldsInLists = fieldsInLists;
        this.fieldsInReferences = fieldsInReferences;
    }

    /**
     * @return The name of fields that are used in content lists.
     */
    @JsonProperty("fieldsInLists")
    public Optional<List<String>> getFieldsInLists() {
        return fieldsInLists;
    }

    /**
     * @return The name of fields that are used in content references.
     */
    @JsonProperty("fieldsInReferences")
    public Optional<List<String>> getFieldsInReferences() {
        return fieldsInReferences;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ConfigureUiFieldsDto && equalTo((ConfigureUiFieldsDto) other);
    }

    private boolean equalTo(ConfigureUiFieldsDto other) {
        return fieldsInLists.equals(other.fieldsInLists) && fieldsInReferences.equals(other.fieldsInReferences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fieldsInLists, this.fieldsInReferences);
    }

    @Override
    public String toString() {
        return "ConfigureUiFieldsDto{" + "fieldsInLists: " + fieldsInLists + ", fieldsInReferences: "
                + fieldsInReferences + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<List<String>> fieldsInLists = Optional.empty();

        private Optional<List<String>> fieldsInReferences = Optional.empty();

        private Builder() {}

        public Builder from(ConfigureUiFieldsDto other) {
            fieldsInLists(other.getFieldsInLists());
            fieldsInReferences(other.getFieldsInReferences());
            return this;
        }

        @JsonSetter(value = "fieldsInLists", nulls = Nulls.SKIP)
        public Builder fieldsInLists(Optional<List<String>> fieldsInLists) {
            this.fieldsInLists = fieldsInLists;
            return this;
        }

        public Builder fieldsInLists(List<String> fieldsInLists) {
            this.fieldsInLists = Optional.of(fieldsInLists);
            return this;
        }

        @JsonSetter(value = "fieldsInReferences", nulls = Nulls.SKIP)
        public Builder fieldsInReferences(Optional<List<String>> fieldsInReferences) {
            this.fieldsInReferences = fieldsInReferences;
            return this;
        }

        public Builder fieldsInReferences(List<String> fieldsInReferences) {
            this.fieldsInReferences = Optional.of(fieldsInReferences);
            return this;
        }

        public ConfigureUiFieldsDto build() {
            return new ConfigureUiFieldsDto(fieldsInLists, fieldsInReferences);
        }
    }
}
