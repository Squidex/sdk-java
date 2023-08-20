package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = EmailRuleActionDto.Builder.class)
public final class EmailRuleActionDto {
    private final String serverHost;

    private final int serverPort;

    private final String serverUsername;

    private final String serverPassword;

    private final String messageFrom;

    private final String messageTo;

    private final String messageSubject;

    private final String messageBody;

    private EmailRuleActionDto(
            String serverHost,
            int serverPort,
            String serverUsername,
            String serverPassword,
            String messageFrom,
            String messageTo,
            String messageSubject,
            String messageBody) {
        this.serverHost = serverHost;
        this.serverPort = serverPort;
        this.serverUsername = serverUsername;
        this.serverPassword = serverPassword;
        this.messageFrom = messageFrom;
        this.messageTo = messageTo;
        this.messageSubject = messageSubject;
        this.messageBody = messageBody;
    }

    /**
     * @return The IP address or host to the SMTP server. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("serverHost")
    public String getServerHost() {
        return serverHost;
    }

    /**
     * @return The port to the SMTP server.
     */
    @JsonProperty("serverPort")
    public int getServerPort() {
        return serverPort;
    }

    /**
     * @return The username for the SMTP server. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("serverUsername")
    public String getServerUsername() {
        return serverUsername;
    }

    /**
     * @return The password for the SMTP server. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("serverPassword")
    public String getServerPassword() {
        return serverPassword;
    }

    /**
     * @return The email sending address. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("messageFrom")
    public String getMessageFrom() {
        return messageFrom;
    }

    /**
     * @return The email message will be sent to. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("messageTo")
    public String getMessageTo() {
        return messageTo;
    }

    /**
     * @return The subject line for this email message. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("messageSubject")
    public String getMessageSubject() {
        return messageSubject;
    }

    /**
     * @return The message body. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("messageBody")
    public String getMessageBody() {
        return messageBody;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof EmailRuleActionDto && equalTo((EmailRuleActionDto) other);
    }

    private boolean equalTo(EmailRuleActionDto other) {
        return serverHost.equals(other.serverHost)
                && serverPort == other.serverPort
                && serverUsername.equals(other.serverUsername)
                && serverPassword.equals(other.serverPassword)
                && messageFrom.equals(other.messageFrom)
                && messageTo.equals(other.messageTo)
                && messageSubject.equals(other.messageSubject)
                && messageBody.equals(other.messageBody);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.serverHost,
                this.serverPort,
                this.serverUsername,
                this.serverPassword,
                this.messageFrom,
                this.messageTo,
                this.messageSubject,
                this.messageBody);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ServerHostStage builder() {
        return new Builder();
    }

    public interface ServerHostStage {
        ServerPortStage serverHost(String serverHost);

        Builder from(EmailRuleActionDto other);
    }

    public interface ServerPortStage {
        ServerUsernameStage serverPort(int serverPort);
    }

    public interface ServerUsernameStage {
        ServerPasswordStage serverUsername(String serverUsername);
    }

    public interface ServerPasswordStage {
        MessageFromStage serverPassword(String serverPassword);
    }

    public interface MessageFromStage {
        MessageToStage messageFrom(String messageFrom);
    }

    public interface MessageToStage {
        MessageSubjectStage messageTo(String messageTo);
    }

    public interface MessageSubjectStage {
        MessageBodyStage messageSubject(String messageSubject);
    }

    public interface MessageBodyStage {
        _FinalStage messageBody(String messageBody);
    }

    public interface _FinalStage {
        EmailRuleActionDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements ServerHostStage,
                    ServerPortStage,
                    ServerUsernameStage,
                    ServerPasswordStage,
                    MessageFromStage,
                    MessageToStage,
                    MessageSubjectStage,
                    MessageBodyStage,
                    _FinalStage {
        private String serverHost;

        private int serverPort;

        private String serverUsername;

        private String serverPassword;

        private String messageFrom;

        private String messageTo;

        private String messageSubject;

        private String messageBody;

        private Builder() {}

        @Override
        public Builder from(EmailRuleActionDto other) {
            serverHost(other.getServerHost());
            serverPort(other.getServerPort());
            serverUsername(other.getServerUsername());
            serverPassword(other.getServerPassword());
            messageFrom(other.getMessageFrom());
            messageTo(other.getMessageTo());
            messageSubject(other.getMessageSubject());
            messageBody(other.getMessageBody());
            return this;
        }

        /**
         * <p>The IP address or host to the SMTP server. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("serverHost")
        public ServerPortStage serverHost(String serverHost) {
            this.serverHost = serverHost;
            return this;
        }

        /**
         * <p>The port to the SMTP server.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("serverPort")
        public ServerUsernameStage serverPort(int serverPort) {
            this.serverPort = serverPort;
            return this;
        }

        /**
         * <p>The username for the SMTP server. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("serverUsername")
        public ServerPasswordStage serverUsername(String serverUsername) {
            this.serverUsername = serverUsername;
            return this;
        }

        /**
         * <p>The password for the SMTP server. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("serverPassword")
        public MessageFromStage serverPassword(String serverPassword) {
            this.serverPassword = serverPassword;
            return this;
        }

        /**
         * <p>The email sending address. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("messageFrom")
        public MessageToStage messageFrom(String messageFrom) {
            this.messageFrom = messageFrom;
            return this;
        }

        /**
         * <p>The email message will be sent to. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("messageTo")
        public MessageSubjectStage messageTo(String messageTo) {
            this.messageTo = messageTo;
            return this;
        }

        /**
         * <p>The subject line for this email message. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("messageSubject")
        public MessageBodyStage messageSubject(String messageSubject) {
            this.messageSubject = messageSubject;
            return this;
        }

        /**
         * <p>The message body. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("messageBody")
        public _FinalStage messageBody(String messageBody) {
            this.messageBody = messageBody;
            return this;
        }

        @Override
        public EmailRuleActionDto build() {
            return new EmailRuleActionDto(
                    serverHost,
                    serverPort,
                    serverUsername,
                    serverPassword,
                    messageFrom,
                    messageTo,
                    messageSubject,
                    messageBody);
        }
    }
}
