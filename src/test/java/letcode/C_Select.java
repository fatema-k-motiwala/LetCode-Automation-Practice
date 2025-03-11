package letcode;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class C_Select {

	@Test
	public void select() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://letcode.in/dropdowns");

//		Select the apple using visible text
		WebElement fruit = driver.findElement(By.id("fruits"));
		Select select = new Select(fruit);
		select.selectByVisibleText("Apple");

//		Select your super hero's
		WebElement superhero = driver.findElement(By.id("superheros"));
		select = new Select(superhero);
		select.selectByVisibleText("Ant-Man");
		select.selectByVisibleText("Batwoman");

//		Select the last programming language and print all the options
		WebElement lang = driver.findElement(By.id("lang"));
		select = new Select(lang);
		List<WebElement> langlist = select.getOptions();
		int size = langlist.size();
		select.selectByIndex(size - 1);
		for (WebElement language : langlist) {
			System.out.println(language.getText());
		}

//		Select India using value & print the selected value
		WebElement country = driver.findElement(By.id("country"));
		select = new Select(country);
		select.selectByValue("India");

		Thread.sleep(2000);
		
		driver.quit();
	}
}
