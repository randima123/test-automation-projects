package HomeDepot.WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeDecorPage {

    WebDriver driver;

    @FindBy(tagName = "h1")
    WebElement header;

    @FindBy(xpath = "    //div[@id='column_thd_c9f8']/descendant::div[@class='content'][1]/div/div[@id='column_thd_f553']/div/div/nav/div[4]/a[text()='Wall Decor']\n")
    WebElement wallDecorLink;

    public HomeDecorPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isHomeDecorPageOpened(){
        return header.getText().toString().equals("Home Decor");
    }

    public void navigateToWallDecor(){
        wallDecorLink.click();
    }

}
