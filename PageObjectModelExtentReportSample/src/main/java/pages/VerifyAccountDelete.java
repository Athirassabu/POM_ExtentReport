package pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseMethods;

public class VerifyAccountDelete extends BaseMethods {

	public VerifyAccountDelete(RemoteWebDriver driver) {
		this.driver = driver;
	}

	public VerifyAccountDelete verifyDeleteAccount(String name) throws InterruptedException, IOException {

		try {
			WebElement search = driver.findElementByXPath("//input[@name='Account-search-input']");
			search.sendKeys(name,Keys.ENTER);
			Thread.sleep(5000);
			WebElement element1 = driver.findElementByXPath("//p[text()='No items to display.']");
			String displayedValue = element1.getText();
			if (displayedValue.equals("No items to display.")) {
				System.out.println("The account is deleted");
			} else
				System.out.println("Fail fail fail:Account not deleted");
			reportStep("Account is Deleted","pass");
		} catch (Exception e) {
			reportStep("Account is not Deleted","fail");
		}

		return this;
	}
	
}
