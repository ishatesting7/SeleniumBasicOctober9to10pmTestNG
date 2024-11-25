package day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class iframeDemo {

    WebDriver driver = new ChromeDriver();

    @Test
    void iFrameNested() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements());

        driver.manage().window().maximize();

        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-left");

        String leftText = driver.findElement(By.tagName("body")).getText();

        System.out.println(leftText);

        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-middle");

        String middleText = driver.findElement(By.tagName("body")).getText();

        System.out.println(middleText);

        driver.switchTo().defaultContent();
    }
}
