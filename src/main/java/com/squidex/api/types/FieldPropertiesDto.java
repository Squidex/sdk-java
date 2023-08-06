package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import java.util.Objects;
import java.util.Optional;

public final class FieldPropertiesDto {
    private final Value value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    private FieldPropertiesDto(Value value) {
        this.value = value;
    }

    public <T> T visit(Visitor<T> visitor) {
        return value.visit(visitor);
    }

    public static FieldPropertiesDto array(ArrayFieldPropertiesDto value) {
        return new FieldPropertiesDto(new ArrayValue(value));
    }

    public static FieldPropertiesDto assets(AssetsFieldPropertiesDto value) {
        return new FieldPropertiesDto(new AssetsValue(value));
    }

    public static FieldPropertiesDto boolean_(BooleanFieldPropertiesDto value) {
        return new FieldPropertiesDto(new BooleanValue(value));
    }

    public static FieldPropertiesDto component(ComponentFieldPropertiesDto value) {
        return new FieldPropertiesDto(new ComponentValue(value));
    }

    public static FieldPropertiesDto components(ComponentsFieldPropertiesDto value) {
        return new FieldPropertiesDto(new ComponentsValue(value));
    }

    public static FieldPropertiesDto dateTime(DateTimeFieldPropertiesDto value) {
        return new FieldPropertiesDto(new DateTimeValue(value));
    }

    public static FieldPropertiesDto geolocation(GeolocationFieldPropertiesDto value) {
        return new FieldPropertiesDto(new GeolocationValue(value));
    }

    public static FieldPropertiesDto json(JsonFieldPropertiesDto value) {
        return new FieldPropertiesDto(new JsonValue(value));
    }

    public static FieldPropertiesDto number(NumberFieldPropertiesDto value) {
        return new FieldPropertiesDto(new NumberValue(value));
    }

    public static FieldPropertiesDto references(ReferencesFieldPropertiesDto value) {
        return new FieldPropertiesDto(new ReferencesValue(value));
    }

    public static FieldPropertiesDto string(StringFieldPropertiesDto value) {
        return new FieldPropertiesDto(new StringValue(value));
    }

    public static FieldPropertiesDto tags(TagsFieldPropertiesDto value) {
        return new FieldPropertiesDto(new TagsValue(value));
    }

    public static FieldPropertiesDto ui(UiFieldPropertiesDto value) {
        return new FieldPropertiesDto(new UiValue(value));
    }

    public boolean isArray() {
        return value instanceof ArrayValue;
    }

    public boolean isAssets() {
        return value instanceof AssetsValue;
    }

    public boolean isBoolean() {
        return value instanceof BooleanValue;
    }

    public boolean isComponent() {
        return value instanceof ComponentValue;
    }

    public boolean isComponents() {
        return value instanceof ComponentsValue;
    }

    public boolean isDateTime() {
        return value instanceof DateTimeValue;
    }

    public boolean isGeolocation() {
        return value instanceof GeolocationValue;
    }

    public boolean isJson() {
        return value instanceof JsonValue;
    }

    public boolean isNumber() {
        return value instanceof NumberValue;
    }

    public boolean isReferences() {
        return value instanceof ReferencesValue;
    }

    public boolean isString() {
        return value instanceof StringValue;
    }

    public boolean isTags() {
        return value instanceof TagsValue;
    }

    public boolean isUi() {
        return value instanceof UiValue;
    }

    public boolean _isUnknown() {
        return value instanceof _UnknownValue;
    }

