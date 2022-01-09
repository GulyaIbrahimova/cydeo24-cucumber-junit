package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.IOException;

public class ExcelReadActions {
    //to store the file name

    String filePath="Employees.xlsx";

    @Test
    public void readExcelSheetData() throws IOException {
        //open the Employees.xlsx using Apache POI
        XSSFWorkbook workbook = new XSSFWorkbook(filePath);

        //Go to "data"worksheet
        XSSFSheet dataSheet = workbook.getSheet("data");//if you don't know name it is dynamic, we can use workSheet.getSheet(0); it will go to the 1st sheet one

        //prit column names
        System.out.println("COLUMN NAMES:");
        System.out.println(dataSheet.getRow(0).getCell(0));
        System.out.println("-------------------");
        for (int i = 0; i <=2; i++) {
            System.out.println(dataSheet.getRow(0).getCell(i));

        }
        //find out number of rows in the worksheet
        int rowsCount = dataSheet.getPhysicalNumberOfRows();
        System.out.println(rowsCount);
        int usedRowsCount = dataSheet.getLastRowNum();
        System.out.println("usedRowsCount= "+dataSheet.getLastRowNum());
        //print all first names
        System.out.println("ALL FIRSTNAMES");
        for (int i = 1; i <=usedRowsCount ; i++) {

        System.out.println(dataSheet.getRow(i).getCell(0));

        }
        //loop and find Fahima
        //print her last name and job id then exit loop
        System.out.println("Fahima INFO");
        for (int i = 0; i < rowsCount; i++) {
            if (dataSheet.getRow(i).getCell(0).toString().equals("Masha")){
                System.out.println(dataSheet.getRow(i).getCell(0) + " | " + dataSheet.getRow(i).getCell(1)+" | "+dataSheet.getRow(i).getCell(2));
                break;
            }

        }




    }
}
