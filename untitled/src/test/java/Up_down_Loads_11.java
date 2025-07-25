import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class Up_down_Loads_11 {

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
    public void uploadTest1() throws AWTException, InterruptedException {

        //C:\\Users\\akila\\Downloads\\TestLeaf Logo.png
        //1st way - Using Robot Class

        WebElement uploadBtn = driver.findElement(By.id("j_idt88:j_idt89"));
        uploadBtn.click();

        //windows control begin here

        String data = "C:\\Users\\akila\\Downloads\\TestLeaf Logo.png";
        StringSelection selection = new StringSelection(data);

        //coping path to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(3000);  //Thread is use only to see the automation when practice

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }


    @Test
    public void uploadTest2(){

        //2nd way - Using send keys (Applicable only element type is file)

        String data = "C:\\Users\\akila\\Downloads\\TestLeaf Logo.png";
        WebElement uploadUsingSendKeys = driver.findElement(By.id("j_idt88:j_idt89_input"));
        uploadUsingSendKeys.sendKeys(data);
    }




    @AfterMethod
    public void close(){
        driver.quit();
    }
}














