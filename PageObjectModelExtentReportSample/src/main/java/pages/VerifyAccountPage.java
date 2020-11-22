package pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseMethods;
import utility.Screenshot;

public class VerifyAccountPage extends BaseMethods {

	public VerifyAccountPage(RemoteWebDriver driver)
	{
		this.driver=driver;
		
	}

	public VerifyAccountPage verifyCreateAccount(String name) throws InterruptedException, IOException {

		try {
			Thread.sleep(3000);
			WebElement element1 = driver
					.findElementByXPath("//span[@class='toastMessage slds-text-heading--small forceActionsText']");
			String displayedValue = element1.getText();
			System.out.println(displayedValue);
			if (displayedValue.contains(name)) {

				System.out.println("Created account is same as displayed");
			} else
				System.out.println("Fail fail fail:Created account name is not same as displayed");
			Screenshot.captureScreenshot(driver, "Create account");
			reportStep("Account is verified","pass");
		} catch (Exception e) {
			reportStep("Account is not verified","fail");
		}
		return this;

	}
}
