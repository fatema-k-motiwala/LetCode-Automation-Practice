package letcode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class K_Sort {

	public static void main(String[] args) throws InterruptedException {
		List<WebElement> firstColumnItems;

		WebDriver driver = new FirefoxDriver();
		driver.get("https://letcode.in/sortable");
		driver.manage().window().maximize();

//      Move the content from to do to done
		int countOfTodo = driver.findElements(By.xpath("//div[@id='cdk-drop-list-0']/div")).size();
		WebElement secondColumn = driver.findElement(By.id("cdk-drop-list-1"));
		Actions actions = new Actions(driver);

		for (int i = 0; i < countOfTodo; i++) {
			Thread.sleep(2000);
			firstColumnItems = driver.findElements(By.xpath("//div[@id='cdk-drop-list-0']/div"));
			actions.dragAndDrop(firstColumnItems.get(0), secondColumn).perform();
		}

		Thread.sleep(5000);

		driver.quit();
	}

}
