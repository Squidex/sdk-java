package com.squidex.api;

import com.squidex.api.core.ApiException;
import com.squidex.api.types.CreateAppDto;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.time.Instant;

public class TestSetup implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        SquidexClient client = Utils.getClient().client();

        System.out.println("SETUP");
        System.out.printf("Using <appName>=<%s>%n", client.getAppName());
        System.out.printf("Using <clientId>=<%s>%n", client.getClientId());
        System.out.printf("Using <clientSecret>=<%s>%n", client.getClientSecret());
        System.out.printf("Using <baseUrl>=<%s>%n", client.getBaseUrl());

        this.waitForServer();

        try {
            CreateAppDto app = new CreateAppDto()
                .name(client.getAppName());

            client.apps().postApp(app).execute();
        } catch (ApiException ex) {
            if (ex.getCode() == 400) {
                System.out.println("App probably already exists.");
                return;
            } else {
                throw ex;
            }
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
    }
}
