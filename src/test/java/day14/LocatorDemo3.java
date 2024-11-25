package day14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class LocatorDemo3 {

    /*XPATH -

    ----
    Xpath - Relative and Absolute
     /  - Absolute Xpath - /html/head/body/div/div --- /html/body/div/div/div[2]/div[1]/div/div/form/div[1]/input
    // - Relative Xpath - //<>
    1. Using Tagname + Attribute and Value ---  //input[@id='input-email']
    2. Using Tagname +Indexed Xpath --- (//input[@id='input-email'])[1]
    3. Using text function --- //tagName[text()='Submit'] -- eg - //a[text()=' Wish List']
    4. Using contains function --- //tagName[contains(@attribute,'value')]
    5. Using starts-with --- //tagName[starts-with(@attribute,'value')] -- //a[starts-with(@class,'oxd-topbar-body-nav-tab-item')]
    6. Using normalizae-space() --- //span[normalize-space()='User Management']
    7. //input[@id='input-email' and @idd = 'Value2']
    8. Ancestor - //tagName[@iddd='asdn']/ancestor::tagname

     */

    /*Window handles
    getwindowHandles
    getWindowHandle


     */

    WebDriver driver = new ChromeDriver();

    @Test
    void openWindowAndGetDetails()
    {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        String currentUrl = driver.getWindowHandle();

        System.out.println(currentUrl);

        driver.quit();
    }

    @Test
    void openWindowAndGetDetailsUsingWindowHandles()
    {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.saucedemo.com/");

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");

        Set<String> allWindows = driver.getWindowHandles();

        for(String wind : allWindows)
        {
            driver.switchTo().window(wind);

                if(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"))
                {
                    System.out.println("I am in orange hrms");


                }
                else if(driver.getCurrentUrl().equals("https://ecommerce-playground.lambdatest.io/index.php?route=account/login"))
                {
                    System.out.println("I am in ecommerce lambda");
                }
                else if(driver.getCurrentUrl().equals("https://www.saucedemo.com/"))
                {
                    System.out.println("I am in SauceDemo");

                }

        }

        // driver.quit();
    }
}
