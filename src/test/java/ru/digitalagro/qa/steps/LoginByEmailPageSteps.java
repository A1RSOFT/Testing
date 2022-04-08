package ru.digitalagro.qa.steps;

import org.openqa.selenium.WebElement;
import ru.digitalagro.qa.pages.LoginByEmailPage;
import ru.digitalagro.qa.pages.UserDashboardPage;

public class LoginByEmailPageSteps {
    public static void enterEmail(String email, LoginByEmailPage loginByEmailPage) {
        WebElement emailInput = loginByEmailPage.getEmailInput();
        emailInput.sendKeys(email);
    }

    public static void enterPassword(String password, LoginByEmailPage loginByEmailPage) {
        WebElement passwordInput = loginByEmailPage.getPasswordInput();
        passwordInput.sendKeys(password);
    }

    public static UserDashboardPage enterButtonClick(LoginByEmailPage loginByEmailPage) {
        WebElement enterButton = loginByEmailPage.getEnterButton();
        enterButton.click();
        return new UserDashboardPage(loginByEmailPage.getDriver());
    }
}
