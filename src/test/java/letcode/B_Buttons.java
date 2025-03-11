package letcode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class B_Buttons {

	@Test
	public void buttons() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://letcode.in/button");

//		Goto Home and come back here using driver commanda
		driver.findElement(By.id("home")).click();
		Thread.sleep(1000);
		driver.navigate().back();

//		Get the X & Y co-ordinates
		Point pt = driver.findElement(By.id("position")).getLocation();
		System.out.println("X : " + pt.x);
		System.out.println("Y : " + pt.y);

//		Find the color of the button
		System.out.println(driver.findElement(By.id("color")).getCssValue("background-color"));

//		Find the height & width of the button
		Dimension sz = driver.findElement(By.id("property")).getSize();
		System.out.println("Height : " + sz.height);
		System.out.println("Width : " + sz.width);
		
//		Confirm button is disabled
		if (driver.findElement(By.xpath("(//button[@id='isDisabled'])[1]")).isEnabled())
			System.out.println("Button is Enabled");
		else
			System.out.println("Button is Disabled");

//		Click and Hold Button
		WebElement button = driver.findElement(By.xpath("(//button[@id='isDisabled'])[2]"));

		System.out.println(button.getText());

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);");

		Actions action = new Actions(driver);
		action.moveToElement(button).clickAndHold(button).pause(Duration.ofSeconds(2)).release().build().perform();

		System.out.println(button.getText());

		driver.quit();
	}
}
