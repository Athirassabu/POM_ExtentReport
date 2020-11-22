package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseMethods;

public class VerifyAccountEditPage extends BaseMethods {

	public VerifyAccountEditPage(RemoteWebDriver driver) {
		this.driver = driver;
	}

	public VerifyAccountEditPage verifyEditAccount() throws InterruptedException, IOException {

		try {
			WebElement element1 = driver.findElementByXPath("//span[text()='(812) 978-5540']");
			String displayedValue = element1.getText();
			System.out.println(displayedValue);
			if (displayedValue.equals("(812) 978-5540")) {
				System.out.println("Phone number is same as displayed");
			} else
				System.out.println("Fail fail fail:Phone number is not same as displayed");
			reportStep("Account is Edited","pass");
		} catch (Exception e) {
			reportStep("Account is not Edited","fail");
		}
		return this;

	}

}