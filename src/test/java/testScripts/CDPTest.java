package testScripts;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v100.network.Network;
import org.openqa.selenium.devtools.v100.network.model.Headers;
import org.openqa.selenium.devtools.v101.emulation.Emulation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

public class CDPTest {
	
	ChromeDriver driver;
	DevTools devTools;
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "admin";
	@BeforeMethod
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		devTools = driver.getDevTools();
		devTools.createSession();
		
	}
	
//  @Test
  public void deviceModeTest() {
	  Map dviceMetrics = new HashMap() {{
		  put("width", 300);
		  put("height", 600);
		  put("mobile", true);
		  put("deviceScaleFactor", 50);
	  }};
	driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", dviceMetrics);
	driver.get("https://www.selenium.dev/");
	
  }
  
//  @Test
  public void geoLocTest() {
	  Map geoLoc = new HashMap() {{
		  put("latitude", 33.748997);
		  put("longitude",-84.387985);
		  put("accuracy", 100);
	  }};
	  
	  driver.executeCdpCommand("Emulation.setGeolocationOverride", geoLoc);
	  driver.get("https://oldnavy.gap.com/stores");
		
  }
  
  @Test
  public void basicAuthTest() {
//	  devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
	  driver.get("http://the-internet.herokuapp.com/basic_auth");
	  Map<String, Object> headers = new HashMap<String, Object>();
	  
	  String basicAuth = "Basic " + new String(new Base64()
			  .encode(String.format("%s:%s", USERNAME, PASSWORD).getBytes()));
	  System.out.println("Authorization : ....." + basicAuth);
	  headers.put("Authorization", basicAuth);
	  devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));
	  driver.get("http://the-internet.herokuapp.com/basic_auth");
	  
  }
  
}
