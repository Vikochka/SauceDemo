package Tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void wrongPassword() {
        loginPage.open();
        loginPage.login("standard_user", "123");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Error balablabla");
    }

    @Test
    public void emtyUserName() {
        loginPage.open();
        loginPage.login("", "");
        assertEquals(loginPage.getErrorMessage(), "_______________________", "Error balablabla");
    }
}
//    @Test
//    public void locked_out_userTest() {
//        browser.get(URL);
//        browser.findElement(By.id("user-name")).sendKeys("locked_out_user");
//        browser.findElement(By.id("password")).sendKeys(password);
//        browser.findElement(By.id("login-button")).click();
//    }
//
//    @Test
//    public void problem_userTest() {
//        browser.get(URL);
//        browser.findElement(By.id("user-name")).sendKeys("problem_user");
//        browser.findElement(By.id("password")).sendKeys(password);
//        browser.findElement(By.id("login-button")).click();
//    }
//
//    @Test
//    public void performance_glitch_userTest() {
//        browser.get(URL);
//        browser.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
//        browser.findElement(By.id("password")).sendKeys(password);
//        browser.findElement(By.id("login-button")).click();
//    }
//}
//
