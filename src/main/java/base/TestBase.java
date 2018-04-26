package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class TestBase {

    protected WebDriver driver;

    public static String BASE_URL = "http://mail.ru";

    @BeforeEach
    public void init() {
        driver = new Driver().getWebDriver(BASE_URL);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
