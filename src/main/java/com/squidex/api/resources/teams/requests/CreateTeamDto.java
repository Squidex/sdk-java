/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squidex.api.resources.teams.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CreateTeamDto.Builder.class)
public final class CreateTeamDto {
    private final String name;

    private CreateTeamDto(String name) {
        this.name = name;
    }

    /**
     * @return The name of the team.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateTeamDto && equalTo((CreateTeamDto) other);
    }

    private boolean equalTo(CreateTeamDto other) {
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        _FinalStage name(String name);

        Builder from(CreateTeamDto other);
    }

    public interface _FinalStage {
        CreateTeamDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, _FinalStage {
        private String name;

        private Builder() {}

        @Override
        public Builder from(CreateTeamDto other) {
            name(other.getName());
            return this;
        }

        /**
         * <p>The name of the team.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name")
        public _FinalStage name(String name) {
            this.name = name;
            return this;
        }

        @Override
        public CreateTeamDto build() {
            return new CreateTeamDto(name);
        }
    }
}
