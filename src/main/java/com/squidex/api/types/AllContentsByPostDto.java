package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AllContentsByPostDto.Builder.class)
public final class AllContentsByPostDto {
    private final Optional<List<String>> ids;

    private final Optional<OffsetDateTime> scheduledFrom;

    private final Optional<OffsetDateTime> scheduledTo;

    private final Optional<String> referencing;

    private final Optional<String> references;

    private final Optional<String> oData;

    private final Optional<Object> q;

    private AllContentsByPostDto(
            Optional<List<String>> ids,
            Optional<OffsetDateTime> scheduledFrom,
            Optional<OffsetDateTime> scheduledTo,
            Optional<String> referencing,
            Optional<String> references,
            Optional<String> oData,
            Optional<Object> q) {
        this.ids = ids;
        this.scheduledFrom = scheduledFrom;
        this.scheduledTo = scheduledTo;
        this.referencing = referencing;
        this.references = references;
        this.oData = oData;
        this.q = q;
    }

    /**
     * @return The list of ids to query.
     */
    @JsonProperty("ids")
    public Optional<List<String>> getIds() {
        return ids;
    }

    /**
     * @return The start of the schedule.
     */
    @JsonProperty("scheduledFrom")
    public Optional<OffsetDateTime> getScheduledFrom() {
        return scheduledFrom;
    }

    /**
     * @return The end of the schedule.
     */
    @JsonProperty("scheduledTo")
    public Optional<OffsetDateTime> getScheduledTo() {
        return scheduledTo;
    }

    /**
     * @return The ID of the referencing content item.
     */
    @JsonProperty("referencing")
    public Optional<String> getReferencing() {
        return referencing;
    }

    /**
     * @return The ID of the reference content item.
     */
    @JsonProperty("references")
    public Optional<String> getReferences() {
        return references;
    }

    /**
     * @return The optional odata query.
     */
    @JsonProperty("oData")
    public Optional<String> getOData() {
        return oData;
    }

    @JsonProperty("q")
    public Optional<Object> getQ() {
        return q;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AllContentsByPostDto && equalTo((AllContentsByPostDto) other);
    }

    private boolean equalTo(AllContentsByPostDto other) {
        return ids.equals(other.ids)
                && scheduledFrom.equals(other.scheduledFrom)
                && scheduledTo.equals(other.scheduledTo)
                && referencing.equals(other.referencing)
                && references.equals(other.references)
                && oData.equals(other.oData)
                && q.equals(other.q);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.ids, this.scheduledFrom, this.scheduledTo, this.referencing, this.references, this.oData, this.q);
    }

    @Override
    public String toString() {
        return "AllContentsByPostDto{" + "ids: " + ids + ", scheduledFrom: " + scheduledFrom + ", scheduledTo: "
                + scheduledTo + ", referencing: " + referencing + ", references: " + references + ", oData: " + oData
                + ", q: " + q + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<List<String>> ids = Optional.empty();

        private Optional<OffsetDateTime> scheduledFrom = Optional.empty();

        private Optional<OffsetDateTime> scheduledTo = Optional.empty();

        private Optional<String> referencing = Optional.empty();

        private Optional<String> references = Optional.empty();

        private Optional<String> oData = Optional.empty();

        private Optional<Object> q = Optional.empty();

        private Builder() {}

        public Builder from(AllContentsByPostDto other) {
            ids(other.getIds());
            scheduledFrom(other.getScheduledFrom());
            scheduledTo(other.getScheduledTo());
            referencing(other.getReferencing());
            references(other.getReferences());
            oData(other.getOData());
            q(other.getQ());
            return this;
        }

        @JsonSetter(value = "ids", nulls = Nulls.SKIP)
        public Builder ids(Optional<List<String>> ids) {
            this.ids = ids;
            return this;
        }

        public Builder ids(List<String> ids) {
            this.ids = Optional.of(ids);
            return this;
        }

        @JsonSetter(value = "scheduledFrom", nulls = Nulls.SKIP)
        public Builder scheduledFrom(Optional<OffsetDateTime> scheduledFrom) {
            this.scheduledFrom = scheduledFrom;
            return this;
        }

        public Builder scheduledFrom(OffsetDateTime scheduledFrom) {
            this.scheduledFrom = Optional.of(scheduledFrom);
            return this;
        }

        @JsonSetter(value = "scheduledTo", nulls = Nulls.SKIP)
        public Builder scheduledTo(Optional<OffsetDateTime> scheduledTo) {
            this.scheduledTo = scheduledTo;
            return this;
        }

        public Builder scheduledTo(OffsetDateTime scheduledTo) {
            this.scheduledTo = Optional.of(scheduledTo);
            return this;
        }

        @JsonSetter(value = "referencing", nulls = Nulls.SKIP)
        public Builder referencing(Optional<String> referencing) {
            this.referencing = referencing;
            return this;
        }

        public Builder referencing(String referencing) {
            this.referencing = Optional.of(referencing);
            return this;
        }

        @JsonSetter(value = "references", nulls = Nulls.SKIP)
        public Builder references(Optional<String> references) {
            this.references = references;
            return this;
        }

        public Builder references(String references) {
            this.references = Optional.of(references);
            return this;
        }

        @JsonSetter(value = "oData", nulls = Nulls.SKIP)
        public Builder oData(Optional<String> oData) {
            this.oData = oData;
            return this;
        }

        public Builder oData(String oData) {
            this.oData = Optional.of(oData);
            return this;
        }

        @JsonSetter(value = "q", nulls = Nulls.SKIP)
        public Builder q(Optional<Object> q) {
            this.q = q;
            return this;
        }

        public Builder q(Object q) {
            this.q = Optional.of(q);
            return this;
        }

        public AllContentsByPostDto build() {
            return new AllContentsByPostDto(ids, scheduledFrom, scheduledTo, referencing, references, oData, q);
        }
    }
}
