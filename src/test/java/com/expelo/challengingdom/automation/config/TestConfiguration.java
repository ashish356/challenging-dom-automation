package com.expelo.challengingdom.automation.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestConfiguration {

    public static final String INTERNAL_USER_TYPE="internal";
    public static final String EXTERNAL_USER_TYPE="external";

    private final String environment;
    private final String browser;
    private final String executionMode;


    public TestConfiguration(
         @Value("${test.environment:e1}") final String environment,
         @Value("${test.browser:Chrome}") final String browser,
         @Value("${test.executionMode:Local}")  final String executionMode) {
        this.environment = environment;
        this.browser = browser;
        this.executionMode = executionMode;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getBrowser() {
        return browser;
    }

    public String getExecutionMode() {
        return executionMode;
    }


}
