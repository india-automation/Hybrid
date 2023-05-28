package com.excek.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

		FileInputStream fileinput=null;
		FileOutputStream fileout=null;
		File file=null;
		public void fileWrite(String fileName ,String filepath, String sheetName , String daattoWrite[]) throws IOException {
			System.out.println(System.getProperty("user.dir"));
			file= new File(filepath+"//"+fileName);
			System.out.println(file);
			fileinput= new FileInputStream(file);
			XSSFWorkbook workbook= new XSSFWorkbook(fileinput);
			XSSFSheet sheet=workbook.getSheet(sheetName);
			System.out.println(sheet);
			int lastrownum=sheet.getLastRowNum();
			System.out.println(lastrownum);
			
				XSSFRow row=sheet.createRow(lastrownum+1);
				for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				XSSFCell cell=row.createCell(j);
				cell.setCellValue(daattoWrite[j]);
				System.out.println(daattoWrite[j]);
			}
            fileout= new FileOutputStream(file);
            workbook.write(fileout);   
            System.out.println("File write done successfully..");
            
		}
}
