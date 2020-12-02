package MyStore.WebPages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyAccountPage extends BasePageObject {

    @FindBy(xpath = "//h1[@class='page-heading']")
    private WebElement myAccountHeading;

    public MyAccountPage(){
        PageFactory.initElements(driver,this);
    }

    public static MyAccountPage open(){
        return new MyAccountPage();
    }

    public boolean verifyMyAccountPage() {
        try {
            String accountHeading = myAccountHeading.getText();
            if ("My account".equalsIgnoreCase(accountHeading)) {
                return true;
            } else {
                //Error loading page
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

