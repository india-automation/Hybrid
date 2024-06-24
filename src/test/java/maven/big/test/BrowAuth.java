package maven.big.test;

import java.net.URI;
import java.util.function.Predicate;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowAuth {
	
	public static WebDriver driver;
	
	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
		 ChromeOptions option= new ChromeOptions();
		 option.addArguments("--remote-allow-origins=*");
		 driver= new ChromeDriver(option);
		 driver.manage().window().maximize();
		 Predicate<URI> uriPredicate = uri -> uri.getHost().contains("the-internet.herokuapp.com");
		 ((HasAuthentication) driver).register(uriPredicate, UsernameAndPassword.of("admin", "admin"));
		 driver.get("https://the-internet.herokuapp.com/basic_auth");
		 System.out.println("new changes to commmit");
		 System.out.println("change 2");
		 System.out.println("Test 4");
		 System.out.println("change 2");
		 System.out.println("Test 4");
		 System.out.println("change 2");
		 System.out.println("Test 4");
		 System.out.println("change 2");
		System.out.println("INdia is new developing country");
		 
	}
}
