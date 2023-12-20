package com.selenium.testNg;

import org.testng.annotations.*;

public class TestNGExample {

    // This method will be executed before any test method in the class
    @BeforeClass
    public void setUp() {
        System.out.println("Initializing Test Suite...");
        // Any setup logic goes here
    }

    // This method will be executed before each test method
    @BeforeMethod
    public void beforeTest() {
        System.out.println("Setting up test...");
        // Any test-specific setup logic goes here
    }

    // Test method
    @Test
    public void test1() {
        System.out.println("Test 1 execution...");
        // Test logic goes here
    }

    // Test method
    @Test
    public void test2() {
        System.out.println("Test 2 execution...");
        // Test logic goes here
    }

    // This method will be executed after each test method
    @AfterMethod
    public void afterTest() {
        System.out.println("Tearing down test...");
        // Any test-specific teardown logic goes here
    }

    // This method will be executed after all the test methods in the class
    @AfterClass
    public void tearDown() {
        System.out.println("Finalizing Test Suite...");
        // Any teardown logic goes here
    }
}
