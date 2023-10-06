/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squidex.api.resources.history;

import com.fasterxml.jackson.core.type.TypeReference;
import com.squidex.api.core.ApiError;
import com.squidex.api.core.ClientOptions;
import com.squidex.api.core.ObjectMappers;
import com.squidex.api.core.RequestOptions;
import com.squidex.api.resources.history.requests.HistoryGetAppHistoryRequest;
import com.squidex.api.resources.history.requests.HistoryGetTeamHistoryRequest;
import com.squidex.api.types.HistoryEventDto;
import java.io.IOException;
import java.util.List;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public class HistoryClient {
    protected final ClientOptions clientOptions;

    public HistoryClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public List<HistoryEventDto> getAppHistory(HistoryGetAppHistoryRequest request) {
        return getAppHistory(request, null);
    }

    public List<HistoryEventDto> getAppHistory(HistoryGetAppHistoryRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("history");
        if (request.getChannel().isPresent()) {
            httpUrl.addQueryParameter("channel", request.getChannel().get());
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
                return ObjectMappers.JSON_MAPPER.readValue(
                        response.body().string(), new TypeReference<List<HistoryEventDto>>() {});
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<HistoryEventDto> getAppHistory() {
        return getAppHistory(HistoryGetAppHistoryRequest.builder().build());
    }

    public List<HistoryEventDto> getTeamHistory(String team, HistoryGetTeamHistoryRequest request) {
        return getTeamHistory(team, request, null);
    }

    public List<HistoryEventDto> getTeamHistory(
            String team, HistoryGetTeamHistoryRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/teams")
                .addPathSegment(team)
                .addPathSegments("history");
        if (request.getChannel().isPresent()) {
            httpUrl.addQueryParameter("channel", request.getChannel().get());
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
                return ObjectMappers.JSON_MAPPER.readValue(
                        response.body().string(), new TypeReference<List<HistoryEventDto>>() {});
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<HistoryEventDto> getTeamHistory(String team) {
        return getTeamHistory(team, HistoryGetTeamHistoryRequest.builder().build());
    }
}
