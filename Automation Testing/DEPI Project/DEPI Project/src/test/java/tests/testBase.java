package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class testBase {
    static WebDriver driver;
    Faker fake = new Faker();
    String email = fake.internet().safeEmailAddress();
    String password = fake.internet().password(10, 15);
    protected static ExtentReports reports;
    protected static ExtentTest test;

    @BeforeSuite
    public void setUp() {
        reports = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Reports/my_reoprt.html");
        reports.attachReporter(spark);

    }

    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

//    @AfterMethod
//    public void afterMethod(ITestResult result) throws InterruptedException {
//        switch (result.getStatus()) {
//            case ITestResult.SUCCESS:
//                // Log successful test execution
//                test.pass("Test passed: " + result.getMethod().getMethodName());
//                break;
//
//            case ITestResult.FAILURE:
//                // Log failure along with the exception
//                test.fail("Test failed: " + result.getMethod().getMethodName());
//                test.fail(result.getThrowable());
//
//                // Optional: Capture screenshot in case of failure (if using WebDriver)
//                // String screenshotPath = takeScreenshot(result.getMethod().getMethodName());
//                // test.addScreenCaptureFromPath(screenshotPath);
//
//                break;
//
//            case ITestResult.SKIP:
//                // Log skipped test execution
//                test.skip("Test skipped: " + result.getMethod().getMethodName());
//                test.skip(result.getThrowable());
//                break;
//
//            default:
//                break;
//        }
@AfterMethod
public void AfterMethod(ITestResult result) throws InterruptedException {
    switch (result.getStatus()) {
        case ITestResult.SUCCESS:
            test.pass("Test passed");
            break;
        case ITestResult.FAILURE:
            test.fail(result.getThrowable());
            break;
        case ITestResult.SKIP:
            test.skip("Test skipped: " + result.getSkipCausedBy().toString());
            break;
        default:
            test.warning("Test finished with an unexpected result");
            break;
    }
    driver.quit();
}
//    @AfterMethod
//    public void AfterMethod(ITestResult result) throws InterruptedException {
//        switch (result.getStatus()){
//            case ITestResult.SUCCESS :
//                test.pass("test is passed");
//                break;
//            case ITestResult.FAILURE:
//                test.fail(result.getThrowable());
//                break;
//            default:
//                break;
//        }
//@AfterMethod
//    public void afterMethod() throws InterruptedException {
//        Thread.sleep(3000);
//        driver.quit();
//
//    }

    @AfterSuite
    public void testDown () throws IOException {
        reports.flush();
        Desktop.getDesktop().open(new File("Reports/my_reoprt.html"));
    }
}


