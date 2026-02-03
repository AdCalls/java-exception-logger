package com.adcalls;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a Spring bean class for automatic exception logging.
 * When any public method in this class throws an exception,
 * it will be logged via SLF4J and then re-thrown.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogExceptions {
}
