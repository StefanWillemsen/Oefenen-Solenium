package tests.solenium;

import lib.Browser;
import lib.DriverFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScenarioOne {
    @Test
    public void logIn() {
        WebDriver driver =
                DriverFactory.createDriver(Browser.Chrome);
        driver.get("https://vgp-shop.polteq-testing.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//li[contains(@class,'my-account')]")).click();
        driver.findElement(By.xpath("//input[contains(@id, 'username')]")).sendKeys("tester@polteq-testing.com");
        driver.findElement(By.xpath("//input[@id= 'password']")).sendKeys("1!QazXsw2@");
        driver.findElement(By.xpath("//button[@name= 'login']")).click();
        boolean actual = driver.findElement(By.xpath("//nav[contains(@class, 'MyAccount-navigation')]")).isDisplayed();
        boolean expected = true;
        Assert.assertEquals( expected, actual);
        driver.close();
    }

}
