package com.driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class driverFactory {

	public static WebDriver driver=null;
	public static Properties prop=null;
	public static FileInputStream fileInput=null;
	public driverFactory() throws IOException
	{
	  try {
		fileInput=new FileInputStream(new File("C:\\Users\\Admin\\Desktop\\Photon\\Photon workspace\\BigMaven\\src\\main\\java\\com\\properties\\property.properties"));
		prop= new Properties();
		prop.load(fileInput);
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	}
	
	public static void initdriver()
	{
	     String browserName=prop.getProperty("browser");
	     if(browserName.equals("firefox"))
	     {
	    	 driver=new FirefoxDriver();
	    	 driver.get(prop.getProperty("url"));
	     }
	     if(browserName.equals("chrome")) {
	     //System.setProperty("webdriver.chrome.driver", "D:\\Chromedriver 110\\chromedriver_win32\\chromedriver.exe");
	     WebDriverManager.chromedriver().setup(); 
	     ChromeOptions option= new ChromeOptions();
	     option.addArguments("--remote-allow-origins=*");
	     driver= new ChromeDriver(option);
		 driver.manage().window().maximize();
		 //driver.get(prop.getProperty("url"));
		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		/* Predicate<URI> uriPredicate = uri -> uri.getHost().contains("the-internet.herokuapp.com");
		 ((HasAuthentication) driver).register(uriPredicate, UsernameAndPassword.of("admin", "admin"));
		 driver.get(prop.getProperty("url"));*/
	     }
	}
}
