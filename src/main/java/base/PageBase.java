package base;

import helpers.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

    protected WebDriver driver = Driver.getInstance().driver;
    protected WebDriverWait wait = new Waiters().getWaiter();
}
