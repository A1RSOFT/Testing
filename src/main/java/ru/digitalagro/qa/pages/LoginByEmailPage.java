package ru.digitalagro.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.digitalagro.qa.BasePage;
import ru.digitalagro.qa.utils.WebDriverDecorator;

public class LoginByEmailPage extends BasePage implements Loadable {
    public LoginByEmailPage(WebDriverDecorator driver) {
        super(driver);
    }

    private final By emailInput = By.xpath("//input[@data-test-id='login-email-input']");
    private final By passwordInput = By.xpath("//input[@data-test-id='login-password-input']");
    private final By enterButton = By.xpath("//button[@data-test-id='login-byEmail-button']");

    public WebElement getEmailInput() {
        return getWebElement(emailInput);
    }

    public WebElement getPasswordInput() {
        return getWebElement(passwordInput);
    }

    public WebElement getEnterButton() {
        return getWebElement(enterButton);
    }

    @Override
    public boolean pageIsLoaded() {
        return getEmailInput().isDisplayed();
    }

}
