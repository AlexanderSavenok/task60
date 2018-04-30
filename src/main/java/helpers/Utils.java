package helpers;

import base.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;

public class Utils {

    private static WebDriver driver = Driver.getDriver();

    public static void takeScreenshot(String fileWithPath) throws Exception{
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(fileWithPath);
        Files.copy(srcFile.toPath(), destFile.toPath());
    }
}
