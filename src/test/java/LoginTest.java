import base.TestBase;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends TestBase {

    @Test
    public void loginMailRuTest() {
        String login = "seleniumtests10";
        String password = "060788avavav";

        MainPage mainPage = new LoginPage(driver).populateLoginPage(login, password);
        assertTrue(mainPage.isLogoutHyperlinkDisplayed(), "Logout hyperlink is not displayed");

        LoginPage loginPage = mainPage.logout();
        assertTrue(loginPage.isSubmitButtonDisplayed(), "Submit button is not displayed");
    }
}
