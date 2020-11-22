package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseMethods;
import pages.AccountPage;
import pages.HomePage;
import pages.SalesPage;
import pages.VerifyAccountEditPage;
import pages.VerifyAccountPage;

public class EditTest extends BaseMethods {
	@BeforeClass
	public void setFile()
	{
		excelName="Edit";
	}

	//dependsOnMethods="testcases.CreateTest.Create")
	@Test(dataProvider="fetchData")
	public void Edit(String Name,String billAdd,String shippAdd,String phone) throws InterruptedException, IOException
	{
		
		HomePage np=new HomePage(driver);
		np.clickToggle().clickViewAll().clickSales();
		SalesPage sp=new SalesPage(driver);
		sp.clickAccount();
		AccountPage ap=new AccountPage(driver);
		ap.searchAccount(Name).clickEdit().enterDetails(billAdd, shippAdd, phone).clickSaveEdit();
		VerifyAccountEditPage vae=new VerifyAccountEditPage(driver);
		vae.verifyEditAccount();
	}
}
