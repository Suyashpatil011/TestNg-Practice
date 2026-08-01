package TestData;

import org.testng.annotations.DataProvider;

public class RegistrationData {


    @DataProvider(name = "studentData",parallel = true)
    public Object[][] getdata() {
        return new Object[][]{
                {"Suyash", "suyash@example.com", "Male", "9876543210","01-10-1999", "Computer Science", "Reading","C://Users//suyas/Images//Mahakal.jpg", "A/P June Danwad","NCR","Agra"},
                {"Riya", "riya@example.com", "Female", "9123456789","01-10-1998", "Mathematics", "Music","C://Users//suyas/Images//Mahakal.jpg", "A/P Inchalkarnji","NCR","Agra"},
                {"Amisha", "amit@example.com", "Female", "9988776655", "01-10-1997","Physics", "Sports","C://Users//suyas/Images//Mahakal.jpg", "A/P Korochi","NCR","Agra"},

        };
    }
}



