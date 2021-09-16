package dynamic_dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import base_class.DriverSetup;

public class DynamicDropdown extends DriverSetup {
	@Test
	public void AutoDropdown() throws InterruptedException {
// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();

		driver.get("http://18.209.122.163/admin/login");

		// Login
		driver.findElement(By.name("email")).sendKeys("superadmin@gmail.com");
		driver.findElement(By.name("password")).sendKeys("superadmin");
		driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/form/div[4]/div/button")).click();

		// Catalogue
		driver.findElement(By.xpath("/html/body/div/div/nav/ul/li[3]/a")).click();
		Thread.sleep(2000);

		// Categories
		driver.findElement(By.xpath("/html/body/div/div/nav/ul/li[3]/ul/li[2]/a")).click();
		Thread.sleep(2000);

		// Classification
		driver.findElement(By.xpath("/html/body/div/div/nav/ul/li[3]/ul/li[2]/a")).click();
		Thread.sleep(2000);

		// Products
		driver.findElement(By.xpath("/html/body/div/div/nav/ul/li[3]/ul/li[3]/a")).click();
		Thread.sleep(2000);

		// Add Products
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[1]/div[1]/div/a")).click();
		Thread.sleep(2000);

		// Basic Info
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/form/div[1]/ul/li[1]/a")).click();
		Thread.sleep(2000);

		// Scroll down
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1000);");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"tab_basic-info\"]/div/div[7]/div/div/div[1]/div[1]/div[2]/input"))
				.sendKeys("Desktop");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\\\"tab_basic-info\\\"]/div/div[7]/div/div/div[1]/div[1]/div[2]/input"))
				.sendKeys(Keys.DOWN);
		Thread.sleep(2000);

		System.out.println(driver
				.findElement(By
						.xpath("//*[@id=\\\\\\\"tab_basic-info\\\\\\\"]/div/div[7]/div/div/div[1]/div[1]/div[2]/input"))
				.getText());

//Javascript DOM can extract hidden elements
//because selenium cannot identify hidden elements - (Ajax implementation)
//investigate the properties of object if it have any hidden text

//JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		String script = "return document.getElementById(\"fromPlaceName\").value;";
		String text = (String) js.executeScript(script);
		System.out.println(text);
		int i = 0;
//BENGALURU INTERNATION AIPORT
		while (!text.equalsIgnoreCase("Desktop")) {
			i++;
			driver.findElement(By.xpath(
					"/*[@id=\\\\\\\\\\\\\\\"tab_basic-info\\\\\\\\\\\\\\\"]/div/div[7]/div/div/div[1]/div[1]/div[2]/input"))
					.sendKeys(Keys.DOWN);

			text = (String) js.executeScript(script);
			System.out.println(text);
			if (i > 10) {
				break;
			}

		}

		if (i > 10) {
			System.out.println("Element not found");
		} else {
			System.out.println("Element  found");
		}

	}

}