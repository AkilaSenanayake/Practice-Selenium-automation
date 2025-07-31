package seleniumJava.seleniumWaits13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;


public class ExplicitWaits {

    WebDriver driver;

    @BeforeMethod
    public void open() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\akila\\Downloads\\Driver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://leafground.com/waits.xhtml");
    }

    public void Test(){

        //1st way
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']")).click();
//        By newBtnLocator = By.xpath("//button[@id='j_idt87:j_idt90']/span");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(newBtnLocator));
//        String newBtnText = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt90']/span")).getText();
//        System.out.println("New Button is : "+newBtnText);

        //2nd way
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']")).click();
        By newBtnLocator = By.xpath("//button[@id='j_idt87:j_idt90']/span");

        WebElement newBtnElement = wait.until(ExpectedConditions.visibilityOfElementLocated(newBtnLocator));
        String newBtnText = newBtnElement.getText();
        System.out.println("New Button is : "+newBtnText);
    }
}