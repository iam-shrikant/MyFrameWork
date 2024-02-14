package com.myframework.utitlies;

import com.myframework.base.Log;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Arrays;

public class ExcelUtility {
    private Workbook workbook = null;
    private Sheet sheet = null;
    private Row row = null;
    private Cell cell= null;
    private FileInputStream inputStream = null;

    public synchronized void readExcel(String filePath, String fileName) throws IOException {

        File excelFile = new File(filePath+"\\"+fileName);
        try {
            inputStream = new FileInputStream(excelFile);

        } catch (FileNotFoundException e) {
            Log.error("ExcelUtility - readExcel() -> Got Exception :",e);
            e.printStackTrace();
        }
        String fileExtension = fileName.substring(fileName.indexOf(".")); //get file extension
        if(fileExtension.equals(".xlsx")){
            try {
                workbook = new XSSFWorkbook(inputStream);
            } catch (IOException e) {
                Log.error("ExcelUtility - readExcel() -> Got Exception :",e);
                e.printStackTrace();
            }
        }else if(fileExtension.equals(".xls")){
            try {
                workbook = new HSSFWorkbook(inputStream);
            } catch (IOException e) {
                Log.error("ExcelUtility - readExcel() -> Got Exception :",e);
                e.printStackTrace();
            }
        }
        inputStream.close();
    }

    public int  getNoOfRows(String sheetName){
        sheet = workbook.getSheet(sheetName);
        System.out.println(sheet.getLastRowNum() +" "+sheet.getFirstRowNum());
        return  sheet.getLastRowNum() - sheet.getFirstRowNum();
    }

    public int getNoOfColumns(String sheetName){
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(0);
        //System.out.println(row.getLastCellNum());
        return row.getLastCellNum();
    }

    public Object[][] getAllDataBySheetName(String sheetName, boolean ignoreFirstRow){
        Object[][] data;
        sheet = workbook.getSheet(sheetName);

        int totalRowInSheet = sheet.getLastRowNum() - sheet.getFirstRowNum();
        // of no data on sheet
        if(totalRowInSheet == 0){
            return new Object[0][0];
        }

        int totalColumn = sheet.getRow(0).getLastCellNum();
        data = new Object[totalRowInSheet][totalColumn];

        // in case ignoreFirstRow = true then data[][] should start from 0th index
        int startData = 0;

        for (int i=0; i <= totalRowInSheet; i++) {
            // if first column is header then skip that column
            if(ignoreFirstRow){
                ignoreFirstRow = false;
                continue;
            }

            row = sheet.getRow(i);
            int totalColumnInRow = row.getLastCellNum();

            for (int j = 0; j < totalColumnInRow; j++) {
                System.out.println(row.getCell(j).getStringCellValue());
                data[startData][j] = row.getCell(j).getStringCellValue().trim();
            }
            startData++;
        }
        //System.out.println(Arrays.deepToString(data));
        return data;
    }





}
