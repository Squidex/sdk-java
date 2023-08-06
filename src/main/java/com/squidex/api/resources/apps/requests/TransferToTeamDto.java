package com.squidex.api.resources.apps.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TransferToTeamDto.Builder.class)
public final class TransferToTeamDto {
    private final Optional<String> teamId;

    private TransferToTeamDto(Optional<String> teamId) {
        this.teamId = teamId;
    }

    /**
     * @return The ID of the team.
     */
    @JsonProperty("teamId")
    public Optional<String> getTeamId() {
        return teamId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TransferToTeamDto && equalTo((TransferToTeamDto) other);
    }

    private boolean equalTo(TransferToTeamDto other) {
        return teamId.equals(other.teamId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.teamId);
    }

    @Override
    public String toString() {
        return "TransferToTeamDto{" + "teamId: " + teamId + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> teamId = Optional.empty();

        private Builder() {}

        public Builder from(TransferToTeamDto other) {
            teamId(other.getTeamId());
            return this;
        }

        @JsonSetter(value = "teamId", nulls = Nulls.SKIP)
        public Builder teamId(Optional<String> teamId) {
            this.teamId = teamId;
            return this;
        }

        public Builder teamId(String teamId) {
            this.teamId = Optional.of(teamId);
            return this;
        }

        public TransferToTeamDto build() {
            return new TransferToTeamDto(teamId);
        }
    }
}
