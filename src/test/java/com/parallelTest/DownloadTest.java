package com.parallelTest;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class DownloadTest {

	WebDriver driver;
	@Test
	public void dowload() throws InterruptedException {
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://chromedriver.storage.googleapis.com/index.html?path=113.0.5672.24/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.linkText("chromedriver_win32.zip")).click();
		Thread.sleep(10000);
        
		File file= new File(System.getProperty("user.dir"));
		File[] listofliles= file.listFiles();
		boolean found = false;
		File f = null;
		
		for(File files:listofliles) {
			if(files.isFile()) {
				 String finename =files.getName();
			     System.out.println(finename);
			     if(finename.matches("chromedriver_win32.zip")) {
			    	 f=new File(finename);
			    	 found=true;
			     }
			}
		}
		org.testng.Assert.assertTrue(found,"downloaded document is not found");
		f.deleteOnExit();
		
	}
}
