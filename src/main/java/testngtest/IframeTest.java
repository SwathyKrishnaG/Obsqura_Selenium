package testngtest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.WebDriverManager;

public class IframeTest extends WebDriverManager {
	  WebDriver driver;
	  @Test
	  public void iframeCheck() throws InterruptedException {  
	 Thread.sleep(5000);
	 WebElement iframe=driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/iframe"));
	 driver.switchTo().frame(iframe);
	 
	 Thread.sleep(3000);
	 WebElement javascript= driver.findElement(By.linkText("JAVASCRIPT"));    // javascriptclick
	// javascript.click();
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 js.executeScript("arguments[0].click();", javascript);
	 Thread.sleep(3000);
	 driver.switchTo().defaultContent();
	 
	 
	 
	// Javascriptscroll
	 
		 
		 js.executeScript("window.scrollBy(0,600)");
		 Thread.sleep(5000);
		 //javascriptwaitimplementation
		 js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
		
		
	 
	 
	  }
	  @BeforeTest
	  public void beforeTest() {
	 this.driver = launchBrowser("chrome","https://www.w3schools.com/html/html_iframe.asp");
	//implicitWait(5);
	  }

	  @AfterTest
	  public void afterTest() {
	 driver.close();
	  }
	
	  
  
}
