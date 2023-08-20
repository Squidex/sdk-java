package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ClientDto.Builder.class)
public final class ClientDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final String id;

    private final String secret;

    private final String name;

    private final Optional<String> role;

    private final int apiCallsLimit;

    private final int apiTrafficLimit;

    private final boolean allowAnonymous;

    private ClientDto(
            Map<String, ResourceLink> links,
            String id,
            String secret,
            String name,
            Optional<String> role,
            int apiCallsLimit,
            int apiTrafficLimit,
            boolean allowAnonymous) {
        this.links = links;
        this.id = id;
        this.secret = secret;
        this.name = name;
        this.role = role;
        this.apiCallsLimit = apiCallsLimit;
        this.apiTrafficLimit = apiTrafficLimit;
        this.allowAnonymous = allowAnonymous;
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
     * @return The client id.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The client secret.
     */
    @JsonProperty("secret")
    public String getSecret() {
        return secret;
    }

    /**
     * @return The client name.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @return The role of the client.
     */
    @JsonProperty("role")
    public Optional<String> getRole() {
        return role;
    }

    /**
     * @return The number of allowed api calls per month for this client.
     */
    @JsonProperty("apiCallsLimit")
    public int getApiCallsLimit() {
        return apiCallsLimit;
    }

    /**
     * @return The number of allowed api traffic bytes per month for this client.
     */
    @JsonProperty("apiTrafficLimit")
    public int getApiTrafficLimit() {
        return apiTrafficLimit;
    }

    /**
     * @return True to allow anonymous access without an access token for this client.
     */
    @JsonProperty("allowAnonymous")
    public boolean getAllowAnonymous() {
        return allowAnonymous;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ClientDto && equalTo((ClientDto) other);
    }

    private boolean equalTo(ClientDto other) {
        return links.equals(other.links)
                && id.equals(other.id)
                && secret.equals(other.secret)
                && name.equals(other.name)
                && role.equals(other.role)
                && apiCallsLimit == other.apiCallsLimit
                && apiTrafficLimit == other.apiTrafficLimit
                && allowAnonymous == other.allowAnonymous;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.links,
                this.id,
                this.secret,
                this.name,
                this.role,
                this.apiCallsLimit,
                this.apiTrafficLimit,
                this.allowAnonymous);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        SecretStage id(String id);

        Builder from(ClientDto other);
    }

    public interface SecretStage {
        NameStage secret(String secret);
    }

    public interface NameStage {
        ApiCallsLimitStage name(String name);
    }

    public interface ApiCallsLimitStage {
        ApiTrafficLimitStage apiCallsLimit(int apiCallsLimit);
    }

    public interface ApiTrafficLimitStage {
        AllowAnonymousStage apiTrafficLimit(int apiTrafficLimit);
    }

    public interface AllowAnonymousStage {
        _FinalStage allowAnonymous(boolean allowAnonymous);
    }

    public interface _FinalStage {
        ClientDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);

        _FinalStage role(Optional<String> role);

        _FinalStage role(String role);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements IdStage,
                    SecretStage,
                    NameStage,
                    ApiCallsLimitStage,
                    ApiTrafficLimitStage,
                    AllowAnonymousStage,
                    _FinalStage {
        private String id;

        private String secret;

        private String name;

        private int apiCallsLimit;

        private int apiTrafficLimit;

        private boolean allowAnonymous;

        private Optional<String> role = Optional.empty();

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(ClientDto other) {
            links(other.getLinks());
            id(other.getId());
            secret(other.getSecret());
            name(other.getName());
            role(other.getRole());
            apiCallsLimit(other.getApiCallsLimit());
            apiTrafficLimit(other.getApiTrafficLimit());
            allowAnonymous(other.getAllowAnonymous());
            return this;
        }

        /**
         * <p>The client id.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("id")
        public SecretStage id(String id) {
            this.id = id;
            return this;
        }

        /**
         * <p>The client secret.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("secret")
        public NameStage secret(String secret) {
            this.secret = secret;
            return this;
        }

        /**
         * <p>The client name.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name")
        public ApiCallsLimitStage name(String name) {
            this.name = name;
            return this;
        }

        /**
         * <p>The number of allowed api calls per month for this client.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("apiCallsLimit")
        public ApiTrafficLimitStage apiCallsLimit(int apiCallsLimit) {
            this.apiCallsLimit = apiCallsLimit;
            return this;
        }

        /**
         * <p>The number of allowed api traffic bytes per month for this client.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("apiTrafficLimit")
        public AllowAnonymousStage apiTrafficLimit(int apiTrafficLimit) {
            this.apiTrafficLimit = apiTrafficLimit;
            return this;
        }

        /**
         * <p>True to allow anonymous access without an access token for this client.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("allowAnonymous")
        public _FinalStage allowAnonymous(boolean allowAnonymous) {
            this.allowAnonymous = allowAnonymous;
            return this;
        }

        /**
         * <p>The role of the client.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage role(String role) {
            this.role = Optional.of(role);
            return this;
        }

        @Override
        @JsonSetter(value = "role", nulls = Nulls.SKIP)
        public _FinalStage role(Optional<String> role) {
            this.role = role;
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
        public ClientDto build() {
            return new ClientDto(links, id, secret, name, role, apiCallsLimit, apiTrafficLimit, allowAnonymous);
        }
    }
}
