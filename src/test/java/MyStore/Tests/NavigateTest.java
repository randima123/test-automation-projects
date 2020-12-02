package MyStore.Tests;

import MyStore.WebPages.LandingPageObject;
import MyStore.WebPages.AuthenticationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigateTest extends BaseTest {

    @Test(priority = 1)
    public void navigateToHomePage(){
        LandingPageObject homePageObject = LandingPageObject.open();
        Assert.assertTrue(driver.getTitle().equals("My Store"), "Navigation to home page failed.");
    }

    @Test(priority = 2)
    public void navigateToSignIn(){
        AuthenticationPage authenticationPageObject = AuthenticationPage.open();
        Assert.assertTrue(driver.getTitle().equals("Login - My Store"), "Navigation to signIn page failed.");
    }

}
