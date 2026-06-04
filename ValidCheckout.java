package sauseDemo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ValidCheckout {

    public static void main(String[] args) throws InterruptedException, IOException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");

        Thread.sleep(2000);
        File dir = new File(".\\screenshots");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        // Screenshot 1 - Login Page
        File loginPage = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(loginPage, new File("./screenshots/LoginPage.png"));

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(3000);

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        // Screenshot 2 - Products Added
        File productsAdded = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(productsAdded, new File("./screenshots/ProductsAdded.png"));

        driver.findElement(By.className("shopping_cart_link")).click();

        // Screenshot 3 - Cart Page
        File cartPage = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(cartPage, new File("./screenshots/CartPage.png"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlContains("cart"));

        wait.until(
                ExpectedConditions.elementToBeClickable(By.id("checkout")));

        System.out.println("Current URL: " + driver.getCurrentUrl());

        System.out.println("Items Found: "
                + driver.findElements(By.className("inventory_item_name")).size());

        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys("parkavi");
        driver.findElement(By.id("last-name")).sendKeys("S");
        driver.findElement(By.id("postal-code")).sendKeys("630561");

        // Screenshot 4 - Checkout Information
        File checkoutInfo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(checkoutInfo, new File("./screenshots/CheckoutInformation.png"));

        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();

        String successMessage = driver.findElement(By.className("complete-header")).getText();

        Assert.assertEquals(
                successMessage,
                "Thank you for your order!");

        // Screenshot 5 - Order Success
        File orderSuccess = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(orderSuccess, new File("./screenshots/OrderSuccess.png"));

        System.out.println("Order completed successfully");

        driver.quit();
    }
}