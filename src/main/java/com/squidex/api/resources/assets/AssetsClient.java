package com.squidex.api.resources.assets;

import com.fasterxml.jackson.core.type.TypeReference;
import com.squidex.api.core.ApiError;
import com.squidex.api.core.ClientOptions;
import com.squidex.api.core.ObjectMappers;
import com.squidex.api.core.RequestOptions;
import com.squidex.api.resources.assets.requests.AnnotateAssetDto;
import com.squidex.api.resources.assets.requests.AssetsDeleteAssetRequest;
import com.squidex.api.resources.assets.requests.AssetsGetAssetContentBySlugRequest;
import com.squidex.api.resources.assets.requests.AssetsGetAssetContentRequest;
import com.squidex.api.resources.assets.requests.AssetsGetAssetFoldersRequest;
import com.squidex.api.resources.assets.requests.AssetsGetAssetsPostRequest;
import com.squidex.api.resources.assets.requests.AssetsGetAssetsRequest;
import com.squidex.api.resources.assets.requests.AssetsPostAssetRequest;
import com.squidex.api.resources.assets.requests.AssetsPostUpsertAssetRequest;
import com.squidex.api.resources.assets.requests.AssetsPutAssetContentRequest;
import com.squidex.api.resources.assets.requests.BulkUpdateAssetsDto;
import com.squidex.api.resources.assets.requests.CreateAssetFolderDto;
import com.squidex.api.resources.assets.requests.MoveAssetDto;
import com.squidex.api.resources.assets.requests.MoveAssetFolderDto;
import com.squidex.api.resources.assets.requests.RenameAssetFolderDto;
import com.squidex.api.resources.assets.requests.RenameTagDto;
import com.squidex.api.types.AssetDto;
import com.squidex.api.types.AssetFolderDto;
import com.squidex.api.types.AssetFoldersDto;
import com.squidex.api.types.AssetsDto;
import com.squidex.api.types.BulkResultDto;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AssetsClient {
    protected final ClientOptions clientOptions;

    public AssetsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public InputStream getAssetContentBySlug(String idOrSlug, String more, AssetsGetAssetContentBySlugRequest request) {
        return getAssetContentBySlug(idOrSlug, more, request, null);
    }

    public InputStream getAssetContentBySlug(
            String idOrSlug, String more, AssetsGetAssetContentBySlugRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/assets")
                .addPathSegment(clientOptions.appName())
                .addPathSegment(idOrSlug)
                .addPathSegment(more);
        if (request.getVersion().isPresent()) {
            _httpUrl.addQueryParameter("version", request.getVersion().get().toString());
        }
        if (request.getCache().isPresent()) {
            _httpUrl.addQueryParameter("cache", request.getCache().get().toString());
        }
        if (request.getDownload().isPresent()) {
            _httpUrl.addQueryParameter("download", request.getDownload().get().toString());
        }
        if (request.getWidth().isPresent()) {
            _httpUrl.addQueryParameter("width", request.getWidth().get().toString());
        }
        if (request.getHeight().isPresent()) {
            _httpUrl.addQueryParameter("height", request.getHeight().get().toString());
        }
        if (request.getQuality().isPresent()) {
            _httpUrl.addQueryParameter("quality", request.getQuality().get().toString());
        }
        if (request.getMode().isPresent()) {
            _httpUrl.addQueryParameter("mode", request.getMode().get().toString());
        }
        if (request.getBg().isPresent()) {
            _httpUrl.addQueryParameter("bg", request.getBg().get());
        }
        if (request.getFocusX().isPresent()) {
            _httpUrl.addQueryParameter("focusX", request.getFocusX().get().toString());
        }
        if (request.getFocusY().isPresent()) {
            _httpUrl.addQueryParameter("focusY", request.getFocusY().get().toString());
        }
        if (request.getNofocus().isPresent()) {
            _httpUrl.addQueryParameter("nofocus", request.getNofocus().get().toString());
        }
        if (request.getAuto().isPresent()) {
            _httpUrl.addQueryParameter("auto", request.getAuto().get().toString());
        }
        if (request.getForce().isPresent()) {
            _httpUrl.addQueryParameter("force", request.getForce().get().toString());
        }
        if (request.getDeleted().isPresent()) {
            _httpUrl.addQueryParameter("deleted", request.getDeleted().get().toString());
        }
        if (request.getFormat().isPresent()) {
            _httpUrl.addQueryParameter("format", request.getFormat().get().toString());
        }
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("GET", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return _response.body().byteStream();
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public InputStream getAssetContentBySlug(String idOrSlug, String more) {
        return getAssetContentBySlug(
                idOrSlug, more, AssetsGetAssetContentBySlugRequest.builder().build());
    }

    public InputStream getAssetContent(String id, AssetsGetAssetContentRequest request) {
        return getAssetContent(id, request, null);
    }

    public InputStream getAssetContent(String id, AssetsGetAssetContentRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/assets")
                .addPathSegment(id);
        if (request.getVersion().isPresent()) {
            _httpUrl.addQueryParameter("version", request.getVersion().get().toString());
        }
        if (request.getCache().isPresent()) {
            _httpUrl.addQueryParameter("cache", request.getCache().get().toString());
        }
        if (request.getDownload().isPresent()) {
            _httpUrl.addQueryParameter("download", request.getDownload().get().toString());
        }
        if (request.getWidth().isPresent()) {
            _httpUrl.addQueryParameter("width", request.getWidth().get().toString());
        }
        if (request.getHeight().isPresent()) {
            _httpUrl.addQueryParameter("height", request.getHeight().get().toString());
        }
        if (request.getQuality().isPresent()) {
            _httpUrl.addQueryParameter("quality", request.getQuality().get().toString());
        }
        if (request.getMode().isPresent()) {
            _httpUrl.addQueryParameter("mode", request.getMode().get().toString());
        }
        if (request.getBg().isPresent()) {
            _httpUrl.addQueryParameter("bg", request.getBg().get());
        }
        if (request.getFocusX().isPresent()) {
            _httpUrl.addQueryParameter("focusX", request.getFocusX().get().toString());
        }
        if (request.getFocusY().isPresent()) {
            _httpUrl.addQueryParameter("focusY", request.getFocusY().get().toString());
        }
        if (request.getNofocus().isPresent()) {
            _httpUrl.addQueryParameter("nofocus", request.getNofocus().get().toString());
        }
        if (request.getAuto().isPresent()) {
            _httpUrl.addQueryParameter("auto", request.getAuto().get().toString());
        }
        if (request.getForce().isPresent()) {
            _httpUrl.addQueryParameter("force", request.getForce().get().toString());
        }
        if (request.getDeleted().isPresent()) {
            _httpUrl.addQueryParameter("deleted", request.getDeleted().get().toString());
        }
        if (request.getFormat().isPresent()) {
            _httpUrl.addQueryParameter("format", request.getFormat().get().toString());
        }
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("GET", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return _response.body().byteStream();
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public InputStream getAssetContent(String id) {
        return getAssetContent(id, AssetsGetAssetContentRequest.builder().build());
    }

    public AssetFoldersDto getAssetFolders(AssetsGetAssetFoldersRequest request) {
        return getAssetFolders(request, null);
    }

    public AssetFoldersDto getAssetFolders(AssetsGetAssetFoldersRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("assets/folders");
        if (request.getParentId().isPresent()) {
            _httpUrl.addQueryParameter("parentId", request.getParentId().get());
        }
        if (request.getScope().isPresent()) {
            _httpUrl.addQueryParameter("scope", request.getScope().get().toString());
        }
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("GET", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), AssetFoldersDto.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AssetFoldersDto getAssetFolders() {
        return getAssetFolders(AssetsGetAssetFoldersRequest.builder().build());
    }

    public AssetFolderDto postAssetFolder(CreateAssetFolderDto request) {
        return postAssetFolder(request, null);
    }

    public AssetFolderDto postAssetFolder(CreateAssetFolderDto request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("assets/folders")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("folderName", request.getFolderName());
        if (request.getParentId().isPresent()) {
            _requestBodyProperties.put("parentId", request.getParentId());
        }
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), AssetFolderDto.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AssetFolderDto putAssetFolder(String id, RenameAssetFolderDto request) {
        return putAssetFolder(id, request, null);
    }

    public AssetFolderDto putAssetFolder(String id, RenameAssetFolderDto request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("assets/folders")
                .addPathSegment(id)
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("folderName", request.getFolderName());
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), AssetFolderDto.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAssetFolder(String id) {
        deleteAssetFolder(id, null);
    }

    public void deleteAssetFolder(String id, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("assets/folders")
                .addPathSegment(id)
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("DELETE", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return;
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AssetFolderDto putAssetFolderParent(String id, MoveAssetFolderDto request) {
        return putAssetFolderParent(id, request, null);
    }

    public AssetFolderDto putAssetFolderParent(String id, MoveAssetFolderDto request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("assets/folders")
                .addPathSegment(id)
                .addPathSegments("parent")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        if (request.getParentId().isPresent()) {
            _requestBodyProperties.put("parentId", request.getParentId());
        }
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), AssetFolderDto.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AssetFolderDto putAssetFolderParent(String id) {
        return putAssetFolderParent(id, MoveAssetFolderDto.builder().build());
    }

    public Map<String, Integer> getTags() {
        return getTags(null);
    }

    public Map<String, Integer> getTags(RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("assets/tags")
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        _response.body().string(), new TypeReference<Map<String, Integer>>() {});
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String, Integer> putTag(String name, RenameTagDto request) {
        return putTag(name, request, null);
    }

    public Map<String, Integer> putTag(String name, RenameTagDto request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("assets/tags")
                .addPathSegment(name)
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("tagName", request.getTagName());
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        _response.body().string(), new TypeReference<Map<String, Integer>>() {});
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AssetsDto getAssets(AssetsGetAssetsRequest request) {
        return getAssets(request, null);
    }

    public AssetsDto getAssets(AssetsGetAssetsRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("assets");
        if (request.getParentId().isPresent()) {
            _httpUrl.addQueryParameter("parentId", request.getParentId().get());
        }
        if (request.getIds().isPresent()) {
            _httpUrl.addQueryParameter("ids", request.getIds().get());
        }
        if (request.getQ().isPresent()) {
            _httpUrl.addQueryParameter("q", request.getQ().get());
        }
        if (request.getTop().isPresent()) {
            _httpUrl.addQueryParameter("$top", request.getTop().get().toString());
        }
        if (request.getSkip().isPresent()) {
            _httpUrl.addQueryParameter("$skip", request.getSkip().get().toString());
        }
        if (request.getOrderby().isPresent()) {
            _httpUrl.addQueryParameter("$orderby", request.getOrderby().get());
        }
        if (request.getFilter().isPresent()) {
            _httpUrl.addQueryParameter("$filter", request.getFilter().get());
        }
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("GET", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        if (request.getNoTotal().isPresent()) {
            _requestBuilder.addHeader("X-NoTotal", request.getNoTotal().get().toString());
        }
        if (request.getNoSlowTotal().isPresent()) {
            _requestBuilder.addHeader(
                    "X-NoSlowTotal", request.getNoSlowTotal().get().toString());
        }
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), AssetsDto.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AssetsDto getAssets() {
        return getAssets(AssetsGetAssetsRequest.builder().build());
    }

    public AssetDto postAsset(File file, AssetsPostAssetRequest request) {
        return postAsset(file, request, null);
    }

    public AssetDto postAsset(File file, AssetsPostAssetRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("assets");
        if (request.getParentId().isPresent()) {
            _httpUrl.addQueryParameter("parentId", request.getParentId().get());
        }
        if (request.getId().isPresent()) {
            _httpUrl.addQueryParameter("id", request.getId().get());
        }
        if (request.getDuplicate().isPresent()) {
            _httpUrl.addQueryParameter("duplicate", request.getDuplicate().get().toString());
        }
        MultipartBody.Builder _multipartBody = new MultipartBody.Builder().setType(MultipartBody.FORM);
        try {
            _multipartBody.addFormDataPart("file", null, RequestBody.create(null, file));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        RequestBody _requestBody = _multipartBody.build();
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)));
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), AssetDto.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AssetsDto getAssetsPost(AssetsGetAssetsPostRequest request) {
        return getAssetsPost(request, null);
    }

    public AssetsDto getAssetsPost(AssetsGetAssetsPostRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("assets/query")
                .build();
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request.getBody()),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        if (request.getNoTotal().isPresent()) {
            _requestBuilder.addHeader("X-NoTotal", request.getNoTotal().get().toString());
        }
        if (request.getNoSlowTotal().isPresent()) {
            _requestBuilder.addHeader(
                    "X-NoSlowTotal", request.getNoSlowTotal().get().toString());
        }
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), AssetsDto.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AssetsDto getAssetsPost() {
        return getAssetsPost(AssetsGetAssetsPostRequest.builder().build());
    }

    public AssetDto getAsset(String id) {
        return getAsset(id, null);
    }

    public AssetDto getAsset(String id, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("assets")
                .addPathSegment(id)
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), AssetDto.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AssetDto postUpsertAsset(String id, File file, AssetsPostUpsertAssetRequest request) {
        return postUpsertAsset(id, file, request, null);
    }

    public AssetDto postUpsertAsset(
            String id, File file, AssetsPostUpsertAssetRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("assets")
                .addPathSegment(id);
        if (request.getParentId().isPresent()) {
            _httpUrl.addQueryParameter("parentId", request.getParentId().get());
        }
        if (request.getDuplicate().isPresent()) {
            _httpUrl.addQueryParameter("duplicate", request.getDuplicate().get().toString());
        }
        MultipartBody.Builder _multipartBody = new MultipartBody.Builder().setType(MultipartBody.FORM);
        try {
            _multipartBody.addFormDataPart("file", null, RequestBody.create(null, file));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        RequestBody _requestBody = _multipartBody.build();
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)));
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), AssetDto.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AssetDto putAsset(String id, AnnotateAssetDto request) {
        return putAsset(id, request, null);
    }

    public AssetDto putAsset(String id, AnnotateAssetDto request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("assets")
                .addPathSegment(id)
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        if (request.getFileName().isPresent()) {
            _requestBodyProperties.put("fileName", request.getFileName());
        }
        if (request.getSlug().isPresent()) {
            _requestBodyProperties.put("slug", request.getSlug());
        }
        if (request.getIsProtected().isPresent()) {
            _requestBodyProperties.put("isProtected", request.getIsProtected());
        }
        if (request.getTags().isPresent()) {
            _requestBodyProperties.put("tags", request.getTags());
        }
        if (request.getMetadata().isPresent()) {
            _requestBodyProperties.put("metadata", request.getMetadata());
        }
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), AssetDto.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AssetDto putAsset(String id) {
        return putAsset(id, AnnotateAssetDto.builder().build());
    }

    public void deleteAsset(String id, AssetsDeleteAssetRequest request) {
        deleteAsset(id, request, null);
    }

    public void deleteAsset(String id, AssetsDeleteAssetRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("assets")
                .addPathSegment(id);
        if (request.getCheckReferrers().isPresent()) {
            _httpUrl.addQueryParameter(
                    "checkReferrers", request.getCheckReferrers().get().toString());
        }
        if (request.getPermanent().isPresent()) {
            _httpUrl.addQueryParameter("permanent", request.getPermanent().get().toString());
        }
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("DELETE", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)));
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return;
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAsset(String id) {
        deleteAsset(id, AssetsDeleteAssetRequest.builder().build());
    }

    public List<BulkResultDto> bulkUpdateAssets(BulkUpdateAssetsDto request) {
        return bulkUpdateAssets(request, null);
    }

    public List<BulkResultDto> bulkUpdateAssets(BulkUpdateAssetsDto request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("assets/bulk")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        if (request.getJobs().isPresent()) {
            _requestBodyProperties.put("jobs", request.getJobs());
        }
        if (request.getCheckReferrers().isPresent()) {
            _requestBodyProperties.put("checkReferrers", request.getCheckReferrers());
        }
        if (request.getOptimizeValidation().isPresent()) {
            _requestBodyProperties.put("optimizeValidation", request.getOptimizeValidation());
        }
        if (request.getDoNotScript().isPresent()) {
            _requestBodyProperties.put("doNotScript", request.getDoNotScript());
        }
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        _response.body().string(), new TypeReference<List<BulkResultDto>>() {});
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<BulkResultDto> bulkUpdateAssets() {
        return bulkUpdateAssets(BulkUpdateAssetsDto.builder().build());
    }

    public AssetDto putAssetContent(String id, File file, AssetsPutAssetContentRequest request) {
        return putAssetContent(id, file, request, null);
    }

    public AssetDto putAssetContent(
            String id, File file, AssetsPutAssetContentRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("assets")
                .addPathSegment(id)
                .addPathSegments("content")
                .build();
        MultipartBody.Builder _multipartBody = new MultipartBody.Builder().setType(MultipartBody.FORM);
        try {
            _multipartBody.addFormDataPart("file", null, RequestBody.create(null, file));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        RequestBody _requestBody = _multipartBody.build();
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)));
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), AssetDto.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AssetDto putAssetParent(String id, MoveAssetDto request) {
        return putAssetParent(id, request, null);
    }

    public AssetDto putAssetParent(String id, MoveAssetDto request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("assets")
                .addPathSegment(id)
                .addPathSegments("parent")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        if (request.getParentId().isPresent()) {
            _requestBodyProperties.put("parentId", request.getParentId());
        }
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), AssetDto.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AssetDto putAssetParent(String id) {
        return putAssetParent(id, MoveAssetDto.builder().build());
    }
}
