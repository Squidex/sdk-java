package com.squidex.api;

import org.junit.jupiter.api.extension.RegisterExtension;

public abstract  class TestBase {
    @RegisterExtension
    static TestSetup staticExtension = new TestSetup();
}
