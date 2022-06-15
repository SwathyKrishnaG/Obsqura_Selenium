package testngcompare;

import org.testng.annotations.Test;

import excel.ExelCodeInstance;
import pagefactory.HomePage;
import utility.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TextVerify extends WebDriverManager{
	WebDriver driver;
	ExelCodeInstance object ;
	
  @Test(priority=3)
  public void CheckText() throws InterruptedException, IOException {
	  
	  driver = getdriver();
	  object =new ExelCodeInstance();
	  String expected = object.readData(0,1);
//	  WebElement inputForm = driver.findElement(By.xpath("//*[@id=\"collapsibleNavbar\"]/ul/li[2]/a"));
//	  inputForm.click();
//	  Thread.sleep(3000);
//	  WebElement enterMessage = driver.findElement(By.xpath("//*[@id=\"single-input-field\"]"));
//	  enterMessage.sendKeys(expected);
	  
	  //pagefactory implementation
	  HomePage objhome = new HomePage(driver);
	  objhome.inputform.click();
	  Thread.sleep(3000);
	  objhome.enterMessage.sendKeys(expected);
	  Thread.sleep(3000);
	  WebElement showMessage = driver.findElement(By.xpath("//*[@id=\"button-one\"]"));
	  showMessage.click();
	  Thread.sleep(3000);
	  WebElement appltext = driver.findElement(By.xpath("//*[@id=\"message-one\"]"));
	  String apptextvalue = appltext.getText();
	  if(apptextvalue.contains(expected)) {
		  Assert.assertTrue(true);
	  }else {
		  Assert.assertTrue(false, "text value comparison failed");
	  }
  }
  
  
  @Test(priority=4)
  public void add() throws InterruptedException {
	  
	  WebElement inputForm = driver.findElement(By.xpath("//*[@id=\"collapsibleNavbar\"]/ul/li[2]/a"));
	  inputForm.click();
	  Thread.sleep(3000);
	  
	  WebElement enterValueA = driver.findElement(By.xpath("//*[@id=\"value-a\"]"));
	  int A=5;
	  enterValueA.sendKeys(String.valueOf(A));
	  
	  Thread.sleep(3000);
	  
	  WebElement enterValueB = driver.findElement(By.xpath("//*[@id=\"value-b\"]"));
	  int B=6;
	  enterValueB.sendKeys(String.valueOf(B));
	  Thread.sleep(3000);
	  
	  WebElement getTotal= driver.findElement(By.xpath("//*[@id=\"button-two\"]"));
	  getTotal.click();
	  Thread.sleep(3000);
	  
	  WebElement appValue = driver.findElement(By.xpath("//*[@id=\"message-two\"]"));
	  String total = appValue.getText();
	  int result=A+B;
	  if((total).contains(String.valueOf(result))) {
		  Assert.assertTrue(true);
	  }else {
		  Assert.assertTrue(false, " addition of two numbers : failed");
	  }}
	    

  
 /* @BeforeTest
  public void beforeTest() throws IOException {	 
	  
	  
	  this.driver =launchBrowser("chrome","https://selenium.obsqurazone.com/index.php");}

*/
  

  @AfterTest
  public void afterTest() {
	  
	  driver.close();

  }

}
