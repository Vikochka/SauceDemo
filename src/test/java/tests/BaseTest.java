package tests;

import org.testng.ITestContext;
import pages.*;
import utils.CapabilitiesGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver browser;
    LoginPage loginPage;
    LoginPageFactory loginPageFactory;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    MenuPage menuPage;

    @BeforeMethod
    public void setup(ITestContext iTestContext, ITestResult testResult) {
        browser = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        iTestContext.setAttribute("driver",browser);
 //       testResult.getTestContext().setAttribute("driver", browser);
        loginPage = new LoginPage(browser);
        loginPageFactory = new LoginPageFactory(browser);
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