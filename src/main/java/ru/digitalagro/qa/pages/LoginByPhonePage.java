package ru.digitalagro.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.digitalagro.qa.BasePage;
import ru.digitalagro.qa.utils.WebDriverDecorator;

public class LoginByPhonePage extends BasePage implements Loadable {
    public LoginByPhonePage(WebDriverDecorator driver) {
        super(driver);
    }

    private final By phoneNumberInput = By.xpath("//input[@data-test-id='login-phone-input']");
    private final By nextButton = By.xpath("//button[@data-test-id='login-next-button']");
    private final By moveToLoginByEmailPageButton = By.xpath("//div[@data-test-id='login-loginByEmail-button']");

    public WebElement getMoveToLoginByEmailPageButton() {
        return getWebElement(moveToLoginByEmailPageButton);
    }

    public WebElement getPhoneNumberInput() {
        return getWebElement(phoneNumberInput);
    }

    public WebElement getNextButton() {
        return getWebElement(nextButton);
    }

    @Override
    public boolean pageIsLoaded() {
        return getMoveToLoginByEmailPageButton().isDisplayed();
    }

}
