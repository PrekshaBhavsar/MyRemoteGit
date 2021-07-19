package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableEx {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr"));
		
		System.out.println("Total rows :"+rows.size());
		
		List<WebElement> coloumns = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr/th"));
		//List<WebElement> coloumns = driver.findElements(By.xpath("//*[@id='customers']/tbody//th"));
		System.out.println("Total columns :"+coloumns.size());
		
		
		WebElement Cdata = driver.findElement(By.xpath("//*[@id='customers']/tbody/tr[4]/td[1]"));
		
		System.out.println("column data :"+ Cdata.getText());
		
		
		
		
		for(int i= 2;i<=rows.size();i++) {
			
			int ri = i;
			WebElement data1 = driver.findElement(By.xpath("//*[@id='customers']/tbody/tr["+i+"]/td[1]"));
			WebElement data2 = driver.findElement(By.xpath("//*[@id='customers']/tbody/tr["+i+"]/td[2]"));
			WebElement data3 = driver.findElement(By.xpath("//*[@id='customers']/tbody/tr["+i+"]/td[3]"));
			System.out.println(data1.getText()+"\t"+data2.getText()+"\t"+data3.getText());
		}

		
		WebElement ScrollTo = driver.findElement(By.xpath("//*[text()='HTML Table - Collapsed Borders']"));
        
        
        JavascriptExecutor obj = (JavascriptExecutor) driver;
        obj.executeScript("arguments[0].scrollIntoView()", ScrollTo);
		
		
	}

}
