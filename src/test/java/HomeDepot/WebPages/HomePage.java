package HomeDepot.WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private static WebDriver driver;

    private static String homePageUrl = "https://www.homedepot.com/";

    @FindBy(xpath = "//div[@data-module-link-id='Item_thd_a13c']")
    WebElement shopByCategoryDecorAndFurniture;

    public HomePage(WebDriver driver){
        this.driver=driver;
        driver.get(homePageUrl);
        PageFactory.initElements(driver, this);
    }

    public void clickOnShopByCategoryDecorAndFurniture(){
        shopByCategoryDecorAndFurniture.click();
    }

}
