//package archive;
//
//import Pages.BasePage;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class LoginPageFactory extends BasePage {
//
//    @FindBy(id="user-name")
//    WebElement userNameInput ;
//    @FindBy(id="password")
//    WebElement passwordInput;
//    @FindBy(id="login-button")
//    WebElement loginButton;
//    @FindBy(css="[data-test=error]")
//    WebElement errorMessage;
//
//
//
//    public LoginPageFactory(WebDriver browser){
//        super(browser);
//    }
//
//    public void open(){
//        browser.get("https://www.saucedemo.com");
//        PageFactory.initElements(browser,this);
//    }
//    public void login(String userName, String password){
//        userNameInput.sendKeys(userName);
//        passwordInput.sendKeys(password);
//        loginButton.click();
//    }
//
//    public  String getErrorMessage(){
//        return errorMessage.getText();
//    }
//}

