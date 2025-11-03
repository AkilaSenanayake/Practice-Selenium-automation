package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParallelMethodTest {

    @Test(priority = 0)
    public void openGoogle(){
        System.out.println("Open Google");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.quit();
    }

    @Test(priority = 1)
    public void OpenBing(){
        System.out.println("OpenBing");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bing.com/");
        driver.quit();
    }
}
