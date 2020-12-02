package MyStore.WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.ws.WebEndpoint;

public class ForgotPasswordPage extends BasePageObject {

    @FindBy(xpath = "//h1[@class='page-subheading']")
    private WebElement pageSubHeading;

    @FindBy(xpath = "//form[@id='form_forgotpassword']/descendant::button[@type='submit']")
    private WebElement retrievePwdButton;

    @FindBy(id = "email")
    private WebElement email;

    public ForgotPasswordPage() {
        PageFactory.initElements(driver, this);
    }

    public static ForgotPasswordPage open() {
        return new ForgotPasswordPage();
    }

    public boolean verifyForgotPwdPage() {
        try {
            String title = pageSubHeading.getText();
            if ("Forgot your password?".equalsIgnoreCase(title)) {
                return true;
            } else {
                return false;
            }
        } catch (
                NoSuchElementException ex) {
            //Error log
            ex.printStackTrace();
            return false;
        }

    }

    public void enterEmail(String email) {
        this.email.sendKeys(email);
    }

    public void clickRetrievePwdButton() {
        this.retrievePwdButton.click();
    }

    public boolean verifySentEmail() {
        try {
            String text = driver.findElement(By.className("alert-success")).getText();
            if (text.contains("A confirmation email has been sent to your address")) {
                return true;
            } else {
                return false;
            }
        } catch (
                NoSuchElementException ex) {
            //Error log
            ex.printStackTrace();
            return false;
        }
    }

}
