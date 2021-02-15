package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    public static final String CHECK_CART = "//*[text()='%s']";
    public static final By CHECKOUT_BUTTON = By.cssSelector(".btn_action");
    public static final String REMOVE_BUTTON = "//*[text()='%s']/../.././/button";
    public static final By CONTINUE_SHOPPING= By.xpath("//*[@class='cart_footer']/a[1]");

    public CartPage(WebDriver browser) {
        super(browser);
    }

    public void checkProduct(String checkProductName) {
        browser.findElement(By.xpath(String.format(CHECK_CART, checkProductName))).isDisplayed();
    }

    public void setCheckoutButton() {
        browser.findElement(CHECKOUT_BUTTON).click();
    }

    public void removeProduct(String removeProductName) {
        browser.findElement(By.xpath(String.format(REMOVE_BUTTON, removeProductName))).click();

    }

    public void continueShopping(){
        browser.findElement(CONTINUE_SHOPPING).click();
    }

    public void waitForCartPage() {
        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn_primary")));
    }

    public void waitForContinueShopping() {
        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".peek")));
    }
}