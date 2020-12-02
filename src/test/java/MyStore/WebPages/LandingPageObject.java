package MyStore.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LandingPageObject extends BasePageObject{

    private static final String homePageUrl = "http://www.automationpractice.com";

    @FindBy(xpath = "//div[@id='contact-link']")
    private WebElement button;

    public LandingPageObject(){
        driver.get(homePageUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    public static LandingPageObject open(){
        LandingPageObject homePageObject = new LandingPageObject();
        return homePageObject;
    }

}
