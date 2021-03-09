package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MenuPage extends BasePage {
    public static final String MENU = "//*[text()='Open Menu']";
    public static final String MENU_BUTTONS = "//*[text()='%s']";

    public MenuPage(WebDriver browser) {
        super(browser);
    }

    @Override
    public BasePage open() {
        return this;
    }

    public void menuButtons(String buttonName) {
        browser.findElement(By.xpath(MENU)).click();
        browser.findElement(By.xpath(String.format(MENU_BUTTONS, buttonName))).click();

    }

    public void waitForAllItems() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".peek")));
        } catch (Exception ex) {
            Assert.fail("ProductPage was not opened");
        }
    }

    public void waitForAbout() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".is-1")));
        } catch (Exception ex) {
            Assert.fail("AboutPage was not opened");
        }
    }

    public void waitForLoguot() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        } catch (Exception ex) {
            Assert.fail("LoginPage was not opened");
        }
    }

    public void waitForResetAppState() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cart_item")));
        } catch (Exception ex) {
            Assert.fail("LoginPage was not opened");
        }
    }
}