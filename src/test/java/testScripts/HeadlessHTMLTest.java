package testScripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeadlessHTMLTest {
	WebDriver driver;
  @Test
  public void searchJava() throws IOException {
	  driver = new HtmlUnitDriver();
	  driver.get("https://www.google.com/");
	 	WebElement srcBox = driver.findElement(By.name("q"));
		srcBox.sendKeys("Selenium Tutorial");
		
//		TakesScreenshot scr = (TakesScreenshot)driver;
//		File scrFile = scr.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(scrFile, new File("F:\\Screenshot\\HeadlessTest.png"));
		
		srcBox.submit();
		
		System.out.println("Page Title ....."+ driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search");
  }
}
