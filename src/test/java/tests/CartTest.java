package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class CartTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    @Description("Add element in cart")
    public void addElementTest() {
        loginPage.open();
        loginPage.login(login, password);
        productsPage.buyProduct("Sauce Labs Backpack");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productsPage.goToShoppingCard();
        cartPage.checkProduct("Sauce Labs Backpack");
        cartPage.checkProduct("Sauce Labs Bolt T-Shirt");
        cartPage.setCheckoutButton();
        cartPage.waitForCartPage();
    }

    @Test(retryAnalyzer = Retry.class)
    @Description("Remove element from cart and continue shopping")
    public void removeTest() {
        loginPage.open();
        loginPage.login(login, password);
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