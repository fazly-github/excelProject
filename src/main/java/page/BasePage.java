package page;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	public void selectFromDropDown(WebElement element, String visibileTest) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibileTest);
	}

	public int generateRandomNum(int boundryNum) {
		Random rnd = new Random();
		int generatedNum = rnd.nextInt(boundryNum);
		return generatedNum;
	}
}
