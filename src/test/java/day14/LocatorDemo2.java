package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class LocatorDemo2 {

    //2 Major Plugins -
    //1 - SelectorHub - https://chromewebstore.google.com/detail/selectorshub-xpath-helper/ndgimibanhlabgdgjcpbbndiehljcpfh
    //2 - Chropath - https://chromewebstore.google.com/detail/chropath/ljngjbnaijcbncmcnjfhigebomdlkcjo

    WebDriver driver = new ChromeDriver();
    //To Print all the hyperlink which is present on the page
    @Test
    void findElementByTagName() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);
        List<WebElement> allElement = driver.findElements(By.tagName("a"));
        System.out.println(allElement.size());
        for(WebElement ele:allElement)
        {
            System.out.println("=====IN FOR LOOP=======");
            String href = ele.getAttribute("href");
            System.out.println(href);
            /*driver.get(href);
            if(href.equals("https://www.linkedin.com/company/orangehrm/mycompany/"))
            {
                System.out.println("URL FOUND");
            }*/

            /*String openLink = Keys.chord(Keys.CONTROL, Keys.RETURN);
            ele.sendKeys(openLink);*/

            driver.get(href);
            Thread.sleep(1000);
            driver.navigate().back();
            Thread.sleep(1000);

        }

        System.out.println("======== HELLO ===========");

    }

    @Test
    public void findElementByCSS()
    {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }


    //RULES for CSS
    // 1. Whenever you have the classname, then the css selector will be .classname (If there is empty space in between then we need to use .)
    // 2. Whenever you have the id, then the css selector will be #id
    // 3. If you are aware about tagname, attribute and value - you can use in below format -
        // a. tagName[attribute = "value"]
        // b. [attribute = "value"]
    // 4. Traversing - Parent and child --- body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > a:nth-child(4) > svg:nth-child(1)



}
