package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CurrentStorageDto.Builder.class)
public final class CurrentStorageDto {
    private final int size;

    private final int maxAllowed;

    private CurrentStorageDto(int size, int maxAllowed) {
        this.size = size;
        this.maxAllowed = maxAllowed;
    }

    /**
     * @return The size in bytes.
     */
    @JsonProperty("size")
    public int getSize() {
        return size;
    }

    /**
     * @return The maximum allowed asset size.
     */
    @JsonProperty("maxAllowed")
    public int getMaxAllowed() {
        return maxAllowed;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CurrentStorageDto && equalTo((CurrentStorageDto) other);
    }

    private boolean equalTo(CurrentStorageDto other) {
        return size == other.size && maxAllowed == other.maxAllowed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.size, this.maxAllowed);
    }

    @Override
    public String toString() {
        return "CurrentStorageDto{" + "size: " + size + ", maxAllowed: " + maxAllowed + "}";
    }

    public static SizeStage builder() {
        return new Builder();
    }

    public interface SizeStage {
        MaxAllowedStage size(int size);

        Builder from(CurrentStorageDto other);
    }

    public interface MaxAllowedStage {
        _FinalStage maxAllowed(int maxAllowed);
    }

    public interface _FinalStage {
        CurrentStorageDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements SizeStage, MaxAllowedStage, _FinalStage {
        private int size;

        private int maxAllowed;

        private Builder() {}

        @Override
        public Builder from(CurrentStorageDto other) {
            size(other.getSize());
            maxAllowed(other.getMaxAllowed());
            return this;
        }

        /**
         * <p>The size in bytes.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("size")
        public MaxAllowedStage size(int size) {
            this.size = size;
            return this;
        }

        /**
         * <p>The maximum allowed asset size.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("maxAllowed")
        public _FinalStage maxAllowed(int maxAllowed) {
            this.maxAllowed = maxAllowed;
            return this;
        }

        @Override
        public CurrentStorageDto build() {
            return new CurrentStorageDto(size, maxAllowed);
        }
    }
}
