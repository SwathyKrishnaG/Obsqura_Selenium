package javatest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TitleCheckCase {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Launching web browser
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.obsqurazone.com/index.php");
		
		// Test case to verify title
		String titleexpected ="Obsqura Testing";
		String titleactual = driver.getTitle();
		if(titleexpected.equals(titleactual)) {
			
			System.out.println("Test passed");
		}else {
			
			System.out.println("Testfailed");
		}
				
		driver.close();

	}

}
