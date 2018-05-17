package base;

import org.openqa.selenium.WebDriver;

public final class Driver {

    private static Driver instance = null;

    DriverConfiguration driverConfiguration = new DriverConfiguration();
    public WebDriver driver = initializeWebDriver();

    private Driver() { }

    public static Driver getInstance() {
        if(instance == null) {
            synchronized (Driver.class) {
                if(instance == null) {
                    instance = new Driver();
                }
            }
        }
        return instance;
    }

    public WebDriver initializeWebDriver() {
        if(driver == null) {
            driver = driverConfiguration.getWebDriver();
        }
        return driver;
    }
}

