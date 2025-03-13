package letcode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class L_MultiSelect {
	@Test
	public void selectAll() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/selectable");
		
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//select all
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='container']/div/div"));
		
		for(WebElement item : list)
		{
			js.executeScript("window.scrollBy(0,25);");
			action.moveToElement(item).click().build().perform();
		}

		Thread.sleep(5000);
		driver.quit();
	}
}
