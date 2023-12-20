package com.selenium.testNg;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ExtentReportsExample {
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeSuite
    public void setUp() {
        // Initialize ExtentReports and attach HTML reporter
        extent = new ExtentReports();

    }

    @Test
    public void testExtentReport() {
        // Create a test in the report
        test = extent.createTest("TestName");
        
        // Test steps
        test.log(Status.INFO, "Starting the test");
        // Perform test actions...
        test.log(Status.PASS, "Test passed");
    }

    @AfterSuite
    public void tearDown() {
        // Flush the report and close ExtentReports
        extent.flush();
    }
}
