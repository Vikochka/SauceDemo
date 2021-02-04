import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends Browser {

    String URL = "https://www.saucedemo.com";
    String password = "secret_sauce";

    @Test
    public void standard_userTest() {
        browser.get(URL);
        browser.findElement(By.id("user-name")).sendKeys("standard_user");
        browser.findElement(By.id("password")).sendKeys(password);
        browser.findElement(By.id("login-button")).click();
    }

    @Test
    public void locked_out_userTest() {
        browser.get(URL);
        browser.findElement(By.id("user-name")).sendKeys("locked_out_user");
        browser.findElement(By.id("password")).sendKeys(password);
        browser.findElement(By.id("login-button")).click();
    }

    @Test
    public void problem_userTest() {
        browser.get(URL);
        browser.findElement(By.id("user-name")).sendKeys("problem_user");
        browser.findElement(By.id("password")).sendKeys(password);
        browser.findElement(By.id("login-button")).click();
    }

    @Test
    public void performance_glitch_userTest() {
        browser.get(URL);
        browser.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
        browser.findElement(By.id("password")).sendKeys(password);
        browser.findElement(By.id("login-button")).click();
    }
}

