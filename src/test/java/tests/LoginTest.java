package tests;

import io.qameta.allure.Description;
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

    @Test(dataProvider = "Input for login",retryAnalyzer = Retry.class)
    public void negativeLoginTest(String userName, String password, String errorMessage) {
        loginPage.open();
        loginPage.login(userName, password);
        Assert.assertEquals(loginPage.getErrorMessage(), errorMessage, "no error message");
    }

    @Test(retryAnalyzer = Retry.class)
    @Description("Check login: standard_user for login ")
    public void standardUserTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        loginPage.invisibilityOfErrorMessage();
        loginPage.waitForLoginPage();
    }

    @Test(retryAnalyzer = Retry.class)
    @Description("Check login: locked_out_user for login ")
    public void lockedOutUserTest() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        loginPage.VisibilityOfErrorMessage();
    }

    @Test(retryAnalyzer = Retry.class)
    @Description("Check login: problem_user for login ")
    public void problemUserTest() {
        loginPage.open();
        loginPage.login("problem_user", "secret_sauce");
        loginPage.invisibilityOfErrorMessage();
        loginPage.waitForLoginPage();
    }

    @Test(retryAnalyzer = Retry.class)
    @Description("Check login: performance_glitch_user for login ")
    public void performanceGlitchUserTest() {
        loginPage.open();
        loginPage.login("performance_glitch_user", "secret_sauce");
        loginPage.invisibilityOfErrorMessage();
        loginPage.waitForLoginPage();
    }
}