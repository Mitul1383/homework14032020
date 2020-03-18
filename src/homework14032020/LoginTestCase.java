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

import static java.lang.Thread.sleep;

public class LoginTestCase {
    WebDriver driver;

    @Before
    public void openbrowser() {
        String baseUrl = "https://demo.nopcommerce.com/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void userShouldloginSuccesfully() throws InterruptedException {


        sleep(4000);
        WebElement setloginButton = driver.findElement(By.className("ico-login"));
        setloginButton.click();
        WebElement welcomepage = driver.findElement(By.xpath("//div[@class='page-title']/h1"));
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = welcomepage.getText();
        Assert.assertEquals(actualMessage, expectedMessage);
        WebElement emailfeild = driver.findElement(By.id("Email"));
        Thread.sleep(3000);
        emailfeild.sendKeys("mittulpattel@gmail.com");
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("12345@");
        WebElement tickbox = driver.findElement(By.name("RememberMe"));
        tickbox.click();
        Thread.sleep(3000);
        WebElement registrtion = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        registrtion.click();
        Thread.sleep(3000);
        WebElement myAccount=driver.findElement(By.xpath("//a[@class='ico-account']"));
        Thread.sleep(3000);
        String expectedMsg="My account";
        String actualMsg=myAccount.getText();
        Assert.assertEquals(expectedMsg,actualMsg);
        Thread.sleep(3000);

    }


    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}
















