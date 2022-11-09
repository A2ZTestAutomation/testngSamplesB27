package testScripts;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoteDriverTest {
	WebDriver driver;
	  @Test
	  public void searchJava() throws IOException {
		  
		  ChromeOptions options = new ChromeOptions();
		  options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
//		  options.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
//		  options.setCapability(CapabilityType.BROWSER_VERSION, 105);
		  String strHub = "http://192.168.1.6:4444/";
		  driver = new RemoteWebDriver(new URL(strHub), options);
		  driver.manage().window().maximize();
		  driver.get("https://www.google.com/");
		 	WebElement srcBox = driver.findElement(By.name("q"));
			srcBox.sendKeys("Selenium Tutorial");
			srcBox.submit();
			System.out.println("Page Title ....."+ driver.getTitle());
			Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search");
	  }
	  
	  //java -jar selenium-server-4.3.0.jar standalone
	  //java -jar selenium-server-4.3.0.jar hub
	  
	  
}
