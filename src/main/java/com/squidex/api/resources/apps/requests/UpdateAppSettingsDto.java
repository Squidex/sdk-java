package com.squidex.api.resources.apps.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.types.EditorDto;
import com.squidex.api.types.PatternDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UpdateAppSettingsDto.Builder.class)
public final class UpdateAppSettingsDto {
    private final List<PatternDto> patterns;

    private final List<EditorDto> editors;

    private final Optional<Boolean> hideScheduler;

    private final Optional<Boolean> hideDateTimeModeButton;

    private UpdateAppSettingsDto(
            List<PatternDto> patterns,
            List<EditorDto> editors,
            Optional<Boolean> hideScheduler,
            Optional<Boolean> hideDateTimeModeButton) {
        this.patterns = patterns;
        this.editors = editors;
        this.hideScheduler = hideScheduler;
        this.hideDateTimeModeButton = hideDateTimeModeButton;
    }

    /**
     * @return The configured app patterns.
     */
    @JsonProperty("patterns")
    public List<PatternDto> getPatterns() {
        return patterns;
    }

    /**
     * @return The configured UI editors.
     */
    @JsonProperty("editors")
    public List<EditorDto> getEditors() {
        return editors;
    }

    /**
     * @return Hide the scheduler for content items.
     */
    @JsonProperty("hideScheduler")
    public Optional<Boolean> getHideScheduler() {
        return hideScheduler;
    }

    /**
     * @return Hide the datetime mode button.
     */
    @JsonProperty("hideDateTimeModeButton")
    public Optional<Boolean> getHideDateTimeModeButton() {
        return hideDateTimeModeButton;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdateAppSettingsDto && equalTo((UpdateAppSettingsDto) other);
    }

    private boolean equalTo(UpdateAppSettingsDto other) {
        return patterns.equals(other.patterns)
                && editors.equals(other.editors)
                && hideScheduler.equals(other.hideScheduler)
                && hideDateTimeModeButton.equals(other.hideDateTimeModeButton);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.patterns, this.editors, this.hideScheduler, this.hideDateTimeModeButton);
    }

    @Override
    public String toString() {
        return "UpdateAppSettingsDto{" + "patterns: " + patterns + ", editors: " + editors + ", hideScheduler: "
                + hideScheduler + ", hideDateTimeModeButton: " + hideDateTimeModeButton + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private List<PatternDto> patterns = new ArrayList<>();

        private List<EditorDto> editors = new ArrayList<>();

        private Optional<Boolean> hideScheduler = Optional.empty();

        private Optional<Boolean> hideDateTimeModeButton = Optional.empty();

        private Builder() {}

        public Builder from(UpdateAppSettingsDto other) {
            patterns(other.getPatterns());
            editors(other.getEditors());
            hideScheduler(other.getHideScheduler());
            hideDateTimeModeButton(other.getHideDateTimeModeButton());
            return this;
        }

        @JsonSetter(value = "patterns", nulls = Nulls.SKIP)
        public Builder patterns(List<PatternDto> patterns) {
            this.patterns.clear();
            this.patterns.addAll(patterns);
            return this;
        }

        public Builder addPatterns(PatternDto patterns) {
            this.patterns.add(patterns);
            return this;
        }

        public Builder addAllPatterns(List<PatternDto> patterns) {
            this.patterns.addAll(patterns);
            return this;
        }

        @JsonSetter(value = "editors", nulls = Nulls.SKIP)
        public Builder editors(List<EditorDto> editors) {
            this.editors.clear();
            this.editors.addAll(editors);
            return this;
        }

        public Builder addEditors(EditorDto editors) {
            this.editors.add(editors);
            return this;
        }

        public Builder addAllEditors(List<EditorDto> editors) {
            this.editors.addAll(editors);
            return this;
        }

        @JsonSetter(value = "hideScheduler", nulls = Nulls.SKIP)
        public Builder hideScheduler(Optional<Boolean> hideScheduler) {
            this.hideScheduler = hideScheduler;
            return this;
        }

        public Builder hideScheduler(Boolean hideScheduler) {
            this.hideScheduler = Optional.of(hideScheduler);
            return this;
        }

        @JsonSetter(value = "hideDateTimeModeButton", nulls = Nulls.SKIP)
        public Builder hideDateTimeModeButton(Optional<Boolean> hideDateTimeModeButton) {
            this.hideDateTimeModeButton = hideDateTimeModeButton;
            return this;
        }

        public Builder hideDateTimeModeButton(Boolean hideDateTimeModeButton) {
            this.hideDateTimeModeButton = Optional.of(hideDateTimeModeButton);
            return this;
        }

        public UpdateAppSettingsDto build() {
            return new UpdateAppSettingsDto(patterns, editors, hideScheduler, hideDateTimeModeButton);
        }
    }
}
