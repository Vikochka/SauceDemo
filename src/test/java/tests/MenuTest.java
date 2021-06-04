package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class MenuTest extends BaseTest {
    @Test
    @Description("Checking the transition to All Item page ")
    public void allItemsTest() {
        loginPage.open();
        loginPage.login(login, password);
        menuPage.menuButtons("All Items");
        menuPage.waitForAllItems();
    }

    @Test(retryAnalyzer = Retry.class)
    @Description("Checking the transition to About page")
    public void aboutTest() {
        loginPage.open();
        loginPage.login(login, password);
        menuPage.menuButtons("About");
        menuPage.waitForAbout();
    }

    @Test(retryAnalyzer = Retry.class)
    @Description("Checking the transition to Login page")
    public void logOutTest() {
        loginPage.open();
        loginPage.login(login, password);
        menuPage.menuButtons("Logout");
        menuPage.waitForLogout();
    }

    @Test(retryAnalyzer = Retry.class)
    @Description("Checking the transition to Reset App State page")
    public void resetAppStateTest() {
        loginPage.open();
        loginPage.login(login, password);
        menuPage.menuButtons("Reset App State");
        menuPage.waitForResetAppState();
    }
}