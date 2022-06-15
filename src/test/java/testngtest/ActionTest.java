package testngtest;

import org.testng.annotations.Test;


import utility.WebDriverManager;

import org.testng.annotations.BeforeTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.Keys;

public class ActionTest extends WebDriverManager {
	WebDriver driver;
  @Test(priority=1,enabled=true)
  public void moveElement() {
	  
	  WebElement inputForm = driver.findElement(By.xpath("//*[@id=\"collapsibleNavbar\"]/ul/li[2]/a"));
	  Actions action = new Actions(driver);
	  action.moveToElement(inputForm).click().build().perform();
	  
	  WebDriverWait wait=new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control']")));
	 
	  WebElement Text = driver.findElement(By.xpath("//input[@class='form-control']"));
	  Actions action11 = new Actions(driver);
	  action11.moveToElement(Text).click().build().perform();
	  Text.sendKeys("hello");
	  Text.sendKeys(Keys.TAB);
	  
	 
  }
	 
	 @Test(priority=2,enabled=true)
	  public void actionalert()  {
		 Alert alertbox;
	  
	  WebElement alert = driver.findElement(By.id("alert-modal"));
	  Actions action1 = new Actions(driver);
	  action1.moveToElement(alert).click().build().perform();
	  
	  
	  
	  WebElement javascriptalert = driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/div/ul/li[5]/a"));
	  Actions action2 = new Actions(driver);
	  action2.moveToElement(javascriptalert).click().build().perform();
	  
	  
	  
	  WebElement promptButton =driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[3]/div/div[2]/button"));
	  Actions action3 = new Actions(driver);
	  action3.moveToElement(promptButton).click().build().perform();
	  
	  WebDriverWait wait=new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.alertIsPresent());
	 
	  alertbox =   driver.switchTo().alert();
	  alertbox.accept();
	  
	  
	 }
	  
	 
	  
	  
	  
	  
	  
	  
	  
  
  @BeforeTest
  public void beforeTest() {
	  this.driver = launchBrowser("chrome","https://selenium.obsqurazone.com/index.php");
	  
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
