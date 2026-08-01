package pom;

import Base.BasePractice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegistrationPage extends BasePractice {
    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(RegistrationPage.class);

    private By nameField = By.id("name");
    private By emailField = By.id("email");
    private By maleRadio = By.xpath("//label[text()='Male']");
    private By femaleRadio = By.xpath("//label[text()='Female']");
    private By mobileField = By.id("mobile");
    private By subjectField = By.id("subjects");
    private By dobField = By.id("dob");
    private By sportsCheckbox = By.xpath("//label[text()='Sports']/preceding-sibling::input");
    private By readingCheckbox = By.xpath("//label[text()='Reading']/preceding-sibling::input");
    private By musicCheckbox = By.xpath("//label[text()='Music']/preceding-sibling::input");
    private By uploadPicture = By.id("picture");
    private By addressField = By.tagName("textarea");
    private By stateDropdown = By.id("state");
    private By cityDropdown = By.id("city");
    private By submitButton = By.xpath("//input[@type='submit']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
        log.info("Entered Name: " + name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        log.info("Entered Email: " + email);
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("Male")) driver.findElement(maleRadio).click();
        else driver.findElement(femaleRadio).click();
        log.info("Selected Gender: " + gender);
    }

    public void enterMobile(String mobile) {
        driver.findElement(mobileField).sendKeys(mobile);
        log.info("Entered Mobile: " + mobile);
    }

    public void setDobField(String dob) {
        driver.findElement(dobField).sendKeys(dob);
        log.info("Entered DOB: " + dob);
    }

    public void selectHobby(String hobby) {
        switch (hobby) {
            case "Sports":
                driver.findElement(sportsCheckbox).click();
                break;
            case "Reading":
                driver.findElement(readingCheckbox).click();
                break;
            case "Music":
                driver.findElement(musicCheckbox).click();
                break;
        }
        log.info("Selected Hobby: " + hobby);
    }

    public void uploadPicture(String filePath) {
        driver.findElement(uploadPicture).sendKeys(filePath);
        log.info("Uploaded Picture: " + filePath);
    }

    public void enterAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
        log.info("Entered Address: " + address);
    }

    public void selectState(String state) {
        Select selectState = new Select(driver.findElement(stateDropdown));
        selectState.selectByVisibleText(state);
        log.info("Selected State: " + state);
    }

    public void selectCity(String city) {
        Select selectCity = new Select(driver.findElement(cityDropdown));
        selectCity.selectByVisibleText(city);
        log.info("Selected City: " + city);
    }

    public void enterSubject(String subject) {
        driver.findElement(subjectField).sendKeys(subject);
        log.info("Entered Subject: " + subject);
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
        log.info("Form Submitted Successfully");
    }
}
