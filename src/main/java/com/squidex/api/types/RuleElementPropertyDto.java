package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = RuleElementPropertyDto.Builder.class)
public final class RuleElementPropertyDto {
    private final RuleFieldEditor editor;

    private final String name;

    private final String display;

    private final Optional<List<String>> options;

    private final Optional<String> description;

    private final boolean isFormattable;

    private final boolean isRequired;

    private RuleElementPropertyDto(
            RuleFieldEditor editor,
            String name,
            String display,
            Optional<List<String>> options,
            Optional<String> description,
            boolean isFormattable,
            boolean isRequired) {
        this.editor = editor;
        this.name = name;
        this.display = display;
        this.options = options;
        this.description = description;
        this.isFormattable = isFormattable;
        this.isRequired = isRequired;
    }

    /**
     * @return The html editor.
     */
    @JsonProperty("editor")
    public RuleFieldEditor getEditor() {
        return editor;
    }

    /**
     * @return The name of the editor.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @return The label to use.
     */
    @JsonProperty("display")
    public String getDisplay() {
        return display;
    }

    /**
     * @return The options, if the editor is a dropdown.
     */
    @JsonProperty("options")
    public Optional<List<String>> getOptions() {
        return options;
    }

    /**
     * @return The optional description.
     */
    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    /**
     * @return Indicates if the property is formattable.
     */
    @JsonProperty("isFormattable")
    public boolean getIsFormattable() {
        return isFormattable;
    }

    /**
     * @return Indicates if the property is required.
     */
    @JsonProperty("isRequired")
    public boolean getIsRequired() {
        return isRequired;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RuleElementPropertyDto && equalTo((RuleElementPropertyDto) other);
    }

    private boolean equalTo(RuleElementPropertyDto other) {
        return editor.equals(other.editor)
                && name.equals(other.name)
                && display.equals(other.display)
                && options.equals(other.options)
                && description.equals(other.description)
                && isFormattable == other.isFormattable
                && isRequired == other.isRequired;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.editor,
                this.name,
                this.display,
                this.options,
                this.description,
                this.isFormattable,
                this.isRequired);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static EditorStage builder() {
        return new Builder();
    }

    public interface EditorStage {
        NameStage editor(RuleFieldEditor editor);

        Builder from(RuleElementPropertyDto other);
    }

    public interface NameStage {
        DisplayStage name(String name);
    }

    public interface DisplayStage {
        IsFormattableStage display(String display);
    }

    public interface IsFormattableStage {
        IsRequiredStage isFormattable(boolean isFormattable);
    }

    public interface IsRequiredStage {
        _FinalStage isRequired(boolean isRequired);
    }

    public interface _FinalStage {
        RuleElementPropertyDto build();

        _FinalStage options(Optional<List<String>> options);

        _FinalStage options(List<String> options);

        _FinalStage description(Optional<String> description);

        _FinalStage description(String description);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements EditorStage, NameStage, DisplayStage, IsFormattableStage, IsRequiredStage, _FinalStage {
        private RuleFieldEditor editor;

        private String name;

        private String display;

        private boolean isFormattable;

        private boolean isRequired;

        private Optional<String> description = Optional.empty();

        private Optional<List<String>> options = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(RuleElementPropertyDto other) {
            editor(other.getEditor());
            name(other.getName());
            display(other.getDisplay());
            options(other.getOptions());
            description(other.getDescription());
            isFormattable(other.getIsFormattable());
            isRequired(other.getIsRequired());
            return this;
        }

        /**
         * <p>The html editor.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("editor")
        public NameStage editor(RuleFieldEditor editor) {
            this.editor = editor;
            return this;
        }

        /**
         * <p>The name of the editor.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name")
        public DisplayStage name(String name) {
            this.name = name;
            return this;
        }

        /**
         * <p>The label to use.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("display")
        public IsFormattableStage display(String display) {
            this.display = display;
            return this;
        }

        /**
         * <p>Indicates if the property is formattable.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("isFormattable")
        public IsRequiredStage isFormattable(boolean isFormattable) {
            this.isFormattable = isFormattable;
            return this;
        }

        /**
         * <p>Indicates if the property is required.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("isRequired")
        public _FinalStage isRequired(boolean isRequired) {
            this.isRequired = isRequired;
            return this;
        }

        /**
         * <p>The optional description.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage description(String description) {
            this.description = Optional.of(description);
            return this;
        }

        @Override
        @JsonSetter(value = "description", nulls = Nulls.SKIP)
        public _FinalStage description(Optional<String> description) {
            this.description = description;
            return this;
        }

        /**
         * <p>The options, if the editor is a dropdown.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage options(List<String> options) {
            this.options = Optional.of(options);
            return this;
        }

        @Override
        @JsonSetter(value = "options", nulls = Nulls.SKIP)
        public _FinalStage options(Optional<List<String>> options) {
            this.options = options;
            return this;
        }

        @Override
        public RuleElementPropertyDto build() {
            return new RuleElementPropertyDto(editor, name, display, options, description, isFormattable, isRequired);
        }
    }
}
