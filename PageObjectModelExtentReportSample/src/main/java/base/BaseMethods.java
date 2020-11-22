package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadExcel;



public class BaseMethods  {
	
	
	public RemoteWebDriver driver;
	public String excelName;
	public Properties prop;
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test,node;
	public String testName,testDesc,testAuthor,testCategory;
	
	@BeforeSuite
	public void startReport()
	{
		reporter= new ExtentHtmlReporter("./ExtentReports/result.html");
		//To have history
		reporter.setAppendExisting(true);
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		
	}
	@BeforeClass
	public void testDetails()
	{
		test=extent.createTest(testName,testDesc);
		test.assignAuthor(testAuthor);
		test.assignCategory(testCategory);
		
	}
	
	public long takeSnap() throws IOException{
		long number=(long)Math.floor(Math.random()* 10000000+ 100000000L);
		File source= driver.getScreenshotAs(OutputType.FILE);
		File target=new File("./snapshot/img"+number+".png");
		FileUtils.copyFile(source, target);
		return number;
		
		
	}
	public void reportStep(String msg,String status) throws IOException
	{
		if(status.equalsIgnoreCase("pass"))
		{
			node.pass(msg,MediaEntityBuilder.createScreenCaptureFromPath(".././snapshot/img"+takeSnap()+".png").build());
		}
		else if(status.equalsIgnoreCase("fail"))
		{
			node.fail(msg,MediaEntityBuilder.createScreenCaptureFromPath(".././snapshot/img"+takeSnap()+".png").build());
			throw new RuntimeException();
		}
	}
	@BeforeMethod
	@Parameters({"browser","username","password"})
	public void setup(String browser,String uName,String pwd) throws Exception{
		 node=test.createNode(testName);
		 
		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("Firefox")){
		//create firefox instance
			
			WebDriverManager.firefoxdriver().setup();
			//Browser notification
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(new FirefoxProfile());
			options.addPreference("dom.webnotifications.enabled", false);
			 driver = new FirefoxDriver(options);
			
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("Chrome")){
			// Disable browser notification
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver(options);
		}
		
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys(uName);
		driver.findElementById("password").sendKeys(pwd);
		driver.findElementById("Login").click();
	}
	

	
	  @DataProvider(name="fetchData")
	  public String[][] sendData() throws IOException {
		  return ReadExcel.excelData(excelName);
	  
	  }
	 
	
	
	  @AfterMethod 
	  public void closeBrowser() {
	  
	  driver.quit();
	  
	  }

@AfterSuite
public void endReport(){
	extent.flush();
	
}

	 
}


