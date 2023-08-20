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

public final class RuleTriggerDto {
    private final Value value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    private RuleTriggerDto(Value value) {
        this.value = value;
    }

    public <T> T visit(Visitor<T> visitor) {
        return value.visit(visitor);
    }

    public static RuleTriggerDto assetChanged(AssetChangedRuleTriggerDto value) {
        return new RuleTriggerDto(new AssetChangedValue(value));
    }

    public static RuleTriggerDto comment(CommentRuleTriggerDto value) {
        return new RuleTriggerDto(new CommentValue(value));
    }

    public static RuleTriggerDto contentChanged(ContentChangedRuleTriggerDto value) {
        return new RuleTriggerDto(new ContentChangedValue(value));
    }

    public static RuleTriggerDto manual(ManualRuleTriggerDto value) {
        return new RuleTriggerDto(new ManualValue(value));
    }

    public static RuleTriggerDto schemaChanged(SchemaChangedRuleTriggerDto value) {
        return new RuleTriggerDto(new SchemaChangedValue(value));
    }

    public static RuleTriggerDto usage(UsageRuleTriggerDto value) {
        return new RuleTriggerDto(new UsageValue(value));
    }

    public boolean isAssetChanged() {
        return value instanceof AssetChangedValue;
    }

    public boolean isComment() {
        return value instanceof CommentValue;
    }

    public boolean isContentChanged() {
        return value instanceof ContentChangedValue;
    }

    public boolean isManual() {
        return value instanceof ManualValue;
    }

    public boolean isSchemaChanged() {
        return value instanceof SchemaChangedValue;
    }

    public boolean isUsage() {
        return value instanceof UsageValue;
    }

    public boolean _isUnknown() {
        return value instanceof _UnknownValue;
    }

    public Optional<AssetChangedRuleTriggerDto> getAssetChanged() {
        if (isAssetChanged()) {
            return Optional.of(((AssetChangedValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<CommentRuleTriggerDto> getComment() {
        if (isComment()) {
            return Optional.of(((CommentValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<ContentChangedRuleTriggerDto> getContentChanged() {
        if (isContentChanged()) {
            return Optional.of(((ContentChangedValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<ManualRuleTriggerDto> getManual() {
        if (isManual()) {
            return Optional.of(((ManualValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<SchemaChangedRuleTriggerDto> getSchemaChanged() {
        if (isSchemaChanged()) {
            return Optional.of(((SchemaChangedValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<UsageRuleTriggerDto> getUsage() {
        if (isUsage()) {
            return Optional.of(((UsageValue) value).value);
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
        T visitAssetChanged(AssetChangedRuleTriggerDto assetChanged);

        T visitComment(CommentRuleTriggerDto comment);

        T visitContentChanged(ContentChangedRuleTriggerDto contentChanged);

        T visitManual(ManualRuleTriggerDto manual);

        T visitSchemaChanged(SchemaChangedRuleTriggerDto schemaChanged);

        T visitUsage(UsageRuleTriggerDto usage);

        T _visitUnknown(Object unknownType);
    }

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            property = "triggerType",
            visible = true,
            defaultImpl = _UnknownValue.class)
    @JsonSubTypes({
        @JsonSubTypes.Type(AssetChangedValue.class),
        @JsonSubTypes.Type(CommentValue.class),
        @JsonSubTypes.Type(ContentChangedValue.class),
        @JsonSubTypes.Type(ManualValue.class),
        @JsonSubTypes.Type(SchemaChangedValue.class),
        @JsonSubTypes.Type(UsageValue.class)
    })
    @JsonIgnoreProperties(ignoreUnknown = true)
    private interface Value {
        <T> T visit(Visitor<T> visitor);
    }

    @JsonTypeName("AssetChanged")
    private static final class AssetChangedValue implements Value {
        @JsonUnwrapped
        private AssetChangedRuleTriggerDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private AssetChangedValue() {}

        private AssetChangedValue(AssetChangedRuleTriggerDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitAssetChanged(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof AssetChangedValue && equalTo((AssetChangedValue) other);
        }

        private boolean equalTo(AssetChangedValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "RuleTriggerDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("Comment")
    private static final class CommentValue implements Value {
        @JsonUnwrapped
        private CommentRuleTriggerDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private CommentValue() {}

        private CommentValue(CommentRuleTriggerDto value) {
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
            return "RuleTriggerDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("ContentChanged")
    private static final class ContentChangedValue implements Value {
        @JsonUnwrapped
        private ContentChangedRuleTriggerDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private ContentChangedValue() {}

        private ContentChangedValue(ContentChangedRuleTriggerDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitContentChanged(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof ContentChangedValue && equalTo((ContentChangedValue) other);
        }

        private boolean equalTo(ContentChangedValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "RuleTriggerDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("Manual")
    private static final class ManualValue implements Value {
        @JsonUnwrapped
        private ManualRuleTriggerDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private ManualValue() {}

        private ManualValue(ManualRuleTriggerDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitManual(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof ManualValue && equalTo((ManualValue) other);
        }

        private boolean equalTo(ManualValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "RuleTriggerDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("SchemaChanged")
    private static final class SchemaChangedValue implements Value {
        @JsonUnwrapped
        private SchemaChangedRuleTriggerDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private SchemaChangedValue() {}

        private SchemaChangedValue(SchemaChangedRuleTriggerDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitSchemaChanged(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof SchemaChangedValue && equalTo((SchemaChangedValue) other);
        }

        private boolean equalTo(SchemaChangedValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "RuleTriggerDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("Usage")
    private static final class UsageValue implements Value {
        @JsonUnwrapped
        private UsageRuleTriggerDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private UsageValue() {}

        private UsageValue(UsageRuleTriggerDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitUsage(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof UsageValue && equalTo((UsageValue) other);
        }

        private boolean equalTo(UsageValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "RuleTriggerDto{" + "value: " + value + "}";
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
            return "RuleTriggerDto{" + "type: " + type + ", value: " + value + "}";
        }
    }
}
