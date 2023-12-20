package com.selenium.testNg;

import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

public class SoftAssertionsExample {

    @Test
    public void testWithSoftAssertions() {
        SoftAssert softAssert = new SoftAssert();

        int expectedResult = 5;
        int actualResult = 2 + 3;

        softAssert.assertEquals(actualResult, expectedResult, "Values do not match");
        softAssert.assertTrue(actualResult > 0, "Result should be positive");
        softAssert.assertNotNull(actualResult, "Result should not be null");

        // Using assertAll() to collect all assertion failures
        softAssert.assertAll();
    }
}
