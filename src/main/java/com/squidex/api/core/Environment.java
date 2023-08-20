package com.squidex.api.core;

public final class Environment {
    public static final Environment DEFAULT = new Environment("https://cloud.squidex.io");

    private final String url;

    private Environment(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public static Environment custom(String url) {
        return new Environment(url);
    }
}
