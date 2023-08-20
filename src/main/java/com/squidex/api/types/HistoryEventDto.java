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
@JsonDeserialize(builder = HistoryEventDto.Builder.class)
public final class HistoryEventDto {
    private final String message;

    private final String eventType;

    private final String actor;

    private final String eventId;

    private final OffsetDateTime created;

    private final int version;

    private HistoryEventDto(
            String message, String eventType, String actor, String eventId, OffsetDateTime created, int version) {
        this.message = message;
        this.eventType = eventType;
        this.actor = actor;
        this.eventId = eventId;
        this.created = created;
        this.version = version;
    }

    /**
     * @return The message for the event.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * @return The type of the original event.
     */
    @JsonProperty("eventType")
    public String getEventType() {
        return eventType;
    }

    /**
     * @return The user who called the action.
     */
    @JsonProperty("actor")
    public String getActor() {
        return actor;
    }

    /**
     * @return Gets a unique id for the event.
     */
    @JsonProperty("eventId")
    public String getEventId() {
        return eventId;
    }

    /**
     * @return The time when the event happened.
     */
    @JsonProperty("created")
    public OffsetDateTime getCreated() {
        return created;
    }

    /**
     * @return The version identifier.
     */
    @JsonProperty("version")
    public int getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof HistoryEventDto && equalTo((HistoryEventDto) other);
    }

    private boolean equalTo(HistoryEventDto other) {
        return message.equals(other.message)
                && eventType.equals(other.eventType)
                && actor.equals(other.actor)
                && eventId.equals(other.eventId)
                && created.equals(other.created)
                && version == other.version;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.message, this.eventType, this.actor, this.eventId, this.created, this.version);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static MessageStage builder() {
        return new Builder();
    }

    public interface MessageStage {
        EventTypeStage message(String message);

        Builder from(HistoryEventDto other);
    }

    public interface EventTypeStage {
        ActorStage eventType(String eventType);
    }

    public interface ActorStage {
        EventIdStage actor(String actor);
    }

    public interface EventIdStage {
        CreatedStage eventId(String eventId);
    }

    public interface CreatedStage {
        VersionStage created(OffsetDateTime created);
    }

    public interface VersionStage {
        _FinalStage version(int version);
    }

    public interface _FinalStage {
        HistoryEventDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements MessageStage, EventTypeStage, ActorStage, EventIdStage, CreatedStage, VersionStage, _FinalStage {
        private String message;

        private String eventType;

        private String actor;

        private String eventId;

        private OffsetDateTime created;

        private int version;

        private Builder() {}

        @Override
        public Builder from(HistoryEventDto other) {
            message(other.getMessage());
            eventType(other.getEventType());
            actor(other.getActor());
            eventId(other.getEventId());
            created(other.getCreated());
            version(other.getVersion());
            return this;
        }

        /**
         * <p>The message for the event.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("message")
        public EventTypeStage message(String message) {
            this.message = message;
            return this;
        }

        /**
         * <p>The type of the original event.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("eventType")
        public ActorStage eventType(String eventType) {
            this.eventType = eventType;
            return this;
        }

        /**
         * <p>The user who called the action.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("actor")
        public EventIdStage actor(String actor) {
            this.actor = actor;
            return this;
        }

        /**
         * <p>Gets a unique id for the event.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("eventId")
        public CreatedStage eventId(String eventId) {
            this.eventId = eventId;
            return this;
        }

        /**
         * <p>The time when the event happened.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("created")
        public VersionStage created(OffsetDateTime created) {
            this.created = created;
            return this;
        }

        /**
         * <p>The version identifier.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("version")
        public _FinalStage version(int version) {
            this.version = version;
            return this;
        }

        @Override
        public HistoryEventDto build() {
            return new HistoryEventDto(message, eventType, actor, eventId, created, version);
        }
    }
}
