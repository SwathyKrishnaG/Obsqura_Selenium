package testngcompare;

import org.testng.annotations.Test;

import utility.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class XpathTest extends WebDriverManager{
	WebDriver driver;
  @Test(priority=1,enabled=true)
  public void menuList() throws InterruptedException {
	  
	   Navigation(2).click();
	   Thread.sleep(3000);
	   
	  // Navigation(4).click();
	 //  Thread.sleep(3000);
	  Option("Simple Form Demo").click();
	  Thread.sleep(3000);
	   
	  
  }
  
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  this.driver =launchBrowser("chrome","https://selenium.obsqurazone.com/index.php");
	   
	 
	  
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
