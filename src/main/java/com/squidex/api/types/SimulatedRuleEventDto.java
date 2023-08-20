package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SimulatedRuleEventDto.Builder.class)
public final class SimulatedRuleEventDto {
    private final String eventId;

    private final String uniqueId;

    private final String eventName;

    private final Object event;

    private final Optional<Object> enrichedEvent;

    private final Optional<String> actionName;

    private final Optional<String> actionData;

    private final Optional<String> error;

    private final List<SkipReason> skipReasons;

    private SimulatedRuleEventDto(
            String eventId,
            String uniqueId,
            String eventName,
            Object event,
            Optional<Object> enrichedEvent,
            Optional<String> actionName,
            Optional<String> actionData,
            Optional<String> error,
            List<SkipReason> skipReasons) {
        this.eventId = eventId;
        this.uniqueId = uniqueId;
        this.eventName = eventName;
        this.event = event;
        this.enrichedEvent = enrichedEvent;
        this.actionName = actionName;
        this.actionData = actionData;
        this.error = error;
        this.skipReasons = skipReasons;
    }

    /**
     * @return The unique event id. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("eventId")
    public String getEventId() {
        return eventId;
    }

    /**
     * @return The the unique id of the simulated event. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("uniqueId")
    public String getUniqueId() {
        return uniqueId;
    }

    /**
     * @return The name of the event. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("eventName")
    public String getEventName() {
        return eventName;
    }

    @JsonProperty("event")
    public Object getEvent() {
        return event;
    }

    @JsonProperty("enrichedEvent")
    public Optional<Object> getEnrichedEvent() {
        return enrichedEvent;
    }

    /**
     * @return The data for the action.
     */
    @JsonProperty("actionName")
    public Optional<String> getActionName() {
        return actionName;
    }

    /**
     * @return The name of the action.
     */
    @JsonProperty("actionData")
    public Optional<String> getActionData() {
        return actionData;
    }

    /**
     * @return The name of the event.
     */
    @JsonProperty("error")
    public Optional<String> getError() {
        return error;
    }

    /**
     * @return The reason why the event has been skipped.
     */
    @JsonProperty("skipReasons")
    public List<SkipReason> getSkipReasons() {
        return skipReasons;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SimulatedRuleEventDto && equalTo((SimulatedRuleEventDto) other);
    }

