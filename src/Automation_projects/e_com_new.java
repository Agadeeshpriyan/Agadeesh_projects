package Automation_projects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class e_com_new {

    private static WebDriver driver;
    private static String baseUrl = "https://www.saucedemo.com/";

    public static void main(String[] args) throws InterruptedException {
        try {
            // Set the path to the ChromeDriver executable
            System.setProperty("webdriver. chrome.driver", "D:\\software testing\\selenium Jars and Drivers\\drivers\\chromedriver.exe");

            // Initialize the ChromeDriver
            driver = new ChromeDriver();

            // Maximize the browser window
            driver.manage().window().maximize();

            // Navigate to the base URL
            driver.get(baseUrl);

            // Initialize WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Log in
            WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("user-name")));
            Thread.sleep(2000);
            WebElement passwordField = driver.findElement(By.id("password"));
            Thread.sleep(2000);
            WebElement loginButton = driver.findElement(By.id("login-button"));

            usernameField.sendKeys("standard_user");
            passwordField.sendKeys("secret_sauce");
            Thread.sleep(2000);
            loginButton.click();

            // Scroll down and add multiple products to the cart
            addMultipleProductsToCart(wait, 5); // Add the first 5 products to the cart

            // Proceed to the cart
            WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("shopping_cart_container")));
            Thread.sleep(2000);
            cartButton.click();

            // Proceed to checkout
            WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout")));
            Thread.sleep(2000);
            checkoutButton.click();

            // Fill in checkout information
            WebElement firstNameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("first-name")));
            WebElement lastNameField = driver.findElement(By.id("last-name"));
            WebElement zipCodeField = driver.findElement(By.id("postal-code"));

            firstNameField.sendKeys("agadeesh");
            Thread.sleep(2000);
            lastNameField.sendKeys("rajalingam");
            Thread.sleep(2000);
            zipCodeField.sendKeys("614801");

            // Continue to next step
            WebElement continueButton = driver.findElement(By.id("continue"));
            Thread.sleep(2000);
            continueButton.click();

            // Finish the order
            WebElement finishButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("finish")));
            Thread.sleep(2000);
            finishButton.click();

            // Verify if we are on the order completion page
            WebElement orderConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-header")));
            if (orderConfirmation.isDisplayed() && orderConfirmation.getText().contains("THANK YOU FOR YOUR ORDER")) {
                System.out.println("Test Passed: Order completed successfully");
            } else {
                System.out.println("Test Failed: Order completion page not displayed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            if (driver != null) {
                Thread.sleep(2000);
                driver.quit();
            }
        }
    }

    private static void addMultipleProductsToCart(WebDriverWait wait, int numberOfProducts) {
        List<WebElement> productButtons = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".inventory_list .btn_inventory"), numberOfProducts - 1));

        for (int i = 0; i < numberOfProducts; i++)
        {
            WebElement productButton = productButtons.get(i);
            scrollByPixel(300); // Scroll down by 300 pixels
            productButton.click();
        }
    }


    private static void scrollByPixel(int pixels)
    {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + pixels + ")");
    }
}

