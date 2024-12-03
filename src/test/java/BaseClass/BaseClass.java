package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseClass {

    protected WebDriver driver;
    public String baseurl = "https://www.demoblaze.com/index.html";
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(baseurl);
    }

    public void tearDown()
    {
        if(driver!=null)
        {
            driver.quit();
        }
    }

}
