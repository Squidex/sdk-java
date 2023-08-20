package com.squidex.api.resources.assets.requests;

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
@JsonDeserialize(builder = MoveAssetDto.Builder.class)
public final class MoveAssetDto {
    private final Optional<String> parentId;

    private MoveAssetDto(Optional<String> parentId) {
        this.parentId = parentId;
    }

    /**
     * @return The parent folder id.
     */
    @JsonProperty("parentId")
    public Optional<String> getParentId() {
        return parentId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof MoveAssetDto && equalTo((MoveAssetDto) other);
    }

    private boolean equalTo(MoveAssetDto other) {
        return parentId.equals(other.parentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.parentId);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> parentId = Optional.empty();

        private Builder() {}

        public Builder from(MoveAssetDto other) {
            parentId(other.getParentId());
            return this;
        }

        @JsonSetter(value = "parentId", nulls = Nulls.SKIP)
        public Builder parentId(Optional<String> parentId) {
            this.parentId = parentId;
            return this;
        }

        public Builder parentId(String parentId) {
            this.parentId = Optional.of(parentId);
            return this;
        }

        public MoveAssetDto build() {
            return new MoveAssetDto(parentId);
        }
    }
}
