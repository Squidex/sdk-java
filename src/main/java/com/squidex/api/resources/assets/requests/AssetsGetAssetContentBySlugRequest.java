package com.squidex.api.resources.assets.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squidex.api.core.ObjectMappers;
import com.squidex.api.types.ImageFormat;
import com.squidex.api.types.ResizeMode;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AssetsGetAssetContentBySlugRequest.Builder.class)
public final class AssetsGetAssetContentBySlugRequest {
    private final Optional<Integer> version;

    private final Optional<Integer> cache;

    private final Optional<Integer> download;

    private final Optional<Integer> width;

    private final Optional<Integer> height;

    private final Optional<Integer> quality;

    private final Optional<ResizeMode> mode;

    private final Optional<String> bg;

    private final Optional<Double> focusX;

    private final Optional<Double> focusY;

    private final Optional<Boolean> nofocus;

    private final Optional<Boolean> auto;

    private final Optional<Boolean> force;

    private final Optional<Boolean> deleted;

    private final Optional<ImageFormat> format;

    private AssetsGetAssetContentBySlugRequest(
            Optional<Integer> version,
            Optional<Integer> cache,
            Optional<Integer> download,
            Optional<Integer> width,
            Optional<Integer> height,
            Optional<Integer> quality,
            Optional<ResizeMode> mode,
            Optional<String> bg,
            Optional<Double> focusX,
            Optional<Double> focusY,
            Optional<Boolean> nofocus,
            Optional<Boolean> auto,
            Optional<Boolean> force,
            Optional<Boolean> deleted,
            Optional<ImageFormat> format) {
        this.version = version;
        this.cache = cache;
        this.download = download;
        this.width = width;
        this.height = height;
        this.quality = quality;
        this.mode = mode;
        this.bg = bg;
        this.focusX = focusX;
        this.focusY = focusY;
        this.nofocus = nofocus;
        this.auto = auto;
        this.force = force;
        this.deleted = deleted;
        this.format = format;
    }

    /**
     * @return The optional version of the asset.
     */
    @JsonProperty("version")
    public Optional<Integer> getVersion() {
        return version;
    }

    /**
     * @return The cache duration in seconds.
     */
    @JsonProperty("cache")
    public Optional<Integer> getCache() {
        return cache;
    }

    /**
     * @return Set it to 0 to prevent download.
     */
    @JsonProperty("download")
    public Optional<Integer> getDownload() {
        return download;
    }

    /**
     * @return The target width of the asset, if it is an image.
     */
    @JsonProperty("width")
    public Optional<Integer> getWidth() {
        return width;
    }

    /**
     * @return The target height of the asset, if it is an image.
     */
    @JsonProperty("height")
    public Optional<Integer> getHeight() {
        return height;
    }

    /**
     * @return Optional image quality, it is is an jpeg image.
     */
    @JsonProperty("quality")
    public Optional<Integer> getQuality() {
        return quality;
    }

    /**
     * @return The resize mode when the width and height is defined.
     */
    @JsonProperty("mode")
    public Optional<ResizeMode> getMode() {
        return mode;
    }

    /**
     * @return Optional background color.
     */
    @JsonProperty("bg")
    public Optional<String> getBg() {
        return bg;
    }

    /**
     * @return Override the y focus point.
     */
    @JsonProperty("focusX")
    public Optional<Double> getFocusX() {
        return focusX;
    }

    /**
     * @return Override the x focus point.
     */
    @JsonProperty("focusY")
    public Optional<Double> getFocusY() {
        return focusY;
    }

    /**
     * @return True to ignore the asset focus point if any.
     */
    @JsonProperty("nofocus")
    public Optional<Boolean> getNofocus() {
        return nofocus;
    }

    /**
     * @return True to use auto format.
     */
    @JsonProperty("auto")
    public Optional<Boolean> getAuto() {
        return auto;
    }

    /**
     * @return True to force a new resize even if it already stored.
     */
    @JsonProperty("force")
    public Optional<Boolean> getForce() {
        return force;
    }

    /**
     * @return Also return deleted content items.
     */
    @JsonProperty("deleted")
    public Optional<Boolean> getDeleted() {
        return deleted;
    }

    /**
     * @return True to force a new resize even if it already stored.
     */
    @JsonProperty("format")
    public Optional<ImageFormat> getFormat() {
        return format;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AssetsGetAssetContentBySlugRequest
                && equalTo((AssetsGetAssetContentBySlugRequest) other);
    }

