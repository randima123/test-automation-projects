package MyStore.WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AuthenticationPage extends BasePageObject {

    private static final String authenticationPagePageUrl = "http://www.automationpractice.com/index.php?controller=authentication";

    @FindBy(id = "email_create")
    private WebElement createEmailInputBox;

    @FindBy(id = "SubmitCreate")
    private WebElement createButton;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    private WebElement submitLoginButton;

    @FindBy(xpath = "//a[@title='Recover your forgotten password']")
    private WebElement forgetPasswordLink;

//    @FindBy(xpath = "//div[@id='create_account_error' and @style='display:none']")
//    private WebElement alreadyRegisteredEmailAlert;

    public AuthenticationPage(){
        driver.get(authenticationPagePageUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    public static AuthenticationPage open(){
        AuthenticationPage authenticationPageObject = new AuthenticationPage();
        return authenticationPageObject;
    }

    public void enterEmailAddress(String email){
        createEmailInputBox.sendKeys(email);
    }

    public void clickCreateAccount(){
        createButton.click();
    }

    public boolean checkAlreadyRegisteredEmail(){

        WebElement element = waitForVisibility(By.xpath("//div[@id='create_account_error']"));
        if(element.getText().contains("An account using this email address has already been registered.")){
            return true;
        }else {
            return false;
        }
    }

    public void login(String username, String password){
            email.sendKeys(username);
            this.password.sendKeys(password);
            submitLoginButton.click();
    }

    public void clickForgetPassword(){
        forgetPasswordLink.click();
    }

}
