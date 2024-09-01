package com.squidex.api;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.squidex.api.types.AssetDto;

public class AssetsTests extends TestBase {
    private static final SquidexClient client = Utils.getClient().client();

    @Test
    public void Should_upload_and_fetch_asset() {
        // STEP 1: Upload asset.
        File file = new File("src/test/resources/logo-wide.png");

        AssetDto createdAsset = client.assets().postAsset().file(file).execute();

        // STEP 2: Query asset.
        AssetDto asset = client.assets().getAsset(createdAsset.getId()).execute();


        assertEquals(createdAsset.getId(), asset.getId());
        assertEquals(file.length(), asset.getFileSize());
        assertEquals(file.getName(), asset.getFileName());
        assertEquals("image/png", asset.getMimeType());
    }

    @Test
    public void Should_upload_and_download_asset() {
        // STEP 1: Upload asset.
        File file = new File("src/test/resources/logo-wide.png");

        AssetDto createdAsset = client.assets().postAsset().file(file).execute();

        // STEP 2: Download asset
        File assetQueried = client.assets().getAssetContentBySlug(createdAsset.getId()).execute();

        assertEquals(assetQueried.length(), createdAsset.getFileSize());
    }
}
