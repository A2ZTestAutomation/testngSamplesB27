package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTwoTest {
  @Test(groups="featureOne")
  public void searchCypressTest() {
	 System.out.println("Cypress Test");
  }
  @Test(groups="featureTwo")
  public void searchCucumberTest() {
	 System.out.println("Cucumber Test");
  }
  @Test(groups = "featureThree")
  public void searchAPITest() {
	 System.out.println("API Test");
  }
}
