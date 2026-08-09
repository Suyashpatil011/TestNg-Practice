package utils;

import Base.BasePractice;
import Base.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class captureScreenshot extends BasePractice {
    public void captureScreenshot
            (String testName) {
        capture(getDriver(), testName, "screenshots");
    }

    public void capture(WebDriver driver, String testName, String folderName) {
        if (driver == null) {
            return;
        }

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // ✅ Ensure folder exists
        String folderPath = System.getProperty("user.dir") + "/screenshots/" + folderName + "/";
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        // File name with timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File dest = new File(folderPath + testName + "_" + timestamp + ".png");

        try {
            FileHandler.copy(src, dest);
            System.out.println("✅ Screenshot saved in " + folderName + ": " + dest.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
