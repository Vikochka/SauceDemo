package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

public class LoginPage extends BasePage {
    public static final By LOGIN_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");


    public LoginPage(WebDriver browser) {
        super(browser);
    }

    public LoginPage open() {
        browser.get("https://www.saucedemo.com");
        return this;
    }

    public ProductsPage login(String userName, String password) {
        browser.findElement(LOGIN_INPUT).sendKeys(userName);
        browser.findElement(PASSWORD_INPUT).sendKeys(password);
        browser.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(browser);
    }

    public String getErrorMessage() {
        return browser.findElement(ERROR_MESSAGE).getText();
    }

    public void waitForLoginPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product_label")));
        } catch (Exception ex) {
            Assert.fail("Page was not opened");
        }
    }
     public void invisibilityOfErrorMessage(){
        browser.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int errorMessage = browser.findElements(ERROR_MESSAGE).size();
        assertEquals(errorMessage,0,"Error message visibility");
        browser.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
     }

     public void VisibilityOfErrorMessage(){
        try {
           boolean isLockedUserName = browser.findElement(ERROR_MESSAGE).isDisplayed();
        }catch (NoSuchElementException ex){
            System.out.println("Error message invisibility");
        }
     }
}