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
@JsonDeserialize(builder = TeamDto.Builder.class)
public final class TeamDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final String id;

    private final String name;

    private final int version;

    private final OffsetDateTime created;

    private final OffsetDateTime lastModified;

    private final Optional<String> roleName;

    private TeamDto(
            Map<String, ResourceLink> links,
            String id,
            String name,
            int version,
            OffsetDateTime created,
            OffsetDateTime lastModified,
            Optional<String> roleName) {
        this.links = links;
        this.id = id;
        this.name = name;
        this.version = version;
        this.created = created;
        this.lastModified = lastModified;
        this.roleName = roleName;
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
     * @return The ID of the team.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The name of the team.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @return The version of the team.
     */
    @JsonProperty("version")
    public int getVersion() {
        return version;
    }

    /**
     * @return The timestamp when the team has been created.
     */
    @JsonProperty("created")
    public OffsetDateTime getCreated() {
        return created;
    }

    /**
     * @return The timestamp when the team has been modified last.
     */
    @JsonProperty("lastModified")
    public OffsetDateTime getLastModified() {
        return lastModified;
    }

    /**
     * @return The role name of the user.
     */
    @JsonProperty("roleName")
    public Optional<String> getRoleName() {
        return roleName;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TeamDto && equalTo((TeamDto) other);
    }

    private boolean equalTo(TeamDto other) {
        return links.equals(other.links)
                && id.equals(other.id)
                && name.equals(other.name)
                && version == other.version
                && created.equals(other.created)
                && lastModified.equals(other.lastModified)
                && roleName.equals(other.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.links, this.id, this.name, this.version, this.created, this.lastModified, this.roleName);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        NameStage id(String id);

        Builder from(TeamDto other);
    }

    public interface NameStage {
        VersionStage name(String name);
    }

    public interface VersionStage {
        CreatedStage version(int version);
    }

    public interface CreatedStage {
        LastModifiedStage created(OffsetDateTime created);
    }

    public interface LastModifiedStage {
        _FinalStage lastModified(OffsetDateTime lastModified);
    }

    public interface _FinalStage {
        TeamDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);

        _FinalStage roleName(Optional<String> roleName);

        _FinalStage roleName(String roleName);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements IdStage, NameStage, VersionStage, CreatedStage, LastModifiedStage, _FinalStage {
        private String id;

        private String name;

        private int version;

        private OffsetDateTime created;

        private OffsetDateTime lastModified;

        private Optional<String> roleName = Optional.empty();

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(TeamDto other) {
            links(other.getLinks());
            id(other.getId());
            name(other.getName());
            version(other.getVersion());
            created(other.getCreated());
            lastModified(other.getLastModified());
            roleName(other.getRoleName());
            return this;
        }

        /**
         * <p>The ID of the team.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("id")
        public NameStage id(String id) {
            this.id = id;
            return this;
        }

        /**
         * <p>The name of the team.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name")
        public VersionStage name(String name) {
            this.name = name;
            return this;
        }

        /**
         * <p>The version of the team.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("version")
        public CreatedStage version(int version) {
            this.version = version;
            return this;
        }

        /**
         * <p>The timestamp when the team has been created.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("created")
        public LastModifiedStage created(OffsetDateTime created) {
            this.created = created;
            return this;
        }

        /**
         * <p>The timestamp when the team has been modified last.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("lastModified")
        public _FinalStage lastModified(OffsetDateTime lastModified) {
            this.lastModified = lastModified;
            return this;
        }

        /**
         * <p>The role name of the user.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage roleName(String roleName) {
            this.roleName = Optional.of(roleName);
            return this;
        }

        @Override
        @JsonSetter(value = "roleName", nulls = Nulls.SKIP)
        public _FinalStage roleName(Optional<String> roleName) {
            this.roleName = roleName;
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
        public TeamDto build() {
            return new TeamDto(links, id, name, version, created, lastModified, roleName);
        }
    }
}
