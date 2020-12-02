package Amazon.WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private static WebDriver driver;
    private static String homePageUrl = "https://www.amazon.com/";

    @FindBy(id = "nav-hamburger-menu")
    private WebElement menuIcon;

    @FindBy(xpath = "//a/div[text()='Sports and Outdoors']")
    private WebElement MainCategory;

    @FindBy(xpath = "//ul[@data-menu-id='15']/child::li/a[text()='Sports & Fitness']")
    private WebElement subCategory;

    @FindBy(id = "nav-cart-count")
    private WebElement cartCountSpan;

    public HomePage(WebDriver driver){
        this.driver=driver;
        driver.get(homePageUrl);
        PageFactory.initElements(driver, this);
    }

    public void navigateToSubCategoryItems(){
        menuIcon.click();
        MainCategory.click();
        subCategory.click();
    }

    public WebElement getCartCountSpan(){
        return this.cartCountSpan;
    }

    public int getCartItemCount(){
        return Integer.parseInt(cartCountSpan.getText().toString().trim());
    }

    public void navigateToHomePage(){
        driver.navigate().to("https://www.amazon.com/");
        PageFactory.initElements(driver, this);
    }

}
