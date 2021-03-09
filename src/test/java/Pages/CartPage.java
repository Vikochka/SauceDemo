package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CartPage extends BasePage {

    public static final String CHECK_CART = "//*[text()='%s']";
    public static final By CHECKOUT_BUTTON = By.cssSelector(".btn_action");
    public static final String REMOVE_BUTTON = "//*[text()='%s']/../.././/button";
    public static final By CONTINUE_SHOPPING = By.xpath("//*[@class='cart_footer']/a[1]");

    public CartPage(WebDriver browser) {
        super(browser);
    }

    @Override
    public BasePage open() {
        return this;
    }

    public void checkProduct(String checkProductName) {
        browser.findElement(By.xpath(String.format(CHECK_CART, checkProductName))).isDisplayed();
    }

    public void setCheckoutButton() {
        ((TakesScreenshot)browser).getScreenshotAs(OutputType.BYTES);
        browser.findElement(CHECKOUT_BUTTON).click();
    }

    public void removeProduct(String removeProductName) {
        browser.findElement(By.xpath(String.format(REMOVE_BUTTON, removeProductName))).click();

    }

    public void continueShopping() {
        browser.findElement(CONTINUE_SHOPPING).click();
    }

    public void waitForCartPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn_primary")));
        } catch (Exception ex) {
            Assert.fail("CartPage wasn't opened");
        }
    }

    public void waitForContinueShopping() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".peek")));
        } catch (Exception ex) {
            Assert.fail("ProductsPage wasn't opened");
        }
    }
}