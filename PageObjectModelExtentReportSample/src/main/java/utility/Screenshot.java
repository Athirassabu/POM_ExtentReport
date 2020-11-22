package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.Augmenter;

public class Screenshot {

	public static void captureScreenshot(WebDriver driver, String screenshotName) {

		try {

			//TakesScreenshot ts = (TakesScreenshot) driver;
		//	File source = ts.getScreenshotAs(OutputType.FILE);
		//	FileUtils.copyFile(source, new File("./screenshot/" + screenshotName + ".png"));

			WebDriver augmentedDriver = new Augmenter().augment(driver);
			File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("./screenshot/" + screenshotName + ".png"));
			System.out.println("Screenshot taken");
		} catch (Exception e) {

			System.out.println("Exception while taking screen shot" + e.getMessage());
		}
		
		
	}
}
