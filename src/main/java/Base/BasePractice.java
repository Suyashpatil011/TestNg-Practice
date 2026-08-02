package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class BasePractice {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected static ExtentReports extent;
    protected static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @BeforeSuite(alwaysRun = true)
    public void startExtentReport() {
        extent = utils.ExtentManager.getInstance(); // initialize once per suite
        System.out.println("✅ Extent Report initialized successfully.");
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {
        WebDriver webDriver = new ChromeDriver();
        driver.set(webDriver);
        getDriver().manage().window().maximize();
        getDriver().get(FormConfig.getFormUrl("login"));

        // create test entry for each method
        test.set(extent.createTest(method.getName()));
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriver webDriver = getDriver();
        if (webDriver != null) {
            webDriver.quit();
            driver.remove();
        }
    }

    @AfterSuite(alwaysRun = true)
    public void flushReport() {
        extent.flush();
        System.out.println("✅ Extent Report flushed successfully.");
    }
}
