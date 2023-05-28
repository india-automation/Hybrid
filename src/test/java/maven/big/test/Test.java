package maven.big.test;

import java.io.File;
import java.util.Arrays;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	
	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option= new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
        option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking","enable-automation"));
        option.addArguments("disable-extentions");
        option.addArguments("start-maximized");
        option.addArguments("--disable-notifications");
        option.addExtensions(new File("C:\\Users\\Admin\\Desktop\\Photon\\CRX-Extractor-Downloader.crx"));
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(ChromeOptions.CAPABILITY, option);
        option.merge(cap);        
        driver= new ChromeDriver(option);
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
    	driver.manage().window().maximize();		
	}
}
