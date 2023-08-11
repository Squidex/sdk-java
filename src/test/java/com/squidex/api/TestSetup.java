package com.squidex.api;

import com.squidex.api.resources.apps.requests.CreateAppDto;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.time.Instant;

public class TestSetup implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        ClientProvider client = Utils.getClient();

        System.out.println("SETUP");
        System.out.printf("Using <appName>=<%s>%n", client.client().clientOptions.appName());
        System.out.printf("Using <clientId>=<%s>%n", client.builder().clientId());
        System.out.printf("Using <clientSecret>=<%s>%n", client.builder().clientSecret());
        System.out.printf("Using <environment>=<%s>%n", client.client().clientOptions.environment().getUrl());

        this.waitForServer();

        try {
            client.client().apps().postApp(
                    CreateAppDto.builder()
                            .name(client.client().clientOptions.appName())
                            .build());
        } catch (Exception ex) {
            System.out.println("App probably already exists.");
            return;
        }
    }

    private void waitForServer() throws InterruptedException {
        ClientProvider client = Utils.getClient();

        String waitTime = System.getenv("CONFIG__WAIT");
        if (waitTime == null) {
            System.out.println("Waiting for server is skipped.");
            return;
        }

        int waitTimeMs = Integer.parseInt(waitTime);
        if (waitTimeMs <= 0) {
            System.out.println("Waiting for server is skipped.");
            return;
        }

        System.out.printf("Waiting %d seconds to access server.%n", waitTimeMs);

        Instant expires = Instant.now().plusMillis(waitTimeMs);
        while (true) {
            try {
                client.client().ping().getPing();
                break;
            } catch (Exception ex) {
                if (expires.isBefore(Instant.now())) {
                    throw new Error(String.format("Cannot connect to test system with: %s.", ex.getMessage()));
                }
            }

            //noinspection BusyWait
            Thread.sleep(100);
        }

        System.out.println("Connected to server.");
    }
}
