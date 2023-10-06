/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squidex.api.resources.notifications;

import com.squidex.api.core.ApiError;
import com.squidex.api.core.ClientOptions;
import com.squidex.api.core.ObjectMappers;
import com.squidex.api.core.RequestOptions;
import com.squidex.api.resources.notifications.requests.NotificationsGetNotificationsRequest;
import com.squidex.api.types.CommentsDto;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public class NotificationsClient {
    protected final ClientOptions clientOptions;

    public NotificationsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * When passing in a version you can retrieve all updates since then.
     */
    public CommentsDto getNotifications(String userId, NotificationsGetNotificationsRequest request) {
        return getNotifications(userId, request, null);
    }

    /**
     * When passing in a version you can retrieve all updates since then.
     */
    public CommentsDto getNotifications(
            String userId, NotificationsGetNotificationsRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/users")
                .addPathSegment(userId)
                .addPathSegments("notifications");
        if (request.getVersion().isPresent()) {
            httpUrl.addQueryParameter("version", request.getVersion().get().toString());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), CommentsDto.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public CommentsDto getNotifications(String userId) {
        return getNotifications(
                userId, NotificationsGetNotificationsRequest.builder().build());
    }

    public void deleteComment(String userId, String commentId) {
        deleteComment(userId, commentId, null);
    }

    public void deleteComment(String userId, String commentId, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/users")
                .addPathSegment(userId)
                .addPathSegments("notifications")
                .addPathSegment(commentId)
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("DELETE", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return;
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
