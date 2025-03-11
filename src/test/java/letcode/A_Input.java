package letcode;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class A_Input {

	@Test
	public void input() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/edit");

//		Enter your full Name
		driver.findElement(By.id("fullName")).sendKeys("Fatema Motiwala");
		
//		Append a text and press keyboard tab
		driver.findElement(By.id("join")).sendKeys(Keys.END, "Hi", Keys.TAB);

//		What is inside the text box
		String getText = driver.findElement(By.id("getMe")).getDomAttribute("value");
		System.out.println(getText);
		
//		Clear the text
		driver.findElement(By.id("clearMe")).clear();

//		Confirm edit field is disabled
		if (driver.findElement(By.id("noEdit")).isEnabled())
			System.out.println("Field is Enabled");
		else
			System.out.println("Field is Disabled");

//		Confirm text is readonly
		if (driver.findElement(By.id("dontwrite")).getDomAttribute("readonly") != null)
			System.out.println("Field is readonly");

		driver.quit();

	}

}
