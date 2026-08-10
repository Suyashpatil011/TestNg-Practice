package pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Newuser {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(Newuser.class);

    private By username = By.id("email");
    private By password = By.id("password");

    public Newuser (WebDriver driver){
        this.driver = driver;
    }

    public void enterUsername(String user)

    {
        driver.findElement(username).sendKeys(user);
        log.info("Entered mailid : - " + user);

    }

    public void enterPassword(String pass){
        driver.findElement(password).sendKeys(pass);
        log.info("Entered password : - " + pass);

    }







}
