import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class ShoppingCart {
    @Test
    public void addElementTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        browser.get("https://www.saucedemo.com/inventory.html");
        browser.findElement(By.xpath("//*[text()='Sauce Labs Onesie']/../../..//button")).click();
        browser.findElement(By.xpath("//*[text()='Sauce Labs Fleece Jacket']/../../..//button")).click();
        browser.findElement(By.xpath("//*[@class='app_logo']/../..//*[@fill='currentColor']")).click();
        String result = browser.findElement(By.cssSelector(".subheader")).getText();
        Assert.assertEquals(result, "Your Cart");
        String sauceLabsFleeceJacket = browser.findElement(By.xpath("//*[@id='item_5_title_link']/div")).getText();
        Assert.assertEquals(sauceLabsFleeceJacket, "Sauce Labs Fleece Jacket");
        String sauceLabsOnesie = browser.findElement(By.xpath("//*[@id='item_2_title_link']/div")).getText();
        Assert.assertEquals(sauceLabsOnesie, "Sauce Labs Onesie");
        browser.quit();
    }
}
