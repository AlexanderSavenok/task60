package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private WebDriver driver;

    protected WebDriver getWebDriver(String url) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        return getChromeDriver(url);
        }

    protected WebDriver getChromeDriver(String url) {
        driver = new ChromeDriver();
        driver.get(url);
        defaultSettings(driver);
        return driver;
    }

    private void defaultSettings(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }
}

