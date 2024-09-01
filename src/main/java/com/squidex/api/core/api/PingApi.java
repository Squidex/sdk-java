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

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SuppressWarnings("ALL")
public class PingApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public PingApi() {
        this(Configuration.getDefaultApiClient());
    }

    public PingApi(ApiClient apiClient) {
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

    private okhttp3.Call getAppPingCall(final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/api/ping/$app$";

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
    private okhttp3.Call getAppPingValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        return getAppPingCall(_callback);

    }


    private ApiResponse<Void> getAppPingWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = getAppPingValidateBeforeCall(null);
        return localVarApiClient.execute(localVarCall);
    }

    private okhttp3.Call getAppPingAsync(final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = getAppPingValidateBeforeCall(_callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }

    public class APIpingGetAppPingRequest {

        private APIpingGetAppPingRequest() {
        }

        /**
         * Build call for getAppPing
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 204 </td><td> Service ping successful. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return getAppPingCall(_callback);
        }

        /**
         * Execute getAppPing request
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 204 </td><td> Service ping successful. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public void execute() throws ApiException {
            getAppPingWithHttpInfo();
        }

        /**
         * Execute getAppPing request with HTTP info returned
         * @return ApiResponse&lt;Void&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 204 </td><td> Service ping successful. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Void> executeWithHttpInfo() throws ApiException {
            return getAppPingWithHttpInfo();
        }

        /**
         * Execute getAppPing request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 204 </td><td> Service ping successful. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Void> _callback) throws ApiException {
            return getAppPingAsync(_callback);
        }
    }

    /**
     * Get ping status.
     * Can be used to test, if the Squidex API is alive and responding.
     * @return APIpingGetAppPingRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> Service ping successful. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
     </table>
     */
    public APIpingGetAppPingRequest getAppPing() {
        return new APIpingGetAppPingRequest();
    }
    private okhttp3.Call getInfoCall(final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/api/info";

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
    private okhttp3.Call getInfoValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        return getInfoCall(_callback);

    }


    private ApiResponse<Map<String, String>> getInfoWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = getInfoValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<Map<String, String>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getInfoAsync(final ApiCallback<Map<String, String>> _callback) throws ApiException {

        okhttp3.Call localVarCall = getInfoValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<Map<String, String>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIpingGetInfoRequest {

        private APIpingGetInfoRequest() {
        }

        /**
         * Build call for getInfo
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Infos returned. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return getInfoCall(_callback);
        }

        /**
         * Execute getInfo request
         * @return Map&lt;String, String&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Infos returned. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public Map<String, String> execute() throws ApiException {
            ApiResponse<Map<String, String>> localVarResp = getInfoWithHttpInfo();
            return localVarResp.getData();
        }

        /**
         * Execute getInfo request with HTTP info returned
         * @return ApiResponse&lt;Map&lt;String, String&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Infos returned. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Map<String, String>> executeWithHttpInfo() throws ApiException {
            return getInfoWithHttpInfo();
        }

        /**
         * Execute getInfo request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Infos returned. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Map<String, String>> _callback) throws ApiException {
            return getInfoAsync(_callback);
        }
    }

    /**
     * Get API information.
     * 
     * @return APIpingGetInfoRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Infos returned. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
     </table>
     */
    public APIpingGetInfoRequest getInfo() {
        return new APIpingGetInfoRequest();
    }
    private okhttp3.Call getPingCall(final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/api/ping";

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
    private okhttp3.Call getPingValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        return getPingCall(_callback);

    }


    private ApiResponse<Void> getPingWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = getPingValidateBeforeCall(null);
        return localVarApiClient.execute(localVarCall);
    }

    private okhttp3.Call getPingAsync(final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = getPingValidateBeforeCall(_callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }

    public class APIpingGetPingRequest {

        private APIpingGetPingRequest() {
        }

        /**
         * Build call for getPing
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 204 </td><td> Service ping successful. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return getPingCall(_callback);
        }

        /**
         * Execute getPing request
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 204 </td><td> Service ping successful. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public void execute() throws ApiException {
            getPingWithHttpInfo();
        }

        /**
         * Execute getPing request with HTTP info returned
         * @return ApiResponse&lt;Void&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 204 </td><td> Service ping successful. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Void> executeWithHttpInfo() throws ApiException {
            return getPingWithHttpInfo();
        }

        /**
         * Execute getPing request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 204 </td><td> Service ping successful. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Void> _callback) throws ApiException {
            return getPingAsync(_callback);
        }
    }

    /**
     * Get ping status of the API.
     * Can be used to test, if the Squidex API is alive and responding.
     * @return APIpingGetPingRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> Service ping successful. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
     </table>
     */
    public APIpingGetPingRequest getPing() {
        return new APIpingGetPingRequest();
    }
}
