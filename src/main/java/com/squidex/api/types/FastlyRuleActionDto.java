package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = FastlyRuleActionDto.Builder.class)
public final class FastlyRuleActionDto {
    private final String apiKey;

    private final String serviceId;

    private FastlyRuleActionDto(String apiKey, String serviceId) {
        this.apiKey = apiKey;
        this.serviceId = serviceId;
    }

    /**
     * @return The API key to grant access to Squidex. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("apiKey")
    public String getApiKey() {
        return apiKey;
    }

    /**
     * @return The ID of the fastly service. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("serviceId")
    public String getServiceId() {
        return serviceId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof FastlyRuleActionDto && equalTo((FastlyRuleActionDto) other);
    }

    private boolean equalTo(FastlyRuleActionDto other) {
        return apiKey.equals(other.apiKey) && serviceId.equals(other.serviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.apiKey, this.serviceId);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ApiKeyStage builder() {
        return new Builder();
    }

    public interface ApiKeyStage {
        ServiceIdStage apiKey(String apiKey);

        Builder from(FastlyRuleActionDto other);
    }

    public interface ServiceIdStage {
        _FinalStage serviceId(String serviceId);
    }

    public interface _FinalStage {
        FastlyRuleActionDto build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ApiKeyStage, ServiceIdStage, _FinalStage {
        private String apiKey;

        private String serviceId;

        private Builder() {}

        @Override
        public Builder from(FastlyRuleActionDto other) {
            apiKey(other.getApiKey());
            serviceId(other.getServiceId());
            return this;
        }

        /**
         * <p>The API key to grant access to Squidex. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("apiKey")
        public ServiceIdStage apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        /**
         * <p>The ID of the fastly service. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("serviceId")
        public _FinalStage serviceId(String serviceId) {
            this.serviceId = serviceId;
            return this;
        }

        @Override
        public FastlyRuleActionDto build() {
            return new FastlyRuleActionDto(apiKey, serviceId);
        }
    }
}
