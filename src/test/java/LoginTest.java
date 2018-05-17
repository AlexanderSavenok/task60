import base.TestBase;
import helpers.Utils;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends TestBase {

    private static String login = "seleniumtests10";
    private static String password = "060788avavav";

    @Test
    public void loginMailRuLogoutHyperlinkDisplayedTest() throws Exception {
        Utils.takeScreenshot(Utils.screenshotPath);
        MainPage mainPage = new LoginPage().login(login, password);

        assertTrue(mainPage.waitLogoutHyperlinkDisplayed(), "Logout hyperlink is not displayed");

        LoginPage loginPage = mainPage.logout();
        assertTrue(loginPage.isSubmitButtonDisplayed(), "Submit button is not displayed");
    }

    @Test
    public void loginMailRuInboxHyperlinkDisplayedTest() throws Exception {
        Utils.takeScreenshot(Utils.screenshotPath);
        MainPage mainPage = new LoginPage().login(login, password);

        assertTrue(mainPage.waitInboxHyperlinkDisplayed(), "Inbox hyperlink is not displayed");

        LoginPage loginPage = mainPage.logout();
        assertTrue(loginPage.isSubmitButtonDisplayed(), "Submit button is not displayed");
    }
}
