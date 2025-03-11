package letcode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class I_Drag {
	
	@Test
	public void drag() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://letcode.in/draggable");

//		Drag the box around
		WebElement box = driver.findElement(By.id("header"));
		Actions actions = new Actions(driver);		
		actions.dragAndDropBy(box,50,90).perform();
		
	}
}
