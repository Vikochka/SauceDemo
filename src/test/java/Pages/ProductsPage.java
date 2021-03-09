package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductsPage extends BasePage {
    public static final String ADD_TO_CARD = "//*[text()='%s']/ancestor::*[contains(@class,'inventory_item')]//button";
    public static final By SHOPPING_CARD_BUTTON = By.xpath("//*[@class='app_logo']/../..//*[@fill='currentColor']");

    public ProductsPage(WebDriver browser) {
        super(browser);
    }

    @Override
    public BasePage open() {
        return this;
    }

    public void buyProduct(String productName) {
        browser.findElement(By.xpath(String.format(ADD_TO_CARD, productName))).click();
    }

    public void goToShoppingCard() {
        browser.findElement(SHOPPING_CARD_BUTTON).click();
    }

    public void waitForProductsPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart_contents_container")));
        } catch (Exception ex) {
            Assert.fail("CartPage was not opened");
        }
    }
}