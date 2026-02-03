# ExceptionLogger

A Java library for exception logging via SLF4J. Provides two ways to log exceptions:

1. **`ExceptionLogger`** — A self-logging exception class you throw directly
2. **`@LogExceptions`** — A Spring AOP annotation that automatically logs exceptions from any method in the annotated class

## Installation

### Gradle

```gradle
dependencies {
    implementation 'com.adcalls:exception-logger:1.1.0'
}
```

### Maven

```xml
<dependency>
    <groupId>com.adcalls</groupId>
    <artifactId>exception-logger</artifactId>
    <version>1.1.0</version>
</dependency>
```

## Usage

### Option 1: Throw ExceptionLogger directly

```java
int userId = 123;
string something = "something else";
throw new ExceptionLogger("Some error message", "userId="+userId, something);
```

### Option 2: Use @LogExceptions annotation (Spring Boot)

Annotate any Spring bean class and all exceptions thrown from its public methods will be logged automatically:

```java
@LogExceptions
@Service
public class SomeService {

    public void processSomething(String someId) {
        // if this method throws any exception, it will be
        // automatically logged with timestamp, message,
        // and full stack trace — then re-thrown as normal
    }
}
```

### Log output

`ExceptionLogger` log output:

```
ERROR -- 2026-02-02 16:31:13: Some exception message
ERROR -- Parameter [0]: userId=123
ERROR -- Parameter [1]: something else
ERROR -- Stack trace:
com.adcalls.ExceptionLogger: Some exception message
    at com.example.Main.main(Main.java:7)
```

`@LogExceptions` log output:

```
ERROR -- 2026-02-02 16:31:13: Exception in SomeService.processSomething(..): Some exception message
ERROR -- Stack trace:
java.lang.RuntimeException: Some exception message
    at com.example.SomeService.processSomething(SomeService.java:12)
```

## Note

- This library depends on `slf4j-api` only. Your application must provide its own SLF4J logging implementation (e.g., Logback, Log4j2).
- The `@LogExceptions` annotation requires Spring AOP (included in Spring Boot). It only intercepts public methods and does not intercept internal method calls within the same class.
