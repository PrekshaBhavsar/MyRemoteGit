package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FbSignUp {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://en-gb.facebook.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement CreateNewAcc = driver.findElement(By.xpath("//*[text()='Create New Account']"));

		CreateNewAcc.click();
		
		WebElement Month = driver.findElement(By.xpath("//*[@id = 'month']"));
		
		Select MonthDropDown = new Select(Month);		
		MonthDropDown.selectByVisibleText("Jan");
		
		WebElement Gender = driver.findElement(By.xpath("//*[@type = 'radio' and @value='2']"));
		
		Gender.click();
		
		////*[@type = 'radio' and @value='2']/following::input
		////*[@type = 'radio' and @value='2']/preceding::input
		////label[text()='Male']/following-sibling::input
		////*[contains(text(),'you connect')]
		////*[starts-with(text(),'Facebook helps')]
		
		//driver.quite();

	}

}
