package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CheckoutPage extends BasePage {

    public static final By FIRST_NAME_INPUT = By.id("first-name");
    public static final By LAST_NAME_INPUT = By.id("last-name");
    public static final By POSTAL_COD_INPUT = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.cssSelector(".cart_button");
    public static final By ERROR_CHECKOUT_MESSAGE = By.xpath("//*[@id='checkout_info_container']/div/form/h3");

    public CheckoutPage(WebDriver browser) {
        super(browser);
    }

    @Override
    public BasePage open() {
        return this;
    }

    public void checkout(String firstName, String lastName, String postelCode) {
        browser.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        browser.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        browser.findElement(POSTAL_COD_INPUT).sendKeys(postelCode);
        browser.findElement(CONTINUE_BUTTON).click();
    }

    public void getErrorCheckOutMessage() {
        browser.findElement(ERROR_CHECKOUT_MESSAGE).getText();
    }

    public void waitForChekOutPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".summary_subtotal_label")));
        } catch (Exception ex) {
            Assert.fail("Page wasn't opened");
        }
    }
}