package testngcompare;

import org.testng.annotations.Test;

import utility.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Alert extends WebDriverManager {
	WebDriver driver;


By alert = By.xpath("//*[@id=\"alert-modal\"]");
By javascriptalert = By.xpath("/html/body/section/div/div/div[1]/div/div/ul/li[5]/a");
By button = By.xpath("/html/body/section/div/div/div[2]/div[1]/div/div[2]/button");
By confirmButton =By.xpath("/html/body/section/div/div/div[2]/div[2]/div/div[2]/p[4]/button");
By displayedtxt=By.id("confirm-demo");
By promptButton=By.xpath("/html/body/section/div/div/div[2]/div[3]/div/div[2]/button");
By displaytxt=By.xpath("//*[@id=\"prompt-demo\"]");





  @Test(priority=1)
  public void alertTest() throws InterruptedException {
 click(alert);
 click(javascriptalert);
 click(button);
 Thread.sleep(2000);
 alertcheck("accept","");
//Alert objalert=driver.switchTo().alert();
 //objalert.accept();
 // objalert.dismiss();/
 // objalert.sendKeys("test");
 // objalert.getText();
 Thread.sleep(4000);
 click(confirmButton);
 Thread.sleep(3000);
 alertcheck("dismiss","");

String displayedtxtValue=getText(displayedtxt);
if(displayedtxtValue.contains("Cancel"))
{
Assert.assertTrue(true);
}
else
{
Assert.assertTrue(false, "Cancel not done");
}
 
  }
  @Test(priority=2)
  public void alertConfirm() throws InterruptedException{
 click(promptButton);
 Thread.sleep(3000);
 Thread.sleep(3000);
 alertcheck("text","Hello");
 Thread.sleep(3000);
 String displaytxtValue=getText(displaytxt);
 System.out.println(displaytxtValue);

 if(displaytxtValue.contains("Hello"))
 {
 Assert.assertTrue(true);
 }
 else
 {
 Assert.assertTrue(false, "text not found");
 }
 

  }
  
	
	
	
	
	
  @BeforeTest
  public void beforeTest() {
	  this.driver =launchBrowser("chrome","https://selenium.obsqurazone.com/index.php");
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
