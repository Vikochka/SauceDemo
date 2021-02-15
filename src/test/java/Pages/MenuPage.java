package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage extends BasePage {
    public static final String MENU = "//*[text()='Open Menu']";
    public static final String MENU_BUTTONS = "//*[text()='%s']";

//    public static final String ALL_ITEMS_BUTTON = "//*[text()='All Items']";
//    public static final String ABOUT_BUTTON = "//*[text()='About']";
//    public static final String LOGUOT_BUTTON = "//*[text()='Logout']";
//    public static final String RESET_APP_STATE_BUTTON = "//*[text()='Reset App State']";

    public MenuPage(WebDriver browser) {
        super(browser);
    }

    public void menuButtons(String buttonName) {
        browser.findElement(By.xpath(MENU)).click();
        browser.findElement(By.xpath(String.format(MENU_BUTTONS, buttonName))).click();

    }

    public void waitForAllItems() {
        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".peek")));
    }

    public void waitForAbout() {
        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".is-1")));
    }

    public void waitForLoguot() {
        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
    }

    public void waitForResetAppState() {
        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cart_item")));
    }

}