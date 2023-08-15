package com.squidex.api;

import com.squidex.api.resources.usermanagement.requests.CreateUserDto;
import com.squidex.api.types.UserDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

public class UserManagementTests extends TestBase {
    private final SquidexApiClient client = Utils.getClient().client();

    @Test()
    public void Should_create_and_fetch_user() {
        String email = String.format("user%s@email.com", UUID.randomUUID());

        CreateUserDto request = CreateUserDto.builder()
                .email(email)
                .displayName("Jane Smith")
                .password("1q2w3e$R")
                .addPermissions("permission1")
                .addPermissions("permission2")
                .build();

        UserDto createUser = client.userManagement().postUser(request);

        UserDto user = client.userManagement().getUser(createUser.getId());
        assertEquals(email, user.getEmail());
        assertEquals(createUser.getDisplayName(), user.getDisplayName());
    }
}
