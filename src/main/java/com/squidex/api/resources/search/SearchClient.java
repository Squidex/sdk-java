package com.squidex.api.resources.search;

import com.fasterxml.jackson.core.type.TypeReference;
import com.squidex.api.core.ClientOptions;
import com.squidex.api.core.ObjectMappers;
import com.squidex.api.core.RequestOptions;
import com.squidex.api.resources.search.requests.SearchGetSearchResultsRequest;
import com.squidex.api.types.SearchResultDto;
import java.util.List;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SearchClient {
    protected final ClientOptions clientOptions;

    public SearchClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public List<SearchResultDto> getSearchResults(SearchGetSearchResultsRequest request) {
        return getSearchResults(request, null);
    }

    public List<SearchResultDto> getSearchResults(
            SearchGetSearchResultsRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("search");
        if (request.getQuery().isPresent()) {
            _httpUrl.addQueryParameter("query", request.getQuery().get());
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
                        _response.body().string(), new TypeReference<List<SearchResultDto>>() {});
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
