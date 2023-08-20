package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = LanguageDto.Builder.class)
public final class LanguageDto {
    private final String iso2Code;

    private final String englishName;

    private final String nativeName;

    private LanguageDto(String iso2Code, String englishName, String nativeName) {
        this.iso2Code = iso2Code;
        this.englishName = englishName;
        this.nativeName = nativeName;
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
     * @return The native name of the language.
     */
    @JsonProperty("nativeName")
    public String getNativeName() {
        return nativeName;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LanguageDto && equalTo((LanguageDto) other);
    }

    private boolean equalTo(LanguageDto other) {
        return iso2Code.equals(other.iso2Code)
                && englishName.equals(other.englishName)
                && nativeName.equals(other.nativeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.iso2Code, this.englishName, this.nativeName);
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

        Builder from(LanguageDto other);
    }

    public interface EnglishNameStage {
        NativeNameStage englishName(String englishName);
    }

    public interface NativeNameStage {
        _FinalStage nativeName(String nativeName);
    }

    public interface _FinalStage {
        LanguageDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements Iso2CodeStage, EnglishNameStage, NativeNameStage, _FinalStage {
        private String iso2Code;

        private String englishName;

        private String nativeName;

        private Builder() {}

        @Override
        public Builder from(LanguageDto other) {
            iso2Code(other.getIso2Code());
            englishName(other.getEnglishName());
            nativeName(other.getNativeName());
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
        public NativeNameStage englishName(String englishName) {
            this.englishName = englishName;
            return this;
        }

        /**
         * <p>The native name of the language.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("nativeName")
        public _FinalStage nativeName(String nativeName) {
            this.nativeName = nativeName;
            return this;
        }

        @Override
        public LanguageDto build() {
            return new LanguageDto(iso2Code, englishName, nativeName);
        }
    }
}
