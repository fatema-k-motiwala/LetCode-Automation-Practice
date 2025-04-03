package letcode;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class O_Tables {

	int total = 0;

	@Test
	public void handlingTable() throws InterruptedException, AWTException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/table");

//		Add all the prices and check if the total is correct
		List<WebElement> price = driver.findElements(By.xpath("//table[@id='shopping']/tbody//td[2]"));
		for (WebElement p : price) {
			total = total + Integer.parseInt(p.getText());
		}
		Assert.assertEquals(total,
				Integer.parseInt(driver.findElement(By.xpath("//table[@id='shopping']/tfoot//td[2]")).getText()));

//		Mark Raj as present
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250);");
		WebElement tick = driver.findElement(By.xpath("//table[@id='simpletable']/tbody/tr[2]/td[4]/input"));
		tick.click();
		Assert.assertTrue(tick.isSelected());
		
//		Check if the sorting is working properly
	
		//sorting is not working on website, checking with Koushik
		
				
//		driver.quit();

	}
}
