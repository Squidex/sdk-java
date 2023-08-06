package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = LogDownloadDto.Builder.class)
public final class LogDownloadDto {
    private final Optional<String> downloadUrl;

    private LogDownloadDto(Optional<String> downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    /**
     * @return The url to download the log.
     */
    @JsonProperty("downloadUrl")
    public Optional<String> getDownloadUrl() {
        return downloadUrl;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LogDownloadDto && equalTo((LogDownloadDto) other);
    }

    private boolean equalTo(LogDownloadDto other) {
        return downloadUrl.equals(other.downloadUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.downloadUrl);
    }

    @Override
    public String toString() {
        return "LogDownloadDto{" + "downloadUrl: " + downloadUrl + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> downloadUrl = Optional.empty();

        private Builder() {}

        public Builder from(LogDownloadDto other) {
            downloadUrl(other.getDownloadUrl());
            return this;
        }

        @JsonSetter(value = "downloadUrl", nulls = Nulls.SKIP)
        public Builder downloadUrl(Optional<String> downloadUrl) {
            this.downloadUrl = downloadUrl;
            return this;
        }

        public Builder downloadUrl(String downloadUrl) {
            this.downloadUrl = Optional.of(downloadUrl);
            return this;
        }

        public LogDownloadDto build() {
            return new LogDownloadDto(downloadUrl);
        }
    }
}
