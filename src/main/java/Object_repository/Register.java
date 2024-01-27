package Object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Register {
	WebDriver driver;
	
	//User information
	By username = By.name("username");
	By password = By.name("password");
	By repeat_password = By.name("repeatedPassword");
	
	//Account Information
	By firstname = By.name("account.firstName");
	By lastname = By.name("account.lastName");
	By email = By.name("account.email");
	By phone = By.name("account.phone");
	By address1 = By.name("account.address1");
	By address2 = By.name("account.address2");
	By city = By.name("account.city");
	By state = By.name("account.state");
	By zip = By.name("account.zip");
	By country = By.name("account.country");
	
	//Profile Information
	By lang = By.name("account.languagePreference");
	By category = By.name("account.favouriteCategoryId");
	By enable_myList= By.name("account.listOption");
	By enable_myBanner= By.name("account.bannerOption");
	
	//Save info Button
	By save_button = By.name("newAccount");
	
	public Register(WebDriver driver) {
		this.driver = driver;
	}
    //Passing from ExcelData
	public void valid_reg_userInfo(String user, String pass,String rep_pass) {
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pass);
		driver.findElement(repeat_password).clear();
		driver.findElement(repeat_password).sendKeys(rep_pass);
	}
	//Passing from @DataProvider in App.test
	public void valid_reg_accountInfo(String fn,String ln,String em,String phn, String add1,String add2,String ct,String st,String zp,String cntr) {
	
		driver.findElement(firstname).sendKeys(fn);
		driver.findElement(lastname).sendKeys(ln);
		driver.findElement(email).sendKeys(em);
		driver.findElement(phone).sendKeys(phn);
		driver.findElement(address1).sendKeys(add1);
		driver.findElement(address2).sendKeys(add2);
		driver.findElement(city).sendKeys(ct);
		driver.findElement(state).sendKeys(st);
		driver.findElement(zip).sendKeys(zp);
		driver.findElement(country).sendKeys(cntr);	
	}
	
	public void valid_reg_profileInfo() throws InterruptedException {
		
		WebElement lan = driver.findElement(lang);
		Select se_lan = new Select(lan);			
		se_lan.selectByVisibleText("japanese");	
		
		WebElement cat = driver.findElement(category);
		Select se_cat = new Select(cat);			
		se_cat.selectByVisibleText("BIRDS");	
		
		driver.findElement(enable_myList).click();
		Thread.sleep(1000);
		driver.findElement(enable_myList).click();

		driver.findElement(enable_myBanner).click();
		
	}
	public void reg_button() {
		driver.findElement(save_button).click();

	}
}
