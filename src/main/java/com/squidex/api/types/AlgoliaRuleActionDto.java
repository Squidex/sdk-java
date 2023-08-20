package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AlgoliaRuleActionDto.Builder.class)
public final class AlgoliaRuleActionDto {
    private final String appId;

    private final String apiKey;

    private final String indexName;

    private final Optional<String> document;

    private final Optional<String> delete;

    private AlgoliaRuleActionDto(
            String appId, String apiKey, String indexName, Optional<String> document, Optional<String> delete) {
        this.appId = appId;
        this.apiKey = apiKey;
        this.indexName = indexName;
        this.document = document;
        this.delete = delete;
    }

    /**
     * @return The application ID. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("appId")
    public String getAppId() {
        return appId;
    }

    /**
     * @return The API key to grant access to Squidex. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("apiKey")
    public String getApiKey() {
        return apiKey;
    }

    /**
     * @return The name of the index. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("indexName")
    public String getIndexName() {
        return indexName;
    }

    /**
     * @return The optional custom document.
     */
    @JsonProperty("document")
    public Optional<String> getDocument() {
        return document;
    }

    /**
     * @return The condition when to delete the entry.
     */
    @JsonProperty("delete")
    public Optional<String> getDelete() {
        return delete;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AlgoliaRuleActionDto && equalTo((AlgoliaRuleActionDto) other);
    }

    private boolean equalTo(AlgoliaRuleActionDto other) {
        return appId.equals(other.appId)
                && apiKey.equals(other.apiKey)
                && indexName.equals(other.indexName)
                && document.equals(other.document)
                && delete.equals(other.delete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.appId, this.apiKey, this.indexName, this.document, this.delete);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static AppIdStage builder() {
        return new Builder();
    }

    public interface AppIdStage {
        ApiKeyStage appId(String appId);

        Builder from(AlgoliaRuleActionDto other);
    }

    public interface ApiKeyStage {
        IndexNameStage apiKey(String apiKey);
    }

    public interface IndexNameStage {
        _FinalStage indexName(String indexName);
    }

    public interface _FinalStage {
        AlgoliaRuleActionDto build();

        _FinalStage document(Optional<String> document);

        _FinalStage document(String document);

        _FinalStage delete(Optional<String> delete);

        _FinalStage delete(String delete);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements AppIdStage, ApiKeyStage, IndexNameStage, _FinalStage {
        private String appId;

        private String apiKey;

        private String indexName;

        private Optional<String> delete = Optional.empty();

        private Optional<String> document = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(AlgoliaRuleActionDto other) {
            appId(other.getAppId());
            apiKey(other.getApiKey());
            indexName(other.getIndexName());
            document(other.getDocument());
            delete(other.getDelete());
            return this;
        }

        /**
         * <p>The application ID. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("appId")
        public ApiKeyStage appId(String appId) {
            this.appId = appId;
            return this;
        }

        /**
         * <p>The API key to grant access to Squidex. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("apiKey")
        public IndexNameStage apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        /**
         * <p>The name of the index. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("indexName")
        public _FinalStage indexName(String indexName) {
            this.indexName = indexName;
            return this;
        }

        /**
         * <p>The condition when to delete the entry.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage delete(String delete) {
            this.delete = Optional.of(delete);
            return this;
        }

        @Override
        @JsonSetter(value = "delete", nulls = Nulls.SKIP)
        public _FinalStage delete(Optional<String> delete) {
            this.delete = delete;
            return this;
        }

        /**
         * <p>The optional custom document.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage document(String document) {
            this.document = Optional.of(document);
            return this;
        }

        @Override
        @JsonSetter(value = "document", nulls = Nulls.SKIP)
        public _FinalStage document(Optional<String> document) {
            this.document = document;
            return this;
        }

        @Override
        public AlgoliaRuleActionDto build() {
            return new AlgoliaRuleActionDto(appId, apiKey, indexName, document, delete);
        }
    }
}
