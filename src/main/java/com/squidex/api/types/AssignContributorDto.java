package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AssignContributorDto.Builder.class)
public final class AssignContributorDto {
    private final String contributorId;

    private final Optional<String> role;

    private final Optional<Boolean> invite;

    private AssignContributorDto(String contributorId, Optional<String> role, Optional<Boolean> invite) {
        this.contributorId = contributorId;
        this.role = role;
        this.invite = invite;
    }

    /**
     * @return The id or email of the user to add to the app. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("contributorId")
    public String getContributorId() {
        return contributorId;
    }

    /**
     * @return The role of the contributor.
     */
    @JsonProperty("role")
    public Optional<String> getRole() {
        return role;
    }

    /**
     * @return Set to true to invite the user if he does not exist.
     */
    @JsonProperty("invite")
    public Optional<Boolean> getInvite() {
        return invite;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AssignContributorDto && equalTo((AssignContributorDto) other);
    }

    private boolean equalTo(AssignContributorDto other) {
        return contributorId.equals(other.contributorId) && role.equals(other.role) && invite.equals(other.invite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.contributorId, this.role, this.invite);
    }

    @Override
    public String toString() {
        return "AssignContributorDto{" + "contributorId: " + contributorId + ", role: " + role + ", invite: " + invite
                + "}";
    }

    public static ContributorIdStage builder() {
        return new Builder();
    }

    public interface ContributorIdStage {
        _FinalStage contributorId(String contributorId);

        Builder from(AssignContributorDto other);
    }

    public interface _FinalStage {
        AssignContributorDto build();

        _FinalStage role(Optional<String> role);

        _FinalStage role(String role);

        _FinalStage invite(Optional<Boolean> invite);

        _FinalStage invite(Boolean invite);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ContributorIdStage, _FinalStage {
        private String contributorId;

        private Optional<Boolean> invite = Optional.empty();

        private Optional<String> role = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(AssignContributorDto other) {
            contributorId(other.getContributorId());
            role(other.getRole());
            invite(other.getInvite());
            return this;
        }

        /**
         * <p>The id or email of the user to add to the app. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("contributorId")
        public _FinalStage contributorId(String contributorId) {
            this.contributorId = contributorId;
            return this;
        }

        /**
         * <p>Set to true to invite the user if he does not exist.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage invite(Boolean invite) {
            this.invite = Optional.of(invite);
            return this;
        }

        @Override
        @JsonSetter(value = "invite", nulls = Nulls.SKIP)
        public _FinalStage invite(Optional<Boolean> invite) {
            this.invite = invite;
            return this;
        }

        /**
         * <p>The role of the contributor.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage role(String role) {
            this.role = Optional.of(role);
            return this;
        }

        @Override
        @JsonSetter(value = "role", nulls = Nulls.SKIP)
        public _FinalStage role(Optional<String> role) {
            this.role = role;
            return this;
        }

        @Override
        public AssignContributorDto build() {
            return new AssignContributorDto(contributorId, role, invite);
        }
    }
}
