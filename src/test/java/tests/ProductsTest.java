package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class ProductsTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    @Description("Add product to cart")
    public void productShouldBeAvailableCartTest() {
        loginPage.open();
        loginPage.login(login, password);
        productsPage.buyProduct("Sauce Labs Backpack");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productsPage.goToShoppingCard();
        productsPage.waitForProductsPage();
    }

    @Test(retryAnalyzer = Retry.class)
    @Description("Add product to cart")
    public void productShouldBeAvailableInCart() {
        loginPage
                .open()
                .login(login, password)
                .buyProduct("Sauce Labs Backpack")
                .buyProduct("Sauce Labs Bolt T-Shirt");
    }
}