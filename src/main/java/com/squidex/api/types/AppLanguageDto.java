package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AppLanguageDto.Builder.class)
public final class AppLanguageDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final String iso2Code;

    private final String englishName;

    private final List<String> fallback;

    private final boolean isMaster;

    private final boolean isOptional;

    private AppLanguageDto(
            Map<String, ResourceLink> links,
            String iso2Code,
            String englishName,
            List<String> fallback,
            boolean isMaster,
            boolean isOptional) {
        this.links = links;
        this.iso2Code = iso2Code;
        this.englishName = englishName;
        this.fallback = fallback;
        this.isMaster = isMaster;
        this.isOptional = isOptional;
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
     * @return The iso code of the language.
     */
    @JsonProperty("iso2Code")
    public String getIso2Code() {
        return iso2Code;
    }

    /**
     * @return The english name of the language.
     */
    @JsonProperty("englishName")
    public String getEnglishName() {
        return englishName;
    }

    /**
     * @return The fallback languages.
     */
    @JsonProperty("fallback")
    public List<String> getFallback() {
        return fallback;
    }

    /**
     * @return Indicates if the language is the master language.
     */
    @JsonProperty("isMaster")
    public boolean getIsMaster() {
        return isMaster;
    }

    /**
     * @return Indicates if the language is optional.
     */
    @JsonProperty("isOptional")
    public boolean getIsOptional() {
        return isOptional;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AppLanguageDto && equalTo((AppLanguageDto) other);
    }

    private boolean equalTo(AppLanguageDto other) {
        return links.equals(other.links)
                && iso2Code.equals(other.iso2Code)
                && englishName.equals(other.englishName)
                && fallback.equals(other.fallback)
                && isMaster == other.isMaster
                && isOptional == other.isOptional;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.links, this.iso2Code, this.englishName, this.fallback, this.isMaster, this.isOptional);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Iso2CodeStage builder() {
        return new Builder();
    }

    public interface Iso2CodeStage {
        EnglishNameStage iso2Code(String iso2Code);

        Builder from(AppLanguageDto other);
    }

    public interface EnglishNameStage {
        IsMasterStage englishName(String englishName);
    }

    public interface IsMasterStage {
        IsOptionalStage isMaster(boolean isMaster);
    }

    public interface IsOptionalStage {
        _FinalStage isOptional(boolean isOptional);
    }

    public interface _FinalStage {
        AppLanguageDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);

        _FinalStage fallback(List<String> fallback);

        _FinalStage addFallback(String fallback);

        _FinalStage addAllFallback(List<String> fallback);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements Iso2CodeStage, EnglishNameStage, IsMasterStage, IsOptionalStage, _FinalStage {
        private String iso2Code;

        private String englishName;

        private boolean isMaster;

        private boolean isOptional;

        private List<String> fallback = new ArrayList<>();

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(AppLanguageDto other) {
            links(other.getLinks());
            iso2Code(other.getIso2Code());
            englishName(other.getEnglishName());
            fallback(other.getFallback());
            isMaster(other.getIsMaster());
            isOptional(other.getIsOptional());
            return this;
        }

        /**
         * <p>The iso code of the language.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("iso2Code")
        public EnglishNameStage iso2Code(String iso2Code) {
            this.iso2Code = iso2Code;
            return this;
        }

        /**
         * <p>The english name of the language.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("englishName")
        public IsMasterStage englishName(String englishName) {
            this.englishName = englishName;
            return this;
        }

        /**
         * <p>Indicates if the language is the master language.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("isMaster")
        public IsOptionalStage isMaster(boolean isMaster) {
            this.isMaster = isMaster;
            return this;
        }

        /**
         * <p>Indicates if the language is optional.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("isOptional")
        public _FinalStage isOptional(boolean isOptional) {
            this.isOptional = isOptional;
            return this;
        }

        /**
         * <p>The fallback languages.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllFallback(List<String> fallback) {
            this.fallback.addAll(fallback);
            return this;
        }

        /**
         * <p>The fallback languages.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addFallback(String fallback) {
            this.fallback.add(fallback);
            return this;
        }

        @Override
        @JsonSetter(value = "fallback", nulls = Nulls.SKIP)
        public _FinalStage fallback(List<String> fallback) {
            this.fallback.clear();
            this.fallback.addAll(fallback);
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
        public AppLanguageDto build() {
            return new AppLanguageDto(links, iso2Code, englishName, fallback, isMaster, isOptional);
        }
    }
}
