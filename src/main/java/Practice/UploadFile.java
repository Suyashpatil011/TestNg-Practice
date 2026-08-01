package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UploadFile {

   public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://rahulshettyacademy.com/upload-download-test/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement downloadBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("downloadButton")));
        downloadBtn.click();
        WebElement upload = driver.findElement(By.id("fileinput"));
        upload.sendKeys("C://Users//suyas//Downloads//download.xlsx");
        By toastLocator = By.cssSelector(".Toastify__toast-body");
        String toastText = driver.findElement(toastLocator).getText();
        System.out.println(toastText);
        wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));
        driver.quit();
    }
}
