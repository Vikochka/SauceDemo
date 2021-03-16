package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class CheckOutTest extends BaseTest {

    @Test()
    public void checkOutTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Backpack");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productsPage.goToShoppingCard();
        cartPage.setCheckoutButton();
        checkoutPage.checkout("Vasia", "Pupkin", "12345");
        checkoutPage.waitForChekOutPage();
    }

    @Test
    public void emptyFormTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Backpack");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productsPage.goToShoppingCard();
        cartPage.setCheckoutButton();
        checkoutPage.checkout("", "", "");
        checkoutPage.getErrorCheckOutMessage();
    }
}