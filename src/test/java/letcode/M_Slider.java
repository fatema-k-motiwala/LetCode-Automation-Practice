package letcode;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class M_Slider {

	@Test
	public void slider() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/slider");

//		Move the slider between 1 to 50
		WebElement slider = driver.findElement(By.xpath("//input[@id='generate']"));
		Random random = new Random();
		int randomNumber = random.nextInt(612 - 111 + 1) + 111;
		Actions actions = new Actions(driver);
		actions.clickAndHold(slider).moveToLocation(randomNumber, 274).release().perform();

//		Click on the get countries button
		WebElement countries = driver.findElement(By.xpath("//button[@class='button is-primary']"));
		countries.click();				
		
//		Validate that countries are generated based on slider values
		String[] list = driver.findElement(By.xpath("//div[@class='card-content']//p")).getText().split("-");
		String limit = driver.findElement(By.xpath("//div[@class='card']//h1")).getText().split(":")[1].trim();
		
		Assert.assertEquals(list.length, Integer.parseInt(limit));
		
		Thread.sleep(5000);
		driver.quit();
	}

}
