package TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class UserStory2 {

WebDriver driver;
	
	@Test
	public void TestCase() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver"  , "C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.get("http://www.westpac.co.nz/");
	    driver.findElement(By.linkText("KiwiSaver calculator")).click();
		driver.findElement(By.linkText("Click here to get started.")).click();  
		
		Thread.sleep(5000);
		 driver.switchTo().frame(0);
		 
		 Actions actions = new Actions(driver);
		 
		
			//Current age =45
			
		  WebElement element = driver.findElement(By.xpath("//div[@help-id='CurrentAge']//input[@class='ng-pristine ng-valid']"));
			actions.moveToElement(element).click().sendKeys("45").perform();
			
			//Employment status
		 
			element = driver.findElement(By.xpath("//div[@help-id='EmploymentStatus']//i[@class='ir dropdown-arrow']"));
			actions.moveToElement(element).click().perform();
			driver.findElement(By.xpath("//span[@class='ng-scope' and text()='Self-employed']")).click();
			
			// PIR
			element = driver.findElement(By.xpath("//div[@help-id='PIRRate']//i[@class='ir dropdown-arrow']"));
			actions.moveToElement(element).click().perform();
			driver.findElement(By.xpath("//span[@class='ng-binding ng-scope' and text()='10.5%']")).click();
			
			//Kiwisaver balance
			element = driver.findElement(By.xpath("//div[@help-id ='KiwiSaverBalance']//div[@class='control-well']"));
			actions.moveToElement(element).click().sendKeys("100000").perform();
			
			// Voluntary contribution
			
			element= driver.findElement(By.xpath("//div[@help-id='VoluntaryContributions']//div[@class='control-cell']"));
			actions.moveToElement(element).click().perform();
			driver.findElement(By.xpath("//input[@class='ng-pristine ng-valid']")).sendKeys("90");

			driver.findElement(By.xpath("//div[@class='dropdown']//li[@value='fortnight']")).click();
			
			//Risk Profile
			driver.findElement(By.xpath("//input[@value='medium']")).click();
			
			//Saving goal 
			element = driver.findElement(By.xpath("//div[@help-id='SavingsGoal']//input[@class='ng-pristine ng-valid']"));
			actions.moveToElement(element).click().sendKeys("290000").perform();
			
//Complete the form to see your KiwiSaver retirement projections.
			
			driver.findElement(By.xpath("//button[@class='btn btn-regular btn-results-reveal btn-has-chevron']")).click();
			
			//Display your KiwiSaver balance is estimated to be:
			
			String KSBal = driver.findElement(By.xpath("//span [@class='result-value result-currency ng-binding']")).getText();
			
			System.out.println("KiwiSaver balance is estimated to be:" +KSBal);
			
			
			
			
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		  
	}
	
}
