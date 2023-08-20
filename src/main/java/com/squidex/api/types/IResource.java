package com.squidex.api.types;

import java.util.Map;

public interface IResource {
    Map<String, ResourceLink> getLinks();
}
