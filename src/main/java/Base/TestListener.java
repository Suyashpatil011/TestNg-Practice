package Base;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result){
        captureScreenshot cs = new captureScreenshot();
        cs.captureScreenshot(result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result){
        captureScreenshot cs = new captureScreenshot();
        cs.captureScreenshot(result.getName());
    }

}

