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
import com.squidex.api.types.TemplateDetailsDto;
import com.squidex.api.types.TemplatesDto;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SuppressWarnings("ALL")
public class TemplatesApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public TemplatesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public TemplatesApi(ApiClient apiClient) {
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

    private okhttp3.Call getTemplateCall(String name, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/api/templates/{name}"
            .replace("{" + "name" + "}", localVarApiClient.escapeString(name.toString()));

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
    private okhttp3.Call getTemplateValidateBeforeCall(String name, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new ApiException("Missing the required parameter 'name' when calling (Async)");
        }

        return getTemplateCall(name, _callback);

    }


    private ApiResponse<TemplateDetailsDto> getTemplateWithHttpInfo(String name) throws ApiException {
        okhttp3.Call localVarCall = getTemplateValidateBeforeCall(name, null);
        Type localVarReturnType = new TypeToken<TemplateDetailsDto>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getTemplateAsync(String name, final ApiCallback<TemplateDetailsDto> _callback) throws ApiException {

        okhttp3.Call localVarCall = getTemplateValidateBeforeCall(name, _callback);
        Type localVarReturnType = new TypeToken<TemplateDetailsDto>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APItemplatesGetTemplateRequest {
        private final String name;

        private APItemplatesGetTemplateRequest(String name) {
            this.name = name;
        }

        /**
         * Build call for getTemplate
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Template returned. </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Template not found. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return getTemplateCall(name, _callback);
        }

        /**
         * Execute getTemplate request
         * @return TemplateDetailsDto
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Template returned. </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Template not found. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public TemplateDetailsDto execute() throws ApiException {
            ApiResponse<TemplateDetailsDto> localVarResp = getTemplateWithHttpInfo(name);
            return localVarResp.getData();
        }

        /**
         * Execute getTemplate request with HTTP info returned
         * @return ApiResponse&lt;TemplateDetailsDto&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Template returned. </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Template not found. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<TemplateDetailsDto> executeWithHttpInfo() throws ApiException {
            return getTemplateWithHttpInfo(name);
        }

        /**
         * Execute getTemplate request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Template returned. </td><td>  -  </td></tr>
            <tr><td> 404 </td><td> Template not found. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<TemplateDetailsDto> _callback) throws ApiException {
            return getTemplateAsync(name, _callback);
        }
    }

    /**
     * Get template details.
     * 
     * @param name The name of the template. (required)
     * @return APItemplatesGetTemplateRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Template returned. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Template not found. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
     </table>
     */
    public APItemplatesGetTemplateRequest getTemplate(String name) {
        return new APItemplatesGetTemplateRequest(name);
    }
    private okhttp3.Call getTemplatesCall(final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/api/templates";

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
    private okhttp3.Call getTemplatesValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        return getTemplatesCall(_callback);

    }


    private ApiResponse<TemplatesDto> getTemplatesWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = getTemplatesValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<TemplatesDto>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getTemplatesAsync(final ApiCallback<TemplatesDto> _callback) throws ApiException {

        okhttp3.Call localVarCall = getTemplatesValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<TemplatesDto>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class APItemplatesGetTemplatesRequest {

        private APItemplatesGetTemplatesRequest() {
        }

        /**
         * Build call for getTemplates
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Templates returned. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return getTemplatesCall(_callback);
        }

        /**
         * Execute getTemplates request
         * @return TemplatesDto
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Templates returned. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public TemplatesDto execute() throws ApiException {
            ApiResponse<TemplatesDto> localVarResp = getTemplatesWithHttpInfo();
            return localVarResp.getData();
        }

        /**
         * Execute getTemplates request with HTTP info returned
         * @return ApiResponse&lt;TemplatesDto&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Templates returned. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<TemplatesDto> executeWithHttpInfo() throws ApiException {
            return getTemplatesWithHttpInfo();
        }

        /**
         * Execute getTemplates request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> Templates returned. </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<TemplatesDto> _callback) throws ApiException {
            return getTemplatesAsync(_callback);
        }
    }

    /**
     * Get all templates.
     * 
     * @return APItemplatesGetTemplatesRequest
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Templates returned. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Operation failed. </td><td>  -  </td></tr>
     </table>
     */
    public APItemplatesGetTemplatesRequest getTemplates() {
        return new APItemplatesGetTemplatesRequest();
    }
}