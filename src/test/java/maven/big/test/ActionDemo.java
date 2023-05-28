package maven.big.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class ActionDemo {

	
	WebDriver driver;
    Actions action;    
	@Test
    public void dragandDrop() throws AWTException {
		
  	action = new Actions(driver);
  	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  	WebElement source=driver.findElement(By.id(""));
	WebElement destination=driver.findElement(By.id(""));
	
	action.dragAndDrop(source, destination);
	action.moveToElement(source).clickAndHold().moveToElement(destination).build().perform();
	
	//Scroll Page.
	
	JavascriptExecutor executor=(JavascriptExecutor)driver;
	executor.executeScript("window.scrollBy(0,1000)");
	
	executor.executeScript("arguments[0].scrollIntoView();",source);
	
	executor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	
	
	//using action class scroll down.
    action.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
    action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();
    
    action.contextClick(source);
    action.doubleClick(destination);
    
    action.keyDown(Keys.ENTER).build().perform();
    action.keyUp(Keys.ENTER).build().perform();
    
    action.sendKeys(Keys.ENTER).build().perform();
    
    action.keyDown(Keys.CONTROL).sendKeys("a");
    action.keyUp(Keys.CONTROL).build().perform();
    
    driver.findElement(By.xpath("")).sendKeys(Keys.ENTER);
    driver.findElement(By.xpath("")).sendKeys(Keys.chord(Keys.CONTROL,"a"));
    
    action.keyDown(Keys.SHIFT).sendKeys("a");
    action.keyDown(source, Keys.SHIFT).sendKeys("a");
    
    
    //Using Robot Class scroll down.
    
    Robot robot= new Robot();
    robot.keyPress(KeyEvent.VK_PAGE_DOWN);
    robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
    
    robot.keyPress(KeyEvent.VK_PAGE_UP);
    robot.keyRelease(KeyEvent.VK_PAGE_UP);
    
    //Mouse Hover.
   action.moveToElement(destination).build();
   String txt=destination.getText();
   
   String title=driver.findElement(By.xpath("")).getAttribute("title");
   System.out.println(title); 
   
   driver.switchTo().frame(0);
   driver.switchTo().frame("");
   driver.switchTo().frame(destination);
   driver.switchTo().frame("parentFrame").switchTo().frame("childFrame");
   driver.switchTo().defaultContent();
   driver.switchTo().parentFrame();
   
  /* //Explicit wait
   WebDriverWait wait = new WebDriverWait(driver,Duration.ofMinutes(1));
   
    wait.until(ExpectedConditions.elementToBeClickable(By.id("")));
    wait.until(ExpectedConditions.elementToBeClickable(destination));
*/
    //Fluent wait.
    
    Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
    .withTimeout(Duration.ofSeconds(20))
    .pollingEvery(Duration.ofSeconds(05))
    .ignoring(Exception.class);
    
    
    

     WebElement clickobjlink =wait.until(new Function<WebDriver, WebElement>(){
     	
       	public WebElement apply(WebDriver driver) {

            WebElement  test= driver.findElement(By.xpath("By.xpath(\"/html/body/div[1]/section/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/a/i\")"));
          
            return test;
       	   
       	}
    
	});
     
     
     
	
}
}
