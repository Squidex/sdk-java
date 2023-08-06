package com.squidex.api.resources.history.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = HistoryGetTeamHistoryRequest.Builder.class)
public final class HistoryGetTeamHistoryRequest {
    private final Optional<String> channel;

    private HistoryGetTeamHistoryRequest(Optional<String> channel) {
        this.channel = channel;
    }

    /**
     * @return The name of the channel.
     */
    @JsonProperty("channel")
    public Optional<String> getChannel() {
        return channel;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof HistoryGetTeamHistoryRequest && equalTo((HistoryGetTeamHistoryRequest) other);
    }

    private boolean equalTo(HistoryGetTeamHistoryRequest other) {
        return channel.equals(other.channel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.channel);
    }

    @Override
    public String toString() {
        return "HistoryGetTeamHistoryRequest{" + "channel: " + channel + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> channel = Optional.empty();

        private Builder() {}

        public Builder from(HistoryGetTeamHistoryRequest other) {
            channel(other.getChannel());
            return this;
        }

        @JsonSetter(value = "channel", nulls = Nulls.SKIP)
        public Builder channel(Optional<String> channel) {
            this.channel = channel;
            return this;
        }

        public Builder channel(String channel) {
            this.channel = Optional.of(channel);
            return this;
        }

        public HistoryGetTeamHistoryRequest build() {
            return new HistoryGetTeamHistoryRequest(channel);
        }
    }
}
