package util;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	static WebDriver driver;
	static String browser;
	static String url;
	public static void readConfig() {
		
		try {
			
			InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
			
			Properties prop = new Properties();
			
			prop.load(input);
			browser = prop.getProperty("browser");
			url = prop.getProperty("url");
			
			
		} catch(IOException e) {
			e.getStackTrace();
		}
		
	}
	
	public static WebDriver init() {

		readConfig();
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		

		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

//		//by using setSize we can set our browser in our choice size we want
//		 // fetching the current window size with getSize()
//	      System.out.println(driver.manage().window().getSize());
//	      //Create object of Dimensions class
//	      Dimension dm = new Dimension(450,630);
//	      //Setting the current window to that dimension
//	      driver.manage().window().setSize(dm);
	}

	public static void tearDown() {

		driver.close();
		driver.quit();
	}

}
