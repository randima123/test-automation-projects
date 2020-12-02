package MyStore.WebPages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SignInPage extends BasePageObject {

    @FindBy(xpath = "//div[@class='account_creation'][1]/h3[@class='page-subheading']")
    private WebElement subHeading;

    @FindBy(id = "id_gender1")
    private WebElement MrRadioButton;

    @FindBy(id = "id_gender2")
    private WebElement MrsRadioButton;

    @FindBy(id = "customer_firstname")
    private WebElement cusFirstName;

    @FindBy(id = "customer_lastname")
    private WebElement cusLastName;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "days")
    private WebElement daySelect;

    @FindBy(id = "months")
    private WebElement monthsSelect;

    @FindBy(id = "years")
    private WebElement yearsSelect;

    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lasttName;

    @FindBy(id = "company")
    private WebElement company;

    @FindBy(id = "address1")
    private WebElement address1;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement stateSelect;

    @FindBy(id = "postcode")
    private WebElement postCode;

    @FindBy(id = "id_country")
    private WebElement countrySelect;

    @FindBy(id = "other")
    private WebElement additionalInfo;

    @FindBy(id = "phone")
    private WebElement homePhone;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhone;

    @FindBy(id = "alias")
    private WebElement alias;

    @FindBy(id = "submitAccount")
    private WebElement submitAccountButton;

    public SignInPage(){
        PageFactory.initElements(driver,this);
    }

    public static SignInPage open(){
        return new SignInPage();
    }

    public boolean verifySignInPage(){

        try{
            if( "Your personal information".equalsIgnoreCase(subHeading.getText())){
                return true;
            }else {
                return false;
            }
        }catch (NoSuchElementException ex){
            //Error log
            ex.printStackTrace();
            return false;
        }

    }

    public void clickSubmitAccountButton(){
        submitAccountButton.click();
    }

    public WebElement getSubHeading() {
        return subHeading;
    }

    public WebElement getMrRadioButton() {
        return MrRadioButton;
    }

    public void clickMrRadioButton() {
        MrRadioButton.click();
    }

    public WebElement getMrsRadioButton() {
        return MrsRadioButton;
    }

    public void clickMrsRadioButton(String mrsRadioButton) {
        MrsRadioButton.click();
    }

    public WebElement getCusFirstName() {
        return cusFirstName;
    }

    public void setCusFirstName(String cusFirstName) {
        this.cusFirstName.sendKeys(cusFirstName);
    }

    public WebElement getCusLastName() {
        return cusLastName;
    }

    public void setCusLastName(String cusLastName) {
        this.cusLastName.sendKeys(cusLastName);
    }

    public WebElement getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public WebElement getDaySelect() {
        return daySelect;
    }

    public void setDaySelect(String daySelect) {
        Select daySel = new Select(this.daySelect);
        daySel.selectByValue(daySelect);
    }

    public WebElement getMonthsSelect() {
        return monthsSelect;
    }

    public void setMonthsSelect(String monthsSelect) {
        Select daySel = new Select(this.monthsSelect);
        daySel.selectByValue(monthsSelect);
    }

    public WebElement getYearsSelect() {
        return yearsSelect;
    }

    public void setYearsSelect(String yearsSelect) {
        Select daySel = new Select(this.yearsSelect);
        daySel.selectByValue(yearsSelect);
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public WebElement getLasttName() {
        return lasttName;
    }

    public void setLasttName(String lasttName) {
        this.lasttName.sendKeys(lasttName);
    }

    public WebElement getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company.sendKeys(company);
    }

    public WebElement getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1.sendKeys(address1);
    }

    public WebElement getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city.sendKeys(city);
    }

    public WebElement getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode.sendKeys(postCode);
    }

    public WebElement getCountrySelect() {
        return countrySelect;
    }

    public void setCountrySelect(String countrySelect) {
        this.countrySelect.sendKeys(countrySelect);
    }

    public WebElement getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo.sendKeys(additionalInfo);
    }

    public WebElement getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone.sendKeys(homePhone);
    }

    public WebElement getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone.sendKeys(mobilePhone);
    }

    public WebElement getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias.sendKeys(alias);
    }

    public WebElement getStateSelect() {
        return stateSelect;
    }

    public void setStateSelect(String stateSelect) {
        Select daySel = new Select(this.stateSelect);
        daySel.selectByValue(stateSelect);
    }

}
