package com.selenium.testNg;

import org.testng.annotations.Test;

public class TestNGGroupsExample {

    @Test(groups = "group1")
    public void test1() {
        System.out.println("Test 1 belongs to group1");
    }

    @Test(groups = "group2")
    public void test2() {
        System.out.println("Test 2 belongs to group2");
    }

    @Test(groups = {"group1", "group2"})
    public void test3() {
        System.out.println("Test 3 belongs to both group1 and group2");
    }
}