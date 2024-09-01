package com.squidex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.squidex.api.core.ApiException;
import com.squidex.api.types.CreateSchemaDto;
import com.squidex.api.types.SchemaDto;
import com.squidex.api.types.SchemaType;
import com.squidex.api.types.StringFieldPropertiesDto;
import com.squidex.api.types.UpsertSchemaFieldDto;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.UUID;

@SuppressWarnings({"ConstantConditions"})
public class SchemasTests extends TestBase {
    private static final SquidexClient client = Utils.getClient().client();

    @Test
    public void should_create_and_fetch_schema() throws ApiException {
        // STEP: Create schema.
        CreateSchemaDto request = new CreateSchemaDto()
                .name(String.format("schema-%s", UUID.randomUUID()))
                .fields(Collections.singletonList(
                        new UpsertSchemaFieldDto()
                                .name("field1")
                                .properties(new StringFieldPropertiesDto())))
                .isPublished(true);

        SchemaDto schemaCreated = client.schemas().postSchema(request).execute();

        // STEP 2: Query schema.
        SchemaDto schema = client.schemas().getSchema(schemaCreated.getId()).execute();

        assertFalse(schemaCreated.getFields().isEmpty());
        assertEquals(request.getName(), schemaCreated.getName());
        assertEquals(request.getFields().get(0).getProperties().getClass(), schemaCreated.getFields().get(0).getProperties().getClass());
        assertEquals(SchemaType.DEFAULT, schema.getType());
        assertTrue(schema.getIsPublished());
    }
}
