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
@JsonDeserialize(builder = ErrorDto.Builder.class)
public final class ErrorDto {
    private final String message;

    private final Optional<String> errorCode;

    private final Optional<String> traceId;

    private final Optional<String> type;

    private final Optional<List<String>> details;

    private final int statusCode;

    private ErrorDto(
            String message,
            Optional<String> errorCode,
            Optional<String> traceId,
            Optional<String> type,
            Optional<List<String>> details,
            int statusCode) {
        this.message = message;
        this.errorCode = errorCode;
        this.traceId = traceId;
        this.type = type;
        this.details = details;
        this.statusCode = statusCode;
    }

    /**
     * @return Error message. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * @return The error code.
     */
    @JsonProperty("errorCode")
    public Optional<String> getErrorCode() {
        return errorCode;
    }

    /**
     * @return The optional trace id.
     */
    @JsonProperty("traceId")
    public Optional<String> getTraceId() {
        return traceId;
    }

    /**
     * @return Link to the error details.
     */
    @JsonProperty("type")
    public Optional<String> getType() {
        return type;
    }

    /**
     * @return Detailed error messages.
     */
    @JsonProperty("details")
    public Optional<List<String>> getDetails() {
        return details;
    }

    /**
     * @return Status code of the http response.
     */
    @JsonProperty("statusCode")
    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ErrorDto && equalTo((ErrorDto) other);
    }

    private boolean equalTo(ErrorDto other) {
        return message.equals(other.message)
                && errorCode.equals(other.errorCode)
                && traceId.equals(other.traceId)
                && type.equals(other.type)
                && details.equals(other.details)
                && statusCode == other.statusCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.message, this.errorCode, this.traceId, this.type, this.details, this.statusCode);
    }

    @Override
    public String toString() {
        return "ErrorDto{" + "message: " + message + ", errorCode: " + errorCode + ", traceId: " + traceId + ", type: "
                + type + ", details: " + details + ", statusCode: " + statusCode + "}";
    }

    public static MessageStage builder() {
        return new Builder();
    }

    public interface MessageStage {
        StatusCodeStage message(String message);

        Builder from(ErrorDto other);
    }

    public interface StatusCodeStage {
        _FinalStage statusCode(int statusCode);
    }

    public interface _FinalStage {
        ErrorDto build();

        _FinalStage errorCode(Optional<String> errorCode);

        _FinalStage errorCode(String errorCode);

        _FinalStage traceId(Optional<String> traceId);

        _FinalStage traceId(String traceId);

        _FinalStage type(Optional<String> type);

        _FinalStage type(String type);

        _FinalStage details(Optional<List<String>> details);

        _FinalStage details(List<String> details);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements MessageStage, StatusCodeStage, _FinalStage {
        private String message;

        private int statusCode;

        private Optional<List<String>> details = Optional.empty();

        private Optional<String> type = Optional.empty();

        private Optional<String> traceId = Optional.empty();

        private Optional<String> errorCode = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(ErrorDto other) {
            message(other.getMessage());
            errorCode(other.getErrorCode());
            traceId(other.getTraceId());
            type(other.getType());
            details(other.getDetails());
            statusCode(other.getStatusCode());
            return this;
        }

        /**
         * <p>Error message. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("message")
        public StatusCodeStage message(String message) {
            this.message = message;
            return this;
        }

        /**
         * <p>Status code of the http response.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("statusCode")
        public _FinalStage statusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        /**
         * <p>Detailed error messages.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage details(List<String> details) {
            this.details = Optional.of(details);
            return this;
        }

        @Override
        @JsonSetter(value = "details", nulls = Nulls.SKIP)
        public _FinalStage details(Optional<List<String>> details) {
            this.details = details;
            return this;
        }

        /**
         * <p>Link to the error details.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage type(String type) {
            this.type = Optional.of(type);
            return this;
        }

        @Override
        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public _FinalStage type(Optional<String> type) {
            this.type = type;
            return this;
        }

        /**
         * <p>The optional trace id.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage traceId(String traceId) {
            this.traceId = Optional.of(traceId);
            return this;
        }

        @Override
        @JsonSetter(value = "traceId", nulls = Nulls.SKIP)
        public _FinalStage traceId(Optional<String> traceId) {
            this.traceId = traceId;
            return this;
        }

        /**
         * <p>The error code.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage errorCode(String errorCode) {
            this.errorCode = Optional.of(errorCode);
            return this;
        }

        @Override
        @JsonSetter(value = "errorCode", nulls = Nulls.SKIP)
        public _FinalStage errorCode(Optional<String> errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        @Override
        public ErrorDto build() {
            return new ErrorDto(message, errorCode, traceId, type, details, statusCode);
        }
    }
}
