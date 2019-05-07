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
		 
		
			// WHEN CURRENT AGE = 45
			
		  WebElement element = driver.findElement(By.xpath("//div[@help-id='CurrentAge']//input[@class='ng-pristine ng-valid']"));
			actions.moveToElement(element).click().sendKeys("45").perform();
			
			//Employment status = SELF-EMPLOYED
		 
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
			
			
			
			
		 // Below is the output
			
		/*..	[RemoteTestNG] detected TestNG version 6.14.3
			Starting ChromeDriver 2.39.562718 (9a2698cba08cf5a471a29d30c8b3e12becabb0e9) on port 36769
			Only local connections are allowed.
			May 07, 2019 10:56:04 PM org.openqa.selenium.remote.ProtocolHandshake createSession
			INFO: Detected dialect: OSS
			KiwiSaver balance is estimated to be:$
			230,481
			PASSED: TestCase

			===============================================
			    Default test
			    Tests run: 1, Failures: 0, Skips: 0
			===============================================


			===============================================
			Default suite
			Total tests run: 1, Failures: 0, Skips: 0
			===============================================  */


		 
		 
		 
		 
		 
		 
		 
		 
		 
		  
	}
	
}
