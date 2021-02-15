package Tests;

import org.testng.annotations.Test;

public class MenuTest extends BaseTest {
    @Test
    public void allItemsTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        menuPage.menuButtons("All Items");
        menuPage.waitForAllItems();
    }

    @Test
    public void aboutTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        menuPage.menuButtons("About");
        menuPage.waitForAbout();
    }

    @Test
    public void logOutTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        menuPage.menuButtons("Logout");
        menuPage.waitForLoguot();
    }

    @Test
    public void resetAppStateTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        menuPage.menuButtons("Reset App State");
        menuPage.waitForResetAppState();
    }
}