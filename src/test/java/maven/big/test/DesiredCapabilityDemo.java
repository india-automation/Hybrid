package maven.big.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DesiredCapabilityDemo {
	
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option= new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver= new ChromeDriver(option);
		driver.get("https://www.orangehrm.com/");
		driver.manage().window().maximize();
  		List<WebElement> element=driver.findElements(By.xpath("//body/nav[1]/div[1]/div[1]"));	
        System.out.println(element.size());  
        System.out.println(element.get(0).getText());
        Select select;
        select= new Select(driver.findElement(By.xpath("")));
        select.selectByIndex(0);
        select.selectByValue("");
        select.selectByVisibleText("");
        select.deselectAll();
        select.deselectByIndex(1);
        select.deselectByValue("");
        select.deselectByVisibleText("");
        List<WebElement> monthsoptions=select.getOptions();
        
        for(int i=0; i< monthsoptions.size();i++)
        {
        String text=monthsoptions.get(i).getText();	
        if(!text.equals("mango")){
        	
        	driver.findElement(By.id("")).click();
        }
        }
	}
}
