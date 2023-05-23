

package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class util {
	WebDriver driver;
	@BeforeTest
	
public static WebDriver startBrowser(String browserName)
{
	WebDriver driver = null;
if (browserName.equalsIgnoreCase("chrome")||browserName.equalsIgnoreCase("google chrome"))
{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\KPONNU\\Desktop\\Dummy\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
}
if (browserName.equalsIgnoreCase("edge")||browserName.equalsIgnoreCase("me"))
{
	System.setProperty("webdriver.edge.driver", "C:\\Users\\KPONNU\\Desktop\\Dummy\\edgedriver_win64\\msedgedriver.exe");
	driver = new EdgeDriver();
}
return driver;

}
	@AfterTest
	public void tearDown() throws Exception
	{
		driver.quit();
	}
}
