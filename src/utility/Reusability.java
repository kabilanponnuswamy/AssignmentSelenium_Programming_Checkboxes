package utility;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.apache.commons.io.*;

public class Reusability {

	public static void capturedSS(WebDriver driver, String screenShotName) {
		// TODO Auto-generated method stub
		try
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File ("./Screenshots1/"+screenShotName+".png"));
			System.out.println("screenshot captured..!!!");
			
		}
		catch (Exception e)
		{
			System.out.println("Issue while taking screenshots..!!!"+e.getMessage());
			}
	}
}
