package com.squidex.api;

import com.squidex.api.resources.schemas.requests.CreateSchemaDto;
import com.squidex.api.types.*;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class SchemasTests extends TestBase {
    private static final SquidexApiClient client = Utils.getClient().client();

    @Test
    public void should_create_and_fetch_schema() {
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

        SchemaDto createdSchema = client.schemas().postSchema(request);

        SchemaDto schema = client.schemas().getSchema(createdSchema.getId());
        assertFalse(createdSchema.getFields().isEmpty());
        assertEquals(request.getName(), createdSchema.getName());
        assertEquals(request.getFields().get().get(0).getProperties().getClass(), createdSchema.getFields().get(0).getProperties().getClass());
        assertEquals(SchemaType.DEFAULT, schema.getType());
        assertTrue(schema.getIsPublished());
    }
}
