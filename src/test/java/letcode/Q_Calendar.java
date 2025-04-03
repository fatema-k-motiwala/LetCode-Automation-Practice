package letcode;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Q_Calendar {

	@Test
	public void selectBirthday() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/calendar");
		
//	Select your Birthday:
	WebElement date = driver.findElement(By.id("birthday"));
	Actions action = new Actions(driver);
	
	action.click(date).sendKeys("19May").sendKeys(Keys.TAB).sendKeys("1984").build().perform();
			
	}
}
