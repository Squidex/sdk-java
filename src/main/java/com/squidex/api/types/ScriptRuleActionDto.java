package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ScriptRuleActionDto.Builder.class)
public final class ScriptRuleActionDto {
    private final String script;

    private ScriptRuleActionDto(String script) {
        this.script = script;
    }

    /**
     * @return The script to render. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("script")
    public String getScript() {
        return script;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ScriptRuleActionDto && equalTo((ScriptRuleActionDto) other);
    }

    private boolean equalTo(ScriptRuleActionDto other) {
        return script.equals(other.script);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.script);
    }

    @Override
    public String toString() {
        return "ScriptRuleActionDto{" + "script: " + script + "}";
    }

    public static ScriptStage builder() {
        return new Builder();
    }

    public interface ScriptStage {
        _FinalStage script(String script);

        Builder from(ScriptRuleActionDto other);
    }

    public interface _FinalStage {
        ScriptRuleActionDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ScriptStage, _FinalStage {
        private String script;

        private Builder() {}

        @Override
        public Builder from(ScriptRuleActionDto other) {
            script(other.getScript());
            return this;
        }

        /**
         * <p>The script to render. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("script")
        public _FinalStage script(String script) {
            this.script = script;
            return this;
        }

        @Override
        public ScriptRuleActionDto build() {
            return new ScriptRuleActionDto(script);
        }
    }
}
