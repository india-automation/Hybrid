package maven.big.test;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CalendarHandling {

	WebDriver driver;
	@Test
	public void calendarTest() throws AWTException, IOException {
		
		WebElement calendar=driver.findElement(By.id(""));
		List<WebElement> rows=calendar.findElements(By.tagName("tr"));
        List<WebElement> columns=calendar.findElements(By.tagName("td"));
        
        for(WebElement cell:columns) {
        	
        	if(cell.getText().equals("10")) {
        		
        		cell.findElement(By.linkText("10")).click();
        	}
        }
      //Window handle.
       String parentWindow= driver.getWindowHandle();
	   Set<String> listofWindows=driver.getWindowHandles(); 
	   
	   ArrayList<String> windowsstore=new ArrayList<String>(listofWindows);
	   
	   
	   for(int i=0;i<windowsstore.size();i++)
	   {
		   driver.switchTo().window(windowsstore.get(i));
	   }
    driver.switchTo().window(parentWindow);
    //Tab.
      
    windowsstore.get(1);
    windowsstore.get(2);
    
    driver.switchTo().window(windowsstore.get(1));	
    
    //Action class to switch between tab.
    
    Actions action= new Actions(driver);
    //switch between tabs from left to right.
    action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB);
    //switch between tabs from right to left.
    action.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys(Keys.TAB);
    
    
    Robot robot= new Robot();
    robot.keyPress(KeyEvent.VK_ESCAPE);
    robot.keyRelease(KeyEvent.VK_ESCAPE);
    robot.mouseMove(123, 456);
    robot.mousePress(InputEvent.BUTTON1_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_MASK);
    robot.mouseWheel(8);
    
    //capture screenshot.
   Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
 // Capture ScreenShot
 BufferedImage img = robot.createScreenCapture(new Rectangle(size));
 // Store image into file
 File path = new File("D://profile.jpg");
 // Write image path
 ImageIO.write(img, "JPG", path);
    
    Point point=driver.findElement(By.id("")).getLocation();
    System.out.println(point.getX()+""+point.getY());
    robot.mouseMove(point.getX(),point.getY());
         
         
         
    //screnshot.
    
    
    TakesScreenshot screenshot= (TakesScreenshot)driver;
      
    File sourecFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    File destination =new File("");
    FileUtils.copyFile(sourecFile, destination);
    JavascriptExecutor exec= (JavascriptExecutor)driver;
    exec.executeScript("window.scrollBy(1,1000)");
    exec.executeScript("agument[0].scrollIntoView();",calendar);
    exec.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    
    
    
    
         
    
    
	}
	
}
