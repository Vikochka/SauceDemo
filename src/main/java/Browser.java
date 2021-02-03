import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class Browser {
    private static String PATH_TO_DRIVER = "src/test/resources/chromedriver.exe";
    public WebDriver browser;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", PATH_TO_DRIVER);
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterClass() {
        String result = browser.findElement(By.cssSelector(".footer_copy")).getText();
        Assert.assertEquals(result, "© 2020 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy");
        browser.quit();
    }
}
