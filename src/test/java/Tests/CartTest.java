package Tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class CartTest extends BaseTest {

    @Test
    public void addElementTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Backpack");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productsPage.goToShoppingCard();
        cartPage.checkProduct("Sauce Labs Backpack");
        cartPage.checkProduct("Sauce Labs Bolt T-Shirt");
        cartPage.setCheckoutButton();
        cartPage.waitForCartPage();
    }

    @Test
    public void removeTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Backpack");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productsPage.goToShoppingCard();
        cartPage.checkProduct("Sauce Labs Backpack");
        cartPage.checkProduct("Sauce Labs Bolt T-Shirt");
        cartPage.removeProduct("Sauce Labs Bolt T-Shirt");
        cartPage.continueShopping();
        cartPage.waitForContinueShopping();
    }
}