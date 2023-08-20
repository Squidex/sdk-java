package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UiSettingsDto.Builder.class)
public final class UiSettingsDto {
    private final boolean canCreateApps;

    private final boolean canCreateTeams;

    private UiSettingsDto(boolean canCreateApps, boolean canCreateTeams) {
        this.canCreateApps = canCreateApps;
        this.canCreateTeams = canCreateTeams;
    }

    /**
     * @return True when the user can create apps.
     */
    @JsonProperty("canCreateApps")
    public boolean getCanCreateApps() {
        return canCreateApps;
    }

    /**
     * @return True when the user can create teams.
     */
    @JsonProperty("canCreateTeams")
    public boolean getCanCreateTeams() {
        return canCreateTeams;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UiSettingsDto && equalTo((UiSettingsDto) other);
    }

    private boolean equalTo(UiSettingsDto other) {
        return canCreateApps == other.canCreateApps && canCreateTeams == other.canCreateTeams;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.canCreateApps, this.canCreateTeams);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static CanCreateAppsStage builder() {
        return new Builder();
    }

    public interface CanCreateAppsStage {
        CanCreateTeamsStage canCreateApps(boolean canCreateApps);

        Builder from(UiSettingsDto other);
    }

    public interface CanCreateTeamsStage {
        _FinalStage canCreateTeams(boolean canCreateTeams);
    }

    public interface _FinalStage {
        UiSettingsDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements CanCreateAppsStage, CanCreateTeamsStage, _FinalStage {
        private boolean canCreateApps;

        private boolean canCreateTeams;

        private Builder() {}

        @Override
        public Builder from(UiSettingsDto other) {
            canCreateApps(other.getCanCreateApps());
            canCreateTeams(other.getCanCreateTeams());
            return this;
        }

        /**
         * <p>True when the user can create apps.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("canCreateApps")
        public CanCreateTeamsStage canCreateApps(boolean canCreateApps) {
            this.canCreateApps = canCreateApps;
            return this;
        }

        /**
         * <p>True when the user can create teams.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("canCreateTeams")
        public _FinalStage canCreateTeams(boolean canCreateTeams) {
            this.canCreateTeams = canCreateTeams;
            return this;
        }

        @Override
        public UiSettingsDto build() {
            return new UiSettingsDto(canCreateApps, canCreateTeams);
        }
    }
}
