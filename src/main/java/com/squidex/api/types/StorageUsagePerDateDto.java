package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = StorageUsagePerDateDto.Builder.class)
public final class StorageUsagePerDateDto {
    private final String date;

    private final int totalCount;

    private final int totalSize;

    private StorageUsagePerDateDto(String date, int totalCount, int totalSize) {
        this.date = date;
        this.totalCount = totalCount;
        this.totalSize = totalSize;
    }

    /**
     * @return The date when the usage was tracked.
     */
    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    /**
     * @return The number of assets.
     */
    @JsonProperty("totalCount")
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * @return The size in bytes.
     */
    @JsonProperty("totalSize")
    public int getTotalSize() {
        return totalSize;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof StorageUsagePerDateDto && equalTo((StorageUsagePerDateDto) other);
    }

    private boolean equalTo(StorageUsagePerDateDto other) {
        return date.equals(other.date) && totalCount == other.totalCount && totalSize == other.totalSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.date, this.totalCount, this.totalSize);
    }

    @Override
    public String toString() {
        return "StorageUsagePerDateDto{" + "date: " + date + ", totalCount: " + totalCount + ", totalSize: " + totalSize
                + "}";
    }

    public static DateStage builder() {
        return new Builder();
    }

    public interface DateStage {
        TotalCountStage date(String date);

        Builder from(StorageUsagePerDateDto other);
    }

    public interface TotalCountStage {
        TotalSizeStage totalCount(int totalCount);
    }

    public interface TotalSizeStage {
        _FinalStage totalSize(int totalSize);
    }

    public interface _FinalStage {
        StorageUsagePerDateDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements DateStage, TotalCountStage, TotalSizeStage, _FinalStage {
        private String date;

        private int totalCount;

        private int totalSize;

        private Builder() {}

        @Override
        public Builder from(StorageUsagePerDateDto other) {
            date(other.getDate());
            totalCount(other.getTotalCount());
            totalSize(other.getTotalSize());
            return this;
        }

        /**
         * <p>The date when the usage was tracked.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("date")
        public TotalCountStage date(String date) {
            this.date = date;
            return this;
        }

        /**
         * <p>The number of assets.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("totalCount")
        public TotalSizeStage totalCount(int totalCount) {
            this.totalCount = totalCount;
            return this;
        }

        /**
         * <p>The size in bytes.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("totalSize")
        public _FinalStage totalSize(int totalSize) {
            this.totalSize = totalSize;
            return this;
        }

        @Override
        public StorageUsagePerDateDto build() {
            return new StorageUsagePerDateDto(date, totalCount, totalSize);
        }
    }
}
