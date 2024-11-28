package day16;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScriptExecutorDemo {

    WebDriver driver = new ChromeDriver();
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @Test
    void JSScrollDemo()
    {
        driver.get("https://scroll.in/");

        js.executeScript("window.scrollBy(0,3000)");
    }

    @Test
    void setInputValue() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(5000);
        WebElement ele = driver.findElement(By.id("user-name"));
        WebElement pass = driver.findElement(By.id("password"));
        js.executeScript("arguments[0].value='standard_user';",ele);
        js.executeScript("arguments[0].value='secret_sauce';",pass);

        Thread.sleep(2000);

        driver.findElement(By.id("login-button")).click();
        //clickOnLogin(driver, js);

    }

    private static void clickOnLogin(WebDriver driver, JavascriptExecutor js)
    {
        WebElement login = driver.findElement(By.id("login-button"));
        js.executeScript("arguments[0].click()",login);
    }
}
