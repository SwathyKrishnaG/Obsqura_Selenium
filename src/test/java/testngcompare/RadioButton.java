package testngcompare;

import org.testng.annotations.Test;

import utility.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class RadioButton extends WebDriverManager {
	WebDriver driver;
	By inputform = By.xpath("//*[@id=\"collapsibleNavbar\"]/ul/li[2]/a");
	By radio = By.xpath("/html/body/section/div/div/div[1]/div/div/ul/li[3]/a");
	By choice = By.id("inlineRadio2");
	By show = By.id("button-one");
	By message = By.id("message-one");

	@Test(priority = 1, enabled = true)
	public void radioCase() throws InterruptedException, IOException {

		click(inputform);
		click(radio);
		
		click(choice);
		Screenshot();
		click(show);
		highlightelement(show);
		Screenshot();
		String exptxt = getText(message);
		String acttxt = "Female";
		if ((exptxt).contains(acttxt)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false, "radio button selection failed");
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
