package Test;

import Base.BasePractice;
import TestData.NewUserData;
import TestData.RegistrationData;
import org.testng.annotations.Test;
import pom.Newuser;

public class NewUserTest extends BasePractice {

@Test(dataProvider = "NewuserList", dataProviderClass = NewUserData.class)
    public void testNewUser(String user ,String pass ){
        Newuser nu = new Newuser(driver);
        nu.enterUsername(user);
        nu.enterPassword(pass);

    }

}
