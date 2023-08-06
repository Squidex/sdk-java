package com.squidex.api.resources.apps.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CreateAppDto.Builder.class)
public final class CreateAppDto {
    private final String name;

    private final Optional<String> template;

    private CreateAppDto(String name, Optional<String> template) {
        this.name = name;
        this.template = template;
    }

    /**
     * @return The name of the app. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @return Initialize the app with the inbuilt template.
     */
    @JsonProperty("template")
    public Optional<String> getTemplate() {
        return template;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateAppDto && equalTo((CreateAppDto) other);
    }

    private boolean equalTo(CreateAppDto other) {
        return name.equals(other.name) && template.equals(other.template);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.template);
    }

    @Override
    public String toString() {
        return "CreateAppDto{" + "name: " + name + ", template: " + template + "}";
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        _FinalStage name(String name);

        Builder from(CreateAppDto other);
    }

    public interface _FinalStage {
        CreateAppDto build();

        _FinalStage template(Optional<String> template);

        _FinalStage template(String template);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, _FinalStage {
        private String name;

        private Optional<String> template = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(CreateAppDto other) {
            name(other.getName());
            template(other.getTemplate());
            return this;
        }

        /**
         * <p>The name of the app. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name")
        public _FinalStage name(String name) {
            this.name = name;
            return this;
        }

        /**
         * <p>Initialize the app with the inbuilt template.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage template(String template) {
            this.template = Optional.of(template);
            return this;
        }

        @Override
        @JsonSetter(value = "template", nulls = Nulls.SKIP)
        public _FinalStage template(Optional<String> template) {
            this.template = template;
            return this;
        }

        @Override
        public CreateAppDto build() {
            return new CreateAppDto(name, template);
        }
    }
}
