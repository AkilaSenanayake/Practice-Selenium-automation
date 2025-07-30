package seleniumJava;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class KeyboardActions_10 {

    WebDriver driver;

    @BeforeMethod
    public void Link() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\akila\\Downloads\\Driver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //Thread not sleep not good with selenium

    @Test
    public void Test() throws InterruptedException {
        driver.get("https://www.google.com/");

        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.click();
        Thread.sleep(1000);

        searchbox.sendKeys("welcome");
        Thread.sleep(1000);

        Actions actions = new Actions(driver);
        Thread.sleep(1000);

        //select the text
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        Thread.sleep(1000);

//        actions.keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).perform();
//        Thread.sleep(1000);

        actions.keyDown(Keys.SHIFT)
                .sendKeys("writing capital sentence")
                .keyUp(Keys.SHIFT)
                .keyDown(Keys.CONTROL).sendKeys("a")
                .keyUp(Keys.CONTROL)
                .keyDown(Keys.CONTROL).sendKeys("x")
                .perform();


        //To write in capital in a text box
//        actions.keyDown(searchbox, Keys.SHIFT)
//                .sendKeys("test capital sentence").perform();

    }

    @Test
    public void Test2() throws InterruptedException {
        driver.get("https://leafground.com/list.xhtml");
        Thread.sleep(3000);

        List<WebElement> selectable = driver.findElements(By.xpath("//ul[@aria-label='From']/li"));
        int size = selectable.size();
        System.out.println("Li count is : "+size);

        Actions actions3 = new Actions(driver);
        actions3.keyDown(Keys.CONTROL)
                .click(selectable.get(0))
                .click(selectable.get(1))
                .click(selectable.get(2))
                .perform();



    }


    @AfterMethod
    public void close(){
        driver.quit();
    }
}
