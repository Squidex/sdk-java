package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = RoleDto.Builder.class)
public final class RoleDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final String name;

    private final int numClients;

    private final int numContributors;

    private final boolean isDefaultRole;

    private final List<String> permissions;

    private final Map<String, Object> properties;

    private RoleDto(
            Map<String, ResourceLink> links,
            String name,
            int numClients,
            int numContributors,
            boolean isDefaultRole,
            List<String> permissions,
            Map<String, Object> properties) {
        this.links = links;
        this.name = name;
        this.numClients = numClients;
        this.numContributors = numContributors;
        this.isDefaultRole = isDefaultRole;
        this.permissions = permissions;
        this.properties = properties;
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
     * @return The role name.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @return The number of clients with this role.
     */
    @JsonProperty("numClients")
    public int getNumClients() {
        return numClients;
    }

    /**
     * @return The number of contributors with this role.
     */
    @JsonProperty("numContributors")
    public int getNumContributors() {
        return numContributors;
    }

    /**
     * @return Indicates if the role is an builtin default role.
     */
    @JsonProperty("isDefaultRole")
    public boolean getIsDefaultRole() {
        return isDefaultRole;
    }

    /**
     * @return Associated list of permissions.
     */
    @JsonProperty("permissions")
    public List<String> getPermissions() {
        return permissions;
    }

    /**
     * @return Associated list of UI properties.
     */
    @JsonProperty("properties")
    public Map<String, Object> getProperties() {
        return properties;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RoleDto && equalTo((RoleDto) other);
    }

    private boolean equalTo(RoleDto other) {
        return links.equals(other.links)
                && name.equals(other.name)
                && numClients == other.numClients
                && numContributors == other.numContributors
                && isDefaultRole == other.isDefaultRole
                && permissions.equals(other.permissions)
                && properties.equals(other.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.links,
                this.name,
                this.numClients,
                this.numContributors,
                this.isDefaultRole,
                this.permissions,
                this.properties);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        NumClientsStage name(String name);

        Builder from(RoleDto other);
    }

    public interface NumClientsStage {
        NumContributorsStage numClients(int numClients);
    }

    public interface NumContributorsStage {
        IsDefaultRoleStage numContributors(int numContributors);
    }

    public interface IsDefaultRoleStage {
        _FinalStage isDefaultRole(boolean isDefaultRole);
    }

    public interface _FinalStage {
        RoleDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);

        _FinalStage permissions(List<String> permissions);

        _FinalStage addPermissions(String permissions);

        _FinalStage addAllPermissions(List<String> permissions);

        _FinalStage properties(Map<String, Object> properties);

        _FinalStage putAllProperties(Map<String, Object> properties);

        _FinalStage properties(String key, Object value);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements NameStage, NumClientsStage, NumContributorsStage, IsDefaultRoleStage, _FinalStage {
        private String name;

        private int numClients;

        private int numContributors;

        private boolean isDefaultRole;

        private Map<String, Object> properties = new LinkedHashMap<>();

        private List<String> permissions = new ArrayList<>();

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(RoleDto other) {
            links(other.getLinks());
            name(other.getName());
            numClients(other.getNumClients());
            numContributors(other.getNumContributors());
            isDefaultRole(other.getIsDefaultRole());
            permissions(other.getPermissions());
            properties(other.getProperties());
            return this;
        }

        /**
         * <p>The role name.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name")
        public NumClientsStage name(String name) {
            this.name = name;
            return this;
        }

        /**
         * <p>The number of clients with this role.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("numClients")
        public NumContributorsStage numClients(int numClients) {
            this.numClients = numClients;
            return this;
        }

        /**
         * <p>The number of contributors with this role.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("numContributors")
        public IsDefaultRoleStage numContributors(int numContributors) {
            this.numContributors = numContributors;
            return this;
        }

        /**
         * <p>Indicates if the role is an builtin default role.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("isDefaultRole")
        public _FinalStage isDefaultRole(boolean isDefaultRole) {
            this.isDefaultRole = isDefaultRole;
            return this;
        }

        /**
         * <p>Associated list of UI properties.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage properties(String key, Object value) {
            this.properties.put(key, value);
            return this;
        }

        /**
         * <p>Associated list of UI properties.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage putAllProperties(Map<String, Object> properties) {
            this.properties.putAll(properties);
            return this;
        }

        @Override
        @JsonSetter(value = "properties", nulls = Nulls.SKIP)
        public _FinalStage properties(Map<String, Object> properties) {
            this.properties.clear();
            this.properties.putAll(properties);
            return this;
        }

        /**
         * <p>Associated list of permissions.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllPermissions(List<String> permissions) {
            this.permissions.addAll(permissions);
            return this;
        }

        /**
         * <p>Associated list of permissions.</p>
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
        public RoleDto build() {
            return new RoleDto(links, name, numClients, numContributors, isDefaultRole, permissions, properties);
        }
    }
}
