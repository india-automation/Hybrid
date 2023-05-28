package com.excek.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	
	FileInputStream fileinput=null;
	File file=null;
	public void fileRead() throws IOException {
		file= new File("C:\\Users\\Admin\\Desktop\\Photon\\Photon workspace\\TestExcel.xlsx");
		fileinput= new FileInputStream(file);
		XSSFWorkbook workbook= new XSSFWorkbook(fileinput);
		XSSFSheet sheet=workbook.getSheet("data");
		XSSFRow row=sheet.getRow(0);
		System.out.println("total columns :"+row.getLastCellNum());
		System.out.println(sheet.getFirstRowNum());
		System.out.println(sheet.getLastRowNum());
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		System.out.println(rowCount);
        for(int i=0;i<=rowCount;i++)
        {	
        	for(int j=0;j<row.getLastCellNum();j++)
        	{
        	     System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+"  ");
        		
        	}
        	System.out.println();
        	
        }
		
		/*if(fileName.substring(fileName.indexOf(".")).equals(".xlsx")) {
        	XSSFWorkbook workbook= new XSSFWorkbook(fileinput);
    		XSSFSheet sheet=workbook.getSheet(sheetName);
        }else {
        	
        	HSSFWorkbook workbook= new HSSFWorkbook(fileinput);
        	HSSFSheet sheet=workbook.getSheet(sheetName);
        	
        }*/
	}
}

