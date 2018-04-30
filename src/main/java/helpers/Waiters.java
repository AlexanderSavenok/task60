package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {

    public static WebDriverWait getWaiter(WebDriver driver) {
        return getWaiter(driver, 10);
    }

    public static WebDriverWait getWaiter(WebDriver driver, int seconds) {
        return new WebDriverWait(driver, seconds);
    }
}
