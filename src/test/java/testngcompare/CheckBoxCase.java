package testngcompare;
import utility.WebDriverManager;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CheckBoxCase extends WebDriverManager {
	
	WebDriver driver;
	
  @Test(priority=1,enabled=true)
  public void checkbox() throws InterruptedException {
	  
	   WebElement inputForm = driver.findElement(By.xpath("//*[@id=\"collapsibleNavbar\"]/ul/li[2]/a"));
	   inputForm.click();
	   Thread.sleep(3000);
	  
	    WebElement checkbox = driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/div/ul/li[2]/a"));
		checkbox.click();
		Thread.sleep(3000);
		
		WebElement checkselect = driver.findElement(By.id("gridCheck"));
		checkselect.click();
		Thread.sleep(3000);
		
		WebElement message = driver.findElement(By.id("message-one"));
		String txt= message.getText();
		String outputtxt = "Success - Check box is checked";
		if((txt).contains(outputtxt)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false, "checkbox not checked");
		}
		Thread.sleep(3000);
		  

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
