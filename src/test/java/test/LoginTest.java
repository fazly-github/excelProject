package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	
		WebDriver driver;
		
		ExcelReader exlReader = new ExcelReader("src\\main\\java\\testData\\Book - Copy.xlsx");
		String userName = exlReader.getCellData("LoginInfo", "UserNAme", 2);
		String password = exlReader.getCellData("LoginInfo", "Password", 2);
		String dashboardValidationText = exlReader.getCellData("LoginInfo", "DashboardValidationText", 2);
		
		@Test
		public void validUserShouldBeAbleToLogin() {
			
			driver = BrowserFactory.init();
			LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
			loginPage.enterUserName(userName);
			loginPage.enterPassword(password);
			loginPage.clickSigninButton();
			
			DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPage.verifyDashboardPage(dashboardValidationText);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			BrowserFactory.tearDown();
		}
}
