package com.squidex.api.resources.contents.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ChangeStatusDto.Builder.class)
public final class ChangeStatusDto {
    private final Optional<Boolean> unpublished;

    private final Optional<String> languages;

    private final String status;

    private final Optional<OffsetDateTime> dueTime;

    private final Optional<Boolean> checkReferrers;

    private ChangeStatusDto(
            Optional<Boolean> unpublished,
            Optional<String> languages,
            String status,
            Optional<OffsetDateTime> dueTime,
            Optional<Boolean> checkReferrers) {
        this.unpublished = unpublished;
        this.languages = languages;
        this.status = status;
        this.dueTime = dueTime;
        this.checkReferrers = checkReferrers;
    }

    /**
     * @return Return unpublished content items.
     */
    @JsonProperty("X-Unpublished")
    public Optional<Boolean> getUnpublished() {
        return unpublished;
    }

    /**
     * @return Only resolve these languages (comma-separated).
     */
    @JsonProperty("X-Languages")
    public Optional<String> getLanguages() {
        return languages;
    }

    /**
     * @return The new status. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * @return The due time.
     */
    @JsonProperty("dueTime")
    public Optional<OffsetDateTime> getDueTime() {
        return dueTime;
    }

    /**
     * @return True to check referrers of this content.
     */
    @JsonProperty("checkReferrers")
    public Optional<Boolean> getCheckReferrers() {
        return checkReferrers;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ChangeStatusDto && equalTo((ChangeStatusDto) other);
    }

    private boolean equalTo(ChangeStatusDto other) {
        return unpublished.equals(other.unpublished)
                && languages.equals(other.languages)
                && status.equals(other.status)
                && dueTime.equals(other.dueTime)
                && checkReferrers.equals(other.checkReferrers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.unpublished, this.languages, this.status, this.dueTime, this.checkReferrers);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static StatusStage builder() {
        return new Builder();
    }

    public interface StatusStage {
        _FinalStage status(String status);

        Builder from(ChangeStatusDto other);
    }

    public interface _FinalStage {
        ChangeStatusDto build();

        _FinalStage unpublished(Optional<Boolean> unpublished);

        _FinalStage unpublished(Boolean unpublished);

        _FinalStage languages(Optional<String> languages);

        _FinalStage languages(String languages);

        _FinalStage dueTime(Optional<OffsetDateTime> dueTime);

        _FinalStage dueTime(OffsetDateTime dueTime);

        _FinalStage checkReferrers(Optional<Boolean> checkReferrers);

        _FinalStage checkReferrers(Boolean checkReferrers);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements StatusStage, _FinalStage {
        private String status;

        private Optional<Boolean> checkReferrers = Optional.empty();

        private Optional<OffsetDateTime> dueTime = Optional.empty();

        private Optional<String> languages = Optional.empty();

        private Optional<Boolean> unpublished = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(ChangeStatusDto other) {
            unpublished(other.getUnpublished());
            languages(other.getLanguages());
            status(other.getStatus());
            dueTime(other.getDueTime());
            checkReferrers(other.getCheckReferrers());
            return this;
        }

        /**
         * <p>The new status. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("status")
        public _FinalStage status(String status) {
            this.status = status;
            return this;
        }

        /**
         * <p>True to check referrers of this content.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage checkReferrers(Boolean checkReferrers) {
            this.checkReferrers = Optional.of(checkReferrers);
            return this;
        }

        @Override
        @JsonSetter(value = "checkReferrers", nulls = Nulls.SKIP)
        public _FinalStage checkReferrers(Optional<Boolean> checkReferrers) {
            this.checkReferrers = checkReferrers;
            return this;
        }

        /**
         * <p>The due time.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage dueTime(OffsetDateTime dueTime) {
            this.dueTime = Optional.of(dueTime);
            return this;
        }

        @Override
        @JsonSetter(value = "dueTime", nulls = Nulls.SKIP)
        public _FinalStage dueTime(Optional<OffsetDateTime> dueTime) {
            this.dueTime = dueTime;
            return this;
        }

        /**
         * <p>Only resolve these languages (comma-separated).</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage languages(String languages) {
            this.languages = Optional.of(languages);
            return this;
        }

        @Override
        @JsonSetter(value = "X-Languages", nulls = Nulls.SKIP)
        public _FinalStage languages(Optional<String> languages) {
            this.languages = languages;
            return this;
        }

        /**
         * <p>Return unpublished content items.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage unpublished(Boolean unpublished) {
            this.unpublished = Optional.of(unpublished);
            return this;
        }

        @Override
        @JsonSetter(value = "X-Unpublished", nulls = Nulls.SKIP)
        public _FinalStage unpublished(Optional<Boolean> unpublished) {
            this.unpublished = unpublished;
            return this;
        }

        @Override
        public ChangeStatusDto build() {
            return new ChangeStatusDto(unpublished, languages, status, dueTime, checkReferrers);
        }
    }
}
