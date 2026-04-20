# example-jdbc-connector

A Java library for connecting securely to example database instances.

## Overview

This connector provides a `SocketFactory` for use with the JDBC PostgreSQL
driver. It uses TLS 1.3 and identity verification between the client and
the server-side proxy.

## Usage

Add the connector to your `pom.xml`:

```xml
<dependency>
    <groupId>com.example.cloud</groupId>
    <artifactId>example-jdbc-connector</artifactId>
    <version>1.2.10</version>
</dependency>
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.6.0</version>
</dependency>
```

Configure your data source with the socket factory:

```java
HikariConfig config = new HikariConfig();
config.setJdbcUrl("jdbc:postgresql:///mydb");
config.addDataSourceProperty("socketFactory",
    "com.example.connector.SocketFactory");
config.addDataSourceProperty("exampleInstanceName", "INSTANCE_NAME");
```

See `docs/configuration.md` for the full list of supported properties.

## Building

```
mvn clean package
```

## Testing

```
mvn test
```

## License

Apache-2.0
