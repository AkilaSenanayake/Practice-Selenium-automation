package seleniumJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class l__BrokenImages_12 {

    WebDriver driver;

    @BeforeMethod
    public void Link() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\akila\\Downloads\\Driver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/broken_images");
    }

    public void Test(){
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='example']/img"));

        // "natural width" = 0 then image is a broken image

        int i = 1;
        for (WebElement image : images){
            if (image.getAttribute("naturalWidth").equals("0")){
                System.out.println("Image "+ i +" is Broken");
            }else{
                System.out.println("Image "+ i +" is not Broken");
            }
            i++;
        }
    }
}