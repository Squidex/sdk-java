package com.squidex.api;

import com.squidex.api.resources.contents.requests.ContentsGetContentRequest;
import com.squidex.api.resources.contents.requests.ContentsPostContentRequest;
import com.squidex.api.resources.schemas.requests.CreateSchemaDto;
import com.squidex.api.types.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("unchecked")
public class ContentsTests extends TestBase {
    private static final SquidexApiClient client = Utils.getClient().client();
    private static SchemaDto schema;

    @BeforeAll
    public static void setup() {
        CreateSchemaDto request = CreateSchemaDto.builder()
                .name(String.format("schema-%s", UUID.randomUUID()))
                .fields(Collections.singletonList(
                                UpsertSchemaFieldDto.builder()
                                        .name("field1")
                                        .properties(FieldPropertiesDto.string(StringFieldPropertiesDto.builder().build()))
                                        .build()
                        )
                )
                .isPublished(true)
                .build();

        schema = client.schemas().postSchema(request);
    }

    @Test
    public void should_create_and_fetch_content() {
        UUID id = UUID.randomUUID();

        Map<String, Map<String, Object>> dataItem = new HashMap<>();
        Map<String, Object> dataField = new HashMap<>();
        dataItem.put("field1", dataField);
        dataField.put("iv", id);

        ContentsPostContentRequest request =
                ContentsPostContentRequest.builder()
                        .body(dataItem)
                        .publish(true)
                        .build();

        ContentDto createdContent = client.contents().postContent(schema.getName(), request);

        ContentDto content = client.contents().getContent(schema.getName(), createdContent.getId());
        assertEquals(id.toString(), ((Map<String, Map<String, Object>>)content.getData()).get("field1").get("iv"));
        assertNotNull(content.getLastModified());
        assertNotNull(content.getLastModifiedBy());
        assertEquals("Published", content.getStatus());
    }

    @Test
    public void Should_create_and_fetch_unpublished_content() {
        UUID id = UUID.randomUUID();

        Map<String, Map<String, Object>> dataItem = new HashMap<>();
        Map<String, Object> dataField = new HashMap<>();
        dataItem.put("field1", dataField);
        dataField.put("iv", id);

        ContentsPostContentRequest request =
                ContentsPostContentRequest.builder()
                        .body(dataItem)
                        .build();

        ContentDto createdContent = client.contents().postContent(schema.getName(), request);



        ContentDto content = client.contents().getContent(schema.getName(), createdContent.getId(), ContentsGetContentRequest.builder().unpublished(true).build());
        assertEquals(id.toString(), ((Map<String, Map<String, Object>>)content.getData()).get("field1").get("iv"));
        assertNotNull(content.getLastModified());
        assertNotNull(content.getLastModifiedBy());
        assertEquals("Draft", content.getStatus());

    }
}
