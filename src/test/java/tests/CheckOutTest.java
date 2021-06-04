package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class CheckOutTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    @Description("Order placement")
    public void checkOutTest() {
        loginPage.open();
        loginPage.login(login, password);
        productsPage.buyProduct("Sauce Labs Backpack");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productsPage.goToShoppingCard();
        cartPage.setCheckoutButton();
        checkoutPage.checkout("Vasia", "Pupkin", "12345");
        checkoutPage.waitForChekOutPage();
    }

    @Test(retryAnalyzer = Retry.class)
    @Description("Сheck if the form is empty")
    public void emptyFormTest() {
        loginPage.open();
        loginPage.login(login, password);
        productsPage.buyProduct("Sauce Labs Backpack");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productsPage.goToShoppingCard();
        cartPage.setCheckoutButton();
        checkoutPage.checkout("", "", "");
        checkoutPage.getErrorCheckOutMessage();
    }
}