package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.google.common.io.Files;

public class WebDriverManager {
	
	
	public static WebDriver driver;

	
	
	
	public WebDriver launchBrowser(String browser,String url) {
		String browser1= browser.toLowerCase();
	      switch(browser1)
	      {
	      
	      
	      case "chrome":
	      System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
	      driver=new ChromeDriver();
	      break;
	      case "IE":
	      System.setProperty("webdriver.ie.driver", "E:\\selenium\\IEDriverServer.exe");  
	               
	          // Instantiate a IEDriver class.    
	      driver=new InternetExplorerDriver();
	      break;
	      case "edge":
		      System.setProperty("webdriver.edge.driver","E:\\selenium\\msedgedriver.exe");
		      driver = new EdgeDriver();
		      break;

	      case "firefox":
	      System.setProperty("webdriver.gecko.driver","E:\\selenium\\geckodriver.exe");
	      driver = new FirefoxDriver();



	      }

			
		driver.manage().window().maximize();
		driver.get(url);
		implicitWait(5);
		return driver;
	}
	
	    public WebDriver implicitWait (int a) {
		driver.manage().timeouts().implicitlyWait(a,TimeUnit.SECONDS);
		return driver;
		}
		public WebDriver implicitWait (long a) {
			driver.manage().timeouts().implicitlyWait(a,TimeUnit.SECONDS);
			return driver;

	
		}
	


		public WebDriver getdriver() {
		return  WebDriverManager.driver;
		}		
	
	public void click(By value) throws InterruptedException {
		Thread.sleep(3000);
	driver.findElement(value).click();
	}
	
	public String getText(By value) throws InterruptedException {
		Thread.sleep(3000);
		return driver.findElement(value).getText();
		
		
	}
	
	public void sendText(By value,String text) throws InterruptedException
	{
	Thread.sleep(3000);
	driver.findElement(value).sendKeys(text);
	}
	
	public void alertcheck(String option,String text)
	{
	Alert objalert =driver.switchTo().alert();
	if(option.equals("dismiss"))
	{
	objalert.dismiss();
	}
	if(option.equals("accept"))
	{
	objalert.accept();
	}
	if(option.equals("text"))
	{
	objalert.sendKeys(text);
	objalert.accept();
	}
	}
	
	public void Screenshot() throws IOException{
		
        String finaldate=java.time.Clock.systemUTC().instant().toString().replace(":", "_");
		
			
		
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		
		String newt="test";
		String extention=".png";
		String filename=newt+finaldate+extention;
		File DestFile = new File("E:\\screenshot\\Test"+filename);

		Files.copy(SrcFile, DestFile);
		
		}

		public void highlightelement(By value) {

		WebElement ele = driver.findElement(value);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//use executeScript() method and pass the arguments
		//Here i pass values based on css style. Yellow background color with solid red color border.
		js.executeScript("arguments[0].setAttribute('style','border: 2px solid red;');", ele);
		}
		
		public WebElement Navigation(int i) {
			return driver.findElement(By.xpath("(//a[@class='nav-link'])["+i+"]"));
		}
		
		public WebElement Option(String a) {
			return driver.findElement(By.xpath("//*[contains(text(),'"+a+"')]"));
		}
	

 
	}

