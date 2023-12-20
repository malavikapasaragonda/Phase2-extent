package com.selenium.testNg;

import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWorkbookCreator {

    public static <Workbook> void main(String[] args) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Hello, this is an Excel file!");

        try {
            FileOutputStream fileOut = new FileOutputStream("TestWorkbook.xlsx");
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Workbook created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
