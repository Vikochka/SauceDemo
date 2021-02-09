package Tests;

import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    public void productShouldBeAvailableCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Backpack");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
    }
}
