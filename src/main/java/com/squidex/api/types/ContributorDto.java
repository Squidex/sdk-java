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
@JsonDeserialize(builder = ContributorDto.Builder.class)
public final class ContributorDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final String contributorId;

    private final String contributorName;

    private final String contributorEmail;

    private final Optional<String> role;

    private ContributorDto(
            Map<String, ResourceLink> links,
            String contributorId,
            String contributorName,
            String contributorEmail,
            Optional<String> role) {
        this.links = links;
        this.contributorId = contributorId;
        this.contributorName = contributorName;
        this.contributorEmail = contributorEmail;
        this.role = role;
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
     * @return The ID of the user that contributes to the app.
     */
    @JsonProperty("contributorId")
    public String getContributorId() {
        return contributorId;
    }

    /**
     * @return The display name.
     */
    @JsonProperty("contributorName")
    public String getContributorName() {
        return contributorName;
    }

    /**
     * @return The email address.
     */
    @JsonProperty("contributorEmail")
    public String getContributorEmail() {
        return contributorEmail;
    }

    /**
     * @return The role of the contributor.
     */
    @JsonProperty("role")
    public Optional<String> getRole() {
        return role;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ContributorDto && equalTo((ContributorDto) other);
    }

    private boolean equalTo(ContributorDto other) {
        return links.equals(other.links)
                && contributorId.equals(other.contributorId)
                && contributorName.equals(other.contributorName)
                && contributorEmail.equals(other.contributorEmail)
                && role.equals(other.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.links, this.contributorId, this.contributorName, this.contributorEmail, this.role);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ContributorIdStage builder() {
        return new Builder();
    }

    public interface ContributorIdStage {
        ContributorNameStage contributorId(String contributorId);

        Builder from(ContributorDto other);
    }

    public interface ContributorNameStage {
        ContributorEmailStage contributorName(String contributorName);
    }

    public interface ContributorEmailStage {
        _FinalStage contributorEmail(String contributorEmail);
    }

    public interface _FinalStage {
        ContributorDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);

        _FinalStage role(Optional<String> role);

        _FinalStage role(String role);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements ContributorIdStage, ContributorNameStage, ContributorEmailStage, _FinalStage {
        private String contributorId;

        private String contributorName;

        private String contributorEmail;

        private Optional<String> role = Optional.empty();

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(ContributorDto other) {
            links(other.getLinks());
            contributorId(other.getContributorId());
            contributorName(other.getContributorName());
            contributorEmail(other.getContributorEmail());
            role(other.getRole());
            return this;
        }

        /**
         * <p>The ID of the user that contributes to the app.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("contributorId")
        public ContributorNameStage contributorId(String contributorId) {
            this.contributorId = contributorId;
            return this;
        }

        /**
         * <p>The display name.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("contributorName")
        public ContributorEmailStage contributorName(String contributorName) {
            this.contributorName = contributorName;
            return this;
        }

        /**
         * <p>The email address.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("contributorEmail")
        public _FinalStage contributorEmail(String contributorEmail) {
            this.contributorEmail = contributorEmail;
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
        public ContributorDto build() {
            return new ContributorDto(links, contributorId, contributorName, contributorEmail, role);
        }
    }
}
