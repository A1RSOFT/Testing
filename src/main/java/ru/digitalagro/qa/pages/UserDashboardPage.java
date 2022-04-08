package ru.digitalagro.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.digitalagro.qa.BasePage;
import ru.digitalagro.qa.utils.WebDriverDecorator;

public class UserDashboardPage extends BasePage implements Loadable {
    public UserDashboardPage(WebDriverDecorator driver) {
        super(driver);
    }

    private final By phoneNumberElement = By.xpath("//div[@class='phone']");
    private final By emailElement = By.xpath("//div[@class='email false']");
    private final By avatarElement = By.xpath("//figure[@data-garden-id='avatars.avatar']");
    private final By avatarContextMenuLogoutItem = By.xpath("//li[@id='downshift-0-item-1']");

    public WebElement getAvatarContextMenuLogoutItem() {
        return getWebElement(avatarContextMenuLogoutItem);
    }

    public WebElement getPhoneNumberElement() {
        return getWebElement(phoneNumberElement);
    }

    public WebElement getEmailElement() {
        return getWebElement(emailElement);
    }

    public WebElement getAvatarElement() {
        return getWebElement(avatarElement);
    }

    @Override
    public boolean pageIsLoaded() {
        return getPhoneNumberElement().isDisplayed();
    }
}