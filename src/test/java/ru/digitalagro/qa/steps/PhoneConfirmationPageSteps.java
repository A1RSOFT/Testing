package ru.digitalagro.qa.steps;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.digitalagro.qa.pages.LoginByPhonePage;
import ru.digitalagro.qa.pages.PhoneConfirmationPage;
import ru.digitalagro.qa.pages.UserDashboardPage;

public class PhoneConfirmationPageSteps {
    public static UserDashboardPage enterPhoneConfirmationCode(String phoneConfirmationCode, PhoneConfirmationPage phoneConfirmationPage) {
        WebElement phoneConfirmationCodeInput = phoneConfirmationPage.getPhoneConfirmationCodeInput();
        phoneConfirmationCodeInput.sendKeys(phoneConfirmationCode);
        return new UserDashboardPage(phoneConfirmationPage.getDriver());
    }

    public static boolean errorCodeMessageIsDisplayed(PhoneConfirmationPage phoneConfirmationPage) {
        return phoneConfirmationPage.getErrorCodeMessageElement().isDisplayed();
    }

    public static void errorCodeMessageTextIsCorrect(PhoneConfirmationPage phoneConfirmationPage) {
        String message = phoneConfirmationPage.getErrorCodeMessageElement().getText();
        Assert.assertEquals(message, "Неверный код");
    }

}
