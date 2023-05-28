package com.parallelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionDemo {

	
	Actions action;
	WebDriver driver;
	@BeforeTest
	public void setup() {

	 	System.out.println("Before test method");
	 	System.out.println("Commit 5");
	 	System.out.println("new changes");

	}
	
	@Test
	public void start() {
	
	WebElement source=driver.findElement(By.xpath(""));	
	WebElement destination=driver.findElement(By.xpath(""));	
	
	action= new Actions(driver);
	action.moveToElement(source).doubleClick().moveToElement(destination).release().build().perform();
	action.dragAndDrop(source, destination);
	//keyboard action
	
	Action act=action.keyDown(source,Keys.SHIFT).sendKeys("a")
    .keyUp(source,Keys.SHIFT)
    .doubleClick()
    .dragAndDrop(source, destination)
    .contextClick(destination)
    .clickAndHold(source).moveToElement(destination)
    .dragAndDropBy(source,100,200)
    .keyDown(source,Keys.ALT).build();
   	 act.perform();
    
	}
}
