package com.parallelTest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableDemo {

WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver= new ChromeDriver(option);
		driver.manage().window().maximize();
	}
	
	/*@Test
	public void webTableTest() {
		
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		List<WebElement> col=driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th"));
		System.out.println("Number of Columns are: "+col.size());
	    List<WebElement> rows=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
		System.out.println("Number of rows are:"+rows.size());
		//Generic code to get specific row and column cell value of the dynamic table.
       
		for(int i=1;i<=rows.size();i++) {
			
			for(int j=1;j<=col.size();j++) {
				
			    WebElement text=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+i+"]/td["+j+"]"));
				String cellData=text.getText();
				System.out.print(cellData+"  , ");
			}
			System.out.println();
		}
		//WebElement cellText=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[3]/td[2]"));
		//System.out.println(cellText.getText());
			
	}
	*/
    @Test
    public void maxData() {
	      
    	driver.get("https://demo.guru99.com/test/web-table-element.php");
		List<WebElement> col=driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th"));
		System.out.println("Number of Columns are: "+col.size());
	    List<WebElement> rows=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
		System.out.println("Number of rows are:"+rows.size());
		float max=0;
         for(int i=1;i<=rows.size();i++) {
			
			    WebElement text=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+i+"]/td[3]"));
				String cellData=text.getText();
				float CellNUmnericData=Float.valueOf(cellData);
				if(CellNUmnericData>max) {
					max=CellNUmnericData;
				}
		}
         System.out.println("Maximum vlaue of previous Close is :"+max);
}
}
