import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample3 {

    WebDriver driver;

    @BeforeMethod
    public void preconditions() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\akila\\Downloads\\Driver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        Dimension newSize = new Dimension(800,600);
        driver.manage().window().setSize(newSize);
        driver.get("https://www.leafground.com/button.xhtml");
    }

    @Test
    public void testing1(){

        //01. click and confirm title
        WebElement button1 = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']"));
        button1.click();
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("Actual Title same as expected");
        }else{
            System.out.println("Actual Title not same as expected");
        }
        //Assert.assertEquals(actualTitle,expectedTitle,"Title missmatched");
        driver.navigate().back();

        //02. Find the position of submit button
        WebElement getPosition = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt94']"));
        Point xyPoint = getPosition.getLocation();
        int x = xyPoint.getX();
        int y = xyPoint.getY();
        System.out.println("x Position is : "+x+" and y Position is : "+y);

        //03. Find the save button color
        WebElement buttonColor = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt96']"));
        String color = buttonColor.getCssValue("background-color");
        System.out.println("Button color is : "+color);

        //04. Find the height and width of this button
        WebElement size = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt98']"));
        int height = size.getSize().getHeight();
        int width = size.getSize().getWidth();
        System.out.println("Height is : "+height+" and Width is : "+width);
    }
}