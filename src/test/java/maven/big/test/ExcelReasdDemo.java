package maven.big.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.excek.utility.ExcelRead;

public class ExcelReasdDemo extends ExcelRead{

	
	
	@Test
	public void excelRead() throws IOException {
		
		fileRead();
	}
}
