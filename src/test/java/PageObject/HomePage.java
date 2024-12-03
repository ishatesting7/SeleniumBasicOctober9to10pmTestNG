package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

    WebDriver driver;

    @FindBy(linkText = "Log in")
    private WebElement loginLink;

    @FindBy(id = "loginusername")
    private WebElement usernameInput;

    @FindBy(id = "loginpassword")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement loginButton;

    @FindBy(id = "logout2")
    private WebElement logoutButton;

    @FindBy(id = "nameofuser")
    private WebElement nameofUser;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //page action
    public void clickLogin()
    {
        loginLink.click();
    }

    public void enterCredentials(String username, String password)
    {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton()
    {
        loginButton.click();
    }

    public void validateLoginPage() {

        System.out.println("INSIDE Validate LOGIN");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(logoutButton.isDisplayed());
        Assert.assertTrue(nameofUser.isDisplayed());
        String userDetails =  nameofUser.getText();
        System.out.println(userDetails);
        Assert.assertTrue(userDetails.contains("vnas"));
    }

}
