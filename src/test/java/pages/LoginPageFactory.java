package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class LoginPageFactory extends BasePage {
    @FindBy(id = "user-name")
    WebElement loginInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(id = "login-button")
    WebElement loginButton;
    @FindBy(css = "[data-test=error]")
    WebElement errorMessage;

    public LoginPageFactory(WebDriver browser) {
        super(browser);
    }

    public BasePage open() {
        browser.get("https://www.saucedemo.com");
        PageFactory.initElements(browser, this);
        return this;
    }

    public void login(String userName, String password) {
        loginInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void waitForLoginPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product_label")));
        } catch (Exception ex) {
            Assert.fail("Page was not opened");
        }
    }
}