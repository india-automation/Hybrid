package maven.big.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.excek.utility.ExcelWrite;

public class WriteFile extends ExcelWrite {

	
	
	@Test
	public void fileWrites() throws IOException {
		
		
		String datawrite[]= {"Laxman", "More"};
		fileWrite("TestExcel.xlsx",System.getProperty("user.dir")+"//src//main//java//com//excelfile","data",datawrite);
		                           
	}
}
