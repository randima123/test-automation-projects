package Amazon.WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubCatItemResultPage {

    WebDriver driver;

    @FindBy(xpath = "//img[@data-image-index='1']")
    WebElement subCatItem;

    @FindBy(id = "add-to-cart-button")
    WebElement addToCartButton;

    @FindBy(tagName = "h1")
    WebElement AddedToCartConfirmationText;

    public SubCatItemResultPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnSubCatItem(){
        subCatItem.click();
    }

    public void ClickOnAddToCartButton(){
        addToCartButton.click();
    }

    public boolean IsAddedToCart(){
        return AddedToCartConfirmationText.getText().contains("Added to Cart");
    }

}
