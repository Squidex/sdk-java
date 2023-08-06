package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = RestoreJobDto.Builder.class)
public final class RestoreJobDto {
    private final String url;

    private final List<String> log;

    private final OffsetDateTime started;

    private final Optional<OffsetDateTime> stopped;

    private final JobStatus status;

    private RestoreJobDto(
            String url, List<String> log, OffsetDateTime started, Optional<OffsetDateTime> stopped, JobStatus status) {
        this.url = url;
        this.log = log;
        this.started = started;
        this.stopped = stopped;
        this.status = status;
    }

    /**
     * @return The uri to load from.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * @return The status log.
     */
    @JsonProperty("log")
    public List<String> getLog() {
        return log;
    }

    /**
     * @return The time when the job has been started.
     */
    @JsonProperty("started")
    public OffsetDateTime getStarted() {
        return started;
    }

    /**
     * @return The time when the job has been stopped.
     */
    @JsonProperty("stopped")
    public Optional<OffsetDateTime> getStopped() {
        return stopped;
    }

    @JsonProperty("status")
    public JobStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RestoreJobDto && equalTo((RestoreJobDto) other);
    }

    private boolean equalTo(RestoreJobDto other) {
        return url.equals(other.url)
                && log.equals(other.log)
                && started.equals(other.started)
                && stopped.equals(other.stopped)
                && status.equals(other.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.url, this.log, this.started, this.stopped, this.status);
    }

    @Override
    public String toString() {
        return "RestoreJobDto{" + "url: " + url + ", log: " + log + ", started: " + started + ", stopped: " + stopped
                + ", status: " + status + "}";
    }

    public static UrlStage builder() {
        return new Builder();
    }

    public interface UrlStage {
        StartedStage url(String url);

        Builder from(RestoreJobDto other);
    }

    public interface StartedStage {
        StatusStage started(OffsetDateTime started);
    }

    public interface StatusStage {
        _FinalStage status(JobStatus status);
    }

    public interface _FinalStage {
        RestoreJobDto build();

        _FinalStage log(List<String> log);

        _FinalStage addLog(String log);

        _FinalStage addAllLog(List<String> log);

        _FinalStage stopped(Optional<OffsetDateTime> stopped);

        _FinalStage stopped(OffsetDateTime stopped);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements UrlStage, StartedStage, StatusStage, _FinalStage {
        private String url;

        private OffsetDateTime started;

        private JobStatus status;

        private Optional<OffsetDateTime> stopped = Optional.empty();

        private List<String> log = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(RestoreJobDto other) {
            url(other.getUrl());
            log(other.getLog());
            started(other.getStarted());
            stopped(other.getStopped());
            status(other.getStatus());
            return this;
        }

        /**
         * <p>The uri to load from.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("url")
        public StartedStage url(String url) {
            this.url = url;
            return this;
        }

        /**
         * <p>The time when the job has been started.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("started")
        public StatusStage started(OffsetDateTime started) {
            this.started = started;
            return this;
        }

        @Override
        @JsonSetter("status")
        public _FinalStage status(JobStatus status) {
            this.status = status;
            return this;
        }

        /**
         * <p>The time when the job has been stopped.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage stopped(OffsetDateTime stopped) {
            this.stopped = Optional.of(stopped);
            return this;
        }

        @Override
        @JsonSetter(value = "stopped", nulls = Nulls.SKIP)
        public _FinalStage stopped(Optional<OffsetDateTime> stopped) {
            this.stopped = stopped;
            return this;
        }

        /**
         * <p>The status log.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllLog(List<String> log) {
            this.log.addAll(log);
            return this;
        }

        /**
         * <p>The status log.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addLog(String log) {
            this.log.add(log);
            return this;
        }

        @Override
        @JsonSetter(value = "log", nulls = Nulls.SKIP)
        public _FinalStage log(List<String> log) {
            this.log.clear();
            this.log.addAll(log);
            return this;
        }

        @Override
        public RestoreJobDto build() {
            return new RestoreJobDto(url, log, started, stopped, status);
        }
    }
}
