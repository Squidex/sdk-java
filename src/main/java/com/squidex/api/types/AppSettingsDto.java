package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AppSettingsDto.Builder.class)
public final class AppSettingsDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final List<PatternDto> patterns;

    private final List<EditorDto> editors;

    private final boolean hideScheduler;

    private final boolean hideDateTimeModeButton;

    private final int version;

    private AppSettingsDto(
            Map<String, ResourceLink> links,
            List<PatternDto> patterns,
            List<EditorDto> editors,
            boolean hideScheduler,
            boolean hideDateTimeModeButton,
            int version) {
        this.links = links;
        this.patterns = patterns;
        this.editors = editors;
        this.hideScheduler = hideScheduler;
        this.hideDateTimeModeButton = hideDateTimeModeButton;
        this.version = version;
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
    public boolean getHideScheduler() {
        return hideScheduler;
    }

    /**
     * @return Hide the datetime mode button.
     */
    @JsonProperty("hideDateTimeModeButton")
    public boolean getHideDateTimeModeButton() {
        return hideDateTimeModeButton;
    }

    /**
     * @return The version of the app.
     */
    @JsonProperty("version")
    public int getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AppSettingsDto && equalTo((AppSettingsDto) other);
    }

    private boolean equalTo(AppSettingsDto other) {
        return links.equals(other.links)
                && patterns.equals(other.patterns)
                && editors.equals(other.editors)
                && hideScheduler == other.hideScheduler
                && hideDateTimeModeButton == other.hideDateTimeModeButton
                && version == other.version;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.links, this.patterns, this.editors, this.hideScheduler, this.hideDateTimeModeButton, this.version);
    }

    @Override
    public String toString() {
        return "AppSettingsDto{" + "links: " + links + ", patterns: " + patterns + ", editors: " + editors
                + ", hideScheduler: " + hideScheduler + ", hideDateTimeModeButton: " + hideDateTimeModeButton
                + ", version: " + version + "}";
    }

    public static HideSchedulerStage builder() {
        return new Builder();
    }

    public interface HideSchedulerStage {
        HideDateTimeModeButtonStage hideScheduler(boolean hideScheduler);

        Builder from(AppSettingsDto other);
    }

    public interface HideDateTimeModeButtonStage {
        VersionStage hideDateTimeModeButton(boolean hideDateTimeModeButton);
    }

    public interface VersionStage {
        _FinalStage version(int version);
    }

    public interface _FinalStage {
        AppSettingsDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);

        _FinalStage patterns(List<PatternDto> patterns);

        _FinalStage addPatterns(PatternDto patterns);

        _FinalStage addAllPatterns(List<PatternDto> patterns);

        _FinalStage editors(List<EditorDto> editors);

        _FinalStage addEditors(EditorDto editors);

        _FinalStage addAllEditors(List<EditorDto> editors);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements HideSchedulerStage, HideDateTimeModeButtonStage, VersionStage, _FinalStage {
        private boolean hideScheduler;

        private boolean hideDateTimeModeButton;

        private int version;

        private List<EditorDto> editors = new ArrayList<>();

        private List<PatternDto> patterns = new ArrayList<>();

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(AppSettingsDto other) {
            links(other.getLinks());
            patterns(other.getPatterns());
            editors(other.getEditors());
            hideScheduler(other.getHideScheduler());
            hideDateTimeModeButton(other.getHideDateTimeModeButton());
            version(other.getVersion());
            return this;
        }

        /**
         * <p>Hide the scheduler for content items.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("hideScheduler")
        public HideDateTimeModeButtonStage hideScheduler(boolean hideScheduler) {
            this.hideScheduler = hideScheduler;
            return this;
        }

        /**
         * <p>Hide the datetime mode button.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("hideDateTimeModeButton")
        public VersionStage hideDateTimeModeButton(boolean hideDateTimeModeButton) {
            this.hideDateTimeModeButton = hideDateTimeModeButton;
            return this;
        }

        /**
         * <p>The version of the app.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("version")
        public _FinalStage version(int version) {
            this.version = version;
            return this;
        }

        /**
         * <p>The configured UI editors.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllEditors(List<EditorDto> editors) {
            this.editors.addAll(editors);
            return this;
        }

        /**
         * <p>The configured UI editors.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addEditors(EditorDto editors) {
            this.editors.add(editors);
            return this;
        }

        @Override
        @JsonSetter(value = "editors", nulls = Nulls.SKIP)
        public _FinalStage editors(List<EditorDto> editors) {
            this.editors.clear();
            this.editors.addAll(editors);
            return this;
        }

        /**
         * <p>The configured app patterns.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllPatterns(List<PatternDto> patterns) {
            this.patterns.addAll(patterns);
            return this;
        }

        /**
         * <p>The configured app patterns.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addPatterns(PatternDto patterns) {
            this.patterns.add(patterns);
            return this;
        }

        @Override
        @JsonSetter(value = "patterns", nulls = Nulls.SKIP)
        public _FinalStage patterns(List<PatternDto> patterns) {
            this.patterns.clear();
            this.patterns.addAll(patterns);
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
        public AppSettingsDto build() {
            return new AppSettingsDto(links, patterns, editors, hideScheduler, hideDateTimeModeButton, version);
        }
    }
}
