package com.adcalls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A custom exception that automatically logs to SLF4J when thrown.
 */
public class ExceptionLogger extends Exception {
    private static final Logger log = LoggerFactory.getLogger(ExceptionLogger.class);

    /**
     * Creates a new ExceptionLogger and logs the message, parameters, and stack trace.
     *
     * @param message the error message
     * @param params  optional parameters to log alongside the message
     */
    public ExceptionLogger(String message, Object... params) {
        super(message);

        String timestamp = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        log.error("{}: {}", timestamp, message);

        for (int i = 0; i < params.length; i++) {
            log.error("Parameter [{}]: {}", i, params[i]);
        }

        log.error("Stack trace:", this);
    }
}
