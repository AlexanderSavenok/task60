import base.TestBase;
import helpers.Utils;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends TestBase {

    private static String simpleFormatDate = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());

    @Test
    public void loginMailRuTest() throws Exception {
        String login = "seleniumtests10";
        String password = "060788avavav";
        String screenshotPath = String.format("src/main/resources/screenshots/loginMailRuTestScreenshot_%s.png", simpleFormatDate);

        Utils.takeScreenshot(screenshotPath);
        MainPage mainPage = new LoginPage().populateLoginPage(login, password);
        //этот метод содержит в себе waiter, но он только на js. Остальные варианты закоменчены.
        //они не работают и не знаю почему. валится на stale ref excep
        assertTrue(mainPage.waitLogoutHyperlinkDisplayed(), "Logout hyperlink is not displayed");

        assertTrue(mainPage.waitInboxHyperlinkDisplayed(), "Inbox hyperlink is not displayed");

        LoginPage loginPage = mainPage.logout();
        assertTrue(loginPage.isSubmitButtonDisplayed(), "Submit button is not displayed");
    }
}
