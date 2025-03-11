package letcode;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class F_Radio_Checkbox {

	@Test
	public void radioCheckbox() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/radio");
		
//		Select any one	
		driver.findElement(By.id("yes")).click();
		
//		Confirm you can select only one radio button
		WebElement one = driver.findElement(By.id("one"));
		WebElement two = driver.findElement(By.id("two"));
		two.click();
		one.click();
		if(one.isSelected() && two.isSelected())
			System.out.println("Both Buttons are selected together");
		else if((one.isSelected() && !two.isSelected()))
			System.out.println("Only one is selected");
		two.click();
		if(one.isSelected() && two.isSelected())
			System.out.println("Both Buttons are selected together");
		else if((!one.isSelected() && two.isSelected()))
			System.out.println("Only two is selected");
		
//		Find the bug
		WebElement nobug = driver.findElement(By.id("nobug"));
		WebElement bug = driver.findElement(By.id("bug"));
		bug.click();
		nobug.click();
		if(nobug.isSelected() && bug.isSelected())
			System.out.println("When selecting nobug, bug can also be selected");
		else if((nobug.isSelected() && !bug.isSelected()))
			System.out.println("Only NoBug is selected");
		driver.navigate().refresh();
		nobug = driver.findElement(By.id("nobug"));
		bug = driver.findElement(By.id("bug"));
		nobug.click();
		bug.click();
		if(nobug.isSelected() && bug.isSelected())
			System.out.println("When selecting bug, nobug can also be selected");
		else if((!nobug.isSelected() && bug.isSelected()))
			System.out.println("Only Bug is selected");
		
//		Find which one is selected
		if(driver.findElement(By.id("foo")).isSelected())
			System.out.println("Foo is selected");
		if(driver.findElement(By.id("notfoo")).isSelected())
			System.out.println("Bar is selected");

//		Confirm last field is disabled
		if(driver.findElement(By.xpath("(//input[@name='plan'])[position() = last()]")).isEnabled())
				System.out.println("Last option is enabled");
		else
			System.out.println("Last option is disabled");
		
//		Find if the checkbox is selected?
		if(driver.findElement(By.xpath("(//label[@class='checkbox'])[1]")).isSelected())
			System.out.println("Checkbox is Selected");
		else
			System.out.println("Checkbox is not Selected");
		
//		Accept the T&C
		driver.findElement(By.xpath("(//label[@class='checkbox'])[2]")).sendKeys(Keys.SPACE);
		
		Thread.sleep(5000);
		driver.quit();
		
	}
}
