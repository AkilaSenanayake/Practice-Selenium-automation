package seleniumJava;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample2 {

    WebDriver driver;

    @BeforeMethod
    public void Link() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\akila\\Downloads\\Driver\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");  //using chromeoptions to open with incognito
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
    }

    @Test
    public void Testing(){
        //01. Type your name
        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Akila Senanayake");

        //02. Append country to this city
        WebElement city = driver.findElement(By.id("j_idt88:j_idt91"));
        city.sendKeys(", India");

        //03. Text box is eneble?
        boolean enabled = driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
        if ( enabled==true ){
            System.out.println("Text box is enabled");
        }else{
            System.out.println("Text box is not enabled");
        }

        //04. Clear the typed text
        WebElement clearText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        clearText.clear();

        //05. Retrieve the type text
        WebElement typeText = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = typeText.getAttribute("value");
        System.out.println("The value include : "+value);

        //06. Type email and Tab. Confirm move to the next element
        WebElement email = driver.findElement(By.id("j_idt88:j_idt99"));
        email.sendKeys("akilasenanayake22@gmail.com"+Keys.TAB + "confirmed control moved to the next element");

        driver.quit();

    }
}