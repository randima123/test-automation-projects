package HomeDepot.Tests;

import HomeDepot.WebPages.HomeDecorPage;
import HomeDepot.WebPages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NavigateToShopByCategoryPageTest {

    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void navigateToShopByCategoryPageTest(){
        HomePage homePage = new HomePage(driver);
        homePage.clickOnShopByCategoryDecorAndFurniture();
        HomeDecorPage homeDecorPage = new HomeDecorPage(driver);
        boolean isHomeDecorPageOpened = homeDecorPage.isHomeDecorPageOpened();
        Assert.assertTrue(isHomeDecorPageOpened, "Error: ShopByCategoryPage is not opened");
    }

    @Test
    public void addItemToCartTest(){
        HomePage homePage = new HomePage(driver);
        homePage.clickOnShopByCategoryDecorAndFurniture();
        HomeDecorPage homeDecorPage = new HomeDecorPage(driver);
        boolean isHomeDecorPageOpened = homeDecorPage.isHomeDecorPageOpened();
        Assert.assertTrue(isHomeDecorPageOpened, "Error: ShopByCategoryPage is not opened");



    }


    @AfterTest
    public void close(){
        driver.close();
    }

}
