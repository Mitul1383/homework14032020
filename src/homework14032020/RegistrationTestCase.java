package homework14032020;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegistrationTestCase {

    WebDriver driver;

    @Before
    public void openBrowser() {
        String baseUrl = "https://demo.nopcommerce.com/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        Thread.sleep(3000);
        WebElement findRegisterPage = driver.findElement(By.xpath("//a[@class='ico-register']"));
        findRegisterPage.click();

        WebElement welcomeMessage = driver.findElement(By.xpath("//div[@class='fieldset']//strong[text()='Your Personal Details']"));
        String expectedMessage = "Your Personal Details";
        String actualMessage = welcomeMessage.getText();
        System.out.println(welcomeMessage.getText());
        Assert.assertEquals(expectedMessage, actualMessage);


    }

    @Test
    public void userShouldRegisterSuccesfully() throws InterruptedException {
        WebElement registerLink = driver.findElement(By.className("ico-register"));
        registerLink.click();
        WebElement genderMale = driver.findElement(By.id("gender-male"));
        genderMale.click();
        Thread.sleep(3000);
        WebElement firstName = driver.findElement(By.name("FirstName"));
        firstName.sendKeys("mitul");
        WebElement lastName = driver.findElement(By.name("LastName"));
        lastName.sendKeys("patel");
        WebElement date = driver.findElement(By.name("DateOfBirthDay"));
        date.sendKeys("12");
        WebElement month = driver.findElement(By.name("DateOfBirthMonth"));
        month.sendKeys("july");
        WebElement year = driver.findElement(By.name("DateOfBirthYear"));
        year.sendKeys("1983");
        WebElement email = driver.findElement(By.xpath("//input[@data-val-required='Email is required.']"));
        email.sendKeys("mittulpattel+3@gmail.com");
        WebElement companyName = driver.findElement(By.id("Company"));
        companyName.sendKeys("jignesh engineering company");
        WebElement newsletter = driver.findElement(By.name("Newsletter"));
        newsletter.click();
        Thread.sleep(4000);
        WebElement password = driver.findElement(By.name("Password"));
        password.sendKeys("12345@");
        WebElement coinfirm = driver.findElement(By.id("ConfirmPassword"));
        coinfirm.sendKeys("12345@");
        WebElement register = driver.findElement(By.id("register-button"));
        register.click();
        WebElement registration = driver.findElement(By.xpath("//div[@class='result']"));
        String expectedMessage = "Your registration completed";
        String actualMessage = registration.getText();
        Assert.assertEquals(expectedMessage, actualMessage);


    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }


}



