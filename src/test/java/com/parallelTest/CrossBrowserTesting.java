package com.parallelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTesting {

	WebDriver driver;
	
	@BeforeTest
	@Parameters({"browser"})
	public void crossTesting(String browsers) throws Exception{
		
		if(browsers.equals("chrome")) {
		   WebDriverManager.chromedriver().setup();
		   ChromeOptions option= new ChromeOptions();
		   option.addArguments("--remote-allow-origins=*");
		   driver= new ChromeDriver(option);
		   driver.manage().window().maximize();
		}
		else if(browsers.equals("firefox")) {
			driver= new FirefoxDriver();
			driver.get("https://www.guru99.com/selenium-tutorial.html");
			driver.manage().window().maximize();
		}else {
			System.out.println("invalid browser name:"+browsers);
		}
	}
	@Test
	public void loginTest() {
		driver.get("http://demo.guru99.com/V4/");
		//Find user name
		WebElement userName = driver.findElement(By.name("uid"));
		//Fill user name
		userName.sendKeys("guru99");
		//Find password
		WebElement password = driver.findElement(By.name("password"));
		//Fill password
		password.sendKeys("guru99");
		
	}
}
