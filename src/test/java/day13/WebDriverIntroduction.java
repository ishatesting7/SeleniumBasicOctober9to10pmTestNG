package day13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;


import java.io.IOException;

public class WebDriverIntroduction {

    // Set the Path - ChromeDriver, GechkoDriver, OperaDriver
    // Advance XPATH (rightof leftof upperof lowerof)
    // WebDriver is a Interface
    // Chrome Browser
    WebDriver driver = new ChromeDriver();
    // Edge Browser
    //WebDriver driver1 = new EdgeDriver();
    //Gecko
    //WebDriver driver2 = new FirefoxDriver();
    // GET command - driver.get("url")
    // MAX Window - driver.window.maximize
    @Test(priority = 1)
    void navigateToUrl()
    {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().window().minimize();
        driver.manage().window().fullscreen();
        System.out.print(driver.manage().window().getSize());
    }
    @Test(priority = 2)
    void enterValue()
    {
        driver.navigate().refresh();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.navigate().back();
        driver.navigate().forward();
    }

    @AfterSuite
    void tearDown()
    {
        driver.quit();
    }

    // Extends --- Class
    // Implements --- Interface
    // class to class --- extends
    // interface to interface --- extends
    // class to interface --- implements
    // interface to class --- implements



}
