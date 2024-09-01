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
import com.squidex.api.types.HistoryEventDto;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SuppressWarnings("ALL")
public class HistoryApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public HistoryApi() {
        this(Configuration.getDefaultApiClient());
    }

    public HistoryApi(ApiClient apiClient) {
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

    private okhttp3.Call getAppHistoryCall(String channel, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/api/apps/$app$/history";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (channel != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("channel", channel));
        }

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
    private okhttp3.Call getAppHistoryValidateBeforeCall(String channel, final ApiCallback _callback) throws ApiException {
        return getAppHistoryCall(channel, _callback);

    }


    private ApiResponse<List<HistoryEventDto>> getAppHistoryWithHttpInfo(String channel) throws ApiException {
        okhttp3.Call localVarCall = getAppHistoryValidateBeforeCall(channel, null);
        Type localVarReturnType = new TypeToken<List<HistoryEventDto>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getAppHistoryAsync(String channel, final ApiCallback<List<HistoryEventDto>> _callback) throws ApiException {

        okhttp3.Call localVarCall = getAppHistoryValidateBeforeCall(channel, _callback);
        Type localVarReturnType = new TypeToken<List<HistoryEventDto>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIhistoryGetAppHistoryRequest {
        private String channel;

        private APIhistoryGetAppHistoryRequest() {
        }

        /**
         * Set channel
         * @param channel The name of the channel. (optional)
         * @return APIhistoryGetAppHistoryRequest
         */
        public APIhistoryGetAppHistoryRequest channel(String channel) {
            this.channel = channel;
            return this;
        }

        /**
         * Build call for getAppHistory
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Events returned. </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> App not found. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return getAppHistoryCall(channel, _callback);
        }

        /**
         * Execute getAppHistory request
         * @return List&lt;HistoryEventDto&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Events returned. </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> App not found. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public List<HistoryEventDto> execute() throws ApiException {
            ApiResponse<List<HistoryEventDto>> localVarResp = getAppHistoryWithHttpInfo(channel);
            return localVarResp.getData();
        }

        /**
         * Execute getAppHistory request with HTTP info returned
         * @return ApiResponse&lt;List&lt;HistoryEventDto&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Events returned. </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> App not found. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<HistoryEventDto>> executeWithHttpInfo() throws ApiException {
            return getAppHistoryWithHttpInfo(channel);
        }

        /**
         * Execute getAppHistory request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Events returned. </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> App not found. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<HistoryEventDto>> _callback) throws ApiException {
            return getAppHistoryAsync(channel, _callback);
        }
    }

    /**
     * Get the app history.
     * 
     * @return APIhistoryGetAppHistoryRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Events returned. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> App not found. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
     </table>
     */
    public APIhistoryGetAppHistoryRequest getAppHistory() {
        return new APIhistoryGetAppHistoryRequest();
    }
    private okhttp3.Call getTeamHistoryCall(String team, String channel, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/api/teams/{team}/history"
            .replace("{" + "team" + "}", localVarApiClient.escapeString(team.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (channel != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("channel", channel));
        }

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
    private okhttp3.Call getTeamHistoryValidateBeforeCall(String team, String channel, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'team' is set
        if (team == null) {
            throw new ApiException("Missing the required parameter 'team' when calling (Async)");
        }

        return getTeamHistoryCall(team, channel, _callback);

    }


    private ApiResponse<List<HistoryEventDto>> getTeamHistoryWithHttpInfo(String team, String channel) throws ApiException {
        okhttp3.Call localVarCall = getTeamHistoryValidateBeforeCall(team, channel, null);
        Type localVarReturnType = new TypeToken<List<HistoryEventDto>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getTeamHistoryAsync(String team, String channel, final ApiCallback<List<HistoryEventDto>> _callback) throws ApiException {

        okhttp3.Call localVarCall = getTeamHistoryValidateBeforeCall(team, channel, _callback);
        Type localVarReturnType = new TypeToken<List<HistoryEventDto>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APIhistoryGetTeamHistoryRequest {
        private final String team;
        private String channel;

        private APIhistoryGetTeamHistoryRequest(String team) {
            this.team = team;
        }

        /**
         * Set channel
         * @param channel The name of the channel. (optional)
         * @return APIhistoryGetTeamHistoryRequest
         */
        public APIhistoryGetTeamHistoryRequest channel(String channel) {
            this.channel = channel;
            return this;
        }

        /**
         * Build call for getTeamHistory
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Events returned. </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Team not found. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return getTeamHistoryCall(team, channel, _callback);
        }

        /**
         * Execute getTeamHistory request
         * @return List&lt;HistoryEventDto&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Events returned. </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Team not found. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public List<HistoryEventDto> execute() throws ApiException {
            ApiResponse<List<HistoryEventDto>> localVarResp = getTeamHistoryWithHttpInfo(team, channel);
            return localVarResp.getData();
        }

        /**
         * Execute getTeamHistory request with HTTP info returned
         * @return ApiResponse&lt;List&lt;HistoryEventDto&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Events returned. </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Team not found. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<HistoryEventDto>> executeWithHttpInfo() throws ApiException {
            return getTeamHistoryWithHttpInfo(team, channel);
        }

        /**
         * Execute getTeamHistory request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Events returned. </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Team not found. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<HistoryEventDto>> _callback) throws ApiException {
            return getTeamHistoryAsync(team, channel, _callback);
        }
    }

    /**
     * Get the team history.
     * 
     * @param team The ID of the team. (required)
     * @return APIhistoryGetTeamHistoryRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Events returned. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Team not found. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
     </table>
     */
    public APIhistoryGetTeamHistoryRequest getTeamHistory(String team) {
        return new APIhistoryGetTeamHistoryRequest(team);
    }
}
