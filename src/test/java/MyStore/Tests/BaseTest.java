package MyStore.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import MyStore.Common.DriverProvider.DriverProvider;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverProvider.getActiveDriver();
        driver.manage().deleteAllCookies();
    }

    @AfterMethod
    public void close(){
        DriverProvider.close();
    }


}
