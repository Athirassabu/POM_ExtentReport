package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseMethods;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SalesPage;
import pages.VerifyAccountPage;

public class CreateTest extends BaseMethods{
	
	
	@BeforeTest
	public void setFile()
	{
		excelName="create";
		testName = "Create account";
		testDesc="Create an account";
		testAuthor = "Athira";
		testCategory = "Smoke";
		}
	

	
	@Test(dataProvider="fetchData")
	public void Create(String Name) throws InterruptedException, IOException
	{
		
		HomePage np=new HomePage(driver);
		np.clickToggle().clickViewAll().clickSales();
		SalesPage sp=new SalesPage(driver);
		sp.clickAccount();
		AccountPage ap=new AccountPage(driver);
		ap.clickNew().enterName(Name).dropDownSelect().clickSave();
		VerifyAccountPage vp=new VerifyAccountPage(driver);
		vp.verifyCreateAccount(Name);
	}
}
