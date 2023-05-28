package com.parallelTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksTest {

	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver= new ChromeDriver(option);
		driver.manage().window().maximize();
	}
	
	@Test
	public void brokenLinkTest() {
		
		driver.get("https://www.zlti.com/");
        List<WebElement> listofLinks=driver.findElements(By.tagName("a"));
        System.out.println(listofLinks.size());
        String storelink[]=new String[listofLinks.size()];
        int i=0;
        for(WebElement link:listofLinks) {
        	
        	String linkTxt=link.getText();
        	storelink[i]=linkTxt;
        	i++;
        }
        for(int k=0;k<storelink.length;i++) {
        	
        	driver.findElement(By.linkText(storelink[k])).click();
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	String title=driver.getTitle(); 
        	if(title.equals("404") || title.contains("Page is under construction")) {
        		
        		System.out.println(storelink[k]+" is not working");
        	}else {
        		System.out.println(storelink[k]+ "is working");
        		driver.navigate().back();
        	}
        }
        
	}
}
