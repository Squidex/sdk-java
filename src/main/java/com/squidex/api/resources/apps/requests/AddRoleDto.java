package com.squidex.api.resources.apps.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AddRoleDto.Builder.class)
public final class AddRoleDto {
    private final String name;

    private AddRoleDto(String name) {
        this.name = name;
    }

    /**
     * @return The role name. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AddRoleDto && equalTo((AddRoleDto) other);
    }

    private boolean equalTo(AddRoleDto other) {
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    @Override
    public String toString() {
        return "AddRoleDto{" + "name: " + name + "}";
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        _FinalStage name(String name);

        Builder from(AddRoleDto other);
    }

    public interface _FinalStage {
        AddRoleDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, _FinalStage {
        private String name;

        private Builder() {}

        @Override
        public Builder from(AddRoleDto other) {
            name(other.getName());
            return this;
        }

        /**
         * <p>The role name. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name")
        public _FinalStage name(String name) {
            this.name = name;
            return this;
        }

        @Override
        public AddRoleDto build() {
            return new AddRoleDto(name);
        }
    }
}
