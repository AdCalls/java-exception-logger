# ExceptionLogger

A custom Java exception that automatically logs to SLF4J when thrown. It logs a timestamped message, any parameters you pass, and the full stack trace.

## Usage

```java
throw new ExceptionLogger("Order processing failed", userId, orderId, orderAmount);
```

This will automatically log:

```
ERROR -- 2026-02-02 16:31:13: Order processing failed
ERROR -- Parameter [0]: userId=123
ERROR -- Parameter [1]: orderId=ABC-456
ERROR -- Parameter [2]: 99.99
ERROR -- Stack trace:
org.example.ExceptionLogger: Order processing failed
    at org.example.Main.main(Main.java:7)
```

## Note

This library depends on `slf4j-api` only. Your application must provide its own SLF4J logging implementation (e.g., Logback, Log4j2).
