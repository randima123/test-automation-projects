package Amazon.Tests;

import Amazon.WebPages.HomePage;
import Amazon.WebPages.SubCatItemResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CartItemCountAfterAddingTest {

    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void cartItemCountAfterAdding(){

        HomePage homePage = new HomePage(driver);
        int previousCartItemCount = homePage.getCartItemCount();

        homePage.navigateToSubCategoryItems();
        SubCatItemResultPage subCatItemResultPage = new SubCatItemResultPage(driver);
        subCatItemResultPage.clickOnSubCatItem();
        subCatItemResultPage.ClickOnAddToCartButton();
        boolean isAddedToCart = subCatItemResultPage.IsAddedToCart();
        Assert.assertTrue(isAddedToCart,"Error: Item not added to cart");
        homePage.navigateToHomePage();
        int countAfterAdding = homePage.getCartItemCount();
        Assert.assertTrue(countAfterAdding > previousCartItemCount, "Error: Item was not increased.");
    }

    @AfterTest
    public void close(){
    }

}
