package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ContributorsMetadata.Builder.class)
public final class ContributorsMetadata {
    private final String isInvited;

    private ContributorsMetadata(String isInvited) {
        this.isInvited = isInvited;
    }

    /**
     * @return Indicates whether the user has been invited.
     */
    @JsonProperty("isInvited")
    public String getIsInvited() {
        return isInvited;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ContributorsMetadata && equalTo((ContributorsMetadata) other);
    }

    private boolean equalTo(ContributorsMetadata other) {
        return isInvited.equals(other.isInvited);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.isInvited);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IsInvitedStage builder() {
        return new Builder();
    }

    public interface IsInvitedStage {
        _FinalStage isInvited(String isInvited);

        Builder from(ContributorsMetadata other);
    }

    public interface _FinalStage {
        ContributorsMetadata build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IsInvitedStage, _FinalStage {
        private String isInvited;

        private Builder() {}

        @Override
        public Builder from(ContributorsMetadata other) {
            isInvited(other.getIsInvited());
            return this;
        }

        /**
         * <p>Indicates whether the user has been invited.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("isInvited")
        public _FinalStage isInvited(String isInvited) {
            this.isInvited = isInvited;
            return this;
        }

        @Override
        public ContributorsMetadata build() {
            return new ContributorsMetadata(isInvited);
        }
    }
}
