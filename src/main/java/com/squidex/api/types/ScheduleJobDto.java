package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ScheduleJobDto.Builder.class)
public final class ScheduleJobDto {
    private final String id;

    private final String status;

    private final OffsetDateTime dueTime;

    private final String color;

    private final String scheduledBy;

    private ScheduleJobDto(String id, String status, OffsetDateTime dueTime, String color, String scheduledBy) {
        this.id = id;
        this.status = status;
        this.dueTime = dueTime;
        this.color = color;
        this.scheduledBy = scheduledBy;
    }

    /**
     * @return The ID of the schedule job.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The new status.
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * @return The target date and time when the content should be scheduled.
     */
    @JsonProperty("dueTime")
    public OffsetDateTime getDueTime() {
        return dueTime;
    }

    /**
     * @return The color of the scheduled status.
     */
    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    /**
     * @return The user who schedule the content.
     */
    @JsonProperty("scheduledBy")
    public String getScheduledBy() {
        return scheduledBy;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ScheduleJobDto && equalTo((ScheduleJobDto) other);
    }

    private boolean equalTo(ScheduleJobDto other) {
        return id.equals(other.id)
                && status.equals(other.status)
                && dueTime.equals(other.dueTime)
                && color.equals(other.color)
                && scheduledBy.equals(other.scheduledBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.status, this.dueTime, this.color, this.scheduledBy);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        StatusStage id(String id);

        Builder from(ScheduleJobDto other);
    }

    public interface StatusStage {
        DueTimeStage status(String status);
    }

    public interface DueTimeStage {
        ColorStage dueTime(OffsetDateTime dueTime);
    }

    public interface ColorStage {
        ScheduledByStage color(String color);
    }

    public interface ScheduledByStage {
        _FinalStage scheduledBy(String scheduledBy);
    }

    public interface _FinalStage {
        ScheduleJobDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements IdStage, StatusStage, DueTimeStage, ColorStage, ScheduledByStage, _FinalStage {
        private String id;

        private String status;

        private OffsetDateTime dueTime;

        private String color;

        private String scheduledBy;

        private Builder() {}

        @Override
        public Builder from(ScheduleJobDto other) {
            id(other.getId());
            status(other.getStatus());
            dueTime(other.getDueTime());
            color(other.getColor());
            scheduledBy(other.getScheduledBy());
            return this;
        }

        /**
         * <p>The ID of the schedule job.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("id")
        public StatusStage id(String id) {
            this.id = id;
            return this;
        }

        /**
         * <p>The new status.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("status")
        public DueTimeStage status(String status) {
            this.status = status;
            return this;
        }

        /**
         * <p>The target date and time when the content should be scheduled.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("dueTime")
        public ColorStage dueTime(OffsetDateTime dueTime) {
            this.dueTime = dueTime;
            return this;
        }

        /**
         * <p>The color of the scheduled status.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("color")
        public ScheduledByStage color(String color) {
            this.color = color;
            return this;
        }

        /**
         * <p>The user who schedule the content.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("scheduledBy")
        public _FinalStage scheduledBy(String scheduledBy) {
            this.scheduledBy = scheduledBy;
            return this;
        }

        @Override
        public ScheduleJobDto build() {
            return new ScheduleJobDto(id, status, dueTime, color, scheduledBy);
        }
    }
}
