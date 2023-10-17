 package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
	
	WebDriver driver;
	
	ExcelReader exlRead = new ExcelReader("src\\main\\java\\testData\\Book - Copy.xlsx");
	String userName = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "Password", 2);
	String dashboardValidationText = exlRead.getCellData("LoginInfo", "DashboardValidationText", 2);
	String addContactValidationText = exlRead.getCellData("AddContactInfo", "AddContactText", 2);
	String fullName = exlRead.getCellData("AddContactInfo", "FullName", 2);
	String company = exlRead.getCellData("AddContactInfo", "CompanyName", 2);
	String email = exlRead.getCellData("AddContactInfo", "Email", 2);
	String phone = exlRead.getCellData("AddContactInfo", "Phone", 2);
	String country = exlRead.getCellData("AddContactInfo", "Country", 2);
	String address = exlRead.getCellData("AddContactInfo", "Address", 2);	
	String city = exlRead.getCellData("AddContactInfo", "City", 2);
	String state = exlRead.getCellData("AddContactInfo", "State", 2);
	String zip = exlRead.getCellData("AddContactInfo", "Zip", 2);
	
	
	@Test
	public void validCustomerShouldBeAbleToCreateCustomer() throws InterruptedException {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.clickSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dashboardPage.verifyDashboardPage(dashboardValidationText);
		dashboardPage.clickOnCustomer();
		dashboardPage.clickOnAddCustomer();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);

		addCustomerPage.verifyAddCustomerPage(addContactValidationText);
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompany(company);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.selectCountry(country);
		addCustomerPage.clickOnSaveButtom();
		
		dashboardPage.clickOnListCustomer();
		
		addCustomerPage.validatedAndDeleteAddedNameOnListCustomer();
		
		//BrowserFactory.tearDown();
		
	}
}
