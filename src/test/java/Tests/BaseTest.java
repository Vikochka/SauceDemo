package Tests;

import Pages.LoginPage;
import Pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver browser;
    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(browser);
        productsPage = new ProductsPage(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (browser != null) {
            browser.quit();
        }
    }
}
