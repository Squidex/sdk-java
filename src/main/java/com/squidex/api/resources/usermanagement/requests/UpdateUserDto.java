package com.squidex.api.resources.usermanagement.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UpdateUserDto.Builder.class)
public final class UpdateUserDto {
    private final String email;

    private final String displayName;

    private final Optional<String> password;

    private final List<String> permissions;

    private UpdateUserDto(String email, String displayName, Optional<String> password, List<String> permissions) {
        this.email = email;
        this.displayName = displayName;
        this.password = password;
        this.permissions = permissions;
    }

    /**
     * @return The email of the user. Unique value. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * @return The display name (usually first name and last name) of the user. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @return The password of the user.
     */
    @JsonProperty("password")
    public Optional<String> getPassword() {
        return password;
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
        return other instanceof UpdateUserDto && equalTo((UpdateUserDto) other);
    }

    private boolean equalTo(UpdateUserDto other) {
        return email.equals(other.email)
                && displayName.equals(other.displayName)
                && password.equals(other.password)
                && permissions.equals(other.permissions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.email, this.displayName, this.password, this.permissions);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static EmailStage builder() {
        return new Builder();
    }

    public interface EmailStage {
        DisplayNameStage email(String email);

        Builder from(UpdateUserDto other);
    }

    public interface DisplayNameStage {
        _FinalStage displayName(String displayName);
    }

    public interface _FinalStage {
        UpdateUserDto build();

        _FinalStage password(Optional<String> password);

        _FinalStage password(String password);

        _FinalStage permissions(List<String> permissions);

        _FinalStage addPermissions(String permissions);

        _FinalStage addAllPermissions(List<String> permissions);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements EmailStage, DisplayNameStage, _FinalStage {
        private String email;

        private String displayName;

        private List<String> permissions = new ArrayList<>();

        private Optional<String> password = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(UpdateUserDto other) {
            email(other.getEmail());
            displayName(other.getDisplayName());
            password(other.getPassword());
            permissions(other.getPermissions());
            return this;
        }

        /**
         * <p>The email of the user. Unique value. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("email")
        public DisplayNameStage email(String email) {
            this.email = email;
            return this;
        }

        /**
         * <p>The display name (usually first name and last name) of the user. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("displayName")
        public _FinalStage displayName(String displayName) {
            this.displayName = displayName;
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
         * <p>The password of the user.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage password(String password) {
            this.password = Optional.of(password);
            return this;
        }

        @Override
        @JsonSetter(value = "password", nulls = Nulls.SKIP)
        public _FinalStage password(Optional<String> password) {
            this.password = password;
            return this;
        }

        @Override
        public UpdateUserDto build() {
            return new UpdateUserDto(email, displayName, password, permissions);
        }
    }
}
