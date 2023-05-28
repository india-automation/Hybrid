import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink2 {

	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver= new ChromeDriver(option);
		driver.manage().window().maximize();
	}
	
	@Test(groups="smoke")
	public void brokenLinkTest() throws IOException {
		
		String homePage = "http://www.zlti.com";
	    HttpURLConnection huc=null;
	    String url="";
	    int respCode=200;
	    
		driver.get("https://www.zlti.com/");
        List<WebElement> listofLinks=driver.findElements(By.tagName("a"));
        Iterator<WebElement> linkIterate =listofLinks.iterator();
        while(linkIterate.hasNext()) {
        url=linkIterate.next().getAttribute("href");
        if(url==null || url.isEmpty()) {
        	System.out.println(url+" ... URL is null or empty");
        }/*if(!url.startsWith(homePage)) {
        	System.out.println(url+" is from different domain");
        }*/
        
        try {
        	
        	URL urls= new URL(url);
          huc=(HttpURLConnection)urls.openConnection();
          huc.connect();
          respCode=huc.getResponseCode();
          if(respCode>=400) {
        	  System.out.println(url+" is a broken link");
          }else {
        	  System.out.println(url+" is valid link");
          }
        	
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        
        
	}
}
