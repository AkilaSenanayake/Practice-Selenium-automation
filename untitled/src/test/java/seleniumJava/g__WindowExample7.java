package seleniumJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class g__WindowExample7 {

    WebDriver driver;

    @BeforeMethod
    public void Link() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\akila\\Downloads\\Driver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/window.xhtml");
        Thread.sleep(2000);
    }

    @Test
    public void Testing() throws InterruptedException{

        //01. click and confirm new window open

        String oldWindow = driver.getWindowHandle();
        System.out.println("Parent window : "+oldWindow);

        WebElement openButton = driver.findElement(By.xpath("//button[@id='j_idt88:new']"));
        openButton.click();
        Thread.sleep(2000);

        Set<String> handels = driver.getWindowHandles();
        int handelSize = handels.size();
        System.out.println("handel size : "+handelSize);

        //first method - for each loop
        for (String newWindow : handels){
            System.out.println(newWindow);
            driver.switchTo().window(newWindow);
            System.out.println("Page title is : "+driver.getTitle());

//            String title = driver.getTitle();
//            if (title.equals("Dashboard")){
//                break;
//            }
        }

        driver.close();

        driver.switchTo().window(oldWindow);  //switch again to parent window

        WebElement openButton1 = driver.findElement(By.xpath("//button[@id='j_idt88:new']"));
        boolean openButtonVisibility = openButton1.isDisplayed();
        System.out.println("Open button visibility : "+openButtonVisibility);


        //second method
//        List<String> list = new ArrayList<>(handels); //converting set to the list
//        if (list.size() >1){
//            driver.switchTo().window(list.get(1));
//            System.out.println("Child tab title is : "+driver.getTitle());
//            driver.close();
//        }


        //02. find the number of open tabs
        WebElement multiWindowButton = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt91']"));
        multiWindowButton.click();
        Thread.sleep(2000);

        Set<String> multiWindow= driver.getWindowHandles();
        int howManyWindows = multiWindow.size();
        System.out.println("Number of windows : "+howManyWindows);


        //03. Close all windows except primary
        WebElement closeWindowButton = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt93']"));
        closeWindowButton.click();
        Thread.sleep(2000);

        Set<String> newAddWindows = driver.getWindowHandles();
        for (String allwindows : newAddWindows){
            if (!allwindows.equals(oldWindow)){
                driver.switchTo().window(allwindows);
                driver.close();
            }
        }

        driver.switchTo().window(oldWindow);
        driver.close();

        //or can do using driver.quit()

    }
}
