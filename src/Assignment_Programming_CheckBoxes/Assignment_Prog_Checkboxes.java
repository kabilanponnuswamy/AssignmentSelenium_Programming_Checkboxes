package Assignment_Programming_CheckBoxes;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;


public class Assignment_Prog_Checkboxes {
	
	@Test
public void testCheckBoxBtn() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KPONNU\\Desktop\\Dummy\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("file:///C:/Users/KPONNU/Desktop/Dummy/html/prog.html");
		
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println(checkboxes.size());
		List<WebElement> radiobtns = driver.findElements(By.xpath("//input[@type='radio']"));
		System.out.println(radiobtns.size());
		
		for (int i=0; i<checkboxes.size(); i++)
		{
			if (checkboxes.get(i).isSelected())
			{
				checkboxes.get(i).click();
				System.out.println(i+" checbox is cleared");
				checkboxes.get(i).click();
				System.out.println(i+" checbox is selected");					
			}
			else
			{
			 checkboxes.get(i).click();
			 System.out.println(i+" checbox is selected");
			}	
		}		
		for (int j=0; j<radiobtns.size(); j++)
		{
			radiobtns.get(j).click();
			 System.out.println(j+" radiobtn is selected");				
		}			
	}
}