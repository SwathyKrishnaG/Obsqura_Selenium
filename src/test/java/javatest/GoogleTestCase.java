package javatest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTestCase {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Launching browser
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");		
		driver.close();

	}

}
