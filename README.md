# Squidex Java Library

[![Maven Central](https://img.shields.io/maven-central/v/io.squidex/squidex)](https://central.sonatype.com/artifact/io.squidex/squidex) 
[![fern shield](https://img.shields.io/badge/%F0%9F%8C%BF-SDK%20generated%20by%20Fern-brightgreen)](https://github.com/fern-api/fern)

The Squidex Java SDK provides convenient access to the Squidex API from Java. 

## Documentation

API reference documentation is available [here](https://cloud.squidex.io/api/docs).

## Installation

### Gradle

Add the dependency in your `build.gradle`:

```groovy
dependencies {
    implementation 'io.squidex:squidex:0.x.x'
}
```

### Maven

Add the dependency in your `pom.xml`:

```xml
<dependency>
    <groupId>io.squidex</groupId>
    <artifactId>squidex</artifactId>
    <version>0.x.x</version>
</dependency>
```

## Usage

```java
SquidexApiClient squidex = SquidexApiClient.builder()
    .credentials("YOUR_CLIENT_ID", "YOUR_CLIENT_SECRET")
    .url("https://your.squidex-deployment")
    .appName("my-app")
    .build();

RulesDto rules = squidex.rules().getRules();

System.out.println("Received response from Squidex: " + rules);
```

## Staged Builders
The generated builders all follow the staged builder pattern. Read more [here](https://immutables.github.io/immutable.html#staged-builder). 
Staged builders only allow you to build the object once all required properties have been specified. 

## Beta status

This SDK is in beta, and there may be breaking changes between versions without a major version update. 
Therefore, we recommend pinning the package version to a specific version in your build.gradle file. 
This way, you can install the same version each time without breaking changes unless you are intentionally 
looking for the latest version.

## Contributing

While we value open-source contributions to this SDK, this library is generated programmatically.
Additions made directly to this library would have to be moved over to our generation code, otherwise 
they would be overwritten upon the next generated release. Feel free to open a PR as a proof of concept, 
but know that we will not be able to merge it as-is. We suggest opening an issue first to discuss with us!

On the other hand, contributions to the README are always very welcome!
