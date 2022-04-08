package ru.digitalagro.qa.steps;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import ru.digitalagro.qa.pages.LoginByEmailPage;
import ru.digitalagro.qa.pages.LoginByPhonePage;
import ru.digitalagro.qa.pages.PhoneConfirmationPage;
import ru.digitalagro.qa.utils.WebDriverDecorator;

public class LoginByPhonePageSteps {
    public static LoginByPhonePage openLoginByPhonePage(WebDriverDecorator driver) {
        driver.get("http://auth.test1.assistance.da.local/sign_in");
        return new LoginByPhonePage(driver);
    }

    public static void enterPhoneNumber(String phoneNumber, LoginByPhonePage loginByPhonePage) {
        WebElement phoneNumberInput = loginByPhonePage.getPhoneNumberInput();
        phoneNumberInput.sendKeys(new CharSequence[]{Keys.HOME});
        phoneNumberInput.sendKeys(phoneNumber);
    }

    public static PhoneConfirmationPage clickNextButton(LoginByPhonePage loginByPhonePage) {
        WebElement nextButton = loginByPhonePage.getNextButton();
        nextButton.click();
        return new PhoneConfirmationPage(loginByPhonePage.getDriver());
    }

    public static LoginByEmailPage moveToLoginByEmailButtonClick(LoginByPhonePage loginByPhonePage) {
        loginByPhonePage.getMoveToLoginByEmailPageButton().click();
        return new LoginByEmailPage(loginByPhonePage.getDriver());
    }

}
