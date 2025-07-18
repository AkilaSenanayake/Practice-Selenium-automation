import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class Up_down_Load_11 {

    WebDriver driver;

    @BeforeMethod
    public void Link() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\akila\\Downloads\\Driver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/file.xhtml");
        Thread.sleep(2000);
    }

    @Test
    public void downloadTest() throws InterruptedException {
        WebElement downloadButton = driver.findElement(By.id("j_idt93:j_idt95"));
        downloadButton.click();
        Thread.sleep(3000);

        File file = new File("C:\\Users\\akila\\Downloads");
        File[] totalFiles = file.listFiles();
        for (File findfile :totalFiles){
            if (findfile.getName().equals("TestLeaf Logo.png")){
                System.out.println("File is downloaded.");
                break;
            }
        }
    }

    @Test
    public void uploadTest(){

    }
}
