package Test;

import Base.BasePractice;
import TestData.RegistrationData;
import org.testng.annotations.Test;
import pom.RegistrationPage;

public class RegistrationTest extends BasePractice {


    @Test(dataProvider = "studentData", dataProviderClass = RegistrationData.class)

    public void testRegistration(String name, String email, String gender,
                                 String mobile, String dob, String subject,String hobby ,String filePath ,String address,String state, String city) {

        RegistrationPage regPage = new RegistrationPage(driver);

        // Use POM methods
        regPage.enterName(name);
        regPage.enterEmail(email);
        regPage.selectGender(gender);
        regPage.enterMobile(mobile);
        regPage.setDobField(dob);
        regPage.enterSubject(subject);
        regPage.selectHobby(hobby);
        regPage.uploadPicture(filePath);
        regPage.enterAddress(address);
        regPage.selectState(state);
        regPage.selectCity(city);
        regPage.submitForm();

    }
}
