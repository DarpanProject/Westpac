package TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class TestScenario {
	
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
		  
		 WebElement icon =  driver.findElement(By.className("icon"));
		  System.out.println(icon.isDisplayed());
		  System.out.println(icon.isEnabled());
				 
		   icon.click();
				  
		WebElement  msg=driver.findElement(By.cssSelector(".field-message.message-info.ng-binding"));
			System.out.println(msg.getText());
					
	}

	}


    //     below is the output : 
		
		// [RemoteTestNG] detected TestNG version 6.14.3
//Starting ChromeDriver 2.39.562718 (9a2698cba08cf5a471a29d30c8b3e12becabb0e9) on port 27603
//Only local connections are allowed.
//[1557136499.996][WARNING]: Timed out connecting to Chrome, retrying...
//May 06, 2019 3:25:18 PM org.openqa.selenium.remote.ProtocolHandshake createSession
//INFO: Detected dialect: OSS
//true
//true
//This calculator has an age limit of 64 years old as you need to be under the age of 65 to join KiwiSaver.
//PASSED: TestCase

//===============================================
//    Default test
 //   Tests run: 1, Failures: 0, Skips: 0
//===============================================


//===============================================
//Default suite
//Total tests run: 1, Failures: 0, Skips: 0
//===============================================




