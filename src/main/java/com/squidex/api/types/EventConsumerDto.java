package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = EventConsumerDto.Builder.class)
public final class EventConsumerDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final boolean isStopped;

    private final boolean isResetting;

    private final int count;

    private final String name;

    private final Optional<String> error;

    private final Optional<String> position;

    private EventConsumerDto(
            Map<String, ResourceLink> links,
            boolean isStopped,
            boolean isResetting,
            int count,
            String name,
            Optional<String> error,
            Optional<String> position) {
        this.links = links;
        this.isStopped = isStopped;
        this.isResetting = isResetting;
        this.count = count;
        this.name = name;
        this.error = error;
        this.position = position;
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
     * @return Indicates if the event consumer has been started.
     */
    @JsonProperty("isStopped")
    public boolean getIsStopped() {
        return isStopped;
    }

    /**
     * @return Indicates if the event consumer is resetting at the moment.
     */
    @JsonProperty("isResetting")
    public boolean getIsResetting() {
        return isResetting;
    }

    /**
     * @return The number of handled events.
     */
    @JsonProperty("count")
    public int getCount() {
        return count;
    }

    /**
     * @return The name of the event consumer. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @return The error details if the event consumer has been stopped after a failure.
     */
    @JsonProperty("error")
    public Optional<String> getError() {
        return error;
    }

    /**
     * @return The position within the vent stream.
     */
    @JsonProperty("position")
    public Optional<String> getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof EventConsumerDto && equalTo((EventConsumerDto) other);
    }

    private boolean equalTo(EventConsumerDto other) {
        return links.equals(other.links)
                && isStopped == other.isStopped
                && isResetting == other.isResetting
                && count == other.count
                && name.equals(other.name)
                && error.equals(other.error)
                && position.equals(other.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.links, this.isStopped, this.isResetting, this.count, this.name, this.error, this.position);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IsStoppedStage builder() {
        return new Builder();
    }

    public interface IsStoppedStage {
        IsResettingStage isStopped(boolean isStopped);

        Builder from(EventConsumerDto other);
    }

    public interface IsResettingStage {
        CountStage isResetting(boolean isResetting);
    }

    public interface CountStage {
        NameStage count(int count);
    }

    public interface NameStage {
        _FinalStage name(String name);
    }

    public interface _FinalStage {
        EventConsumerDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);

        _FinalStage error(Optional<String> error);

        _FinalStage error(String error);

        _FinalStage position(Optional<String> position);

        _FinalStage position(String position);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IsStoppedStage, IsResettingStage, CountStage, NameStage, _FinalStage {
        private boolean isStopped;

        private boolean isResetting;

        private int count;

        private String name;

        private Optional<String> position = Optional.empty();

        private Optional<String> error = Optional.empty();

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(EventConsumerDto other) {
            links(other.getLinks());
            isStopped(other.getIsStopped());
            isResetting(other.getIsResetting());
            count(other.getCount());
            name(other.getName());
            error(other.getError());
            position(other.getPosition());
            return this;
        }

        /**
         * <p>Indicates if the event consumer has been started.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("isStopped")
        public IsResettingStage isStopped(boolean isStopped) {
            this.isStopped = isStopped;
            return this;
        }

        /**
         * <p>Indicates if the event consumer is resetting at the moment.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("isResetting")
        public CountStage isResetting(boolean isResetting) {
            this.isResetting = isResetting;
            return this;
        }

        /**
         * <p>The number of handled events.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("count")
        public NameStage count(int count) {
            this.count = count;
            return this;
        }

        /**
         * <p>The name of the event consumer. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name")
        public _FinalStage name(String name) {
            this.name = name;
            return this;
        }

        /**
         * <p>The position within the vent stream.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage position(String position) {
            this.position = Optional.of(position);
            return this;
        }

        @Override
        @JsonSetter(value = "position", nulls = Nulls.SKIP)
        public _FinalStage position(Optional<String> position) {
            this.position = position;
            return this;
        }

        /**
         * <p>The error details if the event consumer has been stopped after a failure.</p>
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
        public EventConsumerDto build() {
            return new EventConsumerDto(links, isStopped, isResetting, count, name, error, position);
        }
    }
}
