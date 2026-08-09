package utils;

import Base.BasePractice;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result){
        capture(result, "passed");
    }

    @Override
    public void onTestFailure(ITestResult result){
        capture(result, "failed");
    }

    private void capture(ITestResult result, String status) {
        WebDriver driver = null;
        Object testInstance = result.getInstance();

        // 1. Try to get driver from the test class instance field 'driver'
        try {
            java.lang.reflect.Field driverField = testInstance.getClass().getDeclaredField("driver");
            driverField.setAccessible(true);
            driver = (WebDriver) driverField.get(testInstance);
        } catch (Exception e) {
            // Field not found or not accessible
        }

        // 2. Fallback: Try to get driver from BasePractice (ThreadLocal)
        if (driver == null) {
            driver = BasePractice.getDriver();
        }

        if (driver != null) {
            captureScreenshot cs = new captureScreenshot();
            cs.capture(driver, result.getName(), status);
        } else {
            System.out.println("⚠️ Could not capture screenshot for " + result.getName() + " because driver was null.");
        }
    }
}

