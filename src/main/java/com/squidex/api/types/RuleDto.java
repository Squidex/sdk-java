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
@JsonDeserialize(builder = RuleDto.Builder.class)
public final class RuleDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final String id;

    private final String createdBy;

    private final String lastModifiedBy;

    private final OffsetDateTime created;

    private final OffsetDateTime lastModified;

    private final int version;

    private final boolean isEnabled;

    private final Optional<String> name;

    private final RuleTriggerDto trigger;

    private final RuleActionDto action;

    private final int numSucceeded;

    private final int numFailed;

    private final Optional<OffsetDateTime> lastExecuted;

    private RuleDto(
            Map<String, ResourceLink> links,
            String id,
            String createdBy,
            String lastModifiedBy,
            OffsetDateTime created,
            OffsetDateTime lastModified,
            int version,
            boolean isEnabled,
            Optional<String> name,
            RuleTriggerDto trigger,
            RuleActionDto action,
            int numSucceeded,
            int numFailed,
            Optional<OffsetDateTime> lastExecuted) {
        this.links = links;
        this.id = id;
        this.createdBy = createdBy;
        this.lastModifiedBy = lastModifiedBy;
        this.created = created;
        this.lastModified = lastModified;
        this.version = version;
        this.isEnabled = isEnabled;
        this.name = name;
        this.trigger = trigger;
        this.action = action;
        this.numSucceeded = numSucceeded;
        this.numFailed = numFailed;
        this.lastExecuted = lastExecuted;
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
     * @return The ID of the rule.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The user that has created the rule.
     */
    @JsonProperty("createdBy")
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @return The user that has updated the rule.
     */
    @JsonProperty("lastModifiedBy")
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * @return The date and time when the rule has been created.
     */
    @JsonProperty("created")
    public OffsetDateTime getCreated() {
        return created;
    }

    /**
     * @return The date and time when the rule has been modified last.
     */
    @JsonProperty("lastModified")
    public OffsetDateTime getLastModified() {
        return lastModified;
    }

    /**
     * @return The version of the rule.
     */
    @JsonProperty("version")
    public int getVersion() {
        return version;
    }

    /**
     * @return Determines if the rule is enabled.
     */
    @JsonProperty("isEnabled")
    public boolean getIsEnabled() {
        return isEnabled;
    }

    /**
     * @return Optional rule name.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return The trigger properties.
     */
    @JsonProperty("trigger")
    public RuleTriggerDto getTrigger() {
        return trigger;
    }

    /**
     * @return The action properties.
     */
    @JsonProperty("action")
    public RuleActionDto getAction() {
        return action;
    }

    /**
     * @return The number of completed executions.
     */
    @JsonProperty("numSucceeded")
    public int getNumSucceeded() {
        return numSucceeded;
    }

    /**
     * @return The number of failed executions.
     */
    @JsonProperty("numFailed")
    public int getNumFailed() {
        return numFailed;
    }

    /**
     * @return The date and time when the rule was executed the last time.
     */
    @JsonProperty("lastExecuted")
    public Optional<OffsetDateTime> getLastExecuted() {
        return lastExecuted;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RuleDto && equalTo((RuleDto) other);
    }

    private boolean equalTo(RuleDto other) {
        return links.equals(other.links)
                && id.equals(other.id)
                && createdBy.equals(other.createdBy)
                && lastModifiedBy.equals(other.lastModifiedBy)
                && created.equals(other.created)
                && lastModified.equals(other.lastModified)
                && version == other.version
                && isEnabled == other.isEnabled
                && name.equals(other.name)
                && trigger.equals(other.trigger)
                && action.equals(other.action)
                && numSucceeded == other.numSucceeded
                && numFailed == other.numFailed
                && lastExecuted.equals(other.lastExecuted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.links,
                this.id,
                this.createdBy,
                this.lastModifiedBy,
                this.created,
                this.lastModified,
                this.version,
                this.isEnabled,
                this.name,
                this.trigger,
                this.action,
                this.numSucceeded,
                this.numFailed,
                this.lastExecuted);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        CreatedByStage id(String id);

        Builder from(RuleDto other);
    }

    public interface CreatedByStage {
        LastModifiedByStage createdBy(String createdBy);
    }

    public interface LastModifiedByStage {
        CreatedStage lastModifiedBy(String lastModifiedBy);
    }

    public interface CreatedStage {
        LastModifiedStage created(OffsetDateTime created);
    }

    public interface LastModifiedStage {
        VersionStage lastModified(OffsetDateTime lastModified);
    }

    public interface VersionStage {
        IsEnabledStage version(int version);
    }

    public interface IsEnabledStage {
        TriggerStage isEnabled(boolean isEnabled);
    }

    public interface TriggerStage {
        ActionStage trigger(RuleTriggerDto trigger);
    }

    public interface ActionStage {
        NumSucceededStage action(RuleActionDto action);
    }

    public interface NumSucceededStage {
        NumFailedStage numSucceeded(int numSucceeded);
    }

    public interface NumFailedStage {
        _FinalStage numFailed(int numFailed);
    }

    public interface _FinalStage {
        RuleDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);

        _FinalStage name(Optional<String> name);

        _FinalStage name(String name);

        _FinalStage lastExecuted(Optional<OffsetDateTime> lastExecuted);

        _FinalStage lastExecuted(OffsetDateTime lastExecuted);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements IdStage,
                    CreatedByStage,
                    LastModifiedByStage,
                    CreatedStage,
                    LastModifiedStage,
                    VersionStage,
                    IsEnabledStage,
                    TriggerStage,
                    ActionStage,
                    NumSucceededStage,
                    NumFailedStage,
                    _FinalStage {
        private String id;

        private String createdBy;

        private String lastModifiedBy;

        private OffsetDateTime created;

        private OffsetDateTime lastModified;

        private int version;

        private boolean isEnabled;

        private RuleTriggerDto trigger;

        private RuleActionDto action;

        private int numSucceeded;

        private int numFailed;

        private Optional<OffsetDateTime> lastExecuted = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(RuleDto other) {
            links(other.getLinks());
            id(other.getId());
            createdBy(other.getCreatedBy());
            lastModifiedBy(other.getLastModifiedBy());
            created(other.getCreated());
            lastModified(other.getLastModified());
            version(other.getVersion());
            isEnabled(other.getIsEnabled());
            name(other.getName());
            trigger(other.getTrigger());
            action(other.getAction());
            numSucceeded(other.getNumSucceeded());
            numFailed(other.getNumFailed());
            lastExecuted(other.getLastExecuted());
            return this;
        }

        /**
         * <p>The ID of the rule.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("id")
        public CreatedByStage id(String id) {
            this.id = id;
            return this;
        }

        /**
         * <p>The user that has created the rule.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("createdBy")
        public LastModifiedByStage createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        /**
         * <p>The user that has updated the rule.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("lastModifiedBy")
        public CreatedStage lastModifiedBy(String lastModifiedBy) {
            this.lastModifiedBy = lastModifiedBy;
            return this;
        }

        /**
         * <p>The date and time when the rule has been created.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("created")
        public LastModifiedStage created(OffsetDateTime created) {
            this.created = created;
            return this;
        }

        /**
         * <p>The date and time when the rule has been modified last.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("lastModified")
        public VersionStage lastModified(OffsetDateTime lastModified) {
            this.lastModified = lastModified;
            return this;
        }

        /**
         * <p>The version of the rule.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("version")
        public IsEnabledStage version(int version) {
            this.version = version;
            return this;
        }

        /**
         * <p>Determines if the rule is enabled.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("isEnabled")
        public TriggerStage isEnabled(boolean isEnabled) {
            this.isEnabled = isEnabled;
            return this;
        }

        /**
         * <p>The trigger properties.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("trigger")
        public ActionStage trigger(RuleTriggerDto trigger) {
            this.trigger = trigger;
            return this;
        }

        /**
         * <p>The action properties.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("action")
        public NumSucceededStage action(RuleActionDto action) {
            this.action = action;
            return this;
        }

        /**
         * <p>The number of completed executions.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("numSucceeded")
        public NumFailedStage numSucceeded(int numSucceeded) {
            this.numSucceeded = numSucceeded;
            return this;
        }

        /**
         * <p>The number of failed executions.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("numFailed")
        public _FinalStage numFailed(int numFailed) {
            this.numFailed = numFailed;
            return this;
        }

        /**
         * <p>The date and time when the rule was executed the last time.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage lastExecuted(OffsetDateTime lastExecuted) {
            this.lastExecuted = Optional.of(lastExecuted);
            return this;
        }

        @Override
        @JsonSetter(value = "lastExecuted", nulls = Nulls.SKIP)
        public _FinalStage lastExecuted(Optional<OffsetDateTime> lastExecuted) {
            this.lastExecuted = lastExecuted;
            return this;
        }

        /**
         * <p>Optional rule name.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage name(String name) {
            this.name = Optional.of(name);
            return this;
        }

        @Override
        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public _FinalStage name(Optional<String> name) {
            this.name = name;
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
        public RuleDto build() {
            return new RuleDto(
                    links,
                    id,
                    createdBy,
                    lastModifiedBy,
                    created,
                    lastModified,
                    version,
                    isEnabled,
                    name,
                    trigger,
                    action,
                    numSucceeded,
                    numFailed,
                    lastExecuted);
        }
    }
}
