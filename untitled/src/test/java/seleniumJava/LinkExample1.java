package seleniumJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkExample1 {

    WebDriver driver;

    @BeforeMethod
    public void Link(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\akila\\Downloads\\Driver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }

    @Test
    public void LinkTest(){
        // 01. take me to dashboard
        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();

        // 02. find my destination
        WebElement whereToGo = driver.findElement(By.partialLinkText("Find the URL"));
        String path = whereToGo.getAttribute("href");
        System.out.println("path is : "+path);
        driver.navigate().back();

    }


    @Test
    public void LinkTest2(){
        // 03. Am I broken link
        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();

        String title = driver.getTitle();
        if (title.contains("404")){
            System.out.println("Link is broken!");
        }else{
            System.out.println("Link in not broken!");
        }
        driver.navigate().back();
    }

    @Test
    public void LinkTest3(){
        // 05. Count link
        List<WebElement> count=  driver.findElements(By.tagName("a"));
        int pageLink = count.size();
        System.out.println("page link count : "+pageLink);

        // 06. count layout link
        WebElement layout = driver.findElement(By.className("layout-main-content"));
        List<WebElement> layoutCount = layout.findElements(By.tagName("a"));
        int layCountSize = layoutCount.size();
        System.out.println("count layout links : "+ layCountSize);


        driver.quit();

    }
}
