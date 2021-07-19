package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FbLogin {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://en-gb.facebook.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		/*WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		
		LoginLink.click();*/
		
		WebElement Username = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement Password = driver.findElement(By.xpath("//input[@type='password']"));
		WebElement LoginBtn = driver.findElement(By.xpath("//input[@type='password']"));
		//WebElement Remember = driver.findElement(By.className("rememberMe"));
		
		Username.sendKeys("abc@xyz.com");
		Password.sendKeys("abc123");
		LoginBtn.click();
		
		//driver.quite();
		

	}

}
