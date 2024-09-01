package com.squidex.api;

import com.squidex.api.types.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SuppressWarnings({"unchecked", "ConstantConditions"})
public class ContentsTests extends TestBase {
    private static final SquidexClient client = Utils.getClient().client();
    private static SchemaDto schema;

    @BeforeAll
    public static void setup() {
        CreateSchemaDto request = new CreateSchemaDto()
            .name(String.format("schema-%s", UUID.randomUUID()))
            .fields(Collections.singletonList(
                new UpsertSchemaFieldDto()
                    .name("field1")
                    .properties(new StringFieldPropertiesDto())))
            .isPublished(true);

        schema = client.schemas().postSchema(request).execute();
    }

    @Test
    public void should_create_and_fetch_content() {
        UUID id = UUID.randomUUID();

        // STEP 1: Create content
        Map<String, Map<String, Object>> dataItem = Map.of(
            "field1", Map.of(
                "iv", (Object) id.toString()
            )
        );

        ContentDto createdContent = client.contents().postContent(schema.getName(), dataItem).publish(true).execute();

        // STEP 2: Get content
        ContentDto contentItem = client.contents().getContent(schema.getName(), createdContent.getId()).execute();
        Map<String, Map<String, Object>> contentData = (Map<String, Map<String, Object>>) contentItem.getData();

        assertEquals(id.toString(), contentData.get("field1").get("iv"));
        assertNotNull(contentItem.getLastModified());
        assertNotNull(contentItem.getLastModifiedBy());
        assertEquals("Published", contentItem.getStatus());
    }

    @Test
    public void Should_create_and_fetch_unpublished_content() {
        UUID id = UUID.randomUUID();

        // STEP 1: Create content
        Map<String, Map<String, Object>> dataItem = Map.of(
            "field1", Map.of(
                "iv", (Object) id.toString()
            )
        );

        ContentDto createdContent = client.contents().postContent(schema.getName(), dataItem).execute();

        // STEP 2: Get content
        ContentDto contentItem = client.contents().getContent(schema.getName(), createdContent.getId()).unpublished(true).execute();
        Map<String, Map<String, Object>> contentData = (Map<String, Map<String, Object>>) contentItem.getData();

        assertEquals(id.toString(), contentData.get("field1").get("iv"));
        assertNotNull(contentItem.getLastModified());
        assertNotNull(contentItem.getLastModifiedBy());
        assertEquals("Draft", contentItem.getStatus());
    }
}
