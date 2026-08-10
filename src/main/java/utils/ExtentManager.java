package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager
{
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            // ✅ Unique file name with timestamp
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport_" + timestamp + ".html";

            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);

            // ✅ Professional theme and layout
            reporter.config().setTheme(Theme.DARK);
            reporter.config().setDocumentTitle("Automation Test Report");
            reporter.config().setReportName("Automation Test Execution Report - Suyash Patil");

            // ✅ Centered title and clean styling
            reporter.config().setCss(
                    "body { font-family: 'Segoe UI', sans-serif; } " +
                            ".report-name { text-align: center; font-size: 24px; font-weight: 600; color: #0078D7; margin-top: 10px; } " +
                            ".report-header { background-color: #1E1E1E; color: #FFFFFF; padding: 12px; border-bottom: 2px solid #0078D7; } " +
                            ".badge-primary { background-color: #0078D7; } " +
                            ".card-header { font-weight: 600; font-size: 15px; }"
            );

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            // ✅ Executive-style system info
            extent.setSystemInfo("Tester", "Suyash Patil");
            extent.setSystemInfo("Role", "Automation Test Engineer");
            extent.setSystemInfo("Framework", "Selenium | TestNG | ExtentReports");
            extent.setSystemInfo("Execution Date", new SimpleDateFormat("dd MMM yyyy HH:mm:ss").format(new Date()));
            extent.setSystemInfo("Environment", "QA / Staging");
            extent.setSystemInfo("Browser", "Google Chrome");
            extent.setSystemInfo("Build Version", "v1.0.0");
        }
        return extent;
    }
}
