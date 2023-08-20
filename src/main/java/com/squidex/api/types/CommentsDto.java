package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CommentsDto.Builder.class)
public final class CommentsDto {
    private final Optional<List<CommentDto>> createdComments;

    private final Optional<List<CommentDto>> updatedComments;

    private final Optional<List<String>> deletedComments;

    private final int version;

    private CommentsDto(
            Optional<List<CommentDto>> createdComments,
            Optional<List<CommentDto>> updatedComments,
            Optional<List<String>> deletedComments,
            int version) {
        this.createdComments = createdComments;
        this.updatedComments = updatedComments;
        this.deletedComments = deletedComments;
        this.version = version;
    }

    /**
     * @return The created comments including the updates.
     */
    @JsonProperty("createdComments")
    public Optional<List<CommentDto>> getCreatedComments() {
        return createdComments;
    }

    /**
     * @return The updates comments since the last version.
     */
    @JsonProperty("updatedComments")
    public Optional<List<CommentDto>> getUpdatedComments() {
        return updatedComments;
    }

    /**
     * @return The deleted comments since the last version.
     */
    @JsonProperty("deletedComments")
    public Optional<List<String>> getDeletedComments() {
        return deletedComments;
    }

    /**
     * @return The current version.
     */
    @JsonProperty("version")
    public int getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CommentsDto && equalTo((CommentsDto) other);
    }

    private boolean equalTo(CommentsDto other) {
        return createdComments.equals(other.createdComments)
                && updatedComments.equals(other.updatedComments)
                && deletedComments.equals(other.deletedComments)
                && version == other.version;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.createdComments, this.updatedComments, this.deletedComments, this.version);
    }

    @Override
    public String toString() {
        return "CommentsDto{" + "createdComments: " + createdComments + ", updatedComments: " + updatedComments
                + ", deletedComments: " + deletedComments + ", version: " + version + "}";
    }

    public static VersionStage builder() {
        return new Builder();
    }

    public interface VersionStage {
        _FinalStage version(int version);

        Builder from(CommentsDto other);
    }

    public interface _FinalStage {
        CommentsDto build();

        _FinalStage createdComments(Optional<List<CommentDto>> createdComments);

        _FinalStage createdComments(List<CommentDto> createdComments);

        _FinalStage updatedComments(Optional<List<CommentDto>> updatedComments);

        _FinalStage updatedComments(List<CommentDto> updatedComments);

        _FinalStage deletedComments(Optional<List<String>> deletedComments);

        _FinalStage deletedComments(List<String> deletedComments);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements VersionStage, _FinalStage {
        private int version;

        private Optional<List<String>> deletedComments = Optional.empty();

        private Optional<List<CommentDto>> updatedComments = Optional.empty();

        private Optional<List<CommentDto>> createdComments = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(CommentsDto other) {
            createdComments(other.getCreatedComments());
            updatedComments(other.getUpdatedComments());
            deletedComments(other.getDeletedComments());
            version(other.getVersion());
            return this;
        }

        /**
         * <p>The current version.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("version")
        public _FinalStage version(int version) {
            this.version = version;
            return this;
        }

        /**
         * <p>The deleted comments since the last version.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage deletedComments(List<String> deletedComments) {
            this.deletedComments = Optional.of(deletedComments);
            return this;
        }

        @Override
        @JsonSetter(value = "deletedComments", nulls = Nulls.SKIP)
        public _FinalStage deletedComments(Optional<List<String>> deletedComments) {
            this.deletedComments = deletedComments;
            return this;
        }

        /**
         * <p>The updates comments since the last version.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage updatedComments(List<CommentDto> updatedComments) {
            this.updatedComments = Optional.of(updatedComments);
            return this;
        }

        @Override
        @JsonSetter(value = "updatedComments", nulls = Nulls.SKIP)
        public _FinalStage updatedComments(Optional<List<CommentDto>> updatedComments) {
            this.updatedComments = updatedComments;
            return this;
        }

        /**
         * <p>The created comments including the updates.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage createdComments(List<CommentDto> createdComments) {
            this.createdComments = Optional.of(createdComments);
            return this;
        }

        @Override
        @JsonSetter(value = "createdComments", nulls = Nulls.SKIP)
        public _FinalStage createdComments(Optional<List<CommentDto>> createdComments) {
            this.createdComments = createdComments;
            return this;
        }

        @Override
        public CommentsDto build() {
            return new CommentsDto(createdComments, updatedComments, deletedComments, version);
        }
    }
}
