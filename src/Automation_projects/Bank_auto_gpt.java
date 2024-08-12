package Automation_projects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bank_auto_gpt {
    public static void main(String[] args) throws InterruptedException {
        // Setting up WebDriver
        System.setProperty("webdriver. chrome.driver","D:\\software testing\\selenium Jars and Drivers\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to Parabank login page
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        // Logging in
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));

        usernameField.sendKeys("john");
        passwordField.sendKeys("demo");
        loginButton.click();
        Thread.sleep(2000); // Wait for page load

        // Transfer Funds
        Thread.sleep(2000);
        driver.findElement(By.linkText("Transfer Funds")).click();
        WebElement amountField = driver.findElement(By.id("amount"));
        WebElement fromAccountField = driver.findElement(By.id("fromAccountId"));
        WebElement toAccountField = driver.findElement(By.id("toAccountId"));
        WebElement transferButton = driver.findElement(By.cssSelector("input[value='Transfer']"));

        amountField.sendKeys("10000");
        fromAccountField.sendKeys("12345");
        toAccountField.sendKeys("67890");
        Thread.sleep(2000);
        transferButton.click();
        Thread.sleep(1000); // Wait for transfer to complete

        // Go back to home
        driver.findElement(By.linkText("Home")).click();

        // Bill Pay
        Thread.sleep(2000);
        driver.findElement(By.linkText("Bill Pay")).click();
        WebElement payeeNameField = driver.findElement(By.name("payee.name"));
        WebElement addressField = driver.findElement(By.name("payee.address.street"));
        // Other fields omitted for brevity

        payeeNameField.sendKeys("John Doe");
        addressField.sendKeys("123 Main St");
        // Fill in other bill pay details
        Thread.sleep(1000); // Wait for payment to complete

        // Go back to home
        driver.findElement(By.linkText("Home")).click();

        // Update Contact Info
        Thread.sleep(2000);
        driver.findElement(By.linkText("Update Contact Info")).click();
        WebElement firstNameField = driver.findElement(By.id("customer.firstName"));
        WebElement lastNameField = driver.findElement(By.id("customer.lastName"));
        // Other fields omitted for brevity

        firstNameField.sendKeys("John");
        lastNameField.sendKeys("Doe");
        // Fill in other contact info fields
        Thread.sleep(1000); // Wait for update to complete

        // Go back to home
        driver.findElement(By.linkText("Home")).click();

        // Request Loan
        Thread.sleep(2000);
        driver.findElement(By.linkText("Request Loan")).click();
        WebElement loanAmountField = driver.findElement(By.id("amount"));
        WebElement downPaymentField = driver.findElement(By.id("downPayment"));
        // Other fields omitted for brevity

        loanAmountField.sendKeys("5000");
        downPaymentField.sendKeys("1000");
        // Fill in other loan request fields
        Thread.sleep(1000); // Wait for loan request to complete

        // Go back to home
        driver.findElement(By.linkText("Home")).click();

        // Logout
        Thread.sleep(2000);
        driver.findElement(By.linkText("Log Out")).click();

        // Close the browser
        Thread.sleep(2000);
        driver.quit();
    }
}
