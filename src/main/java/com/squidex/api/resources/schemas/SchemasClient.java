package com.squidex.api.resources.schemas;

import com.squidex.api.core.ClientOptions;
import com.squidex.api.core.ObjectMappers;
import com.squidex.api.core.RequestOptions;
import com.squidex.api.resources.schemas.requests.ChangeCategoryDto;
import com.squidex.api.resources.schemas.requests.ConfigureFieldRulesDto;
import com.squidex.api.resources.schemas.requests.ConfigureUiFieldsDto;
import com.squidex.api.resources.schemas.requests.CreateSchemaDto;
import com.squidex.api.resources.schemas.requests.SynchronizeSchemaDto;
import com.squidex.api.resources.schemas.requests.UpdateSchemaDto;
import com.squidex.api.types.AddFieldDto;
import com.squidex.api.types.ReorderFieldsDto;
import com.squidex.api.types.SchemaDto;
import com.squidex.api.types.SchemaScriptsDto;
import com.squidex.api.types.SchemasDto;
import com.squidex.api.types.UpdateFieldDto;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SchemasClient {
    protected final ClientOptions clientOptions;

    public SchemasClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public SchemaDto postField(String schema, AddFieldDto request) {
        return postField(schema, request, null);
    }

    public SchemaDto postField(String schema, AddFieldDto request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
                .addPathSegments("fields")
                .build();
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemaDto postNestedField(String schema, int parentId, AddFieldDto request) {
        return postNestedField(schema, parentId, request, null);
    }

    public SchemaDto postNestedField(String schema, int parentId, AddFieldDto request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
                .addPathSegments("fields")
                .addPathSegment(Integer.toString(parentId))
                .addPathSegments("nested")
                .build();
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemaDto putSchemaUiFields(String schema, ConfigureUiFieldsDto request) {
        return putSchemaUiFields(schema, request, null);
    }

    public SchemaDto putSchemaUiFields(String schema, ConfigureUiFieldsDto request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
                .addPathSegments("fields/ui")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        if (request.getFieldsInLists().isPresent()) {
            _requestBodyProperties.put("fieldsInLists", request.getFieldsInLists());
        }
        if (request.getFieldsInReferences().isPresent()) {
            _requestBodyProperties.put("fieldsInReferences", request.getFieldsInReferences());
        }
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemaDto putSchemaFieldOrdering(String schema, ReorderFieldsDto request) {
        return putSchemaFieldOrdering(schema, request, null);
    }

    public SchemaDto putSchemaFieldOrdering(String schema, ReorderFieldsDto request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
                .addPathSegments("fields/ordering")
                .build();
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemaDto putNestedFieldOrdering(String schema, int parentId, ReorderFieldsDto request) {
        return putNestedFieldOrdering(schema, parentId, request, null);
    }

    public SchemaDto putNestedFieldOrdering(
            String schema, int parentId, ReorderFieldsDto request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
                .addPathSegments("fields")
                .addPathSegment(Integer.toString(parentId))
                .addPathSegments("nested/ordering")
                .build();
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemaDto putField(String schema, int id, UpdateFieldDto request) {
        return putField(schema, id, request, null);
    }

    public SchemaDto putField(String schema, int id, UpdateFieldDto request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
                .addPathSegments("fields")
                .addPathSegment(Integer.toString(id))
                .build();
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemaDto deleteField(String schema, int id) {
        return deleteField(schema, id, null);
    }

    public SchemaDto deleteField(String schema, int id, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
                .addPathSegments("fields")
                .addPathSegment(Integer.toString(id))
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("DELETE", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemaDto putNestedField(String schema, int parentId, int id, UpdateFieldDto request) {
        return putNestedField(schema, parentId, id, request, null);
    }

    public SchemaDto putNestedField(
            String schema, int parentId, int id, UpdateFieldDto request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
                .addPathSegments("fields")
                .addPathSegment(Integer.toString(parentId))
                .addPathSegments("nested")
                .addPathSegment(Integer.toString(id))
                .build();
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemaDto deleteNestedField(String schema, int parentId, int id) {
        return deleteNestedField(schema, parentId, id, null);
    }

    public SchemaDto deleteNestedField(String schema, int parentId, int id, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
                .addPathSegments("fields")
                .addPathSegment(Integer.toString(parentId))
                .addPathSegments("nested")
                .addPathSegment(Integer.toString(id))
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("DELETE", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemaDto lockField(String schema, int id) {
        return lockField(schema, id, null);
    }

    public SchemaDto lockField(String schema, int id, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
                .addPathSegments("fields")
                .addPathSegment(Integer.toString(id))
                .addPathSegments("lock")
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemaDto lockNestedField(String schema, int parentId, int id) {
        return lockNestedField(schema, parentId, id, null);
    }

    public SchemaDto lockNestedField(String schema, int parentId, int id, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
                .addPathSegments("fields")
                .addPathSegment(Integer.toString(parentId))
                .addPathSegments("nested")
                .addPathSegment(Integer.toString(id))
                .addPathSegments("lock")
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemaDto hideField(String schema, int id) {
        return hideField(schema, id, null);
    }

    public SchemaDto hideField(String schema, int id, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
                .addPathSegments("fields")
                .addPathSegment(Integer.toString(id))
                .addPathSegments("hide")
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemaDto hideNestedField(String schema, int parentId, int id) {
        return hideNestedField(schema, parentId, id, null);
    }

    public SchemaDto hideNestedField(String schema, int parentId, int id, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
                .addPathSegments("fields")
                .addPathSegment(Integer.toString(parentId))
                .addPathSegments("nested")
                .addPathSegment(Integer.toString(id))
                .addPathSegments("hide")
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemaDto showField(String schema, int id) {
        return showField(schema, id, null);
    }

    public SchemaDto showField(String schema, int id, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
                .addPathSegments("fields")
                .addPathSegment(Integer.toString(id))
                .addPathSegments("show")
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemaDto showNestedField(String schema, int parentId, int id) {
        return showNestedField(schema, parentId, id, null);
    }

    public SchemaDto showNestedField(String schema, int parentId, int id, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
                .addPathSegments("fields")
                .addPathSegment(Integer.toString(parentId))
                .addPathSegments("nested")
                .addPathSegment(Integer.toString(id))
                .addPathSegments("show")
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemaDto enableField(String schema, int id) {
        return enableField(schema, id, null);
    }

    public SchemaDto enableField(String schema, int id, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
                .addPathSegments("fields")
                .addPathSegment(Integer.toString(id))
                .addPathSegments("enable")
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemaDto enableNestedField(String schema, int parentId, int id) {
        return enableNestedField(schema, parentId, id, null);
    }

    public SchemaDto enableNestedField(String schema, int parentId, int id, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
                .addPathSegments("fields")
                .addPathSegment(Integer.toString(parentId))
                .addPathSegments("nested")
                .addPathSegment(Integer.toString(id))
                .addPathSegments("enable")
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemaDto disableField(String schema, int id) {
        return disableField(schema, id, null);
    }

    public SchemaDto disableField(String schema, int id, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
                .addPathSegments("fields")
                .addPathSegment(Integer.toString(id))
                .addPathSegments("disable")
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemaDto disableNestedField(String schema, int parentId, int id) {
        return disableNestedField(schema, parentId, id, null);
    }

    public SchemaDto disableNestedField(String schema, int parentId, int id, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
                .addPathSegments("fields")
                .addPathSegment(Integer.toString(parentId))
                .addPathSegments("nested")
                .addPathSegment(Integer.toString(id))
                .addPathSegments("disable")
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemasDto getSchemas() {
        return getSchemas(null);
    }

    public SchemasDto getSchemas(RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemasDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemaDto postSchema(CreateSchemaDto request) {
        return postSchema(request, null);
    }

    public SchemaDto postSchema(CreateSchemaDto request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("name", request.getName());
        if (request.getType().isPresent()) {
            _requestBodyProperties.put("type", request.getType());
        }
        if (request.getIsSingleton().isPresent()) {
            _requestBodyProperties.put("isSingleton", request.getIsSingleton());
        }
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemaDto getSchema(String schema) {
        return getSchema(schema, null);
    }

    public SchemaDto getSchema(String schema, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemaDto putSchema(String schema, UpdateSchemaDto request) {
        return putSchema(schema, request, null);
    }

    public SchemaDto putSchema(String schema, UpdateSchemaDto request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        if (request.getLabel().isPresent()) {
            _requestBodyProperties.put("label", request.getLabel());
        }
        if (request.getHints().isPresent()) {
            _requestBodyProperties.put("hints", request.getHints());
        }
        if (request.getContentsSidebarUrl().isPresent()) {
            _requestBodyProperties.put("contentsSidebarUrl", request.getContentsSidebarUrl());
        }
        if (request.getContentSidebarUrl().isPresent()) {
            _requestBodyProperties.put("contentSidebarUrl", request.getContentSidebarUrl());
        }
        if (request.getContentEditorUrl().isPresent()) {
            _requestBodyProperties.put("contentEditorUrl", request.getContentEditorUrl());
        }
        if (request.getValidateOnPublish().isPresent()) {
            _requestBodyProperties.put("validateOnPublish", request.getValidateOnPublish());
        }
        if (request.getTags().isPresent()) {
            _requestBodyProperties.put("tags", request.getTags());
        }
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteSchema(String schema) {
        deleteSchema(schema, null);
    }

    public void deleteSchema(String schema, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
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

    public SchemaDto putSchemaSync(String schema, SynchronizeSchemaDto request) {
        return putSchemaSync(schema, request, null);
    }

    public SchemaDto putSchemaSync(String schema, SynchronizeSchemaDto request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
                .addPathSegments("sync")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        if (request.getNoFieldDeletion().isPresent()) {
            _requestBodyProperties.put("noFieldDeletion", request.getNoFieldDeletion());
        }
        if (request.getNoFieldRecreation().isPresent()) {
            _requestBodyProperties.put("noFieldRecreation", request.getNoFieldRecreation());
        }
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemaDto putCategory(String schema, ChangeCategoryDto request) {
        return putCategory(schema, request, null);
    }

    public SchemaDto putCategory(String schema, ChangeCategoryDto request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
                .addPathSegments("category")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        if (request.getName().isPresent()) {
            _requestBodyProperties.put("name", request.getName());
        }
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemaDto putPreviewUrls(String schema, Map<String, String> request) {
        return putPreviewUrls(schema, request, null);
    }

    public SchemaDto putPreviewUrls(String schema, Map<String, String> request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
                .addPathSegments("preview-urls")
                .build();
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemaDto putScripts(String schema, SchemaScriptsDto request) {
        return putScripts(schema, request, null);
    }

    public SchemaDto putScripts(String schema, SchemaScriptsDto request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
                .addPathSegments("scripts")
                .build();
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemaDto putRules(String schema, ConfigureFieldRulesDto request) {
        return putRules(schema, request, null);
    }

    public SchemaDto putRules(String schema, ConfigureFieldRulesDto request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
                .addPathSegments("rules")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        if (request.getFieldRules().isPresent()) {
            _requestBodyProperties.put("fieldRules", request.getFieldRules());
        }
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemaDto publishSchema(String schema) {
        return publishSchema(schema, null);
    }

    public SchemaDto publishSchema(String schema, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
                .addPathSegments("publish")
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SchemaDto unpublishSchema(String schema) {
        return unpublishSchema(schema, null);
    }

    public SchemaDto unpublishSchema(String schema, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/apps")
                .addPathSegment(clientOptions.appName())
                .addPathSegments("schemas")
                .addPathSegment(schema)
                .addPathSegments("unpublish")
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SchemaDto.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
