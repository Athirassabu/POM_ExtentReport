package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseMethods;
import utility.Screenshot;


public class HomePage extends BaseMethods {
	
	public HomePage(RemoteWebDriver driver)
	{
		this.driver=driver;
		
	}

	
	// Click toggle
	public HomePage clickToggle() throws IOException {
		
		try {
			driver.findElementByClassName("slds-icon-waffle").click();

			reportStep("Toggle is clicked","pass");
			
		} catch (Exception e) {
			
			reportStep("Toggle is not clicked","fail");
		}
		return this;
	}

	// click view all
	public HomePage clickViewAll() throws IOException {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='slds-button']")));
			driver.findElementByXPath("//button[@class='slds-button']").click();
			Screenshot.captureScreenshot(driver, "View all");
			reportStep("View All is clicked","pass");
			
		} catch (Exception e) {
			reportStep("View All is not clicked","fail");
		}
		return this;
}

	// action click
	public SalesPage clickSales() throws IOException {
		try 
		{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Sales']")));
		driver.findElementByXPath("//p[text()='Sales']").click();
		reportStep("Sales is clicked","pass");
		} 
		catch (Exception e)
		{
			reportStep("Sales is not clicked","fail");
		}
		
		return new SalesPage(driver);

	}
}
