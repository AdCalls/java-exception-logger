# ExceptionLogger

A custom Java exception that automatically logs to SLF4J when thrown. It logs a timestamped message, any parameters you pass, and the full stack trace.

## Installation

### Gradle

```gradle
dependencies {
    implementation 'com.adcalls:exception-logger:1.0.1'
}
```

### Maven

```xml
<dependency>
    <groupId>com.adcalls</groupId>
    <artifactId>exception-logger</artifactId>
    <version>1.0.1</version>
</dependency>
```

## Usage

```java
throw new ExceptionLogger("Some error message", userId, secondParam, thirdParam);
```

This will automatically log:

```
ERROR -- 2026-02-02 16:31:13: Order processing failed
ERROR -- Parameter [0]: userId=123
ERROR -- Parameter [1]: secondParam=ABC-456
ERROR -- Parameter [2]: thirdParam
ERROR -- Stack trace:
org.example.ExceptionLogger: Order processing failed
    at org.example.Main.main(Main.java:7)
```

## Note

This library depends on `slf4j-api` only. Your application must provide its own SLF4J logging implementation (e.g., Logback, Log4j2).
