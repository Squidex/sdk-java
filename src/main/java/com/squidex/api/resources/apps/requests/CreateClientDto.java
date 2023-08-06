package com.squidex.api.resources.apps.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CreateClientDto.Builder.class)
public final class CreateClientDto {
    private final String id;

    private CreateClientDto(String id) {
        this.id = id;
    }

    /**
     * @return The ID of the client. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateClientDto && equalTo((CreateClientDto) other);
    }

    private boolean equalTo(CreateClientDto other) {
        return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public String toString() {
        return "CreateClientDto{" + "id: " + id + "}";
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        _FinalStage id(String id);

        Builder from(CreateClientDto other);
    }

    public interface _FinalStage {
        CreateClientDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, _FinalStage {
        private String id;

        private Builder() {}

        @Override
        public Builder from(CreateClientDto other) {
            id(other.getId());
            return this;
        }

        /**
         * <p>The ID of the client. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("id")
        public _FinalStage id(String id) {
            this.id = id;
            return this;
        }

        @Override
        public CreateClientDto build() {
            return new CreateClientDto(id);
        }
    }
}
