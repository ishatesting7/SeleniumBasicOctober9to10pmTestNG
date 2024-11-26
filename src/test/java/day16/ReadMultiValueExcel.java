package day16;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadMultiValueExcel {


    WebDriver driver;
    String filePath = "src/TestData/testDataDemo.xlsx";
    @Test
    void EnterCredentials() throws IOException, InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);

        Sheet sheet = workbook.getSheet("Sheet1");

        for(int i=1; i<=sheet.getLastRowNum();i++)
        {
            Row row = sheet.getRow(i);

            String username = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();
            performLogin(driver,username,password);

        }
    }

    private static void performLogin(WebDriver driver,String user, String pass) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.name("username")).sendKeys(user);
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.cssSelector("[type='submit']")).click();
        Thread.sleep(2000);
        if(user.equals("Admin") && pass.equals("admin123"))
        {
            driver.findElement(By.cssSelector(".oxd-userdropdown-img")).click();
            driver.findElement(By.cssSelector("[href='/web/index.php/auth/logout']")).click();
        }
        System.out.println("Hello ------ Hello");
        Thread.sleep(1000);

    }
}
