package letcode;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class S_File {

	@Test
	public void selectBirthday() throws InterruptedException, AWTException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/file");
		
		//Upload a file
		driver.findElement(By.xpath("//span[@class='file-label']")).click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		String path = System.getProperty("user.dir")+"\\src\\resources\\sample.pdf";
		StringSelection stringSelection = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, stringSelection);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);                                 
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);                             
		Thread.sleep(3000);
		
		//Downloading files
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100);");
		driver.findElement(By.id("xls")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("pdf")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("txt")).click();
		Thread.sleep(3000);
		
		driver.quit();
		
	}

}
