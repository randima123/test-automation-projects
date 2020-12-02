package MyStore.WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import MyStore.Common.DriverProvider.DriverProvider;

public class BasePageObject {


    private static final int SHORT_IMPLICIT_TIMEOUT = 150;
    protected WebDriverWait wait;
    protected WebDriver driver = DriverProvider.getActiveDriver();

    public BasePageObject(){
        wait = new WebDriverWait(driver,SHORT_IMPLICIT_TIMEOUT);
    }

    protected WebElement waitForVisibility(By locator){
//        WebElement element = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(locator));
//        return element;
        return null;
    }

}
