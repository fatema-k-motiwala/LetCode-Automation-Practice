package letcode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class H_Elements {
	@Test
	public void element() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://letcode.in/elements");

//		Type and Enter your Git username
		driver.findElement(By.name("username")).sendKeys("Fatema");
		driver.findElement(By.id("search")).click();

//		Assert that user has image
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement img = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='is-rounded']")));
		Assert.assertTrue(img.isDisplayed());

//		Print the user name & other informations
		String name = driver.findElement(By.xpath("//p[@class='title is-4']")).getText();
		String repoCount = driver.findElement(By.xpath("(//span[@class='tag is-info'])[1]")).getText();		
		String publicGist = driver.findElement(By.xpath("(//span[@class='tag is-info'])[2]")).getText();		
		String followers = driver.findElement(By.xpath("(//span[@class='tag is-info'])[3]")).getText();		
		System.out.println("User Name    : " + name);
		System.out.println("Public Repos : " + repoCount);
		System.out.println("Public Gist  : " + publicGist);
		System.out.println("Followers    : " + followers);
		
//		Assert that no.of public repositories are listed correctly
		int links = driver.findElements(By.xpath("//div[@class='content']//a")).size();
		Assert.assertEquals(Integer.parseInt(repoCount),links);

		driver.quit();
	}
}
