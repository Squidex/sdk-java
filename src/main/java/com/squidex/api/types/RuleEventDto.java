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
@JsonDeserialize(builder = RuleEventDto.Builder.class)
public final class RuleEventDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final String id;

    private final OffsetDateTime created;

    private final String description;

    private final String eventName;

    private final Optional<String> lastDump;

    private final int numCalls;

    private final Optional<OffsetDateTime> nextAttempt;

    private final RuleResult result;

    private final RuleJobResult jobResult;

    private RuleEventDto(
            Map<String, ResourceLink> links,
            String id,
            OffsetDateTime created,
            String description,
            String eventName,
            Optional<String> lastDump,
            int numCalls,
            Optional<OffsetDateTime> nextAttempt,
            RuleResult result,
            RuleJobResult jobResult) {
        this.links = links;
        this.id = id;
        this.created = created;
        this.description = description;
        this.eventName = eventName;
        this.lastDump = lastDump;
        this.numCalls = numCalls;
        this.nextAttempt = nextAttempt;
        this.result = result;
        this.jobResult = jobResult;
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
     * @return The ID of the event.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The time when the event has been created.
     */
    @JsonProperty("created")
    public OffsetDateTime getCreated() {
        return created;
    }

    /**
     * @return The description.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * @return The name of the event.
     */
    @JsonProperty("eventName")
    public String getEventName() {
        return eventName;
    }

    /**
     * @return The last dump.
     */
    @JsonProperty("lastDump")
    public Optional<String> getLastDump() {
        return lastDump;
    }

    /**
     * @return The number of calls.
     */
    @JsonProperty("numCalls")
    public int getNumCalls() {
        return numCalls;
    }

    /**
     * @return The next attempt.
     */
    @JsonProperty("nextAttempt")
    public Optional<OffsetDateTime> getNextAttempt() {
        return nextAttempt;
    }

    @JsonProperty("result")
    public RuleResult getResult() {
        return result;
    }

    @JsonProperty("jobResult")
    public RuleJobResult getJobResult() {
        return jobResult;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RuleEventDto && equalTo((RuleEventDto) other);
    }

    private boolean equalTo(RuleEventDto other) {
        return links.equals(other.links)
                && id.equals(other.id)
                && created.equals(other.created)
                && description.equals(other.description)
                && eventName.equals(other.eventName)
                && lastDump.equals(other.lastDump)
                && numCalls == other.numCalls
                && nextAttempt.equals(other.nextAttempt)
                && result.equals(other.result)
                && jobResult.equals(other.jobResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.links,
                this.id,
                this.created,
                this.description,
                this.eventName,
                this.lastDump,
                this.numCalls,
                this.nextAttempt,
                this.result,
                this.jobResult);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        CreatedStage id(String id);

        Builder from(RuleEventDto other);
    }

    public interface CreatedStage {
        DescriptionStage created(OffsetDateTime created);
    }

    public interface DescriptionStage {
        EventNameStage description(String description);
    }

    public interface EventNameStage {
        NumCallsStage eventName(String eventName);
    }

    public interface NumCallsStage {
        ResultStage numCalls(int numCalls);
    }

    public interface ResultStage {
        JobResultStage result(RuleResult result);
    }

    public interface JobResultStage {
        _FinalStage jobResult(RuleJobResult jobResult);
    }

    public interface _FinalStage {
        RuleEventDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);

        _FinalStage lastDump(Optional<String> lastDump);

        _FinalStage lastDump(String lastDump);

        _FinalStage nextAttempt(Optional<OffsetDateTime> nextAttempt);

        _FinalStage nextAttempt(OffsetDateTime nextAttempt);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements IdStage,
                    CreatedStage,
                    DescriptionStage,
                    EventNameStage,
                    NumCallsStage,
                    ResultStage,
                    JobResultStage,
                    _FinalStage {
        private String id;

        private OffsetDateTime created;

        private String description;

        private String eventName;

        private int numCalls;

        private RuleResult result;

        private RuleJobResult jobResult;

        private Optional<OffsetDateTime> nextAttempt = Optional.empty();

        private Optional<String> lastDump = Optional.empty();

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(RuleEventDto other) {
            links(other.getLinks());
            id(other.getId());
            created(other.getCreated());
            description(other.getDescription());
            eventName(other.getEventName());
            lastDump(other.getLastDump());
            numCalls(other.getNumCalls());
            nextAttempt(other.getNextAttempt());
            result(other.getResult());
            jobResult(other.getJobResult());
            return this;
        }

        /**
         * <p>The ID of the event.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("id")
        public CreatedStage id(String id) {
            this.id = id;
            return this;
        }

        /**
         * <p>The time when the event has been created.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("created")
        public DescriptionStage created(OffsetDateTime created) {
            this.created = created;
            return this;
        }

        /**
         * <p>The description.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("description")
        public EventNameStage description(String description) {
            this.description = description;
            return this;
        }

        /**
         * <p>The name of the event.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("eventName")
        public NumCallsStage eventName(String eventName) {
            this.eventName = eventName;
            return this;
        }

        /**
         * <p>The number of calls.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("numCalls")
        public ResultStage numCalls(int numCalls) {
            this.numCalls = numCalls;
            return this;
        }

        @Override
        @JsonSetter("result")
        public JobResultStage result(RuleResult result) {
            this.result = result;
            return this;
        }

        @Override
        @JsonSetter("jobResult")
        public _FinalStage jobResult(RuleJobResult jobResult) {
            this.jobResult = jobResult;
            return this;
        }

        /**
         * <p>The next attempt.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage nextAttempt(OffsetDateTime nextAttempt) {
            this.nextAttempt = Optional.of(nextAttempt);
            return this;
        }

        @Override
        @JsonSetter(value = "nextAttempt", nulls = Nulls.SKIP)
        public _FinalStage nextAttempt(Optional<OffsetDateTime> nextAttempt) {
            this.nextAttempt = nextAttempt;
            return this;
        }

        /**
         * <p>The last dump.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage lastDump(String lastDump) {
            this.lastDump = Optional.of(lastDump);
            return this;
        }

        @Override
        @JsonSetter(value = "lastDump", nulls = Nulls.SKIP)
        public _FinalStage lastDump(Optional<String> lastDump) {
            this.lastDump = lastDump;
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
        public RuleEventDto build() {
            return new RuleEventDto(
                    links, id, created, description, eventName, lastDump, numCalls, nextAttempt, result, jobResult);
        }
    }
}
