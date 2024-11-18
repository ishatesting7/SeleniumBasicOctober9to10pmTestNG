package day13;

import org.testng.annotations.Test;

public class RegexExpressionInGroup {

    @Test(groups = "user_SingUp",priority = 1)
    public void signUp()
    {
        System.out.println("I am in Singup Group");
    }

    @Test(groups = "user_Registration",priority = 2)
    public void registration()
    {
        System.out.println("I am in Registration Group");
    }

    @Test(groups = "user_Login",priority = 3)
    public void login()
    {
        System.out.println("I am in login Group");
    }

    @Test(dependsOnGroups = {"user_.*"})
    void purchaseProduct()
    {
        System.out.println("I have purchase the product");
    }
}
