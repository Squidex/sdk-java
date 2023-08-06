package com.squidex.api.resources.statistics;

import com.fasterxml.jackson.core.type.TypeReference;
import com.squidex.api.core.ClientOptions;
import com.squidex.api.core.ObjectMappers;
import com.squidex.api.core.RequestOptions;
import com.squidex.api.types.CallsUsageDtoDto;
import com.squidex.api.types.CurrentStorageDto;
import com.squidex.api.types.LogDownloadDto;
import com.squidex.api.types.StorageUsagePerDateDto;
import java.util.List;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public class StatisticsClient {
    protected final ClientOptions clientOptions;

    public StatisticsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public LogDownloadDto getLog() {
        return getLog(null);
    }

    public LogDownloadDto getLog(RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("usages/log")
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), LogDownloadDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CallsUsageDtoDto getUsages(String fromDate, String toDate) {
        return getUsages(fromDate, toDate, null);
    }

    public CallsUsageDtoDto getUsages(String fromDate, String toDate, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("usages/calls")
                .addPathSegment(fromDate)
                .addPathSegment(toDate)
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), CallsUsageDtoDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CallsUsageDtoDto getUsagesForTeam(String team, String fromDate, String toDate) {
        return getUsagesForTeam(team, fromDate, toDate, null);
    }

    public CallsUsageDtoDto getUsagesForTeam(
            String team, String fromDate, String toDate, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/teams")
                .addPathSegment(team)
                .addPathSegments("usages/calls")
                .addPathSegment(fromDate)
                .addPathSegment(toDate)
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), CallsUsageDtoDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CurrentStorageDto getCurrentStorageSize() {
        return getCurrentStorageSize(null);
    }

    public CurrentStorageDto getCurrentStorageSize(RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("usages/storage/today")
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), CurrentStorageDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CurrentStorageDto getTeamCurrentStorageSizeForTeam(String team) {
        return getTeamCurrentStorageSizeForTeam(team, null);
    }

    public CurrentStorageDto getTeamCurrentStorageSizeForTeam(String team, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/teams")
                .addPathSegment(team)
                .addPathSegments("usages/storage/today")
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), CurrentStorageDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<StorageUsagePerDateDto> getStorageSizes(String fromDate, String toDate) {
        return getStorageSizes(fromDate, toDate, null);
    }

    public List<StorageUsagePerDateDto> getStorageSizes(String fromDate, String toDate, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("usages/storage")
                .addPathSegment(fromDate)
                .addPathSegment(toDate)
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
                        _response.body().string(), new TypeReference<List<StorageUsagePerDateDto>>() {});
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<StorageUsagePerDateDto> getStorageSizesForTeam(String team, String fromDate, String toDate) {
        return getStorageSizesForTeam(team, fromDate, toDate, null);
    }

    public List<StorageUsagePerDateDto> getStorageSizesForTeam(
            String team, String fromDate, String toDate, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/teams")
                .addPathSegment(team)
                .addPathSegments("usages/storage")
                .addPathSegment(fromDate)
                .addPathSegment(toDate)
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
                        _response.body().string(), new TypeReference<List<StorageUsagePerDateDto>>() {});
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
