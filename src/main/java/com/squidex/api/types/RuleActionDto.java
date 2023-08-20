package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import java.util.Optional;

public final class RuleActionDto {
    private final Value value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    private RuleActionDto(Value value) {
        this.value = value;
    }

    public <T> T visit(Visitor<T> visitor) {
        return value.visit(visitor);
    }

    public static RuleActionDto algolia(AlgoliaRuleActionDto value) {
        return new RuleActionDto(new AlgoliaValue(value));
    }

    public static RuleActionDto azureQueue(AzureQueueRuleActionDto value) {
        return new RuleActionDto(new AzureQueueValue(value));
    }

    public static RuleActionDto comment(CommentRuleActionDto value) {
        return new RuleActionDto(new CommentValue(value));
    }

    public static RuleActionDto createContent(CreateContentRuleActionDto value) {
        return new RuleActionDto(new CreateContentValue(value));
    }

    public static RuleActionDto discourse(DiscourseRuleActionDto value) {
        return new RuleActionDto(new DiscourseValue(value));
    }

    public static RuleActionDto elasticSearch(ElasticSearchRuleActionDto value) {
        return new RuleActionDto(new ElasticSearchValue(value));
    }

    public static RuleActionDto email(EmailRuleActionDto value) {
        return new RuleActionDto(new EmailValue(value));
    }

    public static RuleActionDto fastly(FastlyRuleActionDto value) {
        return new RuleActionDto(new FastlyValue(value));
    }

    public static RuleActionDto medium(MediumRuleActionDto value) {
        return new RuleActionDto(new MediumValue(value));
    }

    public static RuleActionDto notification(NotificationRuleActionDto value) {
        return new RuleActionDto(new NotificationValue(value));
    }

    public static RuleActionDto openSearch(OpenSearchRuleActionDto value) {
        return new RuleActionDto(new OpenSearchValue(value));
    }

    public static RuleActionDto prerender(PrerenderRuleActionDto value) {
        return new RuleActionDto(new PrerenderValue(value));
    }

    public static RuleActionDto script(ScriptRuleActionDto value) {
        return new RuleActionDto(new ScriptValue(value));
    }

    public static RuleActionDto signalR(SignalRRuleActionDto value) {
        return new RuleActionDto(new SignalRValue(value));
    }

    public static RuleActionDto slack(SlackRuleActionDto value) {
        return new RuleActionDto(new SlackValue(value));
    }

    public static RuleActionDto tweet(TweetRuleActionDto value) {
        return new RuleActionDto(new TweetValue(value));
    }

    public static RuleActionDto typesense(TypesenseRuleActionDto value) {
        return new RuleActionDto(new TypesenseValue(value));
    }

    public static RuleActionDto webhook(WebhookRuleActionDto value) {
        return new RuleActionDto(new WebhookValue(value));
    }

    public boolean isAlgolia() {
        return value instanceof AlgoliaValue;
    }

    public boolean isAzureQueue() {
        return value instanceof AzureQueueValue;
    }

    public boolean isComment() {
        return value instanceof CommentValue;
    }

    public boolean isCreateContent() {
        return value instanceof CreateContentValue;
    }

    public boolean isDiscourse() {
        return value instanceof DiscourseValue;
    }

    public boolean isElasticSearch() {
        return value instanceof ElasticSearchValue;
    }

    public boolean isEmail() {
        return value instanceof EmailValue;
    }

    public boolean isFastly() {
        return value instanceof FastlyValue;
    }

    public boolean isMedium() {
        return value instanceof MediumValue;
    }

    public boolean isNotification() {
        return value instanceof NotificationValue;
    }

    public boolean isOpenSearch() {
        return value instanceof OpenSearchValue;
    }

    public boolean isPrerender() {
        return value instanceof PrerenderValue;
    }

    public boolean isScript() {
        return value instanceof ScriptValue;
    }

    public boolean isSignalR() {
        return value instanceof SignalRValue;
    }

    public boolean isSlack() {
        return value instanceof SlackValue;
    }

    public boolean isTweet() {
        return value instanceof TweetValue;
    }

