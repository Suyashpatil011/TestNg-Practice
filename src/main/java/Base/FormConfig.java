package Base;

public class FormConfig {

    // Base URL for Selenium Practice site
    public static final String BASE_URL = "https://www.tutorialspoint.com/selenium/practice/";

    // Method to get full URL based on form type
    public static String getFormUrl(String formType) {
        switch (formType.toLowerCase()) {
            case "register":
                return BASE_URL + "register.php";
            case "login":
                return BASE_URL + "login.php";
            case "practice":
                return BASE_URL + "selenium_automation_practice.php";
            default:
                throw new IllegalArgumentException("Invalid form type: " + formType);
        }
    }
}
