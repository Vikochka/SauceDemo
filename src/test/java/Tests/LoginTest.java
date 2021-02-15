package Tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void standardUserTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        loginPage.waitForLoginPage();
    }

    @Test
    public void lockedOutUserTest() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        loginPage.waitForLoginPage();
    }

    @Test
    public void problemUserTest() {
        loginPage.open();
        loginPage.login("problem_user", "secret_sauce");
        loginPage.waitForLoginPage();
    }

    @Test
    public void performanceGlitchUserTest() {
        loginPage.open();
        loginPage.login("performance_glitch_user", "secret_sauce");
        loginPage.waitForLoginPage();
    }
}
