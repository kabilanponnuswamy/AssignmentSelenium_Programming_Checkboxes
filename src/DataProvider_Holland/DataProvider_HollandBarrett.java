package DataProvider_Holland;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import utility.Reusability;
import utility.util;


public class DataProvider_HollandBarrett {
	WebDriver driver;
	
	@Test(dataProvider = "HollandBarrett")
	public void hollandBarrettDP(String userName, String password) throws Exception
	{
		driver = util.startBrowser("chrome");  
		driver.get("https://auth.hollandandbarrett.com/u/login?");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		//driver.findElement(By.id("captcha")).sendKeys(password);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertTrue(driver.getTitle().contains("Holland"),"User not able to login Successfully - Invalid Credentials");
		}
	
	public void tearDown(ITestResult result)
	{
		if (ITestResult.FAILURE == result.getStatus())
			for (int i=0; i<3; i++)
		{
			System.out.println(result.getName());
			Reusability.capturedSS(driver, result.getName()+i);
		}
		driver.quit();
	}

		@DataProvider(name="HollandBarrett")
		public Object[][] passData()
		{
			Object[][] data = new Object[3][2];
			data[0][0] = "1234567898";
			data[0][1] = "kabil";
			data[1][0] = "1234567888";
			data[1][1] = "kabik";
			data[0][0] = "123456794";
			data[0][1] = "kabii";
			return data;
		}
	
}