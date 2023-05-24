package FBDataDrivenUsingCSV;
import java.io.FileReader;
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
import au.com.bytecode.opencsv.*;

public class FB_DDT_CSV {
	String CsvPath = "C:\\Users\\KPONNU\\Desktop\\Dummy\\fbcsvfile.csv";
	WebDriver driver;
	
	@BeforeTest
	public void setUp() throws Exception{
		driver = util.startBrowser("chrome");  
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
	}
	@Test
	public void testDPCSV() throws Exception
	{
		CSVReader reader = new CSVReader(new FileReader(CsvPath));
		String[] csvCell;
		while((csvCell = reader.readNext())!=null)
		{
			String FName = csvCell[0];
			String LName = csvCell[1];
			String Email1 = csvCell[2];
			String Email2 = csvCell[3];
			String Pass = csvCell[4];
			String Date = csvCell[5];
			String Month = csvCell[6];
			String Year = csvCell[7];
			String Info = csvCell[8];
			
			driver.findElement(By.xpath("//*[text()='Create new account']")).click();
			Thread.sleep(5000);
			driver.findElement(By.name("firstname")).sendKeys(FName);
			driver.findElement(By.name("lastname")).sendKeys(LName);
			driver.findElement(By.name("reg_email__")).sendKeys(Email1);
			Thread.sleep(3000);
			driver.findElement(By.name("reg_email_confirmation__")).sendKeys(Email2);
			driver.findElement(By.name("reg_passwd__")).sendKeys(Pass);
			
			WebElement dobdate = driver.findElement(By.name("birthday_day"));
			Select date_dd = new Select (dobdate);
			date_dd.selectByVisibleText(Date);
			WebElement dobmonth = driver.findElement(By.name("birthday_month"));
			Select month_dd = new Select (dobmonth);
			month_dd.selectByVisibleText(Month);
			WebElement dobyear = driver.findElement(By.name("birthday_year"));
			Select year_dd = new Select (dobyear);
			year_dd.selectByVisibleText(Year);
			driver.findElement(By.xpath("//label[text()='Male']")).click();
			
Thread.sleep(5000);
driver.findElement(By.name("websubmit")).click();
Thread.sleep(10000);
driver.findElement(By.xpath("//*[text()='" +Info+ "']")).isDisplayed();

		}
		}
	
	public void tearDown(ITestResult result)
	{
		if (ITestResult.SUCCESS == result.getStatus())
		{
			System.out.println(result.getName());
			Reusability.capturedSS(driver, result.getName());
		}
		driver.quit();
	}

			
}