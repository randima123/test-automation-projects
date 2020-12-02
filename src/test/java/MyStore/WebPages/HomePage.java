package MyStore.WebPages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePageObject {


    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public HomePage open(){
        return new HomePage();
    }


}
