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
@JsonDeserialize(builder = TypesenseRuleActionDto.Builder.class)
public final class TypesenseRuleActionDto {
    private final String host;

    private final String indexName;

    private final String apiKey;

    private final Optional<String> document;

    private final Optional<String> delete;

    private TypesenseRuleActionDto(
            String host, String indexName, String apiKey, Optional<String> document, Optional<String> delete) {
        this.host = host;
        this.indexName = indexName;
        this.apiKey = apiKey;
        this.document = document;
        this.delete = delete;
    }

    /**
     * @return The url to the instance or cluster. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("host")
    public String getHost() {
        return host;
    }

    /**
     * @return The name of the index. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("indexName")
    public String getIndexName() {
        return indexName;
    }

    /**
     * @return The api key. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("apiKey")
    public String getApiKey() {
        return apiKey;
    }

    /**
     * @return The optional custom document.
     */
    @JsonProperty("document")
    public Optional<String> getDocument() {
        return document;
    }

    /**
     * @return The condition when to delete the document.
     */
    @JsonProperty("delete")
    public Optional<String> getDelete() {
        return delete;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TypesenseRuleActionDto && equalTo((TypesenseRuleActionDto) other);
    }

    private boolean equalTo(TypesenseRuleActionDto other) {
        return host.equals(other.host)
                && indexName.equals(other.indexName)
                && apiKey.equals(other.apiKey)
                && document.equals(other.document)
                && delete.equals(other.delete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.host, this.indexName, this.apiKey, this.document, this.delete);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static HostStage builder() {
        return new Builder();
    }

    public interface HostStage {
        IndexNameStage host(String host);

        Builder from(TypesenseRuleActionDto other);
    }

    public interface IndexNameStage {
        ApiKeyStage indexName(String indexName);
    }

    public interface ApiKeyStage {
        _FinalStage apiKey(String apiKey);
    }

    public interface _FinalStage {
        TypesenseRuleActionDto build();

        _FinalStage document(Optional<String> document);

        _FinalStage document(String document);

        _FinalStage delete(Optional<String> delete);

        _FinalStage delete(String delete);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements HostStage, IndexNameStage, ApiKeyStage, _FinalStage {
        private String host;

        private String indexName;

        private String apiKey;

        private Optional<String> delete = Optional.empty();

        private Optional<String> document = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(TypesenseRuleActionDto other) {
            host(other.getHost());
            indexName(other.getIndexName());
            apiKey(other.getApiKey());
            document(other.getDocument());
            delete(other.getDelete());
            return this;
        }

        /**
         * <p>The url to the instance or cluster. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("host")
        public IndexNameStage host(String host) {
            this.host = host;
            return this;
        }

        /**
         * <p>The name of the index. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("indexName")
        public ApiKeyStage indexName(String indexName) {
            this.indexName = indexName;
            return this;
        }

        /**
         * <p>The api key. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("apiKey")
        public _FinalStage apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        /**
         * <p>The condition when to delete the document.</p>
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
        public TypesenseRuleActionDto build() {
            return new TypesenseRuleActionDto(host, indexName, apiKey, document, delete);
        }
    }
}
