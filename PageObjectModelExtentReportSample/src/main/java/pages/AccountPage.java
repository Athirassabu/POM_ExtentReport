package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseMethods;

public class AccountPage extends BaseMethods {
	
	public AccountPage(RemoteWebDriver driver)
	{
		this.driver=driver;
	}

			//click new
			public AccountPage clickNew() throws IOException {

				try {
					driver.findElementByXPath("//div[@title='New']").click();
					reportStep("New is clicked","pass");
					
				} catch (Exception e) {
					reportStep("New is not clicked","fail");
					
				}
				return this;
			}

			// enter value in text field
			public AccountPage enterName(String Nme) throws IOException {

				try {
					driver.findElementByXPath("//input[@class=' input']").sendKeys(Nme);
					reportStep("Value is entered in text field","pass");
				} catch (Exception e) {
					reportStep("Value is not entered in text field","fail");
				}
				return this;
			}

			// Drop down select public
			public AccountPage dropDownSelect() throws IOException {
				
			    try {
					driver.findElementByXPath("(//a[@class='select'])[3]").click();
					driver.findElementByXPath("//a[@title='Public']").click();
					reportStep("Public is selected from drop down","pass");
				} catch (Exception e) {
					reportStep("Public is not selected from drop down","fail");
				}
			    return this;
			}
			
			//Click save
			public VerifyAccountPage clickSave() throws IOException {

				try {
					driver.findElementByXPath("//button[@title='Save']/span").click();
					reportStep("Save is clicked","pass");
					
				} catch (Exception e) {
					reportStep("Save is not clicked","fail");
				}
				return new VerifyAccountPage(driver);
			}
        
		//Search account
			public AccountPage searchAccount(String Nme) throws InterruptedException, IOException {

				try {
					WebElement search = driver.findElementByXPath("//input[@name='Account-search-input']");
					search.sendKeys(Nme);
					search.sendKeys(Keys.ENTER);
					Thread.sleep(5000);
					reportStep("Account is searched","pass");
				} catch (Exception e) {
					reportStep("Account is not searched","fail");	
				}
				return this;
			}
			
          //click edit
			public AccountPage clickEdit() throws IOException {

				try {
					driver.findElementByXPath("//table[contains(@class,'slds-table forceRecordLayout')]/tbody[1]/tr[1]/td[6]/span[1]/div[1]/a[1]/lightning-icon[1]/lightning-primitive-icon[1]").click();
					System.out.println("drop down clicked");
					driver.findElementByXPath("//a[@title='Edit']").click();
					reportStep("Edit is clicked","pass");
					
				} catch (Exception e) {
					reportStep("Edit is not clicked","fail");
					
				}
				return this;
			}
			//click delete
			public VerifyAccountDelete clickDelete() throws IOException {

				try {
					driver.findElementByXPath("//table[contains(@class,'slds-table forceRecordLayout')]/tbody[1]/tr[1]/td[6]/span[1]/div[1]/a[1]/lightning-icon[1]/lightning-primitive-icon[1]").click();
					driver.findElementByXPath("//a[@title='Delete']").click();
					driver.findElementByXPath("//span[text()='Delete']").click();
					reportStep("Delete is clicked","pass");
				} catch (Exception e) {
					reportStep("Delete is not clicked","fail");
				}
				return new VerifyAccountDelete(driver);
			}
			//fill details
			public AccountPage enterDetails(String  billAdd,String shippAdd,String phone) throws IOException {

				try {
					driver.findElementByXPath("(//a[@class='select'])[2]").click();
					driver.findElementByXPath("//a[@title='Technology Partner']").click();
					driver.findElementByXPath("(//a[@class='select'])[4]").click();
					driver.findElementByXPath("//a[@title='Healthcare']").click();
					driver.findElementByXPath("//textarea[@placeholder='Billing Street']").sendKeys(billAdd);
					driver.findElementByXPath("//textarea[@placeholder='Shipping Street']").sendKeys(shippAdd);
					driver.findElementByXPath("(//a[@class='select'])[5]").click();
					driver.findElementByXPath("//a[@title='Low']").click();
					driver.findElementByXPath("(//a[@class='select'])[6]").click();
					driver.findElementByXPath("//a[@title='Silver']").click();
					driver.findElementByXPath("(//a[@class='select'])[8]").click();
					driver.findElementByXPath("//a[@title='No']").click();
					driver.findElementByXPath(" (//input[@class=' input'])[2]").sendKeys(phone);
					driver.findElementByXPath("(//a[@class='select'])[7]").click();
					driver.findElementByXPath("(//a[@title='No'])[2]").click();
					reportStep("Details filled","pass");
				} catch (Exception e) {
					reportStep("Details is not filled","fail");
				}
				return this;
			}
			//click save
			public VerifyAccountEditPage clickSaveEdit() throws InterruptedException, IOException {
                try {
					Thread.sleep(3000);
					driver.findElementByXPath("//button[@title='Save']/span").click();
					reportStep("Save is clicked","pass");
				} catch (Exception e) {
					reportStep("Save is not clicked","fail");
				}
				return new VerifyAccountEditPage(driver);

			}
		
			
			

}
