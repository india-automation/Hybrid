package com.parallelTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DesiredCapability {


	WebDriver driver;
	@BeforeTest
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
	    DesiredCapabilities cap= new DesiredCapabilities();
	    cap.setAcceptInsecureCerts(true);
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.setAcceptInsecureCerts(true);
		option.merge(cap);
		driver= new ChromeDriver(option);
		driver.manage().window().maximize();
	}
	@Test
	public void testDesiredCapability() {
		
      driver.get("https://cacert.com/");
      
	}
}
