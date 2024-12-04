package Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;

public class ExtendReportListener implements ITestListener {

    private static final String OUTPUT_FOLDER = "./reports/";
    private static final String FILE_NAME = "TestExecutionReport.html";

    private static ExtentReports extent = init();
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
    private static ExtentReports extentReports;

    private static ExtentReports init()
    {
        Path path = Paths.get(OUTPUT_FOLDER);

        extentReports = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter(OUTPUT_FOLDER+FILE_NAME);
        reporter.config().setReportName("BLAZE DEMO REPORT");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("System", "MAC");
        extentReports.setSystemInfo("Author", "VB");
        extentReports.setSystemInfo("Env Details", "QA");
        return extentReports;
    }

    @Override
    public synchronized void onStart(ITestContext context)
    {
        System.out.println("Test Execution Started");
    }

    @Override
    public synchronized void onFinish(ITestContext context)
    {
        System.out.println("Test Execution Completed");
        extent.flush();
        test.remove();
    }

    @Override
    public synchronized void onTestStart(ITestResult result)
    {
        String methodName = result.getMethod().getMethodName();
        String qualifiedName = result.getMethod().getQualifiedName();
        int last = qualifiedName.lastIndexOf(".");
        int mid = qualifiedName.substring(0,last).lastIndexOf(".");
        String className = qualifiedName.substring(mid+1, last);

        System.out.println("Started --- "+methodName);
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),
                result.getMethod().getDescription());

        extentTest.assignCategory(className);
        test.set(extentTest);
        test.get().getModel().setEndTime(getTime(result.getEndMillis()));

    }

    @Override
    public synchronized void onTestSuccess(ITestResult result)
    {
        String methodName = result.getMethod().getMethodName();
        System.out.println(methodName + " PASSED ");
        test.get().pass("Test Passed");
        test.get().getModel().setEndTime(getTime(result.getEndMillis()));
    }

    @Override
    public synchronized void onTestFailure(ITestResult result)
    {
        String methodName = result.getMethod().getMethodName();
        System.out.println(methodName + " FAILED ");
        test.get().pass("Test Failed");
        test.get().getModel().setEndTime(getTime(result.getEndMillis()));
    }

    public synchronized void onTestSkipped(ITestResult result)
    {
        String methodName = result.getMethod().getMethodName();
        System.out.println(methodName + " SKIPPED ");
        test.get().pass("Test Skipped");
        test.get().getModel().setEndTime(getTime(result.getEndMillis()));
    }

    public Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

}
