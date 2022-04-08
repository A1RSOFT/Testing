package ru.digitalagro.qa.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class WebDriverDecorator implements WebDriver {

    private WebDriver driver;

    public WebDriverDecorator(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getOriginalDriver() {
        return this.driver;
    }

    public JavascriptExecutor getJavascriptExecutor() {
        return (JavascriptExecutor)this.driver;
    }

    public void get(String s) {
        this.driver.get(s);
    }

    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    public String getTitle() {
        return this.driver.getTitle();
    }

    public List<WebElement> findElements(By by) {
        return this.driver.findElements(by);
    }

    public WebElement findElement(By by) {
        WebElement webElement = this.driver.findElement(by);
        String bg = webElement.getCssValue("backgroundColor");
        JavascriptExecutor js = (JavascriptExecutor)this.driver;
        js.executeScript("arguments[0].style.border = '3px solid DeepPink'", new Object[]{webElement});

        try {
            Thread.sleep(750);
        } catch (InterruptedException var7) {
            var7.printStackTrace();
        }

        try {
            js.executeScript("arguments[0].style.border = '" + bg + "'", new Object[]{webElement});
        } catch (Exception var6) {
        }

        return webElement;
    }

    public String getPageSource() {
        return this.driver.getPageSource();
    }

    public void close() {
        this.driver.close();
    }

    public void quit() {
        this.driver.quit();
    }

    public Set<String> getWindowHandles() {
        return this.driver.getWindowHandles();
    }

    public String getWindowHandle() {
        return this.driver.getWindowHandle();
    }

    public TargetLocator switchTo() {
        return this.driver.switchTo();
    }

    public Navigation navigate() {
        return this.driver.navigate();
    }

    public Options manage() {
        return this.driver.manage();
    }

}
