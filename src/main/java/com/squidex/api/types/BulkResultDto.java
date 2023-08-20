package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = BulkResultDto.Builder.class)
public final class BulkResultDto {
    private final Optional<ErrorDto> error;

    private final int jobIndex;

    private final Optional<String> id;

    private final Optional<String> contentId;

    private BulkResultDto(Optional<ErrorDto> error, int jobIndex, Optional<String> id, Optional<String> contentId) {
        this.error = error;
        this.jobIndex = jobIndex;
        this.id = id;
        this.contentId = contentId;
    }

    @JsonProperty("error")
    public Optional<ErrorDto> getError() {
        return error;
    }

    /**
     * @return The index of the bulk job where the result belongs to. The order can change.
     */
    @JsonProperty("jobIndex")
    public int getJobIndex() {
        return jobIndex;
    }

    /**
     * @return The ID of the entity that has been handled successfully or not.
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return The ID of the entity that has been handled successfully or not.
     */
    @JsonProperty("contentId")
    public Optional<String> getContentId() {
        return contentId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BulkResultDto && equalTo((BulkResultDto) other);
    }

    private boolean equalTo(BulkResultDto other) {
        return error.equals(other.error)
                && jobIndex == other.jobIndex
                && id.equals(other.id)
                && contentId.equals(other.contentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.error, this.jobIndex, this.id, this.contentId);
    }

    @Override
    public String toString() {
        return "BulkResultDto{" + "error: " + error + ", jobIndex: " + jobIndex + ", id: " + id + ", contentId: "
                + contentId + "}";
    }

    public static JobIndexStage builder() {
        return new Builder();
    }

    public interface JobIndexStage {
        _FinalStage jobIndex(int jobIndex);

        Builder from(BulkResultDto other);
    }

    public interface _FinalStage {
        BulkResultDto build();

        _FinalStage error(Optional<ErrorDto> error);

        _FinalStage error(ErrorDto error);

        _FinalStage id(Optional<String> id);

        _FinalStage id(String id);

        _FinalStage contentId(Optional<String> contentId);

        _FinalStage contentId(String contentId);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements JobIndexStage, _FinalStage {
        private int jobIndex;

        private Optional<String> contentId = Optional.empty();

        private Optional<String> id = Optional.empty();

        private Optional<ErrorDto> error = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(BulkResultDto other) {
            error(other.getError());
            jobIndex(other.getJobIndex());
            id(other.getId());
            contentId(other.getContentId());
            return this;
        }

        /**
         * <p>The index of the bulk job where the result belongs to. The order can change.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("jobIndex")
        public _FinalStage jobIndex(int jobIndex) {
            this.jobIndex = jobIndex;
            return this;
        }

        /**
         * <p>The ID of the entity that has been handled successfully or not.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage contentId(String contentId) {
            this.contentId = Optional.of(contentId);
            return this;
        }

        @Override
        @JsonSetter(value = "contentId", nulls = Nulls.SKIP)
        public _FinalStage contentId(Optional<String> contentId) {
            this.contentId = contentId;
            return this;
        }

        /**
         * <p>The ID of the entity that has been handled successfully or not.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage id(String id) {
            this.id = Optional.of(id);
            return this;
        }

        @Override
        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public _FinalStage id(Optional<String> id) {
            this.id = id;
            return this;
        }

        @Override
        public _FinalStage error(ErrorDto error) {
            this.error = Optional.of(error);
            return this;
        }

        @Override
        @JsonSetter(value = "error", nulls = Nulls.SKIP)
        public _FinalStage error(Optional<ErrorDto> error) {
            this.error = error;
            return this;
        }

        @Override
        public BulkResultDto build() {
            return new BulkResultDto(error, jobIndex, id, contentId);
        }
    }
}
