package letcode;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class R_Forms {

	@Test
	public void selectBirthday() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/forms");
		
		driver.findElement(By.id("firstname")).sendKeys("ABC");
		driver.findElement(By.id("lasttname")).sendKeys("XYZ");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("hi@gmail.com");
		WebElement code = driver.findElement(By.xpath("(//div[@class='select']/select)[1]"));
		Select select = new Select(code);
		select.selectByVisibleText("India (+91)");
		driver.findElement(By.id("Phno")).sendKeys("1234567890");
		driver.findElement(By.id("Addl1")).sendKeys("Street 1");
		driver.findElement(By.id("Addl2")).sendKeys("Street 2");
		driver.findElement(By.id("state")).sendKeys("Maharashtra");
		driver.findElement(By.id("postalcode")).sendKeys("12345");
		WebElement country = driver.findElement(By.xpath("(//div[@class='select']/select)[2]"));
		select = new Select(country);
		select.selectByVisibleText("India");
		Actions action = new Actions(driver);
		driver.findElement(By.id("Date")).sendKeys("20Apr");
		action.sendKeys(Keys.TAB).sendKeys("1984").build().perform();
		driver.findElement(By.xpath("(//label[@class='radio'])[1]")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.quit();
	}
		
}
