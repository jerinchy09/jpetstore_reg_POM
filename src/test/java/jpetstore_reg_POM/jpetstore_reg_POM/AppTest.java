package jpetstore_reg_POM.jpetstore_reg_POM;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Object_repository.Homepage;
import Object_repository.Login;
import Object_repository.MyaccountPage;
import Object_repository.Register;
import utilities.ExcelData;
import utilities.cross_browser;
import utilities.dataProvider;
import utilities.screenshot;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	WebDriver driver;
	String data[];
	ExtentReports report;
	ExtentTest test;
	String url;
	
	@BeforeTest
	//@Parameters("browser")
	public void setup() throws IOException {
		//browser setup
		cross_browser br= new cross_browser();
		this.driver = br.browser_inititate();	
		this.url=driver.getCurrentUrl();
		//extent report setup
		report= new ExtentReports();
		ExtentSparkReporter sparkreport= new ExtentSparkReporter("E:\\Nexvalli\\Eclipse Wrokspace\\jpetstore_reg_POM\\target\\report.html");
		test = report.createTest("User Registration Application");
		report.attachReporter(sparkreport);
		test.log(Status.PASS,"user launched the browser");
	}
	
	@AfterTest
	public void teardown() {
		this.report.flush();
		this.driver.quit();
		test.log(Status.PASS,"user quit the browser url");	
	}

	@Test(dataProvider = "accountInfo", dataProviderClass = dataProvider.class)
	public void valid_application(String fn,String ln,String email,String phn, String add1,String add2,String city,String state,String zip,String country,Method method) throws InterruptedException, IOException {		
		String ex=driver.getCurrentUrl();
	
		Homepage hm = new Homepage(driver);
		hm.sign_in();	
		test.log(Status.PASS,"user clicked on Signed in");
		
		Login lgn = new Login(driver);
		lgn.register();			
		test.log(Status.PASS,"user clicked on Register now");

		//get the data from Excel file		
		Register reg = new Register(driver);
		ExcelData d = new ExcelData();
		data=d.readExcel();
		String user = data[0];
		String pass = data[1];
		String rep_pass = data[2];
		
		//from excel
		reg.valid_reg_userInfo(user,pass,rep_pass);
		test.log(Status.PASS,"User Info passed from Excel");
		
		//from data provider		
		reg.valid_reg_accountInfo(fn,ln,email,phn,add1,add2,city,state,zip,country);		

		//reg.valid_reg_accountInfo(fsn,lsn,em,pn,addr1,addr2,ct,st,zp,cntr);		
		test.log(Status.PASS,"Account Info passed from Data provider");

		reg.valid_reg_profileInfo();
		test.log(Status.PASS,"Profile Info passed from page");
		
		reg.reg_button();
		test.log(Status.PASS,"User clicked on register Button");
		
		//screenshot
		screenshot s = new screenshot();
		s.take_screenshot(driver,method.getName());
		test.log(Status.PASS,"Screenshot Taken");

		Thread.sleep(1000);
		String act = driver.getCurrentUrl();
		
		//the test is not failing at all, It will be shown in the report.html
		try {
			Assert.assertEquals(act, url);
			test.log(Status.PASS,"Registration passed");
		}
		catch(AssertionError e) {
			//Assert.assertTrue(true, url);	
			System.out.println(e.getMessage());
			test.log(Status.FAIL,"Registration Failed. Error Page shown");			
		}	
	}
	
	@Test( dependsOnMethods={"valid_application"},dataProvider = "Invalid_accountInfo", dataProviderClass = dataProvider.class)
	public void invalid_application(String fn,String ln,String email,String phn, String add1,String add2,String city,String state,String zip,String country, Method method) throws InterruptedException, IOException {		
	
		Homepage hm = new Homepage(driver);
		hm.sign_in();	
		test.log(Status.PASS,"user clicked on Signed in");
		
		Login lgn = new Login(driver);
		lgn.register();			
		test.log(Status.PASS,"user clicked on Register now");

		//get the data from Excel file		
		Register reg = new Register(driver);
		ExcelData d = new ExcelData();
		data=d.readExcel();		String user = data[0];
		String pass = data[1];
		String rep_pass = data[2];
		
		//from excel
		reg.valid_reg_userInfo(user,pass,rep_pass);
		test.log(Status.PASS,"User Info passed from Excel");
		
		//from data provider		
		reg.valid_reg_accountInfo(fn,ln,email,phn,add1,add2,city,state,zip,country);		

		//reg.valid_reg_accountInfo(fsn,lsn,em,pn,addr1,addr2,ct,st,zp,cntr);		
		test.log(Status.PASS,"Account Info passed from Data provider");

		reg.valid_reg_profileInfo();
		test.log(Status.PASS,"Profile Info passed from page");
		
		reg.reg_button();
		test.log(Status.PASS,"User clicked on register Button");
		
		//screenshot
		screenshot s = new screenshot();
		s.take_screenshot(driver,method.getName());
		test.log(Status.PASS,"Screenshot Taken");

		Thread.sleep(1000);
		String act = driver.getCurrentUrl();
		
		//assertion	
		Assert.assertEquals(act, "https://petstore.octoperf.com/actions/Account.action", "Assertion failed: Actual and Expected values are not equal");
		test.log(Status.FAIL,"Invalid Registration.Error Page shown");			
		
	}
}
