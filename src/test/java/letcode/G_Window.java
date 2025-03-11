package letcode;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class G_Window {

	@Test(priority = 1)
	public void window() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/window");

		String childWindow = null;
		
//		Click on the home button
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent window - " + driver.getTitle());
		driver.findElement(By.id("home")).click();
		Thread.sleep(1000);
		
//		Goto the newly opened tab
		Set<String> windows = driver.getWindowHandles();
		for(String w : windows)
			if(!w.equals(parentWindow))
			{
			driver.switchTo().window(w);
			System.out.println("Child window - " + driver.getTitle());
			childWindow = driver.getWindowHandle();
			}	

//		Print the title of the page
		System.out.println(driver.getTitle());
		
//		Close the parent window
		driver.switchTo().window(parentWindow);
		System.out.println("Closing " + driver.getTitle() + "window");
		driver.close();
		Thread.sleep(1000);
		
//		Close the child window
		driver.switchTo().window(childWindow);
		System.out.println("Closing " + driver.getTitle() + "window");
		driver.close();
	}
	
	@Test(priority = 2)
	public void multipleWIndow() throws InterruptedException {
		
//		Click on the Muiltiple windows button
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/window");
		driver.findElement(By.id("multi")).click();
		Thread.sleep(1000);
		
//		Print all the window title
		Set<String> windows = driver.getWindowHandles();
		for(String w : windows)
		{
			driver.switchTo().window(w);
			System.out.println(driver.getTitle());
		}
		
//		Close all the windows
		driver.quit();
	}
}
