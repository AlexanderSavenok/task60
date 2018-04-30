package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public final class Driver {

    private static WebDriver driver;

    private Driver() {

    }

    public static WebDriver getDriver() {
        if(driver == null) {
            synchronized (Driver.class) {
                if(driver == null) {
                        driver = getChromeDriver();
                }
            }
        }
        return driver;
    }

    private static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        defaultSettings(driver);
        return driver;
    }

    private static void defaultSettings(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
    }
}

