package letcode;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T_ShadowDom {

	@Test
	public void selectBirthday() throws InterruptedException, AWTException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/shadow");

		WebElement shadowHost1 = driver.findElement(By.id("open-shadow"));
		SearchContext sc1 = shadowHost1.getShadowRoot();
		WebElement firstName = sc1.findElement(By.cssSelector("#fname"));
		firstName.sendKeys("ABC");
		
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).sendKeys("XYZ").sendKeys(Keys.TAB).sendKeys("pqr@gmail.com").build().perform();
		
		Thread.sleep(5000);
		driver.quit();
		}
	
}
