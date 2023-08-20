package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AppDto.Builder.class)
public final class AppDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final String id;

    private final String name;

    private final Optional<String> label;

    private final Optional<String> description;

    private final int version;

    private final OffsetDateTime created;

    private final OffsetDateTime lastModified;

    private final Optional<String> teamId;

    private final List<String> permissions;

    private final boolean canAccessApi;

    private final boolean canAccessContent;

    private final Optional<String> roleName;

    private final Map<String, Object> roleProperties;

    private AppDto(
            Map<String, ResourceLink> links,
            String id,
            String name,
            Optional<String> label,
            Optional<String> description,
            int version,
            OffsetDateTime created,
            OffsetDateTime lastModified,
            Optional<String> teamId,
            List<String> permissions,
            boolean canAccessApi,
            boolean canAccessContent,
            Optional<String> roleName,
            Map<String, Object> roleProperties) {
        this.links = links;
        this.id = id;
        this.name = name;
        this.label = label;
        this.description = description;
        this.version = version;
        this.created = created;
        this.lastModified = lastModified;
        this.teamId = teamId;
        this.permissions = permissions;
        this.canAccessApi = canAccessApi;
        this.canAccessContent = canAccessContent;
        this.roleName = roleName;
        this.roleProperties = roleProperties;
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
     * @return The ID of the app.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The name of the app.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @return The optional label of the app.
     */
    @JsonProperty("label")
    public Optional<String> getLabel() {
        return label;
    }

    /**
     * @return The optional description of the app.
     */
    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    /**
     * @return The version of the app.
     */
    @JsonProperty("version")
    public int getVersion() {
        return version;
    }

    /**
     * @return The timestamp when the app has been created.
     */
    @JsonProperty("created")
    public OffsetDateTime getCreated() {
        return created;
    }

    /**
     * @return The timestamp when the app has been modified last.
     */
    @JsonProperty("lastModified")
    public OffsetDateTime getLastModified() {
        return lastModified;
    }

    /**
     * @return The ID of the team.
     */
    @JsonProperty("teamId")
    public Optional<String> getTeamId() {
        return teamId;
    }

    /**
     * @return The permission level of the user.
     */
    @JsonProperty("permissions")
    public List<String> getPermissions() {
        return permissions;
    }

    /**
     * @return Indicates if the user can access the api.
     */
    @JsonProperty("canAccessApi")
    public boolean getCanAccessApi() {
        return canAccessApi;
    }

    /**
     * @return Indicates if the user can access at least one content.
     */
    @JsonProperty("canAccessContent")
    public boolean getCanAccessContent() {
        return canAccessContent;
    }

    /**
     * @return The role name of the user.
     */
    @JsonProperty("roleName")
    public Optional<String> getRoleName() {
        return roleName;
    }

    /**
     * @return The properties from the role.
     */
    @JsonProperty("roleProperties")
    public Map<String, Object> getRoleProperties() {
        return roleProperties;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AppDto && equalTo((AppDto) other);
    }

    private boolean equalTo(AppDto other) {
        return links.equals(other.links)
                && id.equals(other.id)
                && name.equals(other.name)
                && label.equals(other.label)
                && description.equals(other.description)
                && version == other.version
                && created.equals(other.created)
                && lastModified.equals(other.lastModified)
                && teamId.equals(other.teamId)
                && permissions.equals(other.permissions)
                && canAccessApi == other.canAccessApi
                && canAccessContent == other.canAccessContent
                && roleName.equals(other.roleName)
                && roleProperties.equals(other.roleProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.links,
                this.id,
                this.name,
                this.label,
                this.description,
                this.version,
                this.created,
                this.lastModified,
                this.teamId,
                this.permissions,
                this.canAccessApi,
                this.canAccessContent,
                this.roleName,
                this.roleProperties);
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

        Builder from(AppDto other);
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
        CanAccessApiStage lastModified(OffsetDateTime lastModified);
    }

    public interface CanAccessApiStage {
        CanAccessContentStage canAccessApi(boolean canAccessApi);
    }

    public interface CanAccessContentStage {
        _FinalStage canAccessContent(boolean canAccessContent);
    }

    public interface _FinalStage {
        AppDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);

        _FinalStage label(Optional<String> label);

        _FinalStage label(String label);

        _FinalStage description(Optional<String> description);

        _FinalStage description(String description);

        _FinalStage teamId(Optional<String> teamId);

        _FinalStage teamId(String teamId);

        _FinalStage permissions(List<String> permissions);

        _FinalStage addPermissions(String permissions);

        _FinalStage addAllPermissions(List<String> permissions);

        _FinalStage roleName(Optional<String> roleName);

        _FinalStage roleName(String roleName);

        _FinalStage roleProperties(Map<String, Object> roleProperties);

        _FinalStage putAllRoleProperties(Map<String, Object> roleProperties);

        _FinalStage roleProperties(String key, Object value);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements IdStage,
                    NameStage,
                    VersionStage,
                    CreatedStage,
                    LastModifiedStage,
                    CanAccessApiStage,
                    CanAccessContentStage,
                    _FinalStage {
        private String id;

        private String name;

        private int version;

        private OffsetDateTime created;

        private OffsetDateTime lastModified;

        private boolean canAccessApi;

        private boolean canAccessContent;

        private Map<String, Object> roleProperties = new LinkedHashMap<>();

        private Optional<String> roleName = Optional.empty();

        private List<String> permissions = new ArrayList<>();

        private Optional<String> teamId = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<String> label = Optional.empty();

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(AppDto other) {
            links(other.getLinks());
            id(other.getId());
            name(other.getName());
            label(other.getLabel());
            description(other.getDescription());
            version(other.getVersion());
            created(other.getCreated());
            lastModified(other.getLastModified());
            teamId(other.getTeamId());
            permissions(other.getPermissions());
            canAccessApi(other.getCanAccessApi());
            canAccessContent(other.getCanAccessContent());
            roleName(other.getRoleName());
            roleProperties(other.getRoleProperties());
            return this;
        }

        /**
         * <p>The ID of the app.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("id")
        public NameStage id(String id) {
            this.id = id;
            return this;
        }

        /**
         * <p>The name of the app.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name")
        public VersionStage name(String name) {
            this.name = name;
            return this;
        }

        /**
         * <p>The version of the app.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("version")
        public CreatedStage version(int version) {
            this.version = version;
            return this;
        }

        /**
         * <p>The timestamp when the app has been created.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("created")
        public LastModifiedStage created(OffsetDateTime created) {
            this.created = created;
            return this;
        }

        /**
         * <p>The timestamp when the app has been modified last.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("lastModified")
        public CanAccessApiStage lastModified(OffsetDateTime lastModified) {
            this.lastModified = lastModified;
            return this;
        }

        /**
         * <p>Indicates if the user can access the api.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("canAccessApi")
        public CanAccessContentStage canAccessApi(boolean canAccessApi) {
            this.canAccessApi = canAccessApi;
            return this;
        }

        /**
         * <p>Indicates if the user can access at least one content.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("canAccessContent")
        public _FinalStage canAccessContent(boolean canAccessContent) {
            this.canAccessContent = canAccessContent;
            return this;
        }

        /**
         * <p>The properties from the role.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage roleProperties(String key, Object value) {
            this.roleProperties.put(key, value);
            return this;
        }

        /**
         * <p>The properties from the role.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage putAllRoleProperties(Map<String, Object> roleProperties) {
            this.roleProperties.putAll(roleProperties);
            return this;
        }

        @Override
        @JsonSetter(value = "roleProperties", nulls = Nulls.SKIP)
        public _FinalStage roleProperties(Map<String, Object> roleProperties) {
            this.roleProperties.clear();
            this.roleProperties.putAll(roleProperties);
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
         * <p>The permission level of the user.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllPermissions(List<String> permissions) {
            this.permissions.addAll(permissions);
            return this;
        }

        /**
         * <p>The permission level of the user.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addPermissions(String permissions) {
            this.permissions.add(permissions);
            return this;
        }

        @Override
        @JsonSetter(value = "permissions", nulls = Nulls.SKIP)
        public _FinalStage permissions(List<String> permissions) {
            this.permissions.clear();
            this.permissions.addAll(permissions);
            return this;
        }

        /**
         * <p>The ID of the team.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage teamId(String teamId) {
            this.teamId = Optional.of(teamId);
            return this;
        }

        @Override
        @JsonSetter(value = "teamId", nulls = Nulls.SKIP)
        public _FinalStage teamId(Optional<String> teamId) {
            this.teamId = teamId;
            return this;
        }

        /**
         * <p>The optional description of the app.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage description(String description) {
            this.description = Optional.of(description);
            return this;
        }

        @Override
        @JsonSetter(value = "description", nulls = Nulls.SKIP)
        public _FinalStage description(Optional<String> description) {
            this.description = description;
            return this;
        }

        /**
         * <p>The optional label of the app.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage label(String label) {
            this.label = Optional.of(label);
            return this;
        }

        @Override
        @JsonSetter(value = "label", nulls = Nulls.SKIP)
        public _FinalStage label(Optional<String> label) {
            this.label = label;
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
        public AppDto build() {
            return new AppDto(
                    links,
                    id,
                    name,
                    label,
                    description,
                    version,
                    created,
                    lastModified,
                    teamId,
                    permissions,
                    canAccessApi,
                    canAccessContent,
                    roleName,
                    roleProperties);
        }
    }
}
