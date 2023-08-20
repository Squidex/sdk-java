package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CallsUsagePerDateDto.Builder.class)
public final class CallsUsagePerDateDto {
    private final String date;

    private final int totalCalls;

    private final int totalBytes;

    private final double averageElapsedMs;

    private CallsUsagePerDateDto(String date, int totalCalls, int totalBytes, double averageElapsedMs) {
        this.date = date;
        this.totalCalls = totalCalls;
        this.totalBytes = totalBytes;
        this.averageElapsedMs = averageElapsedMs;
    }

    /**
     * @return The date when the usage was tracked.
     */
    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    /**
     * @return The total number of API calls.
     */
    @JsonProperty("totalCalls")
    public int getTotalCalls() {
        return totalCalls;
    }

    /**
     * @return The total number of bytes transferred.
     */
    @JsonProperty("totalBytes")
    public int getTotalBytes() {
        return totalBytes;
    }

    /**
     * @return The average duration in milliseconds.
     */
    @JsonProperty("averageElapsedMs")
    public double getAverageElapsedMs() {
        return averageElapsedMs;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CallsUsagePerDateDto && equalTo((CallsUsagePerDateDto) other);
    }

    private boolean equalTo(CallsUsagePerDateDto other) {
        return date.equals(other.date)
                && totalCalls == other.totalCalls
                && totalBytes == other.totalBytes
                && averageElapsedMs == other.averageElapsedMs;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.date, this.totalCalls, this.totalBytes, this.averageElapsedMs);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static DateStage builder() {
        return new Builder();
    }

    public interface DateStage {
        TotalCallsStage date(String date);

        Builder from(CallsUsagePerDateDto other);
    }

    public interface TotalCallsStage {
        TotalBytesStage totalCalls(int totalCalls);
    }

    public interface TotalBytesStage {
        AverageElapsedMsStage totalBytes(int totalBytes);
    }

    public interface AverageElapsedMsStage {
        _FinalStage averageElapsedMs(double averageElapsedMs);
    }

    public interface _FinalStage {
        CallsUsagePerDateDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements DateStage, TotalCallsStage, TotalBytesStage, AverageElapsedMsStage, _FinalStage {
        private String date;

        private int totalCalls;

        private int totalBytes;

        private double averageElapsedMs;

        private Builder() {}

        @Override
        public Builder from(CallsUsagePerDateDto other) {
            date(other.getDate());
            totalCalls(other.getTotalCalls());
            totalBytes(other.getTotalBytes());
            averageElapsedMs(other.getAverageElapsedMs());
            return this;
        }

        /**
         * <p>The date when the usage was tracked.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("date")
        public TotalCallsStage date(String date) {
            this.date = date;
            return this;
        }

        /**
         * <p>The total number of API calls.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("totalCalls")
        public TotalBytesStage totalCalls(int totalCalls) {
            this.totalCalls = totalCalls;
            return this;
        }

        /**
         * <p>The total number of bytes transferred.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("totalBytes")
        public AverageElapsedMsStage totalBytes(int totalBytes) {
            this.totalBytes = totalBytes;
            return this;
        }

        /**
         * <p>The average duration in milliseconds.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("averageElapsedMs")
        public _FinalStage averageElapsedMs(double averageElapsedMs) {
            this.averageElapsedMs = averageElapsedMs;
            return this;
        }

        @Override
        public CallsUsagePerDateDto build() {
            return new CallsUsagePerDateDto(date, totalCalls, totalBytes, averageElapsedMs);
        }
    }
}
