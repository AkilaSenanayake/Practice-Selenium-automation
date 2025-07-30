package seleniumJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class DropdownExample4 {

    WebDriver driver;

    @BeforeMethod
    public void BeforeMeth() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\akila\\Downloads\\Driver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void testing1() throws InterruptedException{

        //01. ways of select values in basic dropdown
        driver.get("https://www.leafground.com/select.xhtml");
        WebElement values = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(values);
        select.selectByIndex(1);
        Thread.sleep(2000);
        select.selectByVisibleText("Playwright");
        Thread.sleep(2000);


        //02. Get the number of dropdown options
        List<WebElement> options = select.getOptions();
        int size = options.size();
        System.out.println("Number of elements in dropdown : "+size);

        for (WebElement element : options){
            System.out.println(element.getText());
        }


        //03. using sendkeys select dropdown
        values.sendKeys("Puppeteer");
        Thread.sleep(2000);


        //04. selecting value in a boostrap dropdown
        WebElement dropdown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropdown2.click();
        List<WebElement> Listdropdown = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));

        for(WebElement element : Listdropdown){
            String dropdownvalue = element.getText();
            if (dropdownvalue.equals("USA")){
                element.click();
                break;
            }
        }

        Thread.sleep(2000);

    }



    // part 2 - Google search, pick a value from suggestion


    public void testing2() throws InterruptedException{
        driver.get("https://www.google.com/");
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("iit");
        Thread.sleep(2000);
        List<WebElement> searchList = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@class='lnnVSe']"));
        System.out.println(searchList.size());
        for (WebElement element: searchList){
            String Value = element.getText();
            System.out.println(Value);
            if (Value.equals("IIT City Office")){
                element.click();
                break;
            }
        }


    }
}