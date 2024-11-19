package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocatorDemo1 {

    // Locator - Finding the web-element on web-page
    // Total we have - 8 ways of identifying

    //Handled the exception with throws keyword
    //Handled the exception with try - catch

    //Assertions - TestNG

    WebDriver driver = new ChromeDriver();
    @Test
    void findElementByIdDemo() throws InterruptedException {
        driver.navigate().to("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        Thread.sleep(2000);
        loginBtn.click();
        //FindElementByClassName
        WebElement product = driver.findElement(By.className("title"));
        String actualText = product.getText();
        String expText = "Products";
        Assert.assertEquals(actualText,expText);

        //URL Validation
        String currURL =  driver.getCurrentUrl();
        /*boolean b = currURL.contains("inventory");
        if(b)
        {
            assert true;
        }
        else
        {
            assert false;
        }*/
        Assert.assertTrue(currURL.contains("inventory"));
        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource());
        driver.close();
    }

    @Test
    void findElementByLinkText()
    {
    driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
    driver.findElement(By.linkText("Register")).click();
    driver.findElement(By.partialLinkText("For")).click();

    }

    // 4 Diff Locator
    // id
    // className
    // linkText - It should be hyperlinke
    // partialLinkText - It should be hyperlink















    /*
    <div class="login_logo">Swag Labs</div>
    div - tagName
    class - attribute
    login_logo - value
    */

    /*
    <input type="submit" class="submit-button btn_action"
    data-test="login-button" id="login-button" name="login-button"
    value="Login">

    input - tagName - <
    type - attribute
    class - attribute
    data-test - attribute /> or </input>
    <html ------ </html>

     */
}
