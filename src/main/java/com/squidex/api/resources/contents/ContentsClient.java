package com.squidex.api.resources.contents;

import com.fasterxml.jackson.core.type.TypeReference;
import com.squidex.api.core.ApiError;
import com.squidex.api.core.ClientOptions;
import com.squidex.api.core.ObjectMappers;
import com.squidex.api.core.RequestOptions;
import com.squidex.api.resources.contents.requests.BulkUpdateContentsDto;
import com.squidex.api.resources.contents.requests.ChangeStatusDto;
import com.squidex.api.resources.contents.requests.ContentsCreateDraftRequest;
import com.squidex.api.resources.contents.requests.ContentsDeleteContentRequest;
import com.squidex.api.resources.contents.requests.ContentsDeleteContentStatusRequest;
import com.squidex.api.resources.contents.requests.ContentsDeleteVersionRequest;
import com.squidex.api.resources.contents.requests.ContentsGetContentRequest;
import com.squidex.api.resources.contents.requests.ContentsGetContentVersionRequest;
import com.squidex.api.resources.contents.requests.ContentsGetContentsPostRequest;
import com.squidex.api.resources.contents.requests.ContentsGetContentsRequest;
import com.squidex.api.resources.contents.requests.ContentsGetReferencesRequest;
import com.squidex.api.resources.contents.requests.ContentsGetReferencingRequest;
import com.squidex.api.resources.contents.requests.ContentsPatchContentRequest;
import com.squidex.api.resources.contents.requests.ContentsPostContentRequest;
import com.squidex.api.resources.contents.requests.ContentsPostUpsertContentRequest;
import com.squidex.api.resources.contents.requests.ContentsPutContentRequest;
import com.squidex.api.resources.contents.requests.ImportContentsDto;
import com.squidex.api.types.BulkResultDto;
import com.squidex.api.types.ContentDto;
import com.squidex.api.types.ContentsDto;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ContentsClient {
    protected final ClientOptions clientOptions;

    public ContentsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public ContentsDto getContents(String schema, ContentsGetContentsRequest request) {
        return getContents(schema, request, null);
    }

    public ContentsDto getContents(String schema, ContentsGetContentsRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/content")
                .addPathSegment(clientOptions.appName())
                .addPathSegment(schema);
        if (request.getIds().isPresent()) {
            _httpUrl.addQueryParameter("ids", request.getIds().get());
        }
        if (request.getQ().isPresent()) {
            _httpUrl.addQueryParameter("q", request.getQ().get());
        }
        if (request.getSearch().isPresent()) {
            _httpUrl.addQueryParameter("$search", request.getSearch().get());
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
        if (request.getFields().isPresent()) {
            _requestBuilder.addHeader("X-Fields", request.getFields().get());
        }
        if (request.getFlatten().isPresent()) {
            _requestBuilder.addHeader("X-Flatten", request.getFlatten().get().toString());
        }
        if (request.getLanguages().isPresent()) {
            _requestBuilder.addHeader("X-Languages", request.getLanguages().get());
        }
        if (request.getNoSlowTotal().isPresent()) {
            _requestBuilder.addHeader(
                    "X-NoSlowTotal", request.getNoSlowTotal().get().toString());
        }
        if (request.getNoTotal().isPresent()) {
            _requestBuilder.addHeader("X-NoTotal", request.getNoTotal().get().toString());
        }
        if (request.getUnpublished().isPresent()) {
            _requestBuilder.addHeader(
                    "X-Unpublished", request.getUnpublished().get().toString());
        }
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ContentsDto.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ContentDto postContent(String schema, ContentsPostContentRequest request) {
        return postContent(schema, request, null);
    }

    public ContentDto postContent(String schema, ContentsPostContentRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/content")
                .addPathSegment(clientOptions.appName())
                .addPathSegment(schema);
        if (request.getStatus().isPresent()) {
            _httpUrl.addQueryParameter("status", request.getStatus().get());
        }
        if (request.getId().isPresent()) {
            _httpUrl.addQueryParameter("id", request.getId().get());
        }
        if (request.getPublish().isPresent()) {
            _httpUrl.addQueryParameter("publish", request.getPublish().get().toString());
        }
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request.getBody()),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        if (request.getUnpublished().isPresent()) {
            _requestBuilder.addHeader(
                    "X-Unpublished", request.getUnpublished().get().toString());
        }
        if (request.getLanguages().isPresent()) {
            _requestBuilder.addHeader("X-Languages", request.getLanguages().get());
        }
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ContentDto.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ContentsDto getContentsPost(String schema, ContentsGetContentsPostRequest request) {
        return getContentsPost(schema, request, null);
    }

    public ContentsDto getContentsPost(
            String schema, ContentsGetContentsPostRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/content")
                .addPathSegment(clientOptions.appName())
                .addPathSegment(schema)
                .addPathSegments("query")
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
        if (request.getFields().isPresent()) {
            _requestBuilder.addHeader("X-Fields", request.getFields().get());
        }
        if (request.getFlatten().isPresent()) {
            _requestBuilder.addHeader("X-Flatten", request.getFlatten().get().toString());
        }
        if (request.getLanguages().isPresent()) {
            _requestBuilder.addHeader("X-Languages", request.getLanguages().get());
        }
        if (request.getNoSlowTotal().isPresent()) {
            _requestBuilder.addHeader(
                    "X-NoSlowTotal", request.getNoSlowTotal().get().toString());
        }
        if (request.getNoTotal().isPresent()) {
            _requestBuilder.addHeader("X-NoTotal", request.getNoTotal().get().toString());
        }
        if (request.getUnpublished().isPresent()) {
            _requestBuilder.addHeader(
                    "X-Unpublished", request.getUnpublished().get().toString());
        }
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ContentsDto.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ContentDto getContent(String schema, String id, ContentsGetContentRequest request) {
        return getContent(schema, id, request, null);
    }

    public ContentDto getContent(
            String schema, String id, ContentsGetContentRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/content")
                .addPathSegment(clientOptions.appName())
                .addPathSegment(schema)
                .addPathSegment(id);
        if (request.getVersion().isPresent()) {
            _httpUrl.addQueryParameter("version", request.getVersion().get().toString());
        }
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("GET", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        if (request.getFields().isPresent()) {
            _requestBuilder.addHeader("X-Fields", request.getFields().get());
        }
        if (request.getFlatten().isPresent()) {
            _requestBuilder.addHeader("X-Flatten", request.getFlatten().get().toString());
        }
        if (request.getLanguages().isPresent()) {
            _requestBuilder.addHeader("X-Languages", request.getLanguages().get());
        }
        if (request.getUnpublished().isPresent()) {
            _requestBuilder.addHeader(
                    "X-Unpublished", request.getUnpublished().get().toString());
        }
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ContentDto.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ContentDto postUpsertContent(String schema, String id, ContentsPostUpsertContentRequest request) {
        return postUpsertContent(schema, id, request, null);
    }

    public ContentDto postUpsertContent(
            String schema, String id, ContentsPostUpsertContentRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/content")
                .addPathSegment(clientOptions.appName())
                .addPathSegment(schema)
                .addPathSegment(id);
        if (request.getStatus().isPresent()) {
            _httpUrl.addQueryParameter("status", request.getStatus().get());
        }
        if (request.getPatch().isPresent()) {
            _httpUrl.addQueryParameter("patch", request.getPatch().get().toString());
        }
        if (request.getPublish().isPresent()) {
            _httpUrl.addQueryParameter("publish", request.getPublish().get().toString());
        }
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request.getBody()),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        if (request.getUnpublished().isPresent()) {
            _requestBuilder.addHeader(
                    "X-Unpublished", request.getUnpublished().get().toString());
        }
        if (request.getLanguages().isPresent()) {
            _requestBuilder.addHeader("X-Languages", request.getLanguages().get());
        }
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ContentDto.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ContentDto putContent(String schema, String id, ContentsPutContentRequest request) {
        return putContent(schema, id, request, null);
    }

    public ContentDto putContent(
            String schema, String id, ContentsPutContentRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/content")
                .addPathSegment(clientOptions.appName())
                .addPathSegment(schema)
                .addPathSegment(id)
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
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        if (request.getUnpublished().isPresent()) {
            _requestBuilder.addHeader(
                    "X-Unpublished", request.getUnpublished().get().toString());
        }
        if (request.getLanguages().isPresent()) {
            _requestBuilder.addHeader("X-Languages", request.getLanguages().get());
        }
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ContentDto.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ContentDto patchContent(String schema, String id, ContentsPatchContentRequest request) {
        return patchContent(schema, id, request, null);
    }

    public ContentDto patchContent(
            String schema, String id, ContentsPatchContentRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/content")
                .addPathSegment(clientOptions.appName())
                .addPathSegment(schema)
                .addPathSegment(id)
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
                .method("PATCH", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        if (request.getUnpublished().isPresent()) {
            _requestBuilder.addHeader(
                    "X-Unpublished", request.getUnpublished().get().toString());
        }
        if (request.getLanguages().isPresent()) {
            _requestBuilder.addHeader("X-Languages", request.getLanguages().get());
        }
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ContentDto.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteContent(String schema, String id, ContentsDeleteContentRequest request) {
        deleteContent(schema, id, request, null);
    }

    public void deleteContent(
            String schema, String id, ContentsDeleteContentRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/content")
                .addPathSegment(clientOptions.appName())
                .addPathSegment(schema)
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

    public void getContentValidity(String schema, String id) {
        getContentValidity(schema, id, null);
    }

    public void getContentValidity(String schema, String id, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/content")
                .addPathSegment(clientOptions.appName())
                .addPathSegment(schema)
                .addPathSegment(id)
                .addPathSegments("validity")
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("GET", null)
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

    public ContentsDto getReferences(String schema, String id, ContentsGetReferencesRequest request) {
        return getReferences(schema, id, request, null);
    }

    public ContentsDto getReferences(
            String schema, String id, ContentsGetReferencesRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/content")
                .addPathSegment(clientOptions.appName())
                .addPathSegment(schema)
                .addPathSegment(id)
                .addPathSegments("references");
        if (request.getQ().isPresent()) {
            _httpUrl.addQueryParameter("q", request.getQ().get());
        }
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("GET", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        if (request.getFields().isPresent()) {
            _requestBuilder.addHeader("X-Fields", request.getFields().get());
        }
        if (request.getFlatten().isPresent()) {
            _requestBuilder.addHeader("X-Flatten", request.getFlatten().get().toString());
        }
        if (request.getLanguages().isPresent()) {
            _requestBuilder.addHeader("X-Languages", request.getLanguages().get());
        }
        if (request.getUnpublished().isPresent()) {
            _requestBuilder.addHeader(
                    "X-Unpublished", request.getUnpublished().get().toString());
        }
        if (request.getNoSlowTotal().isPresent()) {
            _requestBuilder.addHeader(
                    "X-NoSlowTotal", request.getNoSlowTotal().get().toString());
        }
        if (request.getNoTotal().isPresent()) {
            _requestBuilder.addHeader("X-NoTotal", request.getNoTotal().get().toString());
        }
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ContentsDto.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ContentsDto getReferencing(String schema, String id, ContentsGetReferencingRequest request) {
        return getReferencing(schema, id, request, null);
    }

    public ContentsDto getReferencing(
            String schema, String id, ContentsGetReferencingRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/content")
                .addPathSegment(clientOptions.appName())
                .addPathSegment(schema)
                .addPathSegment(id)
                .addPathSegments("referencing");
        if (request.getQ().isPresent()) {
            _httpUrl.addQueryParameter("q", request.getQ().get());
        }
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("GET", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        if (request.getFields().isPresent()) {
            _requestBuilder.addHeader("X-Fields", request.getFields().get());
        }
        if (request.getFlatten().isPresent()) {
            _requestBuilder.addHeader("X-Flatten", request.getFlatten().get().toString());
        }
        if (request.getLanguages().isPresent()) {
            _requestBuilder.addHeader("X-Languages", request.getLanguages().get());
        }
        if (request.getUnpublished().isPresent()) {
            _requestBuilder.addHeader(
                    "X-Unpublished", request.getUnpublished().get().toString());
        }
        if (request.getNoSlowTotal().isPresent()) {
            _requestBuilder.addHeader(
                    "X-NoSlowTotal", request.getNoSlowTotal().get().toString());
        }
        if (request.getNoTotal().isPresent()) {
            _requestBuilder.addHeader("X-NoTotal", request.getNoTotal().get().toString());
        }
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ContentsDto.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public InputStream getContentVersion(
            String schema, String id, int version, ContentsGetContentVersionRequest request) {
        return getContentVersion(schema, id, version, request, null);
    }

    public InputStream getContentVersion(
            String schema,
            String id,
            int version,
            ContentsGetContentVersionRequest request,
            RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/content")
                .addPathSegment(clientOptions.appName())
                .addPathSegment(schema)
                .addPathSegment(id)
                .addPathSegment(Integer.toString(version))
                .build();
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("GET", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        if (request.getUnpublished().isPresent()) {
            _requestBuilder.addHeader(
                    "X-Unpublished", request.getUnpublished().get().toString());
        }
        if (request.getLanguages().isPresent()) {
            _requestBuilder.addHeader("X-Languages", request.getLanguages().get());
        }
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

    public List<BulkResultDto> postContents(String schema, ImportContentsDto request) {
        return postContents(schema, request, null);
    }

    public List<BulkResultDto> postContents(String schema, ImportContentsDto request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/content")
                .addPathSegment(clientOptions.appName())
                .addPathSegment(schema)
                .addPathSegments("import")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("datas", request.getDatas());
        if (request.getPublish().isPresent()) {
            _requestBodyProperties.put("publish", request.getPublish());
        }
        if (request.getDoNotScript().isPresent()) {
            _requestBodyProperties.put("doNotScript", request.getDoNotScript());
        }
        if (request.getOptimizeValidation().isPresent()) {
            _requestBodyProperties.put("optimizeValidation", request.getOptimizeValidation());
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

    public List<BulkResultDto> bulkUpdateContents(String schema, BulkUpdateContentsDto request) {
        return bulkUpdateContents(schema, request, null);
    }

    public List<BulkResultDto> bulkUpdateContents(
            String schema, BulkUpdateContentsDto request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/content")
                .addPathSegment(clientOptions.appName())
                .addPathSegment(schema)
                .addPathSegments("bulk")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("jobs", request.getJobs());
        if (request.getPublish().isPresent()) {
            _requestBodyProperties.put("publish", request.getPublish());
        }
        if (request.getDoNotScript().isPresent()) {
            _requestBodyProperties.put("doNotScript", request.getDoNotScript());
        }
        if (request.getDoNotValidate().isPresent()) {
            _requestBodyProperties.put("doNotValidate", request.getDoNotValidate());
        }
        if (request.getDoNotValidateWorkflow().isPresent()) {
            _requestBodyProperties.put("doNotValidateWorkflow", request.getDoNotValidateWorkflow());
        }
        if (request.getCheckReferrers().isPresent()) {
            _requestBodyProperties.put("checkReferrers", request.getCheckReferrers());
        }
        if (request.getOptimizeValidation().isPresent()) {
            _requestBodyProperties.put("optimizeValidation", request.getOptimizeValidation());
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

    public ContentDto putContentStatus(String schema, String id, ChangeStatusDto request) {
        return putContentStatus(schema, id, request, null);
    }

    public ContentDto putContentStatus(
            String schema, String id, ChangeStatusDto request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/content")
                .addPathSegment(clientOptions.appName())
                .addPathSegment(schema)
                .addPathSegment(id)
                .addPathSegments("status")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("status", request.getStatus());
        if (request.getDueTime().isPresent()) {
            _requestBodyProperties.put("dueTime", request.getDueTime());
        }
        if (request.getCheckReferrers().isPresent()) {
            _requestBodyProperties.put("checkReferrers", request.getCheckReferrers());
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
        if (request.getUnpublished().isPresent()) {
            _requestBuilder.addHeader(
                    "X-Unpublished", request.getUnpublished().get().toString());
        }
        if (request.getLanguages().isPresent()) {
            _requestBuilder.addHeader("X-Languages", request.getLanguages().get());
        }
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ContentDto.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ContentDto deleteContentStatus(String schema, String id, ContentsDeleteContentStatusRequest request) {
        return deleteContentStatus(schema, id, request, null);
    }

    public ContentDto deleteContentStatus(
            String schema, String id, ContentsDeleteContentStatusRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/content")
                .addPathSegment(clientOptions.appName())
                .addPathSegment(schema)
                .addPathSegment(id)
                .addPathSegments("status")
                .build();
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("DELETE", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        if (request.getUnpublished().isPresent()) {
            _requestBuilder.addHeader(
                    "X-Unpublished", request.getUnpublished().get().toString());
        }
        if (request.getLanguages().isPresent()) {
            _requestBuilder.addHeader("X-Languages", request.getLanguages().get());
        }
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ContentDto.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ContentDto createDraft(String schema, String id, ContentsCreateDraftRequest request) {
        return createDraft(schema, id, request, null);
    }

    public ContentDto createDraft(
            String schema, String id, ContentsCreateDraftRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/content")
                .addPathSegment(clientOptions.appName())
                .addPathSegment(schema)
                .addPathSegment(id)
                .addPathSegments("draft")
                .build();
        RequestBody _requestBody = RequestBody.create("", null);
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        if (request.getUnpublished().isPresent()) {
            _requestBuilder.addHeader(
                    "X-Unpublished", request.getUnpublished().get().toString());
        }
        if (request.getLanguages().isPresent()) {
            _requestBuilder.addHeader("X-Languages", request.getLanguages().get());
        }
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ContentDto.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ContentDto deleteVersion(String schema, String id, ContentsDeleteVersionRequest request) {
        return deleteVersion(schema, id, request, null);
    }

    public ContentDto deleteVersion(
            String schema, String id, ContentsDeleteVersionRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/content")
                .addPathSegment(clientOptions.appName())
                .addPathSegment(schema)
                .addPathSegment(id)
                .addPathSegments("draft")
                .build();
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("DELETE", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        if (request.getUnpublished().isPresent()) {
            _requestBuilder.addHeader(
                    "X-Unpublished", request.getUnpublished().get().toString());
        }
        if (request.getLanguages().isPresent()) {
            _requestBuilder.addHeader("X-Languages", request.getLanguages().get());
        }
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ContentDto.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
