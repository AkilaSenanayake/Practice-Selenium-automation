package seleniumJava;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBoxExample5 {

    WebDriver driver;

    @BeforeMethod
    public void preconditions() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\akila\\Downloads\\Driver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    public void radioTest() throws InterruptedException{
        driver.get("https://www.leafground.com/radio.xhtml");

        //01. Find the default select radio button

        boolean chromeRadio = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean firefoxRadio = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safariRadio = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edgeRadio = driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if (chromeRadio){
            String chromeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.println("Default select radio button is : "+chromeText);
        }else if (firefoxRadio){
            String firefoxText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            System.out.println("Default select radio button is : "+firefoxText);
        }else if (safariRadio){
            String safariText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.println("Default select radio button is : "+safariText);
        }if (edgeRadio){
            String edgeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
            System.out.println("Default select radio button is : "+edgeText);
        }


        Thread.sleep(2000);


        //02. Select the age group (Only if not selected)
        WebElement myAgeGroup = driver.findElement(By.id("j_idt87:age:0"));
        boolean isChecked = myAgeGroup.isSelected();
        if (!isChecked){
            //myAgeGroup.click();
            driver.findElement(By.xpath("//label[@for='j_idt87:age:0']")).click();
        }
    }

    @Test
    public void checkBoxTest(){
        driver.get("https://www.leafground.com/checkbox.xhtml");

        //01, choose your favourite languages
        List<WebElement> list = driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        for (WebElement element : list){
            if (!(element.getText().equals("Others"))){
                element.click();
            }
        }

        for(int i=1; i<=list.size(); i++){
            boolean status = driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)["+ i +"]")).isSelected();
            System.out.println("Checkbox "+ i +" selected status is : "+status);
        }


    }
}