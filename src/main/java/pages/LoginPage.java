package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(id = "mailbox:login")
    private WebElement loginField;

    @FindBy(id = "mailbox:password")
    private WebElement passwordField;

    @FindBy(id = "mailbox:submit")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage populateLoginPage(String login, String password) {
        fillLoginData(login, password);
        clickSubmitButton();
        return new MainPage(driver);
    }

    public void fillLoginData(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public boolean isSubmitButtonDisplayed() {
        return submitButton.isDisplayed();
    }
}
