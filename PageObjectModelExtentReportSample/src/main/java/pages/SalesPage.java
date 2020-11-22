package pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseMethods;

public class SalesPage extends BaseMethods {
	
	public SalesPage(RemoteWebDriver driver)
	{
		this.driver=driver;
		
	}

	//click account
	public AccountPage clickAccount() throws IOException {
try {
		WebElement element = driver.findElementByXPath("//span[text()='Accounts']");
		driver.executeScript("arguments[0].click();", element);
		reportStep("Account is clicked","pass");
		}
catch(Exception e)
{
	reportStep("Account is not clicked","fail");	
}
return new AccountPage(driver);
}
}