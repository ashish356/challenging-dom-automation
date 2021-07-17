package com.expelo.challengingdom.automation.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestConfiguration {

    private final String environment;
    private final String browser;


    public TestConfiguration(
         @Value("${test.environment:e1}") final String environment,
         @Value("${test.browser:Chrome}") final String browser) {
        this.environment = environment;
        this.browser = browser;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getBrowser() {
        return browser;
    }


}
