package ru.digitalagro.qa;

import org.testng.annotations.BeforeSuite;

public class BaseTest {
    @BeforeSuite
    public void setUpProp() {
        System.setProperty("webdriver.chrome.driver", "/Users/p.batygin/Documents/Testing/src/test/resources/drivers.macos/chromedriver");
    }
}
