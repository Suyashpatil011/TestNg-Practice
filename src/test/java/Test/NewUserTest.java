package Test;

import Base.BasePractice;
import TestData.LoginUserData;
import org.testng.annotations.Test;
import pom.Newuser;

public class NewUserTest extends BasePractice {

@Test
        (dataProvider = "NewuserList", dataProviderClass = LoginUserData.class)
    public void testNewUser(String user ,String pass ){
        Newuser nu = new Newuser(getDriver());
        nu.enterUsername(user);
        nu.enterPassword(pass);

    }

}
