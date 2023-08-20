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
@JsonDeserialize(builder = UserDto.Builder.class)
public final class UserDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final String id;

    private final String email;

    private final String displayName;

    private final boolean isLocked;

    private final List<String> permissions;

    private UserDto(
            Map<String, ResourceLink> links,
            String id,
            String email,
            String displayName,
            boolean isLocked,
            List<String> permissions) {
        this.links = links;
        this.id = id;
        this.email = email;
        this.displayName = displayName;
        this.isLocked = isLocked;
        this.permissions = permissions;
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
     * @return The ID of the user.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The email of the user. Unique value.
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * @return The display name (usually first name and last name) of the user.
     */
    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @return Determines if the user is locked.
     */
    @JsonProperty("isLocked")
    public boolean getIsLocked() {
        return isLocked;
    }

    /**
     * @return Additional permissions for the user.
     */
    @JsonProperty("permissions")
    public List<String> getPermissions() {
        return permissions;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UserDto && equalTo((UserDto) other);
    }

    private boolean equalTo(UserDto other) {
        return links.equals(other.links)
                && id.equals(other.id)
                && email.equals(other.email)
                && displayName.equals(other.displayName)
                && isLocked == other.isLocked
                && permissions.equals(other.permissions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.links, this.id, this.email, this.displayName, this.isLocked, this.permissions);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        EmailStage id(String id);

        Builder from(UserDto other);
    }

    public interface EmailStage {
        DisplayNameStage email(String email);
    }

    public interface DisplayNameStage {
        IsLockedStage displayName(String displayName);
    }

    public interface IsLockedStage {
        _FinalStage isLocked(boolean isLocked);
    }

    public interface _FinalStage {
        UserDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);

        _FinalStage permissions(List<String> permissions);

        _FinalStage addPermissions(String permissions);

        _FinalStage addAllPermissions(List<String> permissions);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, EmailStage, DisplayNameStage, IsLockedStage, _FinalStage {
        private String id;

        private String email;

        private String displayName;

        private boolean isLocked;

        private List<String> permissions = new ArrayList<>();

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(UserDto other) {
            links(other.getLinks());
            id(other.getId());
            email(other.getEmail());
            displayName(other.getDisplayName());
            isLocked(other.getIsLocked());
            permissions(other.getPermissions());
            return this;
        }

        /**
         * <p>The ID of the user.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("id")
        public EmailStage id(String id) {
            this.id = id;
            return this;
        }

        /**
         * <p>The email of the user. Unique value.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("email")
        public DisplayNameStage email(String email) {
            this.email = email;
            return this;
        }

        /**
         * <p>The display name (usually first name and last name) of the user.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("displayName")
        public IsLockedStage displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        /**
         * <p>Determines if the user is locked.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("isLocked")
        public _FinalStage isLocked(boolean isLocked) {
            this.isLocked = isLocked;
            return this;
        }

        /**
         * <p>Additional permissions for the user.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllPermissions(List<String> permissions) {
            this.permissions.addAll(permissions);
            return this;
        }

        /**
         * <p>Additional permissions for the user.</p>
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
        public UserDto build() {
            return new UserDto(links, id, email, displayName, isLocked, permissions);
        }
    }
}
