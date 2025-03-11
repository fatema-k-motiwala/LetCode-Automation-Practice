package letcode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class E_Frame {
	
	@Test
	public void frame() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://letcode.in/frame");
		
		//Entering first name
		driver.switchTo().frame("firstFr");
		driver.findElement(By.name("fname")).sendKeys("Fatema");
		
		//Entering last name
		driver.findElement(By.name("lname")).sendKeys("Motiwala");
		
		//Entering email
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='innerframe']")));
		driver.findElement(By.name("email")).sendKeys("fkpearl@gmail.com");
		
		Thread.sleep(3000);
		
		driver.quit();
		
	}

}
