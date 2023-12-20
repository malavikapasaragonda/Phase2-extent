package com.selenium.testNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertionsExample {

    @Test
    public void testWithHardAssertions() {
        int expectedResult = 5;
        int actualResult = 2 + 3;

        Assert.assertEquals(actualResult, expectedResult, "Values do not match");
        Assert.assertTrue(actualResult > 0, "Result should be positive");
        Assert.assertNotNull(actualResult, "Result should not be null");
    }
}
