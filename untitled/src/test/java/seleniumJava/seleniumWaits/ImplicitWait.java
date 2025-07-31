package seleniumJava.seleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class ImplicitWait {

    WebDriver driver;

    @BeforeMethod
    public void Link() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\akila\\Downloads\\Driver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

        //add implicit timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //don't give exceptions before 10 sec

        driver.manage().window().maximize();

        //add page.timeout
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));  //best practice is 10 or more sec
        driver.get("https://leafground.com/waits.xhtml");
    }

    @Test
    public void implicitWaitTest(){

        driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']")).click();

        String newBtnText = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt90']/span")).getText();
        System.out.println("New Button is : "+newBtnText);
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }

}

