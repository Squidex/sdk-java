package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = BackupJobDto.Builder.class)
public final class BackupJobDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final String id;

    private final OffsetDateTime started;

    private final Optional<OffsetDateTime> stopped;

    private final int handledEvents;

    private final int handledAssets;

    private final JobStatus status;

    private BackupJobDto(
            Map<String, ResourceLink> links,
            String id,
            OffsetDateTime started,
            Optional<OffsetDateTime> stopped,
            int handledEvents,
            int handledAssets,
            JobStatus status) {
        this.links = links;
        this.id = id;
        this.started = started;
        this.stopped = stopped;
        this.handledEvents = handledEvents;
        this.handledAssets = handledAssets;
        this.status = status;
    }

    /**
     * @return The links.
     */
    @JsonProperty("_links")
    @Override
    public Map<String, ResourceLink> getLinks() {
        return links;
    }

    /**
     * @return The ID of the backup job.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
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

    /**
     * @return The number of handled events.
     */
    @JsonProperty("handledEvents")
    public int getHandledEvents() {
        return handledEvents;
    }

    /**
     * @return The number of handled assets.
     */
    @JsonProperty("handledAssets")
    public int getHandledAssets() {
        return handledAssets;
    }

    @JsonProperty("status")
    public JobStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BackupJobDto && equalTo((BackupJobDto) other);
    }

    private boolean equalTo(BackupJobDto other) {
        return links.equals(other.links)
                && id.equals(other.id)
                && started.equals(other.started)
                && stopped.equals(other.stopped)
                && handledEvents == other.handledEvents
                && handledAssets == other.handledAssets
                && status.equals(other.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.links, this.id, this.started, this.stopped, this.handledEvents, this.handledAssets, this.status);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        StartedStage id(String id);

        Builder from(BackupJobDto other);
    }

    public interface StartedStage {
        HandledEventsStage started(OffsetDateTime started);
    }

    public interface HandledEventsStage {
        HandledAssetsStage handledEvents(int handledEvents);
    }

    public interface HandledAssetsStage {
        StatusStage handledAssets(int handledAssets);
    }

    public interface StatusStage {
        _FinalStage status(JobStatus status);
    }

    public interface _FinalStage {
        BackupJobDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);

        _FinalStage stopped(Optional<OffsetDateTime> stopped);

        _FinalStage stopped(OffsetDateTime stopped);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements IdStage, StartedStage, HandledEventsStage, HandledAssetsStage, StatusStage, _FinalStage {
        private String id;

        private OffsetDateTime started;

        private int handledEvents;

        private int handledAssets;

        private JobStatus status;

        private Optional<OffsetDateTime> stopped = Optional.empty();

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(BackupJobDto other) {
            links(other.getLinks());
            id(other.getId());
            started(other.getStarted());
            stopped(other.getStopped());
            handledEvents(other.getHandledEvents());
            handledAssets(other.getHandledAssets());
            status(other.getStatus());
            return this;
        }

        /**
         * <p>The ID of the backup job.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("id")
        public StartedStage id(String id) {
            this.id = id;
            return this;
        }

        /**
         * <p>The time when the job has been started.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("started")
        public HandledEventsStage started(OffsetDateTime started) {
            this.started = started;
            return this;
        }

        /**
         * <p>The number of handled events.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("handledEvents")
        public HandledAssetsStage handledEvents(int handledEvents) {
            this.handledEvents = handledEvents;
            return this;
        }

        /**
         * <p>The number of handled assets.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("handledAssets")
        public StatusStage handledAssets(int handledAssets) {
            this.handledAssets = handledAssets;
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
         * <p>The links.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage links(String key, ResourceLink value) {
            this.links.put(key, value);
            return this;
        }

        /**
         * <p>The links.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage putAllLinks(Map<String, ResourceLink> links) {
            this.links.putAll(links);
            return this;
        }

        @Override
        @JsonSetter(value = "_links", nulls = Nulls.SKIP)
        public _FinalStage links(Map<String, ResourceLink> links) {
            this.links.clear();
            this.links.putAll(links);
            return this;
        }

        @Override
        public BackupJobDto build() {
            return new BackupJobDto(links, id, started, stopped, handledEvents, handledAssets, status);
        }
    }
}
