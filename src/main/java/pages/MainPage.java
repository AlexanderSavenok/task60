package pages;

import base.PageBase;
import helpers.Waiters;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends PageBase {

    private static final By LOGOUT_HYPERLINK = By.id("PH_logoutLink");
    private static final By INBOX_HYPERLINK = By.cssSelector("div.b-nav__item_unread");

    public LoginPage logout() {
        driver.findElement(LOGOUT_HYPERLINK).click();
        return new LoginPage();
    }

    public boolean waitInboxHyperlinkDisplayed() {
        WebDriverWait wait = Waiters.getWaiter(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(INBOX_HYPERLINK));

        return driver.findElement(INBOX_HYPERLINK).isDisplayed();
    }

    public boolean waitLogoutHyperlinkDisplayed() {
        //no one from this waiters does not work
        //WebDriverWait wait = Waiters.getWaiter(driver);
        //wait.until(ExpectedConditions.presenceOfElementLocated(LOGOUT_HYPERLINK));
        //wait.until(ExpectedConditions.visibilityOf(logoutHyperlink));
        //wait.until((ExpectedCondition<WebElement>) webDriver -> driver.findElement(LOGOUT_HYPERLINK));

        //only this way helps. But is looks like Thread.sleep approach.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");

        return driver.findElement(LOGOUT_HYPERLINK).isDisplayed();
    }
}
