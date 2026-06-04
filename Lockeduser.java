package sauseDemo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Lockeduser {
	public static void main(String[] args) throws InterruptedException, IOException {
		
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.saucedemo.com");
	Thread.sleep(2000);
	
	driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
	Thread.sleep(2000);
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();
	Thread.sleep(2000);
	 String actualError =
             driver.findElement(
                     By.cssSelector("h3[data-test='error']"))
                     .getText();

     String expectedError =
             "Epic sadface: Sorry, this user has been locked out.";

     Assert.assertEquals(actualError, expectedError);

     System.out.println("Flow 2 Passed");

}
}