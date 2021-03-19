package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MenuPage extends BasePage {
    public static final String MENU = "//*[text()='Open Menu']";
    public static final String MENU_BUTTONS = "//*[text()='%s']";
    public static final By PEEK_LABEL = By.cssSelector(".peek");
    public static final By ABOUT_LABEL = By.cssSelector(".is-1");
    public static final By LOGOUT_LABEL = By.id("user-name");
    public static final By RESET_APP_STATE_LABEL = By.cssSelector(".cart_item");

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
            wait.until(ExpectedConditions.visibilityOfElementLocated(PEEK_LABEL));
        } catch (Exception ex) {
            Assert.fail("ProductPage was not opened");
        }
    }

    public void waitForAbout() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ABOUT_LABEL));
        } catch (Exception ex) {
            Assert.fail("AboutPage was not opened");
        }
    }

    public void waitForLogout() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOGOUT_LABEL));
        } catch (Exception ex) {
            Assert.fail("LoginPage was not opened");
        }
    }

    public void waitForResetAppState() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(RESET_APP_STATE_LABEL));
        } catch (Exception ex) {
            Assert.fail("LoginPage was not opened");
        }
    }
}