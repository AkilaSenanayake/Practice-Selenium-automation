package seleniumJava.seleniumWaits13;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class FluentWait {
    WebDriver driver;

    @BeforeMethod
    public void Link() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\akila\\Downloads\\Driver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/waits.xhtml");
    }

    @Test
    public void fluentWaitTest(){

//        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//                .withTimeout(Duration.ofSeconds(30))
//                        .pollingEvery(Duration.ofSeconds(5))
//                                .ignoring(NoSuchElementException)


        driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']")).click();
        String newBtnText = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt90']/span")).getText();
        System.out.println("New Button is : "+newBtnText);
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
