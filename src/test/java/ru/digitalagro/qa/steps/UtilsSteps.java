package ru.digitalagro.qa.steps;

import ru.digitalagro.qa.BasePage;
import ru.digitalagro.qa.pages.Loadable;
import org.testng.Assert;

public class UtilsSteps {
    public static void pageIsLoadedCheck(Loadable page) {
        Assert.assertTrue(page.pageIsLoaded(), page + " не отображается");
    }

    public static String getPhoneNumberOnlyDigits(String phoneNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < phoneNumber.length(); i++) {
            char ch = phoneNumber.charAt(i);
            if(Character.isDigit(ch)){
                stringBuilder.append(ch);
            }
        }
        String unmaskedPhoneNumber = stringBuilder.toString();
        return unmaskedPhoneNumber.substring(unmaskedPhoneNumber.length() - 10);
    }

}
