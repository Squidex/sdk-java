package com.squidex.api.resources.backups.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = BackupsGetBackupContentV2Request.Builder.class)
public final class BackupsGetBackupContentV2Request {
    private final Optional<String> appId;

    private final Optional<String> app;

    private BackupsGetBackupContentV2Request(Optional<String> appId, Optional<String> app) {
        this.appId = appId;
        this.app = app;
    }

    /**
     * @return The ID of the app.
     */
    @JsonProperty("appId")
    public Optional<String> getAppId() {
        return appId;
    }

    /**
     * @return The name of the app.
     */
    @JsonProperty("app")
    public Optional<String> getApp() {
        return app;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BackupsGetBackupContentV2Request && equalTo((BackupsGetBackupContentV2Request) other);
    }

    private boolean equalTo(BackupsGetBackupContentV2Request other) {
        return appId.equals(other.appId) && app.equals(other.app);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.appId, this.app);
    }

    @Override
    public String toString() {
        return "BackupsGetBackupContentV2Request{" + "appId: " + appId + ", app: " + app + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> appId = Optional.empty();

        private Optional<String> app = Optional.empty();

        private Builder() {}

        public Builder from(BackupsGetBackupContentV2Request other) {
            appId(other.getAppId());
            app(other.getApp());
            return this;
        }

        @JsonSetter(value = "appId", nulls = Nulls.SKIP)
        public Builder appId(Optional<String> appId) {
            this.appId = appId;
            return this;
        }

        public Builder appId(String appId) {
            this.appId = Optional.of(appId);
            return this;
        }

        @JsonSetter(value = "app", nulls = Nulls.SKIP)
        public Builder app(Optional<String> app) {
            this.app = app;
            return this;
        }

        public Builder app(String app) {
            this.app = Optional.of(app);
            return this;
        }

        public BackupsGetBackupContentV2Request build() {
            return new BackupsGetBackupContentV2Request(appId, app);
        }
    }
}
