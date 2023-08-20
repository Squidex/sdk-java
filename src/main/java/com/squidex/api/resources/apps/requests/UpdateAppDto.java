package com.squidex.api.resources.apps.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UpdateAppDto.Builder.class)
public final class UpdateAppDto {
    private final Optional<String> label;

    private final Optional<String> description;

    private UpdateAppDto(Optional<String> label, Optional<String> description) {
        this.label = label;
        this.description = description;
    }

    /**
     * @return The optional label of your app.
     */
    @JsonProperty("label")
    public Optional<String> getLabel() {
        return label;
    }

    /**
     * @return The optional description of your app.
     */
    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdateAppDto && equalTo((UpdateAppDto) other);
    }

    private boolean equalTo(UpdateAppDto other) {
        return label.equals(other.label) && description.equals(other.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.label, this.description);
    }

    @Override
    public String toString() {
        return "UpdateAppDto{" + "label: " + label + ", description: " + description + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> label = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Builder() {}

        public Builder from(UpdateAppDto other) {
            label(other.getLabel());
            description(other.getDescription());
            return this;
        }

        @JsonSetter(value = "label", nulls = Nulls.SKIP)
        public Builder label(Optional<String> label) {
            this.label = label;
            return this;
        }

        public Builder label(String label) {
            this.label = Optional.of(label);
            return this;
        }

        @JsonSetter(value = "description", nulls = Nulls.SKIP)
        public Builder description(Optional<String> description) {
            this.description = description;
            return this;
        }

        public Builder description(String description) {
            this.description = Optional.of(description);
            return this;
        }

        public UpdateAppDto build() {
            return new UpdateAppDto(label, description);
        }
    }
}
