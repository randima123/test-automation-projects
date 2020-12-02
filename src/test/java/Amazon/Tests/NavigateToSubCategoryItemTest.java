package Amazon.Tests;

import Amazon.WebPages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NavigateToSubCategoryItemTest {

    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void navigateToSubCategoryItems(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateToSubCategoryItems();

    }

    @AfterTest
    public void close(){
    }


}
