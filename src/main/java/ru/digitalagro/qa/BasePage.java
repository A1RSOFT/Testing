package ru.digitalagro.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.digitalagro.qa.utils.WebDriverDecorator;

public abstract class BasePage {
    protected WebDriverDecorator driver;

    public BasePage(WebDriverDecorator driver) {
        this.driver = driver;
    }

    public WebDriverDecorator getDriver() {
        return driver;
    }

    public WebElement getWebElement(By by) {
        return this.driver.findElement(by);
    }

}
