package com.squidex.api.resources.notifications;

import com.squidex.api.core.ClientOptions;
import com.squidex.api.core.ObjectMappers;
import com.squidex.api.core.RequestOptions;
import com.squidex.api.resources.notifications.requests.NotificationsGetNotificationsRequest;
import com.squidex.api.types.CommentsDto;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NotificationsClient {
    protected final ClientOptions clientOptions;

    public NotificationsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public CommentsDto getNotifications(String userId, NotificationsGetNotificationsRequest request) {
        return getNotifications(userId, request, null);
    }

    public CommentsDto getNotifications(
            String userId, NotificationsGetNotificationsRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/users")
                .addPathSegment(userId)
                .addPathSegments("notifications");
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

    public void deleteComment(String userId, String commentId) {
        deleteComment(userId, commentId, null);
    }

    public void deleteComment(String userId, String commentId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/users")
                .addPathSegment(userId)
                .addPathSegments("notifications")
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
