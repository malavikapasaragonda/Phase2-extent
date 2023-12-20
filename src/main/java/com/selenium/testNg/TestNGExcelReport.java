package com.selenium.testNg;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestNGExcelReport extends TestListenerAdapter {

    private Workbook workbook;
    private Sheet sheet;
    private int rowNum;

    @Override
    public void onStart(ITestContext testContext) {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Test Results");
        rowNum = 0;
        createHeaderRow();
    }

    private void createHeaderRow() {
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Test Name");
        headerRow.createCell(1).setCellValue("Status");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        writeResult(tr.getName(), "PASS");
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        writeResult(tr.getName(), "FAIL");
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        writeResult(tr.getName(), "SKIP");
    }

    private void writeResult(String testName, String status) {
        Row row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue(testName);
        row.createCell(1).setCellValue(status);
    }

    @Override
    public void onFinish(ITestContext testContext) {
        try {
            FileOutputStream fileOut = new FileOutputStream("TestNG_Excel_Report.xlsx");
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Excel report created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
