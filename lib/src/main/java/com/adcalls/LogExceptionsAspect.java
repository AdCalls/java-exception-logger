package com.adcalls;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Spring AOP aspect that intercepts exceptions thrown from classes
 * annotated with {@link LogExceptions} and logs them via SLF4J.
 *
 * @see LogExceptions
 */
@Aspect
public class LogExceptionsAspect {

    /** Creates a new LogExceptionsAspect. */
    public LogExceptionsAspect() {}

    private static final DateTimeFormatter FORMATTER =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Logs exceptions thrown from any public method in a class annotated with {@link LogExceptions}.
     *
     * @param joinPoint the join point at which the exception was thrown
     * @param ex        the thrown exception
     */
    @AfterThrowing(
        pointcut = "@within(com.adcalls.LogExceptions)",
        throwing = "ex"
    )
    public void logException(JoinPoint joinPoint, Throwable ex) {
        Logger log = LoggerFactory.getLogger(joinPoint.getTarget().getClass());

        String timestamp = LocalDateTime.now().format(FORMATTER);
        String methodName = joinPoint.getSignature().toShortString();

        log.error("{}: Exception in {}: {}", timestamp, methodName, ex.getMessage());
        log.error("Stack trace:", ex);
    }
}
