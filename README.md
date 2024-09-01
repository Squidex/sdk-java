# Squidex Java Library

[![Maven Central](https://img.shields.io/maven-central/v/io.squidex/squidex)](https://central.sonatype.com/artifact/io.squidex/squidex) 
[![fern shield](https://img.shields.io/badge/%F0%9F%8C%BF-SDK%20generated%20by%20Fern-brightgreen)](https://github.com/fern-api/fern)

The Squidex Java SDK provides convenient access to the Squidex API from Java. 

## Documentation

API reference documentation is available [here](https://docs.squidex.io/02-documentation/software-development-kits/java).

## Installation

### Gradle

Add the dependency in your `build.gradle`:

```groovy
dependencies {
    implementation 'io.squidex:squidex:1.0.0'
}
```

### Maven

Add the dependency in your `pom.xml`:

```xml
<dependency>
    <groupId>io.squidex</groupId>
    <artifactId>squidex</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage

```java
SquidexClient squidex = SquidexClient.builder()
    .appName("my-app")
    .clientId("your-app:default")
    .clientSecret("xxx")
    .url("https://your.squidex-deployment")
    .build();

RulesDto rules = squidex.rules().getRules();

System.out.println("Received response from Squidex: " + rules);
```

## Staged Builders (v1.X)

The generated builders all follow the staged builder pattern. Read more [here](https://immutables.github.io/immutable.html#staged-builder). 
Staged builders only allow you to build the object once all required properties have been specified. 

## Custom Templates

### `api.mustache`

* Use `vendorExtensions.x-method-name` for the actual method name.
* Use `vendorExtensions.f-field-name` for the actual header name.

### `models.mustache`

* Remove all code where properties for the discriminator is generated.

### `JSON.mustache`

* Fix the serialization with `registerTypeSelector` to select the type based on the discriminator mapping.
* Fix the serialization with `registerPostProcessor` to add the discriminator properties to the generated JSON.

## Contributing

While we value open-source contributions to this SDK, this library is generated programmatically.
Additions made directly to this library would have to be moved over to our generation code, otherwise 
they would be overwritten upon the next generated release. Feel free to open a PR as a proof of concept, 
but know that we will not be able to merge it as-is. We suggest opening an issue first to discuss with us!

On the other hand, contributions to the README are always very welcome!
