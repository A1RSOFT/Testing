package ru.digitalagro.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.digitalagro.qa.BasePage;
import ru.digitalagro.qa.utils.WebDriverDecorator;

public class PhoneConfirmationPage extends BasePage implements Loadable {
    public PhoneConfirmationPage(WebDriverDecorator driver) {
        super(driver);
    }

    private final By phoneConfirmationCodeInput = By.xpath("//input[@data-test-id ='sms-code-input']");
    private final By errorCodeMessageElement = By.xpath("//p[@data-test-id ='sms-code-input-error']");

    public WebElement getPhoneConfirmationCodeInput() {
        return getWebElement(phoneConfirmationCodeInput);
    }

    public WebElement getErrorCodeMessageElement() {
        return getWebElement(errorCodeMessageElement);
    }

    @Override
    public boolean pageIsLoaded() {
        return getPhoneConfirmationCodeInput().isDisplayed();
    }
}

