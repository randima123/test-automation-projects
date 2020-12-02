package Amazon.Tests;

import Amazon.WebPages.HomePage;
import Amazon.WebPages.SubCatItemResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddItemToCartTest {

    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void addItemToCart(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateToSubCategoryItems();
        SubCatItemResultPage subCatItemResultPage = new SubCatItemResultPage(driver);
        subCatItemResultPage.clickOnSubCatItem();
        subCatItemResultPage.ClickOnAddToCartButton();
        boolean isAddedToCart = subCatItemResultPage.IsAddedToCart();
        Assert.assertTrue(isAddedToCart,"Error: Item not added to cart");
    }

    @AfterTest
    public void close(){
    }


}
