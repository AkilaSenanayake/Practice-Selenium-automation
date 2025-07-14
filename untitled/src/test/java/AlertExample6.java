import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertExample6 {

    WebDriver driver;

    @BeforeMethod
    public void preconditions() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\akila\\Downloads\\Driver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");
    }


    @Test
    public void Testing() throws InterruptedException {

        //01. simple alert

        WebElement button1 = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt91']"));
        button1.click();

        Alert alert = driver.switchTo().alert();
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println(e);
        }
        alert.accept();


        //02. Confirm dialog
        WebElement button2 = driver.findElement(By.id("j_idt88:j_idt93"));
        button2.click();

        Alert alert1 = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.dismiss();


        //03.prompt dialog
        WebElement promptButton = driver.findElement(By.id("j_idt88:j_idt104"));
        promptButton.click();

        Alert alert2 = driver.switchTo().alert();
        Thread.sleep(2000);
        String alertText = alert2.getText();
        System.out.println("Alert text is : "+alertText);
        alert2.sendKeys("My name is Akila Senanayake");
        alert2.accept();
    }
}