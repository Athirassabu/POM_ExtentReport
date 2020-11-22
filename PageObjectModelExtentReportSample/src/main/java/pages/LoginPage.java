package pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import base.BaseMethods;

public class LoginPage extends BaseMethods {
	public LoginPage(RemoteWebDriver driver)
	{
		this.driver=driver;
	}
	//@Test
	//actionElement
	/*
	 * public LoginPage enterUserName(String userName) {
	 * 
	 * driver.findElementById("username").sendKeys(userName); return this;
	 * 
	 * } //action enter public LoginPage enterPassword(String Password) {
	 * 
	 * driver.findElementById("password").sendKeys(Password); return this;
	 * 
	 * }
	 */
	 
	 public LoginPage enterUserName() {
			
			driver.findElementById("username").sendKeys("hari.radhakrishnan@testleaf.com");
			return this;
			
		}
		//action enter
		 public LoginPage enterPassword() {
				
				driver.findElementById("password").sendKeys("India$123");
				return this;
				
			}
		//action click
	 public HomePage clickLogin() {
			
		 driver.findElementById("Login").click();
		 
			return new HomePage(driver);
			
		}
		

}
