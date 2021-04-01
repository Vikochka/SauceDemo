package tests;

import org.testng.ITestContext;
import pages.*;
import utils.CapabilitiesGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    public String login = "standard_user";
    public String password = "secret_sauce";
    public String user;

    WebDriver browser;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    MenuPage menuPage;

    @BeforeMethod
    public void setup(ITestContext iTestContext) {
        browser = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        iTestContext.setAttribute("driver", browser);
        user = System.getenv().getOrDefault("user", PropertyReader.getProperty("user"));
        password = System.getenv().getOrDefault("password", PropertyReader.getProperty("password"));

        loginPage = new LoginPage(browser);
        productsPage = new ProductsPage(browser);
        cartPage = new CartPage(browser);
        checkoutPage = new CheckoutPage(browser);
        menuPage = new MenuPage(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (browser != null) {
            browser.quit();
        }
    }
}