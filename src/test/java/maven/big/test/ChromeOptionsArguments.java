package maven.big.test;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeOptionsArguments {
  
	public static WebDriver driver;
	
	public static void main(String[] args) {

	WebDriverManager.chromedriver().setup();
	ChromeOptions option= new ChromeOptions();
	option.addArguments("--remote-allow-origins=*");
	option.addArguments("start-maximized");
	//option.addArguments("--incognito");
	//option.addArguments("--headless");
	option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking","enable-automation"));
	driver= new ChromeDriver(option);
	//driver.manage().window().maximize();
	driver.get("https://www.guru99.com/chrome-options-desiredcapabilities.html");
	System.out.println(driver.getTitle());
	}
}
