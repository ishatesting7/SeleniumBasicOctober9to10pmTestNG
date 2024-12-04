package TestCases;

import BaseClass.BaseClass;
import PageObject.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class LoginTest extends BaseClass {

    HomePage homePage;
    @BeforeMethod
    public void setUpTest()
    {
        setUp();
        homePage = new HomePage(driver);

    }

    @Test
    public void testLogin() throws InterruptedException {

        homePage.clickLogin();
        homePage.enterCredentials("vnas","vnas");
        Thread.sleep(2000);
        homePage.clickLoginButton();
        homePage.validateLoginPage();

    }

    @AfterMethod
    public void tearDemoTest()
    {
        tearDown();
    }

}