    public boolean isTypesense() {
        return value instanceof TypesenseValue;
    }

    public boolean isWebhook() {
        return value instanceof WebhookValue;
    }

    public boolean _isUnknown() {
        return value instanceof _UnknownValue;
    }

    public Optional<AlgoliaRuleActionDto> getAlgolia() {
        if (isAlgolia()) {
            return Optional.of(((AlgoliaValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<AzureQueueRuleActionDto> getAzureQueue() {
        if (isAzureQueue()) {
            return Optional.of(((AzureQueueValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<CommentRuleActionDto> getComment() {
        if (isComment()) {
            return Optional.of(((CommentValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<CreateContentRuleActionDto> getCreateContent() {
        if (isCreateContent()) {
            return Optional.of(((CreateContentValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<DiscourseRuleActionDto> getDiscourse() {
        if (isDiscourse()) {
            return Optional.of(((DiscourseValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<ElasticSearchRuleActionDto> getElasticSearch() {
        if (isElasticSearch()) {
            return Optional.of(((ElasticSearchValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<EmailRuleActionDto> getEmail() {
        if (isEmail()) {
            return Optional.of(((EmailValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<FastlyRuleActionDto> getFastly() {
        if (isFastly()) {
            return Optional.of(((FastlyValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<MediumRuleActionDto> getMedium() {
        if (isMedium()) {
            return Optional.of(((MediumValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<NotificationRuleActionDto> getNotification() {
        if (isNotification()) {
            return Optional.of(((NotificationValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<OpenSearchRuleActionDto> getOpenSearch() {
        if (isOpenSearch()) {
            return Optional.of(((OpenSearchValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<PrerenderRuleActionDto> getPrerender() {
        if (isPrerender()) {
            return Optional.of(((PrerenderValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<ScriptRuleActionDto> getScript() {
        if (isScript()) {
            return Optional.of(((ScriptValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<SignalRRuleActionDto> getSignalR() {
        if (isSignalR()) {
            return Optional.of(((SignalRValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<SlackRuleActionDto> getSlack() {
        if (isSlack()) {
            return Optional.of(((SlackValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<TweetRuleActionDto> getTweet() {
        if (isTweet()) {
            return Optional.of(((TweetValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<TypesenseRuleActionDto> getTypesense() {
        if (isTypesense()) {
            return Optional.of(((TypesenseValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<WebhookRuleActionDto> getWebhook() {
        if (isWebhook()) {
            return Optional.of(((WebhookValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<Object> _getUnknown() {
        if (_isUnknown()) {
            return Optional.of(((_UnknownValue) value).value);
        }
        return Optional.empty();
    }

    @JsonValue
    private Value getValue() {
        return this.value;
    }

    public interface Visitor<T> {
        T visitAlgolia(AlgoliaRuleActionDto algolia);

        T visitAzureQueue(AzureQueueRuleActionDto azureQueue);

        T visitComment(CommentRuleActionDto comment);

        T visitCreateContent(CreateContentRuleActionDto createContent);

        T visitDiscourse(DiscourseRuleActionDto discourse);

        T visitElasticSearch(ElasticSearchRuleActionDto elasticSearch);

        T visitEmail(EmailRuleActionDto email);

        T visitFastly(FastlyRuleActionDto fastly);

        T visitMedium(MediumRuleActionDto medium);

        T visitNotification(NotificationRuleActionDto notification);

        T visitOpenSearch(OpenSearchRuleActionDto openSearch);

        T visitPrerender(PrerenderRuleActionDto prerender);

        T visitScript(ScriptRuleActionDto script);

        T visitSignalR(SignalRRuleActionDto signalR);

        T visitSlack(SlackRuleActionDto slack);

        T visitTweet(TweetRuleActionDto tweet);

        T visitTypesense(TypesenseRuleActionDto typesense);

        T visitWebhook(WebhookRuleActionDto webhook);

        T _visitUnknown(Object unknownType);
    }

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            property = "actionType",
            visible = true,
            defaultImpl = _UnknownValue.class)
    @JsonSubTypes({
        @JsonSubTypes.Type(AlgoliaValue.class),
        @JsonSubTypes.Type(AzureQueueValue.class),
        @JsonSubTypes.Type(CommentValue.class),
        @JsonSubTypes.Type(CreateContentValue.class),
        @JsonSubTypes.Type(DiscourseValue.class),
        @JsonSubTypes.Type(ElasticSearchValue.class),
        @JsonSubTypes.Type(EmailValue.class),
        @JsonSubTypes.Type(FastlyValue.class),
        @JsonSubTypes.Type(MediumValue.class),
        @JsonSubTypes.Type(NotificationValue.class),
        @JsonSubTypes.Type(OpenSearchValue.class),
        @JsonSubTypes.Type(PrerenderValue.class),
        @JsonSubTypes.Type(ScriptValue.class),
        @JsonSubTypes.Type(SignalRValue.class),
        @JsonSubTypes.Type(SlackValue.class),
        @JsonSubTypes.Type(TweetValue.class),
        @JsonSubTypes.Type(TypesenseValue.class),
        @JsonSubTypes.Type(WebhookValue.class)
    })
    @JsonIgnoreProperties(ignoreUnknown = true)
    private interface Value {
        <T> T visit(Visitor<T> visitor);
    }

    @JsonTypeName("Algolia")
    private static final class AlgoliaValue implements Value {
        @JsonUnwrapped
        private AlgoliaRuleActionDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private AlgoliaValue() {}

        private AlgoliaValue(AlgoliaRuleActionDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitAlgolia(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof AlgoliaValue && equalTo((AlgoliaValue) other);
        }

        private boolean equalTo(AlgoliaValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "RuleActionDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("AzureQueue")
    private static final class AzureQueueValue implements Value {
        @JsonUnwrapped
        private AzureQueueRuleActionDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private AzureQueueValue() {}

        private AzureQueueValue(AzureQueueRuleActionDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitAzureQueue(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof AzureQueueValue && equalTo((AzureQueueValue) other);
        }

        private boolean equalTo(AzureQueueValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "RuleActionDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("Comment")
    private static final class CommentValue implements Value {
        @JsonUnwrapped
        private CommentRuleActionDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private CommentValue() {}

        private CommentValue(CommentRuleActionDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitComment(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof CommentValue && equalTo((CommentValue) other);
        }

        private boolean equalTo(CommentValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "RuleActionDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("CreateContent")
    private static final class CreateContentValue implements Value {
        @JsonUnwrapped
        private CreateContentRuleActionDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private CreateContentValue() {}

        private CreateContentValue(CreateContentRuleActionDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitCreateContent(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof CreateContentValue && equalTo((CreateContentValue) other);
        }

        private boolean equalTo(CreateContentValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "RuleActionDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("Discourse")
    private static final class DiscourseValue implements Value {
        @JsonUnwrapped
        private DiscourseRuleActionDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private DiscourseValue() {}

        private DiscourseValue(DiscourseRuleActionDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitDiscourse(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof DiscourseValue && equalTo((DiscourseValue) other);
        }

        private boolean equalTo(DiscourseValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "RuleActionDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("ElasticSearch")
    private static final class ElasticSearchValue implements Value {
        @JsonUnwrapped
        private ElasticSearchRuleActionDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private ElasticSearchValue() {}

        private ElasticSearchValue(ElasticSearchRuleActionDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitElasticSearch(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof ElasticSearchValue && equalTo((ElasticSearchValue) other);
        }

        private boolean equalTo(ElasticSearchValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "RuleActionDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("Email")
    private static final class EmailValue implements Value {
        @JsonUnwrapped
        private EmailRuleActionDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private EmailValue() {}

        private EmailValue(EmailRuleActionDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitEmail(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof EmailValue && equalTo((EmailValue) other);
        }

        private boolean equalTo(EmailValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "RuleActionDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("Fastly")
    private static final class FastlyValue implements Value {
        @JsonUnwrapped
        private FastlyRuleActionDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private FastlyValue() {}

        private FastlyValue(FastlyRuleActionDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitFastly(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof FastlyValue && equalTo((FastlyValue) other);
        }

        private boolean equalTo(FastlyValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "RuleActionDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("Medium")
    private static final class MediumValue implements Value {
        @JsonUnwrapped
        private MediumRuleActionDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private MediumValue() {}

        private MediumValue(MediumRuleActionDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitMedium(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof MediumValue && equalTo((MediumValue) other);
        }

        private boolean equalTo(MediumValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "RuleActionDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("Notification")
    private static final class NotificationValue implements Value {
        @JsonUnwrapped
        private NotificationRuleActionDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private NotificationValue() {}

        private NotificationValue(NotificationRuleActionDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitNotification(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof NotificationValue && equalTo((NotificationValue) other);
        }

        private boolean equalTo(NotificationValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "RuleActionDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("OpenSearch")
    private static final class OpenSearchValue implements Value {
        @JsonUnwrapped
        private OpenSearchRuleActionDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private OpenSearchValue() {}

        private OpenSearchValue(OpenSearchRuleActionDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitOpenSearch(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof OpenSearchValue && equalTo((OpenSearchValue) other);
        }

        private boolean equalTo(OpenSearchValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "RuleActionDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("Prerender")
    private static final class PrerenderValue implements Value {
        @JsonUnwrapped
        private PrerenderRuleActionDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private PrerenderValue() {}

        private PrerenderValue(PrerenderRuleActionDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitPrerender(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof PrerenderValue && equalTo((PrerenderValue) other);
        }

        private boolean equalTo(PrerenderValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "RuleActionDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("Script")
    private static final class ScriptValue implements Value {
        @JsonUnwrapped
        private ScriptRuleActionDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private ScriptValue() {}

        private ScriptValue(ScriptRuleActionDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitScript(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof ScriptValue && equalTo((ScriptValue) other);
        }

        private boolean equalTo(ScriptValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "RuleActionDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("SignalR")
    private static final class SignalRValue implements Value {
        @JsonUnwrapped
        private SignalRRuleActionDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private SignalRValue() {}

        private SignalRValue(SignalRRuleActionDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitSignalR(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof SignalRValue && equalTo((SignalRValue) other);
        }

        private boolean equalTo(SignalRValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "RuleActionDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("Slack")
    private static final class SlackValue implements Value {
        @JsonUnwrapped
        private SlackRuleActionDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private SlackValue() {}

        private SlackValue(SlackRuleActionDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitSlack(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof SlackValue && equalTo((SlackValue) other);
        }

        private boolean equalTo(SlackValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "RuleActionDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("Tweet")
    private static final class TweetValue implements Value {
        @JsonUnwrapped
        private TweetRuleActionDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private TweetValue() {}

        private TweetValue(TweetRuleActionDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitTweet(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof TweetValue && equalTo((TweetValue) other);
        }

        private boolean equalTo(TweetValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "RuleActionDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("Typesense")
    private static final class TypesenseValue implements Value {
        @JsonUnwrapped
        private TypesenseRuleActionDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private TypesenseValue() {}

        private TypesenseValue(TypesenseRuleActionDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitTypesense(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof TypesenseValue && equalTo((TypesenseValue) other);
        }

        private boolean equalTo(TypesenseValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "RuleActionDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("Webhook")
    private static final class WebhookValue implements Value {
        @JsonUnwrapped
        private WebhookRuleActionDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private WebhookValue() {}

        private WebhookValue(WebhookRuleActionDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitWebhook(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof WebhookValue && equalTo((WebhookValue) other);
        }

        private boolean equalTo(WebhookValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "RuleActionDto{" + "value: " + value + "}";
        }
    }

    private static final class _UnknownValue implements Value {
        private String type;

        @JsonValue
        private Object value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private _UnknownValue(@JsonProperty("value") Object value) {}

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor._visitUnknown(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof _UnknownValue && equalTo((_UnknownValue) other);
        }

        private boolean equalTo(_UnknownValue other) {
            return type.equals(other.type) && value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.type, this.value);
        }

        @Override
        public String toString() {
            return "RuleActionDto{" + "type: " + type + ", value: " + value + "}";
        }
    }
}
