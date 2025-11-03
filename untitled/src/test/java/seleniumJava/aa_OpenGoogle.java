package seleniumJava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class aa_OpenGoogle {

    @Test
    public void Google(){
            WebDriverManager.chromedriver().setup();  // Auto download correct driver
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com");
    }
}
