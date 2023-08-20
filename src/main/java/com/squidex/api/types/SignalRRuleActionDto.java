package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SignalRRuleActionDto.Builder.class)
public final class SignalRRuleActionDto {
    private final String connectionString;

    private final String hubName;

    private final ActionTypeEnum action;

    private final Optional<String> methodName;

    private final Optional<String> target;

    private final Optional<String> payload;

    private SignalRRuleActionDto(
            String connectionString,
            String hubName,
            ActionTypeEnum action,
            Optional<String> methodName,
            Optional<String> target,
            Optional<String> payload) {
        this.connectionString = connectionString;
        this.hubName = hubName;
        this.action = action;
        this.methodName = methodName;
        this.target = target;
        this.payload = payload;
    }

    /**
     * @return The connection string to the Azure SignalR. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("connectionString")
    public String getConnectionString() {
        return connectionString;
    }

    /**
     * @return The name of the hub. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("hubName")
    public String getHubName() {
        return hubName;
    }

    @JsonProperty("action")
    public ActionTypeEnum getAction() {
        return action;
    }

    /**
     * @return Set the Name of the hub method received by the customer.
     */
    @JsonProperty("methodName")
    public Optional<String> getMethodName() {
        return methodName;
    }

    /**
     * @return Define target users or groups by id or name. One item per line. Not needed for Broadcast action.
     */
    @JsonProperty("target")
    public Optional<String> getTarget() {
        return target;
    }

    /**
     * @return Leave it empty to use the full event as body.
     */
    @JsonProperty("payload")
    public Optional<String> getPayload() {
        return payload;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SignalRRuleActionDto && equalTo((SignalRRuleActionDto) other);
    }

    private boolean equalTo(SignalRRuleActionDto other) {
        return connectionString.equals(other.connectionString)
                && hubName.equals(other.hubName)
                && action.equals(other.action)
                && methodName.equals(other.methodName)
                && target.equals(other.target)
                && payload.equals(other.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.connectionString, this.hubName, this.action, this.methodName, this.target, this.payload);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ConnectionStringStage builder() {
        return new Builder();
    }

    public interface ConnectionStringStage {
        HubNameStage connectionString(String connectionString);

        Builder from(SignalRRuleActionDto other);
    }

    public interface HubNameStage {
        ActionStage hubName(String hubName);
    }

    public interface ActionStage {
        _FinalStage action(ActionTypeEnum action);
    }

    public interface _FinalStage {
        SignalRRuleActionDto build();

        _FinalStage methodName(Optional<String> methodName);

        _FinalStage methodName(String methodName);

        _FinalStage target(Optional<String> target);

        _FinalStage target(String target);

        _FinalStage payload(Optional<String> payload);

        _FinalStage payload(String payload);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ConnectionStringStage, HubNameStage, ActionStage, _FinalStage {
        private String connectionString;

        private String hubName;

        private ActionTypeEnum action;

        private Optional<String> payload = Optional.empty();

        private Optional<String> target = Optional.empty();

        private Optional<String> methodName = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(SignalRRuleActionDto other) {
            connectionString(other.getConnectionString());
            hubName(other.getHubName());
            action(other.getAction());
            methodName(other.getMethodName());
            target(other.getTarget());
            payload(other.getPayload());
            return this;
        }

        /**
         * <p>The connection string to the Azure SignalR. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("connectionString")
        public HubNameStage connectionString(String connectionString) {
            this.connectionString = connectionString;
            return this;
        }

        /**
         * <p>The name of the hub. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("hubName")
        public ActionStage hubName(String hubName) {
            this.hubName = hubName;
            return this;
        }

        @Override
        @JsonSetter("action")
        public _FinalStage action(ActionTypeEnum action) {
            this.action = action;
            return this;
        }

        /**
         * <p>Leave it empty to use the full event as body.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage payload(String payload) {
            this.payload = Optional.of(payload);
            return this;
        }

        @Override
        @JsonSetter(value = "payload", nulls = Nulls.SKIP)
        public _FinalStage payload(Optional<String> payload) {
            this.payload = payload;
            return this;
        }

        /**
         * <p>Define target users or groups by id or name. One item per line. Not needed for Broadcast action.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage target(String target) {
            this.target = Optional.of(target);
            return this;
        }

        @Override
        @JsonSetter(value = "target", nulls = Nulls.SKIP)
        public _FinalStage target(Optional<String> target) {
            this.target = target;
            return this;
        }

        /**
         * <p>Set the Name of the hub method received by the customer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage methodName(String methodName) {
            this.methodName = Optional.of(methodName);
            return this;
        }

        @Override
        @JsonSetter(value = "methodName", nulls = Nulls.SKIP)
        public _FinalStage methodName(Optional<String> methodName) {
            this.methodName = methodName;
            return this;
        }

        @Override
        public SignalRRuleActionDto build() {
            return new SignalRRuleActionDto(connectionString, hubName, action, methodName, target, payload);
        }
    }
}
