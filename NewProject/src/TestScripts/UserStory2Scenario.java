package TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class UserStory2Scenario {

	
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
		 
		 //  When Current age = 30
		WebElement element = driver.findElement(By.xpath("//div[@help-id='CurrentAge']//div[@class='control-well']"));
			
			actions.moveToElement(element).click().sendKeys("30").perform();
			
			//Employment status = Employed

			 element = driver.findElement(By.xpath("//div[@help-id='EmploymentStatus']//i[@class='ir dropdown-arrow']"));
			actions.moveToElement(element).click().perform();
			driver.findElement(By.xpath("//div[@class='dropdown']//li[@value='employed']")).click();
			
			//Salary or wages per year (before tax)
			
			driver.findElement(By.xpath("//div[@help-id='AnnualIncome']//input[@class='ng-pristine ng-valid']")).sendKeys("82000");
			
			//KiwiSevar member contribution

			driver.findElement(By.xpath("//input[@id='radio-option-06E']")).click();
			
			//PIR

			element = driver.findElement(By.xpath("//div[@help-id='PIRRate']//i[@class='ir dropdown-arrow']"));
			actions.moveToElement(element).click().perform();
			driver.findElement(By.xpath("//span[@class='ng-binding ng-scope' and text()='17.5%']")).click();
			
			  // Risk profile

			driver.findElement(By.xpath("//input[@value='high']")).click();
			

			//Complete the form to see your KiwiSaver retirement projections.

			
			driver.findElement(By.xpath("//button[@class='btn btn-regular btn-results-reveal btn-has-chevron']")).click();

			
			//Display your KiwiSaver balance is estimated to be:

			
			String KSBal = driver.findElement(By.xpath("//span [@class='result-value result-currency ng-binding']")).getText();
			
			System.out.println("KiwiSaver balance is estimated to be:" +KSBal);
		 
	}
		 
}


          // below is the output 

/*[RemoteTestNG] detected TestNG version 6.14.3
Starting ChromeDriver 2.39.562718 (9a2698cba08cf5a471a29d30c8b3e12becabb0e9) on port 22502
Only local connections are allowed.
May 07, 2019 11:12:19 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: OSS
KiwiSaver balance is estimated to be:$
313,971
PASSED: TestCase

===============================================
    Default test
    Tests run: 1, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 1, Failures: 0, Skips: 0
===============================================  */








