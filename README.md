# Squidex Java Library

[![Maven Central](https://img.shields.io/maven-central/v/io.squidex/squidex)](https://central.sonatype.com/artifact/io.squidex/squidex)

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

## Major changes in 2.0

This SDK is mainly based on code generation, based on the OpenAPI specification from the Squidex API.

The initial version was built with fern: https://www.buildwithfern.com/. The main reason was the overall code quality and the support for discriminators. When the 1.0 version was released fern has not defined the pricing yet and unfortunately the current pricing is too expensive.

Therefore the SDK code generation was moved to OpenAPI Generator: (https://openapi-generator.tech/). The goal was to be as close to the previous version as possible without doing too much changes to the code generation templates. It was not possible to provide the same method signatures.

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
