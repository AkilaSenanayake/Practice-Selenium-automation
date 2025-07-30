package seleniumJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class FrameExample8 {

    WebDriver driver;

    @BeforeMethod
    public void preconditions() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\akila\\Downloads\\Driver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/frame.xhtml");
    }

    @Test
    public void frameTest() throws InterruptedException{

        //click me (inside frame)

        WebElement frame2 = driver.findElement(By.xpath("//iframe[@src='default.xhtml']"));
        driver.switchTo().frame(frame2);

        WebElement button1 = driver.findElement(By.xpath("//button[@id='Click']"));
        button1.click();

        String afterClickButtonText = button1.getText();
        System.out.println("Inside frame text after button click : "+afterClickButtonText);



        Thread.sleep(2000);
        //click me (inside nested frame)

        driver.switchTo().defaultContent();  //back to the main html frame

        WebElement frame3 = driver.findElement(By.xpath("//iframe[@src='page.xhtml']"));
        driver.switchTo().frame(frame3);

        WebElement frame4 = driver.findElement(By.xpath("//iframe[@src='framebutton.xhtml']"));
        driver.switchTo().frame(frame4);

        WebElement button3 = driver.findElement(By.xpath("//button[@id='Click']"));
        button3.click();

        String afterClickButtonText2 = button3.getText();
        System.out.println("Nested frame text after button click : "+afterClickButtonText2);



        //How many frames in this page
        driver.switchTo().defaultContent();

        List<WebElement> getIframeTagCount = driver.findElements(By.tagName("iframe"));
        int size = getIframeTagCount.size();
        System.out.println("iframe tag count : "+size);

        for (WebElement iframeElement : getIframeTagCount){
            String frameSrcAttributeValue = iframeElement.getAttribute("src");
            System.out.println("frame src attribute value : "+frameSrcAttributeValue);
        }







        Thread.sleep(3000);
        driver.quit();
    }


    



}