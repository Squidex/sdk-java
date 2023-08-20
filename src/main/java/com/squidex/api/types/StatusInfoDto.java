package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = StatusInfoDto.Builder.class)
public final class StatusInfoDto {
    private final String status;

    private final String color;

    private StatusInfoDto(String status, String color) {
        this.status = status;
        this.color = color;
    }

    /**
     * @return The name of the status.
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * @return The color of the status.
     */
    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof StatusInfoDto && equalTo((StatusInfoDto) other);
    }

    private boolean equalTo(StatusInfoDto other) {
        return status.equals(other.status) && color.equals(other.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.status, this.color);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static StatusStage builder() {
        return new Builder();
    }

    public interface StatusStage {
        ColorStage status(String status);

        Builder from(StatusInfoDto other);
    }

    public interface ColorStage {
        _FinalStage color(String color);
    }

    public interface _FinalStage {
        StatusInfoDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements StatusStage, ColorStage, _FinalStage {
        private String status;

        private String color;

        private Builder() {}

        @Override
        public Builder from(StatusInfoDto other) {
            status(other.getStatus());
            color(other.getColor());
            return this;
        }

        /**
         * <p>The name of the status.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("status")
        public ColorStage status(String status) {
            this.status = status;
            return this;
        }

        /**
         * <p>The color of the status.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("color")
        public _FinalStage color(String color) {
            this.color = color;
            return this;
        }

        @Override
        public StatusInfoDto build() {
            return new StatusInfoDto(status, color);
        }
    }
}
