package com.squidex.api;

import com.squidex.api.resources.assets.requests.AssetsGetAssetContentRequest;
import com.squidex.api.resources.assets.requests.AssetsPostAssetRequest;
import com.squidex.api.types.AssetDto;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssetsTests extends TestBase {
    private static final SquidexClient client = Utils.getClient().client();

    @Test
    public void Should_upload_and_fetch_asset() {
        File file = new File("src/test/resources/logo-wide.png");

        AssetDto createdAsset = client.assets().postAsset(file, AssetsPostAssetRequest.builder().build());

        AssetDto asset = client.assets().getAsset(createdAsset.getId());
        assertEquals(createdAsset.getId(), asset.getId());
        assertEquals(file.length(), asset.getFileSize());
        assertEquals(file.getName(), asset.getFileName());
        assertEquals("image/png", asset.getMimeType());
    }

    @Test
    public void Should_upload_and_download_asset() throws IOException {
        File file = new File("src/test/resources/logo-wide.png");

        AssetDto createdAsset = client.assets().postAsset(file, AssetsPostAssetRequest.builder().build());

        InputStream asset = client.assets().getAssetContent(createdAsset.getId(), AssetsGetAssetContentRequest.builder().build());

        // Store the asset in the temp folder.
        Path tempFilePath = Files.createTempFile("temp-", ".tmp");

        try (OutputStream outputStream = Files.newOutputStream(tempFilePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = asset.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }

        assertEquals(tempFilePath.toFile().length(), createdAsset.getFileSize());
    }
}
