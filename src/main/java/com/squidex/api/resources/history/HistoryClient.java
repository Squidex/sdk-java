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
import okhttp3.RequestBody;
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
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("history");
        if (request.getChannel().isPresent()) {
            _httpUrl.addQueryParameter("channel", request.getChannel().get());
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
                return ObjectMappers.JSON_MAPPER.readValue(
                        _response.body().string(), new TypeReference<List<HistoryEventDto>>() {});
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<HistoryEventDto> getTeamHistory(String team, HistoryGetTeamHistoryRequest request) {
        return getTeamHistory(team, request, null);
    }

    public List<HistoryEventDto> getTeamHistory(
            String team, HistoryGetTeamHistoryRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/teams")
                .addPathSegment(team)
                .addPathSegments("history");
        if (request.getChannel().isPresent()) {
            _httpUrl.addQueryParameter("channel", request.getChannel().get());
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
                return ObjectMappers.JSON_MAPPER.readValue(
                        _response.body().string(), new TypeReference<List<HistoryEventDto>>() {});
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
