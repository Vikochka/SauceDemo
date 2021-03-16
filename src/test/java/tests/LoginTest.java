package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @DataProvider(name = "Input for login")
    public Object[][] inputForLogin() {
        return new Object[][]{
                {"standard_user", "123h", "Epic sadface: Username and password do not match any user in this service"},
                {"", "dfdb", "Epic sadface: Username is required"},
        };
    }

    @Test(dataProvider = "Input for login")
    public void negativeLoginTest(String userName, String password, String errorMessage) {
        loginPage.open();
        loginPage.login(userName, password);
        Assert.assertEquals(loginPage.getErrorMessage(), errorMessage, "no error message");
    }

    @Test
    public void standardUserTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        loginPage.invisibilityOfErrorMessage();
        loginPage.waitForLoginPage();
    }

    @Test
    public void lockedOutUserTest() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        loginPage.VisibilityOfErrorMessage();
    }

    @Test
    public void problemUserTest() {
        loginPage.open();
        loginPage.login("problem_user", "secret_sauce");
        loginPage.invisibilityOfErrorMessage();
        loginPage.waitForLoginPage();
    }

    @Test
    public void performanceGlitchUserTest() {
        loginPage.open();
        loginPage.login("performance_glitch_user", "secret_sauce");
        loginPage.invisibilityOfErrorMessage();
        loginPage.waitForLoginPage();
    }
}