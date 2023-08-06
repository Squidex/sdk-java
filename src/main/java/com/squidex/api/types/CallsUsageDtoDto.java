package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CallsUsageDtoDto.Builder.class)
public final class CallsUsageDtoDto {
    private final int totalCalls;

    private final int totalBytes;

    private final int monthCalls;

    private final int monthBytes;

    private final int blockingApiCalls;

    private final int allowedBytes;

    private final int allowedCalls;

    private final double averageElapsedMs;

    private final Map<String, List<CallsUsagePerDateDto>> details;

    private CallsUsageDtoDto(
            int totalCalls,
            int totalBytes,
            int monthCalls,
            int monthBytes,
            int blockingApiCalls,
            int allowedBytes,
            int allowedCalls,
            double averageElapsedMs,
            Map<String, List<CallsUsagePerDateDto>> details) {
        this.totalCalls = totalCalls;
        this.totalBytes = totalBytes;
        this.monthCalls = monthCalls;
        this.monthBytes = monthBytes;
        this.blockingApiCalls = blockingApiCalls;
        this.allowedBytes = allowedBytes;
        this.allowedCalls = allowedCalls;
        this.averageElapsedMs = averageElapsedMs;
        this.details = details;
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
     * @return The total number of API calls this month.
     */
    @JsonProperty("monthCalls")
    public int getMonthCalls() {
        return monthCalls;
    }

    /**
     * @return The total number of bytes transferred this month.
     */
    @JsonProperty("monthBytes")
    public int getMonthBytes() {
        return monthBytes;
    }

    /**
     * @return The amount of calls that will block the app.
     */
    @JsonProperty("blockingApiCalls")
    public int getBlockingApiCalls() {
        return blockingApiCalls;
    }

    /**
     * @return The included API traffic.
     */
    @JsonProperty("allowedBytes")
    public int getAllowedBytes() {
        return allowedBytes;
    }

    /**
     * @return The included API calls.
     */
    @JsonProperty("allowedCalls")
    public int getAllowedCalls() {
        return allowedCalls;
    }

    /**
     * @return The average duration in milliseconds.
     */
    @JsonProperty("averageElapsedMs")
    public double getAverageElapsedMs() {
        return averageElapsedMs;
    }

    /**
     * @return The statistics by date and group.
     */
    @JsonProperty("details")
    public Map<String, List<CallsUsagePerDateDto>> getDetails() {
        return details;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CallsUsageDtoDto && equalTo((CallsUsageDtoDto) other);
    }

    private boolean equalTo(CallsUsageDtoDto other) {
        return totalCalls == other.totalCalls
                && totalBytes == other.totalBytes
                && monthCalls == other.monthCalls
                && monthBytes == other.monthBytes
                && blockingApiCalls == other.blockingApiCalls
                && allowedBytes == other.allowedBytes
                && allowedCalls == other.allowedCalls
                && averageElapsedMs == other.averageElapsedMs
                && details.equals(other.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.totalCalls,
                this.totalBytes,
                this.monthCalls,
                this.monthBytes,
                this.blockingApiCalls,
                this.allowedBytes,
                this.allowedCalls,
                this.averageElapsedMs,
                this.details);
    }

    @Override
    public String toString() {
        return "CallsUsageDtoDto{" + "totalCalls: " + totalCalls + ", totalBytes: " + totalBytes + ", monthCalls: "
                + monthCalls + ", monthBytes: " + monthBytes + ", blockingApiCalls: " + blockingApiCalls
                + ", allowedBytes: " + allowedBytes + ", allowedCalls: " + allowedCalls + ", averageElapsedMs: "
                + averageElapsedMs + ", details: " + details + "}";
    }

    public static TotalCallsStage builder() {
        return new Builder();
    }

    public interface TotalCallsStage {
        TotalBytesStage totalCalls(int totalCalls);

        Builder from(CallsUsageDtoDto other);
    }

    public interface TotalBytesStage {
        MonthCallsStage totalBytes(int totalBytes);
    }

    public interface MonthCallsStage {
        MonthBytesStage monthCalls(int monthCalls);
    }

    public interface MonthBytesStage {
        BlockingApiCallsStage monthBytes(int monthBytes);
    }

    public interface BlockingApiCallsStage {
        AllowedBytesStage blockingApiCalls(int blockingApiCalls);
    }

    public interface AllowedBytesStage {
        AllowedCallsStage allowedBytes(int allowedBytes);
    }

    public interface AllowedCallsStage {
        AverageElapsedMsStage allowedCalls(int allowedCalls);
    }

    public interface AverageElapsedMsStage {
        _FinalStage averageElapsedMs(double averageElapsedMs);
    }

    public interface _FinalStage {
        CallsUsageDtoDto build();

        _FinalStage details(Map<String, List<CallsUsagePerDateDto>> details);

        _FinalStage putAllDetails(Map<String, List<CallsUsagePerDateDto>> details);

        _FinalStage details(String key, List<CallsUsagePerDateDto> value);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements TotalCallsStage,
                    TotalBytesStage,
                    MonthCallsStage,
                    MonthBytesStage,
                    BlockingApiCallsStage,
                    AllowedBytesStage,
                    AllowedCallsStage,
                    AverageElapsedMsStage,
                    _FinalStage {
        private int totalCalls;

        private int totalBytes;

        private int monthCalls;

        private int monthBytes;

        private int blockingApiCalls;

        private int allowedBytes;

        private int allowedCalls;

        private double averageElapsedMs;

        private Map<String, List<CallsUsagePerDateDto>> details = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(CallsUsageDtoDto other) {
            totalCalls(other.getTotalCalls());
            totalBytes(other.getTotalBytes());
            monthCalls(other.getMonthCalls());
            monthBytes(other.getMonthBytes());
            blockingApiCalls(other.getBlockingApiCalls());
            allowedBytes(other.getAllowedBytes());
            allowedCalls(other.getAllowedCalls());
            averageElapsedMs(other.getAverageElapsedMs());
            details(other.getDetails());
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
        public MonthCallsStage totalBytes(int totalBytes) {
            this.totalBytes = totalBytes;
            return this;
        }

        /**
         * <p>The total number of API calls this month.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("monthCalls")
        public MonthBytesStage monthCalls(int monthCalls) {
            this.monthCalls = monthCalls;
            return this;
        }

        /**
         * <p>The total number of bytes transferred this month.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("monthBytes")
        public BlockingApiCallsStage monthBytes(int monthBytes) {
            this.monthBytes = monthBytes;
            return this;
        }

        /**
         * <p>The amount of calls that will block the app.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("blockingApiCalls")
        public AllowedBytesStage blockingApiCalls(int blockingApiCalls) {
            this.blockingApiCalls = blockingApiCalls;
            return this;
        }

        /**
         * <p>The included API traffic.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("allowedBytes")
        public AllowedCallsStage allowedBytes(int allowedBytes) {
            this.allowedBytes = allowedBytes;
            return this;
        }

        /**
         * <p>The included API calls.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("allowedCalls")
        public AverageElapsedMsStage allowedCalls(int allowedCalls) {
            this.allowedCalls = allowedCalls;
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

        /**
         * <p>The statistics by date and group.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage details(String key, List<CallsUsagePerDateDto> value) {
            this.details.put(key, value);
            return this;
        }

        /**
         * <p>The statistics by date and group.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage putAllDetails(Map<String, List<CallsUsagePerDateDto>> details) {
            this.details.putAll(details);
            return this;
        }

        @Override
        @JsonSetter(value = "details", nulls = Nulls.SKIP)
        public _FinalStage details(Map<String, List<CallsUsagePerDateDto>> details) {
            this.details.clear();
            this.details.putAll(details);
            return this;
        }

        @Override
        public CallsUsageDtoDto build() {
            return new CallsUsageDtoDto(
                    totalCalls,
                    totalBytes,
                    monthCalls,
                    monthBytes,
                    blockingApiCalls,
                    allowedBytes,
                    allowedCalls,
                    averageElapsedMs,
                    details);
        }
    }
}