    private boolean equalTo(SimulatedRuleEventDto other) {
        return eventId.equals(other.eventId)
                && uniqueId.equals(other.uniqueId)
                && eventName.equals(other.eventName)
                && event.equals(other.event)
                && enrichedEvent.equals(other.enrichedEvent)
                && actionName.equals(other.actionName)
                && actionData.equals(other.actionData)
                && error.equals(other.error)
                && skipReasons.equals(other.skipReasons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.eventId,
                this.uniqueId,
                this.eventName,
                this.event,
                this.enrichedEvent,
                this.actionName,
                this.actionData,
                this.error,
                this.skipReasons);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static EventIdStage builder() {
        return new Builder();
    }

    public interface EventIdStage {
        UniqueIdStage eventId(String eventId);

        Builder from(SimulatedRuleEventDto other);
    }

    public interface UniqueIdStage {
        EventNameStage uniqueId(String uniqueId);
    }

    public interface EventNameStage {
        EventStage eventName(String eventName);
    }

    public interface EventStage {
        _FinalStage event(Object event);
    }

    public interface _FinalStage {
        SimulatedRuleEventDto build();

        _FinalStage enrichedEvent(Optional<Object> enrichedEvent);

        _FinalStage enrichedEvent(Object enrichedEvent);

        _FinalStage actionName(Optional<String> actionName);

        _FinalStage actionName(String actionName);

        _FinalStage actionData(Optional<String> actionData);

        _FinalStage actionData(String actionData);

        _FinalStage error(Optional<String> error);

        _FinalStage error(String error);

        _FinalStage skipReasons(List<SkipReason> skipReasons);

        _FinalStage addSkipReasons(SkipReason skipReasons);

        _FinalStage addAllSkipReasons(List<SkipReason> skipReasons);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements EventIdStage, UniqueIdStage, EventNameStage, EventStage, _FinalStage {
        private String eventId;

        private String uniqueId;

        private String eventName;

        private Object event;

        private List<SkipReason> skipReasons = new ArrayList<>();

        private Optional<String> error = Optional.empty();

        private Optional<String> actionData = Optional.empty();

        private Optional<String> actionName = Optional.empty();

        private Optional<Object> enrichedEvent = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(SimulatedRuleEventDto other) {
            eventId(other.getEventId());
            uniqueId(other.getUniqueId());
            eventName(other.getEventName());
            event(other.getEvent());
            enrichedEvent(other.getEnrichedEvent());
            actionName(other.getActionName());
            actionData(other.getActionData());
            error(other.getError());
            skipReasons(other.getSkipReasons());
            return this;
        }

        /**
         * <p>The unique event id. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("eventId")
        public UniqueIdStage eventId(String eventId) {
            this.eventId = eventId;
            return this;
        }

        /**
         * <p>The the unique id of the simulated event. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("uniqueId")
        public EventNameStage uniqueId(String uniqueId) {
            this.uniqueId = uniqueId;
            return this;
        }

        /**
         * <p>The name of the event. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("eventName")
        public EventStage eventName(String eventName) {
            this.eventName = eventName;
            return this;
        }

        @Override
        @JsonSetter("event")
        public _FinalStage event(Object event) {
            this.event = event;
            return this;
        }

        /**
         * <p>The reason why the event has been skipped.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllSkipReasons(List<SkipReason> skipReasons) {
            this.skipReasons.addAll(skipReasons);
            return this;
        }

        /**
         * <p>The reason why the event has been skipped.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addSkipReasons(SkipReason skipReasons) {
            this.skipReasons.add(skipReasons);
            return this;
        }

        @Override
        @JsonSetter(value = "skipReasons", nulls = Nulls.SKIP)
        public _FinalStage skipReasons(List<SkipReason> skipReasons) {
            this.skipReasons.clear();
            this.skipReasons.addAll(skipReasons);
            return this;
        }

        /**
         * <p>The name of the event.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage error(String error) {
            this.error = Optional.of(error);
            return this;
        }

        @Override
        @JsonSetter(value = "error", nulls = Nulls.SKIP)
        public _FinalStage error(Optional<String> error) {
            this.error = error;
            return this;
        }

        /**
         * <p>The name of the action.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage actionData(String actionData) {
            this.actionData = Optional.of(actionData);
            return this;
        }

        @Override
        @JsonSetter(value = "actionData", nulls = Nulls.SKIP)
        public _FinalStage actionData(Optional<String> actionData) {
            this.actionData = actionData;
            return this;
        }

        /**
         * <p>The data for the action.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage actionName(String actionName) {
            this.actionName = Optional.of(actionName);
            return this;
        }

        @Override
        @JsonSetter(value = "actionName", nulls = Nulls.SKIP)
        public _FinalStage actionName(Optional<String> actionName) {
            this.actionName = actionName;
            return this;
        }

        @Override
        public _FinalStage enrichedEvent(Object enrichedEvent) {
            this.enrichedEvent = Optional.of(enrichedEvent);
            return this;
        }

        @Override
        @JsonSetter(value = "enrichedEvent", nulls = Nulls.SKIP)
        public _FinalStage enrichedEvent(Optional<Object> enrichedEvent) {
            this.enrichedEvent = enrichedEvent;
            return this;
        }

        @Override
        public SimulatedRuleEventDto build() {
            return new SimulatedRuleEventDto(
                    eventId, uniqueId, eventName, event, enrichedEvent, actionName, actionData, error, skipReasons);
        }
    }
}
