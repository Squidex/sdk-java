package com.squidex.api;

import com.squidex.api.types.CreateUserDto;
import com.squidex.api.types.UserDto;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserManagementTests extends TestBase {
    private static final SquidexClient client = Utils.getClient().client();

    @Test()
    public void Should_create_and_fetch_user() {
        String email = String.format("user%s@email.com", UUID.randomUUID());

        // STEP 1: Create User.
        CreateUserDto request = new CreateUserDto()
                .email(email)
                .displayName("Jane Smith")
                .password("1q2w3e$R")
                .permissions(Collections.singletonList("permission1"));

        UserDto createUser = client.userManagement().postUser(request).execute();

        // STEP 2: Query User.
        UserDto user = client.userManagement().getUser(createUser.getId()).execute();
        assertEquals(email, user.getEmail());
        assertEquals(createUser.getDisplayName(), user.getDisplayName());
    }
}
