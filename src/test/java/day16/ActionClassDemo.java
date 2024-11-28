package day16;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClassDemo {

    WebDriver driver = new ChromeDriver();
    @Test
    void mouseHover()
    {
        driver.get("https://tutorialsninja.com/demo/");
        WebElement productMenu = driver.findElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));

        Actions action = new Actions(driver);

        action.moveToElement(productMenu).perform();
    }

    @Test
    void DragAndDrop() throws InterruptedException {
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        driver.manage().window().maximize();
        Thread.sleep(10000);
        WebElement source = driver.findElement(By.xpath("//img[@alt='The peaks of High Tatras']"));
        WebElement destination = driver.findElement(By.xpath("//div[@id='trash']"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,destination);


    }
}

