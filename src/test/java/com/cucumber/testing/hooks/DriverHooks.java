package com.cucumber.testing.hooks;

import com.cucumber.testing.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverHooks {

    @Before
    public void setUpDriver() {
        DriverManager.setupDriver();
    }

    @After
    public void quitDriver() {
        DriverManager.quitDriver();
    }
}
