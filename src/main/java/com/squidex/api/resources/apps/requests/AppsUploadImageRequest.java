package com.squidex.api.resources.apps.requests;

import com.squidex.api.core.ObjectMappers;

public final class AppsUploadImageRequest {
    private AppsUploadImageRequest() {}

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AppsUploadImageRequest;
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }
}
