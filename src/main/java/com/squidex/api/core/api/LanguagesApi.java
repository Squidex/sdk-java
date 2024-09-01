/*
 * Squidex API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1.0.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.squidex.api.core.api;

import com.squidex.api.core.ApiCallback;
import com.squidex.api.core.ApiClient;
import com.squidex.api.core.ApiException;
import com.squidex.api.core.ApiResponse;
import com.squidex.api.core.Configuration;
import com.squidex.api.core.Pair;
import com.squidex.api.core.ProgressRequestBody;
import com.squidex.api.core.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.squidex.api.types.ErrorDto;
import com.squidex.api.types.LanguageDto;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SuppressWarnings("ALL")
public class LanguagesApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public LanguagesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public LanguagesApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public int getHostIndex() {
        return localHostIndex;
    }

    public void setHostIndex(int hostIndex) {
        this.localHostIndex = hostIndex;
    }

    public String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    public void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    private okhttp3.Call getLanguagesCall(final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/languages";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getLanguagesValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        return getLanguagesCall(_callback);

    }


    private ApiResponse<List<LanguageDto>> getLanguagesWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = getLanguagesValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<List<LanguageDto>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getLanguagesAsync(final ApiCallback<List<LanguageDto>> _callback) throws ApiException {

        okhttp3.Call localVarCall = getLanguagesValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<List<LanguageDto>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIlanguagesGetLanguagesRequest {

        private APIlanguagesGetLanguagesRequest() {
        }

        /**
         * Build call for getLanguages
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Supported language codes returned. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return getLanguagesCall(_callback);
        }

        /**
         * Execute getLanguages request
         * @return List&lt;LanguageDto&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Supported language codes returned. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public List<LanguageDto> execute() throws ApiException {
            ApiResponse<List<LanguageDto>> localVarResp = getLanguagesWithHttpInfo();
            return localVarResp.getData();
        }

        /**
         * Execute getLanguages request with HTTP info returned
         * @return ApiResponse&lt;List&lt;LanguageDto&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Supported language codes returned. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<LanguageDto>> executeWithHttpInfo() throws ApiException {
            return getLanguagesWithHttpInfo();
        }

        /**
         * Execute getLanguages request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Supported language codes returned. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<LanguageDto>> _callback) throws ApiException {
            return getLanguagesAsync(_callback);
        }
    }

    /**
     * Get supported languages.
     * Provide a list of supported language codes, following the ISO2Code standard.
     * @return APIlanguagesGetLanguagesRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Supported language codes returned. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
     </table>
     */
    public APIlanguagesGetLanguagesRequest getLanguages() {
        return new APIlanguagesGetLanguagesRequest();
    }
}