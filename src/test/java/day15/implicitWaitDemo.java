package day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class implicitWaitDemo {

    /*
    2 Waits - Implicit and Explicit wait ---- Fluent Wait

    Thread.sleep(2000) - Explicit
     */

    WebDriver driver = new ChromeDriver();

    @BeforeSuite
    void setUp()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    void implicitDemo()
    {
        driver.get("https://the-internet.herokuapp.com/nested_frames");

    }

    @Test
    void explicitWaitDemo()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfAllElements());
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
                //===
                //==
        wait.until(ExpectedConditions.visibilityOfAllElements());
    }

    @Test
    void fluentWaitDemo()
    {
        /*
        polling frequency -
        timeout - total timeout
        ignore exception
         */
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(6))
                .ignoring(NoClassDefFoundError.class);

        WebElement dyElement = wait.until(new Function<WebDriver, WebElement>(){

            WebElement ele = driver.findElement(By.id("dummy"));
            public WebElement apply(WebDriver driver)
            {
                if(ele.isDisplayed())
                {
                    return ele;
                }
                else {
                    return  null;
                }
            }

        });

        dyElement.click();
    }
}

// How to read value from Excel
// TestNG Listerner
// Log4j
// Extend Report
// Framework Creation (action class, select class, javascriptExecutor)

