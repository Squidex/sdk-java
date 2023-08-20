package com.squidex.api.resources.assets.requests;

public final class AssetsPutAssetContentRequest {
    private AssetsPutAssetContentRequest() {}

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AssetsPutAssetContentRequest;
    }

    @Override
    public String toString() {
        return "AssetsPutAssetContentRequest{" + "}";
    }
}
