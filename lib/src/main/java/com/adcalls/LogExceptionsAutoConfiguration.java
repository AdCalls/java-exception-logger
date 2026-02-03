package com.adcalls;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Auto-configuration that registers the {@link LogExceptionsAspect}
 * as a Spring bean and enables AspectJ auto-proxying.
 */
@Configuration
@EnableAspectJAutoProxy
public class LogExceptionsAutoConfiguration {

    /** Creates a new LogExceptionsAutoConfiguration. */
    public LogExceptionsAutoConfiguration() {}

    /**
     * Registers the {@link LogExceptionsAspect} bean.
     *
     * @return a new LogExceptionsAspect instance
     */
    @Bean
    public LogExceptionsAspect logExceptionsAspect() {
        return new LogExceptionsAspect();
    }
}
