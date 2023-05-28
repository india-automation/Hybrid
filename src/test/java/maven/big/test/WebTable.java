package maven.big.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WebTable {

	
	WebDriver driver;
     @Test
     public void WebTableDemo() {
	 
     //webtable 
     List<WebElement> rows=driver.findElements(By.tagName("tr"));	
     String exepectedText="";
     for(WebElement rowNumber:rows) {
    	 
               List<WebElement> rowData=rowNumber.findElements(By.tagName("td")); 	 
               
                  for(WebElement rowDatas:rowData) {
                	  
                	 String actualText= rowDatas.getText();
                	 
                	 if(actualText.equals(exepectedText))
                	 {
                		 System.out.println("Record is found");
                	 }
                  }
     }
	}
}
