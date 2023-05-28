package com.parallelTest;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandleTest {

	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver= new ChromeDriver(option);
		driver.manage().window().maximize();
	}
	@Test
	public void windoHnadleTest() throws InterruptedException {
		
		driver.get("https://demo.guru99.com/popup.php");
		driver.findElement(By.linkText("Click Here")).click();
		String mainwindow=driver.getWindowHandle();
		Set set= driver.getWindowHandles();
		ArrayList<String> listofWindow= new ArrayList<String>(set);
		System.out.println(listofWindow.size());
        for(int i=0;i<listofWindow.size();i++) {
        	
        	driver.switchTo().window(listofWindow.get(i));
        }
        driver.findElement(By.name("emailid")).sendKeys("morelaxman000@gmail.com");
        driver.findElement(By.name("btnLogin")).click();  
        driver.switchTo().window(listofWindow.get(0));
        Thread.sleep(5000);
        driver.findElement(By.linkText("Click Here")).click();
        driver.quit();
	}
}
