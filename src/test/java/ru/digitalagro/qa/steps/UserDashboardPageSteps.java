package ru.digitalagro.qa.steps;

import org.testng.Assert;
import ru.digitalagro.qa.pages.UserDashboardPage;

public class UserDashboardPageSteps {
    public static void isAuthorizedByPhone(UserDashboardPage userDashboardPage, String phoneNumber) {
        Assert.assertEquals(UtilsSteps.getPhoneNumberOnlyDigits(getPhoneNumber(userDashboardPage)), phoneNumber);
    }

    public static void isAuthorizedByEmail(UserDashboardPage userDashboardPage, String email) {
        Assert.assertEquals(getEmail(userDashboardPage), email);
    }

    public static String getPhoneNumber(UserDashboardPage userDashboardPage) {
        return userDashboardPage.getPhoneNumberElement().getText();
    }

    public static String getEmail(UserDashboardPage userDashboardPage) {
        return userDashboardPage.getEmailElement().getText();
    }

    public static void avatarButtonClick(UserDashboardPage userDashboardPage) {
        userDashboardPage.getAvatarElement().click();
    }

    public static void avatarLogoutItemClick(UserDashboardPage userDashboardPage) {
        userDashboardPage.getAvatarContextMenuLogoutItem().click();
    }
}
