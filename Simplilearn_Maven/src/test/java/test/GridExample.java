package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridExample {

	public static void main(String[] args) throws MalformedURLException {
		
		//WebDriver driver = new ChromeDriver();
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setPlatform(Platform.WINDOWS);
		cap.setBrowserName("chrome");
		
		String sURL = "http://localhost:4444/wd/hub";
		
		WebDriver driver = new RemoteWebDriver(new URL(sURL),cap);
		
		 driver.get("https://www.simplilearn.com/");
	        
	     driver.manage().window().maximize();
	        
	     driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	     
	     driver.quit();

	}

}
