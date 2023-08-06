package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = NestedFieldDto.Builder.class)
public final class NestedFieldDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final int fieldId;

    private final String name;

    private final boolean isHidden;

    private final boolean isLocked;

    private final boolean isDisabled;

    private final FieldPropertiesDto properties;

    private NestedFieldDto(
            Map<String, ResourceLink> links,
            int fieldId,
            String name,
            boolean isHidden,
            boolean isLocked,
            boolean isDisabled,
            FieldPropertiesDto properties) {
        this.links = links;
        this.fieldId = fieldId;
        this.name = name;
        this.isHidden = isHidden;
        this.isLocked = isLocked;
        this.isDisabled = isDisabled;
        this.properties = properties;
    }

    /**
     * @return The links.
     */
    @JsonProperty("_links")
    @Override
    public Map<String, ResourceLink> getLinks() {
        return links;
    }

    /**
     * @return The ID of the field.
     */
    @JsonProperty("fieldId")
    public int getFieldId() {
        return fieldId;
    }

    /**
     * @return The name of the field. Must be unique within the schema. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @return Defines if the field is hidden.
     */
    @JsonProperty("isHidden")
    public boolean getIsHidden() {
        return isHidden;
    }

    /**
     * @return Defines if the field is locked.
     */
    @JsonProperty("isLocked")
    public boolean getIsLocked() {
        return isLocked;
    }

    /**
     * @return Defines if the field is disabled.
     */
    @JsonProperty("isDisabled")
    public boolean getIsDisabled() {
        return isDisabled;
    }

    @JsonProperty("properties")
    public FieldPropertiesDto getProperties() {
        return properties;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof NestedFieldDto && equalTo((NestedFieldDto) other);
    }

    private boolean equalTo(NestedFieldDto other) {
        return links.equals(other.links)
                && fieldId == other.fieldId
                && name.equals(other.name)
                && isHidden == other.isHidden
                && isLocked == other.isLocked
                && isDisabled == other.isDisabled
                && properties.equals(other.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.links, this.fieldId, this.name, this.isHidden, this.isLocked, this.isDisabled, this.properties);
    }

    @Override
    public String toString() {
        return "NestedFieldDto{" + "links: " + links + ", fieldId: " + fieldId + ", name: " + name + ", isHidden: "
                + isHidden + ", isLocked: " + isLocked + ", isDisabled: " + isDisabled + ", properties: " + properties
                + "}";
    }

    public static FieldIdStage builder() {
        return new Builder();
    }

    public interface FieldIdStage {
        NameStage fieldId(int fieldId);

        Builder from(NestedFieldDto other);
    }

    public interface NameStage {
        IsHiddenStage name(String name);
    }

    public interface IsHiddenStage {
        IsLockedStage isHidden(boolean isHidden);
    }

    public interface IsLockedStage {
        IsDisabledStage isLocked(boolean isLocked);
    }

    public interface IsDisabledStage {
        PropertiesStage isDisabled(boolean isDisabled);
    }

    public interface PropertiesStage {
        _FinalStage properties(FieldPropertiesDto properties);
    }

    public interface _FinalStage {
        NestedFieldDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements FieldIdStage,
                    NameStage,
                    IsHiddenStage,
                    IsLockedStage,
                    IsDisabledStage,
                    PropertiesStage,
                    _FinalStage {
        private int fieldId;

        private String name;

        private boolean isHidden;

        private boolean isLocked;

        private boolean isDisabled;

        private FieldPropertiesDto properties;

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(NestedFieldDto other) {
            links(other.getLinks());
            fieldId(other.getFieldId());
            name(other.getName());
            isHidden(other.getIsHidden());
            isLocked(other.getIsLocked());
            isDisabled(other.getIsDisabled());
            properties(other.getProperties());
            return this;
        }

        /**
         * <p>The ID of the field.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("fieldId")
        public NameStage fieldId(int fieldId) {
            this.fieldId = fieldId;
            return this;
        }

        /**
         * <p>The name of the field. Must be unique within the schema. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name")
        public IsHiddenStage name(String name) {
            this.name = name;
            return this;
        }

        /**
         * <p>Defines if the field is hidden.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("isHidden")
        public IsLockedStage isHidden(boolean isHidden) {
            this.isHidden = isHidden;
            return this;
        }

        /**
         * <p>Defines if the field is locked.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("isLocked")
        public IsDisabledStage isLocked(boolean isLocked) {
            this.isLocked = isLocked;
            return this;
        }

        /**
         * <p>Defines if the field is disabled.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("isDisabled")
        public PropertiesStage isDisabled(boolean isDisabled) {
            this.isDisabled = isDisabled;
            return this;
        }

        @Override
        @JsonSetter("properties")
        public _FinalStage properties(FieldPropertiesDto properties) {
            this.properties = properties;
            return this;
        }

        /**
         * <p>The links.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage links(String key, ResourceLink value) {
            this.links.put(key, value);
            return this;
        }

        /**
         * <p>The links.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage putAllLinks(Map<String, ResourceLink> links) {
            this.links.putAll(links);
            return this;
        }

        @Override
        @JsonSetter(value = "_links", nulls = Nulls.SKIP)
        public _FinalStage links(Map<String, ResourceLink> links) {
            this.links.clear();
            this.links.putAll(links);
            return this;
        }

        @Override
        public NestedFieldDto build() {
            return new NestedFieldDto(links, fieldId, name, isHidden, isLocked, isDisabled, properties);
        }
    }
}
