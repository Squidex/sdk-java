package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = FieldDto.Builder.class)
public final class FieldDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final int fieldId;

    private final String name;

    private final boolean isHidden;

    private final boolean isLocked;

    private final boolean isDisabled;

    private final String partitioning;

    private final FieldPropertiesDto properties;

    private final Optional<List<NestedFieldDto>> nested;

    private FieldDto(
            Map<String, ResourceLink> links,
            int fieldId,
            String name,
            boolean isHidden,
            boolean isLocked,
            boolean isDisabled,
            String partitioning,
            FieldPropertiesDto properties,
            Optional<List<NestedFieldDto>> nested) {
        this.links = links;
        this.fieldId = fieldId;
        this.name = name;
        this.isHidden = isHidden;
        this.isLocked = isLocked;
        this.isDisabled = isDisabled;
        this.partitioning = partitioning;
        this.properties = properties;
        this.nested = nested;
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

    /**
     * @return Defines the partitioning of the field. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("partitioning")
    public String getPartitioning() {
        return partitioning;
    }

    @JsonProperty("properties")
    public FieldPropertiesDto getProperties() {
        return properties;
    }

    /**
     * @return The nested fields.
     */
    @JsonProperty("nested")
    public Optional<List<NestedFieldDto>> getNested() {
        return nested;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof FieldDto && equalTo((FieldDto) other);
    }

    private boolean equalTo(FieldDto other) {
        return links.equals(other.links)
                && fieldId == other.fieldId
                && name.equals(other.name)
                && isHidden == other.isHidden
                && isLocked == other.isLocked
                && isDisabled == other.isDisabled
                && partitioning.equals(other.partitioning)
                && properties.equals(other.properties)
                && nested.equals(other.nested);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.links,
                this.fieldId,
                this.name,
                this.isHidden,
                this.isLocked,
                this.isDisabled,
                this.partitioning,
                this.properties,
                this.nested);
    }

    @Override
    public String toString() {
        return "FieldDto{" + "links: " + links + ", fieldId: " + fieldId + ", name: " + name + ", isHidden: " + isHidden
                + ", isLocked: " + isLocked + ", isDisabled: " + isDisabled + ", partitioning: " + partitioning
                + ", properties: " + properties + ", nested: " + nested + "}";
    }

    public static FieldIdStage builder() {
        return new Builder();
    }

    public interface FieldIdStage {
        NameStage fieldId(int fieldId);

        Builder from(FieldDto other);
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
        PartitioningStage isDisabled(boolean isDisabled);
    }

    public interface PartitioningStage {
        PropertiesStage partitioning(String partitioning);
    }

    public interface PropertiesStage {
        _FinalStage properties(FieldPropertiesDto properties);
    }

    public interface _FinalStage {
        FieldDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);

        _FinalStage nested(Optional<List<NestedFieldDto>> nested);

        _FinalStage nested(List<NestedFieldDto> nested);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements FieldIdStage,
                    NameStage,
                    IsHiddenStage,
                    IsLockedStage,
                    IsDisabledStage,
                    PartitioningStage,
                    PropertiesStage,
                    _FinalStage {
        private int fieldId;

        private String name;

        private boolean isHidden;

        private boolean isLocked;

        private boolean isDisabled;

        private String partitioning;

        private FieldPropertiesDto properties;

        private Optional<List<NestedFieldDto>> nested = Optional.empty();

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(FieldDto other) {
            links(other.getLinks());
            fieldId(other.getFieldId());
            name(other.getName());
            isHidden(other.getIsHidden());
            isLocked(other.getIsLocked());
            isDisabled(other.getIsDisabled());
            partitioning(other.getPartitioning());
            properties(other.getProperties());
            nested(other.getNested());
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
        public PartitioningStage isDisabled(boolean isDisabled) {
            this.isDisabled = isDisabled;
            return this;
        }

        /**
         * <p>Defines the partitioning of the field. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("partitioning")
        public PropertiesStage partitioning(String partitioning) {
            this.partitioning = partitioning;
            return this;
        }

        @Override
        @JsonSetter("properties")
        public _FinalStage properties(FieldPropertiesDto properties) {
            this.properties = properties;
            return this;
        }

        /**
         * <p>The nested fields.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage nested(List<NestedFieldDto> nested) {
            this.nested = Optional.of(nested);
            return this;
        }

        @Override
        @JsonSetter(value = "nested", nulls = Nulls.SKIP)
        public _FinalStage nested(Optional<List<NestedFieldDto>> nested) {
            this.nested = nested;
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
        public FieldDto build() {
            return new FieldDto(links, fieldId, name, isHidden, isLocked, isDisabled, partitioning, properties, nested);
        }
    }
}
