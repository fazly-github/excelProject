package page;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//h5[text()='Add Contact']")
	WebElement ADD_CONTACT_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='cid']")
	WebElement COMPANY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']")
	WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='country']")
	WebElement COUNTRY_ELEMENT;
	
	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	WebElement ADDRESS_ELEMENT;
	
	@FindBy(how = How.XPATH, using = "//input[@id='city']")
	WebElement CITY_ELEMENT;
	
	@FindBy(how = How.XPATH, using = "//input[@id='state']")
	WebElement STATE_ELEMENT;
	
	@FindBy(how = How.XPATH, using = "//input[@id='zip']")
	WebElement ZIP_ELEMENT;
	
	@FindBy(how = How.XPATH, using = "//button[@id='submit']")
	WebElement SAVE_BUTTON_ELEMENT;

	public void verifyAddCustomerPage(String addCustomerHeaderText) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ADD_CONTACT_HEADER_ELEMENT));
		Assert.assertEquals(ADD_CONTACT_HEADER_ELEMENT.getText(), addCustomerHeaderText, "Wrong Page!");
	}
	
	String insertedName;
	
	public void insertFullName(String fullName) {
		insertedName = fullName + generateRandomNum(9999); 
		FULL_NAME_ELEMENT.sendKeys(insertedName);
	}

	public void selectCompany(String company) {
		selectFromDropDown(COMPANY_ELEMENT, company);
	}

	public void insertEmail(String email) {
		EMAIL_ELEMENT.sendKeys(generateRandomNum(999) + email);
	}

	public void insertPhone(String phoneNum) {
		PHONE_ELEMENT.sendKeys(phoneNum + generateRandomNum(999));
	}
	
	public void insertAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);
	}
	
	public void insertCity(String city) {
		CITY_ELEMENT.sendKeys(city);
	}
	
	public void insertState(String state) {
		STATE_ELEMENT.sendKeys(state);
	}
	
	public void insertZip(String zip) {
		ZIP_ELEMENT.sendKeys(zip);
	}
	

	public void selectCountry(String country) {
		selectFromDropDown(COUNTRY_ELEMENT, country);
	}
	
	public void clickOnSaveButtom() {
		SAVE_BUTTON_ELEMENT.click();
	}
	
	//tbody/tr[1]/td[3]
		//tbody/tr[2]/td[3]
		//tbody/tr[3]/td[3]
	//tbody/tr[i]/td[3]
	//tbody/tr[1]/td[7]/a[2] (Delete Button)
		
		String begining_xpath = "//tbody/tr[";
		String after_xpath = "]/td[3]";
		String after_xpath_delete = "]/td[7]/a[2]";
			
		public void validatedAndDeleteAddedNameOnListCustomer () throws InterruptedException {
			
			for (int i =1; i<=10; i++) {
			//	driver.findElement(By.xpath("//tbody/tr[i]/td[3]"));
				String nameOnList = driver.findElement(By.xpath(begining_xpath + i +  after_xpath)).getText();
				System.out.println(nameOnList);
//			 	Assert.assertEquals(nameOnList, insertedName ,"Name does not exist" );
				
				if(nameOnList.contains(insertedName)) {
					System.out.println("Entered name exsit");
					Thread.sleep(2000);
					driver.findElement(By.xpath(begining_xpath + i + after_xpath_delete)).click();
					break;
				}
				
			} 
			 
		}
	
	

}
