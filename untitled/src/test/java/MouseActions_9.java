
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class MouseActions_9 {

    WebDriver driver;

    @BeforeMethod
    public void Link() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\akila\\Downloads\\Driver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }



    public void Test() throws InterruptedException {
        driver.get("https://leafground.com/drag.xhtml;jsessionid=node0h01qritjvo9ffj3tdiou8hec3130741.node0");

        //Move to element operation
        System.out.println("<< Move to element operation >>");

        Actions actions= new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt37"))).perform();  //build().perform()
        Thread.sleep(2000);

        actions.moveToElement(driver.findElement(By.id("menuform:j_idt38"))).perform();  //build().perform()
        Thread.sleep(2000);

        actions.moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();  //build().perform()


        //drag and drop operation
        System.out.println("<< Drag and Drop operation >>");

        WebElement from = driver.findElement(By.id("form:drag"));
        WebElement to = driver.findElement(By.id("form:drop"));

        //actions.clickAndHold(from).moveToElement(to).release(to).perform(); //first way
        actions.dragAndDrop(from,to).perform();  //second way




        //Slider operation
        System.out.println("<< Slider operation >>");

        WebElement sliderpoint1 = driver.findElement(By.xpath("//div[@id='form:j_idt125']//span[1]"));
        System.out.println("Location of slider point1 before moving : "+sliderpoint1.getLocation());
        Thread.sleep(2000);

        actions.dragAndDropBy(sliderpoint1,50,0).perform();
        System.out.println("Location of slider point1 after moving : "+sliderpoint1.getLocation());



    }


    @Test
    public void Test2() throws InterruptedException{
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        WebElement rightClickButtonElement = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

        Actions actions1 = new Actions(driver);
        actions1.contextClick(rightClickButtonElement).perform();

        driver.findElement(By.xpath("//span[text()='Edit']")).click();
        Alert alertpop = driver.switchTo().alert();
        //Thread.sleep(2000);

        System.out.println("Alert shows the text as : "+alertpop.getText());
        alertpop.accept();
    }



    @AfterMethod
    public void close(){
        driver.quit();
    }


}
