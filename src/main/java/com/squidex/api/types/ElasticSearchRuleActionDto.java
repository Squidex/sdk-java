package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ElasticSearchRuleActionDto.Builder.class)
public final class ElasticSearchRuleActionDto {
    private final String host;

    private final String indexName;

    private final Optional<String> username;

    private final Optional<String> password;

    private final Optional<String> document;

    private final Optional<String> delete;

    private ElasticSearchRuleActionDto(
            String host,
            String indexName,
            Optional<String> username,
            Optional<String> password,
            Optional<String> document,
            Optional<String> delete) {
        this.host = host;
        this.indexName = indexName;
        this.username = username;
        this.password = password;
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
     * @return The optional username.
     */
    @JsonProperty("username")
    public Optional<String> getUsername() {
        return username;
    }

    /**
     * @return The optional password.
     */
    @JsonProperty("password")
    public Optional<String> getPassword() {
        return password;
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
        return other instanceof ElasticSearchRuleActionDto && equalTo((ElasticSearchRuleActionDto) other);
    }

    private boolean equalTo(ElasticSearchRuleActionDto other) {
        return host.equals(other.host)
                && indexName.equals(other.indexName)
                && username.equals(other.username)
                && password.equals(other.password)
                && document.equals(other.document)
                && delete.equals(other.delete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.host, this.indexName, this.username, this.password, this.document, this.delete);
    }

    @Override
    public String toString() {
        return "ElasticSearchRuleActionDto{" + "host: " + host + ", indexName: " + indexName + ", username: " + username
                + ", password: " + password + ", document: " + document + ", delete: " + delete + "}";
    }

    public static HostStage builder() {
        return new Builder();
    }

    public interface HostStage {
        IndexNameStage host(String host);

        Builder from(ElasticSearchRuleActionDto other);
    }

    public interface IndexNameStage {
        _FinalStage indexName(String indexName);
    }

    public interface _FinalStage {
        ElasticSearchRuleActionDto build();

        _FinalStage username(Optional<String> username);

        _FinalStage username(String username);

        _FinalStage password(Optional<String> password);

        _FinalStage password(String password);

        _FinalStage document(Optional<String> document);

        _FinalStage document(String document);

        _FinalStage delete(Optional<String> delete);

        _FinalStage delete(String delete);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements HostStage, IndexNameStage, _FinalStage {
        private String host;

        private String indexName;

        private Optional<String> delete = Optional.empty();

        private Optional<String> document = Optional.empty();

        private Optional<String> password = Optional.empty();

        private Optional<String> username = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(ElasticSearchRuleActionDto other) {
            host(other.getHost());
            indexName(other.getIndexName());
            username(other.getUsername());
            password(other.getPassword());
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
        public _FinalStage indexName(String indexName) {
            this.indexName = indexName;
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

        /**
         * <p>The optional password.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage password(String password) {
            this.password = Optional.of(password);
            return this;
        }

        @Override
        @JsonSetter(value = "password", nulls = Nulls.SKIP)
        public _FinalStage password(Optional<String> password) {
            this.password = password;
            return this;
        }

        /**
         * <p>The optional username.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage username(String username) {
            this.username = Optional.of(username);
            return this;
        }

        @Override
        @JsonSetter(value = "username", nulls = Nulls.SKIP)
        public _FinalStage username(Optional<String> username) {
            this.username = username;
            return this;
        }

        @Override
        public ElasticSearchRuleActionDto build() {
            return new ElasticSearchRuleActionDto(host, indexName, username, password, document, delete);
        }
    }
}
