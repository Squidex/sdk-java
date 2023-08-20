package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AzureQueueRuleActionDto.Builder.class)
public final class AzureQueueRuleActionDto {
    private final String connectionString;

    private final String queue;

    private final Optional<String> payload;

    private AzureQueueRuleActionDto(String connectionString, String queue, Optional<String> payload) {
        this.connectionString = connectionString;
        this.queue = queue;
        this.payload = payload;
    }

    /**
     * @return The connection string to the storage account. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("connectionString")
    public String getConnectionString() {
        return connectionString;
    }

    /**
     * @return The name of the queue. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("queue")
    public String getQueue() {
        return queue;
    }

    /**
     * @return Leave it empty to use the full event as body.
     */
    @JsonProperty("payload")
    public Optional<String> getPayload() {
        return payload;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AzureQueueRuleActionDto && equalTo((AzureQueueRuleActionDto) other);
    }

    private boolean equalTo(AzureQueueRuleActionDto other) {
        return connectionString.equals(other.connectionString)
                && queue.equals(other.queue)
                && payload.equals(other.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.connectionString, this.queue, this.payload);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ConnectionStringStage builder() {
        return new Builder();
    }

    public interface ConnectionStringStage {
        QueueStage connectionString(String connectionString);

        Builder from(AzureQueueRuleActionDto other);
    }

    public interface QueueStage {
        _FinalStage queue(String queue);
    }

    public interface _FinalStage {
        AzureQueueRuleActionDto build();

        _FinalStage payload(Optional<String> payload);

        _FinalStage payload(String payload);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ConnectionStringStage, QueueStage, _FinalStage {
        private String connectionString;

        private String queue;

        private Optional<String> payload = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(AzureQueueRuleActionDto other) {
            connectionString(other.getConnectionString());
            queue(other.getQueue());
            payload(other.getPayload());
            return this;
        }

        /**
         * <p>The connection string to the storage account. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("connectionString")
        public QueueStage connectionString(String connectionString) {
            this.connectionString = connectionString;
            return this;
        }

        /**
         * <p>The name of the queue. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("queue")
        public _FinalStage queue(String queue) {
            this.queue = queue;
            return this;
        }

        /**
         * <p>Leave it empty to use the full event as body.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage payload(String payload) {
            this.payload = Optional.of(payload);
            return this;
        }

        @Override
        @JsonSetter(value = "payload", nulls = Nulls.SKIP)
        public _FinalStage payload(Optional<String> payload) {
            this.payload = payload;
            return this;
        }

        @Override
        public AzureQueueRuleActionDto build() {
            return new AzureQueueRuleActionDto(connectionString, queue, payload);
        }
    }
}
