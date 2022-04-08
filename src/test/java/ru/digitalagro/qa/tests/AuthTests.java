package ru.digitalagro.qa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.digitalagro.qa.BaseTest;
import ru.digitalagro.qa.pages.LoginByEmailPage;
import ru.digitalagro.qa.pages.LoginByPhonePage;
import ru.digitalagro.qa.pages.PhoneConfirmationPage;
import ru.digitalagro.qa.pages.UserDashboardPage;
import ru.digitalagro.qa.steps.*;
import ru.digitalagro.qa.utils.WebDriverDecorator;

import java.time.Duration;

public class AuthTests extends BaseTest {

    private WebDriverDecorator driver;

    @BeforeMethod
    void setDriver() {
        WebDriver webDriver = new ChromeDriver();
        this.driver = new WebDriverDecorator(webDriver);
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void shutDown() {
        this.driver.close();
    }

    @Test
    public void PhoneAuthorization() {
        String phoneNumber = "9534790763";
        String phoneConfirmationCode = "111111";

        LoginByPhonePage loginByPhonePage = LoginByPhonePageSteps.openLoginByPhonePage(driver);
        UtilsSteps.pageIsLoadedCheck(loginByPhonePage);
        LoginByPhonePageSteps.enterPhoneNumber(phoneNumber, loginByPhonePage);
        PhoneConfirmationPage phoneConfirmationPage = LoginByPhonePageSteps.clickNextButton(loginByPhonePage);
        UtilsSteps.pageIsLoadedCheck(phoneConfirmationPage);
        UserDashboardPage userDashboardPage = PhoneConfirmationPageSteps.enterPhoneConfirmationCode("111111", phoneConfirmationPage);
        UtilsSteps.pageIsLoadedCheck(userDashboardPage);
        UserDashboardPageSteps.isAuthorizedByPhone(userDashboardPage, phoneNumber);
    }

    @Test
    public void EmailAuthorization() {
        String email = "killah19934@gmail.com";
        String password = "111111";

        LoginByPhonePage loginByPhonePage = LoginByPhonePageSteps.openLoginByPhonePage(driver);
        UtilsSteps.pageIsLoadedCheck(loginByPhonePage);
        LoginByEmailPage loginByEmailPage = LoginByPhonePageSteps.moveToLoginByEmailButtonClick(loginByPhonePage);
        UtilsSteps.pageIsLoadedCheck(loginByEmailPage);
        LoginByEmailPageSteps.enterEmail(email, loginByEmailPage);
        LoginByEmailPageSteps.enterPassword(password, loginByEmailPage);
        UserDashboardPage userDashboardPage = LoginByEmailPageSteps.enterButtonClick(loginByEmailPage);
        UtilsSteps.pageIsLoadedCheck(userDashboardPage);
        UserDashboardPageSteps.isAuthorizedByEmail(userDashboardPage, email);
    }

    @Test
    public void PhoneAuthorizationWithIncorrectCode() {
        String phoneNumber = "9534790763";
        String phoneConfirmationCode = "111112";

        LoginByPhonePage loginByPhonePage = LoginByPhonePageSteps.openLoginByPhonePage(driver);
        UtilsSteps.pageIsLoadedCheck(loginByPhonePage);
        LoginByPhonePageSteps.enterPhoneNumber(phoneNumber, loginByPhonePage);
        PhoneConfirmationPage phoneConfirmationPage = LoginByPhonePageSteps.clickNextButton(loginByPhonePage);
        UtilsSteps.pageIsLoadedCheck(phoneConfirmationPage);
        PhoneConfirmationPageSteps.enterPhoneConfirmationCode(phoneConfirmationCode, phoneConfirmationPage);
        PhoneConfirmationPageSteps.errorCodeMessageIsDisplayed(phoneConfirmationPage);
        PhoneConfirmationPageSteps.errorCodeMessageTextIsCorrect(phoneConfirmationPage);
    }

    @Test
    public void Logout() {
        String phoneNumber = "9534790763";
        String phoneConfirmationCode = "111111";

        LoginByPhonePage loginByPhonePage = LoginByPhonePageSteps.openLoginByPhonePage(driver);
        UtilsSteps.pageIsLoadedCheck(loginByPhonePage);
        LoginByPhonePageSteps.enterPhoneNumber(phoneNumber, loginByPhonePage);
        PhoneConfirmationPage phoneConfirmationPage = LoginByPhonePageSteps.clickNextButton(loginByPhonePage);
        UtilsSteps.pageIsLoadedCheck(phoneConfirmationPage);
        UserDashboardPage userDashboardPage = PhoneConfirmationPageSteps.enterPhoneConfirmationCode("111111", phoneConfirmationPage);
        UtilsSteps.pageIsLoadedCheck(userDashboardPage);
        UserDashboardPageSteps.avatarButtonClick(userDashboardPage);
        UserDashboardPageSteps.avatarLogoutItemClick(userDashboardPage);
        UtilsSteps.pageIsLoadedCheck(loginByPhonePage);
    }
}
