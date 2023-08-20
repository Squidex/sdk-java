package com.squidex.api.resources.apps.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UpdateRoleDto.Builder.class)
public final class UpdateRoleDto {
    private final List<String> permissions;

    private final Optional<Map<String, Object>> properties;

    private UpdateRoleDto(List<String> permissions, Optional<Map<String, Object>> properties) {
        this.permissions = permissions;
        this.properties = properties;
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
    public Optional<Map<String, Object>> getProperties() {
        return properties;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdateRoleDto && equalTo((UpdateRoleDto) other);
    }

    private boolean equalTo(UpdateRoleDto other) {
        return permissions.equals(other.permissions) && properties.equals(other.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.permissions, this.properties);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private List<String> permissions = new ArrayList<>();

        private Optional<Map<String, Object>> properties = Optional.empty();

        private Builder() {}

        public Builder from(UpdateRoleDto other) {
            permissions(other.getPermissions());
            properties(other.getProperties());
            return this;
        }

        @JsonSetter(value = "permissions", nulls = Nulls.SKIP)
        public Builder permissions(List<String> permissions) {
            this.permissions.clear();
            this.permissions.addAll(permissions);
            return this;
        }

        public Builder addPermissions(String permissions) {
            this.permissions.add(permissions);
            return this;
        }

        public Builder addAllPermissions(List<String> permissions) {
            this.permissions.addAll(permissions);
            return this;
        }

        @JsonSetter(value = "properties", nulls = Nulls.SKIP)
        public Builder properties(Optional<Map<String, Object>> properties) {
            this.properties = properties;
            return this;
        }

        public Builder properties(Map<String, Object> properties) {
            this.properties = Optional.of(properties);
            return this;
        }

        public UpdateRoleDto build() {
            return new UpdateRoleDto(permissions, properties);
        }
    }
}
