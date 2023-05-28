package maven.big.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.excek.utility.ExcelRead;

public class ReadFile extends ExcelRead {
	
   @Test
   public void readFile() throws IOException {
	   
	   
	   //fileRead("TestExcel.xls","C:\\\\Users\\\\Admin\\\\Desktop\\\\Photon\\\\Photon workspace\\\\TestExcel.xlsx","data");
	   fileRead();
	   
   }
}
