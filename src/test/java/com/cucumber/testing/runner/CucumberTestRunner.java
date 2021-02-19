package com.cucumber.testing.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports",
                  "json:target/cucumber-reports/CucumberTests.json",
                  "junit:target/cucumber-reports/CucumberTests.xml"},
        monochrome = true,
        tags = "@smoke",
        glue = "com.cucumber.testing",
        features = "classpath:com/cucumber/testing" +
                "/features"
)
public class CucumberTestRunner {
}
