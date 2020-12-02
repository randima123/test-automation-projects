package MyStore.Tests;

import MyStore.WebPages.AuthenticationPage;
import MyStore.WebPages.ForgotPasswordPage;
import MyStore.WebPages.MyAccountPage;
import MyStore.WebPages.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


//    @Test(priority = 1, dataProvider = "getValidateEmailToCreateAccountTestData")
//    public void validateEmailToCreateAccountTest(String email, boolean expectedValue){
//        AuthenticationPage authenticationPage = AuthenticationPage.open();
//        authenticationPage.enterEmailAddress(email);
//        authenticationPage.clickCreateAccount();
//        SignInPage signInPage = SignInPage.open();
//        boolean actualValue = signInPage.verifySignInPage();
//        Assert.assertEquals(actualValue, expectedValue,"Error in submiting email address");
//    }

//    @Test(priority = 2)
//    public void registerTest(){
//        validateEmailToCreateAccountTest();
//        SignInPage signInPage = SignInPage.open();
//        signInPage.clickMrRadioButton();
//        signInPage.setFirstName("Randima");
//        signInPage.setLasttName("Sen");
//        signInPage.setAdditionalInfo("Additional info");
//        signInPage.setAddress1("address1");
//        signInPage.setAlias("alias");
//        signInPage.setCity("city");
//        signInPage.setCompany("company");
//        signInPage.setDaySelect("28");
//        signInPage.setMonthsSelect("2");
//        signInPage.setYearsSelect("1994");
//        signInPage.setCusFirstName("Ran");
//        signInPage.setCusLastName("Sen");
//        signInPage.setHomePhone("1233344234");
//        signInPage.setMobilePhone("5442233667");
//        signInPage.setPassword("pwd123");
//        signInPage.setPostCode("00002");
//        signInPage.setStateSelect("2");
//        signInPage.clickSubmitAccountButton();
//        MyAccountPage myAccountPage = MyAccountPage.open();
//        boolean isRegistered = myAccountPage.verifyMyAccountPage();
//        Assert.assertTrue(isRegistered, "Error when loading myAccountPage");
//    }
//
//    @Test(priority = 3)
//    public void alreadyRegisteredEmailTest(){
//        AuthenticationPage authenticationPage = AuthenticationPage.open();
//        authenticationPage.enterEmailAddress("randimals1@gmail.com");
//        authenticationPage.clickCreateAccount();
//        boolean isSuccess = authenticationPage.checkAlreadyRegisteredEmail();
//        Assert.assertTrue(isSuccess, "Error in identifying already registered email.");
//    }
//
//    @Test(priority = 4)
//    public void loginTest(){
//        AuthenticationPage authenticationPage = AuthenticationPage.open();
//        authenticationPage.login("randimals1@gmail.com","pwd123");
//        MyAccountPage myAccountPage = MyAccountPage.open();
//        boolean isRegistered = myAccountPage.verifyMyAccountPage();
//        Assert.assertTrue(isRegistered, "Error when login in.");
//    }
//
//    @Test(priority = 5)
//    public void forgetPasswordTest(){
//        AuthenticationPage authenticationPage = AuthenticationPage.open();
//        authenticationPage.clickForgetPassword();
//        ForgotPasswordPage forgotPasswordPage = ForgotPasswordPage.open();
//        boolean isOnForgotPwdPage = forgotPasswordPage.verifyForgotPwdPage();
//        Assert.assertTrue(isOnForgotPwdPage, "Error when navigating to forgot password page.");
//        forgotPasswordPage.enterEmail("randimals1@gmail.com");
//        forgotPasswordPage.clickRetrievePwdButton();
//        boolean isConfirmed = forgotPasswordPage.verifySentEmail();
//        Assert.assertTrue(isConfirmed, "Error in sending email");
//    }

}
