package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testNGExample.TestNGListner;


@Listeners(TestNGListner.class)
public class LoginTest {

	WebDriver driver;

	/*public static void main(String[] args) {

		LoginTest obj = new LoginTest();

		obj.Setup();
		obj.Testcase1();
		obj.Cleanup();

	}*/

	XSSFWorkbook wbook;
    XSSFSheet Sheet1;
    
    
	
	@BeforeMethod
	public void Setup() throws IOException{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://www.simplilearn.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		FileInputStream fis = new FileInputStream("exceldata.xlsx");
		
		wbook = new XSSFWorkbook(fis);
		
		Sheet1 = wbook.getSheet("data");
	}

	@Test
	@Parameters({"username","password"})
	public void Testcase1(String username,String password) {
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));

		LoginLink.click();

		WebElement Username = driver.findElement(By.name("user_login"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement LoginBtn = driver.findElement(By.name("btn_login"));
		WebElement Remember = driver.findElement(By.className("rememberMe"));

		//String excelUsername  = Sheet1.getRow(0).getCell(0).getStringCellValue();
		//String excelPassword  = Sheet1.getRow(0).getCell(1).getStringCellValue();
		
		Username.sendKeys(username); //we can use Parameter : username
		Password.sendKeys(password); //we can use Parameter : password
		Remember.click();
		LoginBtn.click();

		//WebElement loginError = driver.findElement(By.id("msg_box"));

		//String LoginError = loginError.getText();
		//String ExpError = "The email or password you have entered is invalid.";

		/*if (LoginError.equals(ExpError)) {
			System.out.println("TC Passed");
		} else {
			System.out.println("TC Failed");
		}*/
		
		//Assert.assertEquals(LoginError, ExpError);

		List<WebElement> Links = driver.findElements(By.tagName("input"));
		System.out.println("total links " + Links.size());

	}

	@AfterMethod
	public void Cleanup() {
		driver.quit();
	}
}
