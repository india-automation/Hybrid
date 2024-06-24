package maven.big.test;

import java.net.URI;
import java.util.Arrays;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserAuthentication {

	public static WebDriver driver;
	public static void main(String[] args) {

		 WebDriverManager.chromedriver().setup();
		 ChromeOptions opt= new ChromeOptions();
     	 opt.addArguments("--remote-allow-origins=*");
     	 opt.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking","enable-automation"));
     	 driver= new ChromeDriver(opt);
		 driver.manage().window().maximize();
		
			      /*String a = "admin";
			      // appending username, password with URL
			      String s = "https://" + a + ":" + a + "@" +
			      "the-internet.herokuapp.com/basic_auth";
			      */
			      String p="https://admin:admin@the-internet.herokuapp.com/basic_auth";
			 	 System.out.println("1");
			      driver.get(p);
			      // identify text
			      String m = driver.findElement(By.cssSelector("p")).getText();
			      System.out.println("Text is: " + m);
			      
	}
}
