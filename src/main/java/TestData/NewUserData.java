package TestData;

import org.testng.annotations.DataProvider;

public class NewUserData {

    @DataProvider(name = "NewuserList" ,parallel = true)
    public Object[][] getData() {

        return new Object[][]{

                {"student@example.com", "Password123"},
                {"student@example.com", "Password123"}
        };
    }

}

