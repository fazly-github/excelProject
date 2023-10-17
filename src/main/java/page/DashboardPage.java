package page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	// Elemnt List
	@FindBy(how = How.XPATH, using = "//h2[text()=' Dashboard ']") WebElement DASHBOARD_HEADER_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/a") WebElement CUSTOMERS_MENU_FIELD;
	@FindBy(how = How.XPATH, using = "//a[text()='Add Customer']") WebElement ADD_CUSTOMER_FIELD;
	@FindBy(how = How.XPATH, using = "//a[text()='List Customers']") WebElement LIST_CUSTOMER_FIELD;
	
	public void verifyDashboardPage(String dashboardText) {
		Assert.assertEquals(DASHBOARD_HEADER_FIELD.getText(), dashboardText, "wrong Page!");
	}

	public void clickOnCustomer() throws InterruptedException {
		Thread.sleep(3000);
		CUSTOMERS_MENU_FIELD.click();
	}

	public void clickOnAddCustomer() {
		ADD_CUSTOMER_FIELD.click();
	}
	
	public void clickOnListCustomer() throws InterruptedException {
		Thread.sleep(2000);
		LIST_CUSTOMER_FIELD.click();
	}
	
	
	

}
