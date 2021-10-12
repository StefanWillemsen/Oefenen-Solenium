package tests.solenium;

import lib.Browser;
import lib.DriverFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class NavigationTest {

    @Test
    public void navigateBackAndForward(){
        WebDriver driver =
                DriverFactory.createDriver(Browser.Chrome);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://vgp-shop.polteq-testing.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//li[contains(@class,'contact-us')]")).click();
        driver.navigate().back();
        driver.navigate().forward();
        driver.close();

    }
}
