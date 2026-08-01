package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.LoginPage;

public class LoginPageTest extends BaseTest {

    private LoginPage login;

    @BeforeMethod(alwaysRun = true)
    public void initpage() {
        login = new LoginPage(driver);
    }

    @Test(priority = 2)
    public void possitiveLoginTest() {

        login.enterUsername("student");
        login.enterPassword("Password123");
        login.submitButtonClick();
        Assert.assertTrue(login.getCurrentUrl().contains("logged-in-successfully"),
                "Login failed with valid credentials!");
    }

    @Test(priority = -1)
    public void negativeLoginTest() {

        login.enterUsername("incorrectUser");
        login.enterPassword("Password123");
        login.submitButtonClick();

        Assert.assertEquals(login.getErrorMessage(), "Your username is invalid!");
    }

    @Test(groups = "negative")
    public void negativePasswordTest() {
        login.enterUsername("student");
        login.enterPassword("Password1234");
        login.submitButtonClick();

        Assert.assertEquals(login.getErrorMessage(), "Your password is invalid!");
    }
}
