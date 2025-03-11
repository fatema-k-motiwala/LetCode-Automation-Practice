package letcode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class D_Alert {

	@Test
	public void alert() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://letcode.in/alert");
		
//		Accept the Alert
		driver.findElement(By.id("accept")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();	

//		Dismiss the Alert & print the alert text
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(1000);
		System.out.println(driver.switchTo().alert().getText());	
		driver.switchTo().alert().dismiss();

//		Type your name & accept
		driver.findElement(By.id("prompt")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().sendKeys("Fatema");	
		driver.switchTo().alert().accept();
		
//		Sweet alert
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1000)");
		driver.findElement(By.id("modern")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
	
		Thread.sleep(1000);
		driver.quit();
	}

}