    public Optional<ArrayFieldPropertiesDto> getArray() {
        if (isArray()) {
            return Optional.of(((ArrayValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<AssetsFieldPropertiesDto> getAssets() {
        if (isAssets()) {
            return Optional.of(((AssetsValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<BooleanFieldPropertiesDto> getBoolean() {
        if (isBoolean()) {
            return Optional.of(((BooleanValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<ComponentFieldPropertiesDto> getComponent() {
        if (isComponent()) {
            return Optional.of(((ComponentValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<ComponentsFieldPropertiesDto> getComponents() {
        if (isComponents()) {
            return Optional.of(((ComponentsValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<DateTimeFieldPropertiesDto> getDateTime() {
        if (isDateTime()) {
            return Optional.of(((DateTimeValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<GeolocationFieldPropertiesDto> getGeolocation() {
        if (isGeolocation()) {
            return Optional.of(((GeolocationValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<JsonFieldPropertiesDto> getJson() {
        if (isJson()) {
            return Optional.of(((JsonValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<NumberFieldPropertiesDto> getNumber() {
        if (isNumber()) {
            return Optional.of(((NumberValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<ReferencesFieldPropertiesDto> getReferences() {
        if (isReferences()) {
            return Optional.of(((ReferencesValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<StringFieldPropertiesDto> getString() {
        if (isString()) {
            return Optional.of(((StringValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<TagsFieldPropertiesDto> getTags() {
        if (isTags()) {
            return Optional.of(((TagsValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<UiFieldPropertiesDto> getUi() {
        if (isUi()) {
            return Optional.of(((UiValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<Object> _getUnknown() {
        if (_isUnknown()) {
            return Optional.of(((_UnknownValue) value).value);
        }
        return Optional.empty();
    }

    @com.fasterxml.jackson.annotation.JsonValue
    private Value getValue() {
        return this.value;
    }

    public interface Visitor<T> {
        T visitArray(ArrayFieldPropertiesDto array);

        T visitAssets(AssetsFieldPropertiesDto assets);

        T visitBoolean(BooleanFieldPropertiesDto boolean_);

        T visitComponent(ComponentFieldPropertiesDto component);

        T visitComponents(ComponentsFieldPropertiesDto components);

        T visitDateTime(DateTimeFieldPropertiesDto dateTime);

        T visitGeolocation(GeolocationFieldPropertiesDto geolocation);

        T visitJson(JsonFieldPropertiesDto json);

        T visitNumber(NumberFieldPropertiesDto number);

        T visitReferences(ReferencesFieldPropertiesDto references);

        T visitString(StringFieldPropertiesDto string);

        T visitTags(TagsFieldPropertiesDto tags);

        T visitUi(UiFieldPropertiesDto ui);

        T _visitUnknown(Object unknownType);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "fieldType", visible = true, defaultImpl = _UnknownValue.class)
    @JsonSubTypes({
        @JsonSubTypes.Type(ArrayValue.class),
        @JsonSubTypes.Type(AssetsValue.class),
        @JsonSubTypes.Type(BooleanValue.class),
        @JsonSubTypes.Type(ComponentValue.class),
        @JsonSubTypes.Type(ComponentsValue.class),
        @JsonSubTypes.Type(DateTimeValue.class),
        @JsonSubTypes.Type(GeolocationValue.class),
        @JsonSubTypes.Type(JsonValue.class),
        @JsonSubTypes.Type(NumberValue.class),
        @JsonSubTypes.Type(ReferencesValue.class),
        @JsonSubTypes.Type(StringValue.class),
        @JsonSubTypes.Type(TagsValue.class),
        @JsonSubTypes.Type(UiValue.class)
    })
    @JsonIgnoreProperties(ignoreUnknown = true)
    private interface Value {
        <T> T visit(Visitor<T> visitor);
    }

    @JsonTypeName("Array")
    private static final class ArrayValue implements Value {
        @JsonUnwrapped
        private ArrayFieldPropertiesDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private ArrayValue() {}

        private ArrayValue(ArrayFieldPropertiesDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitArray(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof ArrayValue && equalTo((ArrayValue) other);
        }

        private boolean equalTo(ArrayValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "FieldPropertiesDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("Assets")
    private static final class AssetsValue implements Value {
        @JsonUnwrapped
        private AssetsFieldPropertiesDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private AssetsValue() {}

        private AssetsValue(AssetsFieldPropertiesDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitAssets(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof AssetsValue && equalTo((AssetsValue) other);
        }

        private boolean equalTo(AssetsValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "FieldPropertiesDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("Boolean")
    private static final class BooleanValue implements Value {
        @JsonUnwrapped
        private BooleanFieldPropertiesDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private BooleanValue() {}

        private BooleanValue(BooleanFieldPropertiesDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitBoolean(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof BooleanValue && equalTo((BooleanValue) other);
        }

        private boolean equalTo(BooleanValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "FieldPropertiesDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("Component")
    private static final class ComponentValue implements Value {
        @JsonUnwrapped
        private ComponentFieldPropertiesDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private ComponentValue() {}

        private ComponentValue(ComponentFieldPropertiesDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitComponent(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof ComponentValue && equalTo((ComponentValue) other);
        }

        private boolean equalTo(ComponentValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "FieldPropertiesDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("Components")
    private static final class ComponentsValue implements Value {
        @JsonUnwrapped
        private ComponentsFieldPropertiesDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private ComponentsValue() {}

        private ComponentsValue(ComponentsFieldPropertiesDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitComponents(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof ComponentsValue && equalTo((ComponentsValue) other);
        }

        private boolean equalTo(ComponentsValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "FieldPropertiesDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("DateTime")
    private static final class DateTimeValue implements Value {
        @JsonUnwrapped
        private DateTimeFieldPropertiesDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private DateTimeValue() {}

        private DateTimeValue(DateTimeFieldPropertiesDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitDateTime(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof DateTimeValue && equalTo((DateTimeValue) other);
        }

        private boolean equalTo(DateTimeValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "FieldPropertiesDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("Geolocation")
    private static final class GeolocationValue implements Value {
        @JsonUnwrapped
        private GeolocationFieldPropertiesDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private GeolocationValue() {}

        private GeolocationValue(GeolocationFieldPropertiesDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitGeolocation(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof GeolocationValue && equalTo((GeolocationValue) other);
        }

        private boolean equalTo(GeolocationValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "FieldPropertiesDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("Json")
    private static final class JsonValue implements Value {
        @JsonUnwrapped
        private JsonFieldPropertiesDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private JsonValue() {}

        private JsonValue(JsonFieldPropertiesDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitJson(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof JsonValue && equalTo((JsonValue) other);
        }

        private boolean equalTo(JsonValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "FieldPropertiesDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("Number")
    private static final class NumberValue implements Value {
        @JsonUnwrapped
        private NumberFieldPropertiesDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private NumberValue() {}

        private NumberValue(NumberFieldPropertiesDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitNumber(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof NumberValue && equalTo((NumberValue) other);
        }

        private boolean equalTo(NumberValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "FieldPropertiesDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("References")
    private static final class ReferencesValue implements Value {
        @JsonUnwrapped
        private ReferencesFieldPropertiesDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private ReferencesValue() {}

        private ReferencesValue(ReferencesFieldPropertiesDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitReferences(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof ReferencesValue && equalTo((ReferencesValue) other);
        }

        private boolean equalTo(ReferencesValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "FieldPropertiesDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("String")
    private static final class StringValue implements Value {
        @JsonUnwrapped
        private StringFieldPropertiesDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private StringValue() {}

        private StringValue(StringFieldPropertiesDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitString(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof StringValue && equalTo((StringValue) other);
        }

        private boolean equalTo(StringValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "FieldPropertiesDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("Tags")
    private static final class TagsValue implements Value {
        @JsonUnwrapped
        private TagsFieldPropertiesDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private TagsValue() {}

        private TagsValue(TagsFieldPropertiesDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitTags(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof TagsValue && equalTo((TagsValue) other);
        }

        private boolean equalTo(TagsValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "FieldPropertiesDto{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("UI")
    private static final class UiValue implements Value {
        @JsonUnwrapped
        private UiFieldPropertiesDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private UiValue() {}

        private UiValue(UiFieldPropertiesDto value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitUi(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof UiValue && equalTo((UiValue) other);
        }

        private boolean equalTo(UiValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "FieldPropertiesDto{" + "value: " + value + "}";
        }
    }

    private static final class _UnknownValue implements Value {
        private String type;

        @com.fasterxml.jackson.annotation.JsonValue
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
            return "FieldPropertiesDto{" + "type: " + type + ", value: " + value + "}";
        }
    }
}
