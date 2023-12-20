package com.selenium.testNg;

import java.io.FileOutputStream;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.collect.Table.Cell;

public class ExcelReportGenerator implements ITestListener {

    private Workbook workbook;
    private Sheet sheet;
    private int rowNum = 0;

    public ExcelReportGenerator() {
        // Create a new Excel workbook and sheet
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("TestNG Report");

        // Create header row
        Row headerRow = sheet.createRow(rowNum++);
        String[] headers = {"Test Name", "Status"};
        int colNum = 0;
        for (String header : headers) {
            Cell cell = headerRow.createCell(colNum++);
            cell.setCellValue(header);
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        addTestResultToReport(result.getName(), "PASS");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        addTestResultToReport(result.getName(), "FAIL");
    }

    @Override
    public void onFinish(ITestContext context) {
        // Write the workbook content to an Excel file
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("TestNGReport.xlsx");
            workbook.write(fileOutputStream);
            fileOutputStream.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addTestResultToReport(String testName, String status) {
        Row row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue(testName);
        row.createCell(1).setCellValue(status);
    }
}
