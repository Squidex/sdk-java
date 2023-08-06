package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ReorderFieldsDto.Builder.class)
public final class ReorderFieldsDto {
    private final List<Integer> fieldIds;

    private ReorderFieldsDto(List<Integer> fieldIds) {
        this.fieldIds = fieldIds;
    }

    /**
     * @return The field ids in the target order.
     */
    @JsonProperty("fieldIds")
    public List<Integer> getFieldIds() {
        return fieldIds;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ReorderFieldsDto && equalTo((ReorderFieldsDto) other);
    }

    private boolean equalTo(ReorderFieldsDto other) {
        return fieldIds.equals(other.fieldIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fieldIds);
    }

    @Override
    public String toString() {
        return "ReorderFieldsDto{" + "fieldIds: " + fieldIds + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private List<Integer> fieldIds = new ArrayList<>();

        private Builder() {}

        public Builder from(ReorderFieldsDto other) {
            fieldIds(other.getFieldIds());
            return this;
        }

        @JsonSetter(value = "fieldIds", nulls = Nulls.SKIP)
        public Builder fieldIds(List<Integer> fieldIds) {
            this.fieldIds.clear();
            this.fieldIds.addAll(fieldIds);
            return this;
        }

        public Builder addFieldIds(Integer fieldIds) {
            this.fieldIds.add(fieldIds);
            return this;
        }

        public Builder addAllFieldIds(List<Integer> fieldIds) {
            this.fieldIds.addAll(fieldIds);
            return this;
        }

        public ReorderFieldsDto build() {
            return new ReorderFieldsDto(fieldIds);
        }
    }
}
