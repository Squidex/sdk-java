package com.squidex.api.resources.comments;

import com.fasterxml.jackson.core.type.TypeReference;
import com.squidex.api.core.ClientOptions;
import com.squidex.api.core.ObjectMappers;
import com.squidex.api.core.RequestOptions;
import com.squidex.api.resources.comments.requests.CommentsGetCommentsRequest;
import com.squidex.api.types.CommentDto;
import com.squidex.api.types.CommentsDto;
import com.squidex.api.types.UpsertCommentDto;
import java.util.List;
import java.util.Optional;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CommentsClient {
    protected final ClientOptions clientOptions;

    public CommentsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public List<String> getWatchingUsers(Optional<String> resource) {
        return getWatchingUsers(resource, null);
    }

    public List<String> getWatchingUsers(Optional<String> resource, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("watching");
        if (resource.isPresent()) {
            _httpUrl.addPathSegment(resource.get());
        }
        Request _request = new Request.Builder()
                .url(_httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        _response.body().string(), new TypeReference<List<String>>() {});
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CommentsDto getComments(String commentsId, CommentsGetCommentsRequest request) {
        return getComments(commentsId, request, null);
    }

    public CommentsDto getComments(
            String commentsId, CommentsGetCommentsRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("comments")
                .addPathSegment(commentsId);
        if (request.getVersion().isPresent()) {
            _httpUrl.addQueryParameter("version", request.getVersion().get().toString());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), CommentsDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CommentDto postComment(String commentsId, UpsertCommentDto request) {
        return postComment(commentsId, request, null);
    }

    public CommentDto postComment(String commentsId, UpsertCommentDto request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("comments")
                .addPathSegment(commentsId)
                .build();
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), CommentDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void putComment(String commentsId, String commentId, UpsertCommentDto request) {
        putComment(commentsId, commentId, request, null);
    }

    public void putComment(
            String commentsId, String commentId, UpsertCommentDto request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("comments")
                .addPathSegment(commentsId)
                .addPathSegment(commentId)
                .build();
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return;
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteComment(String commentsId, String commentId) {
        deleteComment(commentsId, commentId, null);
    }

    public void deleteComment(String commentsId, String commentId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("comments")
                .addPathSegment(commentsId)
                .addPathSegment(commentId)
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
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
