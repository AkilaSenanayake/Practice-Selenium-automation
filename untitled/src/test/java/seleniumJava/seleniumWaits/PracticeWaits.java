package seleniumJava.seleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticeWaits {

    WebDriver driver;

    @BeforeMethod
    public void Link() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\akila\\Downloads\\Driver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    public void Test(){
        WebElement login = driver.findElement(By.name("username"));
        login.click();
        login.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.click();
        password.sendKeys("admin123");

        WebElement logBtn = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        logBtn.click();
    }

}