    private boolean equalTo(AssetsGetAssetContentBySlugRequest other) {
        return version.equals(other.version)
                && cache.equals(other.cache)
                && download.equals(other.download)
                && width.equals(other.width)
                && height.equals(other.height)
                && quality.equals(other.quality)
                && mode.equals(other.mode)
                && bg.equals(other.bg)
                && focusX.equals(other.focusX)
                && focusY.equals(other.focusY)
                && nofocus.equals(other.nofocus)
                && auto.equals(other.auto)
                && force.equals(other.force)
                && deleted.equals(other.deleted)
                && format.equals(other.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.version,
                this.cache,
                this.download,
                this.width,
                this.height,
                this.quality,
                this.mode,
                this.bg,
                this.focusX,
                this.focusY,
                this.nofocus,
                this.auto,
                this.force,
                this.deleted,
                this.format);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Integer> version = Optional.empty();

        private Optional<Integer> cache = Optional.empty();

        private Optional<Integer> download = Optional.empty();

        private Optional<Integer> width = Optional.empty();

        private Optional<Integer> height = Optional.empty();

        private Optional<Integer> quality = Optional.empty();

        private Optional<ResizeMode> mode = Optional.empty();

        private Optional<String> bg = Optional.empty();

        private Optional<Double> focusX = Optional.empty();

        private Optional<Double> focusY = Optional.empty();

        private Optional<Boolean> nofocus = Optional.empty();

        private Optional<Boolean> auto = Optional.empty();

        private Optional<Boolean> force = Optional.empty();

        private Optional<Boolean> deleted = Optional.empty();

        private Optional<ImageFormat> format = Optional.empty();

        private Builder() {}

        public Builder from(AssetsGetAssetContentBySlugRequest other) {
            version(other.getVersion());
            cache(other.getCache());
            download(other.getDownload());
            width(other.getWidth());
            height(other.getHeight());
            quality(other.getQuality());
            mode(other.getMode());
            bg(other.getBg());
            focusX(other.getFocusX());
            focusY(other.getFocusY());
            nofocus(other.getNofocus());
            auto(other.getAuto());
            force(other.getForce());
            deleted(other.getDeleted());
            format(other.getFormat());
            return this;
        }

        @JsonSetter(value = "version", nulls = Nulls.SKIP)
        public Builder version(Optional<Integer> version) {
            this.version = version;
            return this;
        }

        public Builder version(Integer version) {
            this.version = Optional.of(version);
            return this;
        }

        @JsonSetter(value = "cache", nulls = Nulls.SKIP)
        public Builder cache(Optional<Integer> cache) {
            this.cache = cache;
            return this;
        }

        public Builder cache(Integer cache) {
            this.cache = Optional.of(cache);
            return this;
        }

        @JsonSetter(value = "download", nulls = Nulls.SKIP)
        public Builder download(Optional<Integer> download) {
            this.download = download;
            return this;
        }

        public Builder download(Integer download) {
            this.download = Optional.of(download);
            return this;
        }

        @JsonSetter(value = "width", nulls = Nulls.SKIP)
        public Builder width(Optional<Integer> width) {
            this.width = width;
            return this;
        }

        public Builder width(Integer width) {
            this.width = Optional.of(width);
            return this;
        }

        @JsonSetter(value = "height", nulls = Nulls.SKIP)
        public Builder height(Optional<Integer> height) {
            this.height = height;
            return this;
        }

        public Builder height(Integer height) {
            this.height = Optional.of(height);
            return this;
        }

        @JsonSetter(value = "quality", nulls = Nulls.SKIP)
        public Builder quality(Optional<Integer> quality) {
            this.quality = quality;
            return this;
        }

        public Builder quality(Integer quality) {
            this.quality = Optional.of(quality);
            return this;
        }

        @JsonSetter(value = "mode", nulls = Nulls.SKIP)
        public Builder mode(Optional<ResizeMode> mode) {
            this.mode = mode;
            return this;
        }

        public Builder mode(ResizeMode mode) {
            this.mode = Optional.of(mode);
            return this;
        }

        @JsonSetter(value = "bg", nulls = Nulls.SKIP)
        public Builder bg(Optional<String> bg) {
            this.bg = bg;
            return this;
        }

        public Builder bg(String bg) {
            this.bg = Optional.of(bg);
            return this;
        }

        @JsonSetter(value = "focusX", nulls = Nulls.SKIP)
        public Builder focusX(Optional<Double> focusX) {
            this.focusX = focusX;
            return this;
        }

        public Builder focusX(Double focusX) {
            this.focusX = Optional.of(focusX);
            return this;
        }

        @JsonSetter(value = "focusY", nulls = Nulls.SKIP)
        public Builder focusY(Optional<Double> focusY) {
            this.focusY = focusY;
            return this;
        }

        public Builder focusY(Double focusY) {
            this.focusY = Optional.of(focusY);
            return this;
        }

        @JsonSetter(value = "nofocus", nulls = Nulls.SKIP)
        public Builder nofocus(Optional<Boolean> nofocus) {
            this.nofocus = nofocus;
            return this;
        }

        public Builder nofocus(Boolean nofocus) {
            this.nofocus = Optional.of(nofocus);
            return this;
        }

        @JsonSetter(value = "auto", nulls = Nulls.SKIP)
        public Builder auto(Optional<Boolean> auto) {
            this.auto = auto;
            return this;
        }

        public Builder auto(Boolean auto) {
            this.auto = Optional.of(auto);
            return this;
        }

        @JsonSetter(value = "force", nulls = Nulls.SKIP)
        public Builder force(Optional<Boolean> force) {
            this.force = force;
            return this;
        }

        public Builder force(Boolean force) {
            this.force = Optional.of(force);
            return this;
        }

        @JsonSetter(value = "deleted", nulls = Nulls.SKIP)
        public Builder deleted(Optional<Boolean> deleted) {
            this.deleted = deleted;
            return this;
        }

        public Builder deleted(Boolean deleted) {
            this.deleted = Optional.of(deleted);
            return this;
        }

        @JsonSetter(value = "format", nulls = Nulls.SKIP)
        public Builder format(Optional<ImageFormat> format) {
            this.format = format;
            return this;
        }

        public Builder format(ImageFormat format) {
            this.format = Optional.of(format);
            return this;
        }

        public AssetsGetAssetContentBySlugRequest build() {
            return new AssetsGetAssetContentBySlugRequest(
                    version, cache, download, width, height, quality, mode, bg, focusX, focusY, nofocus, auto, force,
                    deleted, format);
        }
    }
}
